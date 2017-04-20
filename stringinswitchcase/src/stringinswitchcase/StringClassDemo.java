package stringinswitchcase;

public class StringClassDemo {
	public static void main(String args[]){
		String s1 = "Ciao"; //String Literal
		String s2 = new String("Hello"); //Explicitly create a new object in memory
		switch (s1) {
			case "Hola":
				System.out.println("Spanish Greating" +s1);
				break;
			case "Ciao":
				System.out.println("Italian Greeting" +s1);
				break;
			case "Hello":
				System.out.println("English Greeting" +s2);
				break;
			default: 
				System.out.println(s1+ "Greeting not recog");
				break;
		}
	}
}
