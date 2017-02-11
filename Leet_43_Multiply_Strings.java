public class Leet_43_Multiply_Strings {
	/**
	 * 自己的算法，有错误
	 * @param num1
	 * @param num2
	 * @return
	 */
    public String multiply(String num1, String num2) {
    	//先建立string builder以便生成结果
    	StringBuilder resultBuilder = new StringBuilder();
    	//先拿到两string的长度
    	int num1Len = num1.length();
    	int num2Len = num2.length();
    	//
    	String thisRes = null;
    	String lastRes = null;
    	for(int i = 0; i < num1Len; ++i){
    		int tmp1 = num1.charAt(num1Len - 1 - i) - '0';
    		int carry = 0;
    		StringBuilder tmp = new StringBuilder();
    		for(int j = 0; j < num2Len; ++j){
    			int tmp2 = num2.charAt(num2Len - 1 - i) - '0';
    			carry += tmp1 * tmp2;
    			tmp.append(carry % 10);
    			carry /= 10;
    		}
    		thisRes = tmp.reverse().toString();
    		if(i != 0){//如果不是第一次
    			thisRes += '0';//左移一位
    			lastRes = addStrings2(thisRes, lastRes);
    		}else{
    			lastRes = tmp.reverse().toString();
    		}
    	}
    	//最后生成结果字符串，注意，刚才构造的string实际上是倒序的，记得转化顺序
    	return lastRes;
    }
    
    public String addStrings2(String num1, String num2) {
    	//先建立string builder以便生成结果
    	StringBuilder resultBuilder = new StringBuilder();
    	//先拿到两string的长度
    	int num1Len = num1.length();
    	int num2Len = num2.length();
    	//设置进位变量
    	int toNext = 0;
    	for(int i = 0; i < num1Len || i < num2Len; ++i){
    		//注意循环条件的写法，事实上应该是从低位（即string的最后一个字符）开始遍历，但是这么写可以简化过程，因此在获取每一个char的时候就要注意方法了
    		//设置两个临时变量表示两字符串的当前访问字符
    		int tmp1 = 0;
    		int tmp2 = 0;
    		//因为两个string的长度可能不同，因此还要判断
    		if(i < num1Len){
    			tmp1 = num1.charAt(num1Len - 1 - i) - '0';//注意写法
    		}
    		if(i < num2Len){
    			tmp2 = num2.charAt(num2Len - 1 - i) - '0';
    		}
    		//计算当前位数的值，注意考虑：前一位的进位，本位的进位
    		resultBuilder.append((tmp1 + tmp2 + toNext) % 10);
    		//计算进位
    		toNext = (tmp1 + tmp2 + toNext) / 10;
    	}
    	//注意不要忘了，最后一次循环中计算出的进位要加上，由于是字符串，因此只有当进位是1的时候才添加（进位不是0就是1，因为每一位计算结果加上前一位的进位最多是9+9+1），否则可能会在首位多出个零导致出错
    	if(toNext == 1)
    		resultBuilder.append(toNext);
    	//最后生成结果字符串，注意，刚才构造的string实际上是倒序的，记得转化顺序
    	return resultBuilder.reverse().toString();
    }
    
    /**
     * 网上大神的算法
     * @param num1
     * @param num2
     * @return
     */
    public String multiply2(String num1, String num2){
    	int m = num1.length(), n = num2.length();
    	int[] pos = new int[m + n];//结果数组，长度一定是m+n或者m+n+1
    	for(int i = m - 1; i >= 0; --i){
    		for(int j = n - 1; j >= 0; --j){
    			int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
    			int p1 = i + j, p2 = i + j +1;//这是算法的重点
    			int sum = mul + pos[p2];
    			
    			pos[p1] += sum / 10;
    			pos[p2] = sum % 10;
    		}
    	}
    	//构造结果字符串
    	StringBuilder sb = new StringBuilder();
    	for(int p : pos){
    		if(!(sb.length() == 0 && p==0)){
    			sb.append(p);
    		}
    	}
    	return sb.length() == 0 ? "0" : sb.toString();
    }
}
