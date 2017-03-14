package excelParser;

public class Worker {
	private boolean driverStatus;
	private boolean inShopStatus;
	private Availability availability;
	private String name;
	
	public Worker(String name, boolean driver, boolean inShop, Availability aval){
		this.name = name;
		driverStatus = driver;
		inShop = inShopStatus;
		availability = aval;
	}
	
	//Getters
	public boolean getDriverStatus(){
		return driverStatus;
	}
	
	public boolean getInShopStatus(){
		return inShopStatus;
	}
	
	public Availability getAvailability(){
		return availability; 
	}
	
	public String getName(){
		return name;
	}
	
	//Setters
	public void setDriverStatus(boolean status){
		driverStatus = status;
	}
	
	public void setInShopStatus(boolean status){
		inShopStatus = status;
	}
	
	public void setAvailability(Availability aval){
		availability = aval;
	}
	
	public void setName(String name){
		this.name = name;
	}
}
