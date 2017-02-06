import java.util.HashMap;
import java.util.Map;

public class Leet_217_Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
    	//这个map的key部分存储nums[i]，values部分存储nums中的值出现的次数
    	Map<Integer, Integer> table = new HashMap<Integer, Integer>();
    	int times = 0;
        for(int i = 0; i < nums.length; ++i){
        	//先判断在table中是否存在nums中的当前值
        	if(table.containsKey(nums[i])){
        		//如果存在，则其对应的值要加一
        		table.replace(nums[i], table.get(nums[i]) + 1);
        		//加一过后要判断value是否大于一，如果大于一则返回true
        		if(table.get(nums[i]) > 1){
        			return true;
        		}
        	}else{
        		table.put(nums[i], 1);
        	}
        }
        return false;
    }
}
