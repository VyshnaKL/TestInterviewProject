package com.obsquara.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsquara.pages.LoginPageDemoPage;

import Utilities.ExcelUtility;
import Utilities.WaitUtility;
import constants.Constants;

public class LoginPageDemoTest extends Base {
	LoginPageDemoPage loginPageDemoPage;

	@Parameters({"validationMessage"})
	@Test
	public void verifytheSignInButton(String validationMessage) {
		loginPageDemoPage = new LoginPageDemoPage(driver);
		loginPageDemoPage.clickSignInButton();
		String message = loginPageDemoPage.getValidationMessage("username");
		assertEquals(message,validationMessage, "Validation messages doesn't match");
	}

	@Test

	@Parameters({ "username", "password" })
	public void verifyApplicationLoginSuccess(String username, String password) throws IOException {
		String expectedUrl = ExcelUtility.getString(0, 0, System.getProperty("user.dir") + Constants.EXCELFILE, "LoginSuccess");
		loginPageDemoPage = new LoginPageDemoPage(driver);
		loginPageDemoPage.enterNameInUsernameField(username);
		loginPageDemoPage.enterTextInPasswordField(password);
		loginPageDemoPage.clickSignInButton();
		assertTrue(driver.getCurrentUrl().equals(expectedUrl), "Unable to login");
	}

	@Parameters({ "username", "password" })
	public void verifyLoginCredentialsCaseSensitive(String username, String password) throws IOException {
		String expectedUrl = ExcelUtility.getString(0, 0, System.getProperty("user.dir") + Constants.EXCELFILE, "LoginSuccess");
		loginPageDemoPage = new LoginPageDemoPage(driver);
		loginPageDemoPage.enterNameInUsernameField(username.toUpperCase());
		loginPageDemoPage.enterTextInPasswordField(password);
		loginPageDemoPage.clickSignInButton();
		assertTrue(driver.getCurrentUrl().equals(expectedUrl), "Unable to login");
	}

	@Test(dataProvider = "LoginProvider", priority = 1)
	public void verifyApplicationLoginFailure(String username, String password) throws IOException {
		String expectedUrl = ExcelUtility.getString(0, 0, System.getProperty("user.dir") + Constants.EXCELFILE, "LoginSuccess");
		loginPageDemoPage = new LoginPageDemoPage(driver);
		loginPageDemoPage.enterNameInUsernameField(username);
		loginPageDemoPage.enterTextInPasswordField(password);
		loginPageDemoPage.clickSignInButton();
		assertFalse(driver.getCurrentUrl().equals(expectedUrl),
				"Invalid Username/Password");
		assertTrue(loginPageDemoPage.alertBoxMessageDisplayed(), "Alert box message not displayed");
	}

	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromDataprovider() {
		return new Object[][] { { "Vyshna", "V123" }, };

	}

}
