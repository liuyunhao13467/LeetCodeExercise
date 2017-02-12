import java.util.ArrayList;
import java.util.List;

public class Leet_102_Binary_Tree_Level_Order_Traversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	//构造二维list
	List<List<Integer>> reslut = new ArrayList<>();
	/**
	 * 递归做法的思路就是从根结点开始，先将本结点的val存入result中对应的地方，然后再递归访问下一层的结点（左右孩子结点）
	 * 最重要的一点是：result中，第一维代表着二叉树的深度，换句话说就是从第0行到第n-1行分别代表着0到n-1的深度，应该将对应的深度的元素值存入正确的行中
	 * @param root
	 * @return
	 */
    public List<List<Integer>> levelOrder(TreeNode root) {
    	builtList(root, 0);
    	return reslut;
    }
    /**
     * 这个函数负责构造结果集
     * @param root
     * @param depth
     */
    public void builtList(TreeNode root, int depth){
    	if(root == null)
    		return;
    	if(reslut.size() == depth){//这里要注意，实际上result最初是一个空的结构，它是在不断递归中不断扩张的，每遍历一个深度扩张一次
    		reslut.add(depth, new ArrayList<>());
    	}
    	//在对应的深度装填元素
    	reslut.get(depth).add(root.val);
    	//递归
    	builtList(root.left, depth + 1);
    	builtList(root.right, depth + 1);
    }
    public int maxDepth(TreeNode root){
    	if(root == null){
    		return 0;
    	}
    	int left_depth = maxDepth(root.left);
    	int right_depth = maxDepth(root.right);
    	return left_depth > right_depth ? left_depth : right_depth;
    }
}
