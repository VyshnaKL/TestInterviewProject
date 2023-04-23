package com.obsquara.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class ExpenseCategoryPage {
	WebDriver driver;

	public ExpenseCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButtonOption;

	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deleteButton;

	@FindBy(xpath = "//input[@id='name']")
	WebElement titleTextField;

	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertBox;

	@FindBy(xpath = "//a[text()='Home']")
	WebElement homeOption;

	@FindBy(xpath = "//li[@class='nav-item has-treeview'][2]")
	WebElement manageExpense;

	@FindBy(xpath = "//p[text()='Expense Category']")
	WebElement expenseCategory;

	@FindBy(xpath = "//input[@class='form-control']")
	WebElement searchTitle;

	@FindBy(xpath = "//button[@name='Search']")
	WebElement redSearchButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody")
	WebElement tableBody;

	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement editButton;

	@FindBy(xpath = "//button[@name='Update']")
	WebElement updateButton;

	public void clickSearchButton() {
		PageUtility.clickOnElement(searchButton);

	}

	public void clickRedSearchButton() {
		PageUtility.clickOnElement(redSearchButton);

	}

	public void clickNewButton() {
		PageUtility.clickOnElement(newButtonOption);

	}

	public void clickHomeButton() {
		PageUtility.clickOnElement(homeOption);

	}

	public void clickSaveButton() {
		PageUtility.clickOnElement(saveButton);

	}

	public void clickManageExpense() {
		PageUtility.clickOnElement(manageExpense);

	}

	public void clickExpenseCategory() {
		PageUtility.clickOnElement(expenseCategory);
	}

	public void clickDeleteButton() {
		PageUtility.clickOnElement(deleteButton);
	}

	public void clickEditButton() {
		PageUtility.clickOnElement(editButton);
	}

	public void clickUpdateButton() {
		PageUtility.clickOnElement(updateButton);
	}

	public WebElement enterTitleField(String input) {

		return PageUtility.enterText(titleTextField, input);
	}

	public boolean saveButtonisEnabled() {

		return PageUtility.isElementEnabled(saveButton);
	}

	public boolean isAlertBoxDisplayed() {
		return PageUtility.isDisplay(alertBox);
	}

	public WebElement enterSearchTitle(String input) {
		return PageUtility.enterText(searchTitle, input);
	}

	public boolean checkTitle(String title) {
		List<WebElement> rows = PageUtility.findRowElements(tableBody);
		for (WebElement row : rows) {
			if (row.getText().contains(title))
				return true;
		}
		return false;
	}

	public void deleteExpenseCategory(String title) {
		clickExpenseCategory();
		clickSearchButton();
		enterSearchTitle(title);
		clickRedSearchButton();
		clickDeleteButton();
		driver.switchTo().alert().accept();

	}
	
	public void addExpenseCategory(String title) {
		clickExpenseCategory();
		clickNewButton();
		enterTitleField(title);
		clickSaveButton();
	}

}
