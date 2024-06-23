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
	
	@FindBy(id = "pass")
	private WebElement password;
	
	public static void loginPage() {
		
		try {
			input(driver, email, "antartica@gmail.com");
		} catch (Exception e) {
			// TODO: handle exception
		}
	try {
		clickOnElement(driver, signinBtn);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		passInput(driver, password, "priyanka@17");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
