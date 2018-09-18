package demo.DEmo1;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import com.login.index.loginIndex;

public class RunTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestListenerAdapter tla = new TestListenerAdapter();
    	TestNG testng = new TestNG();
    	testng.setTestClasses(new Class[] {loginIndex.class });
    	testng.addListener(tla);
    	testng.run();
	}

}
