package offer7;

import java.util.*;



/*
 * ���Ľṹ
 * 
 * ����ǰ�����������Ľ�����ؽ����������
 * 
 * �������л������ݹ���ʽ��ǰ�к����
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
        //��ʼλ�ô��ڽ���λ��˵���Ѿ�����Ҷ�ڵ���
        if(ps>pe)
            return null;
        ///ǰ�������һ������Ϊ��ǰ�ĸ��ڵ�
        int value=preOrder[ps];
        //indexΪ���ڵ���������������е�����
        int index=is;
        while(index<=ie&&inOrder[index]!=value){
            index++;
        }
        System.out.println("��ǰ����������ֵΪ->ps:"+ps+" pe:"+pe+" is��"+is+" ie��"+ie+" index��"+index+" rootValue��"+value);
        //������������������û���ҵ����ڵ�˵������������ǲ��Ϸ���
        if(index>ie){
            throw new RuntimeException("invalid input"+index);
        }
        TreeNode node=new TreeNode(value);
        
        //��ǰ�ڵ���������ĸ���Ϊindex-is
        //��������Ӧ��ǰ�������λ����preOrder[ps+1,ps+index-is]
        //��������Ӧ�����������λ����inOrder[is,index-1]
        node.left=ConstructCore(preOrder,ps+1,ps+index-is,inOrder,is,index-1);
        //��ǰ�ڵ���������ĸ���Ϊie-index
        //��������Ӧ��ǰ�����λ����preOrder[ps+index-is+1,pe]
        //��������Ӧ���������λ����inOrder[index+1,ie]
        node.right=ConstructCore(preOrder,ps+index-is+1,pe,inOrder,index+1,ie);
        return node;
    }
    */
	
	//������ȱ���
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
	
//��������ǵݹ�
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
//������� �ݹ���ʽ
	public List<Integer> postOrder(TreeNode node,List out) {
		//List<Integer> out = new ArrayList<Integer>();
		if (node != null) {
			postOrder(node.left,out);
			postOrder(node.right,out);
			out.add(node.val);
		}
		
		return out;
	}
	
//ǰ����� �ݹ���ʽ
	public List<Integer> postPer(TreeNode node,List out) {
		//List<Integer> out = new ArrayList<Integer>();
		if (node != null) {
			out.add(node.val);
			postOrder(node.left,out);
			postOrder(node.right,out);
			
		}
		
		return out;
	}
//������� �ݹ���ʽ
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
