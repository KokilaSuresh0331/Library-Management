package com.kokilasuresh.librarymanagement01.librarydb;

import java.util.ArrayList;
import java.util.List;

import com.kokilasuresh.librarymanagement01.model.Book;
import com.kokilasuresh.librarymanagement01.model.Library;
import com.kokilasuresh.librarymanagement01.model.User;

public class LibraryDb {
	private static LibraryDb libraryDatabase;

	private Library library;
	private List<Book> bookList = new ArrayList();
	private List<User> userList = new ArrayList();

	public static LibraryDb getInstance() {

		if (libraryDatabase == null) {
			libraryDatabase = new LibraryDb();
		}
		return libraryDatabase;
	}

	public Library getLibrary() {
		return library;// SQL query and it's result here.
	}

	public Library insertLibrary(Library library2) {
		this.library = library2;
		this.library.setLibraryId(1);
		return library;
	}

	public List<Book> getAllBooks() {
		return bookList;
	}

	public Book getBook(int bookId) {
		for (Book book : bookList) {
			if (book.getId() == bookId) {
				return book;
			}
		}
		// select query with where condition.
		return null;
	}

	public List<Book> searchBooks(String bookName) {
		List<Book> searchResult = new ArrayList();
		for (Book book : bookList) {
			if (book.getName().contains(bookName)) {
				searchResult.add(book);
			}
		}
		// select query with where condition.
		return searchResult;
	}

	public boolean insertBook(Book book) {
		boolean hasBook = false;
		for (Book addedBook : bookList) {
			if (addedBook.getName().equals(book.getName()) && addedBook.getAuthor().equals(book.getAuthor())) {
				hasBook = true;
				break;
			}
		}
		if (hasBook) {
			return false;
		} else {
			bookList.add(book);
			return true;
		}
	}

	public boolean insertUser(User user) {
		boolean hasUser = false;
		for (User addedUser : userList) {
			if (addedUser.getEmailId().equals(user.getEmailId())) {
				hasUser = true;
				break;
			}
		}
		if (hasUser) {
			return false;
		} else {
			userList.add(user);
			return true;
		}
	}
}