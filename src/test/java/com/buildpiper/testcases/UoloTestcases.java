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

public class UoloTestcases extends BaseTest {

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
	public void createServ() {
		ServiceCreationPage servicecreationpage=new ServiceCreationPage();
		BuildConfigurationPage buildconfig=new BuildConfigurationPage();
		DeployConfigurationPage deployconfig=new DeployConfigurationPage();
		ArrayList<String> chipList = new ArrayList<String>();
//		chipList.add(" All");
		chipList.add("linux/arm64");
		chipList.add("linux/amd64");

		ArrayList<String> languageList = new ArrayList<String>();
		languageList.add("JAVA");

		ArrayList<String> list = new ArrayList<String>();
		list.add("QA");
		list.add("DEV");
		list.add("DevOps");

		ArrayList<String> serviceButton = new ArrayList<String>();
		serviceButton.add("Build");
		serviceButton.add("Deploy");
		serviceButton.add("History");
		serviceButton.add("Monitoring");
		
	    new PreRequisitesPage().switchUser();
	    ui_wait(4);
		int RowNumber=reader.getRowByTestCaseName("MicroServiceData", "createServ");
		
		servicecreationpage.buildAndValidateService(reader.getCellData("MicroServiceData", "applicationName", RowNumber),
				reader.getCellData("MicroServiceData", "envName", RowNumber),
				reader.getCellData("MicroServiceData", "buildRadioButtonName", RowNumber), list,
				reader.getCellData("MicroServiceData", "JobTemplateValue", RowNumber));
		String servicename=servicecreationpage.servicename;
//		String prehook1=reader.getCellData("MicroServiceData", "preHookPass", RowNumber)+servicename+"/.env .";
//		String prehook2=reader.getCellData("MicroServiceData", "preHookPass", RowNumber)+servicename+"/credentials/drive-token.json .";
//		String prehook3=reader.getCellData("MicroServiceData", "preHookPass", RowNumber)+servicename+"/credentials/drive-credentials.json .";
//		String prehook4=reader.getCellData("MicroServiceData", "preHookPass", RowNumber)+servicename+"/credentials/sheet-credentials.json .";
//		String prehook5=reader.getCellData("MicroServiceData", "preHookPass", RowNumber)+servicename+"/credentials/sheet-token.json .";
		
		String prehook1=reader.getCellData("MicroServiceData", "preHookPass", RowNumber)+"cms-bkd/.env .";
		String prehook2=reader.getCellData("MicroServiceData", "preHookPass", RowNumber)+"cms-bkd/credentials/drive-token.json .";
		String prehook3=reader.getCellData("MicroServiceData", "preHookPass", RowNumber)+"cms-bkd/credentials/drive-credentials.json .";
		String prehook4=reader.getCellData("MicroServiceData", "preHookPass", RowNumber)+"cms-bkd/credentials/sheet-credentials.json .";
		String prehook5=reader.getCellData("MicroServiceData", "preHookPass", RowNumber)+"cms-bkd/credentials/sheet-token.json .";
		
		
		buildconfig.CreateAndValidateBuildConfig_MultiplePrehook(reader.getCellData("MicroServiceData", "gitURL", RowNumber),
				reader.getCellData("MicroServiceData", "BranchName", RowNumber),
				reader.getCellData("MicroServiceData", "FilePath", RowNumber),
				reader.getCellData("MicroServiceData", "DockerFilePath", RowNumber), chipList, languageList,
				prehook1,prehook2,prehook3,prehook4,prehook5,
				reader.getCellData("MicroServiceData", "envName", RowNumber));
		
		servicecreationpage.SearchServiceViaRandomStringValue(reader.getCellData("MicroServiceData", "applicationName", RowNumber),servicename);
		
		//build Service
		ui_wait(2);
		new ServiceCreationPage().buildButton_Click();
		ui_wait(1);
		//new ServiceCreationPage().buildButton_Click();
		ui_wait(5);
		//new ServiceCreationPage().Verify_EnvironmentandSubEnvironment("STAGING",reader.getCellData("MicroServiceData", "envName", RowNumber));
		ui_wait(3);
		new ServiceCreationPage().triggerBuild_Click();
		ui_wait(8);
		new ServiceCreationPage().RefreshBuildandDeploy_Click();
		ui_wait(3);
		new ServiceCreationPage().Verify_buildStatus("RUNNING");
		new ServiceCreationPage().RefreshBuildandDeploy_Click();
		ui_wait(60);
		new ServiceCreationPage().RefreshBuildandDeploy_Click();
		ui_wait(30);
		new ServiceCreationPage().RefreshBuildandDeploy_Click();
		ui_wait(30);
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
		System.out.println(ArtifactID);
		servicecreationpage.OpenFirstService();
		servicecreationpage.deleteService(servicename);
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
		  new PreRequisitesPage().switchUser();
		ui_wait(5);
		new BuildPipeLinePage().createUoloPipeline(reader.getCellData("Pipeline", "applicationName", 2),
				reader.getCellData("Pipeline", "versionType", 2), reader.getCellData("Pipeline", "retentionCount", 2),
				reader.getCellData("Pipeline", "triggerType", 2), userRoleList,
				reader.getCellData("Pipeline", "jobType", 2), reader.getCellData("Pipeline", "fromEnv", 2),
				reader.getCellData("Pipeline", "jobType2", 2), reader.getCellData("Pipeline", "toEnv", 2),
				reader.getCellData("Pipeline", "ArtifactName", 2), reader.getCellData("Pipeline", "jobType3", 2),
				reader.getCellData("Pipeline", "ArtifactName2", 2), reader.getCellData("Pipeline", "prodEnv", 2),pipelineName);

	}
	
	


}
