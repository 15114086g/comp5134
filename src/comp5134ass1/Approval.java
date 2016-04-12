package comp5134ass1;

public class Approval {
	Staff staff;
	LeaveApplication leave;
	Boolean status;
	
	public Approval(Staff staff, LeaveApplication leave){
		this.staff=staff;
		this.leave=leave;
	}
	
	public Staff getStaff(){
		return this.staff;
	}
	public LeaveApplication getLeave(){
		return this.leave;
	}
	
	public Boolean getStatus(){
		return this.status;
	}
	
	public void setStatus(Boolean status){
		this.status=status;
	}
}
