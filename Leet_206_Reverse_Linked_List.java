public class Leet_206_Reverse_Linked_List {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
    public ListNode reverseList(ListNode head) {
    	//在java表述中，头结点视作第一个结点，如果头结点引用为空，返回null
        if(head == null){
        	return null;
        }
        //每执行一次交换都是对当前结点和它的下一个结点进行的，因此设置如下两个变量
        ListNode next = head.next;//初始时当前结点的下一个结点
        head.next = null;//先切段第一个结点和第二个结点的联系，因为逆序之后第一个结点就变成最后一个结点，它不再指向任何结点了
        //只要当前结点的下一个结点不为空就执行操作
        while(next != null){
        	//这个临时辅助变量记录下要进行交换操作的两个结点中的后者所指向的结点。
        	//换句话说，将这两个要执行交换操作的结点看作一个整体，我们必须知道这个整体（不管是交换前还是交换后）的下一个结点指向哪里
        	ListNode tmp = next.next;
        	//先令第二个结点指向第一个结点
        	next.next = head;
        	//将当前元素和它的后一个元素分别后移
        	head = next;
        	next = tmp;
        }
        return head;
    }
}
