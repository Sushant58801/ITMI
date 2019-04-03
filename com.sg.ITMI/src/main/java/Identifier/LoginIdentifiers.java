package Identifier;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import WebBase.BasePage;

public class LoginIdentifiers extends BasePage{
	
	@FindBy(id="buttonConnect")
	public WebElement btn_ssoConnection;
	
	@FindBy(id="password")
	public WebElement txt_SGpassword;
	
	@FindBy(id="username")
	public WebElement txt_SGusername;
	
	@FindBy(xpath ="//*[@id=\"error\"]/span")
	public WebElement errormsg;
	
	@FindBy(xpath ="//*[@id=\"formAutoLogin\"]/a")
	public WebElement useanotherloginlink;	
	 
	@FindBy(xpath = "//a[contains(@href,'location')]")
	public WebElement InventoryTab;	
	
	
	

}
