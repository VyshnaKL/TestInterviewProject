package com.obsquara.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class ManageUserPage {
	WebDriver driver;

	public ManageUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Manage Users']//parent::a")
	WebElement manageUser;

	@FindBy(xpath = "//i[@class='fa fa-angle-double-down']")
	WebElement passwordDetail;

	@FindBy(xpath = "//span[text()='Active']")
	WebElement activeButton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;

	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger']")
	WebElement redSearchbutton;

	@FindBy(xpath = "//input[@id='un']")
	WebElement nameField;

	@FindBy(xpath = "//div[@class='profile-info-name']")
	WebElement resultPassword;

	public ManageUserPage clickonManagerUserElement() {
		PageUtility.clickOnElement(manageUser);
		return this;
	}

	public ManageUserPage clickonPasswordDetailElement() {
		PageUtility.clickOnElement(passwordDetail);
		return this;

	}

	public boolean PasswordShownDetailsDisplayed() {
		return PageUtility.isElementDisplayed(passwordDetail);
	}

	public ManageUserPage clickSearchButtn() {
		PageUtility.clickOnElement(searchButton);
		return this;

	}

	public ManageUserPage clickonRedSearchButton() {
		PageUtility.clickOnElement(redSearchbutton);
		return this;
	}

	public ManageUserPage enterNameinSearchListUser(String input) {
		PageUtility.enterText(nameField, input);
		return this;
	}

	public boolean isDisplayedResultPassword() {
		return PageUtility.isDisplay(resultPassword);
	}
}
