package test;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.UserPage;
import WebBase.BaseTest;

public class UserTest extends BaseTest{
	
	UserPage US = new UserPage();
	
	@Test(priority=1)
	public void CreateNewUser() throws InterruptedException, IOException
	{
		
		US.Createuser();
	
	}
	
	@Test(priority=2)
	public void SearchUser() throws InterruptedException, IOException
	{
		
		US.SearchUser();
	
	}
	
	@Test(priority=3)
	public void EditNewUser() throws InterruptedException, IOException
	{
		
		US.Editeuser();
	
	}

}
