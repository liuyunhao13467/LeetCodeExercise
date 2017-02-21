package com;

public class Leet_19_Remove_Nth_Node_From_End_of_List {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	/**
	 * 自己的做法，思路混乱
	 * @param head
	 * @param n
	 * @return
	 */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 1, j = 0;
        ListNode pi = head, pj = null, pjPre = null;
        while(pi.next != null){
        	if(i >= n){
        		if(j == 0){
        			j = 1;
        			pj = head;
        		}else{
        			j++;
        			pjPre = pj;
            		pj = pj.next;
        		}
        	}
        	i++;
        	pi = pi.next;
        }
        pjPre.next = pj.next;
        return head;
    }
    
    /**
     * 大神做法
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n){
    	ListNode p = head, q = head;//p代表后指针，q代表前指针
    	//这个题的关键就在于要判断各种特殊情况
    	//head结点为空
    	if(head == null){
    		return null;
    	}
    	//先将前指针向前推进n个结点
    	for(int i = 1; i <= n; ++i){
    		q = q.next;
    	}
    	//前指针向前推进后，要考虑特殊情况：如果只有一个head结点，即这是一个空链表的情况
    	if(q == null){
    		head = head.next;
    		return head;
    	}
    	//正常情况下找倒数第n个数，因为p最开始的时候指向的是头结点，因此当最后前指针指向最后一个元素的时候，后指针p指向的是倒数第n个元素的前一个元素
    	while(q.next != null){
    		q = q.next;
    		p = p.next;
    	}
    	//去掉倒数第n个数
    	p.next = p.next.next;
    	return head;
    }
}
