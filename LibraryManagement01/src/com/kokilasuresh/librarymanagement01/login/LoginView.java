
package com.kokilasuresh.librarymanagement01.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kokilasuresh.librarymanagement01.LibraryManagement01;
import com.kokilasuresh.librarymanagement01.librarysetup.LibrarySetupView;
import com.kokilasuresh.librarymanagement01.model.User;

public class LoginView {
	
private LoginModel loginModel;
Scanner sc=new Scanner(System.in);
private List<User> userList = new ArrayList<>();
private static int userIdCounter = 100;
private User registeredUser;
	public LoginView() {
		loginModel=new LoginModel(this);
	}
	public void init() {
	
		System.out.println("--- " + LibraryManagement01.getInstance().getAppName() + " --- \nversion "
				+ LibraryManagement01.getInstance().getAppVersion());
		System.out.println("*****************************************************");
		
		System.out.println("\n\nPlease to proceed.");
		System.out.println("1.Register");
		System.out.println("2.Login");
		System.out.println("3.Admin");
		System.out.println("4.Exit");
		System.out.println("Enter Your Option:");
		int option=sc.nextInt();
		switch(option) {
		case 1:
			
			register();
			break;
		case 2:
		
			proceedLogin();
			break;
		case 3:
			
			admin();
			break;
		default:
			System.out.println("Thank you for visting");
			System.exit(0);
		}
		
	}
	
	public  void register() {
		System.out.println("Welcome to Registartion");
		User u=new User();
		u.setId(userIdCounter++);
		sc.nextLine();
		System.out.print("Enter your name:");
		u.setName(sc.nextLine());
		System.out.print("Enter your password:");
		u.setPassword(sc.nextLine());
		System.out.print("Enter your Phone number:");
		u.setPhoneNo(sc.nextLine());
		System.out.print("Enter your email id:");
		u.setEmailId(sc.nextLine());
		System.out.print("Enter your address:");
		u.setAddress(sc.nextLine());
		userList.add(u);
		
		if (u.getName()!=null&&u.getName()!="") {
	        	displayUserList();
	            System.out.println("Registration successful!");
	            System.out.println("If you want to another user:Yes/No");
	            againAdd();
	        } else {
	            System.out.println("Invalid username or password. Registration failed.");
	        }
	
	
	}

private void proceedLogin() {
		System.out.println("Welcome to User");
		System.out.println("Enter your User Name:");
		String userName=sc.nextLine();
		sc.nextLine();
		System.out.println("Enter your Password:");
		String password=sc.nextLine();
		loginModel.validateUser(userName, password);
		}
private void admin() {
	System.out.println("Welcome to Admin Page");
	

}
private void againAdd() {
	Scanner scanner = new Scanner(System.in);
	String choice = scanner.next();
	if (choice.equalsIgnoreCase("yes")) {
		register();
	} else if (choice.equalsIgnoreCase("no")) {
		System.out.println("\n ---- Thanks You ----");
		System.out.println("Go back to Main Menu");
		init();}

}
public void displayUserList() {
    System.out.println("User List:");
    
    for (User user : userList) {
        System.out.println("User ID: " + user.getId());
        System.out.println("Name: " + user.getName());
        System.out.println("Phone number: " + user.getPhoneNo());
        System.out.println("Email ID: " + user.getEmailId());
        System.out.println("Address: " + user.getAddress());
        System.out.println("------------------------");
    }
}
public void onLoginFailed(String alertText) {
	System.out.println(alertText);
	checkForLogin();
}

private void checkForLogin() {
	System.out.println("Do you try again? \nType Yes/No");
	Scanner scanner = new Scanner(System.in);
	String choice = scanner.next();
	if (choice.equalsIgnoreCase("yes")) {
		proceedLogin();
	} else if (choice.equalsIgnoreCase("no")) {
		System.out.println("\n ---- Thanks You ----");
	} else {
		System.out.println("\nInvalid choice, Please enter valid choice.\n");
		checkForLogin();
	}
}
public void onSuccess() {
	System.out.flush();
	System.out.println(
			"\n\nLogin successful...\n\n ---- welcome to " + LibraryManagement01.getInstance().getAppName()
					+ " - v" + LibraryManagement01.getInstance().getAppVersion() + "----");
	LibrarySetupView librarySetupView = new LibrarySetupView();
	librarySetupView.init();
}

}