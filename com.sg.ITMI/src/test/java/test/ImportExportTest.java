package test;

import org.testng.annotations.Test;


import Pages.ImportExportPage;
import WebBase.BaseTest;

public class ImportExportTest extends BaseTest{
	
	ImportExportPage impexp = new ImportExportPage();
	
	
	@Test(priority = 1)
	public void AgencyImport() throws InterruptedException {
		impexp.AgencyImport();

	}
	
	@Test(priority = 2)
	public void AssetImport() throws Exception {
		impexp.AssetImport();
	}
	
	@Test(priority = 3)
	public void LocationImport() throws Exception {
		impexp.LocationImport();
	}
	
	@Test(priority = 4,enabled=false)
	public void userImport() throws Exception {
		impexp.userImport();
	}
	
	@Test(priority = 5)
	public void AssetLocalization() throws Exception {
		impexp.AssetLocalization();
	}
	
	@Test(priority = 6)
	public void Assetperdus() throws Exception {
		impexp.Assetperdus();
	}
	
	@Test(priority = 7)
	public void ListInventoriesDetails() throws Exception {
		impexp.ListInventoriesDetails();
	}
	
	@Test(priority = 8)
	public void ListInventorieStatus() throws Exception {
		impexp.ListInventorieStatus();
	}
	
	

}
