package com.kokilasuresh.librarymanagement01.manageuser;

import java.util.Scanner;

import com.kokilasuresh.librarymanagement01.model.User;

public class ManageUserView {

	private ManageUserModel manageUserModel;

	public ManageUserView() {
		manageUserModel = new ManageUserModel(this);
	}

	public void initAdd() {
		System.out.println("Enter the following user Details: ");
		Scanner scanner = new Scanner(System.in);
		User user = new User();
		System.out.println("\nEnter user name:");
		user.setName(scanner.nextLine());
		System.out.println("\nEnter user emailId:");
		user.setEmailId(scanner.next());
		manageUserModel.addNewUser(user);
	}

	public void showLibraryName(String libraryName) {
		System.out.println("Current Library Name - " + libraryName);
	}

	public void onUserAdded(User user) {
		System.out.println("\n------- User '" + user.getName() + "' added successfully ------- \n");
		checkForAddNewUser();
	}

	public void onUserExist(User user) {
		System.out.println("\n------- User '" + user.getName() + "' already exist -------\n");
		checkForAddNewUser();
	}

	private void checkForAddNewUser() {
		System.out.println("Do you want to add more users? \nType Yes/No");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.next();
		if (choice.equalsIgnoreCase("yes")) {
			initAdd();
		} else if (choice.equalsIgnoreCase("no")) {
			System.out.println("\n Thanks for adding users");
		} else {
			System.out.println("\nInvalid choice, Please enter valid choice.\n");
			checkForAddNewUser();
		}
	}
}