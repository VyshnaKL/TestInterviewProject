package com.obsquara.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class AdminUserPage {
	WebDriver driver;

	public  AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@id='username']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement userPassword;
	
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement userType;
	
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertBox;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	
	
	public void clickonNewUser() {
		PageUtility.clickOnElement(newButton);
	}
	
	public WebElement enterUserNameField(String input) {

		return PageUtility.enterText(userName, input);
	}
	
	public WebElement enterPasswordField(String input) {

		return PageUtility.enterText(userPassword, input);
	}
	
	public void clickonSaveNotification() {
		PageUtility.clickOnElement(saveButton);
	}
	 public void selectbyDropdownIndex() {
		 PageUtility.selectDropdownbyIndex(userType, 1);
	 }

	
	
	
}
