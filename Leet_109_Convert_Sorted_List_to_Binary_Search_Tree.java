import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Leet_109_Convert_Sorted_List_to_Binary_Search_Tree {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	/**
	 * 自底向上的做法
	 * @param head
	 * @return
	 */
	//递归的时候要不断遍历链表，因此要有全局变量辅助
	static ListNode h;
	public TreeNode sortedListToBSTFromBottomToTop(ListNode head){
		if(head == null){
			return null;
		}
		//计算长度
		int size = 0;
		ListNode p = head;
		while(p != null){
			size++;
			p = p.next;
		}
		//开始计算
		h = head;
		return fromBottomToUp(0, size - 1);
	}
	public TreeNode fromBottomToUp(int start, int end){
		if(start > end){
			return null;
		}
		//中间点
		int middle = (start + end) / 2;
		//左递归
		TreeNode left = fromBottomToUp(start, middle - 1);
		//根结点(中)
		TreeNode root = new TreeNode(h.val);
		//访问完了就要后移游标
		h = h.next;
		//右递归
		TreeNode right = fromBottomToUp(middle + 1, end);
		root.left = left;
		root.right = right;
		return root;
	}
	/**
	 * 还可以使用快慢指针的方法来做
	 * 具体做法是先找到链表的中间结点，然后对左右各半部分的链表递归运算
	 * @param head
	 * @return
	 */
	public TreeNode sortedListToBSTFastSlowPointer(ListNode head){
		//如果head为空，那么返回空
		if(head == null){
			return null;
		}
		//如果head只有一个结点
		if(head.next == null){
			return new TreeNode(head.val);
		}
		//找到链表的中间结点
		ListNode mid = findMid(head);
		//构建根结点（这个根结点不仅是最后返回的结果，而且是每次递归，即每个子树的根结点）
		TreeNode root = new TreeNode(mid.val);
		root.left = sortedListToBSTFastSlowPointer(head);
		root.right = sortedListToBSTFastSlowPointer(mid.next);
		return root;
	}
	/**
	 * 查找一个链表的中间结点，快慢指针
	 * @param head
	 * @return
	 */
	ListNode findMid(ListNode head){
		ListNode preSlow = null, slow = head, fast = head;
		while(fast != null){
			fast = fast.next;
			if(fast != null){
				fast = fast.next;
				preSlow = slow;
				slow = slow.next;
			}
		}
		//preSlow元素是分界元素，我们使用它将一个链表一分为二
		preSlow.next = null;
		return slow;
	}
	/**
	 * 尝试最笨的方法：将链表转化为数组，再使用108题中的解法
	 * @param head
	 * @return
	 */
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
        	return null;
        }
        ListNode cursor = head;
        List<Integer> numList = new ArrayList<>();
        while(cursor != null){
        	numList.add(cursor.val);
        	cursor = cursor.next;
        }
        int[] nums = new int[numList.size()];
        Iterator<Integer> it = numList.iterator();
        for(int i = 0; i < nums.length&&it.hasNext(); ++i){
        	nums[i] = it.next().intValue();
        }
        return createTreeNode(nums, 0, nums.length-1);
    }
    /**
     * 108题中的解法（最笨的方法）
     * @param nums
     * @param start
     * @param end
     * @return
     */
    TreeNode createTreeNode(int[] nums, int start, int end){
    	if(start > end){
    		return null;
    	}
    	int middle = start + (end - start) / 2;//核心
    	TreeNode node = new TreeNode(nums[middle]);
    	node.left = createTreeNode(nums, start, middle-1);
    	node.right = createTreeNode(nums, middle+1, end);
    	return node;
    }
}
