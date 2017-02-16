package com;

public class Leet_5_Longest_Palindromic_Substring {
	/**
	 * 是对于每个子串的中心（可以是一个字符，或者是两个字符的间隙，
	 * 比如串abc,中心可以是a,b,c,或者是ab的间隙，bc的间隙，例如aba是回文，abba也是回文，这两种情况要分情况考虑）
	 * 往两边同时进 行扫描，直到不是回文串为止。
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
        if (s.isEmpty()||s==null||s.length() == 1)
            return s;
     
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length())
                longest = tmp;
     
            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length())
                longest = tmp;
        }
     
        return longest;
    }
     
    // Given a center, either one letter or two letter, 
    // Find longest palindrome
    public String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);//注意java中substring的用法
    }
}
