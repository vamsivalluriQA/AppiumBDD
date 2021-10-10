package glue;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import pages.Homescreen;

public class Shared 
{
	//declare common objects
	public URL u;
	public Scenario s;
	public Properties p;
	public AndroidDriver<MobileElement> driver;
	public Homescreen hs;
	
	//common methods
	@Before
	public void method1(Scenario s) throws Exception
	{
		//"s" object work for every current scenario
		this.s=s; 
		//load properties file
		FileInputStream fi=new FileInputStream(
				               "src\\test\\resources\\utilities\\config.properties");
		p=new Properties();
		p.load(fi);
		//define driver object
		driver=null;
		//define page class object
		hs=null;
		//start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium\"");
		u=new URL(p.getProperty("appium_server_url"));
	}
	
	@After
	public void method2() throws Exception
	{
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		Thread.sleep(5000);
	}
}
