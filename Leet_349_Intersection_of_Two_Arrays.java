public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //建立一个set存储nums1的信息
        Set<Integer> nums1Set = new HashSet<Integer>();
        //遍历存储
        for(int i = 0; i < nums1.length; ++i){
        	nums1Set.add(new Integer(nums1[i]));
        }
        
        //建立一个set，存储结果
        Set<Integer> resultSet = new HashSet<Integer>();
        for(int i = 0; i < nums2.length; ++i){
        	Iterator<Integer> nums1It = nums1Set.iterator();
        	while(nums1It.hasNext()){
        		if(nums2[i] == nums1It.next().intValue()){
        			resultSet.add(nums2[i]);
        		}
        	}
        }
        //将result set转化为数组
        int[] result = new int[resultSet.size()];
        Iterator<Integer> resultSetIt = resultSet.iterator();
        for(int i = 0; resultSetIt.hasNext() && i < resultSet.size(); ++i){
        	result[i] = resultSetIt.next().intValue();
        }
        return result;
    }
}
