package com.MovieDetails;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Endpoints.Endpoints;
import com.base.BaseClass;
/**
 * 
 * @author Dhinakaran S
 * @module Details of the movie "Pushpa: The Rise"
 * @created 02-Sep-2022
 *
 */
public class MovieDetails extends BaseClass implements Endpoints {
	
	static Logger logger = (Logger) LogManager.getLogger();

	/**
	 * 
	 * @return movieName
	 */
	@DataProvider(name = "mName")
	private Object[] dataPro() {
		
		// Passing the user defined movie name as dataProvider

		Object[] movieName = new Object[1];
		movieName[0] = "Pushpa: The Rise";

		return movieName;
	}

	@BeforeTest
	private void timerStart() {

		// Start time of the test
		
		long startTime = System.currentTimeMillis();
		System.out.println("Start Time : " + startTime);
	}

	/**
	 * 
	 * @param movieName
	 * @throws IOException 
	 */
	@Test(dataProvider = "mName", priority = 1)
	private void iMDB(String movieName) throws IOException {
		logger.info("Browser Opened and URL loaded - IMDB");
		browserLauncher(Endpoints.IMDB);
		BrowserFactory bFac = new BrowserFactory();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		bFac.getImdbSearchBar().sendKeys(movieName);
		bFac.getImdbSrcBtn().click();
		logger.info("Title searched - IMDB");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		bFac.getOptionSelect().click();
		logger.info("First Option Seleted - IMDB");
		String titleText = bFac.getTitleIMDB().getText();

		// Assertion for the Title
		
		Assert.assertEquals(titleText, "Pushpa: The Rise - Part 1");
		logger.info("Assertion for Title and print title - IMDB");
		
		// Scroll into view
		
		JavascriptExecutor jk = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		jk.executeScript("arguments[0].scrollIntoView(true)", bFac.getImdbDetails());
		
		// Take screenShot
		
		TakesScreenshot tk = (TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("/Users/jyothieshwariselvam/eclipse-workspace/New_work_space/"
				+ "AssignmentTV/screenshots/imdbDetails.png");
		FileUtils.copyFile(src, des);
		
		// Get the release date and assert

		String iMDBReDate = bFac.getImdbReleaseDate().getText();
		Assert.assertEquals(iMDBReDate, "December 17, 2021 (India)");
		logger.info("Assertion for the date and print date - IMDB");
		
		// Get the country of release and assert

		String iMDBCoO = bFac.getImdbCoOrigin().getText();
		Assert.assertEquals(iMDBCoO, "India");
		logger.info("Assertion for Country and Print it - IMDB");
		
		System.out.println(titleText + " :");
		System.out.println("Release Date: " + iMDBReDate);
		System.out.println("Country: " + iMDBCoO);
	}

	/**
	 * 
	 * @param movieName
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	@Test(dataProvider = "mName", priority = 2)
	private void wiki(String movieName) throws IOException, InterruptedException {
		logger.info("Browser Opened and URL loaded - Wiki");
		browserLauncher(Endpoints.WIKI);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		BrowserFactory bFact = new BrowserFactory();
		bFact.getWikiSearchBar().sendKeys(movieName);
		bFact.getWikiSrcBtn().click();
		logger.info("Title searched - Wiki");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// Assertion for the title

		String titletext = bFact.getWikiTitle().getText();
		Assert.assertEquals(titletext, movieName);
		logger.info("Assertion for Title and print title - Wiki");
		
		// Scroll into view
		
		JavascriptExecutor jk = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		jk.executeScript("arguments[0].scrollIntoView(true)", bFact.getWikiTitle());
		
		// Take screenShot
				
		TakesScreenshot tk = (TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("/Users/jyothieshwariselvam/eclipse-workspace/New_work_space/"
				+ "AssignmentTV/screenshots/wikiDetails.png");
		FileUtils.copyFile(src, des);

		// Get the release date and assert
		
		String wikiRedate = bFact.getWikiReleasedate().getText();
		Assert.assertEquals(wikiRedate, "17 December 2021");
		logger.info("Assertion for the date and print date - Wiki");

		Thread.sleep(8000);

		// Get the country of release and assert
		
		String wikiCountry = bFact.getWikiCountry().getText();
		Assert.assertEquals(wikiCountry, "India");
		logger.info("Assertion for Country and Print it - Wiki");
		
		System.out.println(titletext + " :");
		System.out.println("Release Date: " + wikiRedate);
		System.out.println("Country: " + wikiCountry);
	}

	@AfterTest
	private void timerEnd() {
		
		// End time of the test
		
		long endTime = System.currentTimeMillis();
		System.out.println("End Time : " + endTime);
	}

	/**
	 * 
	 * @throws InterruptedException
	 */
	@AfterClass
	private void browserClose() throws InterruptedException {

		// Close the driver
		logger.info("Browser closed");
		driver.close();
	}

}
