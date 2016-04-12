package comp5134ass1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DeletePage extends JFrame{

	Staff staff;
	ArrayList<Staff> staffList;
	
	public DeletePage(Staff staff, ArrayList<Staff> staffList){
		super("Delete Staff");
	    this.staff=staff;
	    this.staffList=staffList;
	    buildUI();
	}
	
	public void buildUI(){
		this.setSize(500, 300);
	    this.setLocation(100, 100);
	    
	    JPanel aPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Please enter the username of the staff to be deleted"));
        aPanel.add(topPanel, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel(new GridLayout(8, 3, 5, 10));
        for (int i = 0; i < 6; i++) {
            centerPanel.add(new JPanel());
        }
        centerPanel.add(new JLabel("Staff Username", SwingConstants.RIGHT));
        final JTextField username=new JTextField("", 20);
        centerPanel.add(username);
        for(int i=0;i<5;i++)
        	centerPanel.add(new JLabel());
       
        
        JButton delete=new JButton("Delete");
        
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String sUsername = username.getText();
    			Staff dStaff=null;
    			Boolean sExist=false;
    			
    			if(!sUsername.equals(staff.getUsername())){
    				
    			for (Staff s: staffList){
    				
    				if(s.getUsername().equals(sUsername)){
    					dStaff=s;
    					sExist=true;
    					
    				}
            	}
            	
    			if(sExist){
    				staffList.remove(dStaff);
    				dStaff=null;
    				JOptionPane.showMessageDialog(DeletePage.this, "User "+sUsername+" has been removed.");
        			
    			} else{
    				JOptionPane.showMessageDialog(DeletePage.this, "User doesn't exist.");
    			}
            	
    			} else{
    				JOptionPane.showMessageDialog(DeletePage.this, "You do not have the right to delete this user.");
    			}
    		}
            	
            	
            
        });
        centerPanel.add(delete);
        centerPanel.add(new JPanel());
        for (int i = 0; i < 9; i++) {
            centerPanel.add(new JPanel());
        }
        aPanel.add(centerPanel, BorderLayout.CENTER);
        this.add(aPanel);
	    this.setVisible(true);
	}
	
}
