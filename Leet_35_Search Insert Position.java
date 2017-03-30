public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if(nums.length == 0){
        	return 0;
        }
        while(left <= right){
        	int mid = (left + right) / 2; 
        	if(target == nums[mid]){
        		return mid;
        	}else if(target < nums[mid]){
        		right = mid - 1;
        	}else{
        		left = mid + 1;
        	}
        }
        return left;
    }
}
