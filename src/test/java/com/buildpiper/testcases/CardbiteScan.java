package com.buildpiper.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.buildpiper.base.BaseTest;
import com.buildpiper.listeners.RetryCountIfFailed;
import com.buildpiper.pages.BuildConfigurationPage;
import com.buildpiper.pages.BuildDeployAlternatePage;
import com.buildpiper.pages.BuildPipeLinePage;
import com.buildpiper.pages.DeployConfigurationPage;
import com.buildpiper.pages.EnvironmentCreationPage;
import com.buildpiper.pages.GitEventsPage;
import com.buildpiper.pages.HomePage;
import com.buildpiper.pages.LoginPage;
import com.buildpiper.pages.PreRequisitesPage;
import com.buildpiper.pages.ServiceCreationPage;
import com.buildpiper.utils.Configuration;
import com.buildpiper.utils.ExcelUtility;
import com.buildpiper.utils.FrameworkConfig;
import com.buildpiper.utils.Pause;
import com.buildpiper.utils.RandomStrings;
import com.buildpiper.utils.XlsReadData;
import com.buildpiper.utils.testDataUtil;

/**
 * @author: SagarT
 * @reviewer: @
 * 
 *
 */

@Listeners(com.buildpiper.report.ExtentReportListener.class)

public class CardbiteScan extends BaseTest {

	FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);

//	@DataProvider
//	public Iterator<Object[]> createServiceTestData() {
//		ArrayList<Object[]> CreateServiceData = testDataUtil.getMicroServiceData();
//		return CreateServiceData.iterator();
//	}

	ExcelUtility reader = new ExcelUtility();
	
//	ArrayList<String> languageList = new ArrayList<String>();
//	ArrayList<String> chipList = new ArrayList<String>();
//	ArrayList<String> list = new ArrayList<String>();

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
	public void CardBite_CardManagementServiceBuildandDeploy() {
		ServiceCreationPage servicecreationpage=new ServiceCreationPage();	
		String servicename="STAGE-CARD-MANAGEMENT-SERVICE";
        String branch="CAR-NEW-STAGING";
	    new PreRequisitesPage().switchUser();
	    ui_wait(4);
		int RowNumber=reader.getRowByTestCaseName("MicroServiceData", "createServ");        
		servicecreationpage.SearchServiceViaRandomStringValue(reader.getCellData("MicroServiceData", "applicationName", RowNumber),servicename);
		
		//build Service
		ui_wait(2);
		new ServiceCreationPage().buildButton_Click();
		ui_wait(1);
		//new ServiceCreationPage().buildButton_Click();
		ui_wait(3);
		new ServiceCreationPage().SelectBranch(branch);
		ui_wait(2);
		new ServiceCreationPage().triggerBuild_Click();
		ui_wait(10);
		new ServiceCreationPage().RefreshBuildandDeploy_Click();
		ui_wait(3);
		new ServiceCreationPage().Verify_buildStatus("RUNNING");
		new ServiceCreationPage().RefreshBuildandDeploy_Click();
		ui_wait(60);
		new ServiceCreationPage().RefreshBuildandDeploy_Click();
		ui_wait(10);
		//new ServiceCreationPage().Verify_buildStatus("SUCCESS");
		ui_wait(3);
		new ServiceCreationPage().closeBuildWindow();
		ui_wait(10);
		new ServiceCreationPage().RefreshService_Click();
		ui_wait(2);
		ui_IsElementDisplay(ui_waitForElementToDisplay(new ServiceCreationPage().buildArtifact, Pause.MEDIUM));
		String ArtifactID=new ServiceCreationPage().buildArtifact.getText();
		
		//Deploy Service
		new ServiceCreationPage().deployService(ArtifactID);
		ui_wait(3);
	  //	new ServiceCreationPage().Verify_deployStatus("RUNNING");
		ui_wait(4);
		new ServiceCreationPage().RefreshBuildandDeploy_Click();
		ui_wait(60);
		new ServiceCreationPage().deployRecentButtonClick();
		ui_switchToNewWindow();
		ui_wait(20);
		new ServiceCreationPage().RefreshBuildandDeploy_Click();
		ui_wait(10);
		new ServiceCreationPage().RefreshBuildandDeploy_Click();
		ui_wait(3);
		new ServiceCreationPage().Verify_deployStatus("SUCCESS");
		ui_wait(3);
		new ServiceCreationPage().closeDeployWindow();
		ui_wait(3);
		
		// Trigger Build and Deploy 
		ui_wait(2);
		new ServiceCreationPage().buildButton_Click();
		ui_wait(1);
		//new ServiceCreationPage().buildButton_Click();
		ui_wait(3);
		new ServiceCreationPage().SelectBranch(branch);
		ui_wait(2);
		new ServiceCreationPage().TriggerBuildandDeploy_Click();
	}

}
