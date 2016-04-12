package comp5134ass1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePage extends JFrame implements Observer{
	
	Staff staff;
	ArrayList<Staff> staffList;
	ArrayList<LeaveApplication> leaveList;
	ArrayList<Approval> approveList;
	
	public HomePage(Staff staff, ArrayList<Staff> staffList, ArrayList<LeaveApplication> leaveList, ArrayList<Approval> approveList){
		super("Home Page");
	    this.staff=staff;
	    this.staffList=staffList;
	    this.leaveList=leaveList;
	    this.approveList=approveList;
	    this.staff.addObserver(this);
	    
	    buildUI();
	}
	
	public void buildUI(){
		this.setSize(500, 300);
	    this.setLocation(100, 100);
	
	
	    JPanel aPanel = new JPanel(new BorderLayout());
	    JPanel topPanel = new JPanel();
	    topPanel.add(new JLabel("Welcome "+staff.getName()+"!"));
	    aPanel.add(topPanel, BorderLayout.NORTH);
	    
	    JPanel centerPanel = new JPanel(new GridLayout(2,2));
	    
	    JButton leave = new JButton("Apply for leave");
	    leave.addActionListener(new ActionListener() {
	        
			public void actionPerformed(ActionEvent e) {
				new LeavePage(staff, leaveList, approveList);
			}
	    });	    
	    centerPanel.add(leave);
	    
	    JButton delete = new JButton("Delete a staff");
	    delete.addActionListener(new ActionListener() {
	        
			public void actionPerformed(ActionEvent e) {
				new DeletePage(staff,staffList);
			}
	    });	    
	    centerPanel.add(delete);
	    
	    JButton review = new JButton("Review application status");
	    review.addActionListener(new ActionListener() {
	        
			public void actionPerformed(ActionEvent e) {
				new ReviewPage(staff, leaveList);
			}
	    });
	    centerPanel.add(review);
	    
	    JButton approve = new JButton("Approve staff leave application");
	    approve.addActionListener(new ActionListener() {
	        
			public void actionPerformed(ActionEvent e) {
				new ApprovePage(staff,leaveList, approveList);
			}
	    });	    
	    centerPanel.add(approve);
	    
	    aPanel.add(centerPanel, BorderLayout.CENTER);
	    
	    this.add(aPanel);
        this.setVisible(true);
	}
	public void update(Approval a){
		approveList.add(a);
	}

}
