package com.obsquara.testscripts;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsquara.pages.DashBoardMenuList;
import com.obsquara.pages.DeliveryBoyUser;
import com.obsquara.pages.LoginSuccess;
import com.obsquara.pages.ManageDeliveryBoyPage;

import Utilities.ExcelUtility;
import Utilities.UtilityFile;
import generaltest.Retry;

public class ManageDeliveryBoyTest extends Base {

	ManageDeliveryBoyPage manageDeliveryBoyPage;
	LoginSuccess loginSuccess;

	@Test(retryAnalyzer = Retry.class, priority = 1)
	public void verifyToAddNewDeliveryBoy() throws IOException, InterruptedException {

		String name = ExcelUtility.getString(0, 0, UtilityFile.excelPath, "ManageDeliveryBoy");
		String email = ExcelUtility.getString(1, 0, UtilityFile.excelPath, "ManageDeliveryBoy");
		String phonenumber = ExcelUtility.getString(2, 0, UtilityFile.excelPath, "ManageDeliveryBoy");
		String address = ExcelUtility.getString(3, 0, UtilityFile.excelPath, "ManageDeliveryBoy");
		String deliveryusername = ExcelUtility.getString(4, 0, UtilityFile.excelPath, "ManageDeliveryBoy");
		String deliverypassword = ExcelUtility.getString(5, 0, UtilityFile.excelPath, "ManageDeliveryBoy");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(7, 0, UtilityFile.excelPath, "DashBoard"));
		manageDeliveryBoyPage = new ManageDeliveryBoyPage(driver);
		manageDeliveryBoyPage.clickNewButton();
		manageDeliveryBoyPage.enterNameField(name);
		manageDeliveryBoyPage.enterEmailField(email);
		manageDeliveryBoyPage.enterPhoneNumberField(phonenumber);
		manageDeliveryBoyPage.enterAddressField(address);
		manageDeliveryBoyPage.enterUserNameField(deliveryusername);
		manageDeliveryBoyPage.enterPasswordField(deliverypassword);
		manageDeliveryBoyPage.scrollToBottom();
		manageDeliveryBoyPage.clickSaveButton();
		assertTrue(manageDeliveryBoyPage.checkTitle(name), "title not found in table");

	}

	@Test(retryAnalyzer = Retry.class, priority = 2)
	public void verifySearchDeliveryBoy() throws IOException, InterruptedException {
		String searchName = ExcelUtility.getString(0, 0, UtilityFile.excelPath, "ManageDeliveryBoy");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(7, 0, UtilityFile.excelPath, "DashBoard"));
		manageDeliveryBoyPage = new ManageDeliveryBoyPage(driver);
		manageDeliveryBoyPage.clickSearchButton();
		manageDeliveryBoyPage.enterSearchName(searchName);
		manageDeliveryBoyPage.clickRedSearchButton();
		assertTrue(manageDeliveryBoyPage.checkTitle(searchName), "title not found in table");
	}

	@Test(retryAnalyzer = Retry.class, priority = 4)
	public void verifyEditDeliveryBoy() throws IOException, InterruptedException {

		String name = ExcelUtility.getString(0, 1, UtilityFile.excelPath, "ManageDeliveryBoy");
		String email = ExcelUtility.getString(1, 1, UtilityFile.excelPath, "ManageDeliveryBoy");
		String phonenumber = ExcelUtility.getString(2, 1, UtilityFile.excelPath, "ManageDeliveryBoy");
		String address = ExcelUtility.getString(3, 1, UtilityFile.excelPath, "ManageDeliveryBoy");
		String deliveryusername = ExcelUtility.getString(4, 1, UtilityFile.excelPath, "ManageDeliveryBoy");
		String deliverypassword = ExcelUtility.getString(5, 1, UtilityFile.excelPath, "ManageDeliveryBoy");
		String editName = ExcelUtility.getString(0, 2, UtilityFile.excelPath, "ManageDeliveryBoy");
		String editEmail = ExcelUtility.getString(1, 2, UtilityFile.excelPath, "ManageDeliveryBoy");
		String editPhonenumber = ExcelUtility.getString(2, 2, UtilityFile.excelPath, "ManageDeliveryBoy");
		String editAddress = ExcelUtility.getString(3, 2, UtilityFile.excelPath, "ManageDeliveryBoy");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(7, 0, UtilityFile.excelPath, "DashBoard"));
		DeliveryBoyUser user = new DeliveryBoyUser(name, email, phonenumber, address, deliveryusername,deliverypassword);
		manageDeliveryBoyPage = new ManageDeliveryBoyPage(driver);
		manageDeliveryBoyPage.addNewDeliveryBoy(user);
		manageDeliveryBoyPage.clickSearchButton();
		manageDeliveryBoyPage.enterSearchName(name);
		manageDeliveryBoyPage.clickRedSearchButton();
		manageDeliveryBoyPage.clickEditButton();
		assertTrue(manageDeliveryBoyPage.isEditPageDisplayed(), "edit box not displayed");
		manageDeliveryBoyPage.enterName(editName);
		manageDeliveryBoyPage.enterEmail(editEmail);
		manageDeliveryBoyPage.enterPhone(editPhonenumber);
		manageDeliveryBoyPage.enterAddress(editAddress);
		manageDeliveryBoyPage.enterUsername(deliveryusername);
		manageDeliveryBoyPage.enterPassword(deliverypassword);
		manageDeliveryBoyPage.scrollToBottom();
		manageDeliveryBoyPage.clickUpdateButton();
		assertTrue(manageDeliveryBoyPage.checkTitle(editName), "Edited Name not found in table");
		assertTrue(manageDeliveryBoyPage.checkTitle(editEmail), "Edited Email not found in table");
		assertTrue(manageDeliveryBoyPage.checkTitle(deliveryusername), "username not found in table");
		assertTrue(manageDeliveryBoyPage.checkTitle(deliverypassword), "password not found in table");
		assertTrue(manageDeliveryBoyPage.isAlertMessageDisplayed(), "alert box not displayed");
		manageDeliveryBoyPage.deleteDeliveryBoy(editName);
	}

	@Test(retryAnalyzer = Retry.class, priority = 3)
	public void verifyDeleteDeliveryBoy() throws IOException, InterruptedException {
		String searchName = ExcelUtility.getString(0, 0, UtilityFile.excelPath, "ManageDeliveryBoy");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(7, 0, UtilityFile.excelPath, "DashBoard"));
		manageDeliveryBoyPage = new ManageDeliveryBoyPage(driver);
		manageDeliveryBoyPage.clickSearchButton();
		manageDeliveryBoyPage.enterSearchName(searchName);
		manageDeliveryBoyPage.clickRedSearchButton();
		manageDeliveryBoyPage.clickDeleteButton();
		driver.switchTo().alert().accept();
		assertFalse(manageDeliveryBoyPage.checkTitle(searchName), "title not found in table");
		assertTrue(manageDeliveryBoyPage.isAlertMessageDisplayed(), "alert box not displayed");
	}

	@Test(retryAnalyzer = Retry.class, priority = 5)
	public void verifyResetButton() throws IOException, InterruptedException {
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(7, 0, UtilityFile.excelPath, "DashBoard"));
		manageDeliveryBoyPage = new ManageDeliveryBoyPage(driver);
		manageDeliveryBoyPage.clickSearchButton();
		manageDeliveryBoyPage.clickResetButton();
		assertFalse(manageDeliveryBoyPage.isSearchListBoxDisplayed(), "SearchListBox is still displayed");
	}

}
