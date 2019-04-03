package Identifier;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import WebBase.BasePage;

public class Inventoryidentifiers extends BasePage{
	
	@FindBy( xpath = "//a[contains(@href,'location')]")
	public WebElement InventoryTab;
	
	@FindBy(id ="add_location")
	public WebElement btn_location;
	
	@FindBy(id ="loc_name")
	public WebElement txt_name;
	
	@FindBy(id ="loc_code")
	public WebElement txt_code;
	
	@FindBy(id ="loc_contact")
	public WebElement txt_contact;
	
	@FindBy(id ="loc_phone")
	public WebElement txt_phone;
	
	@FindBy(id ="loc_agency")
	public WebElement txt_agency;
	
	@FindBy(id ="ui-id-1")
	public WebElement txt_agencyList;
	
	
	@FindBy(xpath ="//div[@class='alert alert-success']")
	public WebElement SuccessMsg;

	
	@FindBy(id ="loc_street")
	public WebElement txt_Street;
	
	@FindBy(id ="loc_city")
	public WebElement txt_city;
	
	@FindBy(id ="loc_zipcode")
	public WebElement txt_zipCode;
	
	@FindBy(id ="resetForm")
	public WebElement btn_resetform;
	
	@FindBy(id ="submitLocationForm")
	public WebElement btn_submitform;

	@FindBy(xpath ="//input[@type='search']")
	public WebElement txt_search;
	
	@FindBy(xpath ="//tr[@class='odd']//td[1]")
	public WebElement tbl_code;
	
	@FindBy(xpath ="//a[@title='Modifier un localisation']")
	public WebElement tbl_edit;
	
	@FindBy(xpath ="//a[@title='Afficher le matériel de la localisation']")
	public WebElement tbl_details;
		
	@FindBy(id ="begin_new")
	public WebElement btn_newInventory;
	
	@FindBy(id ="add_material")
	public WebElement btn_Addmaterial;
	
	@FindBy(id ="AST_CAT_ID")
	public WebElement dd_category;
	
	@FindBy(id ="AST_CODE")
	public WebElement txt_materialCode;
	
	@FindBy(id ="AST_NAME")
	public WebElement txt_materialName;
	
	@FindBy(id ="AST_SERIAL_NUMBER")
	public WebElement txt_materialSeriesNo;
	
	@FindBy(id ="AST_HOST")
	public WebElement txt_Host;
	
	@FindBy(id ="btn-save")
	public WebElement btn_saveMaterial;
	
	@FindBy(id ="tofocus-0")
	public WebElement row_Printer;
	
	@FindBy(id ="tofocus-1")
	public WebElement row_Computer;
	
	@FindBy(id ="usr_name-0")
	public WebElement row_Username1;
		
	@FindBy(id ="usr_name-1")
	public WebElement row_Username2;
		
	@FindBy(id ="ASI_COMMENT-0")
	public WebElement row_Comment1;
	
	@FindBy(id ="ASI_COMMENT-1")
	public WebElement row_Comment2;
	
	@FindBy(id ="check-present-0")
	public WebElement row_Presnt1;
	
	@FindBy(id ="check-present-1")
	public WebElement row_Presnt2;
	
	@FindBy(id ="remove-present-0")
	public WebElement row_Remove1;
	
	@FindBy(id ="remove-present-1")
	public WebElement row_Remove2;
	
	@FindBy(id ="question-present-0")
	public WebElement row_Question1;
	
	@FindBy(id ="question-present-1")
	public WebElement row_Question2;
	
	@FindBy(id ="INV_COMMENT")
	public WebElement txt_InvComment;
	
	@FindBy(id ="btnSubmit")
	public WebElement btn_tempsave;
	
	@FindBy(id ="INV_NUMBER_PHONE")
	public WebElement Inv_phoneNumber;
	
	@FindBy(id ="continue_inventory")
	public WebElement btn_continueinventory;
	
	@FindBy(id ="btnFinish")
	public WebElement btn_CloseInventory;
	
	@FindBy(xpath= "//*[@class='ui-corner-all']")
	public List <WebElement> Assigned_List;
}
