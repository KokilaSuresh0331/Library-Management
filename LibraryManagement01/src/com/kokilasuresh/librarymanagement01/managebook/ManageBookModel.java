package com.kokilasuresh.librarymanagement01.managebook;

import com.kokilasuresh.librarymanagement01.librarydb.LibraryDb;
import com.kokilasuresh.librarymanagement01.model.Book;

public class ManageBookModel {

	private ManageBookView manageBookView;

	ManageBookModel(ManageBookView manageBookView) {
		this.manageBookView = manageBookView;
	}

	public void addNewBook(Book book) {
		if (LibraryDb.getInstance().insertBook(book)) {
			manageBookView.onBookAdded(book);
		} else {
			manageBookView.onBookExist(book);
		}
	}
}