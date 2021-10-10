package glue;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import io.cucumber.java.en.Then;

public class Gluecode3
{
	//"Shared" class can provide other reusable classes objects
	public Shared sh; 
	//Constructor method to get association with "Shared" class
	public Gluecode3(Shared sh)
	{
		this.sh=sh;
	}
	
	//Step definitions
	@Then("^validate addition using \"(.*)\" and \"(.*)\"$")
	public void method6(String x, String y)
	{
		try
		{
			//wait for app launching
		    Thread.sleep(5000);
		    //Enter input1(by clicking required button)
		    for(int i=0;i<x.length();i++)
		    {
		    	char d=x.charAt(i);
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
		    sh.hs.clickadd();
		    //Enter input2
		    for(int i=0;i<y.length();i++)
		    {
		    	char d=y.charAt(i);
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
		    Thread.sleep(5000);
		    //Get output
		    String temp=sh.hs.getoutput();
		    //validation
		    float i1=Float.parseFloat(x);
		    float i2=Float.parseFloat(y);
		    float o=Float.parseFloat(temp);
		    if(o==i1+i2)
		    {
		    	sh.s.log("Addition Test passed");
		    }
		    else
		    {
		    	byte[] b=((TakesScreenshot)sh.driver).getScreenshotAs(OutputType.BYTES);
		    	sh.s.attach(b,"png","Addition Test failed");
		    	Assert.fail(); //to stop failed scenario's next steps
		    }
		    //clear output
		    sh.hs.clickclear();
		}
		catch(Exception ex)
		{
		    byte[] b=((TakesScreenshot)sh.driver).getScreenshotAs(OutputType.BYTES);
	    	sh.s.attach(b,"png","Addition test returns "+ex.getMessage());
		    Assert.fail(); 
		} 
	}
	
	@Then("^validate subtraction using \"(.*)\" and \"(.*)\"$")
	public void method7(String x, String y)
	{
		try
		{
			//wait for app launching
		    Thread.sleep(5000);
		    //Enter input1(by clicking required button)
		    for(int i=0;i<x.length();i++)
		    {
		    	char d=x.charAt(i);
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
		    sh.hs.clickminus();
		    //Enter input2
		    for(int i=0;i<y.length();i++)
		    {
		    	char d=y.charAt(i);
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
		    Thread.sleep(5000);
		    //Get output
		    String temp=sh.hs.getoutput();
		    //validation
		    float i1=Float.parseFloat(x);
		    float i2=Float.parseFloat(y);
		    float o=Float.parseFloat(temp);
		    if(o==i1-i2)
		    {
		    	sh.s.log("Subtract Test passed");
		    }
		    else
		    {
		    	byte[] b=((TakesScreenshot)sh.driver).getScreenshotAs(OutputType.BYTES);
		    	sh.s.attach(b,"png","Subtract Test failed");
		    	Assert.fail(); //to stop failed scenario's next steps
		    }
		    //clear output
		    sh.hs.clickclear();
		}
		catch(Exception ex)
		{
		    byte[] b=((TakesScreenshot)sh.driver).getScreenshotAs(OutputType.BYTES);
	    	sh.s.attach(b,"png","Subtract test returns "+ex.getMessage());
		    Assert.fail(); 
		} 
	}
	
	@Then("^validate multiply using \"(.*)\" and \"(.*)\"$")
	public void method8(String x, String y)
	{
		try
		{
			//wait for app launching
		    Thread.sleep(5000);
		    //Enter input1(by clicking required button)
		    for(int i=0;i<x.length();i++)
		    {
		    	char d=x.charAt(i);
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
		    sh.hs.clickmultiply();
		    //Enter input2
		    for(int i=0;i<y.length();i++)
		    {
		    	char d=y.charAt(i);
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
		    Thread.sleep(5000);
		    //Get output
		    String temp=sh.hs.getoutput();
		    //validation
		    float i1=Float.parseFloat(x);
		    float i2=Float.parseFloat(y);
		    float o=Float.parseFloat(temp);
		    if(o==i1*i2)
		    {
		    	sh.s.log("Multiply Test passed");
		    }
		    else
		    {
		    	byte[] b=((TakesScreenshot)sh.driver).getScreenshotAs(OutputType.BYTES);
		    	sh.s.attach(b,"png","Multiply Test failed");
		    	Assert.fail(); //to stop failed scenario's next steps
		    }
		    //clear output
		    sh.hs.clickclear();
		}
		catch(Exception ex)
		{
		    byte[] b=((TakesScreenshot)sh.driver).getScreenshotAs(OutputType.BYTES);
	    	sh.s.attach(b,"png","Multiply test returns "+ex.getMessage());
		    Assert.fail(); 
		} 
	}
	
	@Then("^validate division using \"(.*)\" and \"(.*)\"$")
	public void method9(String x, String y)
	{
		try
		{
			//wait for app launching
		    Thread.sleep(5000);
		    //Enter input1(by clicking required buttons)
		    for(int i=0;i<x.length();i++)
		    {
		    	char d=x.charAt(i);
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
		    sh.hs.clickdivide();
		    //Enter input2
		    for(int i=0;i<y.length();i++)
		    {
		    	char d=y.charAt(i);
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
		    Thread.sleep(5000);
		    //Get output
		    if(y.equals("0") && sh.driver.findElement(
		    		     By.xpath("//*[@text=\"Can't divide by 0\"]")).isDisplayed())
		    {
		    	sh.s.log("division Test passed fro divide by zero");
		    	sh.driver.findElement(By.xpath("//*[@text='DEL']")).click();
		    }
		    else
		    {
		    	String temp=sh.hs.getoutput();
		    	//validation
		    	float i1=Float.parseFloat(x);
		    	float i2=Float.parseFloat(y);
		    	float o=Float.parseFloat(temp);
		    	if(o==i1/i2)
		    	{
		    		sh.s.log("division Test passed");
		    	}
		    	else
		    	{
		    		byte[] b=((TakesScreenshot)sh.driver).getScreenshotAs(OutputType.BYTES);
		    		sh.s.attach(b,"png","division Test failed");
		    		Assert.fail(); //to stop failed scenario's next steps
		    	}
		    	//clear output
			    sh.hs.clickclear();
		    }
		}
		catch(Exception ex)
		{
		    byte[] b=((TakesScreenshot)sh.driver).getScreenshotAs(OutputType.BYTES);
	    	sh.s.attach(b,"png","division test returns "+ex.getMessage());
		    Assert.fail(); 
		} 
	}	
}