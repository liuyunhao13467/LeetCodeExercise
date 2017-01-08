public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int old = n;
		    int result = 0;
        //我的思路是将n转化为long类型即可
        //在Java中没有无符号整数，int类型用32位表示，且最高位是符号位，上下界为：2147483647和-2147483468
        //因此，一旦输入2147483468（10000000000000000000000000000000）等越界的数之后，系统会只识别符号位之后的数
        //虽然系统的检查规则如上所述，但是在内存中的存储方式却也是不变的（如上所述）
        //我们只需让系统在识别的时候将符号位也算上就行了
        //办法之一就是将输入的int转化为long，因为这样就可以扩充长度，使系统在识别的时候将原数字中的符号位也识别上
        long m = Integer.toUnsignedLong(n);
        if(m == 0){
            result = 0;
        }else{//n不等于0和1的时候
            for(; m/2 != 0;){
        		    if(m % 2 == 1){
        			      result++;
        		    }
        		    m = m / 2;
        	  }
        	  if(m == 1){
        		    result++;
        	  }
        }
    	  return result;
    }
}
