package org.testCases;

import org.apache.log4j.Logger;
import org.commonFunctions.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.pageObject.UserRolePageObjects;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUserRole extends CommonFunctions{
	

	static Logger logger=Logger.getLogger(TestUserRole.class);
	public void users() {
		
		Actions act = new Actions(driver);
		
		act.moveToElement(UserRolePageObjects.admin);
		act.moveToElement(UserRolePageObjects.userManagement);
		act.moveToElement(UserRolePageObjects.users);
		act.click().build().perform();


	}

	public void selectUserRole() {
		
		Select s = new Select(UserRolePageObjects.userRole);
		s.selectByIndex(1);

	}

	public void selectStatus() {
		
		Select s = new Select(UserRolePageObjects.status);
		s.selectByIndex(1);

	}
	public void search() {
		
		UserRolePageObjects.searchBtn.click();

	}

	@Test
	public void checkTestUser() {
		PageFactory.initElements(driver, UserRolePageObjects.class);
		logger.info("Navigating to users page");
		users();
		logger.info("selectng the User Role");
		selectUserRole();
		logger.info("selectig the status");
		selectStatus();
		search();
		String actualUserRole = UserRolePageObjects.userRoleText.getText();
		String actualStatus = UserRolePageObjects.statusText.getText();
		logger.info("Verifying the results");
		Assert.assertEquals(actualUserRole, "Admin");
		Assert.assertEquals(actualStatus, "Enabled");
		logger.info("End of test user role test case");

	}


}
