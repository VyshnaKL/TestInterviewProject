package com.obsquara.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsquara.pages.DashBoardMenuList;
import com.obsquara.pages.HomePage;
import com.obsquara.pages.LoginSuccess;

import Utilities.ExcelUtility;
import constants.Constants;

public class HomePageTest extends Base {
	HomePage homePage;
	LoginSuccess loginSuccess;

	@Test(retryAnalyzer = Retry.class)
	public void verifySuccessfullyLogout() throws IOException {
		String expectedUrl = ExcelUtility.getString(0, 0, System.getProperty("user.dir") + Constants.EXCELFILE,
				"LogOutSucess");
		homePage = new HomePage(driver);
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		homePage.clickAdminLogo();
		homePage.clickLogoutButton();
		assertTrue(driver.getCurrentUrl().equals(expectedUrl), "Not redirected to Login Page");
	}

	@Test(retryAnalyzer = Retry.class)
	public void verifyPushUpMenuButton() throws IOException {
		homePage = new HomePage(driver);
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		homePage.clickPushupMenu();
		assertTrue(homePage.menuListDisplayed(), " response is not enabled");
	}

	@Test(retryAnalyzer = Retry.class)
	public void verifySelectFromDashBoard() throws IOException, InterruptedException {
		String expectedUrl = ExcelUtility.getString(0, 0, System.getProperty("user.dir") + Constants.EXCELFILE,
				"DashBoard");
		homePage = new HomePage(driver);
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(2, 0, System.getProperty("user.dir") + Constants.EXCELFILE, "DashBoard"));
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(10, 0, System.getProperty("user.dir") + Constants.EXCELFILE, "DashBoard"));
		assertTrue(driver.getCurrentUrl().equals(expectedUrl), "Unable to login");
	}

}
