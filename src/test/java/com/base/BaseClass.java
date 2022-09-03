package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	// 1 - to launch browser
	public static void browserLauncher(Object avatar) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to((String) avatar);
		driver.manage().window().maximize();
	}

	// 2 - to find element by id
	public static WebElement findElementId(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;

	}

	// 3 - to find element by className
	public static WebElement findElementClassName(String className) {
		WebElement element = driver.findElement(By.className(className));
		return element;
	}

	// 4 - to find element by xpath
	public static WebElement findElementXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	// 5 - to find element by tagName
	public static WebElement findElementTagName(String tagName) {
		WebElement element = driver.findElement(By.tagName(tagName));
		return element;
	}

	// 6 - to print the WebElement using Xpath
	public static String printWebElementXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		String text = element.getText();
		return text;
	}

	public static WebElement findElementName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;
	}

	// 7 - to print WebElement using Id
	public static String printWebElementId(String id) {
		WebElement element = driver.findElement(By.id(id));
		String text = element.getText();
		return text;
	}

	// 8 - to print WebElement using className
	public static String printWebElementCName(String className) {
		WebElement element = driver.findElement(By.className(className));
		String text = element.getText();
		return text;
	}

	// 9 - to print WebElement using tagName
	public static String printWebElementtagName(String tagName) {
		WebElement element = driver.findElement(By.tagName(tagName));
		String text = element.getText();
		return text;
	}

	// 10 - to pass values
	public static void sValues(WebElement element, String data) {
		element.sendKeys(data);

	}

	// 11 - to click
	public static void click(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		element.click();

	}

	// 12 - to double click
	public static void doubleClick(String Xpath) {
		WebElement element = driver.findElement(By.xpath(Xpath));
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();

	}

	// 13 - to context click
	public static void contextClick(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}

	// 14 - to scroll into view
	public static void scrollIntoView(String xpath) throws InterruptedException {
		WebElement element = driver.findElement(By.xpath(xpath));
		JavascriptExecutor jk = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		jk.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	// 15 - to take screenshot
	public static void screenShot(String fileName) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File(
				"//Users//jyothieshwariselvam//eclipse-workspace//New_work_space//SeleniumBasic//ScreenShot//"
						+ fileName + ".png");
		FileUtils.copyFile(src, des);
	}

	// 16 - to click on frame
	public void clickFrame(String path1, String path2) {
		WebElement element = driver.findElement(By.xpath(path1));
		driver.switchTo().frame(element);
		WebElement img = driver.findElement(By.xpath(path2));
		img.click();
	}

	// 17 - to return to default
	public void frameReturnDefault() {
		driver.switchTo().defaultContent();
	}

	// 18 - to get text
	public String getText(String path) {
		WebElement element = driver.findElement(By.xpath(path));
		String text = element.getText();
		return text;
	}

	// 19 - to get current url
	public String getCurrentUrl() {
		String title = driver.getTitle();
		return title;

	}

	// 20 - to navigate to url
	public void navigate(String url) {
		driver.navigate().to(url);
	}

	// 21 - to navigate back
	public void navigateBack() {
		driver.navigate().back();
	}

	// 22 - to navigate forward
	public void navigateForward() {
		driver.navigate().forward();
	}

	// 23 - to refresh
	public void refresh() {
		driver.navigate().refresh();
	}

	// 24 - to hold script
	public void holdScript(long l) throws InterruptedException {
		Thread.sleep(l);
	}

	// 25 - to get attribute
	public String getAttribute(String path, String data) {
		WebElement element = driver.findElement(By.xpath(path));
		element.sendKeys(data);
		String attribute = element.getAttribute(data);
		return attribute;

	}

	// 26 - move to element
	public void moveToElement(String path) {
		WebElement element = driver.findElement(By.xpath(path));
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	// 27 - to drag and drop
	public void dragNDrop(String srcPath, String desPath) {
		WebElement src = driver.findElement(By.xpath(srcPath));
		WebElement des = driver.findElement(By.xpath(desPath));
		Actions a = new Actions(driver);
		a.dragAndDrop(src, des);
	}

	// 28 - to accept alert
	public void handleAlert(String path) throws InterruptedException {
		WebElement element = driver.findElement(By.xpath(path));
		element.click();
		Thread.sleep(3000);
		Alert a = driver.switchTo().alert();
		a.accept();

	}

	// 29 - to dismiss alert
	public void dismissAlert() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

	// 30 - to send values in alert
	public void sendValuesInAlert(String data) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(data);
		a.accept();
	}

	// 31 - to select drop down by visible text
	public void selectDropDownVText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	// 32 - to select drop down by value
	public void selectDropDownValue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	// 33 - to select drop down by index
	public void selectDropDownIndex(WebElement element, int value) {
		Select s = new Select(element);
		s.selectByIndex(value);
	}

	// 34 - to print all options
	public void toPrintAllOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (int i = 0; i < allSelectedOptions.size(); i++) {
			System.out.println(allSelectedOptions.get(i).getText());
		}
	}

	// 35 - to copy
	public void copyKey() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_META);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_META);
		r.keyRelease(KeyEvent.VK_C);
	}

	// 36 - to paste
	public void pasteKey() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_META);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_META);
		r.keyRelease(KeyEvent.VK_V);
	}

	// 37 - to get cell data
	public String toGetCellData(String path, String sheetName, int rowNo, int cellNo) throws IOException {
		File file = new File(path);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		String stringCellValue = cell.getStringCellValue();

		return stringCellValue;
	}

	// 38 - to know the cell type
	public int toKnowTheCellType(String path, String sheetName, int rowNo, int cellNo) throws IOException {
		File file = new File(path);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		int cellType = cell.getCellType();
		return cellType;
	}

	// 39 - to iterate all row and cell data
	public void iterateAllData(String path, String sheetName) throws IOException {
		File file = new File(path);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				System.out.println(cell);
			}
		}

	}

	// 40 - to find table elements by tagName
	public WebElement findTableElements(String tagName) {
		WebElement table = driver.findElement(By.tagName(tagName));
		return table;
	}

	// 41 - to know the tableData size
	public int tableDataSize(WebElement table, String tagName) {
		@SuppressWarnings("unchecked")
		List<WebElement> tableData = (List<WebElement>) table.findElement(By.tagName(tagName));
		int dataSize = tableData.size();
		System.out.println("Table Data Size:");
		return dataSize;
	}

	// 42 - to find tableRow elements
	public WebElement findTableRowElements(String tablePath, String rowPath) {
		WebElement table = driver.findElement(By.xpath(tablePath));
		WebElement tableRow = (WebElement) table.findElements(By.tagName(rowPath));
		return tableRow;

	}

	// 43 - to iterate particular row data
	public void iterateParticularRow(String tablePath, String rowPath, String tableTag, int rowNo) {
		WebElement table = driver.findElement(By.xpath(tablePath));
		List<WebElement> tableRow = table.findElements(By.tagName(rowPath));
		List<WebElement> rowData = tableRow.get(rowNo).findElements(By.tagName(tableTag));
		for (int i = 0; i < rowData.size(); i++) {
			String text = rowData.get(i).getText();
			System.out.println(text);
		}
	}

	// 44 - to iterate all rows and columns
	public void iterateAllRowsCells(String tablePath, String rowPath, String tableTag) {
		WebElement table = driver.findElement(By.xpath(tablePath));
		List<WebElement> tableRow = table.findElements(By.tagName(rowPath));
		for (int i = 0; i < tableRow.size(); i++) {
			List<WebElement> data = tableRow.get(i).findElements(By.tagName(tableTag));
			for (int j = 0; j < data.size(); j++) {
				String text = data.get(j).getText();
				System.out.println(text);
			}
		}
	}

	// 45 - to get title
	public String toGetTitle() {
		String title = driver.getTitle();
		return title;
	}

	// 46 - robot action for down
	public void robotDownKey(int index) throws AWTException {
		Robot r = new Robot();
		for (int i = 0; i < index; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	// - to close
	public void close() {
		driver.close();
	}

	// - to quit
	public void quit() {
		driver.quit();
	}
	
	// - frefox browser launch
	public static void browserLaunchFirefox(String url) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(url);
	}

}
