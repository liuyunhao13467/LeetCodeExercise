import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet_15_3Sum {
	/**
	 * 自己的写法，程序实现有误，但思路大体正确
	 * @param nums
	 * @return
	 */
    public List<List<Integer>> threeSumMySelf(int[] nums) {
    	int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        //开始查找：第一层循环定下第一个数，第二层循环中将第二第三个数分别置于i+1和len-1的位置，然后边判断条件边动态调整
        for(int i = 0; i < len - 1; ++i){
        	int start = i + 1;
        	int end = len - 1;
        	//skip same i
        	while(i > 0 && i < len && nums[i] == nums[i - 1]){
        		++i;
        	}
        	while(start < end){
        		int tmpSum = nums[i] + nums[start] + nums[end];
        		//条件判断
        		if(tmpSum == 0){
        			List<Integer> current = new ArrayList<>();
        			current.add(nums[i]);
        			current.add(nums[start]);
        			current.add(nums[end]);
        			result.add(current);
        			start++;
        			end++;
        			//skip same start and end
        			while(start < end && nums[start] == nums[start - 1]){
                		++start;
                	}
        			while(end > start && nums[end] == nums[end + 1]){
                		--end;
                	}
        		}else if(tmpSum < 0){
        			start++;
        			//skip same start
        			while(start < end && nums[start] == nums[start - 1]){
                		++start;
                	}
        		}else{
        			end--;
        			//skip same
        			while(end > start && nums[end] == nums[end + 1]){
                		--end;
                	}
        		}
        	}
        }
        return result;
    }
    
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    /**
     * 大神做法
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        if (nums == null || length < 3)
            return ans;
        Arrays.sort(nums);
        for (int i = 0; i < length - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            findTwoSum(nums, i + 1, length - 1, nums[i]);
        }
        return ans;
    }
 
    public void findTwoSum(int[] num, int begin, int end, int target) {
        while (begin < end) {
            if (num[begin] + num[end] + target == 0) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(target);
                list.add(num[begin]);
                list.add(num[end]);
                ans.add(list);
                while (begin < end && num[begin + 1] == num[begin])
                    begin++;
                begin++;
                while (begin < end && num[end - 1] == num[end])
                    end--;
                end--;
            } else if (num[begin] + num[end] + target > 0)
                end--;
            else
                begin++;
        }
    }

}
