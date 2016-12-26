public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0)
            return res;
        int n = nums.length;
        int[] num = new int[n];
        Arrays.fill(num,-1);
        for(int i = 0;i < n;i++)
            num[nums[i] - 1] = nums[i];
        for(int i = 0;i < n;i++){
            if(num[i] == -1)
                res.add(i + 1);
        }
        return res;
    }
}
