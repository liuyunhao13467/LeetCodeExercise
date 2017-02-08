public class Leet_204_Count_Primes {
	//此方法超时！
    public int countPrimes(int n) {
        int result = 0;
        for(int i = 2; i < n; ++i){
        	boolean isPrime = true;
        	for(int j = 2; j <= Math.sqrt(i); ++j){
        		if(i % j == 0){
        			isPrime = false;
        		}
        	}
        	if(isPrime){
        		result++;
        	}
        }
        return result;
    }
    
    public int countPrimes2(int n){
    	if (n <= 1)
    		return 0;
    	int[] flag = new int[n];
    	//所有标识位置1
    	for (int i = 2; i < n; i++)
    		flag[i] = 1;
    	//判定素数：2到根号n之间的数都不能整除j
    	for (int i = 2; i <= (int) Math.sqrt(n); i++) {
    		if (flag[i] == 1) {
    			//如果可以整除给标识位设置为0
    			for (int j = i; j * i < n; j++) {
    				flag[j * i] = 0;
    			}
    		}
    	}
    	
    	int count = 0;
    	for (int i = 2; i < n; i++) {
    		if (flag[i] == 1)
    			count++;
    	}
    	
    	return count;
    }
}
