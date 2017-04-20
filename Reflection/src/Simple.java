class Simple{}  
  
class Test{  
 public static void main(String args[]) throws ReflectiveOperationException{  
  Class c=Class.forName("Simple");  
  System.out.println(c.getName());  
 }  
}  