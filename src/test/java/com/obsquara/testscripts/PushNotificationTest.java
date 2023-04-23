package com.obsquara.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsquara.pages.DashBoardMenuList;
import com.obsquara.pages.LoginSuccess;
import com.obsquara.pages.PushNotificationPage;

import Utilities.ExcelUtility;
import constants.Constants;

public class PushNotificationTest extends Base {
	PushNotificationPage pushNotificationPage;
	LoginSuccess loginSuccess;

	@Test

	public void verifyPushNotificationPage() throws IOException, InterruptedException {
		String expectedUrl = ExcelUtility.getString(0, 0, System.getProperty("user.dir") + Constants.EXCELFILE,
				"PushNotification");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages("Push Notifications");
		pushNotificationPage = new PushNotificationPage(driver);
		pushNotificationPage.clickonPushNotification();
		assertTrue(driver.getCurrentUrl().equals(expectedUrl), "Unable to login");

	}
	@Test
	
	public void verifyTitleDescriptionField() throws IOException, InterruptedException {
		String expectedUrl = ExcelUtility.getString(0, 0, System.getProperty("user.dir") + Constants.EXCELFILE,
				"PushNotification");
		String titleTextBox= ExcelUtility.getString(1, 0, System.getProperty("user.dir") + Constants.EXCELFILE,
				"PushNotification");
		String descriptionTextBox = ExcelUtility.getString(2, 0, System.getProperty("user.dir") + Constants.EXCELFILE,
				"PushNotification");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages("Push Notifications");
		pushNotificationPage = new PushNotificationPage(driver);
		pushNotificationPage.clickonPushNotification();
		pushNotificationPage.enterTitleField(titleTextBox);
		pushNotificationPage.enterDescriptionField(descriptionTextBox);
		pushNotificationPage.clickSendButton();
		assertTrue(pushNotificationPage.isAlertMessageDisplayed(), "alert box not displayed");
		
	}

}
