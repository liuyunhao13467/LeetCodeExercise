public class Solution {
    public int findComplement(int num) {
        //先判断合法性
		if(num <= 0){
			System.out.println("Error input!");
			return -1;
		}
		//先将正整数转化为二进制
		char[] bits = new char[32];
		int numInUse = num;
		int i = 0;
		for(i = 0; numInUse != 0; ++i){
			if(numInUse % 2 == 0){
				bits[i] = '0';
			}else if(numInUse % 2 == 1){
				bits[i] = '1';
			}
			numInUse = numInUse / 2;
		}
		int effectiveBit = i-1;//记录有效位（0~effectiveBit）
		for(;i < 32; ++i){//填充
			bits[i] = '0';
		}
		//求补数
		int j = 0;
		for(; j <= effectiveBit; ++j){
			//置换
			if(bits[j] == '0'){
				bits[j] = '1';
			}else if(bits[j] == '1'){
				bits[j] = '0';
			}
		}
		//结果转为int
		int result = 0;
		int k = 0;
		for(; k < 31; ++k){
			if(bits[k] == '0'){
				result += 0;
			}else if(bits[k] == '1'){
				result += Math.pow(2, k);
			}
		}
		
		return result;
    }
}
