package com.buildpiper.testcases;

import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.buildpiper.base.BaseTest;
import com.buildpiper.pages.JobTemplatePage;
import com.buildpiper.pages.LoginPage;
import com.buildpiper.pages.ManageApplicationPage;
import com.buildpiper.pages.PreRequisitesPage;
import com.buildpiper.utils.ExcelUtility;
import com.buildpiper.utils.FrameworkConfig;
import com.buildpiper.utils.RandomStrings;

@Listeners(com.buildpiper.report.ExtentReportListener.class)

public class ManageApplicationTestcases extends BaseTest {

	FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);

	ExcelUtility reader = new ExcelUtility();
	 @BeforeMethod
	    public void StartDriver() {
	    	new LoginPage().login(config.username(), config.password());
	    	ui_wait(5);
	    }
	   @AfterMethod
	    public void StopDriver() {
	    ui_getUIDriver().quit();
	    }

	@Test(groups = { "Regression" }, priority = 0)
//	@RetryCountIfFailed(2)
	public void AddApplication() {
	String Appname="devtest";
	new ManageApplicationPage().EnableTemplateV3Support();
	new ManageApplicationPage().AddApplication(Appname);
	}
	
}
