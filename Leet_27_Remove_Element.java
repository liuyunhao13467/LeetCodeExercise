package com;

public class Leet_27_Remove_Element {
	/**
	 * 双指针法
	 * 快指针按正常顺序指向每个元素，慢指针正常情况下也按顺序指向每个元素，在当前遍历的元素等于val时慢指针不动
	 * @param nums
	 * @param val
	 * @return
	 */
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        for(i = 0; i < nums.length; ++i){
        	if(val != nums[i]){
        		nums[j] = nums[i];
        		++j;
        	}
        }
        return j;
    }
}
