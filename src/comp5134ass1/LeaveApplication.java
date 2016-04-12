package comp5134ass1;

import java.util.Date;

public class LeaveApplication {
	
	Staff staff;
	Date startDate;
	Date endDate;
	String status;
	
	public LeaveApplication(Staff staff, Date startDate, Date endDate, String status) {
		this.staff = staff;
		this.startDate = startDate;
	    this.endDate = endDate;
	    this.status = status;
	  }
	
	public Date getStartDate() {
	    return this.startDate;
	  }
	public Date getEndDate() {
	    return this.endDate;
	  }
	public Staff getStaff() {
	    return this.staff;
	  }
	public String getStatus() {
	    return this.status;
	  }
	public void setStatus(String status){
		this.status=status;
	}

}
