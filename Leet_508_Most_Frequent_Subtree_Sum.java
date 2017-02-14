import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet_508_Most_Frequent_Subtree_Sum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public Map<Integer, Integer> map = new HashMap<>();
	/**
	 * 所谓的subtree sum就是一个结点以及他下方所有结点构成的子树的所有val的和
	 * 每一个结点都有一个subtree sum，这个题就是求所有结点的子树和中最大的那个
	 * 因此，我们应该对树进行深度优先遍历，在这个过程中计算每一个结点的subtree sum
	 * @param root
	 * @return
	 */
    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> result = new ArrayList<>();//结果集
        result.clear();
        dfs(root);
        //先求最大的subtree sum出现次数
        int maxSubtreeSumFrequency = 0;
        for(Integer tmp : map.keySet()){//遍历map中所有的key，即subtree sum值
        	System.out.println("Key: "+tmp+"; Value: "+map.get(tmp));
        	if(map.get(tmp) > maxSubtreeSumFrequency){
        		maxSubtreeSumFrequency = map.get(tmp);
        	}
        }
        System.out.println("maxSubtreeSumFrequency is: "+maxSubtreeSumFrequency);
        //再次遍历map，找到所有出现次数等于maxSubtreeSumFrequency的value
        for(Integer tmp : map.keySet()){
        	if(map.get(tmp).intValue() == maxSubtreeSumFrequency){
        		System.out.println("Key: "+tmp+"; Value: "+map.get(tmp));
        		result.add(tmp);
//        		for(Integer tmpListElem : result){
//        			System.out.println("result: "+tmpListElem.intValue());
//        		}
        	}
        }
        //list转数组
        int[] res = new int[result.size()];
        for(int i = 0; i < result.size(); ++i){
        	System.out.println("result["+i+"]="+result.indexOf(i));
        	//res[i] = result.indexOf(i);//注意这里不能用indexOf方法
        	res[i] = result.get(i);
        }
        return res;
    }
    //深度优先计算每个结点的子树和
    public void dfs(TreeNode root){
    	if(root == null){
    		return;
    	}
    	//计算值
    	if(root.left != null){
    		//递归对左孩子进行计算
    		dfs(root.left);
    		root.val += root.left.val;
    	}
    	if(root.right != null){
    		//递归对右孩子进行计算
    		dfs(root.right);
    		root.val += root.right.val;
    	}
    	//将每一个结点的subtree sum存到一个全局的map中，key: subtree sum; value: 次数
    	if(map.containsKey(root.val)){
    		map.put(root.val, map.get(root.val)+1);
    	}else{
    		map.put(root.val, 1);
    	}
    }
}
