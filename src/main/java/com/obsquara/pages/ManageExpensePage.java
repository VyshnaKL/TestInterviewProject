package com.obsquara.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class ManageExpensePage {
	WebDriver driver;

	public ManageExpensePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[@id='user_id']")
	WebElement userField;
	
	@FindBy(xpath="//input[@id='ex_date']")
	WebElement dateField;
	
	@FindBy(xpath="//select[@id='ex_cat']")
	WebElement  categoryField;
	
	@FindBy(xpath="//select[@id='order_id']")
	WebElement orderIdField ;
	
	@FindBy(xpath="//select[@id='purchase_id']")
	WebElement purchaseIdField;
	
	@FindBy(xpath="//select[@id='ex_type']")
	WebElement expenseTypeField ;
	
	@FindBy(xpath="//input[@id='amount']")
	WebElement amountField ;
	
	@FindBy(xpath="//textarea[@id='content']")
	WebElement  remarkField;
	
	@FindBy(xpath="//input[@name='userfile']")
	WebElement  chooseFileField;
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement saveButton ;
	
	 public ManageExpensePage selectUserField() {
			PageUtility.selectDropdownbyIndex(userField, 1);
			return this;
		}
	 
	 public ManageExpensePage selectCategoryField() {
			PageUtility.selectDropdownbyIndex(categoryField, 1);
			return this;
		}
	 public ManageExpensePage selectOrderIdField() {
			PageUtility.selectDropdownbyIndex(orderIdField, 1);
			return this;
		}
	 public ManageExpensePage selectPurchaseField() {
			PageUtility.selectDropdownbyIndex(purchaseIdField, 1);
			return this;
		}
	 public ManageExpensePage selectExpenseField() {
			PageUtility.selectDropdownbyIndex(expenseTypeField, 1);
			return this;
		}
	 public ManageExpensePage enterAmountField(String input) {
		 PageUtility.enterText(amountField, input);
		  return this;
		}
	 public ManageExpensePage enterRemarkField(String input) {
		 PageUtility.enterText(remarkField, input);
		  return this;
		}
	 public ManageExpensePage uploadImage() throws IOException
		{
			chooseFileField.sendKeys("\"D:\\testimage.jpg\"");
			return this;
		}
	 public ManageExpensePage clickonSaveButton()
	 {
		 PageUtility.clickOnElement(saveButton);
		 return this;
	 }
}