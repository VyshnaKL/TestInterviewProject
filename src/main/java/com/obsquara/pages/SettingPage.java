package com.obsquara.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class SettingPage {
	WebDriver driver;

	public SettingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Old Password']")
	WebElement oldPassword;

	@FindBy(xpath = "//input[@placeholder='New Password']")
	WebElement newPassword;

	@FindBy(xpath = "//input[@placeholder='Confirm Password']")
	WebElement confirmPassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement changeButton;

	@FindBy(xpath = "//a[@class=' nav-link ']")
	WebElement changePassword;

	@FindBy(xpath = "//a[@class='active highlight nav-link']//parent::li[@class='nav-item']")
	WebElement manageMenu;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButtonOption;

	@FindBy(xpath = "//input[@id='name']")
	WebElement menuName;

	@FindBy(xpath = "//select[@id='menu_id']")
	WebElement parentMenu;

	@FindBy(xpath = "")
	WebElement urlLink;

	@FindBy(xpath = "")
	WebElement faIcon;

	@FindBy(xpath = "")
	WebElement tableName;

	@FindBy(xpath = "")
	WebElement menuOrder;

	@FindBy(xpath = "")
	WebElement activeFiles;

	@FindBy(xpath = "")
	WebElement displayColor;

	@FindBy(xpath = "")
	WebElement setHomeYes;

	@FindBy(xpath = "")
	WebElement setHomeNo;

	public SettingPage enterOldPassword(String input) {
		PageUtility.enterText(oldPassword, input);
		return this;
	}

	public SettingPage enterNewPassword(String input) {
		PageUtility.enterText(newPassword, input);
		return this;
	}

	public SettingPage enterConfirmPassword(String input) {
		PageUtility.enterText(confirmPassword, input);
		return this;
	}

	public SettingPage clickChangeButton() {
		PageUtility.clickOnElement(changeButton);
		return this;
	}

	public SettingPage clickChangePassword() {
		PageUtility.clickOnElement(changePassword);
		return this;
	}

	public boolean confirmationDisplayed() {
		return PageUtility.isDisplay(confirmPassword);
	}

	public SettingPage clickManageMenu() {
		PageUtility.clickOnElement(manageMenu);
		return this;
	}

	public SettingPage clickNewButton() {
		PageUtility.clickOnElement(newButtonOption);
		return this;

	}

}
