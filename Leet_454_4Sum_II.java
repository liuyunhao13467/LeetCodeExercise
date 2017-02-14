import java.util.HashMap;
import java.util.Map;

public class Leet_454_4Sum_II {
	/**
	 * 这种方法最直观，但是时间开销非常大，在leet中不会通过测试，会超时
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @return
	 */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        for(int i = 0; i < A.length; ++i){
        	for(int j = 0; j < B.length; ++j){
        		for(int k = 0; k < C.length; ++k){
        			for(int l = 0; l < D.length; ++l){
        				if(A[i]+B[j]+C[k]+D[l]==0){
        					result++;
        				}
        			}
        		}
        	}
        }
        return result;
    }
    /**
     * 为了减少时间上的开销，可能的一种思路是：
     * 先求出AB数组中所有和的情况，然后记录每一种元素组合求得的和出现的次数，
     * 得到：组合求和结果到结果出现次数的映射后（即key：a[i]+b[j]，value：frequency(a[i]+b[j])），
     * 求CD两数组中不同的组合的和，在循环求和的过程中与map中的key进行运算，看是否等于零，
     * 等于零即满足条件
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D){
    	int result = 0;
    	//判断合法性
    	if(A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0 || A == null || B == null || C == null || D == null){
    		return result;
    	}
    	//构建映射：key：a[i]+b[j]，value：frequency(a[i]+b[j])
    	Map<Integer, Integer> map = new HashMap<>();
    	//计算AB不同组合的和以及不同的和出现的次数，并将它们存入map中
    	for(int i = 0; i < A.length; ++i){
    		for(int j = 0; j < B.length; ++j){
    			map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0)+1);
    		}
    	}
    	//将map中的结果和CD中的结果相加，判断是否满足条件，并记录满足条件的组合的数量
    	for(int i = 0; i < C.length; ++i){
    		for(int j = 0; j < D.length; ++j){
    			//这里如果再对map进行遍历的话时间复杂度会很高，
    			//由于要满足的条件是A[i]+B[j]+C[k]+D[l]==0，转化一下可得：A[i]+B[j]==-(C[k]+D[l])
    			//因此可以利用-(C[k]+D[l])在map中直接查找，如果存在就说明满足条件
    			result += map.getOrDefault(-C[i]-D[j], 0);
    		}
    	}
    	return result;
    }
}
