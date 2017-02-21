package com;

import java.util.ArrayList;
import java.util.List;

public class Leet_22_Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", n, n);
        return res;
    }
    
    public void dfs(List<String> result, String s, int left, int right){
    	if(left > right){
    		return;
    	}
    	if(left == 0 && right == 0){
    		result.add(s);
    		return;
    	}
    	if(left > 0){
    		dfs(result, s+"(", left - 1, right);
    	}
    	if(right > 0){
    		dfs(result, s+")", left, right - 1);
    	}
    }
}
