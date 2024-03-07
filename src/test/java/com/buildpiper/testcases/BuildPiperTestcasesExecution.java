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
import com.buildpiper.pages.PreRequisitesPage;
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

public class BuildPiperTestcasesExecution extends BaseTest {
	
	FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);


    //XlsReadData reader = new XlsReadData(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\Sandbox1TestData.xlsx");
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
	
	@Test(groups = { "Regression" },priority = 0)
	@RetryCountIfFailed(2)
	public void BuildPipeLine() {
		//RK
		//new LoginPage().login(config.username(), config.password());
		//new PreRequisitesPage().switchUser();
		//new LoginPage().login(reader.getCellData("UserData", "username", 2), reader.getCellData("UserData", "password", 2));
		new ServiceCreationPage().accountPreRequisites();
		new BuildPipeLinePage().buildAndValidateConsolePage(reader.getCellData("Pipeline", "applicationName", 2),reader.getCellData("Pipeline", "existingPipeline", 2));
	}
	
	@Test(groups = { "Regression" },priority = 0)
	@RetryCountIfFailed(2)
	public void managePopupTest() {
		int RowNumber=reader.getRowByTestCaseName("Pipeline", "managePopupTest");
		//new LoginPage().login(config.username(), config.password());		
		new BuildPipeLinePage().managePopupTest(reader.getCellData("Pipeline", "applicationName", RowNumber),reader.getCellData("Pipeline", "existingPipeline", RowNumber));

	}
	
	@Test(groups = { "Regression" },priority = 1)
	@RetryCountIfFailed(2)	
	public void CreateBasicPipeLine_logs() {
		
		String pipelineName = "BasicPipeline" + RandomStrings.generateRandomString(9);
		String baseurl=config.apibaseurl();
		ArrayList<String> userRoleList = new ArrayList<String>();
		userRoleList.add("DEV");
		userRoleList.add("QA");
		userRoleList.add("DEVOPS");
		
		//new LoginPage().login(config.username(), config.password());
		//RK
		new PreRequisitesPage().switchUser();
//		new ServiceCreationPage().accountPreRequisites();
		new BuildPipeLinePage().createBasicPipeline(reader.getCellData("Pipeline", "applicationName", 2),reader.getCellData("Pipeline", "versionType", 2),reader.getCellData("Pipeline", "retentionCount", 2),reader.getCellData("Pipeline", "triggerType", 2),userRoleList,reader.getCellData("Pipeline", "jobType", 2),reader.getCellData("Pipeline", "fromEnv", 2),reader.getCellData("Pipeline", "jobType2", 2),reader.getCellData("Pipeline", "toEnv", 2),reader.getCellData("Pipeline", "ArtifactName", 2),reader.getCellData("Pipeline", "jobType3", 2),reader.getCellData("Pipeline", "ArtifactName2", 2),reader.getCellData("Pipeline", "prodEnv", 2),pipelineName);
		//new BuildPipeLinePage().executeBasicPipeline();
		//ui_wait(180);
		new BuildPipeLinePage().fetchlogs(baseurl, pipelineName);
	}
	
	@Test(groups = { "Regression" },priority = 2)
	@RetryCountIfFailed(2)	
	public void CreateJiraPipeLine() {
		
		ArrayList<String> userRoleList = new ArrayList<String>();
		userRoleList.add("DEV");
		userRoleList.add("QA");
		userRoleList.add("DEVOPS");
		//new LoginPage().login(config.username(), config.password());
		ui_wait(3);
		//new LoginPage().login(reader.getCellData("UserData", "username", 2), reader.getCellData("UserData", "password", 2));
		new ServiceCreationPage().accountPreRequisites();
		ui_wait(4);
		new BuildPipeLinePage().createJiraPipeline(reader.getCellData("Pipeline", "applicationName", 2),reader.getCellData("Pipeline", "versionType", 2),reader.getCellData("Pipeline", "retentionCount", 2),reader.getCellData("Pipeline", "triggerType", 2),userRoleList);

	}

//	@Test(groups = { "Regression" },priority = 3)
//	@RetryCountIfFailed(2)	
//	public void runBasicPipeLine() {
//		
//		new LoginPage().login(reader.getCellData("UserData", "username", 2), reader.getCellData("UserData", "password", 2));
//		new BuildPipeLinePage().executeBasicPipeline(reader.getCellData("Pipeline", "applicationName", 2),reader.getCellData("Pipeline", "existingPipeline", 2));
//		
//	}
	
	@Test(groups = { "Regression" },priority = 4)
	@RetryCountIfFailed(2)	
	public void CreateBasicPipeLineNegative1() {
		
		
		
		ArrayList<String> userRoleList = new ArrayList<String>();
		userRoleList.add("DEV");
		userRoleList.add("QA");
		userRoleList.add("DEVOPS");
		new LoginPage().login(config.username(), config.password());
		ui_wait(4);
		//new LoginPage().login(reader.getCellData("UserData", "username", 2), reader.getCellData("UserData", "password", 2));
		new BuildPipeLinePage().createBasicPipelineNegativeTest4(reader.getCellData("Pipeline", "applicationName", 3),reader.getCellData("Pipeline", "versionType", 3),reader.getCellData("Pipeline", "retentionCount", 3),reader.getCellData("Pipeline", "triggerType", 3),userRoleList,reader.getCellData("Pipeline", "existingPipeline", 3));
		//new BuildPipeLinePage().executeBasicPipeline();
		
	}
	
	@Test(groups = { "Regression" },priority = 5)
	@RetryCountIfFailed(2)	
	public void CreateBasicPipeLineNegative2() {
		
		
		
		ArrayList<String> userRoleList = new ArrayList<String>();
		userRoleList.add("DEV");
		userRoleList.add("QA");
		userRoleList.add("DEVOPS");
		new LoginPage().login(config.username(), config.password());
		ui_wait(4);
		//new LoginPage().login(reader.getCellData("UserData", "username", 2), reader.getCellData("UserData", "password", 2));
		new BuildPipeLinePage().createBasicPipelineNegativeTest5(reader.getCellData("Pipeline", "applicationName", 4),reader.getCellData("Pipeline", "versionType", 4),reader.getCellData("Pipeline", "retentionCount", 4),reader.getCellData("Pipeline", "triggerType", 4),userRoleList);
		//new BuildPipeLinePage().executeBasicPipeline();
		
	}
	
	//RK
	@Test(groups = { "Regression" },priority = 1)
	@RetryCountIfFailed(2)	
	public void createSchedulePipeline() {
		
		ArrayList<String> userRoleList = new ArrayList<String>();
		userRoleList.add("DEV");
		userRoleList.add("QA");
		userRoleList.add("DEVOPS");
		int RowNumber=reader.getRowByTestCaseName("Pipeline", "createSchedulePipeline");
		
		String ApplicationName=reader.getCellData("Pipeline", "applicationName", RowNumber);
		String VersionType=reader.getCellData("Pipeline", "versionType", RowNumber);
		String RetentionCount=reader.getCellData("Pipeline", "retentionCount", RowNumber);
		String TriggerType=reader.getCellData("Pipeline", "triggerType", RowNumber);
		String JobType=reader.getCellData("Pipeline", "jobType", RowNumber);
		String EnvFrom=reader.getCellData("Pipeline", "fromEnv", RowNumber);
		String JobType2=reader.getCellData("Pipeline", "jobType2", RowNumber);
		String ToEnv=reader.getCellData("Pipeline", "toEnv", RowNumber);
		String ArtifactName=reader.getCellData("Pipeline", "ArtifactName", RowNumber);
		String JobType3=reader.getCellData("Pipeline", "jobType3", 2);
		String ArtifactName2=reader.getCellData("Pipeline", "ArtifactName2", RowNumber);
		String ProdEnv=reader.getCellData("Pipeline", "prodEnv", RowNumber);
		
		//new LoginPage().login(config.username(), config.password());
		//RK
		new PreRequisitesPage().switchUser();
		ui_wait(4);
		new BuildPipeLinePage().createSchedulePipeline(ApplicationName,VersionType,RetentionCount,TriggerType,userRoleList,JobType,EnvFrom,JobType2,ToEnv,ArtifactName,JobType3,ArtifactName2,ProdEnv);
		//new BuildPipeLinePage().executeBasicPipeline();
		
	}
	
	@Test(groups = { "Regression" },priority = 1)
	@RetryCountIfFailed(2)	
	public void createSCMPollPipeline() {
		
		ArrayList<String> userRoleList = new ArrayList<String>();
		userRoleList.add("DEV");
		userRoleList.add("QA");
		userRoleList.add("DEVOPS");
		int RowNumber=reader.getRowByTestCaseName("Pipeline", "createSCMPollPipeline");
		
		String ApplicationName=reader.getCellData("Pipeline", "applicationName", RowNumber);
		String VersionType=reader.getCellData("Pipeline", "versionType", RowNumber);
		String RetentionCount=reader.getCellData("Pipeline", "retentionCount", RowNumber);
		String TriggerType=reader.getCellData("Pipeline", "triggerType", RowNumber);
		String JobType=reader.getCellData("Pipeline", "jobType", RowNumber);
		String EnvFrom=reader.getCellData("Pipeline", "fromEnv", RowNumber);
		String JobType2=reader.getCellData("Pipeline", "jobType2", RowNumber);
		String ToEnv=reader.getCellData("Pipeline", "toEnv", RowNumber);
		String ArtifactName=reader.getCellData("Pipeline", "ArtifactName", RowNumber);
		String JobType3=reader.getCellData("Pipeline", "jobType3", 2);
		String ArtifactName2=reader.getCellData("Pipeline", "ArtifactName2", RowNumber);
		String ProdEnv=reader.getCellData("Pipeline", "prodEnv", RowNumber);
		
		new LoginPage().login(config.username(), config.password());
		//RK
		new PreRequisitesPage().switchUser();
		ui_wait(4);
		new BuildPipeLinePage().createSCMPollPipeline(ApplicationName,VersionType,RetentionCount,TriggerType,userRoleList,JobType,EnvFrom,JobType2,ToEnv,ArtifactName,JobType3,ArtifactName2,ProdEnv);
		new BuildPipeLinePage().runwithParameter();
		
	}
	
	@Test(groups = { "Regression" },priority = 1)
	@RetryCountIfFailed(2)	
	public void EditPipeline() {
		
		ArrayList<String> userRoleList = new ArrayList<String>();
		userRoleList.add("DEV");
		userRoleList.add("QA");
		userRoleList.add("DEVOPS");
		int RowNumber=reader.getRowByTestCaseName("Pipeline", "EditPipeline");
		
		String ApplicationName=reader.getCellData("Pipeline", "applicationName", RowNumber);
		String VersionType=reader.getCellData("Pipeline", "versionType", RowNumber);
		String RetentionCount=reader.getCellData("Pipeline", "retentionCount", RowNumber);
		String TriggerType=reader.getCellData("Pipeline", "triggerType", RowNumber);
		String JobType=reader.getCellData("Pipeline", "jobType", RowNumber);
		String EnvFrom=reader.getCellData("Pipeline", "fromEnv", RowNumber);
		String JobType2=reader.getCellData("Pipeline", "jobType2", RowNumber);
		String ToEnv=reader.getCellData("Pipeline", "toEnv", RowNumber);
		String ArtifactName=reader.getCellData("Pipeline", "ArtifactName", RowNumber);
		String JobType3=reader.getCellData("Pipeline", "jobType3", 2);
		String ArtifactName2=reader.getCellData("Pipeline", "ArtifactName2", RowNumber);
		String ProdEnv=reader.getCellData("Pipeline", "prodEnv", RowNumber);
		
		//new LoginPage().login(config.username(), config.password());
		//RK
		new PreRequisitesPage().switchUser();
		ui_wait(4);
		new BuildPipeLinePage().EditandDeletePipeline(ApplicationName,VersionType,RetentionCount,TriggerType,userRoleList,JobType,EnvFrom,JobType2,ToEnv,ArtifactName,JobType3,ArtifactName2,ProdEnv);
		//new BuildPipeLinePage().executeBasicPipeline();
		
	}

	
}








////////////////// test change delta /////////////////////
