package com.obsquara.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManageDeliveryBoyPage {
	WebDriver driver;

	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(xpath = "//input[@id='name']")
	WebElement nameField;

	@FindBy(xpath = "//input[@id='email']")
	WebElement emailField;

	@FindBy(xpath = "//input[@id='phone']")
	WebElement phoneNumberField;

	@FindBy(xpath = "//textarea[@id='address']")
	WebElement addressField;

	@FindBy(xpath = "//input[@id='username']")
	WebElement usernameField;

	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordField;

	@FindBy(xpath = "//button[@name='create']")
	WebElement saveButton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;

	@FindBy(xpath = "//button[@name='Search']")
	WebElement redSearchButton;

	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
	WebElement cancelButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody")
	WebElement tableBody;

	@FindBy(xpath = "//input[@id='un']")
	WebElement searchName;

	@FindBy(xpath = "//input[@id='ut']")
	WebElement searchEmail;

	@FindBy(xpath = "//input[@id='ph']")
	WebElement searchPhone;

	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deleteButton;

	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement editButton;

	@FindBy(xpath = "//div[@class='card-body']")
	WebElement enterDeliveryBoyInformation;

	@FindBy(xpath = "//button[@name='update']")
	WebElement upDateButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessageBox;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetButton;

	@FindBy(xpath = "//div[@class='hide_div']")
	WebElement searchListBox;

	public void clickNewButton() {
		PageUtility.ScrollAndClickOnElement(newButton, driver);
	}

	public void clickEditButton() {
		PageUtility.clickOnElement(editButton);
	}

	public void clickSaveButton() throws InterruptedException {
		WaitUtility.implicitWait();
		PageUtility.ScrollAndClickOnElement(saveButton, driver);
	}

	public void scrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}

	public void clickDeleteButton() throws InterruptedException {
		WaitUtility.implicitWait();
		PageUtility.clickOnElement(deleteButton);
	}

	public WebElement enterSearchName(String input) {
		return PageUtility.enterText(searchName, input);
	}

	public void clickSearchButton() {
		PageUtility.clickOnElement(searchButton);
	}

	public void enterName(String name) {
		PageUtility.sendKey(nameField, name);
	}

	public void enterEmail(String email) {
		PageUtility.sendKey(emailField, email);
	}

	public void enterPhone(String phone) {
		PageUtility.sendKey(phoneNumberField, phone);
	}

	public void enterAddress(String address) {
		PageUtility.sendKey(addressField, address);
	}

	public void enterUsername(String username) {
		PageUtility.sendKey(usernameField, username);
	}

	public void enterPassword(String password) {
		PageUtility.sendKey(passwordField, password);
	}

	public void clickRedSearchButton() {
		PageUtility.clickOnElement(redSearchButton);
	}

	public void clickCancelButton() {
		PageUtility.clickOnElement(cancelButton);
	}

	public boolean isAlertMessageDisplayed() {
		return PageUtility.isDisplay(alertMessageBox);
	}

	public boolean isEditPageDisplayed() {
		return PageUtility.isDisplay(enterDeliveryBoyInformation);
	}

	public boolean isSearchListBoxDisplayed() {
		return PageUtility.isDisplay(searchListBox);
	}

	public void clickResetButton() {
		PageUtility.clickOnElement(resetButton);
	}

	public void clickUpdateButton() throws InterruptedException {
		WaitUtility.implicitWait();
		PageUtility.ScrollAndClickOnElement(upDateButton, driver);
	}

	public WebElement enterNameField(String input) {
		return PageUtility.enterText(nameField, input);
	}

	public WebElement enterEmailField(String input) {
		return PageUtility.enterText(emailField, input);
	}

	public WebElement enterUserNameField(String input) {
		return PageUtility.enterText(usernameField, input);
	}

	public WebElement enterAddressField(String input) {
		return PageUtility.enterText(addressField, input);
	}

	public WebElement enterPasswordField(String input) {
		return PageUtility.enterText(passwordField, input);
	}

	public WebElement enterPhoneNumberField(String input) {
		return PageUtility.enterText(phoneNumberField, input);
	}

	public boolean saveButtonisEnabled() {
		return PageUtility.isElementEnabled(saveButton);
	}

	public boolean cancelButtonisEnabled() {
		return PageUtility.isElementEnabled(cancelButton);
	}

	public boolean isNameEnabled() {
		return PageUtility.isEnabled(nameField);
	}

	public boolean isEmailEnabled() {
		return PageUtility.isEnabled(emailField);
	}

	public boolean isAddressEnabled() {
		return PageUtility.isEnabled(addressField);
	}

	public boolean isPhoneNumEnabled() {
		return PageUtility.isEnabled(phoneNumberField);
	}

	public boolean isUserNameEnabled() {
		return PageUtility.isEnabled(usernameField);
	}

	public boolean isPasswordEnabled() {
		return PageUtility.isEnabled(passwordField);
	}

	public boolean checkTitle(String title) {
		List<WebElement> rows = PageUtility.findRowElements(tableBody);
		for (WebElement row : rows) {
			if (row.getText().contains(title))
				return true;
		}
		return false;
	}

	public void addNewDeliveryBoy(DeliveryBoyUser user) throws IOException, InterruptedException {
		clickNewButton();
		enterNameField(user.getName());
		enterEmailField(user.getEmail());
		enterPhoneNumberField(user.getPhonenumber());
		enterAddressField(user.getAddress());
		enterUserNameField(user.getUsername());
		enterPasswordField(user.getPassword());
		scrollToBottom();
		clickSaveButton();
	}

	public void deleteDeliveryBoy(String searchName) throws InterruptedException {
		clickSearchButton();
		enterSearchName(searchName);
		clickRedSearchButton();
		clickDeleteButton();
		WaitUtility.implicitWait();
		driver.switchTo().alert().accept();
		WaitUtility.implicitWait();
	}

}
