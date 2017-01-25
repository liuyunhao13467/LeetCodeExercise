public class Solution {
    public int[] constructRectangle(int area) {
        //先判断输入值的合法性
		if(area <= 0){
			return null;
		}
		//计算可能的组合
		int W = (int) Math.sqrt(area),L = (int) Math.sqrt(area);
		while(L * W != area){
			if(L * W > area){
				--W;
			}else{
				++L;
			}
		}
		int[] result = new int[2];
		result[0] = L;
		result[1] = W;
		return result;
    }
}
