package comp5134ass1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Register extends JFrame{

	ArrayList<Staff> staffList;

	public Register(ArrayList<Staff> staffList){
		super("New user registration");
		this.staffList=staffList;
		buildUI();

	}
	
	public void buildUI(){
		this.setSize(500, 300);
	    this.setLocation(100, 100);

	    JPanel aPanel = new JPanel(new BorderLayout());
	    JPanel topPanel = new JPanel();
	    topPanel.add(new JLabel("Staff Registration"));
	    aPanel.add(topPanel, BorderLayout.NORTH);
	    JPanel centerPanel = new JPanel(new GridLayout(8, 3, 5, 10));

	    for (int i = 0; i < 3; i++) {
	        centerPanel.add(new JPanel());
	    }
	    
	    centerPanel.add(new JLabel("Username", SwingConstants.RIGHT));
	    final JTextField usernameTextField = new JTextField("", 20);
	    centerPanel.add(usernameTextField);
	    centerPanel.add(new JPanel());
	    centerPanel.add(new JLabel("Password", SwingConstants.RIGHT));
	    final JTextField passwordTextField = new JTextField("", 20);
	    centerPanel.add(passwordTextField);
	    centerPanel.add(new JPanel());
	    centerPanel.add(new JLabel("Staff Name", SwingConstants.RIGHT));
	    final JTextField nameTextField = new JTextField("", 20);
	    centerPanel.add(nameTextField);
	    centerPanel.add(new JPanel());
	    centerPanel.add(new JLabel("Supervisor username", SwingConstants.RIGHT));
	    final JTextField supervisorTextField = new JTextField("", 20);
	    centerPanel.add(supervisorTextField);
	    centerPanel.add(new JPanel());  
	   
	    centerPanel.add(new JPanel());
	    JButton register = new JButton("Register");
	    register.addActionListener(new ActionListener() {
	        
			public void actionPerformed(ActionEvent e) {
				
				Staff newStaff=null;
				String sUsername = supervisorTextField.getText();
				Staff supervisor=null;
				Boolean sExist=false;
				Boolean uExist=false;
				
				for(Staff s:staffList){
					if(s.getUsername().equals(usernameTextField.getText())){
						JOptionPane.showMessageDialog(Register.this, "Username has been used. Please select another username");
						uExist=true;
					}
				}
				
				if (sUsername.trim().equals("")||supervisorTextField.getText()==null) {
	            	
	            	if (Director.checkInstance()==true){
	            		newStaff= Director.getInstance(usernameTextField.getText(), nameTextField.getText(), passwordTextField.getText());
	            		staffList.add(newStaff);
	            		JOptionPane.showMessageDialog(Register.this, "User "+ newStaff.getUsername() +" has been created.");
						
	            	}
	            	else{
	                	JOptionPane.showMessageDialog(Register.this, "Please enter supervisor name");}
	            } else {
	            	
	            	for (Staff s: staffList){
	    				
	    				if(s.getUsername().equals(sUsername)){
	    					supervisor=s;
	    					sExist=true;
	    				}
	    				
	    				
	    			}
	            	if(sExist&&uExist==false){
	            		newStaff= new Staff(usernameTextField.getText(), nameTextField.getText(), passwordTextField.getText(), supervisor);
	            		staffList.add(newStaff);
						JOptionPane.showMessageDialog(Register.this, "User "+ newStaff.getUsername() +" has been created.");
						
	            	} else if(sExist=false){
	            		JOptionPane.showMessageDialog(Register.this, "User "+sUsername+" doesn't exist");          	
	            	}
	    			
	           
	            }
	            
	        }
	    });
	    centerPanel.add(register);
	    centerPanel.add(new JPanel());
	    for (int i = 0; i < 6; i++) {
	        centerPanel.add(new JPanel());
	    }
	    aPanel.add(centerPanel, BorderLayout.CENTER);

	    this.add(aPanel);
	    this.setVisible(true);
	}

}
