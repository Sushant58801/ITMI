package Identifier;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import WebBase.BasePage;

public class UserIdentifiers extends BasePage{
	
	@FindBy(id="add_user")
	public WebElement btn_addnewuser;
	
	@FindBy(id="user_sgid")
	public WebElement txt_userSGID;
	
	@FindBy(id="user_firstname")
	public WebElement txt_name;
	
	@FindBy(id="user_location")
	public WebElement dd_location;

	@FindBy(id="user_role")
	public WebElement dd_role;
	
	@FindBy(id="submitUserForm")
	public WebElement btn_CreateUser;
	
	@FindBy(css=".alert.alert-success")
	public WebElement Alrt_SuccessMSG;
	
	@FindBy(xpath = "//a[contains(@href,'user')]")
	public WebElement usertab;
	
	@FindBy(xpath = "//input[@type='search']")
	public WebElement txt_searchUser;
	
	@FindBy(xpath = "//tr[@class='odd']//td[2]")
	public WebElement tbl_SGID;
	
	@FindBy(xpath = "//div[@class='action-buttons']")
	public WebElement tbl_editBtn;
	

}
