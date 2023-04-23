package com.obsquara.testscripts;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsquara.pages.AdminUserPage;
import com.obsquara.pages.DashBoardMenuList;
import com.obsquara.pages.LoginSuccess;
import com.obsquara.pages.SettingPage;

public class AdminUserTest extends Base {
	AdminUserPage adminUserPage;
	LoginSuccess loginSuccess;
	
	@Test(dataProvider = "LoginProvider")
	public void verifyNewAdminUser(String username, String password) throws IOException {
		loginSuccess = new LoginSuccess(driver);
		loginSuccess.login();
		DashBoardMenuList DashBoardMenuListObj = new DashBoardMenuList(driver);
		DashBoardMenuListObj.navigateToPages("Admin Users");
		adminUserPage= new AdminUserPage(driver);
		adminUserPage.clickonNewUser();
		adminUserPage.enterPasswordField(username);
		adminUserPage.enterUserNameField(password);
		adminUserPage.selectbyDropdownIndex();
		adminUserPage.clickonSaveNotification();
		
		
		
	}
	
	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromDataprovider() {
		return new Object[][] { { "Vyshna", "V123" }, };

	}

}
