package com.kokilasuresh.librarymanagement01.managebook;

import java.util.Scanner;

import com.kokilasuresh.librarymanagement01.model.Book;

public class ManageBookView {
	private ManageBookModel manageBookModel;

	public ManageBookView() {
		manageBookModel = new ManageBookModel(this);
	}

	public void initAdd() {
		System.out.println("\nEnter book details: ");
		Scanner scanner = new Scanner(System.in);
		Book book = new Book();
		System.out.println("\nEnter book name:");
		book.setName(scanner.nextLine());
		System.out.println("\nEnter book author:");
		book.setAuthor(scanner.nextLine());
		manageBookModel.addNewBook(book);
	}

	public void showLibraryName(String libraryName) {
		System.out.println("Current Library Name - " + libraryName);
	}

	public void onBookAdded(Book book) {
		System.out.println("\n------- Book '" + book.getName() + "' added successfully ------- \n");
		checkForAddNewBook();
	}

	public void onBookExist(Book book) {
		System.out.println("\n------- Book '" + book.getName() + "' already exist -------\n");
		checkForAddNewBook();
	}

	private void checkForAddNewBook() {
		System.out.println("\nDo you want to add more books? \nType Yes/No");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.next();
		if (choice.equalsIgnoreCase("yes")) {
			initAdd();
		} else if (choice.equalsIgnoreCase("no")) {
			System.out.println("\n Thanks for adding books");
		} else {
			System.out.println("\nInvalid choice, Please enter valid choice.\n");
			checkForAddNewBook();
		}
	}

}
