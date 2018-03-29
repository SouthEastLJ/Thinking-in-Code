package offer8;

import java.util.ArrayList;
import java.util.List;

/*
 * 找出中序遍历的下一个节点  
 * 注意：树中的节点有指向父节点的指针
 * 
 */

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode father;
	TreeNode(int x)
	{
		val = x;
	}
}

public class Offer8 {
	
	
	
	
	
	
	
	private TreeNode FindNext(TreeNode in) {
		TreeNode out = new TreeNode(-1);
		TreeNode cur = in;
		if(in == null)
			return null;
		if(in.right!=null)
		{
			cur = in.right;
			while(cur.left!=null)
			{
				cur = cur.left;
				
			}
			out = cur;
		}
		if(in.right==null && in.father!=null)  //分析没有右子树的情形
		{
			if(in.father.left==in)
			{
				out = in.father;
			}
			else if(in.father.right == in)
			{
				cur = in.father;
				while(cur.father.right == cur && cur.father!=null)
				{
					cur=cur.father;

				}
				if(cur.father==null)
					out = null;
				else
					out = cur.father;
			}
		}
		return out;		
	}
	

	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode cur = root;
		TreeNode a = cur.left = new TreeNode(2);
		TreeNode b = cur.right = new TreeNode(3);
		a.father = cur;
		b.father = cur;
		a.left=new TreeNode(4);
		a.right = new TreeNode(5);
		a.left.father =a;
		a.right.father = a;
		
		TreeNode out = new Offer8().FindNext(root);
		
		
		
		
		
		System.out.println(out.val);
		
	}

}
