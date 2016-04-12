package comp5134ass1;

import java.util.ArrayList;
import java.util.Iterator;

public class Staff implements CommandHandler {
	String username;
	String name;
	Staff supervisor;
	String password;
	
	Observer listners;
	
	public Staff(String username, String name, String password, Staff supervisor) {
	    this.supervisor = supervisor;
	    this.username = username;
	    this.name = name;
	    this.password = password;
	  }
	
	public Staff getSupervisor() {
	    return this.supervisor;
	  }
	
	public String getPassword() {
	    return this.password;
	  }
	
	public String getUsername() {
	    return this.username;
	  }
	
	public String getName() {
	    return this.name;
	  }
	
	public void postCommand(LeaveApplication leave){
		
		if(this.getSupervisor()==null)
			leave.setStatus("Application Succeeded");
		else{
			Approval a=new Approval(supervisor,leave);
		
			listners.update(a);
		}	
			
	}
	
	public void addObserver(Observer o){
		this.listners=o;
		
	}
	
}
