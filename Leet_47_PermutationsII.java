public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        for(int i = 0; i < nums.length; ++i){
        	visited[i] = false;
        }
        Arrays.sort(nums);
        helper(result, path, nums, visited);
        return result;
    }
	public void helper(List<List<Integer>> result, List<Integer> path, int[] nums, boolean[] visited){
		if(path.size() == nums.length){
			result.add(new ArrayList<>(path));
			return;
		}
		for(int i = 0; i < nums.length; ++i){
			if(i != 0 && nums[i] == nums[i-1] && !visited[i-1]){
				continue;
			}
			if(!visited[i]){//nums中第i个元素未被访问过
				visited[i] = true;
				path.add(nums[i]);
				helper(result, path, nums, visited);
				path.remove(path.size()-1);
				visited[i] = false;
			}
		}
	}
}
