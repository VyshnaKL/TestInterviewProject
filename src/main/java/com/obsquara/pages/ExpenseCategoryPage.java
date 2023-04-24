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

	public ExpenseCategoryPage clickSearchButton() {
		PageUtility.clickOnElement(searchButton);
		return this;

	}

	public ExpenseCategoryPage clickRedSearchButton() {
		PageUtility.clickOnElement(redSearchButton);
		return this;
	}

	public ExpenseCategoryPage clickNewButton() {
		PageUtility.clickOnElement(newButtonOption);
		return this;
	}

	public ExpenseCategoryPage clickHomeButton() {
		PageUtility.clickOnElement(homeOption);
		return this;
	}

	public ExpenseCategoryPage clickSaveButton() {
		PageUtility.clickOnElement(saveButton);
		return this;
	}

	public ExpenseCategoryPage clickManageExpense() {
		PageUtility.clickOnElement(manageExpense);
		return this;
	}

	public ExpenseCategoryPage clickExpenseCategory() {
		PageUtility.clickOnElement(expenseCategory);
		return this;
	}

	public ExpenseCategoryPage clickDeleteButton() {
		PageUtility.clickOnElement(deleteButton);
		return this;
	}

	public ExpenseCategoryPage clickEditButton() {
		PageUtility.clickOnElement(editButton);
		return this;
	}

	public ExpenseCategoryPage clickUpdateButton() {
		PageUtility.clickOnElement(updateButton);
		return this;
	}

	public ExpenseCategoryPage  enterTitleField(String input) {
		 PageUtility.enterText(titleTextField, input);
		 return this;
	}

	public boolean saveButtonisEnabled() {

		return PageUtility.isElementEnabled(saveButton);
	}

	public boolean isAlertBoxDisplayed() {
		return PageUtility.isDisplay(alertBox);
	}

	public ExpenseCategoryPage enterSearchTitle(String input) {
		PageUtility.enterText(searchTitle, input);
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
