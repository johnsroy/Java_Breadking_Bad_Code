public class FootballPlayer2{
	
	private String name = "";
	private double[] fourtyYardDashTimes = null;
	
	public String getName()
	{
		return name;
	}
	
	public double [] get40YardDashTimes(){
		return fourtyYardDashTimes;
	}
	
	FootballPlayer2(String name, double[] fourtyYardDashTimes)
	{
		this.name  = name;
		this.fourtyYardDashTimes = fourtyYardDashTimes;
		
	}
	
	
	
	
}