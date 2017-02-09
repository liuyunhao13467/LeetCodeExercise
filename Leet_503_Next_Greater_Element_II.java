import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet_503_Next_Greater_Element_II {
	/**
	 * 自己的思路，这个方法有错，但是可作为一种思路 
   * @param nums
	 * @return
	 */
    public int[] nextGreaterElements(int[] nums) {
    	if(nums.length == 1 || nums == null){
    		int[] rt = new int[1];
    		rt[0] = -1;
    		return rt;
    	}
    	List<Integer> resultList = new ArrayList<Integer>();
        //先建立数组元素到元素位置的映射
    	Map<Integer, Integer> elemToPosition = new HashMap<>();
    	for(int i = 0; i < nums.length; ++i){
    		elemToPosition.put(nums[i], i);
    	}
    	//本题目的输入是一个循环数组，直接开始查找即可
    	for(int num : nums){
    		//先获取当前元素和当前元素所在的位置
    		Integer elem = num;
    		Integer position = elemToPosition.get(elem);
    		//查找符合条件的结果，由于是循环数组，所以查找次数times应该是nums长度减一，而j则代表当前position
    		for(int j = position.intValue(), times = 0; times < nums.length - 1; ++times){
    			//当j为nums的最后一个位置时
    			if(j == nums.length - 1){
    				j = 0;
    				//如果下一个元素满足条件
    				if(nums[j] > elem){
    					resultList.add(nums[j]);
    					break;
    				}else{
    					//如果是最后一次循环
    					if(times == nums.length - 2){
    						resultList.add(-1);
    					}else{
    						//j = j + 1;
    					}
    				}
    			}else{//j不是nums的最后一个位置
    				j = j + 1;
    				//如果下一个元素满足条件
    				if(nums[j] > elem){
    					resultList.add(nums[j]);
    					break;
    				}else{
    					//如果是最后一次循环
    					if(times == nums.length - 2){
    						resultList.add(-1);
    					}else{
    						//j = j + 1;
    					}
    				}
    			}
    		}
    	}
    	//结果转化
    	Integer[] resultTmp = (Integer[])resultList.toArray(new Integer[resultList.size()]);
    	int[] result = new int[resultList.size()];
    	for(int i = 0; i < result.length; ++i){
    		result[i] = resultTmp[i].intValue();
    	}
    	return result;
    }
    
    /**
     * 因为是循环数组，可以将原数组展开成两个数组（拼接两个相同的），而后在新数组中进行查找
     * @param nums
     * @return
     */
    public int[] nextGreaterElements2(int[] nums) {
    	int[] result = new int[nums.length];
        //可以先找出数组中的最大值，在遍历的时候，如果访问到这个最大值的话，那么他的next Greater Element一定不存在
    	int max = Integer.MIN_VALUE;
    	for(int num : nums){
    		max = Math.max(max, num);
    	}
    	//构造循环数组的展开形式，就是把原数组的副本和原件拼接
    	int[] circularArray = new int[nums.length * 2];
    	for(int i = 0; i < nums.length * 2; ++i){
    		circularArray[i] = nums[i % nums.length];
    	}
    	//对nums中的每个元素查找next Greater Element
    	for(int i = 0; i < nums.length; ++i){
    		result[i] = -1;//先将其置为-1，满足一定条件再做修改
    		//如果是数组中最大值，那么他一定没有next Greater Element
    		if(nums[i] == max){
    			continue;
    		}
    		//在扩展数组上进行查找，从当前元素i的下一个开始查找
    		for(int j = i + 1; j < nums.length * 2; ++j){
    			//如果有满足条件的元素出现，就将其加入result中，然后不再进行后面的查找（跳出循环）
    			if(circularArray[j] > nums[i]){
    				result[i] = circularArray[j];
    				break;
    			}
    		}
    	}
    	return result;
    }
}
