package com.login.verification;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.demo.init.AbstractPage;
import com.demo.init.Common;

public class loginverification extends AbstractPage {

	public loginverification(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath="//p[text()='Please enter your username and password.']")
	WebElement blank_validation;
	
	public boolean LoginblankValidation()
	{
		return Common.isElementDisplayed(blank_validation);
	}
	
	

	
	
}
