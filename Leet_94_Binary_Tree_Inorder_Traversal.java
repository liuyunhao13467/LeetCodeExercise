public class Leet_94_Binary_Tree_Inorder_Traversal{
  //由于要在不断地递归过程中向结果集中添加元素，因此结果集要设为静态变量
    public static List<Integer> result = new ArrayList<>();
    /**
     * 这个题其实就是让中根序遍历二叉树，把遍历的结果存入一个List中去
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
    	//这里要注意，在使用list之前要先清空一下，在实例化result之后jvm会给result赋默认值，
    	//如果不进行clear操作，在输入的树为空的时候，我们会返回一个带着默认值的result，而我们预期的是空result，这样就会出错
    	result.clear();
    	//要考虑两种特殊情况：空树和只有一个结点的树
    	if(root == null){
    		return result;
    	}
    	if(root.left == null && root.right == null){
    		result.add(root.val);
    		return result;
    	}
    	//对于正常情况下就中根序遍历构造结果集即可
    	buildInorderTraversal(root);
        return result;
    }
    //中根序遍历函数，递归操作
    public void buildInorderTraversal(TreeNode root){
    	if(root == null){
    		return ;
    	}
    	buildInorderTraversal(root.left);
    	result.add(root.val);
    	buildInorderTraversal(root.right);
    }
    
    /**
     * 再介绍一种利用栈迭代遍历的方法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root){
    	List<Integer> result = new ArrayList<>();
    	TreeNode current = root;
    	Stack<TreeNode> stack = new Stack<>();
    	//第一层循环以栈是否为空和结点指针是否为空来判断
    	while(current != null || !stack.empty()){
    		//第二层循环相当于探针，深度优先遍历做孩子结点，从第一层循环中被访问结点向左深度优先，将访问到的点都存在栈中
    		while(current != null){
    			stack.add(current);
    			current = current.left;
    		}
    		//将所有左子树深度优先遍历完之后，将访问到的元素出栈，加入结果中
    		//同时，也让current指针回退
    		current = stack.pop();
    		result.add(current.val);
    		//重新设置current，转而遍历右子树
    		current = current.right;
    	}
    	return result;
    }
}
