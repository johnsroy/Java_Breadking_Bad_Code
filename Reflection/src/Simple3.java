class Simple3{}  
interface My{}  
  
class Test4{  
 public static void main(String args[]){  
  try{  
   Class c=Class.forName("Simple");  
   System.out.println(c.isInterface());  
     
   Class c2=Class.forName("My");  
   System.out.println(c2.isInterface());  
    
  }catch(Exception e){System.out.println(e);}  
  
 }  
}  