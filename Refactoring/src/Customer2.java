// Replace constructors with factories
//Two techniques have been shown 
//One with switch cases and the other one is done dynamically

public abstract class Customer2 {
	
	private String custRating;
	static final int PREMIER = 2;// a customer who pays in advance
	static final int VALUED = 1;// normal customer 
	static final int DEADBEAT = 0; // a customer who doesn't pay on time
	
	
	//create getters and setters for custRating
	public String getCustRating(){ return custRating; }
	
	public void setCustRating(String custRating) { this.custRating = custRating; }
	
	public static void main(String[] args){
		
		// This factory will generate specific subclasses of Customer3
		
		CustomerFactory customerFactory  = new CustomerFactory();
		
		// This assigns the methods and fields for the class Premier
		
		// This is replaced when I get rid of the Switch 
		
		// Customer3 goodCustomer = customerFactory.getCustomer(Customer3.PREMIER);
		
		Customer2 goodCustomer = customerFactory.getCustomer("Premier");
		
		System.out.println("This Customers Rating: " + goodCustomer.getCustRating());
		
		// This assigns the methods and fields for the class Deadbeat
		
		// This is replaced when I get rid of the Switch 
		
		// Customer3 badCustomer = customerFactory.getCustomer(Customer3.DEADBEAT);
		
		Customer2 badCustomer = customerFactory.getCustomer("Deadbeat");
				
		System.out.println("This Customers Rating: " + badCustomer.getCustRating());
		
	}

}

class Premier extends Customer2{
	
	Premier(){
		
		setCustRating("Premier Customer");
		
	}
	
}

class Deadbeat extends Customer2{
	
	Deadbeat(){
		
		setCustRating("Deadbeat Customer");
		
	}
	
}

class CustomerFactory{
	
	// This is a poor design because this switch needs updated
	// every time I make a new subclass
	/*
	public Customer2 getCustomer(int custType){
		
		switch (custType){
		
		case 2:
			return new Premier();
		case 0:
			return new Deadbeat();
		default:
			throw new IllegalArgumentException("Invalid Customer Type");
		
		}
		
	}
	*/
	//The following is the factory method
	public Customer2 getCustomer(String custName){
		
		try {
			
			// forName returns a class object that has the same name with 
			//the String which is
			// passed to it. newInstance() creates an instance of the class
			
			return (Customer2) Class.forName(custName).newInstance();
				// returning a subclass of (Customer 2)
			
		}
		
		catch(Exception e){
			
			throw new IllegalArgumentException("Invalid Customer Type");
		
		}
		
	}
	
}