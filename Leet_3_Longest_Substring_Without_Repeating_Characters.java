package com;

public class Leet_3_Longest_Substring_Without_Repeating_Characters {
	//这实际上源自一种javascript解法
	/**
	 * 从字符串的起始位置开始判断，
	 * 依次向后包含一个字母，
	 * 同时记录当前子字符串的长度，如果找到了重复的字母，
	 * 则找出当前子字符串中重复字母的位置，并从此位置的后面继续找子字符串
	 * @param s
	 * @return
	 */
    public int lengthOfLongestSubstring(String s) {
    	if(s.isEmpty() || s == null){
            return 0;
        }
    	//将变量i定义为当前子字符串的结尾的下一个位置，
    	//比如如果我们当前的子字符串为ab，那么i的位置是c，并判断c是否包含在ab中，如果不包含就将c加进去，并且当前子字符串长度currentLen加1
        int maxLen=1,currentLen=1,len=s.length(),i,repeat;
        for(i=1; i<len; i++){
        	//那么当前子字符串为s.substr(i-currentLen,currentLen)，
        	//i位置字母出现在当前子字符的s.substr(i-currentLen,currentLen).indexOf(s.substr(i,1))上，令这个位置为repeat
            //repeat = s.substring(i-currentLen,currentLen).indexOf(s.substring(i,1));//原js中的语句，在js中subtring的参数含义和java中不一样
        	repeat = s.substring(i-currentLen,i).indexOf(s.substring(i,1+i));
            if(repeat == -1){//如果repeat的值是-1就代表不包含，我们字符串长度加1
                currentLen++;
            }else{//否则我们将当前子字符串的其实位置调到出现重复字母位置的后面，这里改变子字符串长度即可
                currentLen -= repeat;
            }
            if(maxLen<currentLen){//如果当前子字符串长度比最大值maxLen还大，就更新最大值
                maxLen = currentLen;
            }
        }
        return maxLen;
    }
    
    public int lengthOfLongestSubstring2(String s) {
        int[] map = new int[256]; // map from character's ASCII to its last occured index
        
        int j = 0;
        int i = 0;
        int ans = 0;
        for (i = 0; i < s.length(); i++) {
            while (j < s.length() && map[s.charAt(j)]==0) {
                map[s.charAt(j)] = 1;
                ans = Math.max(ans, j-i + 1);
                j ++;
            }
            map[s.charAt(i)] = 0;
        }
        
        return ans;
    }
}
