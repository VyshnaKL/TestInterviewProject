package com.obsquara.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManageLocationPage {
	WebDriver driver;

	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(xpath = "//select[@id='country_id']")
	WebElement countryField;

	@FindBy(xpath = "//select[@id='st_id']")
	WebElement stateField;

	@FindBy(xpath = "//input[@id='location']")
	WebElement locationField;

	@FindBy(xpath = "//input[@id='delivery']")
	WebElement deliveryField;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertBox;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;

	@FindBy(xpath = "//button[@name='Search']")
	WebElement redSearchButton;

	@FindBy(xpath = "//i[@class='fas fa-edit']")
	WebElement editButton;

	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deleteButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody")
	WebElement tableBody;

	public ManageLocationPage clickNewButton() {
		PageUtility.clickOnElement(newButton);
		return this;
	}

	public ManageLocationPage clickSearchButton() {
		PageUtility.clickOnElement(searchButton);
		return this;
	}

	public ManageLocationPage clickRedSearchButton() {
		PageUtility.clickOnElement(redSearchButton);
		return this;
	}

	public ManageLocationPage enterLocation(String input) {
		PageUtility.enterText(locationField, input);
		return this;
	}

	public ManageLocationPage enterdeliveryamount(String input) {
		PageUtility.enterText(deliveryField, input);
		return this;
	}

	public ManageLocationPage clickSaveButton() {
		PageUtility.clickOnElement(saveButton);
		return this;
	}

	public ManageLocationPage clickEditButton() {
		PageUtility.clickOnElement(editButton);
		return this;
	}

	public ManageLocationPage clickDeleteButton() {
		PageUtility.clickOnElement(deleteButton);
		return this;
	}

	public boolean isAlertBoxDisplayed() {
		return PageUtility.isDisplay(alertBox);

	}

	public ManageLocationPage selectCountryField() throws InterruptedException {
		WaitUtility.implicitWait();
		PageUtility.selectDropdownbyIndex(countryField, 1);
		WaitUtility.implicitWait();
		return this;
	}

	public ManageLocationPage selectStateField(String state) throws InterruptedException {
		// PageUtility.selectDropdownbyIndex(stateField, 1);
		WaitUtility.implicitWait();
		PageUtility.selectDropdownbyText(stateField, state);
		WaitUtility.implicitWait();
		return this;
	}

	public boolean checkTitle(String title) {
		List<WebElement> rows = PageUtility.findRowElements(tableBody);
		for (WebElement row : rows) {
			if (row.getText().contains(title))
				return true;
		}
		return false;
	}

	public void addNewLocation(String state, String location, String deliveryAmount) throws InterruptedException {
		clickNewButton();
		selectCountryField();
		selectStateField(state);
		enterLocation(location);
		enterdeliveryamount(deliveryAmount);
		clickSaveButton();

	}

	public void deleteLocation(String state, String location) throws InterruptedException {
		clickSearchButton();
		selectCountryField();
		selectStateField(state);
		enterLocation(location);
		clickRedSearchButton().clickDeleteButton();
		WaitUtility.implicitWait();
		driver.switchTo().alert().accept();
		WaitUtility.implicitWait();
	}
	
	public void searchLocation(String state, String location) throws InterruptedException {
		clickSearchButton();
		selectCountryField();
		selectStateField(state);
		enterLocation(location);
		clickRedSearchButton();
	}
}
