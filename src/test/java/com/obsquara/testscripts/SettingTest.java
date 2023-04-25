package com.obsquara.testscripts;

import static constants.Constants.EXCELFILE;
import static constants.Constants.SYSTEM_PATH;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsquara.pages.DashBoardMenuList;
import com.obsquara.pages.LoginSuccess;
import com.obsquara.pages.SettingPage;
import com.obsquara.utilities.Retry;

import Utilities.ExcelUtility;

public class SettingTest extends Base {
	SettingPage settingPage;
	LoginSuccess loginSuccess;

	@Test(retryAnalyzer = Retry.class)
	public void verifyToChangePassword() throws IOException, InterruptedException {

		String oldpassword = ExcelUtility.getString(0, 0, SYSTEM_PATH + EXCELFILE, "Settings");
		String newpassword = ExcelUtility.getString(1, 0, SYSTEM_PATH + EXCELFILE, "Settings");
		String confirmpassword = ExcelUtility.getString(2, 0, SYSTEM_PATH + EXCELFILE, "Settings");
		String expectedUrl = ExcelUtility.getString(3, 0, SYSTEM_PATH + EXCELFILE, "Settings");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(9, 0, SYSTEM_PATH + EXCELFILE, "DashBoard"));
		settingPage = new SettingPage(driver);
		settingPage.clickChangePassword().enterOldPassword(oldpassword).enterNewPassword(newpassword)
				.enterConfirmPassword(confirmpassword).clickChangeButton();
		assertTrue(driver.getCurrentUrl().equals(expectedUrl),
				"Logout not successfully and Not redirected to Login  Page");

	}

	@Test(retryAnalyzer = Retry.class)
	public void verifyMenuManagement() throws IOException, InterruptedException {
		String menuname = ExcelUtility.getString(4, 0, SYSTEM_PATH + EXCELFILE, "Settings");
		String url = ExcelUtility.getString(5, 0, SYSTEM_PATH + EXCELFILE, "Settings");
		String faicon = ExcelUtility.getString(6, 0, SYSTEM_PATH + EXCELFILE, "Settings");
		String menuorder = ExcelUtility.getString(7, 0, SYSTEM_PATH + EXCELFILE, "Settings");
		String tablename = ExcelUtility.getString(8, 0, SYSTEM_PATH + EXCELFILE, "Settings");
		String activeFiles = ExcelUtility.getString(9, 0, SYSTEM_PATH + EXCELFILE, "Settings");
		String color = ExcelUtility.getString(10, 0, SYSTEM_PATH + EXCELFILE, "Settings");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(9, 0, SYSTEM_PATH + EXCELFILE, "DashBoard"));
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(11, 0, SYSTEM_PATH + EXCELFILE, "DashBoard"));
		settingPage = new SettingPage(driver);
		//settingPage.clickManageMenu();
		settingPage.clickNewButton().enterTextinMenuName(menuname).selectbyDropdownIndex();
		settingPage.enterTextinUrl(url).enterTextinFaIcon(faicon).enterTextinMenuOrder(menuorder)
				.enterTextinActiveFiles(activeFiles).enterTextinTableName(tablename).enterTextinColor(color);
		settingPage.clickYesButton();
		settingPage.scrollToBottom();
		settingPage.clickSave();
		assertTrue(settingPage.checkTitle(menuname), "new Menu name is not added");
	}

}
