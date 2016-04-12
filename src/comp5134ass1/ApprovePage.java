package comp5134ass1;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
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

public class ApprovePage extends JFrame{
	
	Staff staff;
	ArrayList<LeaveApplication> leaveList;
	ArrayList<Approval> approveList;

	public ApprovePage(Staff staff, ArrayList<LeaveApplication> leaveList, ArrayList<Approval> approveList){
		super("Approve Staff Leave Application");
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
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        
        
        int i=0,j=0;
        
        addGrid("Staff Username", centerPanel, i,0,c);
        addGrid("Start Date", centerPanel, i,1,c);
        addGrid("End Date", centerPanel, i,2,c);
        addGrid("Approve?", centerPanel, i,3,c);
        
        i+=1;
        
        
        
        for(Approval a:approveList){
        	
        	if(a.getStaff()==staff){
        		c.anchor = GridBagConstraints.PAGE_START;
                c.weighty = 1.0;
                c.ipadx = 25;
            	c.ipady = 20;
            	LeaveApplication leave=a.getLeave();
        		
            	String start=toString(leave.getStartDate());
            	addGrid(leave.getStaff().getUsername(), centerPanel, i,0,c);
        		addGrid(start, centerPanel, i,1,c);
                addGrid(toString(leave.getEndDate()), centerPanel, i,2,c);
                JButton action=new JButton("Action");
                action.addActionListener(new ActionListener() {
	        
                	public void actionPerformed(ActionEvent e) {
                		
                		int dialogResult=JOptionPane.showConfirmDialog(ApprovePage.this, "Do you approve "+ start, "Approval", JOptionPane.YES_NO_CANCEL_OPTION);
                		if(dialogResult==0){
                			Staff supervisor=staff.getSupervisor();
                			staff.postCommand(leave);
                			approveList.remove(a);
                			update(aPanel);
                			
                		}else if(dialogResult==1){
                			leave.setStatus("Application Failed");
                			approveList.remove(a);
                			update(aPanel);
                		}
                	}
                });
                c.gridx=3;
                centerPanel.add(action,c);
        		i+=1;
        	}
        }
        
        aPanel.add(centerPanel, BorderLayout.CENTER);
        this.add(aPanel);
	    this.setVisible(true);
	}
	
	public void update(JPanel aPanel){
		aPanel.removeAll();
		buildUI();
	}
	
	public static String toString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = sdf.format(date);
		return dateString;
	}
	
	public static void addGrid(String s, JPanel centerPanel, int i, int j, GridBagConstraints c){
		
		c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = i;
    	c.gridx = j;
    	c.ipadx = 20;
    	c.ipady = 5;
    	c.anchor = GridBagConstraints.PAGE_START;
    	c.weighty = 1.0;
    	JLabel l=new JLabel(s, SwingConstants.LEFT);
      
        centerPanel.add(l,c);
        
	}
	
	
}
