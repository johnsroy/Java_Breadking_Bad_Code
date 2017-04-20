import java.lang.reflect.Constructor;

public class ReflectionHelloWorld4 {
	public static void main(String[] args){
		//create instance of "Class"
		Class<?> c = null;
		try{
			c=Class.forName("Feebs");
		}catch(Exception e){
			e.printStackTrace();
		}
 
		//create instance of "Foo"
		Feebs f1 = null;
		Feebs f2 = null;
 
		//get all constructors
		Constructor<?> cons[] = c.getConstructors();
 
		try {
			f1 = (Feebs) cons[0].newInstance();
			f2 = (Feebs) cons[1].newInstance("abc");
		} catch (Exception e) {
			e.printStackTrace();
		}	
 
		f1.print();
		f2.print();
	}
}
 
class Feebs {
	String s; 
 
	public Feebs(){}
 
	public Feebs(String s){
		this.s=s;
	}
 
	public void print() {
		System.out.println(s);
	}
}