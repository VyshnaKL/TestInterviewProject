package com.obsquara.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class DashBoardMenuList {
	WebDriver driver;

	public DashBoardMenuList(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//li[contains(@class,'nav-item')]//a")
	List<WebElement> pages;

	public void navigateToPages(String pageText) {
		for (WebElement menulist : pages) {
			if (PageUtility.getElementText(menulist).equals(pageText)) {
				PageUtility.clickOnElement(menulist);
				break;
			}

		}

	}

}