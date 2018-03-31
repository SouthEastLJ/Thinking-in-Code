package offer10;

//用矩阵的方法实现斐波那契数列

public class Offer10 {
	
	
	private int Fibonacci(int n)
	{
		
		int [][] a = new int[2][2];
		a[0][0] = 1;a[0][1] = 1;
		a[1][0] = 1;a[1][1] = 0;
		int [][] buff = new int[2][2];
		int c = n/2;
		
		int b = n-2*(int)(n/2);
		
		if(n==1)
			return 0;
		if(n==2 || n==3)
			return 1;
		
		
		
		for(int i=0;i<c-2;i++)
		{
			buff[0][0] = a[0][0]*1+a[0][1]*1;
			buff[0][1] = a[0][0]*1+a[0][1]*0;
			buff[1][0] = a[1][0]*1+a[1][1]*1;
			buff[1][1] = a[1][0]*1+a[1][1]*0;
			a[0][0] = buff[0][0] ;
			a[0][1] = buff[0][1] ;
			a[1][0] = buff[1][0] ;
			a[1][1] = buff[1][1] ;
		}
	
		if(b==0)
			return a[0][0]*a[0][0]+a[0][1]*a[1][0];
		else
			return a[0][0]*a[0][0]+a[0][1]*a[1][0]+a[0][0]*a[0][1]+a[0][1]*a[1][1];
		
		
	}
	public static void main(String []args)
	{
		
		
		System.out.println(new Offer10().Fibonacci(2));
		
	}
	
	
	

}
