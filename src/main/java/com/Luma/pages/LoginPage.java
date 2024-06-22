package com.Luma.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Luma.base.BaseClass;

public class LoginPage extends BaseClass{

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "send2")
	private WebElement signIN;
	
	public static void Loginpage() {
		
		clickOnElement(driver, signIN);
	}
	
	
}
