package com.Luma.base;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseClass {

	public static WebDriver driver;
	

	public static WebDriver getDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		return driver;
	}

	public static void launchUrl(String url) {
		driver.manage().window().maximize();
		driver.get(url);
	}

	public static boolean elementDisplayed(WebDriver drive,WebElement element) {
		return element.isDisplayed();
		 

	}

	public static void input(WebDriver driver, WebElement element, String value) {
		WebElement element2 = new WebDriverWait(driver, Duration.ofSeconds(30))
        .until(ExpectedConditions.elementToBeClickable(element));
		element2.clear();
		element2.sendKeys(value);
	}

	public static void clickOnElement(WebDriver driver,WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(30))
        .until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public static void screenshot() {

		DateTimeFormatter dateFormatted = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime date = LocalDateTime.now();
		String fileName = date.format(dateFormatted);
		fileName = fileName.replaceAll(" ", "");
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			// File dest = new File(System.getProperty("user.dir") + "\\screenshots\\" +
			// fileName + ".png");
			File dest = new File(".\\screenshots\\" + fileName + ".png");

			FileHandler.copy(src, dest);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void mouseHover(WebDriver driver,WebElement element) {
		new Actions(driver).moveToElement(element).build().perform();
	}

	public static void dragAndDrop(WebDriver driver,WebElement src, WebElement dest) {
		new Actions(driver).dragAndDrop(src, dest).build().perform();
	}

	public static void confirmAlert(WebDriver driver,WebElement element, String condition) {

		Alert confirm_alert = driver.switchTo().alert();
		if (condition.equalsIgnoreCase("accept")) {
			confirm_alert.accept();
		} else if (condition.equalsIgnoreCase("dismiss")) {
			confirm_alert.dismiss();
		}

	}

	public static void selectFromDropDown(WebDriver driver,WebElement element, String option, String value) {

		Select s = new Select(element);
		if (option.equalsIgnoreCase("index")) {
			s.selectByIndex(Integer.parseInt(value));
		} else if (option.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		} else if (option.equalsIgnoreCase("visibleText")) {
			s.selectByVisibleText(value);
		}

	}

	public static void scrollUsingCoordinates(WebDriver driver,int width, int height) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(" + width + "," + height + ");");
	}

	public static void frameUsingIndex(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}

	public static void frameUsingName(WebDriver driver,String name) {
		driver.switchTo().frame(name);
	}

	public static void frameUsingElement(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}

	public static void switchToDefault(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public static void switchWindow(WebDriver driver,int index) {
		Set<String> all_tab_id = driver.getWindowHandles();
		List<String> tab_id_list = new LinkedList<>(all_tab_id);
		driver.switchTo().window(tab_id_list.get(index));
	}


	public static void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public static void explicitWait(WebDriver driver,WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(30))
		.until(ExpectedConditions.visibilityOf(element));
	}
}