public class Leet_268_Missing_Number {
	/**
	 * 这里要注意的一点是：传入的数组一定是一个缺一个元素的等差数列。
	 * 首先解释为什么一定缺一个元素，这是题目中给定的，题目给出的全集就是一个0～n的等差数列，传入的数组是这个全集的一个子集，本题让求数组中缺失的那个一个元素，因此只缺一个元素
	 * 可以先求出不缺元素的情况下（理想状态）这个子集的和以及实际传入的数组的所有元素的和，再用这个理想状态的和减去实际状态的和，得到的就是缺失的元素
	 * leetcode的test case中似乎传入的都是从零开始的数组（和我预想的任意取n个数不一样），和1～n相比，这种情况实际就是0～n
	 * 传入数组长度为n，那么理想状况下（如果不缺元素）数组的长度为n+1，即0～n共四个元素，那么除去0之后的1～n就有n个元素，根据求1～n的等差数列求和公式：n*(n+1)/2计算即可
	 * @param nums
	 * @return
	 */
	public int missingNumber(int[] nums) {
		int actualSum = 0;//实际状态下数组的和
		for(int num : nums){
			actualSum += num;
		}
		int idealSum = nums.length * (nums.length + 1) / 2;//理论值
		return idealSum - actualSum;
	}
}
