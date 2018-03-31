package offer11;



public class Offer11 {
	
	private int Min(int []in )
	{
		if(in==null)
		{
		     try {
	                throw new Exception("in is empty.");
            } 
            catch (Exception e) {
            }
		}
		if(in.length == 1)
			return in[0];
		int a = 0;
		int b = in.length-1;
		int c=0;
		while(b-a>1&&in[a]>=in[b])
		{
			
			c=(b+a)/2;
		    if(in[a] == in[c] && in[a] == in[b])
		    	return Find(in,a,b);
			if(in[a]<=in[c])
				a=c;
			if(in[b]>=in[c])
				b=c;
		}
		return in[b];
	
	}
	
	private int Find(int []in ,int a ,int b)
	{
		int result = in[a];
		for(int i=a+1;i<=b;i++)
		{
			if(in[i]<result)
				result = in[i];
		}
		return result;
	}
	public static void main(String args[])  
    {  
        int array[]={1,0,1,1,1,};  
        int a = new Offer11().Min(array);
      
        System.out.println(a);  
    } 

}
