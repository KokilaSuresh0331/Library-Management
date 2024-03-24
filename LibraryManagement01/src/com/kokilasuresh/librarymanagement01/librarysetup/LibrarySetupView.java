package com.kokilasuresh.librarymanagement01.librarysetup;

import java.util.Scanner;

import com.kokilasuresh.librarymanagement01.LibraryManagement01;
import com.kokilasuresh.librarymanagement01.login.LoginView;
import com.kokilasuresh.librarymanagement01.manageuser.ManageUserView;
import com.kokilasuresh.librarymanagement01.model.Library;

public class LibrarySetupView {
	private LibrarySetupModel librarySetupModel;
	public LibrarySetupView() {
		librarySetupModel = new LibrarySetupModel(this);
	}
	public void init() {
		librarySetupModel.startSetup();
		
	}
	public void onSetupComplete(Library library) {
		System.out.println("\nLibrary setup completed\n");
		System.out.println("\nCurrent Library Name - " + library.getLibraryName());
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println(
					"\n 1. Add Book\n 2. Add user \n 3. Search Book \n 9. Logout \n 0. Exit \n Enter your Choice:");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				new ManageUserView().initAdd();
				break;
			case 2:
				new ManageUserView().initAdd();
				break;
			case 3:
				System.out.println("\nSearch Book Feature is under development\nPlease choose some other option.\n");
				// new SearchBook().initSearch();
				break;
			case 9:
				System.out.println("\n-- You are logged out successfully -- \n\n");
				new LoginView().init();
				return; // Exit from the current session
			case 0:
				System.out.println("\n-- Thanks for using " + LibraryManagement01.getInstance().getAppName() + " --");
				return; // Exit from the application
			default:
				System.out.println("\nPlease Enter valid choice\n");
			}
		}
	}

	public void showAlert(String alert) {
		System.out.println(alert);
		initiateSetup();
	}

	public void initiateSetup() {
		System.out.println("\n\nEnter library details:");
		Scanner scanner = new Scanner(System.in);
		Library library = new Library();
		System.out.println("\nEnter library name:");
		library.setLibraryName(scanner.nextLine());
		System.out.println("\nEnter library email:");
		library.setEmailId(scanner.nextLine());
		librarySetupModel.createLibrary(library);
	}
}
