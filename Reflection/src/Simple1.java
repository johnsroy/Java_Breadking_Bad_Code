class Simple1{}  
  
class Test2{  
  void printName(Object obj){  
  Class c=obj.getClass();    
  System.out.println(c.getName());  
  }  
  public static void main(String args[]){  
   Simple s=new Simple();  
   
   Test2 t=new Test2();  
   t.printName(s);  
 }  
}  