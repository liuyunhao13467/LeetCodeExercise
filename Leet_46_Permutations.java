public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(nums == null || nums.length == 0){
        	return result;
        }
        helper(nums, result, path);
        return result;
    }
	public void helper(int[] nums, List<List<Integer>> result, List<Integer> path){
		if(nums.length == path.size()){
			result.add(new ArrayList<>(path));
			return;
		}
		boolean isVisited = false;
		for(int i = 0; i < nums.length; ++i){
			isVisited = find(nums[i], path);
			if(!isVisited){
				path.add(nums[i]);
				helper(nums, result, path);
				path.remove(path.size() - 1);
			}
		}
	}
	public boolean find(int target, List<Integer> path){
		Iterator<Integer> pathIt = path.iterator();
		boolean result = false;
		while(pathIt.hasNext()){
			Integer tmp = pathIt.next();
			if(tmp.intValue() == target){
				result = true;
				break;
			}
		}
		return result;
	}
}
