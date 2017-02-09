import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet_496_Next_Greater_Element_I {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
    	List<Integer> resultList = new ArrayList<Integer>();
        //为nums建立映射:key->nums[i]; value->position
    	Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
    	for(int i = 0; i < nums.length; ++i){
    		numsMap.put(nums[i], i);
    	}
    	//遍历findNums，为每一个元素查找next greater element
    	for(int i = 0; i < findNums.length; ++i){
    		Integer currentElem = findNums[i];
    		Integer startPosition = numsMap.get(currentElem);
    		//如果findNums中的某个元素在nums中不存在，结果位置为-1
    		if(startPosition == null){
    			resultList.add(-1);
    		}
    		//在对应的位置开始查找next greater element
    		for(int j = startPosition.intValue(); j < nums.length; ++j){
    			//从前往后找，找到的话就把结果放进list，然后跳出循环
    			if(findNums[i] < nums[j]){
    				resultList.add(nums[j]);
    				break;
    			}else{
    				//如果是最后一次循环仍未找到满足条件的元素，将-1放入list
    				if(j + 1 == nums.length){
    					resultList.add(-1);
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
}
