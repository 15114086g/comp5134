package comp5134ass1;

public class Director extends Staff{
	private static Director instance;
	
	protected Director(String username, String name, String password, Staff supervisor){
		super(username,name,password,supervisor);
	}
	
	public static Director getInstance(String username, String name, String password){
		if(instance==null){
			instance = new Director(username,name,password,null);
		}
		return instance;
	}
	
	public static Boolean checkInstance(){ //if no director return true
		if(instance==null)
			return true;
		return false;
	}
}

