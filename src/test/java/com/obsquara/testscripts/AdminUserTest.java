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
import Utilities.UtilityFile;

public class AdminUserTest extends Base {
	AdminUserPage adminUserPage;
	LoginSuccess loginSuccess;

	@Test(retryAnalyzer = generaltest.Retry.class, dataProvider = "LoginProvider")
	public void verifyNewAdminUser(String username, String password) throws IOException, InterruptedException {
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(4, 0, UtilityFile.excelPath, "DashBoard"));
		adminUserPage = new AdminUserPage(driver);
		adminUserPage.clickonNewUser().enterUserNameField(username).enterPasswordField(password).selectbyDropdownIndex()
				.clickonSaveNotification();
		assertTrue(adminUserPage.checkTitle(username), "USERNAME is  not found in table");
		adminUserPage.deleteAdminUser(username, password, username);
	}

	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromDataprovider() {
		return new Object[][] { { "Vyshna", "V123" }, };

	}

	@Test(retryAnalyzer = generaltest.Retry.class)

	public void verifyDeleteAdminUser() throws IOException, InterruptedException {
		String searchName = ExcelUtility.getString(0, 0, UtilityFile.excelPath, "AdminUsers");
		String username = ExcelUtility.getString(0, 0, UtilityFile.excelPath, "AdminUsers");
		String password = ExcelUtility.getString(0, 0, UtilityFile.excelPath, "AdminUsers");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(4, 0, UtilityFile.excelPath, "DashBoard"));
		adminUserPage = new AdminUserPage(driver);
		adminUserPage.clickonNewUser().enterUserNameField(username).enterPasswordField(password).selectbyDropdownIndex()
				.clickonSaveNotification().clickSearchButton();
		adminUserPage.enterSearchName(searchName).clickRedSearchButton().clickDeleteButton();
		driver.switchTo().alert().accept();
		assertFalse(adminUserPage.checkTitle(searchName), "username is found in table");
		assertTrue(adminUserPage.isAlertMessageDisplayed(), "username not deleted successfully");

	}
	
	@Test(retryAnalyzer = generaltest.Retry.class)
	public void verifySearchAdminUser() throws IOException, InterruptedException {
		String searchName = ExcelUtility.getString(0, 0, UtilityFile.excelPath, "AdminUsers");
		String username = ExcelUtility.getString(0, 0, UtilityFile.excelPath, "AdminUsers");
		String password = ExcelUtility.getString(0, 0, UtilityFile.excelPath, "AdminUsers");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(4, 0, UtilityFile.excelPath, "DashBoard"));
		adminUserPage = new AdminUserPage(driver);
		adminUserPage.clickonNewUser().enterUserNameField(username).enterPasswordField(password).selectbyDropdownIndex()
				.clickonSaveNotification().clickSearchButton();
		adminUserPage.enterSearchName(searchName).clickRedSearchButton();
		assertTrue(adminUserPage.checkTitle(searchName), "username not found in table");
		adminUserPage.deleteAdminUser(username, password, searchName);
	}

}
