package com.obsquara.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelUtility;
import Utilities.PageUtility;
import constants.Constants;

public class LoginSuccess {
	WebDriver driver;

	public LoginSuccess(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement usenameFieldTextBox;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passwordFieldTextBox;

	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signInButtonClick;

	public WebElement enterNameInUsernameField(String input) {
		return PageUtility.enterText(usenameFieldTextBox, input);
	}

	public WebElement enterTextInPasswordField(String input) {
		return PageUtility.enterText(passwordFieldTextBox, input);
	}

	public void clickSignInButton() {
		PageUtility.clickOnElement(signInButtonClick);
	}

	public void login() throws IOException {
		String username = ExcelUtility.getString(0, 0, System.getProperty("user.dir") + Constants.EXCELFILE,
				"LoginCredentials");
		String password = ExcelUtility.getString(0, 1, System.getProperty("user.dir") + Constants.EXCELFILE,
				"LoginCredentials");
		enterNameInUsernameField(username);
		enterTextInPasswordField(password);
		clickSignInButton();
	}

}
