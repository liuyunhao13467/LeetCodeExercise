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
    //正确做法请参考上面的hasPathSum，hasPathSum_FirstTime为最初思路版本，这个算法并不能达到要求
    //基本思路是递归遍历，当传入的TreeNode为空时说明本次函数执行的caller已经为叶子节点，因此返回false
    //当传入的TreeNode不为空时，要进行业务逻辑操作
    //我的思路是：每调用一次函数就使用传入的sum减去本节点的val，最后如果在叶子节点处sum恰好削减为0则说明路径存在
    //因此在实现上，判断sum是否等于零。
    //若sum为零，接下来要判断当前节点是否为叶子节点：如果是叶子节点，则路径达成；如果不是叶子节点，则说明此路径不满足条件（此处思维有漏洞，后述）
    //若sum不为零，则继续递归调用本函数，遍历其左子树和右子树。只要有一个满足条件即可（这个地方在这篇代码中没有正确的写出来，后述）
    //上述思路存在着较大的问题：
    //（1）当到达一个非叶子节点时出现了sum为零的情况时，不能简单地判断该条路径不成立，
    //    因为忽略了节点值可能为负数的情况，虽然在当前节点sum为零，但是在后面的路径运算中，也可能出现负数和正数相减最终等于零的情况
    //    因此，判断路径达成的条件不能简单地是“sum为零”，而应该是“在叶子节点处sum为零”，叶子节点、sum为零，两个条件缺一不可
    //    原思路只注意到了sum为零这个情况，这是思维的第一个漏洞
    //（2）当sum不等于零时要继续递归的调用本函数，对本节点的左右孩子节点进行判断，
    //    在这里的逻辑是：只要对左右孩子节点使用这个函数的两个结果有一个结果正确（返回true）即可，
    //    但是在下面的代码中，并非表述的这个意思，正确的实现可以用hasPathSum(root.left, sum) || hasPathSum(root.right, sum)来表示
    //综上所述：
    //我们在判断的时候，要判断两个条件：1，是否为叶节；2，sum是否为零
    //如果按照原来的思路来看，应该有如下几种情况：
    //（1）sum==0 且 为叶节点 -->结束运算，返回true
    //（2）sum==0 且 不为叶节点 -->继续运算
    //（3）sum！=0 且 为叶节点 -->结束运算，返回false
    //（4）sum！=0 且 不为叶节点 -->继续运算
    //但是最好先判断是否为叶节点这个条件，因为如果这个条件不达成，计算一定不结束，情况（2）（4）所做的操作是一样的。因此先判断是否为叶节点可以简化思路，精简代码量
    public boolean hasPathSum_FirstTime(TreeNode root, int sum) {
	boolean isZero = false;
	if(root != null){
		sum = sum - root.val;
		//如果此时sum减到了0
		if(sum == 0){
			//如果当前结点为叶子节点（且sum已经为零），则存在路径
			if(root.left == null && root.right == null){
				isZero = true;
			}else{//如果不是叶子节点（但是sum已经到0了），则说明此路径不满足条件
				isZero = false;
			}
		}else{
			isZero = hasPathSum(root.left, sum);
			if(isZero == true){
				return isZero;
			}
			isZero = hasPathSum(root.right, sum);
		}
	}else{//虽然前面已经对节点进行判断，看其是否为叶子节点，但是还是要防止最开始的传入参数就是空树的情况
		isZero = false;
	}
	return isZero;
    }
}
