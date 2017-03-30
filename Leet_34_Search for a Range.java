public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0, right = nums.length-1;
        if(nums.length == 0){
        	res[0] = -1;
        	res[1] = -1;
        	return res;
        }
        if(nums.length == 1){
        	if(nums[0] == target){
        		res[0] = 0;
        		res[1] = 0;
        		return res;
        	}else{
        		res[0] = -1;
            	res[1] = -1;
            	return res;
        	}
        }
        while(left < right){
        	if(target > nums[left]){
        		++left;
        	}
        	if(target < nums[right]){
        		--right;
        	}
        	if(target == nums[left] && target == nums[right]){
        		res[0] = left;
        		res[1] = right;
        		return res;
        	}
        }
        res[0] = -1;
    	res[1] = -1;
        return res;
    }
}
