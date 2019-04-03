package Identifier;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import WebBase.BasePage;

public class ImortExportidentifiers extends BasePage{
	
	@FindBy( xpath = "//a[contains(@href,'importexport')]")
	public WebElement ExportImportTab;
	
	@FindBy(id ="imp_type")
	public WebElement dd_importlist;
	
	@FindBy(id="imp_file")
	public WebElement SeletcFile;
	
	@FindBy(id= "imp_sbmt")
	public WebElement btn_importsubmit;
	
	@FindBy(id= "export_type")
	public WebElement dd_exporttype;
	
	@FindBy(id= "export-btn")
	public WebElement btn_exportsubmit;
	
	@FindBy(id= "error_msg_div")
	public WebElement Error_Msg;
	
	@FindBy(id= "error_msg")
	public WebElement success_Msg;
	
	
	
	
	

}
