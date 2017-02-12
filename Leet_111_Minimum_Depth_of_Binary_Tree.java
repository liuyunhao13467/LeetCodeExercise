public class Leet_111_Minimum_Depth_of_Binary_Tree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	/**
	 * 三种情况：
	 * 1.root为空，此时返回0
	 * 2.root为单个结点，此时返回1
	 * 3.其他情况，每次递归返回左右子树深度中最小值然后再加一（因为本结点也算一层深度）
	 * @param root
	 * @return
	 */
    public int minDepth(TreeNode root) {
        if(root == null){
        	return 0;
        }else if(root.left == null && root.right == null){
        	return 1;
        }else{
        	int left_depth, right_depth;
        	if(root.left != null){
        		left_depth = minDepth(root.left);
        	}else{
        		left_depth = Integer.MAX_VALUE;
        	}
        	if(root.right != null){
        		right_depth = minDepth(root.right);
        	}else{
        		right_depth = Integer.MAX_VALUE;
        	}
        	return Math.min(left_depth, right_depth) + 1;//记得加一
        }
    }
}
