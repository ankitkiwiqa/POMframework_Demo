package com.demo.init;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import com.login.index.loginIndex;


/**
 * Hello world!
 *
 */
public class LaunchConfig 
{
	public static void main(String[] args)
    {
    	TestListenerAdapter tla = new TestListenerAdapter();
    	TestNG testng = new TestNG();
    	testng.setTestClasses(new Class[] {loginIndex.class });
    	testng.addListener(tla);
    	testng.run();
    }
}
