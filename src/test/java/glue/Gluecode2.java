package glue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.cucumber.java.en.Then;

public class Gluecode2
{
	//"Shared" class can provide other reusable classes objects
	public Shared sh; 
	//Constructor method to get association with "Shared" class
	public Gluecode2(Shared sh)
	{
		this.sh=sh;
	}
	
	//Step definitions
	@Then("^validate operation with data in excel file$")
	public void method5() throws Exception
	{
		//wait for app launching
	    WebDriverWait w=new WebDriverWait(sh.driver,20);
	    w.until(ExpectedConditions.visibilityOf(sh.hs.minus));
		//Open Excel file
		File f=new File("src\\test\\resources\\utilities\\Book1.xlsx"); 
		FileInputStream fi=new FileInputStream(f);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sheet=wb.getSheet("Sheet1"); 
		int nour=sheet.getPhysicalNumberOfRows(); //count of used rows
		int nouc=sheet.getRow(0).getLastCellNum(); //count of used columns
		SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
		Date dt=new Date();
		Cell rc1=sheet.getRow(0).createCell(nouc);
		rc1.setCellValue("Test results on "+sf.format(dt));
		//1st row(index is 0) have names of columns in Sheet1
		for(int r=1;r<nour;r++) //from 2nd row(index=1)
		{
			DataFormatter df=new DataFormatter();
			String operation=df.formatCellValue(sheet.getRow(r).getCell(0));
			String input1=df.formatCellValue(sheet.getRow(r).getCell(1));
			String input2=df.formatCellValue(sheet.getRow(r).getCell(2));
			try
			{
			    //Enter input1
			    for(int i=0;i<input1.length();i++)
			    {
			    	char d=input1.charAt(i);
			    	if(d=='-')
			    	{
			    		w.until(ExpectedConditions.elementToBeClickable(sh.hs.minus));
			    		sh.hs.clickminus();
			    	}
			    	else
			    	{
			    		MobileBy m=
			    		 (MobileBy) MobileBy.xpath("//android.widget.Button[@text='"+d+"']");
			    		w.until(ExpectedConditions.elementToBeClickable(m)).click();
			    	}
			    }
			    //Click button for operation
			    if(operation.equalsIgnoreCase("add"))
			    {
			    	w.until(ExpectedConditions.elementToBeClickable(sh.hs.plus));
			    	sh.hs.clickadd();
			    }
			    else if(operation.equalsIgnoreCase("subtract"))
			    {
			    	w.until(ExpectedConditions.elementToBeClickable(sh.hs.minus));
			    	sh.hs.clickminus();
			    }
			    else if(operation.equalsIgnoreCase("multiply"))
			    {
			    	w.until(ExpectedConditions.elementToBeClickable(sh.hs.multiply));
			    	sh.hs.clickmultiply();
			    }
			    else
			    {
			    	w.until(ExpectedConditions.elementToBeClickable(sh.hs.divide));
			    	sh.hs.clickdivide();
			    }
			    //Enter input2
			    for(int i=0;i<input2.length();i++)
			    {
			    	char d=input2.charAt(i);
			    	if(d=='-')
			    	{
			    		w.until(ExpectedConditions.elementToBeClickable(sh.hs.minus));
			    		sh.hs.clickminus();
			    	}
			    	else
			    	{
			    		MobileBy m=
			    		 (MobileBy) MobileBy.xpath("//android.widget.Button[@text='"+d+"']");
			    		w.until(ExpectedConditions.elementToBeClickable(m)).click();
			    	}
			    }
			    //Click equals
			    w.until(ExpectedConditions.elementToBeClickable(sh.hs.equals));
			    sh.hs.clickequals();
			    //Get output
			    w.until(ExpectedConditions.visibilityOf(sh.hs.outputbox));
			    String temp=sh.hs.getoutput();
			    //validation
			    float i1=Float.parseFloat(input1);
			    float i2=Float.parseFloat(input2);
			    float o=Float.parseFloat(temp);
			    System.out.println(o);
			    if(operation.equalsIgnoreCase("add") && o==i1+i2)
			    {
			    	sh.s.log(operation+" Test passed");
			    	Cell c=sheet.getRow(r).createCell(nouc);
					c.setCellValue("Test Passed");
			    }
			    else if(operation.equalsIgnoreCase("subtract") && o==i1-i2)
			    {
			    	sh.s.log(operation+" Test passed");
			    	Cell c=sheet.getRow(r).createCell(nouc);
					c.setCellValue("Test Passed");
			    }
			    else if(operation.equalsIgnoreCase("multiply") && o==i1*i2)
			    {
			    	sh.s.log(operation+" Test passed");
			    	Cell c=sheet.getRow(r).createCell(nouc);
					c.setCellValue("Test Passed");
			    }
			    else if(operation.equalsIgnoreCase("divide") && o==i1/i2)
			    {
			    	sh.s.log(operation+" Test passed");
			    	Cell c=sheet.getRow(r).createCell(nouc);
					c.setCellValue("Test Passed");
			    }
			    else
			    {
			    	byte[] b=((TakesScreenshot)sh.driver).getScreenshotAs(OutputType.BYTES);
			    	sh.s.attach(b,"png",operation+" Test failed");
			    	Cell c=sheet.getRow(r).createCell(nouc);
					c.setCellValue("Test failed");
			    	Assert.fail(); //to stop failed scenario's next steps
			    }
			    //clear output
			    sh.hs.clickclear();
			}
			catch(Exception ex)
			{
			    byte[] b=((TakesScreenshot)sh.driver).getScreenshotAs(OutputType.BYTES);
		    	sh.s.attach(b,"png",operation+" "+ex.getMessage());
		    	Cell c=sheet.getRow(r).createCell(nouc);
				c.setCellValue(ex.getMessage());
			    Assert.fail(); 
			} 
		} //for each loop closing
		//Save and close excel file
		sheet.autoSizeColumn(nouc); //auto fit on column size
		FileOutputStream fo=new FileOutputStream(f);
		wb.write(fo); //save changes
		wb.close();
		fo.close();
		fi.close();
	} //method closing
}


