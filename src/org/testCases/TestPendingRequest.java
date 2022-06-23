package org.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.commonFunctions.CommonFunctions;

import org.openqa.selenium.support.PageFactory;
import org.pageObject.DashBoardPageObjects;

import org.pageObject.LoginPageObjects;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPendingRequest extends CommonFunctions{

	String actualmessage = null;
	
	static Logger logger=Logger.getLogger(TestPendingRequest.class);
	
	
	public void login() throws InterruptedException {
		logger.info("Logging into the application");

		PageFactory.initElements(driver, LoginPageObjects.class);

		LoginPageObjects.userName.sendKeys("Admin");
		LoginPageObjects.passWord.sendKeys("admin123");
		LoginPageObjects.loginBtn.click();

	
	}
	
	public void pendingLeaveRequest() {
		logger.info("Getting the pending leave requests");
		PageFactory.initElements(driver, DashBoardPageObjects.class);
        actualmessage = DashBoardPageObjects.noRecords.getText();

	}
	
	@Test
	public void VerifypendingLeaveRequest() throws IOException, InterruptedException {
		login();
		pendingLeaveRequest();
		logger.info("verification");
        Assert.assertEquals(actualmessage, "No Records are Available");
        logger.info("end of test pending equest test case");

	}


}
