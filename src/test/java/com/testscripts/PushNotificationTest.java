package com.obsquara.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsquara.pages.DashBoardMenuList;
import com.obsquara.pages.LoginSuccess;
import com.obsquara.pages.PushNotificationPage;

import Utilities.ExcelUtility;
import Utilities.UtilityFile;

public class PushNotificationTest extends Base {
	PushNotificationPage pushNotificationPage;
	LoginSuccess loginSuccess;

	@Test(retryAnalyzer = generaltest.Retry.class)
	public void verifyPushNotificationPage() throws IOException, InterruptedException {
		String expectedUrl = ExcelUtility.getString(0, 0, UtilityFile.excelPath, "PushNotification");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(8, 0, UtilityFile.excelPath, "DashBoard"));
		pushNotificationPage = new PushNotificationPage(driver);
		pushNotificationPage.clickonPushNotification();
		assertTrue(driver.getCurrentUrl().equals(expectedUrl), "Url is nt same");

	}

	@Test(retryAnalyzer = generaltest.Retry.class)
	public void verifyTitleDescriptionField() throws IOException, InterruptedException {
		String titleTextBox = ExcelUtility.getString(1, 0, UtilityFile.excelPath, "PushNotification");
		String descriptionTextBox = ExcelUtility.getString(2, 0, UtilityFile.excelPath, "PushNotification");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(8, 0, UtilityFile.excelPath, "DashBoard"));
		pushNotificationPage = new PushNotificationPage(driver);
		pushNotificationPage.clickonPushNotification().enterTitleField(titleTextBox).enterDescriptionField(descriptionTextBox).clickSendButton();
		assertTrue(pushNotificationPage.isAlertMessageDisplayed(), "the new data is not added");

	}

}
