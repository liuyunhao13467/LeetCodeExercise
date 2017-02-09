import java.util.HashMap;
import java.util.Map;

public class Leet_506_Relative_Ranks {
    public String[] findRelativeRanks(int[] nums) {
    	Map<Integer, Integer> orderedElemToPosition = new HashMap<>();//排序后的元素 -> 该元素在原数组中的位置
    	int[] shadowArray = nums.clone();//输入数组的副本，用来构建映射
        //先对数组排序，然后作出排序后元素到该元素在原数组中位置的映射
    	for(int i = 0; i < nums.length; ++i){
    		//找到最大值，将最大值与首元素交换
    		int max = Integer.MIN_VALUE;
    		int position = 0;
    		for(int j = i; j < nums.length; ++j){
    			if(nums[j] > max){
    				max = nums[j];
    				position = j;
    			}
    		}
    		//交换位置：把本次排序中最大的元素和当前元素交换
    		int tmp = nums[i];
    		nums[i] = max;
    		nums[position] = tmp;
    	}
    	//构造映射
    	for(int i = 0; i < nums.length; ++i){
    		for(int j = 0; j < nums.length; ++j){
    			if(nums[i] == shadowArray[j]){
    				orderedElemToPosition.put(nums[i], j);
    			}
    		}
    	}
    	//遍历排序过后的数组，根据map得出结果
    	String[] result = new String[nums.length];
    	for(int i = 0; i < nums.length; ++i){
    		System.out.println(Integer.toString(nums[i])+","+orderedElemToPosition.get(nums[i]));
    		if(i == 0){
    			result[orderedElemToPosition.get(nums[i])] = "Gold Medal";
    		}else if(i == 1){
    			result[orderedElemToPosition.get(nums[i])] = "Silver Medal";
    		}else if(i == 2){
    			result[orderedElemToPosition.get(nums[i])] = "Bronze Medal";
    		}else{
    			result[orderedElemToPosition.get(nums[i])] = Integer.toString(i+1);
    		}
    	}
    	return result;
    }
}
