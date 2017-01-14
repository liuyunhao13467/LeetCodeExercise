/**
	 * Write a function to delete a node (except the tail) 
	 * in a singly linked list, given only access to that node.
	 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and 
	 * you are given the third node with value 3, 
	 * the linked list should become 1 -> 2 -> 4 after calling your function.
	 */

	public class ListNode {
		int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}

	public void deleteNode(ListNode node) {
		if(node.next == null){
			return ;
		}
		ListNode firstNode = node;
		ListNode secondNode = node.next;
		while(secondNode.next != null){
			firstNode.val = secondNode.val;
			firstNode = secondNode;
			secondNode = secondNode.next;
		}
		firstNode.val = secondNode.val;
		firstNode.next = null;
	}
