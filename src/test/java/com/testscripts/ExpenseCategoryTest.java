package com.obsquara.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsquara.pages.DashBoardMenuList;
import com.obsquara.pages.ExpenseCategoryPage;
import com.obsquara.pages.LoginSuccess;

import Utilities.ExcelUtility;
import Utilities.UtilityFile;

public class ExpenseCategoryTest extends Base {
	ExpenseCategoryPage expenseCategoryPage;
	LoginSuccess loginSuccess;

	@Test(retryAnalyzer = generaltest.Retry.class, priority = 1)
	@Parameters({ "inputMessage" })
	public void verifyToAddNewExpenseCategory() throws IOException, InterruptedException {
		String expenseCategory = ExcelUtility.getString(0, 0, UtilityFile.excelPath, "ExpenseCategoryName");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(6, 0, UtilityFile.excelPath, "DashBoard"));
		expenseCategoryPage = new ExpenseCategoryPage(driver);
		expenseCategoryPage.clickExpenseCategory().clickNewButton().enterTitleField(expenseCategory);
		assertTrue(expenseCategoryPage.saveButtonisEnabled(), " new expense category");
		expenseCategoryPage.clickSaveButton();
		assertTrue(expenseCategoryPage.checkTitle(expenseCategory), "new expense category is not added sucessfully");
		expenseCategoryPage.deleteExpenseCategory(expenseCategory);
	}

	@Test(retryAnalyzer = generaltest.Retry.class, priority = 2)
	public void verifySearchExpenseCategory() throws IOException, InterruptedException {
		String expenseCategoryTitle = ExcelUtility.getString(0, 0, UtilityFile.excelPath, "ExpenseCategoryName");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(6, 0, UtilityFile.excelPath, "DashBoard"));
		expenseCategoryPage = new ExpenseCategoryPage(driver);
		expenseCategoryPage.clickExpenseCategory().addExpenseCategory(expenseCategoryTitle);
		expenseCategoryPage.clickExpenseCategory().clickSearchButton().enterSearchTitle(expenseCategoryTitle)
				.clickRedSearchButton();
		assertTrue(expenseCategoryPage.checkTitle(expenseCategoryTitle), "new expense category cannot find ");
		expenseCategoryPage.deleteExpenseCategory(expenseCategoryTitle);

	}

	@Test(retryAnalyzer = generaltest.Retry.class, priority = 4)
	public void verifyEditExpenseCategory() throws IOException, InterruptedException {
		String expenseCategoryTitle = ExcelUtility.getString(0, 1, UtilityFile.excelPath, "ExpenseCategoryName");
		String editedExpenseCategoryTitle = ExcelUtility.getString(0, 2, UtilityFile.excelPath, "ExpenseCategoryName");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(6, 0, UtilityFile.excelPath, "DashBoard"));
		expenseCategoryPage = new ExpenseCategoryPage(driver);
		expenseCategoryPage.clickExpenseCategory();
		expenseCategoryPage.addExpenseCategory(expenseCategoryTitle);
		expenseCategoryPage.clickSearchButton().enterSearchTitle(expenseCategoryTitle).clickRedSearchButton()
				.clickEditButton().enterTitleField(editedExpenseCategoryTitle).clickUpdateButton();
		assertTrue(expenseCategoryPage.isAlertBoxDisplayed(), "new expense category cant be edited successfully");
		assertTrue(expenseCategoryPage.checkTitle(editedExpenseCategoryTitle), "");
		expenseCategoryPage.deleteExpenseCategory(editedExpenseCategoryTitle);

	}

	@Test(retryAnalyzer = generaltest.Retry.class, priority = 3)
	public void verifyDeleteExpenseCategory() throws IOException, InterruptedException {
		String inputMessage = ExcelUtility.getString(0, 0, UtilityFile.excelPath, "ExpenseCategoryName");
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages(ExcelUtility.getString(6, 0, UtilityFile.excelPath, "DashBoard"));
		expenseCategoryPage = new ExpenseCategoryPage(driver);
		expenseCategoryPage.clickExpenseCategory().addExpenseCategory(inputMessage);
		expenseCategoryPage.clickExpenseCategory().clickSearchButton().enterSearchTitle(inputMessage)
				.clickRedSearchButton().clickDeleteButton();
		driver.switchTo().alert().accept();
		assertTrue(expenseCategoryPage.isAlertBoxDisplayed(), "expense category not deleted from the table");

	}

}
