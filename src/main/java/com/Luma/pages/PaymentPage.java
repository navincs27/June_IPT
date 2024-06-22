package com.Luma.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Luma.base.BaseClass;

public class PaymentPage extends BaseClass{
	WebDriver driver;
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//button[@title='Place Order']")
	private WebElement placeOrder;
	
	
public void paymentModule() {
	clickOnElement(driver,placeOrder);
	System.out.println("*********Order placed successfully***********");
}
}
