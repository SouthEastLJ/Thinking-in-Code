package offer6;

import java.util.Scanner;
import java.util.Stack;

/*
 * 使用栈的思想，反转打印链表
 * 
 * 测试用例：
 * 1.   6   1 2 3  4 5 6
 * 2.   1   1
 * 3.   0
 * 
 */

class ListNode{
	int val;
	ListNode next;
	ListNode(int x)
	{
		val =x;
	}
}
public class Offer6 {
	
	
	public static void main(String[] args){
		Scanner sc= new Scanner (System.in);
		int n = sc.nextInt();
		ListNode head = new ListNode(0);
		ListNode ptr = head;
		for(int i=0;i<n;i++)
		{
			 ptr.next = new ListNode(sc.nextInt());
			 ptr = ptr.next;
		}
		new Offer6().Listprint(head.next);
		
	}
	public void Listprint(ListNode head)
	{
		Stack <ListNode>buf = new Stack<ListNode>();
		ListNode cur = head;
		while(cur!=null)
		{
			buf.push(cur);
			cur = cur.next;
		}
		while(!buf.isEmpty())
		{
			cur = buf.pop();
			System.out.println(cur.val);
		}
	}

}
