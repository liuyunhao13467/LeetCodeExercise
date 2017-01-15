public class Solution{
  public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutiveOnes = 0;//每一截1序列中数字1的个数
        int result = 0;//最终结果
        for(int i = 0; i < nums.length; ++i){//遍历数组
        	if(nums[i] == 1){//如果当前数字为1，则说明进入了一个1序列，开始计算这个1序列中数字1的个数
        		maxConsecutiveOnes++;//当前1序列中数字1的个数加一
        		if(maxConsecutiveOnes >= result){//注意，要更新结果
    				result = maxConsecutiveOnes;
    			}
    		}else{//如果当前数字为0，说明已经不在1序列中，那么要比较上一个1序列和result的大小，并更新result
    			if(maxConsecutiveOnes > result){
    				result = maxConsecutiveOnes;
    			}
    			maxConsecutiveOnes = 0;//不在1序列的话，该变量就要清零
    		}
        }
        return result;//上面两段关于result和maxConsecutiveOnes的比较是为了时刻保证result是最大值
    }
}
