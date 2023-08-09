package com.obsquara.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class AdminUserPage {
	WebDriver driver;

	public AdminUserPage(WebDriver driver) {
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

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody")
	WebElement tableBody;

	@FindBy(xpath = "//input[@id='un']")
	WebElement searchName;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;

	@FindBy(xpath = "//button[@name='Search']")
	WebElement redSearchButton;

	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deleteButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessageBox;

	public AdminUserPage clickonNewUser() {
		PageUtility.clickOnElement(newButton);
		return this;
	}

	public AdminUserPage enterUserNameField(String input) {

		PageUtility.enterText(userName, input);
		return this;
	}

	public AdminUserPage enterPasswordField(String input) {

		PageUtility.enterText(userPassword, input);
		return this;
	}

	public AdminUserPage clickonSaveNotification() {
		PageUtility.clickOnElement(saveButton);
		return this;
	}

	public AdminUserPage selectbyDropdownIndex() {
		PageUtility.selectDropdownbyIndex(userType, 1);
		return this;
	}

	public AdminUserPage enterSearchName(String input) {
		PageUtility.enterText(searchName, input);
		return this;
	}

	public AdminUserPage clickRedSearchButton() {
		PageUtility.clickOnElement(redSearchButton);
		return this;
	}

	public AdminUserPage clickDeleteButton() throws InterruptedException {
		WaitUtility.implicitWait();
		PageUtility.clickOnElement(deleteButton);
		return this;
	}

	public AdminUserPage clickSearchButton() {
		PageUtility.clickOnElement(searchButton);
		return this;
	}

	public boolean isAlertMessageDisplayed() {
		return PageUtility.isDisplay(alertMessageBox);
	}

	public boolean checkTitle(String title) {
		List<WebElement> rows = PageUtility.findRowElements(tableBody);
		for (WebElement row : rows) {
			if (row.getText().contains(title))
				return true;
		}
		return false;
	}

	public void deleteAdminUser(String username, String password, String searchName) throws InterruptedException {
		clickonNewUser().enterUserNameField(username).enterPasswordField(password).selectbyDropdownIndex()
				.clickonSaveNotification().clickSearchButton().enterSearchName(searchName).clickRedSearchButton()
				.clickDeleteButton();
		WaitUtility.implicitWait();
		driver.switchTo().alert().accept();
		WaitUtility.implicitWait();
	}

}
