package offer23;

import java.util.Scanner;
/*
 * �ҵ������еĻ�
 * 
 * ���ܲ��ԣ������а������߲����������������ж����һ���ڵ㣨ָ������
 * ������ԣ�����Ϊ��
 * 
 */


class ListNode{
	int val;
	ListNode next;
	ListNode (int x )
	{
		val = x;
	}
}

public class Offer23 {
	
	public ListNode MeetingNode(ListNode head)
	{
		if(head == null)
		{
			return null;
		}
		ListNode slow = head.next;
		ListNode fast = head.next.next;
		if(slow == null || fast ==null)
		{
			return null;
		}
		while(fast !=null && slow != null)
		{
			if(slow == fast)
				return fast;
			slow = slow.next;
			fast = fast .next;
			if(fast!=null)
				fast = fast.next;
		}
		return null;
	}
	
	public ListNode EntryNodeOfLoop(ListNode head)
	{
		ListNode MeetNode  = MeetingNode(head);
		if(MeetNode == null)
			return null;
		ListNode node1 = MeetNode.next;
		int loopnum = 1;
		while(node1!=MeetNode)
		{
			++loopnum;
			node1 = node1.next;
		}
		node1 = head;
		for(int i=0;i<loopnum;i++)
		{
			node1 = node1.next;
		}
		ListNode node2 = head;
		while(node1!=node2)
		{
			node1= node1.next;
			node2= node2.next;
		}
		return node1;
	}
	public static void main(String []args )
	{
		Scanner sc = new Scanner(System.in);		
		int num = sc.nextInt();       
        ListNode head = new ListNode(sc.nextInt());
        ListNode ptr = head;
        for(int i=0;i<num-1;i++) {
            ptr.next = new ListNode(sc.nextInt());
            ptr = ptr.next;
        }
        ptr.next = head;//���Ի�
        ListNode out = new Offer23().EntryNodeOfLoop(head);
        try {       	
        	System.out.print(out.val); 
        }
        catch(NullPointerException e) {
            System.out.println("û���ҵ���������Ϊ��");  //�쳣����
        }
        
               
	}

}
