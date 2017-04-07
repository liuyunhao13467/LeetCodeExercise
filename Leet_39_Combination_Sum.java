public class Solution {
   List<List<Integer>> result;  
    List<Integer> path;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	result = new ArrayList<>();
    	path = new ArrayList<>();
    	Arrays.sort(candidates);
    	helper(candidates, 0, 0, target);
		return result;
    }
    
    void helper(int[] nums, int pos, int base, int target){
    	//路径和等于目标值
    	if(base == target){
    		result.add(new ArrayList<>(path));
    		return;
    	}
    	//如果当前路径和大于目标值，说明加了最后一个数之前路径和还是小于目标值的，
    	//因此该路径不符合要求，向前回溯一个点，退到倒数第二个路径节点上
    	if(base > target){
    		return;
    	}
    	//如果当前路径和小于目标值，说明当前路径还可以往前走一个，进行尝试
    	for(int i = pos; i < nums.length; ++i){
    		path.add(nums[i]);
    		helper(nums,i,base+nums[i],target);
    		path.remove(path.size()-1);
    	}
    }
}
