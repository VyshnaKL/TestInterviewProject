package Utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public static void clickOnElement(WebElement element) {
		element.click();
	}

	public static boolean isEnabled(WebElement element) {
		boolean status = element.isEnabled();
		return status;
	}

	public static boolean isDisplay(WebElement element) {
		boolean status = element.isDisplayed();
		return status;
	}

	public static WebElement enterText(WebElement element, String value) {
		element.sendKeys(value);
		return element;
	}

	public static void sendKey(WebElement element, String s) {
		element.sendKeys(s);
	}

	public static String getElementText(WebElement element) {
		return element.getText();
	}

	public static String getElementFontColor(WebElement element, String value) {
		return element.getCssValue(value);
	}

	public static void clickAndHoldOnElement(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).build().perform();
	}

	public static void selectDropdownbyText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public static void selectDropdownbyIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public static WebElement enterIntValue(WebElement element, CharSequence[] value) {
		element.sendKeys(value);
		return element;
	}

	public static boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public static boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	public static void ScrollBy(WebDriver driver) {
		JavascriptExecutor Js1 = (JavascriptExecutor) driver;
		Js1.executeScript("window.scrollBy(0,2500)");
	}

	public static void stopPageRefresh(WebDriver driver) {
		JavascriptExecutor Js1 = (JavascriptExecutor) driver;
		Js1.executeScript("window.stop();");

	}

	public static String getToolTip(WebElement element) {
		return element.getAttribute("title");
	}

	public static String getValue(WebElement element) {
		return element.getAttribute("value");
	}

	public static void getClickElement(WebElement element) {
		element.click();
	}

	public static void mediumDelay(int x) throws InterruptedException {
		Thread.sleep(x);
	}

	public static void selectFuncbyindex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);

	}

	public static void selectFuncbyValue(WebElement element, String value) {
		Select select1 = new Select(element);
		select1.selectByValue(value);

	}

	public static String selectFuncbyVisibletext(WebElement element, String visibletext) {
		Select select = new Select(element);
		select.selectByVisibleText(visibletext);
		WebElement selectedValue = select.getFirstSelectedOption();
		return (selectedValue.getText());

	}

	public static String FirstSelectedOption(WebElement element) {
		Select select1 = new Select(element);
		String firstoption = select1.getFirstSelectedOption().getText();
		return (firstoption);
	}

	public static List<WebElement> getAllOptions(Select s) {

		List<WebElement> op = s.getOptions();

		return op;

	}

	public static List<String> convertToStringList(List<WebElement> weList) {
		List<String> strList = new ArrayList<String>();
		for (int i = 0; i < weList.size(); i++) {

			strList.add(weList.get(i).getText());
		}

		return strList;

	}

	public static String stylePropertyValidation(WebElement element, String propertyType) {
		return element.getCssValue(propertyType);
	}

	public static boolean isSelected(WebElement element) {
		return element.isSelected();
	}

	public static List<String> addList(List<String> list, String s) {

		list.add(s);

		return list;
	}

	public static void alertHandlingaccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public static String alerttext(WebDriver driver) {
		return (driver.switchTo().alert().getText());
	}

	public static boolean getElementTextList(List<WebElement> chkList, String element) {

		boolean value = true;
		for (int i = 0; i < chkList.size(); i++) {

			String text = chkList.get(i).getText();

			if (!text.equals(element))

			{
				value = false;

			}
		}

		return value;
	}

	public static boolean compareLists(List<String> actuallist, List<String> expectedlist) {
		boolean value = true;
		for (int i = 0; i < actuallist.size(); i++) {
			if (!actuallist.get(i).equals(expectedlist.get(i))) {
				value = false;
			}
		}

		return value;
	}

	public static void managSliderList(List<WebElement> actuallist, List<WebElement> element) {
		for (int i = 0; i < actuallist.size(); i++) {
			String text = actuallist.get(i).getText();

			if (!text.equals(element)) {
				break;
			}
		}
	}

	public static void clickAction(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();

	}

	public static void mouseHoverAction(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

	}

	public static void doubleClickAction(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();

	}

	public static void rightClickAction(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();

	}

	public static void clickAndHoldAction(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.clickAndHold(element).perform();
	}

	public static void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions action = new Actions(driver);
		action.clickAndHold(source).moveToElement(target).release(target).build().perform();
	}
}
