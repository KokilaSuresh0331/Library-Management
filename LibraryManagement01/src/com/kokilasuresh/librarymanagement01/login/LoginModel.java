package com.kokilasuresh.librarymanagement01.login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginModel {
	
	private LoginView loginView;
	private static final String USERNAME_PATTERN = "^[a-zA-Z0-9_]{5,20}$"; // Alphanumeric characters and underscores, 5-20 characters long
	private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$"; // At least one digit, one lowercase letter, one uppercase letter, 8-20 characters long

	
public LoginModel(LoginView loginView) {
	this.loginView=loginView;
}
public void validateUser(String userName,String password) {
	if (isValidUserName(userName)) {
		if (isValidPassword(userName,password)) {
			loginView.onSuccess();
		} else {
			loginView.onLoginFailed("Invalid password");
		}
	} else {
		loginView.onLoginFailed("Invalid User Name");
	}
}

// this method should be private because this method used only with in this
// class.
private boolean isValidUserName(String userName) {
	return userName.equals(userName);
}

// this method should be private because this method used only with in this
// class.
private boolean isValidPassword(String userName, String password) {
	return (userName.equals(userName)&&password.equals(password));
}
}

