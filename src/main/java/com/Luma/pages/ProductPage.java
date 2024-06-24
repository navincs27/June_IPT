package com.Luma.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Luma.base.BaseClass;

public class ProductPage extends BaseClass{

	WebDriver driver;
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[text()='M']")
	public WebElement sizebtn;
	
	public void productSelect() {
		clickOnElement(driver, sizebtn);
	}
}
