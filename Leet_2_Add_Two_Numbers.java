public class Leet_2_Add_Two_Numbers {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //先构建一个首结点
		ListNode result = new ListNode(0);
		//针对l1和l2的游标
		ListNode cursorForL1 = l1;
		ListNode cursorForL2 = l2;
		//进位
		int toNext = 0;
		//结果链表游标
		ListNode resultCursor = result;
		//循环遍历
		while((cursorForL1 != null) || cursorForL2 != null){
			//当前访问元素
			int tmp1 = 0;
			int tmp2 = 0;
			//对每个list单独判断一下
			if(cursorForL1 != null){
				toNext += cursorForL1.val;
				cursorForL1 = cursorForL1.next;
			}
			if(cursorForL2 != null){
				toNext += cursorForL2.val;
				cursorForL2 = cursorForL2.next;
			}
			//计算本位结果
			int tmpRes = (tmp1 + tmp2 + toNext) % 10;
			//构造链表
			resultCursor.next = new ListNode(tmpRes);
			resultCursor = resultCursor.next;
			//计算本位的进位
			toNext = (tmp1 + tmp2 + toNext) / 10;  
		}
		//记得加进位
		if(toNext > 0){
			resultCursor.next = new ListNode(toNext);
		}
		return result.next;
    }
}
