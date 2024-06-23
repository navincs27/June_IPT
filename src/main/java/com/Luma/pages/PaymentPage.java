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
	
<<<<<<< HEAD
	
	@FindBy(xpath = "//button[@title='Place Order']")
	private WebElement placeOrder;
	
	
public void paymentModule() {
	clickOnElement(driver,placeOrder);
	System.out.println("*********Order placed successfully***********");
}
=======
	@FindBy(id="block-discount-heading")
	private WebElement apply_Discount;

>>>>>>> be4629af47e91b44f482deff32c3e3af3e8ecb27
}
