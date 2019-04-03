package Pages;

import java.io.File;
import java.io.FilenameFilter;

import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.selenium.webdriven.commands.GetLocation;

import Identifier.ImortExportidentifiers;
import Utility.AppstringConstant;
import Utility.Helper;
import WebBase.BasePage;
import WebBase.BaseTest;

public class ImportExportPage extends BasePage {

	ImortExportidentifiers importid = new ImortExportidentifiers();
	BaseTest baseT = new BaseTest();
	String UserDriectory = System.getProperty("user.dir") + "\\ExcelImport";
	Helper help = new Helper();
	String className = "";
	public ExtentTest logger;
	File dir = new File("C:\\Users\\S6670405\\Downloads\\");

	public void AgencyImport() throws InterruptedException {
		className = this.getClass().getName();
		createDirectory("ITMI" + className);
		logger = baseT.extent.startTest("Import nd Export Test");
		importid.ExportImportTab.click();
		Select agency = new Select(importid.dd_importlist);
		agency.selectByVisibleText("AGENCY");
		importid.SeletcFile.sendKeys(UserDriectory + "\\Agency.xlsx");
		importid.btn_importsubmit.click();
		Thread.sleep(2000);
		if (importid.success_Msg.getText().contains(AppstringConstant.IMPORTAGENCYSUCMSG)) {
			logger.log(LogStatus.PASS,
					"1:  Agency import " + "<br/>" + "2 : Importing for Agency " + "<br/>"
							+ "<b>Result: Agency import successfully <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Imported")));
		} else {
			logger.log(LogStatus.FAIL, "Success message is not displayed.");
		}
	}

	public void AssetImport() throws InterruptedException {

		Select agency = new Select(importid.dd_importlist);
		agency.selectByVisibleText("ASSET");
		importid.SeletcFile.sendKeys(UserDriectory + "\\Asset.xlsx");
		importid.btn_importsubmit.click();
		Thread.sleep(2000);
		if (importid.success_Msg.getText().contains(AppstringConstant.IMPORTASSETSUCMSG)) {
			logger.log(LogStatus.PASS,
					"1:  Asset import " + "<br/>" + "2 : Importing for Asset " + "<br/>"
							+ "<b>Result: Asset import successfully <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Imported")));
		} else {
			logger.log(LogStatus.FAIL, "Success message is not displayed.");
		}
	}

	public void LocationImport() throws InterruptedException {

		Select agency = new Select(importid.dd_importlist);
		agency.selectByVisibleText("LOCATION");
		importid.SeletcFile.sendKeys(UserDriectory + "\\Location.xlsx");
		importid.btn_importsubmit.click();
		Thread.sleep(2000);
		if (importid.success_Msg.getText().contains(AppstringConstant.IMPORTLOCSUCMSG)) {
			logger.log(LogStatus.PASS,
					"1:  Location import " + "<br/>" + "2 : Importing for Location " + "<br/>"
							+ "<b>Result: Location import successfully <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Imported")));
		} else {
			logger.log(LogStatus.FAIL, "Success message is not displayed.");
		}
	}

	public void userImport() throws InterruptedException {
		Select agency = new Select(importid.dd_importlist);
		agency.selectByVisibleText("USER");
		importid.SeletcFile.sendKeys(UserDriectory + "\\User.xlsx");
		importid.btn_importsubmit.click();
		Thread.sleep(2000);
		if (importid.success_Msg.getText().contains(AppstringConstant.IMPORTUSRSUCMSG)) {
			logger.log(LogStatus.PASS,
					"1:  User import " + "<br/>" + "2 : Importing for User " + "<br/>"
							+ "<b>Result:  User imported successfully <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Imported")));
		} else {
			logger.log(LogStatus.FAIL, "Success message is not displayed.");
		}
	}

	public void AssetLocalization() throws InterruptedException {
		importid.ExportImportTab.click();
		Select agency = new Select(importid.dd_exporttype);
		agency.selectByVisibleText("Assets avec plusieurs localisations");
		importid.btn_exportsubmit.click();
		Thread.sleep(2000);
		if (help.isFileDownloaded("C:\\Users\\S6670405\\Downloads\\", "EXP1_") == true) {
			logger.log(LogStatus.PASS,
					"1: Asset localisations export " + "<br/>" + "2 : Exporting for Asset localisations" + "<br/>"
							+ "<b>Result: Asset localisations exported successfully <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Exported")));

		} else {
			logger.log(LogStatus.FAIL, "Asset localisations exported file does not displayed.");

		}
		help.deletefile("C:\\Users\\S6670405\\Downloads\\", "EXP1_");

	}

	public void Assetperdus() throws InterruptedException {

		Select agency = new Select(importid.dd_exporttype);
		agency.selectByVisibleText("Assets perdus");
		importid.btn_exportsubmit.click();
		Thread.sleep(2000);
		if (help.isFileDownloaded("C:\\Users\\S6670405\\Downloads\\", "EXP2_") == true) {
			logger.log(LogStatus.PASS,
					"1: Asset perdus export " + "<br/>" + "2 : Exporting for Asset perdus" + "<br/>"
							+ "<b>Result: Asset perdus exported successfully <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Exported")));

		} else {
			logger.log(LogStatus.FAIL, "Asset perdus exported file does not displayed.");

		}
		help.deletefile("C:\\Users\\S6670405\\Downloads\\", "EXP2_");

	}

	public void ListInventoriesDetails() throws InterruptedException {

		Select agency = new Select(importid.dd_exporttype);
		agency.selectByVisibleText("Liste des inventaires (détails)");
		importid.btn_exportsubmit.click();
		Thread.sleep(2000);
		if (help.isFileDownloaded("C:\\Users\\S6670405\\Downloads\\", "EXP5_") == true) {
			logger.log(LogStatus.PASS,
					"1: Inventory list details export " + "<br/>" + "2 : Exporting for Inventory list details "
							+ "<br/>" + "<b>Result: Inventory list details  successfully <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Exported")));

		} else {
			logger.log(LogStatus.FAIL, "Inventory list details exported file does not displayed.");

		}
		help.deletefile("C:\\Users\\S6670405\\Downloads\\", "EXP5_");

	}

	public void ListInventorieStatus() throws InterruptedException {

		Select agency = new Select(importid.dd_exporttype);
		agency.selectByVisibleText("Liste des inventaires (statut)");
		importid.btn_exportsubmit.click();
		Thread.sleep(2000);
		if (help.isFileDownloaded("C:\\Users\\S6670405\\Downloads\\", "EXP3_") == true) {
			logger.log(LogStatus.PASS,
					"1: Inventory list status export " + "<br/>" + "2 : Exporting for Inventory list status " + "<br/>"
							+ "<b>Result: Inventory list status  successfully <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Exported")));

		} else {
			logger.log(LogStatus.FAIL, "Inventory list status exported file does not displayed.");

		}
		help.deletefile("C:\\Users\\S6670405\\Downloads\\", "EXP3_");

	}

}
