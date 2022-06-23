package org.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRolePageObjects {
	
	@FindBy(id="menu_admin_viewAdminModule")
	public static WebElement admin;
	
	@FindBy(id="menu_admin_UserManagement")
	public static WebElement userManagement;
	
	@FindBy(id="menu_admin_viewSystemUsers")
	public static WebElement users;
	
	@FindBy(id="searchSystemUser_userType")
	public static WebElement userRole;
	
	@FindBy(id="searchSystemUser_status")
	public static WebElement status;
	
	@FindBy(id="searchBtn")
	public static WebElement searchBtn;
	
	@FindBy(xpath="//*[@id=\'resultTable\']/tbody/tr[1]/td[3]")
	public static WebElement userRoleText;
	
	@FindBy(xpath="//*[@id=\'resultTable\']/tbody/tr[1]/td[5]")
	public static WebElement statusText;
	
	

}
