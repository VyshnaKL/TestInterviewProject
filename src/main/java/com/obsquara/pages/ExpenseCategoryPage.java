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

	@FindBy(xpath = "//input[@id='name']")
	WebElement titleTextField;

	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;

	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchButton;
	
	@FindBy(xpath = "//a[text()='Home']")
	WebElement homeOption;
	
	@FindBy(xpath = "/html/body/div/aside[1]/div/div[4]/div/div/nav/ul/li[3]")
	WebElement manageExpense ;
	
	@FindBy(xpath = "//p[text()='Expense Category']")
	WebElement expenseCategory;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody")
	WebElement tableBody;
	
	
	public void clickSearchButton(){
		PageUtility.clickOnElement(searchButton);
		
	}
	
	
	public void clickNewButton(){
		PageUtility.clickOnElement(newButtonOption);
		
	}
	public void clickHomeButton(){
		PageUtility.clickOnElement(homeOption);
		
	}
	public void clickSaveButton(){
		PageUtility.clickOnElement(saveButton);
		
	}
	public void clickManageExpense(){
		PageUtility.clickOnElement(manageExpense);
		
	}
	public void clickExpenseCategory() {
		PageUtility.clickOnElement(expenseCategory);
	}
	public WebElement enterTitleField(String input) {

		return PageUtility.enterText(titleTextField, input);
	}
	public boolean saveButtonisEnabled() {

		return PageUtility.isElementEnabled(saveButton);
	}
	
	public boolean checkTitle(String title) {
		List<WebElement> rows = PageUtility.findRowElements(tableBody);
		for (WebElement row : rows) {
			if(row.getText().contains(title))
				return true;
		}
		return false;
	}
	 
	
}
