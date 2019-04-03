package Pages;

import java.io.IOException;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Identifier.UserIdentifiers;
import Utility.AppstringConstant;
import Utility.Helper;
import WebBase.BasePage;
import WebBase.BaseTest;

public class UserPage extends BasePage{
	
	UserIdentifiers UserId = new UserIdentifiers();
	Helper help = new Helper();
	String Username = help.randomUsernameGenerator();
	String EditedUsername = help.randomUsernameGenerator();
	String SGId = help.randomSGIDGenerator();
	BaseTest baseT = new BaseTest();
	String EditSGId = help.randomSGIDGenerator();
	String className = "";
	public ExtentTest logger;

	public void Createuser() throws InterruptedException, IOException {
		//Function is used to create new SG user.
		className = this.getClass().getName();
		createDirectory("ITMI"+className);
		logger = baseT.extent.startTest("User Test");
		UserId.usertab.click();
		UserId.btn_addnewuser.click();
		Thread.sleep(2000);
		UserId.txt_userSGID.click();
		UserId.txt_userSGID.sendKeys(SGId);
		UserId.txt_name.sendKeys(Username);
		UserId.dd_location.click();
		help.Dropdown(AppstringConstant.USRLOCATION);
		UserId.dd_role.click();
		help.Dropdown(AppstringConstant.USERROLEDROPDOWN);
		UserId.btn_CreateUser.click();
		Thread.sleep(2000);	
		String errro  = UserId.Alrt_SuccessMSG.getText();
		System.out.println(errro);
		if(UserId.Alrt_SuccessMSG.getText().contains(AppstringConstant.CREATEUSERMSG) == true){
			logger.log(LogStatus.PASS,
					"1:  Create user " + "<br/>" + "2 : Creation of new user. " + "<br/>"
							+ "<b>Result: New user is created successfully <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Create new user")));
		} else {
			logger.log(LogStatus.FAIL, "Success message is not displayed.");
		}
	}
		
		public void SearchUser() throws InterruptedException{
			UserId.txt_searchUser.sendKeys(SGId);
			Thread.sleep(3000);
			if (SGId.equals(UserId.tbl_SGID.getText()) == true) {
				logger.log(LogStatus.PASS,
						"1:  Search user " + "<br/>" + "2 : Search for new user. " + "<br/>"
								+ "<b>Result: New user is search successfully <b>"
								+ logger.addScreenCapture(captureScreenShot(driver, "search new user")));
			} else {
				logger.log(LogStatus.FAIL, "User does not displayed after search.");
			}
		}			

	public void Editeuser() throws InterruptedException, IOException {
		UserId.tbl_editBtn.click();
		Thread.sleep(2000);
		UserId.txt_name.clear();
		UserId.txt_name.sendKeys(EditedUsername);
		UserId.txt_userSGID.sendKeys(EditSGId);
		UserId.dd_role.click();
		help.Dropdown(AppstringConstant.USERROLEDROPDOWN);
		UserId.btn_CreateUser.click();
		Thread.sleep(5000);
		//verified edit user success message.
		if (UserId.Alrt_SuccessMSG.getText().contains(AppstringConstant.EDITUSERMSG) == true) {
			logger.log(LogStatus.PASS,
					"1:  Edit user " + "<br/>" + "2 : Modification  of user. " + "<br/>"
							+ "<b>Result: Modification of  user is done successfully <b>"
							+ logger.addScreenCapture(captureScreenShot(driver, "Modify user")));
		} else {
			logger.log(LogStatus.FAIL, "Success message is not displayed.");
		}
	}

}
