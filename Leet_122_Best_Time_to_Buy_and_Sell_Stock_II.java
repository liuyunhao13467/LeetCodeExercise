public class Solution {
    public int maxProfit(int[] prices) {
        //在这个题目中，不限制交易次数，也就意味着：只要赚钱就可以！
		//先判断数组是否为空，为空直接返回零
		if(prices.length == 0)
			return 0;
		int result = 0;//计算结果
		//从1开始遍历
        for(int i = 1; i < prices.length; ++i){
        	if(prices[i] > prices[i-1])
        		result += prices[i] - prices[i-1];
        }
        return result;
    }
}
