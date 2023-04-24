package com.obsquara.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class ManageSliderPage {
	WebDriver driver;
	public ManageSliderPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	 @FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	 WebElement newButton ;
	 
	 @FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	 WebElement editButton ;
	 
	 @FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	 WebElement  deleteButton;
	 
	 @FindBy(xpath = "//input[@id='link']")
	 WebElement  linkField;
	 
	 @FindBy(xpath = "//button[@class='btn btn-danger']")
	 WebElement saveButton;
	 
	 @FindBy(xpath = "//button[@name='update']")
	 WebElement updateButton ;

	 @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	 WebElement alertMessageBox ;
	  
	 public ManageSliderPage clickonNewButton() {
		 PageUtility.clickOnElement(newButton);
		 return this;
	 }
	 
	 public ManageSliderPage clickonEditButton() {
		 PageUtility.clickOnElement(editButton);
		 return this;
	 }
	 public ManageSliderPage clickonUpdatetButton() {
		 PageUtility.clickOnElement(updateButton);
		 return this;
	 }
	 public ManageSliderPage clickonDeletetButton() {
		 PageUtility.clickOnElement(deleteButton);
		 return this;
	 }
	 
	 public ManageSliderPage enterTextinLinkField(String link) {
		 PageUtility.enterText(linkField, link);
		 return this;
	 }
	 
	 public ManageSliderPage clickonSaveButton() {
		 PageUtility.clickOnElement(saveButton);
		 return this;
	 }
	 
	 public boolean alertMessageDisplay() {
		 return PageUtility.isDisplay(alertMessageBox);
	 }
	 
	 
}
