public class Leet_66_Plus_One {
    public int[] plusOne(int[] digits) {
    	int len = digits.length;
    	int carry = 0;//进位
    	//从后向前访问数组中的元素
        for(int i = 0; i < len; ++i){
        	int currElem = digits[len - i - 1];
        	int tmpRes = 0;
        	//因为只是加一操作，因此在个位的操作是：当前元素+进位+1
        	if(i == 0){
        		tmpRes = currElem + carry + 1;
        	}else{//在除个位以外的其它位上的操作是：当前元素+进位
        		tmpRes = currElem + carry;
        	}
        	digits[len - i - 1] = tmpRes % 10;//结果写回数组
        	carry = tmpRes / 10;//求进位
        }
        //这里需要考虑一种情况，执行加一操作之后，最高位也产生进位，这种情况下如果还使用原数组就会发生溢出（结果的最高位丢失），因此需要新建一个数组
        if(carry != 0){
			int[] result = new int[len + 1];//新数组
			result[0] = carry;//最高位一定是最后产生的进位值
			for(int i = 1, j = 0; i < len+1 && j < len; ++i, ++j){//
				result[i] = digits[j];
			}
			return result;
		}
        //如果最后不产生进位直接返回结果
        return digits;
    }
}
