package com.obsquara.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsquara.pages.DashBoardMenuList;
import com.obsquara.pages.LoginSuccess;
import com.obsquara.pages.ManageUserPage;

import Utilities.ExcelUtility;
import Utilities.UtilityFile;

public class ManageUserTest extends Base {
	ManageUserPage manageUserPage;
	LoginSuccess loginSuccess;

	@Test(retryAnalyzer = generaltest.Retry.class)
	public void verifySearchUserandPasswordShownInDetail() throws IOException {
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(3, 0, UtilityFile.excelPath, "DashBoard"));
		manageUserPage = new ManageUserPage(driver);
		manageUserPage.clickSearchButtn();
		manageUserPage.enterNameinSearchListUser((ExcelUtility.getString(0, 0, UtilityFile.excelPath, "ManageUser")));
		manageUserPage.clickonRedSearchButton();
		manageUserPage.clickonPasswordDetailElement();
		assertTrue(manageUserPage.isDisplayedResultPassword(), " the password not dispalyed");
	}

	@Test(retryAnalyzer = generaltest.Retry.class)
	public void verifySearchButtonColorinManageUser () throws IOException {
		String expectedcolor = ExcelUtility.getString(1, 0, UtilityFile.excelPath, "ManageUser");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(3, 0, UtilityFile.excelPath, "DashBoard"));
		manageUserPage = new ManageUserPage(driver);
		String actualColor = manageUserPage.getSearchButtonColor();
		assertEquals(expectedcolor, actualColor, "Search button color is not same");
	}

}
