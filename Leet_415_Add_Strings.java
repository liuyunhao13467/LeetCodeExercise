public class Leet_415_Add_Strings {
	/**
	 * 大致思路就是：从低位开始，分别将两个string对应的值相加（注意，要将char值转化为int值）
	 * 主要问题是：1，要注意进位处理；2，两个string的长度可能不同，要注意对多出位的处理
	 * @param num1
	 * @param num2
	 * @return
	 */
    public String addStrings(String num1, String num2) {
    	String result = new String();
    	int resultNum = 0;
    	//针对这两个string，同时从最低位（个位）开始遍历相加，以长度短的为结束基准，再将长的string剩下的数加到结果里
    	//i代表nums1的游标，j代表nums2的游标
    	int times = 0;//表示循环次数，利用这个数来计算个十百千万
    	int toHigherBit = 0;//表示每次计算的进位，单个来看，每一位上的计算不超过9+9（如果算上前一位的进位就再加一）
    	int i = num1.length() - 1, j = num2.length() - 1;
        for(; i >= 0 && j >= 0; --i, --j){
        	resultNum += ((((num1.charAt(i) - '0') + (num2.charAt(j) - '0')) * Math.pow(10, times)) % 10) + toHigherBit;//这里在最后一次计算时如果有进位记得在结束时加上
        	toHigherBit = (int) ((((num1.charAt(i) - '0') + (num2.charAt(j) - '0')) * Math.pow(10, times)) / 10);
        	times++;
        }
        //计算剩下的高位
        if(i == -1){//num2剩余
        	for(;j >= 0;--j){
        		resultNum += (num2.charAt(j) - '0') * Math.pow(10, times) + toHigherBit;
        		toHigherBit = 0;
        		times++;
        	}
        }else if(j == -1){//num1剩余
        	for(;i >= 0;--i){
        		resultNum += (num1.charAt(i) - '0') * Math.pow(10, times) + toHigherBit;
        		toHigherBit = 0;
        		times++;
        	}
        }else{//如果都不剩余，记得将
        	resultNum += toHigherBit;
        }
        //结果数字转string
        result = Integer.toString(resultNum);
        return result;
    }
    
    /**
     * 上述方法是自己的思路，大体思路正确，但是实现上冗杂且有错误
     * 本方法是参考别人的
     * @param num1
     * @param num2
     * @return
     */
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
}
