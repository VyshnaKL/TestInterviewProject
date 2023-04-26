package com.obsquara.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsquara.pages.LoginPageDemoPage;

import Utilities.ExcelUtility;
import Utilities.UtilityFile;

public class LoginPageDemoTest extends Base {
	LoginPageDemoPage loginPageDemoPage;

	@Parameters({ "validationMessage" })
	@Test(retryAnalyzer = generaltest.Retry.class)
	public void verifytheSignInButton(String validationMessage) {
		loginPageDemoPage = new LoginPageDemoPage(driver);
		loginPageDemoPage.clickSignInButton();
		String message = loginPageDemoPage.getValidationMessage("username");
		assertEquals(message, validationMessage, "Validation messages doesn't match");
	}

	@Test(retryAnalyzer = generaltest.Retry.class)
	@Parameters({ "username", "password" })
	public void verifyApplicationLoginSuccess(String username, String password) throws IOException {
		String expectedUrl = ExcelUtility.getString(0, 0, UtilityFile.excelPath, "LoginSuccess");
		loginPageDemoPage = new LoginPageDemoPage(driver);
		loginPageDemoPage.enterNameInUsernameField(username).enterTextInPasswordField(password).clickSignInButton();
		assertTrue(driver.getCurrentUrl().equals(expectedUrl), "Unable to login");
	}

	@Test(retryAnalyzer = generaltest.Retry.class)
	@Parameters({ "username", "password" })
	public void verifyLoginCredentialsCaseSensitive(String username, String password) throws IOException {
		String expectedUrl = ExcelUtility.getString(0, 0, UtilityFile.excelPath, "LoginSuccess");
		loginPageDemoPage = new LoginPageDemoPage(driver);
		loginPageDemoPage.enterNameInUsernameField(username.toUpperCase()).enterTextInPasswordField(password)
				.clickSignInButton();
		assertTrue(driver.getCurrentUrl().equals(expectedUrl), "Unable to login");
	}

	@Test(retryAnalyzer = generaltest.Retry.class)
	@Parameters({ "username", "password" })
	public void verifyLoginPasswordCaseSensitive(String username, String password) throws IOException {
		String expectedUrl = ExcelUtility.getString(0, 0, UtilityFile.excelPath, "LoginSuccess");
		loginPageDemoPage = new LoginPageDemoPage(driver);
		loginPageDemoPage.enterNameInUsernameField(username);
		loginPageDemoPage.enterTextInPasswordField(password.toUpperCase());
		loginPageDemoPage.clickSignInButton();
		assertFalse(driver.getCurrentUrl().equals(expectedUrl), "Invalid Username/Password");
		assertTrue(loginPageDemoPage.alertBoxMessageDisplayed(), "Invalid Username/Password");
	}

	@Test(retryAnalyzer = generaltest.Retry.class, dataProvider = "LoginProvider", priority = 1)
	public void verifyApplicationLoginFailure(String username, String password) throws IOException {
		String expectedUrl = ExcelUtility.getString(0, 0, UtilityFile.excelPath, "LoginSuccess");
		loginPageDemoPage = new LoginPageDemoPage(driver);
		loginPageDemoPage.enterNameInUsernameField(username).enterTextInPasswordField(password).clickSignInButton();
		assertFalse(driver.getCurrentUrl().equals(expectedUrl), "Invalid Username/Password");
		assertTrue(loginPageDemoPage.alertBoxMessageDisplayed(), "Invalid Username/Password");
	}

	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromDataprovider() {
		return new Object[][] { { "Vyshna", "V1234" }, };

	}

}
