package com.buildpiper.testcases;

import java.util.ArrayList;

import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.buildpiper.base.BaseTest;
import com.buildpiper.listeners.RetryCountIfFailed;
import com.buildpiper.pages.BuildPipeLinePage;
import com.buildpiper.pages.LoginPage;
import com.buildpiper.pages.ServiceCreationPage;
import com.buildpiper.utils.Configuration;
import com.buildpiper.utils.ExcelUtility;
import com.buildpiper.utils.FrameworkConfig;
import com.buildpiper.utils.RandomStrings;
import com.buildpiper.utils.XlsReadData;

/**
 * @author: SagarT
 * @reviewer: @
 * 
 *
 */

@Listeners(com.buildpiper.report.ExtentReportListener.class)

public class BuildPiperTestcasesExecutionComprehensiveTests extends BaseTest {

	FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);

	//XlsReadData reader = new XlsReadData(
		//	System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\Sandbox1TestData.xlsx");
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
	@RetryCountIfFailed(2)
	public void CreateBasicPipeLine() {
		String pipelineName = "BasicPipeline" + RandomStrings.generateRandomString(9);
		ArrayList<String> userRoleList = new ArrayList<String>();
		userRoleList.add("DEV");
		userRoleList.add("QA");
		userRoleList.add("DEVOPS");

		//new LoginPage().login(config.username(), config.password());
		new ServiceCreationPage().accountPreRequisites();
		ui_wait(5);
		new BuildPipeLinePage().createBasicPipeline(reader.getCellData("Pipeline", "applicationName", 2),
				reader.getCellData("Pipeline", "versionType", 2), reader.getCellData("Pipeline", "retentionCount", 2),
				reader.getCellData("Pipeline", "triggerType", 2), userRoleList,
				reader.getCellData("Pipeline", "jobType", 2), reader.getCellData("Pipeline", "fromEnv", 2),
				reader.getCellData("Pipeline", "jobType2", 2), reader.getCellData("Pipeline", "toEnv", 2),
				reader.getCellData("Pipeline", "ArtifactName", 2), reader.getCellData("Pipeline", "jobType3", 2),
				reader.getCellData("Pipeline", "ArtifactName2", 2), reader.getCellData("Pipeline", "prodEnv", 2),pipelineName);

	}
	
	@Test(groups = { "Regression" },priority = 1)
	@RetryCountIfFailed(2)	
	public void CreateJiraPipeLine() {
		
		ArrayList<String> userRoleList = new ArrayList<String>();
		userRoleList.add("DEV");
		userRoleList.add("QA");
		userRoleList.add("DEVOPS");
		
		//new LoginPage().login(config.username(), config.password());
		new ServiceCreationPage().accountPreRequisites();
		ui_wait(5);
		new BuildPipeLinePage().createJiraPipeline(reader.getCellData("Pipeline", "applicationName", 2),reader.getCellData("Pipeline", "versionType", 2),reader.getCellData("Pipeline", "retentionCount", 2),reader.getCellData("Pipeline", "triggerType", 2),userRoleList);

	}

}
