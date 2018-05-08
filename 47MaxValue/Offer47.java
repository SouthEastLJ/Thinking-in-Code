package offer47;
/*
 * 这道题我的理解有点像多米诺骨牌
 * 
 * 求出到达每个点的所能经过的值的最大值
 * 
 */
public class Offer47 {
	public static  void main(String []args)
	{
		int [][]data = new int[4][4];
		data[0][0]=1;data[0][1]=10;data[0][2]=3;data[0][3]=8;
		data[1][0]=12;data[1][1]=2;data[1][2]=9;data[1][3]=6;
		data[2][0]=5;data[2][1]=7;data[2][2]=4;data[2][3]=11;
		data[3][0]=3;data[3][1]=7;data[3][2]=16;data[3][3]=5;
		System.out.print(new Offer47().getMaxValue(data, 4, 4));
	}
	private int getMaxValue(int data[][],int row,int col)
	{
		if(data==null)
		{
			return 0;
		}
		int []buff = new int[row];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				int left=0;
				int up =0;
				if(i>0)
				{
					up = buff[j];
				}
				if(j>0)
				{
					left=buff[j-1];
				}
				buff[j] = Math.max(up, left)+data[i][j];
			}
		}
		return buff[col-1];
	}

}
