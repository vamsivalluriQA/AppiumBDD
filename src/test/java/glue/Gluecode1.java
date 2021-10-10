package glue;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import pages.Homescreen;

public class Gluecode1
{
	//"Shared" class can provide other reusable classes objects
	public Shared sh; 
	//Constructor method to get association with "Shared" class
	public Gluecode1(Shared sh)
	{
		this.sh=sh;
	}
	
	//Step definitions
	@Given("^launch app$")
	public void method2()
	{
		//Maintain details base for app and AVD
		DesiredCapabilities dc=new DesiredCapabilities();
	    dc.setCapability("deviceName",sh.p.getProperty("udid"));
	    dc.setCapability("platformName",sh.p.getProperty("platform"));
	    dc.setCapability("platformVersion",sh.p.getProperty("version"));
		dc.setCapability("appPackage",sh.p.getProperty("app_package_name"));
	    dc.setCapability("appActivity",sh.p.getProperty("app_activity_name"));
		//Launch app in AVD through appium server
		while(2>1)
		{
			try
			{
				sh.driver=new AndroidDriver<MobileElement>(sh.u,dc);
				break;
			}
			catch(Exception ex)
			{
			}
		}
		//create object to page class
		sh.hs=new Homescreen(sh.driver);
	}
	
	@Then("^validate operation with given data$")
	public void method3(DataTable testdata) throws Exception
	{
		//Goto each map(every map is having 3 entries)
		for(Map<String,String> data:testdata.asMaps())
		{
			try
			{
				//wait for app launching
			    Thread.sleep(5000);
			    //Enter input1(by clicking required button)
			    for(int i=0;i<data.get("input1").length();i++)
			    {
			    	char d=data.get("input1").charAt(i);
			    	if(d=='-')
			    	{
			    		sh.hs.clickminus();
			    		Thread.sleep(2000);
			    	}
			    	else
			    	{
			    		sh.driver.findElement(By.xpath(
			    		                "//android.widget.Button[@text='"+d+"']")).click();
			    		Thread.sleep(2000);
			    	}
			    }
			    //Click button for operation
			    if(data.get("operation").equalsIgnoreCase("add"))
			    {
			    	sh.hs.clickadd();
			    	Thread.sleep(2000);
			    }
			    else if(data.get("operation").equalsIgnoreCase("subtract"))
			    {
			    	sh.hs.clickminus();
			    	Thread.sleep(2000);
			    }
			    else if(data.get("operation").equalsIgnoreCase("multiply"))
			    {
			    	sh.hs.clickmultiply();
			    	Thread.sleep(2000);
			    }
			    else
			    {
			    	sh.hs.clickdivide();
			    	Thread.sleep(2000);
			    }
			    //Enter input2
			    for(int i=0;i<data.get("input2").length();i++)
			    {
			    	char d=data.get("input2").charAt(i);
			    	if(d=='-')
			    	{
			    		sh.hs.clickminus();
			    		Thread.sleep(2000);
			    	}
			    	else
			    	{
			    		sh.driver.findElement(By.xpath(
			    		            "//android.widget.Button[@text='"+d+"']")).click();
			    		Thread.sleep(2000);
			    	}
			    }
			    //Click equals
			    sh.hs.clickequals();
			    Thread.sleep(10000);
			    //Get output
			    String temp=sh.hs.getoutput();
			    //validation
			    float i1=Float.parseFloat(data.get("input1"));
			    float i2=Float.parseFloat(data.get("input2"));
			    float o=Float.parseFloat(temp);
			    if(data.get("operation").equalsIgnoreCase("add") && o==i1+i2)
			    {
			    	sh.s.log(data.get("operation")+" Test passed");
			    }
			    else if(data.get("operation").equalsIgnoreCase("subtract") && o==i1-i2)
			    {
			    	sh.s.log(data.get("operation")+" Test passed");
			    }
			    else if(data.get("operation").equalsIgnoreCase("multiply") && o==i1*i2)
			    {
			    	sh.s.log(data.get("operation")+" Test passed");
			    }
			    else if(data.get("operation").equalsIgnoreCase("divide") && o==i1/i2)
			    {
			    	sh.s.log(data.get("operation")+" Test passed");
			    }
			    else
			    {
			    	byte[] b=((TakesScreenshot)sh.driver).getScreenshotAs(OutputType.BYTES);
			    	sh.s.attach(b,"png",data.get("operation")+" Test failed");
			    	Assert.fail(); //to stop failed scenario's next steps
			    }
			    //clear output
			    sh.hs.clickclear();
			}
			catch(Exception ex)
			{
			    byte[] b=((TakesScreenshot)sh.driver).getScreenshotAs(OutputType.BYTES);
		    	sh.s.attach(b,"png",data.get("operation")+" "+ex.getMessage());
			    Assert.fail(); 
			} 
		} //for each loop closing
	} //method closing
	
	@And("^close app$")
	public void method4()
	{
		sh.driver.quit();
	}
}


