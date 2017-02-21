package com;

import java.util.Arrays;

public class Leet_16_3Sum_Closest {
    public int threeSumClosest(int[] nums, int target) {
        //先判断数组的合法性
    	if(nums.length < 3 && nums == null){
    		return -1;
    	}
    	//排序，升序
    	Arrays.sort(nums);
    	//开始比较
    	int bestSum = nums[0] + nums[1] + nums[2];//设置bestSum的初始值
    	for(int i = 0; i < nums.length; ++i){
    		//每次对i，i+1和数组最后一个数进行运算
    		int start = i + 1, end = nums.length - 1;
    		while(start < end){//依次运算的条件
    			int sum = nums[start] + nums[end] + nums[i];
    			if(Math.abs(target - bestSum) > Math.abs(target - sum)){
    				bestSum = sum;
    			}
    			if(sum < target){//sum比target小，说明下一个sum要变的大一些
    				start++;
    			}else{
    				end--;
    			}
    		}
    	}
    	return bestSum;
    }
}
