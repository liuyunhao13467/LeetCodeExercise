import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leet_18_4Sum {
	/**
	 * 要注意的一点是：结果集中的每一个条目中都不能出现重复的元素，即每个nums中的元素只能出现一次
	 * 主要思路：首先对数组排序，然后先确定四个数当中前两个，再遍历数组剩余部分确定后两个，具体方法是首尾两端左右逼近。最后注意去重
	 * @param nums
	 * @param target
	 * @return
	 */
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	int i, j, start, end;
    	int len = nums.length;
    	List<Integer> triplet = new ArrayList<>();
    	List<List<Integer>> triplets = new ArrayList<>();
    	Set<List<Integer>> setOfTmpResult = new HashSet<>(); 
    	//先排序
    	for(i = 0; i < len; ++i){
    		int min = nums[i];
        	int position = i;
    		for(j = i + 1; j < len; ++j){
    			if(min > nums[j]){
    				min = nums[j];
    				position = j;
    			}
    		}
    		int tmp = nums[i];
    		nums[i] = min;
    		nums[position] = tmp;
    	}
    	for(i=0;i<len;++i){
    		System.out.println(nums[i]);
    	}
    	//左右逼近
    	for(i = 0; i < len - 3; ++i){
    		if(i>0&&nums[i]==nums[i-1])continue;
    		for(j = i + 1; j < len - 2; ++j){
    			start = j + 1;
    			end = len - 1;
    			if(j>i+1&&nums[j]==nums[j-1])continue;
    			while(start < end){
    				int curSum = nums[i] + nums[j] + nums[start] + nums[end];
    				//如果sum和target相等
    				if(curSum == target){
    					triplet.clear();//每次都清空
    					//构造四元组
    					triplet.add(nums[i]);
    					triplet.add(nums[j]);
    					triplet.add(nums[start]);
    					triplet.add(nums[end]);
    					triplets.add(triplet);
    					System.out.println(i+","+j+","+start+","+end);
    					System.out.println(nums[i]+","+nums[j]+","+nums[start]+","+nums[end]);
    					System.out.println(triplet.toString());
    					while(start<end&&nums[end]==nums[start+1])start++;
                        while(start<end&&nums[end]==nums[end-1])end--;
    					//移动游标（逼近）继续比较
    					start++;
    					end--;
    				}else if(curSum > target){//sum大于target则当前值需要减小
    					end--;
    				}else{//sum小于target则当前值需要增大
    					start++;
    				}
    			}
    		}
    	}
    	//利用set去重
//    	Iterator<List<Integer>> it = setOfTmpResult.iterator();
//    	while(it.hasNext()){
//    		List<Integer> tmp = it.next();
//    		triplets.add(tmp);
//    		Iterator<Integer> tmpIt = tmp.iterator();
//    		while(tmpIt.hasNext()){
//    			System.out.println(tmpIt.next().intValue());
//    		}
//    	}
        return triplets;
    }
    
    /**
     * 网上的做法，思路一样，实现略有不同，上面是自己的做法，实现上有错误
     * @param num
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum2(int[] num, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if(num.length<4)return ans;
        Arrays.sort(num);
        for(int i=0; i<num.length-3; i++){
            if(i>0&&num[i]==num[i-1])continue;
            for(int j=i+1; j<num.length-2; j++){
                if(j>i+1&&num[j]==num[j-1])continue;
                int low=j+1, high=num.length-1;
                while(low<high){
                    int sum=num[i]+num[j]+num[low]+num[high];
                    if(sum==target){
                        ans.add(Arrays.asList(num[i], num[j], num[low], num[high]));
                        while(low<high&&num[low]==num[low+1])low++;
                        while(low<high&&num[high]==num[high-1])high--;
                        low++;
                        high--;
                    }
                    else if(sum<target)low++;
                    else high--;
                }
            }
        }
        return ans;
    }
}
