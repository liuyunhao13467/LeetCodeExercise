public class Solution {
    //先定义树节点类
    public class TreeNode {
		    int val;
		    TreeNode left;
		    TreeNode right;
		    TreeNode(int x) { val = x; }
    }
    //我的思路是递归调用本函数，深度优先遍历这棵树，将sum逐级递减，最后在哪一个leaf节点sum被减到了零，说明路径存在，就返回true，否则返回false
    public boolean hasPathSum(TreeNode root, int sum) {
        boolean isZero = false;
		    if(root != null){
			      if(root.left == null && root.right == null){
				        isZero = sum - root.val == 0;
				        return isZero;
			      }
			      return (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));
		    }else{//空节点的情况直接返回false即可
            isZero = false;
		    }
		    return isZero;
    }
}
