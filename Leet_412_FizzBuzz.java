package com.lyh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
	
	public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<String>();
        for(int i = 1; i <= n; ++i){
        	StringBuilder tmp = new StringBuilder();
            if(i % 3 == 0){
            	tmp.append("Fizz");
            }
            if(i % 5 == 0){
            	tmp.append("Buzz");
            }
            if((i % 3 != 0) && (i % 5 != 0)){
            	tmp.append(Integer.toString(i));
            }
            result.add(tmp.toString());
        }
        return result;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int test = 15;
		Test testObj = new Test();
		List<String> result = testObj.fizzBuzz(test);
		
		Iterator it = result.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
