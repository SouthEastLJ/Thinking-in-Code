package offer32;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;


class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x)
	{
		val =x;
	}
}
public class Offer {
	public static void main(String []args)
	{
		//		Object a = new Object<>();
		//		a.hashCode();
		//		Map <Integer> test = new HashMap<Integer>();
		//String ca = "abs";
		TreeNode a = new TreeNode(1);
		a.left = new TreeNode(2);
		a.right = new TreeNode(3);
		a.left.right = new TreeNode(4);
		LinkedList<Integer> ans = new LinkedList<Integer>();
		//ans = VerifySquenceOfBST(a);
		VerifySquenceOfBST2(a,ans);
		Iterator<Integer> out = ans.iterator();
		while(out.hasNext())
			System.out.print(out.next());
		
	}	
	private static LinkedList PrintTopToBottom(TreeNode root)
	{
		if(root == null)
		{
			return null;
		}
		LinkedList <Integer> out = new LinkedList<Integer>();
		Queue <TreeNode> buff = new LinkedList<TreeNode>();
		buff.offer(root);
		while(!buff.isEmpty())
		{
			TreeNode a = buff.poll();
			out.add(a.val);
			if(a.left!=null)
				buff.offer(a.left);
			if(a.right!=null)
				buff.offer(a.right);
		}
		return out;		
	}
	
	private static LinkedList VerifySquenceOfBST(TreeNode root)
	{
		Stack <TreeNode> stack1 = new Stack<TreeNode>();
		Stack <TreeNode> stack2 = new Stack<TreeNode>();
		LinkedList <Integer> out = new LinkedList<Integer>();
		if(root == null)
		{
			return null;
		}
		TreeNode cur = root;
		while(cur!=null || !stack1.isEmpty())
		{

			while(cur!=null)
			{				
				stack1.push(cur);
				stack2.push(cur);
				cur =cur.right;
			}
			cur = stack1.pop();		
			cur = cur.left;
		}
		while(!stack2.isEmpty())
			out.add(stack2.pop().val);
		return out;
		
		
	}
	
	private static void VerifySquenceOfBST2(TreeNode root,LinkedList <Integer> out)
	{
		
		if(root == null)
		{
			return ;
		}
		VerifySquenceOfBST2(root.left,out);
		VerifySquenceOfBST2(root.right,out);
		out.add(root.val);		
	}
	
}
