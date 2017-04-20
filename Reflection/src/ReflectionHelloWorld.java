
 public class ReflectionHelloWorld {
	public static void main(String[] args){
		Foo f = new Foo();
		System.out.println(f.getClass().getName());			
	}
}
 
class Foo {
	public void print() {
		System.out.println("abc");
	}
}