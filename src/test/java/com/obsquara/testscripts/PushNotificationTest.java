package com.obsquara.testscripts;

import static constants.Constants.EXCELFILE;
import static constants.Constants.SYSTEM_PATH;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsquara.pages.DashBoardMenuList;
import com.obsquara.pages.LoginSuccess;
import com.obsquara.pages.PushNotificationPage;
import com.obsquara.utilities.Retry;

import Utilities.ExcelUtility;
import constants.Constants;

public class PushNotificationTest extends Base {
	PushNotificationPage pushNotificationPage;
	LoginSuccess loginSuccess;

	@Test(retryAnalyzer = Retry.class)
	public void verifyPushNotificationPage() throws IOException, InterruptedException {
		String expectedUrl = ExcelUtility.getString(0, 0, SYSTEM_PATH + EXCELFILE, "PushNotification");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(8, 0, SYSTEM_PATH + EXCELFILE, "DashBoard"));
		pushNotificationPage = new PushNotificationPage(driver);
		pushNotificationPage.clickonPushNotification();
		assertTrue(driver.getCurrentUrl().equals(expectedUrl), "Unable to login");

	}

	@Test(retryAnalyzer = Retry.class)
	public void verifyTitleDescriptionField() throws IOException, InterruptedException {
		String titleTextBox = ExcelUtility.getString(1, 0, System.getProperty("user.dir") + Constants.EXCELFILE,
				"PushNotification");
		String descriptionTextBox = ExcelUtility.getString(2, 0, SYSTEM_PATH + EXCELFILE, "PushNotification");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(8, 0, SYSTEM_PATH + EXCELFILE, "DashBoard"));
		pushNotificationPage = new PushNotificationPage(driver);
		pushNotificationPage.clickonPushNotification();
		pushNotificationPage.enterTitleField(titleTextBox);
		pushNotificationPage.enterDescriptionField(descriptionTextBox);
		pushNotificationPage.clickSendButton();
		assertTrue(pushNotificationPage.isAlertMessageDisplayed(), "");

	}

}
