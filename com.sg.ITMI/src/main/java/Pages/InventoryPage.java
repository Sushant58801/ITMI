package Pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Identifier.Inventoryidentifiers;
import Utility.AppstringConstant;
import Utility.Helper;
import WebBase.BasePage;
import WebBase.BaseTest;


public class InventoryPage extends BasePage{
	
	Inventoryidentifiers inventory = new Inventoryidentifiers();
	Helper help=new Helper();
	String className = "";
	public ExtentTest logger;
	BaseTest baseT = new BaseTest();
	String code = help.randomSupplierCodeGenerator();
	
	public void location(String nom,String code,String Contact,int Tele,String address,String city,String postal){
		inventory.txt_name.sendKeys(nom);
		inventory.txt_code.sendKeys(code);
		inventory.txt_contact.sendKeys(Contact);
		inventory.txt_phone.sendKeys(String.valueOf(Tele));
		inventory.txt_Street.sendKeys(address);
		inventory.txt_city.sendKeys(city);
		inventory.txt_zipCode.sendKeys(postal);
		
	}
	
	public void AutoTextSelection (String value, String method)
	{
		if(method.equals("1")){
		List<WebElement> options = inventory.txt_agencyList.findElements(By.tagName("li"));
				   for (WebElement option1 : options) {
		   if(value.equals(option1.getText().trim()))
		    option1.click();   
		   }	
		}else
				   {
			   List<WebElement> options = inventory.Assigned_List;
			     for (WebElement option1 : options) {
	   if(value.equals(option1.getText().trim()))
	    option1.click();   
			   }
		   }
				   
	}
	
	public void CreateLocation() throws InterruptedException{
		className = this.getClass().getName();
		createDirectory("ITMI" + className);
		logger = baseT.extent.startTest("Inventory Test");
		inventory.InventoryTab.click();
		inventory.btn_location.click();
		location(help.randomUsernameGenerator(),code,help.randomUsernameGenerator(),help.randomMobileFAX(),
				help.randomUsernameGenerator(),help.randomUsernameGenerator(),help.randomUsernameGenerator());	
		inventory.txt_agency.sendKeys("DR");
		Thread.sleep(2000);
		AutoTextSelection(AppstringConstant.AGENCYNAME,"1");
//		List<WebElement> options = inventory.txt_agencyList.findElements(By.tagName("li"));
//		   for (WebElement option1 : options) {
//		   if(AppstringConstant.AGENCYNAME.equals(option1.getText().trim()))
//		    option1.click();   
//		   }	   
		inventory.btn_submitform.click();
		if(inventory.SuccessMsg.getText().contains(AppstringConstant.LOCATIONSUCESS) == true) {
			logger.log(LogStatus.PASS,
					"1:  Create Location " + "<br/>" + "2 : Creation of new location. " + "<br/>"
							+ "<b>Result: New location is created successfully <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Create new location")));
		} else {
			logger.log(LogStatus.FAIL, "Success message is not displayed.");			
		}
		
			
	}

	public void SearchLocation() throws InterruptedException {
		
		inventory.txt_search.sendKeys(code);
		Thread.sleep(2000);
		if(inventory.tbl_code.getText().equals(code) == true) {
			logger.log(LogStatus.PASS,
					"1:  Search Location " + "<br/>" + "2 : searc for new location. " + "<br/>"
							+ "<b>Result: New location is searched successfully <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Create new location")));
		} else {
			logger.log(LogStatus.FAIL, "Ssearch does not displayed.");			
		}
		
	}
	
	public void ModifyLocation(){
		
		inventory.tbl_edit.click();
		location(help.randomUsernameGenerator(),code,help.randomUsernameGenerator(),help.randomMobileFAX(),
				help.randomUsernameGenerator(),help.randomUsernameGenerator(),help.randomUsernameGenerator());	
		inventory.btn_submitform.click();
		if(inventory.SuccessMsg.getText().contains(AppstringConstant.LOCATIONEDIT) == true) {
			logger.log(LogStatus.PASS,
					"1:  Create Location " + "<br/>" + "2 : Creation of new location. " + "<br/>"
							+ "<b>Result: New location is created successfully <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Create new location")));
		} else {
			logger.log(LogStatus.FAIL, "Success message is not displayed.");			
		}
		
	}
			
	public void CreateInventoryButton() throws InterruptedException
	{
		inventory.txt_search.sendKeys(code);
		Thread.sleep(2000);
		inventory.tbl_details.click();
		Thread.sleep(2000);
		if(help.isElementPresent(inventory.btn_newInventory)== true) {
			logger.log(LogStatus.PASS,
					"1:  Create new inventory " + "<br/>" + "2 : Creation of new inventory. " + "<br/>"
							+ "<b>Result: New inventory button  is successfully displayed<b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Create new new inventory")));
		} else {
			logger.log(LogStatus.FAIL, "button is missing");			
		}
	}
	
	public void Addmaterialbutton() throws InterruptedException
	{
		inventory.btn_newInventory.click();
		Thread.sleep(2000);
		if(help.isElementPresent(inventory.btn_Addmaterial)== true) {
			logger.log(LogStatus.PASS,
					"1:  Create new material " + "<br/>" + "2 : Creation of new material. " + "<br/>"
							+ "<b>Result: New material button  is successfully displayed<b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Create new new material")));
		} else {
			logger.log(LogStatus.FAIL, "button is missing");			
		}
	}
	
	public void PrinterMaterial() throws InterruptedException
	{
		inventory.btn_Addmaterial.click();
		Thread.sleep(1000);
		inventory.dd_category.click();
		Select print = new Select(inventory.dd_category);
		print.selectByVisibleText("Printer");
		inventory.txt_materialCode.sendKeys("A1");
		Thread.sleep(2000);
		AutoTextSelection(AppstringConstant.MATERIALCODEPRINTER,"1");
//		List<WebElement> options = inventory.txt_agencyList.findElements(By.tagName("li"));
//		   for (WebElement option1 : options) {
//		   if(AppstringConstant.MATERIALCODEPRINTER.equals(option1.getText().trim()))
//		    option1.click();   
//		   }	
		   inventory.btn_saveMaterial.click();		   
		   Thread.sleep(1000);		   
		if(help.isElementPresent(inventory.row_Printer)== true) {
			logger.log(LogStatus.PASS,
					"1:  Material Creation " + "<br/>" + "2 : Creation of new material for Printer " + "<br/>"
							+ "<b>Result: printer is created successfully<b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Create new  material printer")));
		} else {
			logger.log(LogStatus.FAIL, "Material is not created");			
		}
	}
		
	public void ComputerMaterial() throws InterruptedException
	{
		inventory.btn_Addmaterial.click();
		Thread.sleep(1000);
		inventory.txt_materialCode.sendKeys("A1");
		Thread.sleep(2000);
		AutoTextSelection(AppstringConstant.MATERIALCODECOMPUTER,"1");
		inventory.btn_saveMaterial.click();		
		   Thread.sleep(1000);		   
		if(help.isElementPresent(inventory.row_Computer)== true) {
			logger.log(LogStatus.PASS,
					"1:  Material Creation " + "<br/>" + "2 : Creation of new material for Printer " + "<br/>"
							+ "<b>Result: printer is created successfully<b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Create new  material printer")));
		} else {
			logger.log(LogStatus.FAIL, "Material is not created");			
		}
	}
		
	public void TempSaveInventory() throws InterruptedException
	{	
		inventory.row_Username1.sendKeys("A1");
		Thread.sleep(1000);
		AutoTextSelection(AppstringConstant.PRINTERASSIGNE,"2");
		inventory.row_Username2.sendKeys("C1");
		Thread.sleep(1000);
		AutoTextSelection(AppstringConstant.COMPUTERASSIGNE,"2");
		   inventory.row_Comment1.sendKeys(AppstringConstant.PRINTERCOMMENT);
		   inventory.row_Comment2.sendKeys(AppstringConstant.COMPUTERCOMMENT);
		   inventory.txt_InvComment.sendKeys(AppstringConstant.GENERICCOMMENT);
		   inventory.btn_tempsave.click();	
		   Thread.sleep(1000);	
		   driver.switchTo().alert().accept();
		   	   
		if(inventory.SuccessMsg.getText().equals(AppstringConstant.SAVEINVENTORYMSG)== true) {
			logger.log(LogStatus.PASS,
					"1:  Inventory saved temparary " + "<br/>" + "2 : Saving the inventory as a temparary " + "<br/>"
							+ "<b>Result: Saving the inventory as a temparary successfully<b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "saving temp inventory")));
		} else {
			logger.log(LogStatus.FAIL, "success message is not displayed");			
		}
	}
	
	public void CloseInventory() throws InterruptedException
	{			
			inventory.btn_continueinventory.click();
		   inventory.txt_InvComment.sendKeys(AppstringConstant.GENERICCOMMENT1);
		  	inventory.Inv_phoneNumber.sendKeys(AppstringConstant.INVPHONENUMBER);
		   inventory.row_Presnt1.click();
		   inventory.row_Presnt2.click();
		   inventory.btn_CloseInventory.click();
		   driver.switchTo().alert().accept();
		   Thread.sleep(1000);	
		   driver.switchTo().alert().accept();
		   	   
		if(inventory.SuccessMsg.getText().equals(AppstringConstant.SAVEINVENTORYMSG)== true) {
			logger.log(LogStatus.PASS,
					"1:  Inventory saved permanently " + "<br/>" + "2 : Saving the inventory as a permanently " + "<br/>"
							+ "<b>Result: Saving the inventory as a permanently successfully<b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "saving permanently inventory")));
		} else {
			logger.log(LogStatus.FAIL, "success message is not displayed");			
		}
	}

}
