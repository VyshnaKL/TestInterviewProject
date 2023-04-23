package com.obsquara.testscripts;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsquara.pages.DashBoardMenuList;
import com.obsquara.pages.DeliveryBoyUser;
import com.obsquara.pages.LoginSuccess;
import com.obsquara.pages.ManageDeliveryBoyPage;

import Utilities.ExcelUtility;
import constants.Constants;

public class ManageDeliveryBoyTest extends Base {

	ManageDeliveryBoyPage manageDeliveryBoyPage;
	LoginSuccess loginSuccess;

	@Test(priority = 1)
	public void verifyToAddNewDeliveryBoy() throws IOException, InterruptedException {

		String name = ExcelUtility.getString(0, 0, System.getProperty("user.dir") + Constants.EXCELFILE,
				"ManageDeliveryBoy");
		String email = ExcelUtility.getString(1, 0, System.getProperty("user.dir") + Constants.EXCELFILE,
				"ManageDeliveryBoy");
		String phonenumber = ExcelUtility.getString(2, 0, System.getProperty("user.dir") + Constants.EXCELFILE,
				"ManageDeliveryBoy");
		String address = ExcelUtility.getString(3, 0, System.getProperty("user.dir") + Constants.EXCELFILE,
				"ManageDeliveryBoy");
		String deliveryusername = ExcelUtility.getString(4, 0, System.getProperty("user.dir") + Constants.EXCELFILE,
				"ManageDeliveryBoy");
		String deliverypassword = ExcelUtility.getString(5, 0, System.getProperty("user.dir") + Constants.EXCELFILE,
				"ManageDeliveryBoy");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages("Manage Delivery Boy");
		manageDeliveryBoyPage = new ManageDeliveryBoyPage(driver);
		manageDeliveryBoyPage.clickNewButton();
		manageDeliveryBoyPage.enterNameField(name);
		manageDeliveryBoyPage.enterEmailField(email);
		manageDeliveryBoyPage.enterPhoneNumberField(phonenumber);
		manageDeliveryBoyPage.enterAddressField(address);
		manageDeliveryBoyPage.enterUserNameField(deliveryusername);
		manageDeliveryBoyPage.enterPasswordField(deliverypassword);
		manageDeliveryBoyPage.clickSaveButton();
		assertTrue(manageDeliveryBoyPage.checkTitle(name), "title not found in table");

	}

	@Test(priority = 2)
	public void verifySearchDeliveryBoy() throws IOException, InterruptedException {
		String searchName = ExcelUtility.getString(0, 0, System.getProperty("user.dir") + Constants.EXCELFILE,
				"ManageDeliveryBoy");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages("Manage Delivery Boy");
		manageDeliveryBoyPage = new ManageDeliveryBoyPage(driver);
		manageDeliveryBoyPage.clickSearchButton();
		manageDeliveryBoyPage.enterSearchName(searchName);
		manageDeliveryBoyPage.clickRedSearchButton();
		assertTrue(manageDeliveryBoyPage.checkTitle(searchName), "title not found in table");
	}

	@Test(priority = 4)
	public void verifyEditDeliveryBoy() throws IOException, InterruptedException {

		String name = ExcelUtility.getString(0, 1, System.getProperty("user.dir") + Constants.EXCELFILE,
				"ManageDeliveryBoy");
		String email = ExcelUtility.getString(1, 1, System.getProperty("user.dir") + Constants.EXCELFILE,
				"ManageDeliveryBoy");
		String phonenumber = ExcelUtility.getString(2, 1, System.getProperty("user.dir") + Constants.EXCELFILE,
				"ManageDeliveryBoy");
		String address = ExcelUtility.getString(3, 1, System.getProperty("user.dir") + Constants.EXCELFILE,
				"ManageDeliveryBoy");
		String deliveryusername = ExcelUtility.getString(4, 1, System.getProperty("user.dir") + Constants.EXCELFILE,
				"ManageDeliveryBoy");
		String deliverypassword = ExcelUtility.getString(5, 1, System.getProperty("user.dir") + Constants.EXCELFILE,
				"ManageDeliveryBoy");
		String editName = ExcelUtility.getString(0, 2, System.getProperty("user.dir") + Constants.EXCELFILE,
				"ManageDeliveryBoy");
		String editEmail = ExcelUtility.getString(1, 2, System.getProperty("user.dir") + Constants.EXCELFILE,
				"ManageDeliveryBoy");
		String editPhonenumber = ExcelUtility.getString(2, 2, System.getProperty("user.dir") + Constants.EXCELFILE,
				"ManageDeliveryBoy");
		String editAddress = ExcelUtility.getString(3, 2, System.getProperty("user.dir") + Constants.EXCELFILE,
				"ManageDeliveryBoy");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages("Manage Delivery Boy");
		DeliveryBoyUser user = new DeliveryBoyUser(name, email, phonenumber, address, deliveryusername,
				deliverypassword);
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
		manageDeliveryBoyPage.clickUpdateButton();
		assertTrue(manageDeliveryBoyPage.checkTitle(editName), "Edited Name not found in table");
		assertTrue(manageDeliveryBoyPage.checkTitle(editEmail), "Edited Email not found in table");
		//assertTrue(manageDeliveryBoyPage.checkTitle(editAddress), "Edited Address not found in table");
		assertTrue(manageDeliveryBoyPage.checkTitle(deliveryusername), "username not found in table");
		assertTrue(manageDeliveryBoyPage.checkTitle(deliverypassword), "password not found in table");
		assertTrue(manageDeliveryBoyPage.isAlertMessageDisplayed(), "alert box not displayed");

		manageDeliveryBoyPage.deleteDeliveryBoy(editName);

	}

	@Test(priority = 3)
	public void verifyDeleteDeliveryBoy() throws IOException, InterruptedException {
		String searchName = ExcelUtility.getString(0, 0, System.getProperty("user.dir") + Constants.EXCELFILE,
				"ManageDeliveryBoy");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages("Manage Delivery Boy");
		manageDeliveryBoyPage = new ManageDeliveryBoyPage(driver);
		manageDeliveryBoyPage.clickSearchButton();
		manageDeliveryBoyPage.enterSearchName(searchName);
		manageDeliveryBoyPage.clickRedSearchButton();
		manageDeliveryBoyPage.clickDeleteButton();
		driver.switchTo().alert().accept();
		assertFalse(manageDeliveryBoyPage.checkTitle(searchName), "title not found in table");
		assertTrue(manageDeliveryBoyPage.isAlertMessageDisplayed(), "alert box not displayed");
	}

	@Test(priority = 5)
	public void verifyResetButton() throws IOException, InterruptedException {
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages("Manage Delivery Boy");
		manageDeliveryBoyPage = new ManageDeliveryBoyPage(driver);
		manageDeliveryBoyPage.clickSearchButton();
		manageDeliveryBoyPage.clickResetButton();
		assertFalse(manageDeliveryBoyPage.isSearchListBoxDisplayed(), "SearchListBox is still displayed");
	}

}
