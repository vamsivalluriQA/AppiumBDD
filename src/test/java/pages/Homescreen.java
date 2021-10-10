package pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Homescreen 
{
	public AndroidDriver<MobileElement> driver;
	
	@AndroidFindBy(xpath="//*[@content-desc='minus']")
	public MobileElement minus;
	
	@AndroidFindBy(xpath="//*[@content-desc='plus']")
	public MobileElement plus;
	
	@AndroidFindBy(xpath="//*[@content-desc='multiply']")
	public MobileElement multiply;
	
	@AndroidFindBy(xpath="//*[@content-desc='divide']")
	public MobileElement divide;
	
	@AndroidFindBy(xpath="//*[@content-desc='equals']")
	public MobileElement equals;
	
	@AndroidFindBy(xpath="//*[@content-desc='clear']")
	public MobileElement clear;
	
	@AndroidFindBy(xpath="//*[contains(@resource-id,'result')]")
	public MobileElement outputbox;
	
	public Homescreen(AndroidDriver<MobileElement> driver)
	{
		this.driver=driver;
		AppiumFieldDecorator ad=new AppiumFieldDecorator(driver);
		PageFactory.initElements(ad,this);
	}
	
	public void clickadd()
	{
		plus.click();
	}
	
	public void clickminus()
	{
		minus.click();
	}
	
	public void clickmultiply()
	{
		multiply.click();
	}
	
	public void clickdivide()
	{
		divide.click();
	}
	
	public void clickequals()
	{
		equals.click();
	}
	
	public void clickclear()
	{
		clear.click();
	}
	
	public String getoutput()
	{
		String o=outputbox.getAttribute("text");
		System.out.println(o);
		Pattern p1=Pattern.compile("^[0-9]");
		Matcher m1=p1.matcher(o);
		if(!m1.find()) //output not started with digit(means start with android "-")
		{
			String temp=o.substring(1); //skip first(index is 0) android "-" and take remaining
			o="-"+temp; //Add java "-" at front to remaining value
		}
		System.out.println(o); 
		return(o);
	}
}

