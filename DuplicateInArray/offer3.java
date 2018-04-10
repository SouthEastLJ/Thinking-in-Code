import java.util.*;
/*
 * 数组中重复的数字
 * 
 * 
 */
public class offer3 {
	
	private LinkedList duplicate1(int []numbers)
	{
		if(numbers.length==0)
			return null;
		LinkedList <Integer> out = new LinkedList<Integer>();
		for(int i=0;i<numbers.length;i++)
		{
			while(i != numbers[i])
			{
				if(numbers[i] == numbers[numbers[i]])
				{
					out.add(numbers[i]);
					break;
				}
				int temp = numbers[i];
				numbers[i] = numbers[temp];
				numbers[temp] = temp;
			}
		}
		return out;
	}
	private LinkedList duplicate2(int []numbers)
	{
		if(numbers.length==0)
			return null;
		LinkedList <Integer> out = new LinkedList<Integer>();
		Map<Integer,Integer> buffer = new HashMap<Integer,Integer>();
		for(int i=0;i<numbers.length;i++)
		{
			if(buffer.containsKey(numbers[i]))
			{
				out.add(numbers[i]);
			}
			else
			{
				buffer.put(numbers[i], 1);
			}
			
		}

		return out;
	}
	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []numbers = new int[n];
		for(int i=0;i<n;i++)
		{
			numbers[i]=sc.nextInt();
		}
		LinkedList out = new offer3().duplicate1(numbers);
		for(int k=0;k<out.size();k++)
		{
			System.out.print(out.get(k)+" ");
		}
	}
	
}
