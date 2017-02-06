import java.util.HashMap;
import java.util.Map;

public class Leet_219_Contains_Duplicate_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //map中key部分代表nums中的元素，value部分表示该元素在数组中的位置
    	Map<Integer, Integer> table = new HashMap<Integer, Integer>();
    	//遍历数组
    	for(int i = 0; i < nums.length; ++i){
    		if(table.containsKey(nums[i])){
    			//如果map已经有过与当前访问元素的记录，那么将其位置与当前元素的位置相比较，看是否满足条件
    			if(Math.abs(i - table.get(nums[i])) <= k){
    				return true;
    			}
    		}
    		//注意，在hashmap中，key的值是不可重复的，如果有相同的值会覆写。
    		//例如数组{1,0,1,1}，第一次写入<1,0>，第二次写入<1,2>，第三次写入<1,3>，map中最后只有第三次写入的
    		//在这个题中，因为i是不断增加的，且对于半径的要求是不大于k，因此可以不考虑map中key重复而导致的覆写问题，
    		//i越来越大，如果这次不出现满足条件的entry，那么等i增加1之后，之前的entry更不可能满足条件，因此覆写不会造成错误
    		table.put(nums[i], i);
    	}
    	return false;
    }
}
