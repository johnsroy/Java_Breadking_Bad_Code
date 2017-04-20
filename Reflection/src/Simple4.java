class Simple4{  
 void message(){System.out.println("Hello Java");}  
}  
  
class Test5{  
 public static void main(String args[]){  
  try{  
  Class c=Class.forName("Simple4");  
  Simple4 s=(Simple4)c.newInstance();  //casting into Simple4 type object
  s.message();  
  
  }catch(Exception e){System.out.println(e);}  
  
 }  
}  