package com;

public class Leet_28_Implement_strStr {
    public int strStr(String haystack, String needle) {
    	if(needle.isEmpty() || needle == null){
    		return 0;
    	}
    	char[] str = haystack.toCharArray();
    	char[] target = needle.toCharArray();
    	int strLen = str.length;
    	int targetLen = str.length;
        for(int i = 0; i < strLen; ++i){
        	if(str[i] == target[i]){
        		int j = i, count = 0;
        		while(count < targetLen){
        			if(str[j] == target[j]){
        				j++; count++;
        			}else{
        				break;
        			}
        		}
        		if(count == targetLen){
        			return i;
        		}
        	}
        }
        return -1;
    }
    
    public int strStr2(String haystack, String needle) {
    	if(haystack==null || needle==null) return 0;
    	if(needle.length()==0) return 0;
    	for(int i=0;i<haystack.length();i++){
    		//注意这里：当i当前指向的元素后面的字符串长度已经比needle的长度小时，说明后面已经不可能存在needle了，这时为了节省时间应该及时返回-1
    		if(i+needle.length()>haystack.length()) 
    			return -1;
    		int m=i;
    		for(int j=0;j<needle.length();j++){
    			if(needle.charAt(j)==haystack.charAt(m)){
    				if(j==needle.length()-1){
    					return i;
    				}
    				m++;
    			}else{
    				break;
    			}
    		}
    	}
    	return -1;
   }
}
