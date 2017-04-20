public class Largest
{
	public static int largest(int[] list){
		int i, max= 0;
		for (i=0; i<list.length -1; i++)
		{
			if (list[i]>max)
			{
				max=list[i];
			}
		}
		return max;
	}
}



