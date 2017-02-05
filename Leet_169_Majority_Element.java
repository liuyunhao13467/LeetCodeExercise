public class Solution {
    public int majorityElement(int[] nums) {
    	int result = 0;
        for(int i = 0; i < nums.length; ++i){
        	int tmp = nums[i];
        	int times = 0;
        	for(int j = i; j < nums.length; ++j){
        		if(tmp == nums[j]){
        			++times;
        		}
        		if(times-1 >= (nums.length/2)){
        			result = tmp;
        		}
        	}
        }
        return result;
    }
    
    /**
     * 上面的做法是暴力查找，时间复杂度较高。
     * 事实上，因为主元素个数必须大于n/2，那么，主元素只有一个！（这点很关键）
     * 那么，我们只需要找到一对不同的两个数，那么这两个数就不会是主元素。
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
    	int majority = 0;
    	int count = 0;
        for(int i = 0; i < nums.length; ++i){
        	if(count == 0){
        		majority = nums[i];
        		++count;
        	}else{
        		if(majority == nums[i]){
        			++count;
        		}else{
        			--count;
        		}
        		if(count >= nums.length/2){
        			return majority;
        		}
        	}
        }
        return 0;
    }
}
