package com.obsquara.testscripts;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsquara.pages.DashBoardMenuList;
import com.obsquara.pages.LoginSuccess;
import com.obsquara.pages.ManageLocationPage;

import Utilities.ExcelUtility;
import Utilities.UtilityFile;

public class ManageLocationTest extends Base {
	ManageLocationPage manageLocationPage;
	LoginSuccess loginSuccess;

	@Test(priority = 1)
	public void verifytheAddingNewLocation() throws IOException, InterruptedException {
		String location = ExcelUtility.getString(0, 0, UtilityFile.excelPath, "ManageLocation");
		String deliveryAmount = ExcelUtility.getString(2, 0, UtilityFile.excelPath, "ManageLocation");
		String state = ExcelUtility.getString(3, 0, UtilityFile.excelPath, "ManageLocation");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(13, 0, UtilityFile.excelPath, "DashBoard"));
		manageLocationPage = new ManageLocationPage(driver);
		manageLocationPage.addNewLocation(state, location, deliveryAmount);
		assertTrue(manageLocationPage.isAlertBoxDisplayed(), " the new location is not added");
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(13, 0, UtilityFile.excelPath, "DashBoard"));
		manageLocationPage.deleteLocation(state, location);
	}
	
	@Test(priority = 2)
	public void verifytheSearchManageLocation() throws IOException, InterruptedException {
		String searchName = ExcelUtility.getString(0, 0, UtilityFile.excelPath, "ManageLocation");
		String state = ExcelUtility.getString(3, 0, UtilityFile.excelPath, "ManageLocation");
		String deliveryAmount = ExcelUtility.getString(2, 0, UtilityFile.excelPath, "ManageLocation");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(13, 0, UtilityFile.excelPath, "DashBoard"));
		manageLocationPage = new ManageLocationPage(driver);
		manageLocationPage.addNewLocation(state, searchName, deliveryAmount);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(13, 0, UtilityFile.excelPath, "DashBoard"));
		manageLocationPage.searchLocation(state, searchName);
		assertTrue(manageLocationPage.checkTitle(searchName), "location cant find in table list");
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(13, 0, UtilityFile.excelPath, "DashBoard"));
		manageLocationPage.deleteLocation(state, searchName);
	}

	@Test(priority = 3)
	public void verifytheDeleteButtoninManageLocation() throws IOException, InterruptedException {
		String location = ExcelUtility.getString(0, 0, UtilityFile.excelPath, "ManageLocation");
		String state = ExcelUtility.getString(3, 0, UtilityFile.excelPath, "ManageLocation");
		String deliveryAmount = ExcelUtility.getString(2, 0, UtilityFile.excelPath, "ManageLocation");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(13, 0, UtilityFile.excelPath, "DashBoard"));
		manageLocationPage = new ManageLocationPage(driver);
		manageLocationPage.addNewLocation(state, location, deliveryAmount);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(13, 0, UtilityFile.excelPath, "DashBoard"));
		manageLocationPage.deleteLocation(state, location);
		assertFalse(manageLocationPage.checkTitle(location), " location not find in table");
		assertTrue(manageLocationPage.isAlertBoxDisplayed(), "location not deleted successfully");
	}
}
