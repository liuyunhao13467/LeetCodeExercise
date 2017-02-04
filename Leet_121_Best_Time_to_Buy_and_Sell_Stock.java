public class Solution {
    public int maxProfit(int[] prices) {
		//先判断数组是否为空，为空直接返回零
		if(prices.length == 0)
			return 0;
		int low = prices[0];//low变量代表数组中最小的元素
		int result = 0;//计算结果
		//从1开始遍历
        for(int i = 1; i < prices.length; ++i){
        	//先找出到当前元素为止，数组中的最小元素
        	if(prices[i] < low)
        		low = prices[i];
        	else if(prices[i] - low > result)//而后再计算利润，和之前的利润相比较，取大的
        		result = prices[i] - low;
        }
        return result;
    }
}
