package com.obsquara.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelUtility;
import Utilities.PageUtility;
import constants.Constants;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	LoginPageDemoPage loginPageDemoPage;

	@FindBy(xpath = "//a[@class='dropdown-item'][2]")
	WebElement logoutButtonOption;
	
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement adminLogo;

	@FindBy(xpath = "//a[@data-widget='pushmenu']")
	WebElement pushupMenu;

	//@FindBy(xpath = "//div[@class='os-content']")
	@FindBy(xpath = "//a[@class='brand-link navbar-dark']")
	WebElement menuList;
	

	public void clickLogoutButton() {
		PageUtility.clickOnElement(logoutButtonOption);
	}

	public void clickAdminLogo() {
		PageUtility.clickOnElement(adminLogo);
	}
	
	public void clickPushupMenu() {
		PageUtility.clickOnElement(pushupMenu);
	}

	public boolean pushUpMenuisEnabled() {
		return PageUtility.isEnabled(pushupMenu);
	}

	public boolean menuListDisplayed() {
		return PageUtility.isDisplay(menuList);
	}
	
	public void login() throws IOException {
		loginPageDemoPage = new LoginPageDemoPage(driver);
		String username = ExcelUtility.getString(0, 0, System.getProperty("user.dir") + Constants.EXCELFILE, "LoginCredentials");
		String password = ExcelUtility.getString(0, 1, System.getProperty("user.dir") + Constants.EXCELFILE, "LoginCredentials");
		loginPageDemoPage.enterNameInUsernameField(username);
		loginPageDemoPage.enterTextInPasswordField(password);
		loginPageDemoPage.clickSignInButton();
	}

}
