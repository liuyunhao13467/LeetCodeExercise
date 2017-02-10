import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet_350_Intersection_of_Two_Arrays_II {
    public int[] intersect(int[] nums1, int[] nums2) {
    	//用一个map来表示nums1中元素到它在数组中出现次数的映射
        Map<Integer, Integer> table = new HashMap<>();//注意，hashmap会自动将重复的key去掉
        //构建map
        for(int num : nums1){
        	if(table.containsKey(num) == false){//如果map中不存在当前元素
        		table.put(num, 1);
        	}else{//map中已经存在当前元素，就将该元素出现次数加一，即将该元素在map中对应的value加一
        		table.put(num, table.get(num)+1);
        	}
        }
        //查找交集
        List<Integer> resultList = new ArrayList<>();
        for(int i = 0; i < nums2.length; ++i){
        	//如果nums2的当前元素在map中存在
        	if(table.containsKey(nums2[i])){
        		//如果这个元素对应的在map中的value大于零说明至少有一个当前元素属于交集（结果）
        		if(table.get(nums2[i]) >= 1){
        			resultList.add(nums2[i]);//加入结果集
        			table.put(nums2[i], table.get(nums2[i])-1);//因为已经将一个元素加入结果集，因此要更新map中的value
        		}
        	}
        }
        //list转化为array
        int[] result = new int[resultList.size()];
        for(int i = 0; i < result.length; ++i){
        	result[i] = resultList.get(i);
        }
        return result;
    }
}
