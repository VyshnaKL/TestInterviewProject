package com.obsquara.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class LoginPageDemoPage {
	WebDriver driver;

	public LoginPageDemoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement usenameFieldTextBox;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passwordFieldTextBox;

	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signInButtonClick;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertBoxMessage;

	@FindBy(xpath = "//input[@id='remember']")
	WebElement rememberMe;

	public LoginPageDemoPage enterNameInUsernameField(String input) {
		PageUtility.enterText(usenameFieldTextBox, input);
		return this;
	}

	public LoginPageDemoPage enterTextInPasswordField(String input) {
		PageUtility.enterText(passwordFieldTextBox, input);
		return this;
	}

	public LoginPageDemoPage clickSignInButton() {
		PageUtility.clickOnElement(signInButtonClick);
		return this;
	}

	public LoginPageDemoPage clickRememberMe() {
		WaitUtility.waitForElementClickable(driver, rememberMe);
		PageUtility.clickOnElement(rememberMe);
		return this;
	}

	public boolean isRememberMeEnabled() {
		return PageUtility.isElementEnabled(rememberMe);
	}

	public boolean usernameFieldDisplayed() {
		return PageUtility.isDisplay(usenameFieldTextBox);
	}

	public boolean passwordFieldDisplayed() {
		return PageUtility.isDisplay(passwordFieldTextBox);
	}

	public boolean alertBoxMessageDisplayed() {
		return PageUtility.isDisplay(alertBoxMessage);
	}

	public String getValidationMessage(String name) {
		return PageUtility.getValidationMessage(driver, name);
	}
}
