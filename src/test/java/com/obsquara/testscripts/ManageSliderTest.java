package com.obsquara.testscripts;

import static constants.Constants.EXCELFILE;
import static constants.Constants.SYSTEM_PATH;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsquara.pages.DashBoardMenuList;
import com.obsquara.pages.LoginSuccess;
import com.obsquara.pages.ManageSliderPage;
import com.obsquara.utilities.Retry;

import Utilities.ExcelUtility;

public class ManageSliderTest extends Base {
	ManageSliderPage manageSliderPage;
	LoginSuccess loginSuccess;

	@Test(retryAnalyzer = Retry.class)
	public void verifyAddingNewLinkinSlider() throws IOException {
		String link = ExcelUtility.getString(0, 0, SYSTEM_PATH + EXCELFILE, "ManageSlider");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(5, 0, SYSTEM_PATH + EXCELFILE, "DashBoard"));
		manageSliderPage = new ManageSliderPage(driver);
		manageSliderPage.clickonNewButton().enterTextinLinkField(link).clickonSaveButton();
		assertTrue(manageSliderPage.alertMessageDisplay(), " failed to add new slider in website ");
	}

	@Test(retryAnalyzer = Retry.class)
	public void verifyEditLinkinSlider() throws IOException {
		String link = ExcelUtility.getString(1, 0, SYSTEM_PATH + EXCELFILE, "ManageSlider");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(5, 0, SYSTEM_PATH + EXCELFILE, "DashBoard"));
		manageSliderPage = new ManageSliderPage(driver);
		manageSliderPage.clickonEditButton().enterTextinLinkField(link).clickonUpdatetButton();
		assertTrue(manageSliderPage.alertMessageDisplay(), "Failed to update the new link");
	}

	@Test(retryAnalyzer = Retry.class)
	public void verifyDeleteLinkinSlider() throws IOException {
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(5, 0, SYSTEM_PATH + EXCELFILE, "DashBoard"));
		manageSliderPage = new ManageSliderPage(driver);
		manageSliderPage.clickonDeletetButton();
		driver.switchTo().alert().accept();
		assertTrue(manageSliderPage.alertMessageDisplay(), " the link is not deleted frm the slider page");

	}

}
