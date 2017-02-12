public class Leet_24_Swap_Nodes_in_Pairs {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	/**
	 * 这种方法我们只进行值交换
	 * @param head
	 * @return
	 */
    public ListNode swapPairs(ListNode head) {
    	//特殊情况
    	if(head == null){
    		return null;
    	}
    	if(head.next == null){
    		return head;
    	}
    	//初始状态下指针
    	ListNode p = head;
    	while(p != null){
    		//交换值
    		int tmp = p.val;
    		p.val = p.next.val;
    		p.next.val = tmp;
    		//移动游标
    		p = p.next;
    		//链表有偶数个元素的情况下，要保证指针移动后它的下一个元素存在，因为每次都要对p和它下一个元素进行交换操作
    		if(p.next == null){
    			break;
    		}
    		p = p.next;
    		//链表有奇数个元素的情况下，要保证指针移动后它的下一个元素存在，因为每次都要对p和它下一个元素进行交换操作
    		if(p.next == null){
    			break;
    		}
    	}
        return head;
    }
}
