
 
public class ReflectionHelloWorld3 {
	public static void main(String[] args){
		//create instance of "Class"
		Class c = null;
		try{
			c=Class.forName("Feeb");
		}catch(Exception e){
			e.printStackTrace();
		}
 
		//create instance of "Foo"
		Feeb f = null;
 
		try {
			f = (Feeb) c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}	
 
		f.print();
	}
}
 
class Feeb {
	public void print() {
		System.out.println("abc");
	}
}