package comp5134ass1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LeavePage extends JFrame{
	
	Staff staff;
	ArrayList<LeaveApplication> leaveList;
	ArrayList<Approval> approveList;
	
	public LeavePage(Staff staff, ArrayList<LeaveApplication> leaveList, ArrayList<Approval> approveList){
		super("Leave Application");
	    this.staff=staff;
	    this.leaveList=leaveList;
	    this.approveList=approveList;
	    
	    buildUI();
	}
	
	public void buildUI(){
		this.setSize(500, 300);
	    this.setLocation(100, 100);
	    
	    JPanel aPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Leave Application"));
        aPanel.add(topPanel, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel(new GridLayout(8, 3, 5, 10));
        for (int i = 0; i < 6; i++) {
            centerPanel.add(new JPanel());
        }
        centerPanel.add(new JLabel("StartDate", SwingConstants.RIGHT));
        final JTextField startDate=new JTextField("", 20);
        centerPanel.add(startDate);
        centerPanel.add(new JLabel("yyyy-mm-dd", SwingConstants.LEFT));
        centerPanel.add(new JLabel("EndDate", SwingConstants.RIGHT));
        final JTextField endDate=new JTextField("", 20);
        centerPanel.add(endDate);
        centerPanel.add(new JLabel("yyyy-mm-dd", SwingConstants.LEFT));
        centerPanel.add(new JPanel());
        
        JButton apply=new JButton("Apply");
        
        apply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	String sDate=startDate.getText();
            	String eDate=endDate.getText();
            	
            	if(isValidDate(sDate)&&isValidDate(eDate)){
            		if(sDate.compareTo(eDate)==1){
            			JOptionPane.showMessageDialog(LeavePage.this, "Invalid date.");
    				
            		}
            		else{
            		
            		LeaveApplication newLeave=new LeaveApplication(staff, toDate(sDate),toDate(eDate), "pending");
            		
            		leaveList.add(newLeave);
            		JOptionPane.showMessageDialog(LeavePage.this, "Application submitted, pending for appraoval.");
            		
        			staff.postCommand(newLeave);
        			
            		
            		
            		
            		}
            		
            	} else{
        			JOptionPane.showMessageDialog(LeavePage.this, "Invalid date.");
            		
        		}
            	
            	
            }
        });
        centerPanel.add(apply);
        centerPanel.add(new JPanel());
        for (int i = 0; i < 9; i++) {
            centerPanel.add(new JPanel());
        }
        aPanel.add(centerPanel, BorderLayout.CENTER);
        this.add(aPanel);
	    this.setVisible(true);
	}
	
	public static boolean isValidDate(String inDate) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    try {
	      dateFormat.parse(inDate.trim());
	    } catch (ParseException pe) {
	    	
	      return false;
	    }
	    return true;
	  }
	
	public static Date toDate(String dateString){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date  date=null;
		try {
			date = sdf.parse(dateString);
			
		} catch (ParseException pe) {
			System.out.println(pe);
		}
		return date;
	}
	
}
