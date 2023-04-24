package com.obsquara.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class PushNotificationPage {
	WebDriver driver;

	public PushNotificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='title']")
	WebElement titleField;

	@FindBy(xpath = "//a[@class='active nav-link']")
	WebElement pushNotification;

	@FindBy(xpath = "//input[@id='description']")
	WebElement descriptionField;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement sendButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessageBox;

	public PushNotificationPage enterTitleField(String input) {
		PageUtility.enterText(titleField, input);
		return this;
	}

	public PushNotificationPage enterDescriptionField(String input) {
		PageUtility.enterText(descriptionField, input);
		return this;

	}

	public PushNotificationPage clickonPushNotification() {
		PageUtility.clickOnElement(pushNotification);
		return this;
	}

	public PushNotificationPage clickSendButton() {
		PageUtility.clickOnElement(sendButton);
		return this;
	}

	public boolean isTitleFieldDisplayed() {
		return PageUtility.isDisplay(titleField);
	}

	public boolean isDescriptionFieldDisplayed() {
		return PageUtility.isDisplay(descriptionField);
	}

	public boolean isAlertMessageDisplayed() {
		return PageUtility.isDisplay(alertMessageBox);
	}

}
