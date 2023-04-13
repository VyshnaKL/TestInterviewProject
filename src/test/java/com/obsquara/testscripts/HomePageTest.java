package com.obsquara.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsquara.pages.HomePage;

import Utilities.ExcelUtility;
import constants.Constants;

public class HomePageTest extends Base {
	HomePage homePage;

	//@Test

	public void verifySuccessfullyLogout() throws IOException {
		String expectedUrl = ExcelUtility.getString(0, 0, System.getProperty("user.dir") + Constants.EXCELFILE,
				"LogOutSucess");
		homePage = new HomePage(driver);
		homePage.login();
		homePage.clickAdminLogo();
		homePage.clickLogoutButton();
		assertTrue(driver.getCurrentUrl().equals(expectedUrl), "Not redirected to Login Page");
	}

	@Test
	public void verifyPushUpMenuButton() throws IOException {
		homePage = new HomePage(driver);
		homePage.login();
		homePage.clickPushupMenu();
		assertTrue(homePage.menuListDisplayed(), " response is not enabled");
	}

}
