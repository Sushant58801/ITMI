package test;

import org.testng.annotations.Test;

import Identifier.Inventoryidentifiers;
import Pages.InventoryPage;
import WebBase.BaseTest;

public class InventoryTest extends BaseTest{
	
	InventoryPage Inv = new InventoryPage();
	
	@Test(priority = 1)
	public void CreateLocation() throws InterruptedException {
		Inv.CreateLocation();

	}
	
	@Test(priority = 2)
	public void SearchLocation() throws Exception {
		Inv.SearchLocation();
	}
	
	@Test(priority = 3)
	public void ModifyLocation() throws Exception {
		Inv.ModifyLocation();
	}
	
	@Test(priority = 4)
	public void CreateInventoryButton() throws Exception {
		Inv.CreateInventoryButton();
	}
	
	@Test(priority = 5)
	public void Addmaterialbutton() throws Exception {
		Inv.Addmaterialbutton();
	}
	
	@Test(priority = 6)
	public void PrinterMaterial() throws Exception {
		Inv.PrinterMaterial();
	}
	
	@Test(priority = 7)
	public void ComputerMaterial() throws Exception {
		Inv.ComputerMaterial();
	}
	
	@Test(priority = 8)
	public void TempSaveInventory() throws Exception {
		Inv.TempSaveInventory();
	}
	
	@Test(priority = 9)
	public void CloseInventory() throws Exception {
		Inv.CloseInventory();
	}
	
	

}
