public class Leet_108_Convert_Sorted_Array_to_Binary_Search_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    public TreeNode sortedArrayToBST(int[] nums) {
    	if(nums.length == 0 || nums == null){
    	    return null;
    	}
    	return createTreeNode2(nums, 0, nums.length-1);
    }
    /**
     * 该方法是构建bst的一般思路，但是在这里（java）的实现不正确，而且不适用于本题目
     * @param node
     * @param num
     * @return
     */
    boolean createTreeNode(TreeNode node, int num){
    	//如果是空树（第一次）
    	if(node == null){
    		node = new TreeNode(num);
    		node.left = null;
    		node.right = null;
    		return true;
    	}
    	//不是空树
    	if(num == node.val){//bst中不允许有相等的元素
    		return false;
    	}
    	if(num < node.val){//元素值小于父结点的值
    		return createTreeNode(node.left, num);
    	}
    	//元素值大于父结点的值时
    	return createTreeNode(node.right, num);
    }
    /**
     * 二分法：使用start～i-1构建左子树，使用i+1～end构建右子树，
     * 注意middle值的算法：middle=start+(end-start)/2或者middle=(start+middle)/2
     * @param nums
     * @param start
     * @param end
     * @return
     */
    TreeNode createTreeNode2(int[] nums, int start, int end){
    	if(start > end){
    		return null;
    	}
    	int middle = start + (end - start) / 2;//核心
    	TreeNode node = new TreeNode(nums[middle]);
    	node.left = createTreeNode2(nums, start, middle-1);
    	node.right = createTreeNode2(nums, middle+1, end);
    	return node;
    }
}
