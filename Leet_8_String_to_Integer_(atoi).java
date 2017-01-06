public class Solution {
    public int myAtoi(String str) {
        //判断合法性：本身为空串为非法
        if(str == null){
        	return 0;
        }
        //去掉空格如果为0（本身只有空格）为非法
        str = str.trim();
        if(str.length() == 0){
        	return 0;
        }
        //设立正负符号标记和字符串的索引
        int sign = 1;
        int index = 0;
        long num = 0;
        //先判断符号：若存在符号，要移动索引指针，不存在符号就不管
        if(str.charAt(index) == '+'){
        	//若为正数且带有符号，就移动指针
        	index++;
        }else if(str.charAt(index) == '-'){
        	//若为负数（这样一定带有符号）则移动指针且改变符号标记
        	index++;
        	sign = -1;
        }
        //遍历字符串中的字符
        for(; index < str.length(); ++index){
        	//如果这样则字符非法
        	if(str.charAt(index) < '0' || str.charAt(index) > '9'){
        		break;
        	}
        	num = num * 10 + (str.charAt(index) - '0');
        	if(num > Integer.MAX_VALUE)
        		break;
        }
        //如果值溢出...
        if(num * sign > Integer.MAX_VALUE)
        	return Integer.MAX_VALUE;
        if(num * sign < Integer.MIN_VALUE)
        	return Integer.MIN_VALUE;
        
        return (int) (num * sign);
    }
}
