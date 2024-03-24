package com.kokilasuresh.librarymanagement01.manageuser;

import com.kokilasuresh.librarymanagement01.librarydb.LibraryDb;
import com.kokilasuresh.librarymanagement01.model.User;

public class ManageUserModel {
	private ManageUserView manageUsersView;

	ManageUserModel(ManageUserView manageUserView) {
		this.manageUsersView = manageUsersView;
	}

	public void addNewUser(User user) {
		if (LibraryDb.getInstance().insertUser(user)) {
			manageUsersView.onUserAdded(user);
		} else {
			manageUsersView.onUserExist(user);
		}
	}
}