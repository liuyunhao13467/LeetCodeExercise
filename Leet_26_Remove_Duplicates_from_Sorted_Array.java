package com;

public class Leet_26_Remove_Duplicates_from_Sorted_Array {
	/**
	 * 这道题不是简单的求去重后数组的长度，还要保证用得到的长度能输出去重后的数组，应该就是在原数组中把数组压缩了
	 * 自己的方法只注重求去重后的长度，而没有压缩数组
	 * @param nums
	 * @return
	 */
    public int removeDuplicates(int[] nums) {
    	int res = nums.length;
        for(int i = 0; i < nums.length-1; ++i){
        	if(nums[i] == nums[i+1]){
        		int count = 0, j = i;
        		while(nums[j] == nums[j+1] && j+1 < nums.length){
        			count++;
        			++j;
        		}
        		res = res - count + 1;
        		i = j + 1;
        	}
        }
        return res;
    }
    
    /**
     * 大神做法
     * @param A
     * @return
     */
    public static int removeDuplicatesNaive(int[] A) {
    	if (A.length < 2)
    		return A.length;
     
    	int j = 0;
    	int i = 1;
     
    	while (i < A.length) {
    		if (A[i] == A[j]) {
    			i++;
    		} else {
    			j++;
    			A[j] = A[i];
    			i++;
    		}
    	}
     
    	return j + 1;
    }

}
