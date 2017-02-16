package com;

public class Leet_7_Reverse_Integer {
	/**
	 * 此方法超时
	 * @param x
	 * @return
	 */
    public int reverse(int x) {
    	int head = x/10;  
        int tail = x%10;  
        long re = 0;  
          
        while(head!=0||tail!=0)  
        {  
            re = re*10 + tail;  
            tail = head%10;  
            head = head/10;  
        }  
          
        re = re < Integer.MIN_VALUE? 0:re;  
        re = re > Integer.MAX_VALUE? 0:re;  
          
        return (int)re;  
    }
}
