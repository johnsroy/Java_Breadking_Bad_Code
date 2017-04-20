
public class StringBufferDemo {
	private static final int ITERATIONS = 1000000;
	private static final int BUFFSIZE = 16;
	public void concatString(){
		System.out.print("Concate String ->");
		long startTime = System.currentTimeMillis();
		String concat = "";
		for (int i=0;i<ITERATIONS; i++)
		{
			concat += (i%10);
		}
	}
	
	public void concatStringBuffer(){
		System.out.print("Concate String Buffer ->");
		long startTime = System.currentTimeMillis();
		StringBuffer concat= new StringBuffer (BUFFSIZE);
		for (int i=0; i<ITERATIONS; i++){
			concat.append(i%10);
		}
		long endTime = System.currentTimeMillis();
		System.out.print("length" +concat.length());
		System.out.println("time"+(endTime - startTime));
	
	}

	public static void main(String[] args) {
		String str = new String ("Hello");
		str += "Stanford";
		
		StringBuffer strb = new StringBuffer("Hello");
		strb.append("Stanford");
		
		StringBufferDemo st = new StringBufferDemo();
		System.out.println("Iterations" +ITERATIONS);
		System.out.println("Buffer :" +BUFFSIZE);

	}

}
