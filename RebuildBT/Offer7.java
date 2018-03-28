package offer7;

import java.util.*;



/*
 * 树的结构
 * 
 * 给出前序和中序遍历的结果，重建这个二叉树
 * 
 * 这个编程中还包括递归形式的前中后遍历
 */

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x)
	{
		val =x;
	}
}

class ListNode{
	int val;
	ListNode next;
	ListNode(int x)
	{
		val =x;
	}
}

public class Offer7 {
	
	private TreeNode Construct(int[] prehead,int []inhead,int length)
	{
		TreeNode head = null;
		if(prehead == null || inhead==null || length<=0)
			return head;
		else
			head = ConstructCore(prehead,0,length-1,inhead,0,length-1);
		return head;
		
	}
	
	private TreeNode ConstructCore(int[] pre, int ps,int pe,int []in,int is,int ie)
	{
		if(ps > pe )
			return null;
		int rootval = pre[ps];
		TreeNode root = new TreeNode(rootval);
		

	
		
		int i = 0;
		while(in[i]!=rootval)
		{
			i++ ;
		}
		if(i>0)
		{
			root.left = ConstructCore(pre,ps+1,ps+i-is,in,is,i-1);
		}
		if(i<ie)
		{
			root.right = ConstructCore(pre,ps+i-is+1,pe,in,i+1,ie);
		}
		return root;

	}
	
/*
    public static TreeNode ConstructCore(int[] preOrder,int ps,int pe,int[] inOrder,int is,int ie){
        //开始位置大于结束位置说明已经处理到叶节点了
        if(ps>pe)
            return null;
        ///前序遍历第一个数字为当前的根节点
        int value=preOrder[ps];
        //index为根节点在中序遍历序列中的索引
        int index=is;
        while(index<=ie&&inOrder[index]!=value){
            index++;
        }
        System.out.println("当前各参数的数值为->ps:"+ps+" pe:"+pe+" is："+is+" ie："+ie+" index："+index+" rootValue："+value);
        //如果在整个中序遍历中没有找到根节点说明输入的数据是不合法的
        if(index>ie){
            throw new RuntimeException("invalid input"+index);
        }
        TreeNode node=new TreeNode(value);
        
        //当前节点的左子树的个数为index-is
        //左子树对应的前序遍历的位置在preOrder[ps+1,ps+index-is]
        //左子树对应的中序遍历的位置在inOrder[is,index-1]
        node.left=ConstructCore(preOrder,ps+1,ps+index-is,inOrder,is,index-1);
        //当前节点的右子树的个数为ie-index
        //右子树对应的前序遍历位置在preOrder[ps+index-is+1,pe]
        //右子树对应的中序遍历位置在inOrder[index+1,ie]
        node.right=ConstructCore(preOrder,ps+index-is+1,pe,inOrder,index+1,ie);
        return node;
    }
    */
	
	//广度优先遍历
	/*
	public List<Integer> inorderTraversal(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();	
		List<Integer> out = new ArrayList<Integer>();
		TreeNode cur=root;
		queue.offer(cur);
		while(!queue.isEmpty())
		{
			cur=queue.poll();
			out.add(cur.val);
			if(cur.left!=null)
				queue.offer(cur.left);
			if(cur.right!=null)
				queue.offer(cur.right);
		}
		
		return out;        
	}
	*/
	
//后序遍历非递归
	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		List<Integer> out = new ArrayList<Integer>();
		TreeNode cur=root;		
		while(cur != null || !stack2.empty())
		{
			while(cur != null)
			{
		  		
		  		stack.push(cur);    
		  		stack2.push(cur);
				cur = cur.right;    			
			}
			cur = stack2.pop();		
			cur = cur.left;
		}
		while(!stack.empty())
		{
			out.add(stack.pop().val);
		}	
		return out;        
	}
//后序遍历 递归形式
	public List<Integer> postOrder(TreeNode node,List out) {
		//List<Integer> out = new ArrayList<Integer>();
		if (node != null) {
			postOrder(node.left,out);
			postOrder(node.right,out);
			out.add(node.val);
		}
		
		return out;
	}
	
//前序遍历 递归形式
	public List<Integer> postPer(TreeNode node,List out) {
		//List<Integer> out = new ArrayList<Integer>();
		if (node != null) {
			out.add(node.val);
			postOrder(node.left,out);
			postOrder(node.right,out);
			
		}
		
		return out;
	}
//中序遍历 递归形式
	public List<Integer> postMiddle(TreeNode node,List out) {
		//List<Integer> out = new ArrayList<Integer>();
		if (node != null) {
			postOrder(node.left,out);
			out.add(node.val);
			postOrder(node.right,out);
			
		}
		
		return out;
	}
	
	
	public static void main(String[] args) {
		int[] preOrder={1,2,4,7,3,5,6,8};
		int[] inOrder={4,7,2,1,5,3,8,6};
		List<Integer> out = new ArrayList<Integer>();
		TreeNode node=new Offer7().Construct(preOrder,inOrder,preOrder.length);
		out = new Offer7().postOrder(node,out);
		System.out.println(out.toString());
		
	}

}
