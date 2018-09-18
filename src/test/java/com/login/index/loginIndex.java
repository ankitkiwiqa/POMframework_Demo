package com.login.index;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.init.Common;
import com.demo.init.SeleniumInit;

public class loginIndex extends SeleniumInit{

	@Test
	public void logintest()
	{
		String Username= "user2";
		String password="pass2";
		
		Common.logcase("Test Case1: Login to the Account");
		
		Common.logstep("Step 1. Open URL: 'http://store.demoqa.com/products-page/your-account/'");
		
		Common.logstep("Step 2. Enter Username: "+Username);
		login_index.enterUsername(Username);
		
		Common.logstep("Step 3. Enter Password: "+ password);
		login_index.enterPassword(password);
		
		Common.logstep("Step 4. Click on 'Login' button.");
		login_index.clickonLogin();
		
		Common.logverification("Verify that user should show validation message for blank field.");
		if(login_verification.LoginblankValidation())
		{
			Common.logverification("Test Passed.");
			Assert.assertTrue(true);
		}else {
			Common.logverification("Test Failed.");
			Assert.assertTrue(false);
		}
		
	}
	
	
}
