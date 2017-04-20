public class Employee implements java.io.Serializable {
   public String name;
   public String address;
   public transient int  SSN;//confidential info which we don't need to save
   							//thus marked as transient. It will simply be overlooked 
   							//and not be stored
   public int number;
   
   public void mailCheck() {
      System.out.println("Mailing a check to " + name + " " + address);
   }
}
