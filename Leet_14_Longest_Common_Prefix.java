package com;

public class Leet_14_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
        	return "";
        }
        //以第一个string为基准，开始逐个与后面的string做对比
        char[] str = strs[0].toCharArray();
        int min = str.length;
        //遍历strs，逐个对比，因为strs[0]已被作为基准，因此遍历从1开始
        for(int i = 1; i < strs.length; ++i){
        	//当前string
        	char[] tmp = strs[i].toCharArray();
        	//对当前访问的string和str进行逐一字符的对比，找最大前缀公共字串
        	int j = 0;//因为是逐个字符对比，因此这是指向str和tmp对应位置的指针
        	while(j < min && j < tmp.length && tmp[j] == str[j]){//指针不溢出且对应字符都相等则指针可后移
        		j++;
        	}
        	//j最后指向的是最大前缀公共字串的后一位，因而j恰巧就代表的是字串的长度
        	min = j < min ? j : min;//min永远是最小值
        }
        return strs[0].substring(0, min);
    }
}
