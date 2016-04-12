package comp5134ass1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class Login extends JFrame {
	
	ArrayList<Staff> staffList;
	ArrayList<LeaveApplication> leaveList;
	ArrayList<Approval> approveList;
	
	public Login() {
        super("Leave Application System");
        
        this.staffList = new ArrayList<Staff>();
        this.leaveList = new ArrayList<LeaveApplication>();
        this.approveList = new ArrayList<Approval>();
        
        buildUI();
    }
	
	public void buildUI(){
		
		this.setSize(500, 300);
        this.setLocation(100, 100);
        JPanel aPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Leave Application System"));
        aPanel.add(topPanel, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel(new GridLayout(8, 3, 5, 10));
        for (int i = 0; i < 6; i++) {
            centerPanel.add(new JPanel());
        }
        centerPanel.add(new JLabel("Username", SwingConstants.RIGHT));
        final JTextField user=new JTextField("", 20);
        centerPanel.add(user);
        centerPanel.add(new JPanel());
        centerPanel.add(new JLabel("Password", SwingConstants.RIGHT));
        final JTextField pw=new JTextField("", 20);
        centerPanel.add(pw);
        centerPanel.add(new JPanel());
        centerPanel.add(new JPanel());
        
        JButton login=new JButton("Login");
        
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	String sUsername = user.getText();
    			Staff staff=null;
    			Boolean sExist=false;
    			Boolean pExist=false;
            	
            	for (Staff s: staffList){
    				
    				if(s.getUsername().equals(sUsername)){
    					staff=s;
    					sExist=true;
    					if(pw.getText().equals(s.getPassword())){
    						pExist=true;
    						
    					}
    					
    				}
            	}
                if (sExist&&pExist) {
                	new HomePage(staff, staffList, leaveList, approveList);
                    //JOptionPane.showMessageDialog(Login.this, "Hello " + user.getText());
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Wrong username or password!");
                }
            }
        });
        centerPanel.add(login);
        centerPanel.add(new JPanel());
        for (int i = 0; i < 5; i++) {
            centerPanel.add(new JPanel());
        }
        centerPanel.add(new JLabel("Not yet Register?", SwingConstants.CENTER));
        centerPanel.add(new JPanel());
        centerPanel.add(new JPanel());
        
        JButton register=new JButton("Register Now");
        
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Register(staffList);
            }
        });
        
        centerPanel.add(register);
        aPanel.add(centerPanel, BorderLayout.CENTER);
        
        

        this.add(aPanel);
        this.setVisible(true);
        
	}
	
}
