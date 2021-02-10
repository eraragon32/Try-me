package com.vastika.uis.controller;

import java.util.List;

import javax.swing.JOptionPane;

import com.vastika.uis.model.User;
import com.vastika.uis.service.UserService;
import com.vastika.uis.service.UserServiceImpl;

public class UserController {

	public static void main(String[] args) {
		
		UserService userService =new UserServiceImpl();
		String decision="";
		
		do {
			String choice =JOptionPane.showInputDialog("Enter choice : save | update | delete | list| get");
			
			switch (choice) {
			case "save":
				User user = getUser();
				
				int saved = userService.saveUserInfo(user);
				if(saved>=1) {
					
					
					JOptionPane.showMessageDialog(null, "User info is saved sucessfully in db.");
				}else {
					JOptionPane.showMessageDialog(null, "Error in db.");			
					
				}

				
				break;
				
			case "update":
				User updatedUser = getUser();
				
				int id =Integer.parseInt( JOptionPane.showInputDialog("Enter Id:"));
				updatedUser.setId(id);
				int updated = userService.updateUserInfo(updatedUser);
				if(updated>=1) {
					
					
					JOptionPane.showMessageDialog(null, "User info is updated sucessfully in db.");
				}else {
					JOptionPane.showMessageDialog(null, "Error in db.");			
					
				}
				break;
				
			case "delete":
			
				
				 id =Integer.parseInt( JOptionPane.showInputDialog("Enter Id:"));
				int deleted =userService.deleteUserInfo(id);
				if(deleted>=1) {
					
					
					JOptionPane.showMessageDialog(null, "User info is delete sucessfully in db.");
				}else {
					JOptionPane.showMessageDialog(null, "Error in db.");			
					
				}
				break;
				
			case "list":
				List<User> userList =userService.getAllUserInfo();
				for(User u: userList) {
					System.out.println("User id is:"+u.getId());
					System.out.println("User name is:"+u.getUsername());
					System.out.println("User password is:"+u.getPassword());
					System.out.println("User Mobile No is:"+u.getMobileNo());
					System.out.println("User salary is:"+u.getSalary());
					System.out.println("is User active? :"+u.isActive());
					System.out.println("===============================");
					
				}
				break;
				
			case "get": 
				id =Integer.parseInt( JOptionPane.showInputDialog("Enter Id:"));
				User u =userService.getUserById(id);
				
					System.out.println("User id is:"+u.getId());
					System.out.println("User name is:"+u.getUsername());
					System.out.println("User password is:"+u.getPassword());
					System.out.println("User Mobile No is:"+u.getMobileNo());
					System.out.println("User salary is:"+u.getSalary());
					System.out.println("is User active? :"+u.isActive());
					System.out.println("===============================");
				
				break;
				
			default:
				JOptionPane.showMessageDialog(null, "wrong choice");
				break;
			
			}
			decision =JOptionPane.showInputDialog("if you want to prefoem next optraion press'yes'");
			
			   
			
			
			
			
			
			
		}while(decision.equalsIgnoreCase("yes"));
		
		JOptionPane.showMessageDialog(null, "Bye Bye Bye");
		
		
		
		
		

	}
	
	public static User getUser() {
		
		User user = new User();
		String username = JOptionPane.showInputDialog("Enter Username:");
		String password = JOptionPane.showInputDialog("Enter password:");
		long mobileNo= Long.parseLong(JOptionPane.showInputDialog("Enter mobile no:"));
		double salary   =Double.parseDouble(JOptionPane.showInputDialog("Enter salary:"));
		boolean isActive = Boolean.parseBoolean(JOptionPane.showInputDialog("Enter is user Active:"));
	
		user.setUsername(username);
		user.setPassword(password);
		user.setMobileNo(mobileNo);
		user.setActive(isActive);
		user.setSalary(salary);
		
		return user;
		
	}

}
