package com.obsquara.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

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

	//@FindBy(xpath = "///a[@class='active highlight nav-link']//following::p[text()='Manage Menu']")
	//WebElement manageMenu;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement addNewOption;
	
	@FindBy(xpath = "//input[@id='url']")
	WebElement urlLink;

	@FindBy(xpath = "//input[@id='icon']")
	WebElement faIcon;

	@FindBy(xpath = "//input[@id='menu_table']")
	WebElement tableName;

	@FindBy(xpath = "//input[@id='menu_order']")
	WebElement menuOrder;

	@FindBy(xpath = "//input[@id='active_file']")
	WebElement activeFiles;

	@FindBy(xpath = "//input[@id='menu_color']")
	WebElement displayColor;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(xpath = "//input[@id='name']")
	WebElement menuName;
	
	@FindBy(xpath = "//select[@id='menu_id']")
	WebElement parentName;
	
	@FindBy(xpath = "//input[@value='no']")
	WebElement radioButtonNo;
	

	@FindBy(xpath = "//input[@value='yes']")
	WebElement radioButtonYes;
	
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger']")
	WebElement saveButton;
	
	@FindBy(xpath = "//table[@class='table table-bordered']//tbody")
	WebElement tableBody;
	
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

	public SettingPage clickNewButton() {
		PageUtility.clickOnElement(newButton);
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

	/*public SettingPage clickManageMenu() {
		PageUtility.clickOnElement(manageMenu);
		return this;
	}*/

	public SettingPage enterTextinMenuName(String input) {
		PageUtility.enterText(menuName, input);
		return this;

	}
	public SettingPage enterTextinTableName(String input) {
		PageUtility.enterText(tableName, input);
		return this;

	}
	public SettingPage enterTextinUrl(String input) {
		PageUtility.enterText(urlLink, input);
		return this;

	}
	public SettingPage enterTextinFaIcon(String input) {
		PageUtility.enterText(faIcon, input);
		return this;

	}
	public SettingPage enterTextinMenuOrder(String input) {
		PageUtility.enterText(menuOrder, input);
		return this;

	}
	public SettingPage enterTextinActiveFiles(String input) {
		PageUtility.enterText(activeFiles, input);
		return this;

	}
	public SettingPage enterTextinColor(String input) {
		PageUtility.enterText(displayColor, input);
		return this;

	}

	public SettingPage selectbyDropdownIndex() {
		PageUtility.selectDropdownbyIndex(parentName, 13);
		return this;
	}
	public SettingPage clickSave() throws InterruptedException {
		WaitUtility.implicitWait();
		PageUtility.ScrollAndClickOnElement(saveButton, driver);
		return this;
	}
	public void clickYesButton() {
		
		PageUtility.clickOnElement(radioButtonYes);
	}
	public void clickeNoButton() {
	
		PageUtility.clickOnElement(radioButtonNo);
	}
	
	public boolean yesCheckBoxisSelected() {
		return PageUtility.isSelected(radioButtonYes);
	}

	public boolean noCheckBoxisSelected() {
		return PageUtility.isSelected(radioButtonNo);
	}
	public boolean checkTitle(String title) {
		List<WebElement> rows = PageUtility.findRowElements(tableBody);
		for (WebElement row : rows) {
			if (row.getText().contains(title))
				return true;
		}
		return false;
	}
	public void scrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		js.executeScript("arguments[0].scrollIntoView();", saveButton);
	}

	

}
