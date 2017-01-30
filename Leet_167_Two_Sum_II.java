public class Leet_167_Two_Sum_II {
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
        for(int i = 0; i < numbers.length; ++i){
        	int tmp = target - numbers[i];
        	for(int j = 0; j < numbers.length; ++j){
        		if(j != i){
        			if(tmp == numbers[j]){
        				if(i > j){
        					result[0] = j+1;
        					result[1] = i+1;
        				}else{
        					result[0] = i+1;
        					result[1] = j+1;
        				}
        			}
        		}
        	}
        }
        return result;
    }
	
	public int[] twoSum2(int[] numbers, int target) {
		if(numbers == null || numbers.length < 1)
			return null;
		int i = 0, j = numbers.length - 1;
		while(i < j){
			int x = numbers[i] + numbers[j];
			if(x < target){
				++i;
			}else if(x > target){
				--j;
			}else{
				return new int[]{i+1, j+1};
			}
		}
		return null;
	}
}
