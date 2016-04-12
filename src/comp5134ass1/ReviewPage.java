package comp5134ass1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ReviewPage extends JFrame{
	
	Staff staff;
	ArrayList<LeaveApplication> leaveList;
	
	public ReviewPage(Staff staff, ArrayList<LeaveApplication> leaveList){
		super("Review Leave Application");
	    this.staff=staff;
	    this.leaveList=leaveList;
		buildUI();
	}
	
	public void buildUI(){
		this.setSize(500, 300);
	    this.setLocation(100, 100);
	    
	    JPanel aPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Review previous leave application status"));
        aPanel.add(topPanel, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        int i=0,j=0;
        
        addGrid("Start Date", centerPanel, i,0,c);
        addGrid("End Date", centerPanel, i,1,c);
        addGrid("Status", centerPanel, i,2,c);
        
        i+=1;
        
        for(LeaveApplication l:leaveList){
        	if(l.getStaff()==staff){
        		c.anchor = GridBagConstraints.PAGE_START;
                c.weighty = 1.0;
                c.ipadx = 25;
            	c.ipady = 20;
        		
        		addGrid(toString(l.getStartDate()), centerPanel, i,0,c);
                addGrid(toString(l.getEndDate()), centerPanel, i,1,c);
                addGrid(l.getStatus(), centerPanel, i,2,c);
        		i+=1;
        	}
        }
        
        aPanel.add(centerPanel,  BorderLayout.CENTER);
        this.add(aPanel);
	    this.setVisible(true);
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
        centerPanel.add(new JLabel(s, SwingConstants.LEFT),c);
	}
	

}
