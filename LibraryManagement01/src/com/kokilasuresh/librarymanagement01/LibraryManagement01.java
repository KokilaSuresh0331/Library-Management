package com.kokilasuresh.librarymanagement01;

import com.kokilasuresh.librarymanagement01.login.LoginView;

public class LibraryManagement01 {
	private static LibraryManagement01 libraryManagement;
	private String appName = "Library Management System";
	private String appVersion = "0.0.1";

	private LibraryManagement01() {

	}

	public static LibraryManagement01 getInstance() {

		if (libraryManagement == null) {
			libraryManagement = new LibraryManagement01();
		}

		return libraryManagement;

	}

	private void create() {
		LoginView loginView = new LoginView();
		loginView.init();
	}

	public String getAppName() {
		return appName;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public static void main(String[] args) {
		LibraryManagement01.getInstance().create();
	}

}
