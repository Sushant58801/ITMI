package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Identifier.LoginIdentifiers;
import WebBase.Controller;

public class Helper {
	
	int i = 1;
	
	LoginIdentifiers testID = new LoginIdentifiers();
	
	public String randomEmailGenerator() {
		//Method with generate random Numbers.
				Random randomGenerator = new Random();
				int randomInt = randomGenerator.nextInt(10000000);
				String emailID = "testUser" + randomInt + "@gmail.com";
				return emailID;

			}

			public String randomUsernameGenerator() {
		//Method will generate random user name
				String randomInt = RandomStringUtils.random(5, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
				String UserName = "username" + randomInt;
				return UserName;

			}

			public boolean isElementPresent(WebElement element) {
				//Method will check is elemenet present or not.
				try {
					element.isDisplayed();
					return true;
				} catch (org.openqa.selenium.NoSuchElementException e) {
					return false;
				}
			}

			public void Login(String username, String password) {
				//Login credentials
				testID.txt_SGusername.sendKeys(username);
				testID.txt_SGpassword.sendKeys(password);

			}

			public String randomSGIDGenerator() {
				//Method to create random SGID.
				Random randomGenerator = new Random();
				int randomInt = randomGenerator.nextInt(10000000);
				String randomString = RandomStringUtils.random(1, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
				String SGID = randomString + randomInt;
				return SGID;
			}
			
			public int randomMobileFAX() {
				//Method to create random SGID.
				Random randomGenerator = new Random();
				int randomInt = randomGenerator.nextInt(1000000000);
				int phoneNumber = randomInt;
				return phoneNumber;
			}
			
			public String randomSupplierCodeGenerator() {
				//Method to create random SupplierCode.
				Random randomGenerator = new Random();
				int randomInt = randomGenerator.nextInt(10000);
				String randomString = RandomStringUtils.random(2, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
				String SupplierCode = randomString + randomInt + " "+"-" +" "+ randomInt;
				return SupplierCode;
			}

			public void Dropdown(String Locator) {
				//Function to retrieve value from drop-down list.
				List<WebElement> selectoption = Controller.driver.findElements(By.xpath("" + Locator + ""));
				Random random = new Random();
				int index = random.nextInt(selectoption.size());
				if (index == 0) {
					index = index + 1;
				}
				selectoption.get(index).click();

			}
			
			@SuppressWarnings("unused")
			public File getLatestFilefromDir(String dirPath){
			    File dir = new File(dirPath);
			    File[] files = dir.listFiles();
			    if (files == null || files.length == 0) {
			        return null;
			    }
			
			    File lastModifiedFile = files[0];
			    for (int i = 1; i < files.length; i++) {
			       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
			           lastModifiedFile = files[i];
			           System.out.println(lastModifiedFile);
			       }
			    }
			    return lastModifiedFile;
			}
			
			public boolean isFileDownloaded(String downloadPath, String fileName) {
				boolean flag = false;
			    File dir = new File(downloadPath);
			    File[] dir_contents = dir.listFiles();
			  	    
			    for (int i = 0; i < dir_contents.length; i++) {
			        if (dir_contents[i].getName().contains(fileName))
			            return flag=true;
			            }

			    return flag;
			}
			
			public boolean deletefile(String downloadPath, String fileName) {
				boolean flag = false;
			    File dir = new File(downloadPath);
			    File[] dir_contents = dir.listFiles();
			  	    
			    for (int i = 0; i < dir_contents.length; i++) {
			        if (dir_contents[i].getName().contains(fileName))
			        	dir_contents[i].delete();
			            }

			    return flag;
			}
			
			
			public void selectOptionWithText(String textToSelect , WebElement element) {
				try {
					WebElement autoOptions = element;
					//wait.until(ExpectedConditions.visibilityOf(autoOptions));

					List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
					for(WebElement option : optionsToSelect){
				        if(option.getText().equals(textToSelect)) {
				        	System.out.println("Trying to select: "+textToSelect);
				            option.click();
				            break;
				        }
				    }
					
				} catch (NoSuchElementException e) {
					System.out.println(e.getStackTrace());
				}
				catch (Exception e) {
					System.out.println(e.getStackTrace());
				}
			}
			
			

			public void getscreenshots() throws IOException {
				//Code used to capture screenshots.
				File scfile = ((TakesScreenshot) Controller.driver).getScreenshotAs(OutputType.FILE);
				String filename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				File DestFile = new File("C:\\dexter\\CAMAL\\Screenshots\\" + filename + "Test" + i++ + ".png");
				FileUtils.copyFile(scfile, DestFile);
			}

}
