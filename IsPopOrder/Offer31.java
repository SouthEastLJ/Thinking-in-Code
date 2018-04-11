package offer31;

import java.util.Scanner;
import java.util.Stack;

class Solution{
	public  boolean IsPopOrder(int []num1,int []num2)
	{
		Stack<Integer> a = new Stack<Integer>();
		if(num1.length==0 || num2.length==0)
			return false;
		if(num1.length!=num2.length)
			return false;
		int k =0;
		for(int i=0;i<num1.length;i++)
		{
			while(a.size()==0 || a.peek()!=num2[i]) //如果栈为空 或者栈顶元素不等于要弹出元素
			{
				if(k>=num1.length)
					break;
				a.push(num1[k]);
				k++;
			
				
			}
//			if(a.peek()!=num2[i])
//				break;
			a.pop();
			
		}
		if(a.size()!=0)
			return false;
		else
			return true;
	}
}



public class Offer31 {
	
	
	
	
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []num1 = new int[n];
		int []num2 = new int[n];
		for(int i =0;i<n;i++)
		{
			num1[i] = sc.nextInt();
		}
		for(int i =0;i<n;i++)
		{
			num2[i] = sc.nextInt();
		}
		System.out.print(new Solution().IsPopOrder(num1, num2));
		
	}

}
