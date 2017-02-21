package com;

import java.util.ArrayList;
import java.util.List;

public class Leet_17_Letter_Combinations_of_a_Phone_Number {
	/**
	 * 经典的backtracking（回溯算法）的题目。当一个题目，存在各种满足条件的组合，
	 * 并且需要把它们全部列出来时，就可以考虑backtracking了。当然，backtracking在一定程度上属于穷举，
	 * 所以当数据特别大的时候，不合适。而对于那些题目，可能就需要通过动态规划来完成。
	 * 这道题的思路很简单，假设输入的是"23"，2对应的是"abc"，3对应的是"edf"，那么我们在递归时，
	 * 先确定2对应的其中一个字母（假设是a），然后进入下一层，穷举3对应的所有字母，并组合起来（"ae"，"ad"，"af"），
	 * 当"edf"穷举完后，返回上一层，更新字母b，再重新进入下一层。这个就是backtracing的基本思想。
	 * @param digits
	 * @return
	 */
    public List<String> letterCombinations(String digits) {
    	List<String> result = new ArrayList<>();
    	result.clear();
        //合法性
    	if(digits.isEmpty()){
    		result.add("");
    		return result;
    	}
    	//列出来数字对应的字符
    	String[] map = new String[10];  
        map[0] = "";  
        map[1] = "";  
        map[2] = "abc";  
        map[3] = "def";  
        map[4] = "ghi";  
        map[5] = "jkl";  
        map[6] = "mno";  
        map[7] = "pqrs";  
        map[8] = "tuv";  
        map[9] = "wxyz";
        //从digits的第一个数开始计算
        combineLetter(result, digits, "", 0, map);
        return result;
    }
    
    public void combineLetter(List<String> list, String digits, String curr, int index,String[] table){
    	//递归的退出条件就是以digits的元素遍历完了
    	if(index == digits.length()){
    		if(curr.length() != 0) list.add(curr);
    		return;
    	}
    	//找到数字对应的字符串
    	String tmp = table[digits.charAt(index) - '0'];
    	for(int i = 0; i < tmp.length(); ++i){
    		//遍历数字对应的字符串，然后添加到curr之后
    		String next = curr + tmp.charAt(i);
    		//进入下一层
    		combineLetter(list, digits, next, index + 1, table);
    	}
    }
}
