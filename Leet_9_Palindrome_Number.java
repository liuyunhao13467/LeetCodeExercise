package com;

public class Leet_9_Palindrome_Number {
	/**
	 * 大致思路：找到首尾两个数判断他们是否相等，判断完毕后去掉首尾两数
	 * @param x
	 * @return
	 */
    public boolean isPalindrome(int x) {
        //合法性判断，负数不存在回文数
    	if(x < 0){
    		return false;
    	}
    	//计算输入数字的长度，这里用10的若干次方来表示
    	int len = 1;
    	while(x/len >= 10){
    		len = len * 10;
    	}
    	//计算首尾数字，比较是否相同
    	while(x>0){
    		int start = x / len;
    		int end = x % 10;
    		//只要发现首尾不相同就返回false
    		if(start != end){
    			return false;
    		}else{//如果相同就继续计算首尾数，去除原来的首尾数即可，计算的事情放在下一次循环中进行
    			x = (x % len) / 10;
    			len = len / 100;
    		}
    	}
    	return true;
    }
}
