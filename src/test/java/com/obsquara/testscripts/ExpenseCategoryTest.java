package com.obsquara.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsquara.pages.ExpenseCategoryPage;

import Utilities.ExcelUtility;
import constants.Constants;

public class ExpenseCategoryTest extends Base {
	ExpenseCategoryPage expenseCategoryPage;

	@Test

	@Parameters({ "inputMessage" })
	public void verifyToAddNewTitle() throws IOException {
		String inputMessage = ExcelUtility.getString(0, 0, System.getProperty("user.dir") + Constants.EXCELFILE,
				"ExpenseCategoryName");
		expenseCategoryPage = new ExpenseCategoryPage(driver);
		expenseCategoryPage.login();
		expenseCategoryPage.clickManageExpense();
		expenseCategoryPage.clickExpenseCategory();
		expenseCategoryPage.clickNewButton();
		expenseCategoryPage.enterTitleField(inputMessage);
		assertTrue(expenseCategoryPage.saveButtonisEnabled(), " Title not saved");
		expenseCategoryPage.clickSaveButton();
		assertTrue(expenseCategoryPage.checkTitle(inputMessage), "title not found in table");
	}

}
