package com.MovieDetails;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Dhinakaran S
 * @module Details of the movie "Pushpa: The Rise"
 * @created 02-Sep-2022
 * @description page object model for locators
 *
 */
public class BrowserFactory extends BaseClass {

	public BrowserFactory() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "suggestion-search")
	private WebElement imdbSearchBar;

	@FindBy(xpath = "(//h3[@class='ipc-title__text'])[9]")
	private WebElement imdbDetails;

	@FindBy(id = "suggestion-search-button")
	private WebElement imdbSrcBtn;

	@FindBy(xpath = "(//tr[@class='findResult odd']//child::a)[2]")
	private WebElement optionSelect;

	@FindBy(xpath = "//h1[@data-testid='hero-title-block__title']")
	private WebElement titleIMDB;

	@CacheLookup
	@FindBy(xpath = "(//li[@data-testid='title-details-releasedate']//child::a)[2]")
	private WebElement imdbReleaseDate;

	@CacheLookup
	@FindBy(xpath = "//li[@data-testid='title-details-origin']//child::a")
	private WebElement imdbCoOrigin;

	@FindBy(id = "searchInput")
	private WebElement wikiSearchBar;

	@FindBy(id = "searchButton")
	private WebElement wikiSrcBtn;

	@FindBy(id = "firstHeading")
	private WebElement wikiTitle;

	@CacheLookup
	@FindBy(xpath = "(//td[@class='infobox-data']//child::li)[10]")
	private WebElement wikiReleasedate;

	@CacheLookup
	@FindBy(xpath = "(//td[@class='infobox-data'])[12]")
	public WebElement wikiCountry;

	/**
	 * 
	 * @return imdbSearchBar
	 */
	public WebElement getImdbSearchBar() {
		return imdbSearchBar;
	}

	/**
	 * 
	 * @return imdbDetails
	 */
	public WebElement getImdbDetails() {
		return imdbDetails;
	}

	/**
	 * 
	 * @return imdbReleaseDate
	 */
	public WebElement getImdbReleaseDate() {
		return imdbReleaseDate;
	}

	/**
	 * 
	 * @return imdbCoOrigin
	 */
	public WebElement getImdbCoOrigin() {
		return imdbCoOrigin;
	}

	/**
	 * 
	 * @return wikiSearchBar
	 */
	public WebElement getWikiSearchBar() {
		return wikiSearchBar;
	}

	/**
	 * 
	 * @return wikiReleasedate
	 */
	public WebElement getWikiReleasedate() {
		return wikiReleasedate;
	}

	/**
	 * 
	 * @return wikiCountry
	 */
	public WebElement getWikiCountry() {
		return wikiCountry;
	}

	/**
	 * 
	 * @return optionSelect
	 */
	public WebElement getOptionSelect() {
		return optionSelect;
	}

	/**
	 * 
	 * @return titleIMDB
	 */
	public WebElement getTitleIMDB() {
		return titleIMDB;
	}

	/**
	 * 
	 * @return imdbSrcBtn
	 */
	public WebElement getImdbSrcBtn() {
		return imdbSrcBtn;
	}

	/**
	 * 
	 * @return wikiSrcBtn
	 */
	public WebElement getWikiSrcBtn() {
		return wikiSrcBtn;
	}

	/**
	 * 
	 * @return wikiTitle
	 */
	public WebElement getWikiTitle() {
		return wikiTitle;
	}

}
