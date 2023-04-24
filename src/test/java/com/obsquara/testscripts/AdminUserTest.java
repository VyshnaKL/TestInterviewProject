package com.obsquara.testscripts;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.obsquara.pages.AdminUserPage;
import com.obsquara.pages.DashBoardMenuList;
import com.obsquara.pages.LoginSuccess;

import Utilities.ExcelUtility;
import constants.Constants;

public class AdminUserTest extends Base {
	AdminUserPage adminUserPage;
	LoginSuccess loginSuccess;

	@Test(retryAnalyzer = Retry.class,dataProvider = "LoginProvider")
	public void verifyNewAdminUser(String username, String password) throws IOException {
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(
				ExcelUtility.getString(4, 0, System.getProperty("user.dir") + Constants.EXCELFILE, "DashBoard"));
		adminUserPage = new AdminUserPage(driver);
		adminUserPage.clickonNewUser().enterUserNameField(username).enterPasswordField(password).selectbyDropdownIndex()
				.clickonSaveNotification();
		assertTrue(adminUserPage.checkTitle(username), "USERNAME is  not found in table");
	}

	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromDataprovider() {
		return new Object[][] { { "Vyshna", "V123" }, };

	}

	@Test(retryAnalyzer = Retry.class)

	public void verifyDeleteAdminUser() throws IOException, InterruptedException {
		String searchName = ExcelUtility.getString(0, 0, System.getProperty("user.dir") + Constants.EXCELFILE,
				"AdminUsers");
		String username = ExcelUtility.getString(0, 0, System.getProperty("user.dir") + Constants.EXCELFILE,
				"AdminUsers");
		String password = ExcelUtility.getString(0, 0, System.getProperty("user.dir") + Constants.EXCELFILE,
				"AdminUsers");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(
				ExcelUtility.getString(4, 0, System.getProperty("user.dir") + Constants.EXCELFILE, "DashBoard"));
		adminUserPage = new AdminUserPage(driver);
		adminUserPage.clickonNewUser().enterUserNameField(username).enterPasswordField(password).selectbyDropdownIndex()
				.clickonSaveNotification().clickSearchButton();
		adminUserPage.enterSearchName(searchName).clickRedSearchButton().clickDeleteButton();
		driver.switchTo().alert().accept();
		assertFalse(adminUserPage.checkTitle(searchName), "username not found in table");
		assertTrue(adminUserPage.isAlertMessageDisplayed(), "alert box not displayed");

	}

}
