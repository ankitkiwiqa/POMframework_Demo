package com.login.indexpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.demo.init.AbstractPage;
import com.demo.init.Common;

public class loginindexpage extends AbstractPage{

	public loginindexpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@id='log']")
	WebElement txt_username;
	
	@FindBy(xpath="//input[@id='pwd']")
	WebElement txt_password;
	
	@FindBy(xpath="//input[@id='login']")
	WebElement btn_login;
	
	public void enterUsername(String Username)
	{
		Common.type(txt_username, Username);
	}
	
	public void enterPassword(String password)
	{
		Common.type(txt_password, password);
	}
	
	public void clickonLogin()
	{
		Common.clickOn(driver, btn_login);
	}

}
