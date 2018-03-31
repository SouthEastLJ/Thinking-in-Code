package offer9;

import java.util.*;



class Solution {
	Stack <Integer> stack1 = new Stack<Integer>(); //实例变量（成员变量）
	Stack <Integer> stack2 = new Stack<Integer>(); //实例变量（成员变量）
	
	Queue<Integer> queue1 = new LinkedList<Integer>(); // Queue是接口，Queue一般用LinkedList实现。
	Queue<Integer> queue2 = new LinkedList<Integer>();
	
	public void appendTail(int element)
	{
		stack1.push(element);
	}
	
	public int deletHead()
	{
		if(stack2.size()<=0)
		{
			while(stack1.size()>0)
			{
				stack2.push(stack1.pop());
			}
		}
		if(stack2.size()==0)
		{
            try {
                throw new Exception("queue is empty.");
            } 
            catch (Exception e) {
            }
		}
		int out = stack2.pop();    //局部变量  方法体中任何位置可以访问   
		return out;
			
	}
	
	public void push(int element)
	{
		if (queue1.isEmpty() && queue2.isEmpty())
		{
			queue1.offer(element);
		}
		else if(queue1.isEmpty())
		{
			queue2.offer(element);
		}
		else
		{
			queue1.offer(element);
		}
	}
	
	public int  pop()
	{
		int out = 0;
		if(!queue1.isEmpty())
		{
			while(queue1.size()>1)
			{
				queue2.offer(queue1.poll());
			}
			out = queue1.poll();
		}
		else if(!queue2.isEmpty())
		{
			while(queue2.size()>1)
			{
				queue1.offer(queue2.poll());
			}
			out = queue2.poll();
		}
		else
		{
            try {
                throw new Exception("stack is empty.");
            } 
            catch (Exception e) {
            }
		}
		return out;
	}
}

public class Offer9{
	
	public static void main(String []args)
	{
		int []in = {2,1,3,5,4,9,6,5,3,5,6};
		Solution a = new Solution();
		for(int i=0;i<in.length;i++)
		{
			a.push(in[i]);
		}
		
		System.out.println(a.pop());
		System.out.println(a.pop());
		a.push(12);
		System.out.println(a.pop());
		System.out.println(a.pop());
		
	}

}
