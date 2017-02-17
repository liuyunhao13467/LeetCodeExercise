package com;

public class Leet_234_Palindrome_Linked_List {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
    public boolean isPalindrome(ListNode head) {
    	//先判断合法性：空链表或者单个元素的链表返回false
    	if(head == null || head.next == null){
    		return true;
    	}
    	//对链表的后半部分或者前半部分逆置，然后比较逆置后与剩下的一半是否相等
    	//先找后半部分链表，采用快慢指针的方法
    	ListNode slow = head;
    	ListNode fast = head;
    	while(fast.next != null && fast.next.next != null){
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	//对链表后半段进行反转  
    	ListNode midNode=slow;  
    	ListNode firNode=slow.next;//后半段链表的第一个节点  
    	ListNode cur=firNode.next;//插入节点从第一个节点后面一个开始  
    	firNode.next=null;//第一个节点最后会变最后一个节点  
    	while(cur!=null)  
    	{  
    	    ListNode nextNode=cur.next;//保存下次遍历的节点  
    	    cur.next=midNode.next;  
    	    midNode.next=cur;  
    	    cur=nextNode;  
    	}  
    	   
    	//反转之后对前后半段进行比较  
    	slow=head;  
    	fast=midNode.next;  
    	while(fast!=null)  
    	{  
    	    if(fast.val!=slow.val)  
    	        return false;  
    	    slow=slow.next;  
    	    fast=fast.next;  
    	}  
    	return true;  
    	
    }
    
    public void reverse(ListNode head){
    	//if linked list is null or only has a head node or has a head node and one element node
    	if(head == null || head.next == null || head.next.next == null){
    		return;
    	}
        //reverse the linked list
    	head.next.next = null;
    	ListNode cur = head.next.next;
    	ListNode pre = head.next;
    	while(cur != null){
    		ListNode curNext = cur.next;
    		cur.next = pre;
    		pre = cur;
    		cur = curNext;
    	}
    	head = pre;
    }
}
