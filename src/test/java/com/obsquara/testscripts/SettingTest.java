package com.obsquara.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsquara.pages.DashBoardMenuList;
import com.obsquara.pages.LoginSuccess;
import com.obsquara.pages.SettingPage;

import Utilities.ExcelUtility;
import constants.Constants;

public class SettingTest extends Base {
	SettingPage settingPage;
	LoginSuccess loginSuccess;

	@Test(retryAnalyzer = Retry.class)
	public void verifyToChangePassword() throws IOException, InterruptedException {

		String oldpassword = ExcelUtility.getString(0, 0, System.getProperty("user.dir") + Constants.EXCELFILE,
				"Settings");
		String newpassword = ExcelUtility.getString(1, 0, System.getProperty("user.dir") + Constants.EXCELFILE,
				"Settings");
		String confirmpassword = ExcelUtility.getString(2, 0, System.getProperty("user.dir") + Constants.EXCELFILE,
				"Settings");
		String expectedUrl = ExcelUtility.getString(3, 0, System.getProperty("user.dir") + Constants.EXCELFILE,
				"Settings");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(
				ExcelUtility.getString(9, 0, System.getProperty("user.dir") + Constants.EXCELFILE, "DashBoard"));
		settingPage = new SettingPage(driver);
		settingPage.clickChangePassword().enterOldPassword(oldpassword).enterNewPassword(newpassword)
				.enterConfirmPassword(confirmpassword).clickChangeButton();
		assertTrue(driver.getCurrentUrl().equals(expectedUrl),
				"Logout not successfully and Not redirected to Login  Page");

	}

}
