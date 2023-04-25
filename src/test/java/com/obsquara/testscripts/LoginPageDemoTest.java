package com.obsquara.testscripts;

import static constants.Constants.EXCELFILE;
import static constants.Constants.SYSTEM_PATH;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsquara.pages.LoginPageDemoPage;
import com.obsquara.utilities.Retry;

import Utilities.ExcelUtility;

public class LoginPageDemoTest extends Base {
	LoginPageDemoPage loginPageDemoPage;

	@Parameters({ "validationMessage" })
	@Test(retryAnalyzer = Retry.class)
	public void verifytheSignInButton(String validationMessage) {
		loginPageDemoPage = new LoginPageDemoPage(driver);
		loginPageDemoPage.clickSignInButton();
		String message = loginPageDemoPage.getValidationMessage("username");
		assertEquals(message, validationMessage, "Validation messages doesn't match");
	}

	@Test(retryAnalyzer = Retry.class)
	@Parameters({ "username", "password" })
	public void verifyApplicationLoginSuccess(String username, String password) throws IOException {
		String expectedUrl = ExcelUtility.getString(0, 0, SYSTEM_PATH +EXCELFILE,
				"LoginSuccess");
		loginPageDemoPage = new LoginPageDemoPage(driver);
		loginPageDemoPage.enterNameInUsernameField(username).enterTextInPasswordField(password).clickSignInButton();
		assertTrue(driver.getCurrentUrl().equals(expectedUrl), "Unable to login");
	}

	@Test(retryAnalyzer = Retry.class)
	@Parameters({ "username", "password" })
	public void verifyLoginCredentialsCaseSensitive(String username, String password) throws IOException {
		String expectedUrl = ExcelUtility.getString(0, 0, SYSTEM_PATH +EXCELFILE,
				"LoginSuccess");
		loginPageDemoPage = new LoginPageDemoPage(driver);
		loginPageDemoPage.enterNameInUsernameField(username.toUpperCase()).enterTextInPasswordField(password)
				.clickSignInButton();
		assertTrue(driver.getCurrentUrl().equals(expectedUrl), "Unable to login");
	}

	@Test(retryAnalyzer = Retry.class)
	@Parameters({ "username", "password" })
	public void verifyLoginPasswordCaseSensitive(String username, String password) throws IOException {
		String expectedUrl = ExcelUtility.getString(0, 0, SYSTEM_PATH +EXCELFILE,
				"LoginSuccess");
		loginPageDemoPage = new LoginPageDemoPage(driver);
		loginPageDemoPage.enterNameInUsernameField(username);
		loginPageDemoPage.enterTextInPasswordField(password.toUpperCase());
		loginPageDemoPage.clickSignInButton();
		assertFalse(driver.getCurrentUrl().equals(expectedUrl), "Invalid Username/Password");
		assertTrue(loginPageDemoPage.alertBoxMessageDisplayed(), "Alert box message not displayed");
	}

	@Test(retryAnalyzer = Retry.class, dataProvider = "LoginProvider", priority = 1)
	public void verifyApplicationLoginFailure(String username, String password) throws IOException {
		String expectedUrl = ExcelUtility.getString(0, 0, SYSTEM_PATH +EXCELFILE,
				"LoginSuccess");
		loginPageDemoPage = new LoginPageDemoPage(driver);
		loginPageDemoPage.enterNameInUsernameField(username).enterTextInPasswordField(password).clickSignInButton();
		assertFalse(driver.getCurrentUrl().equals(expectedUrl), "Invalid Username/Password");
		assertTrue(loginPageDemoPage.alertBoxMessageDisplayed(), "Alert box message not displayed");
	}

	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromDataprovider() {
		return new Object[][] { { "Vyshna", "V123" }, };

	}

}
