package com;

public class Leet_21_Merge_Two_Sorted_Lists {
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
	/**
	 * 这个题不用新建链表，比较大小的时候把结点串起来就可以了
	 * @param l1
	 * @param l2
	 * @return
	 */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	//先判断特殊情况
    	if(l1 == null){
    		return l2;
    	}
    	if(l2 == null){
    		return l1;
    	}
    	//一般情况
        ListNode p1 = l1, p2 = l2, l3;
        //先对比每个链表的第一个元素
        if(l1.val > l2.val){
        	l3 = l2;
        	l2 = l2.next;
        }else{
        	l3 = l1;
        	l1 = l1.next;
        }
        //为l3建一个头结点
        ListNode head = new ListNode(-1);
        head.next = l3;
        while(l1 != null && l2 != null){
        	if(l1.val < l2.val){
        		l3.next = l1;
        		l1 = l1.next;
        		l3 = l3.next;
        	}else{
        		l3.next = l2;
        		l2 = l2.next;
        		l3 = l3.next;
        	}
        }
        //把后面的尾巴加上
        if(l1 == null){
        	l3.next = l2;
        }
        if(l2 == null){
        	l3.next = l1;
        }
        return head.next;
    }
}
