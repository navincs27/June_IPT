package com.Luma.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Luma.base.BaseClass;

public class HomePage extends BaseClass{

	WebDriver driver;
	
	@FindBy(xpath ="//a[@id='ui-id-5']")
	private WebElement men;
	
	@FindBy(xpath ="//a[@id='ui-id-17']")
	private WebElement tops;
	
	@FindBy(xpath ="//a[@id='ui-id-19']")
	private WebElement jackets;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void categoryPage() {
		mouseover(men, driver);
		mouseover(tops, driver);
		clickTheElement(jackets, driver);
	}
	
}
