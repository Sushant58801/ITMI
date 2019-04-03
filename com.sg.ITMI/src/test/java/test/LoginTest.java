package test;

import org.testng.annotations.Test;

import Pages.LoginPage;
import WebBase.BaseTest;

public class LoginTest extends BaseTest{
	

LoginPage loginPage = new LoginPage();

	
	@Test(priority = 1)
	public void checkloginpage() {
		loginPage.checkloginpage();

	}
	
	@Test(priority = 2)
	public void invalidLogin() throws Exception {
		loginPage.invalidLogin();
	}
	
	@Test(priority = 3)
	public void AdminvalidLogin() throws Exception {
		loginPage.AdmvalidLogin();
	}
	
	
	

}
