package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Leet_20_Valid_Parentheses {
    public boolean isValid(String s) {
    	Map<Character, Character> map = new HashMap<>();
    	map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        char[] str = s.toCharArray();
        for(int i = 0; i < str.length; ++i){
        	char tmp = str[i];
        	if(map.keySet().contains(tmp)){//注意顺序，左括号一定要入栈
        		stack.push(tmp);
        	}else{
        		if(!stack.empty() && map.get(stack.peek()) == tmp){//配对
        			stack.pop();
        		}else{
        			return false;
        		}
        	}
        }
        return stack.empty();
    }
}
