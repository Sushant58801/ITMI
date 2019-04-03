package Pages;

import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Identifier.LoginIdentifiers;
import Utility.AppstringConstant;
import Utility.Excellmport;
import Utility.Helper;
import WebBase.BasePage;
import WebBase.BaseTest;

public class LoginPage extends BasePage{
	
	LoginIdentifiers login = new LoginIdentifiers();
	SoftAssert sa = new SoftAssert();
	Helper scHelper = new Helper();
	Excellmport excel = new Excellmport();
	BaseTest baseT = new BaseTest();
	String className = "";
	public ExtentTest logger;

	public void checkloginpage() {
		// function will verify object on SG login page
		className = this.getClass().getName();
		createDirectory("ITMI" + className);
		logger = baseT.extent.startTest("Login Test");
		if (scHelper.isElementPresent(login.useanotherloginlink) == true) {

			login.useanotherloginlink.click();
		}
		// verify object
		
		if (scHelper.isElementPresent(login.txt_SGusername) && scHelper.isElementPresent(login.txt_SGpassword) 
				&& scHelper.isElementPresent(login.btn_ssoConnection) == true) {
			logger.log(LogStatus.PASS,
					"1: logged in with application " + "<br/>" + "2 : verify logo of the page" + "<br/>"
							+ "<b>Result: title of home  page is verified <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "verify home page title")));
		} else {
			logger.log(LogStatus.FAIL, "Title is not verified");
		}

	}

	public void invalidLogin() throws Exception {
		// Function for login to the app with invalid data
		// Login data is fetch from the Excel (Test_Data.xlsx)
		Excellmport.setExcelFile(AppstringConstant.EXCELFILEPATH + AppstringConstant.EXCELFILENAME,
				AppstringConstant.EXCELLOGINSHEET);
		String Exe_username = Excellmport.getCellData(1, 0);
		String Exe_password = Excellmport.getCellData(1, 1);
		scHelper.Login(Exe_username, Exe_password);
		login.btn_ssoConnection.click();
		System.out.println("Test 2 - Verified login with invalid user details.");
		if (login.errormsg.getText().contains(AppstringConstant.INVALIDLOGINMSG) == true) {
			logger.log(LogStatus.PASS,
					"1: logged in with application " + "<br/>" + "2 : verify logo of the page" + "<br/>"
							+ "<b>Result: Login with Invalid User ID is verified <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Invalid login checked")));
		} else {
			logger.log(LogStatus.FAIL, "Login with Invalid data is fail");
		}
	}

	public void AdmvalidLogin() throws Exception {
		// Function for login to the app with valid data
		// Login data is fetch from the Excel (Test_Data.xlsx)
		Excellmport.setExcelFile(AppstringConstant.EXCELFILEPATH + AppstringConstant.EXCELFILENAME,
				AppstringConstant.EXCELLOGINSHEET);
		String Exe_username = Excellmport.getCellData(2, 0);
		String Exe_password = Excellmport.getCellData(2, 1);
		login.txt_SGusername.clear();
		login.txt_SGpassword.clear();
		scHelper.Login(Exe_username, Exe_password);
		login.btn_ssoConnection.click();
		System.out.println("Test 3 - Verified login with valid data and check required fields are present.");
		if (scHelper.isElementPresent(login.InventoryTab) == true) {
			logger.log(LogStatus.PASS,
					"1: logged in with application " + "<br/>" + "2 : verify logo of the page" + "<br/>"
							+ "<b>Result: Login with valid User ID is verified <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "valid login checked")));
		} else {
			logger.log(LogStatus.FAIL, "Login with valid data is fail");
		}
	}


}
