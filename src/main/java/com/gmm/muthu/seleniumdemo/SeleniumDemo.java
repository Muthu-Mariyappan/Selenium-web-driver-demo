package com.gmm.muthu.seleniumdemo;
import org.openqa.selenium.By;
/**
 * Author: Muthu Mariyappan
 * Title : Selenium chrome/firefox webdriver demo
 * */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/**
 * It is a simple demo of selenium.WebDriver with different implementations to get specific info from target web page
 * I used ChromeDriver and FirefoxDriver for demonstration, similarly we can use different implementation of WebDriver
 * For demonstration of different implementation of WebDriver, I used ChoremDriver to print info about Messi and FirefoxDriver for ronaldo
 * */
public class SeleniumDemo {
	
	/**
	 * This function gets an implementation of WebDriver and target URL as input
	 * Prints the the info about the player along with name and country
	 * */
	private static String getPlayerInfo(WebDriver driver, String URL){
		driver.get(URL); //loads the target page in the corresponding browser window(using driver)
		String name = driver.findElement(By.cssSelector("div.fi-p__name")).getText(); //gets player name
		String country = driver.findElement(By.cssSelector("div.fi-p__country")).getText();//gets player country
		String text = driver.findElements(By.cssSelector("div.fi-p__profile-text")).get(1).getText().replaceAll("\\. ", ".\n");
		driver.close();
		return "\nInformation about "+country+"\'s "+name+"\n\n"+text;	
	}
	
	public static void main(String... args) {
		
		final String FIFA_MESSI_PAGE = "https://www.fifa.com/worldcup/players/player/229397/";
		final String FIFA_RONALDO_PAGE = "https://www.fifa.com/worldcup/players/player/201200/";
		
		//Maps driver property with stored executable driver file
		System.setProperty("webdriver.chrome.driver","L:\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","L:\\geckodriver-v0.20.1-win32\\geckodriver.exe");
		
		//Following two lines help clearing unwanted logs in the console when using firefoxDriver
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		
		WebDriver chromeDriver = new ChromeDriver(); //using ChromeDriver implementation of WebDriver
		WebDriver firefoxDriver = new FirefoxDriver();//using FirefoxDriver version of WebDriver
		
        System.out.println(getPlayerInfo(chromeDriver,FIFA_MESSI_PAGE));
        System.out.println(getPlayerInfo(firefoxDriver,FIFA_RONALDO_PAGE));
	}
}
