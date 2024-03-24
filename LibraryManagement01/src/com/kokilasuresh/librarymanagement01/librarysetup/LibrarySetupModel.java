package com.kokilasuresh.librarymanagement01.librarysetup;

import com.kokilasuresh.librarymanagement01.librarydb.LibraryDb;
import com.kokilasuresh.librarymanagement01.model.Library;

public class LibrarySetupModel {
	private LibrarySetupView librarySetupView;
	private Library library;
	LibrarySetupModel(LibrarySetupView librarySetupView) {
		this.librarySetupView = librarySetupView;
	
	}
	public void startSetup() {
		if (library == null || library.getLibraryId() == 0) {
			librarySetupView.initiateSetup();
		} else {
			librarySetupView.onSetupComplete(library);
		}
		
	}
	public void createLibrary(Library library) {
		
		if (library.getLibraryName().length() <3  || library.getLibraryName().length() > 50) {
			librarySetupView.showAlert("Enter valid name");
			return;
		}
		this.library = LibraryDb.getInstance().insertLibrary(library);		
		librarySetupView.onSetupComplete(library);	
	}

}
