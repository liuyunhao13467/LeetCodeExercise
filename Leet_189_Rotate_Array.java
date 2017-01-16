public class Solution {
    public void rotate(int[] nums, int k) {
        //先判断k的合法性
		k = k % nums.length;
		if(k == 0 || k > nums.length){
			return;
		}
		//在上面的rotate方法中，时间复杂度很大，这个方法就牺牲空间复杂度来换取时间上的优化，这里创建一个等长的辅助数组
		int[] tmpResult = new int[nums.length];
		//先把要挪的k个数挪到前面，即将要挪的k的数放在辅助数组的最前面
		int j = 0;
		for(int i = nums.length-k; i < nums.length; ++i, j++){
			tmpResult[j] = nums[i];
		}
		//再把不动的那一部分数移到这k个数的后面，即将不动的那一部分数字放在辅助数组中（前k个数的后面）
		for(int i = 0; i < nums.length-k; ++i,++j){
			tmpResult[j] = nums[i];
		}
		//因为返回值是void，因此还要将辅助数组的结果拷贝回nums
		for(int i = 0; i < nums.length; ++i){
			nums[i] = tmpResult[i];
		}
    }
}
