package offer22;

import java.util.Scanner;


/*
 * 链表中倒数第k个节点
 * 
 * 链表为null,链表的节点小于k.
 */
class ListNode{
	int val;
	ListNode next;
	ListNode (int x )
	{
		val = x;
	}
}

public class Offer22 {
	
	private ListNode FindKthToTail(ListNode head,int k)
	{
		ListNode ahead = head;
		ListNode behind = null;
		for(int i=0;i<k-1;++i)
		{
			if(ahead.next!=null) // 防止出现k大于链表长度的情况
				ahead = ahead.next;
			else
				return null;
			
		}
		behind = head;
		while(ahead.next!=null)
		{
			ahead = ahead.next;
			behind = behind.next;
		}
		return behind;
		
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
        int k = sc.nextInt();
        ListNode out = new Offer22().FindKthToTail(head, k);
        try {       	
        	System.out.print(out.val); 
        }
        catch(NullPointerException e) {
            System.out.println("K的值大于链表长度");  //异常处理
        }
        
               
	}
	
	


}
