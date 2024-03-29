package com.buildpiper.pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.buildpiper.base.BasePage;
import com.buildpiper.utils.Configuration;
import com.buildpiper.utils.Pause;
import com.buildpiper.utils.RandomStrings;

import groovyjarjarantlr4.v4.runtime.tree.xpath.XPath;

public class ServiceCreationPage extends BasePage {

	SoftAssert softAssert = new SoftAssert();
   public String servicename;
	String ServiceName = "automation-" + RandomStrings.generateRandomString(15);
	String ServiceHelmName = "automation-helm-" + RandomStrings.generateRandomString(9);

	String ExternalName = "automation-" + RandomStrings.generateRandomString(8);
	String ExternalHelmName = "automation-helm-" + RandomStrings.generateRandomString(8);

//	@FindBy(xpath = "//span[@title='perfeasy-testing']//..//..//span[text()='Service Overview']")
//	WebElement serviceOverViewTab;

	@FindBy(xpath = "//button//span[2][@class='flaticon-expand-arrow']/../..//div//span[@title='Service Overview']/span")
	WebElement serviceOverViewTab;

	@FindBy(xpath = "//li//button[contains(@class,'main-nav-1')]//span[1][@title]")
	List<WebElement> poc_qaProjectLink;

	@FindBy(xpath = "//a[@class='btn btn-submit']")
	WebElement addServiceBtn;
	

	@FindBy(xpath = "//h1[@class='main-heading']")
	WebElement main_Heading;

	@FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-container']//div[@class='txt']")
	List<WebElement> muiGridContainerText;

	@FindBy(xpath = "//p[(@class='service-form-heading')]")
	WebElement createaServiceHeading;

	@FindBy(xpath = "//p[(@class='hint-text-main-heading')]")
	WebElement subHeading;

	@FindBy(xpath = "//input[@placeholder='demo-app']")
	WebElement service_Name_SearchBox;

	@FindBy(xpath = "//input[@placeholder='Sample-Service']")
	WebElement external_Name_SearchBox;

	@FindBy(xpath = "//span[contains(.,'Build once and promote')]")
	WebElement buildForOnceBuild_Radiobtn;

	@FindBy(xpath = "//span[contains(.,'Build for every environment')]")
	WebElement buildForEveryBuild_Radiobtn;

	@FindBy(xpath = "//button[@class='btn btn-submit']")
	WebElement saveAndContinue_Create_Page;

	@FindBy(xpath = "//h1[@class='h1' and contains(.,'Create a Environment')]")
	WebElement environmentHeader;

	@FindBy(xpath = "//div[@class='staticwrap-inner']")
	WebElement environmentSubHeader;

	@FindBy(xpath = "//select[@name='env_id']")
	WebElement envDropdown;

	@FindBy(xpath = "//input[@name='manual_build']")
	WebElement allowManualBuildYes;

	@FindBy(xpath = "//input[@name='manual_deploy']")
	WebElement allowManualDeployYes;

	@FindBy(xpath = "//div[@class='selectJob_heading']//p")
	WebElement userRoleGroupText;

	@FindBy(xpath = "//input[@name='qa'][@type='checkbox']")
	WebElement qaroleGroupCheckbox;

	@FindBy(xpath = "//span[contains(@class,'MuiCheckbox-root')]//input")
	List<WebElement> roleGroupCheckbox;

	@FindBy(xpath = "//input[@name='job_template_version'][@type='radio'][@value='v2']")
	WebElement selectJobTemplateRadioBtn;

	@FindBy(xpath = "//select[@name='project_job_template_id']")
	WebElement jobTemplateDropdown;

	@FindBy(xpath = "//div[@class='font-27 font-family-nunito font-weight-300 lh-12 mr-5']")
	WebElement createdServiceName;

	@FindBy(xpath = "//span[contains(text(),'Project:')]")
	WebElement projectNameCheck;

	@FindBy(xpath = "//span[contains(text(),'Job Template: ')]")
	WebElement validateJobTemplate;

	@FindBy(xpath = "//span[contains(text(),' User Group: ')]")
	WebElement validateUserRole;

	////////////// change //////////////////////

//	@FindBy(xpath = "//*[text()='Build Details']")
//	WebElement validateBuildDetails;
//
//	@FindBy(xpath = "//*[text()='Deploy Details']")
//	WebElement validateDeployDetails;

	////////////// change //////////////////////

	@FindBy(xpath = "//*[text()='Env Build Details']")
	WebElement validateBuildDetails;

	@FindBy(xpath = "//*[text()='Env Deploy Details']")
	WebElement validateDeployDetails;

	@FindBy(xpath = "//*[text()='Integration Testing']")
	WebElement validateIntegrationDetails;

	@FindBy(xpath = "//*[text()='Other Deployment Info']")
	WebElement validateOtherDeploymentDetails;

	@FindBy(xpath = "//*[text()='Generated Manifest']")
	WebElement validateGeneratedManifest;

	@FindBy(xpath = "//p[@class='main-text mb-10']")
	WebElement buildDetailsTextMain;

	@FindBy(xpath = "//span[@class='sub-text mb-10']")
	WebElement buildDetailsTextSub;

	@FindBy(xpath = "//p[@class='main-text mb-10']")
	WebElement deployDetailsTextMain;

	@FindBy(xpath = "//span[@class='sub-text mb-10']")
	WebElement deployDetailsTextSub;

	@FindBy(xpath = "//*[text()='To have a very smooth configuration we strongly recommend BuildPiper UI.']")
	WebElement deployDetailsTextSub1;

	@FindBy(xpath = "//*[text()='you can also configure the CD by uploading your custom manifest file.']")
	WebElement deployDetailsTextSub2;

	@FindBy(xpath = "//*[text()='Integration Testing Configuration']")
	WebElement integrationText1;

	@FindBy(xpath = "//*[text()='To know more about integration testing please read the ']")
	WebElement integrationText2;

	@FindBy(xpath = "//*[text()='Integrations testing Configuration ']")
	WebElement integrationText3;

	@FindBy(xpath = "//*[text()='Other Deployment Details']")
	WebElement otherDeploymentDetails1;

	@FindBy(xpath = "//*[text()='To know more about access levels please read the ']")
	WebElement otherDeploymentDetails2;

	@FindBy(xpath = "//*[text()=' Please configure deployment details to setup HPA(Horizontal Pod Autoscaling)']")
	WebElement otherDeploymentDetails3;

	@FindBy(xpath = "//*[text()='No Manifest File has been generated.']")
	WebElement generatedManifestText;

	@FindBy(xpath = "//button[contains(@class,'btn-link-green')][text()=' Switch to User Portal']")
	WebElement switchToUSer;

	@FindBy(xpath = "//button[@type='button' and @aria-controls='menu-appbar']//div//div")
	WebElement userMenuAppBar;

	@FindBy(xpath = "//a[@href='/integration/containerRegistries']")
	WebElement containerRegistryBtn;

	@FindBy(xpath = "(//button[@class='test-btn'])[1]")
	WebElement testConnection;

	@FindBy(xpath = "//div[contains(@class,'connected text connected')]")
	WebElement connectionStatusText;


	@FindBy(xpath = "//div[contains(@class,'service-name')]//a[contains(@href,'service')]")
	List<WebElement> serviceList;
	@FindBy(xpath = "//button[text()='Check Status']")
	WebElement statusCheck;
	@FindBy(xpath = "//span[@id='healthstatus']")
	WebElement healthStatus;
	@FindBy(xpath = "//span[text()='Promoted On: ']")
	WebElement promotedOn;	
	@FindBy(xpath = "//div[@class='build-section']//div[contains(@class,'status-chip status-chip')]")
	WebElement runningBuildStatus;
	@FindBy(xpath = "(//div/p[text()='Artifact']/following-sibling::span)[1]")
	public WebElement buildArtifact;
	@FindBy(xpath = "(//div/div[text()='Artifact ']/following-sibling::span)[1]")
	public WebElement deployandPromoteartifactID1;
	
	@FindBy(xpath = "//span[text()='Commit ID: ']/../div/span")
	WebElement commitID;
	@FindBy(xpath = "//span[text()='Commit Msg: ']/../div/span")
	WebElement commitMessage;
	@FindBy(xpath = "//span[text()='Build on: ']/following-sibling::span")
	WebElement buildOn;
	@FindBy(xpath = "//span[text()='Promoted By: ']/following-sibling::span")
	WebElement promotedBy;
	
	
	@FindBy(xpath = "(//div[@class='service-lising-detailed-card card']//span[@class='tab-label-inner'][1])[1]")
	WebElement deployNumber;
	@FindBy(xpath = "(//p[text()='Artifact']/../span)[1]")
	WebElement deployArtifact;
	@FindBy(xpath = "//span[text()='Manifest Applied']/span/span")
	WebElement deployManifestApplied;
	@FindBy(xpath = "//span[text()='Rollout']/span/span")
	WebElement deployRollout;
	@FindBy(xpath = "//span[text()='Deployed On: ']/following-sibling::span")
	WebElement deployOn;
	@FindBy(xpath = "//span[text()='Deployed By: ']/following-sibling::span")
	WebElement deployBy;
	@FindBy(xpath = "//span[text()='Uptime: ']/following-sibling::span")
	WebElement deployUptime;
	@FindBy(xpath = "//span[text()='Restart: ']/following-sibling::span")
	WebElement deployRestart;
	

	
	
	
	@FindBy(xpath = "//button[@title='Build']")
	WebElement build;
	@FindBy(xpath = "//button[@title='Deploy']")
	WebElement deploy;
	@FindBy(xpath = "//button/span[@class='flaticon-forward-arrow']")
	WebElement promote;
	@FindBy(xpath = "//select[@name='promote_env']")
	WebElement promoteEnvironmentSelect;
	
	@FindBy(xpath = "//button[@title='History']")
	WebElement history;
	@FindBy(xpath = "//button[@title='Monitoring']")
	WebElement monitoring;
	@FindBy(xpath = "//a[text()='Build #']")
	WebElement historyBuild;
	@FindBy(xpath = "(//p[contains(@title,'tag : ')])[1]")
	WebElement historyTag;
	@FindBy(xpath = "(//p[contains(@title,'no_cache : ')])[1]")
	WebElement historyCacheorNoCache;
	@FindBy(xpath = "(//p[contains(@title,'is_deploy : ')])[1]")
	WebElement historyIsDeploy;
	@FindBy(xpath = "(//p[contains(@title,'custom_tag : ')])[1]")
	WebElement historyCustomtag;
	@FindBy(xpath = "(//p[contains(@title,'branch_name : ')])[1]")
	WebElement historyBranchname;
	@FindBy(xpath = "//input[@placeholder='Artifact']")
	WebElement searchArtifact;
	@FindBy(xpath = "(//p[contains(@title,'activity_master_code : ')])[1]")
	WebElement historyActivity_MasterCode;
	
	@FindBy(xpath = "(//p[contains(@title,'dry_run : ')])[1]")
	WebElement deployDryrun;
	@FindBy(xpath = "(//p[contains(@title,'component_id : ')])[1]")
	WebElement deployComponentid;
	@FindBy(xpath = "(//p[contains(@title,'deploy_by_user : ')])[1]")
	WebElement deploybyuser;
	@FindBy(xpath = "(//p[contains(@title,'deployment_type : ')])[1]")
	WebElement deploymenttype;
	@FindBy(xpath = "(//p[contains(@title,'deployment_status_check : ')])[1]")
	WebElement deploymentstatuscheck;
	
	
	@FindBy(xpath = "//div[@class='card']//button[@class='MuiButtonBase-root MuiIconButton-root']")
	WebElement buildwindow_closeButton;
	@FindBy(xpath = "//div[@class='card']//button[@class='MuiButtonBase-root MuiIconButton-root']")
	WebElement deploywindow_closeButton;
	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-edgeEnd']")
	WebElement historywindow_closeButton;
	@FindBy(xpath = "(//div[@class='history-body']/div/a)[1]")
	WebElement history_buildType;
	@FindBy(xpath = "(//div[@class='history-body']/div/p[1])[1]")
	WebElement history_buildStatus;
	@FindBy(xpath = "(//div[@class='history-body']/div/p[2])[1]")
	WebElement history_buildDuration;
	@FindBy(xpath = "(//div[@class='history-body']/div/p[3])[1]")
	WebElement history_buildDateandTime;
	@FindBy(xpath = "(//div[@class='history-body']/div/div/p)[1]")
	WebElement history_buildArtifact;
	@FindBy(xpath = "(//div[@class='history-body']/div/p[4])[1]")
	WebElement history_buildby;
	@FindBy(xpath = "(//div[@class='history-body']/div/div/p)[2]")
	WebElement history_CommitID;
	@FindBy(xpath = "(//div[@class='history-body']/div/div/p[1])[3]")
	WebElement history_CommitMessage;
	
	
	public ServiceCreationPage() {

	}

	public ServiceCreationPage accountPreRequisites() {
		if(Configuration.get("environment").equals("pt") || Configuration.get("environment").equals("sandbox") || Configuration.get("environment").equals("demo") || Configuration.get("environment").equals("lenskart") || Configuration.get("environment").equals("uolo")){
		ui_click(userMenuAppBar, "userMenuAppBar");
		boolean switchTypeCheck = ui_IsElementPresent(switchToUSer, "5");
		if (switchTypeCheck == true) {
			ui_click(containerRegistryBtn, "clicks on container registry");
			ui_click(testConnection, "clicks on first container registry test");
			ui_IsElementDisplay(ui_waitForElementToDisplay(connectionStatusText, Pause.MEDIUM));
			// Assert.assertEquals(connectionStatusText.getText().trim(), "CONNECTED",
			// "connection status validated");
			ui_wait(5);
			
			ui_click(userMenuAppBar, "userMenuAppBar");
			ui_click(switchToUSer, "switching to user account");
			}
		}
		return this;

	}

	public ServiceCreationPage addService(String appName, String ProjectName, String buildRadioButtonName) {

		boolean projectSelection = false;
		ui_wait(5);
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for (WebElement element : poc_qaProjectLink) {
			if (element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if (projectSelection) {

			ui_click(serviceOverViewTab, "Poc_QA serviceOverviewLink");
			ui_IsElementDisplay(ui_waitForElementToDisplay(addServiceBtn, Pause.MEDIUM));
			ui_click(addServiceBtn, "Poc_QA addServiceBtn");
			ui_IsElementDisplay(ui_waitForElementToDisplay(main_Heading, Pause.MEDIUM));
			String mainHeadingText = main_Heading.getText();
			///// Create Page Text Validations //////////////////////////
			Assert.assertEquals(mainHeadingText, "Benefits of creating Microservices",
					"Unable to validate 'Benefits of creating Microservices'");

			boolean muiTxtStatus = true;
			for (WebElement muicontainer : muiGridContainerText) {
				String muiText = muicontainer.getText();
				System.out.println(muiText);
				if (!(muiText.contains("Go Live with your App in just 24 hours")
						|| muiText.contains("Spin up new Environment in few clicks")
						|| muiText.contains("Onboard a Dockerized service in minutes")
						|| muiText.contains("Enable most robust & secure DevSecOps CI in few clicks")
						|| muiText.contains("Setup & Run hassle free secured Pipelines")
						|| muiText.contains("Speed, Security & Compliance together in one Platform")
						|| muiText.contains("Setup Observability tooling in just 5 mins"))) {
					muiTxtStatus = false;
					break;
				}
			}
			Assert.assertTrue(muiTxtStatus, "Unable to  valudate the MUI container Text on left side");

			String Text8 = createaServiceHeading.getText();
			Assert.assertEquals(Text8, "Create a New Service", "Unable to validate 'Create  new service label'");
			ui_IsElementDisplay(ui_waitForElementToDisplay(subHeading, Pause.MEDIUM));
			String Text9 = subHeading.getText();
			Assert.assertEquals(Text9, "Microservice are used to group pipeline and other setting together",
					"Unable to validate 'Microservice are used to group pipeline and other setting together'");

			ui_setvalue(service_Name_SearchBox, "sets service name", ServiceName);
			ui_setvalue(external_Name_SearchBox, "sets external name", ExternalName);

			if (buildRadioButtonName.contains("Build once and promote")) {
				ui_click(buildForOnceBuild_Radiobtn, "Poc_QA selectOnceRadioBtn");

			} else {
				ui_click(buildForEveryBuild_Radiobtn, "Poc_QA selectEveryRadioBtn");
			}
			ui_click(saveAndContinue_Create_Page, "Poc_QA SubmitCreatePage");

		}
		return this;

	}
	@FindBy(xpath = "(//div[@class='service-name']/a)[1]")
	WebElement firstServiceLink;
	@FindBy(xpath = "(//button[@class='btn btn-with-icon btn-round'])[1]")
	WebElement editServicebutton;
	@FindBy(xpath = "//div[@class='heading-section-env']/div[2]/div[1]/div")
	WebElement servicePagetitle;
	public ServiceCreationPage editService(String appName, String UpdatedService) {

		boolean projectSelection = false;
		ui_wait(5);
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for (WebElement element : poc_qaProjectLink) {
			if (element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if (projectSelection) {
			
			ui_wait(2);
			ui_IsElementDisplay(ui_waitForElementToDisplay(editServicebutton, Pause.MEDIUM));
			ui_click(editServicebutton, "edit Service button");
			ui_wait(2);
			ui_IsElementDisplay(ui_waitForElementToDisplay(service_Name_SearchBox, Pause.MEDIUM));
			ui_clearAndSetValue(service_Name_SearchBox, UpdatedService);
			ui_wait(2);
			ui_click(saveAndContinue_Create_Page, "Poc_QA SubmitCreatePage");
			ui_wait(3);
			Assert.assertEquals(servicePagetitle.getText(), UpdatedService);
			ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));			
			for (WebElement element : poc_qaProjectLink) {
				if (element.getText().trim().equalsIgnoreCase(appName)) {
					element.click();
			}
			}
			ui_wait(2);
			ui_IsElementDisplay(ui_waitForElementToDisplay(serviceOverViewTab, Pause.MEDIUM));
			ui_ActionMoveAndClick(serviceOverViewTab, "serviceOverViewTab");
			ui_IsElementDisplay(ui_waitForElementToDisplay(searchServiceTextBox, Pause.MEDIUM));
			ui_click(searchServiceTextBox, "clicks on Search overview tab under applicartion name");
			ui_clearAndSetValue(searchServiceTextBox, UpdatedService);
			searchServiceTextBox.sendKeys(Keys.ENTER);
			ui_wait(3);
			ui_IsElementDisplay(ui_waitForElementToDisplay(firstServiceLink, Pause.MEDIUM));
			Assert.assertEquals(firstServiceLink.getText(), UpdatedService.toUpperCase());
			ui_wait(2);
			ui_click(firstServiceLink, "firstServiceLink");
		}
		return this;

	}
	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root btn btn-with-icon btn-round']")
	WebElement deleteServicebutton;
	@FindBy(xpath = "//input[@placeholder='Please enter the reason to delete']")
	WebElement deletePopupInputField;
	@FindBy(xpath = "//button[text()='Delete']")
	WebElement deleteButton;
	@FindBy(xpath = "//div[contains(text(),'No Service found with the name : ')]")
	WebElement serviceNotFoundMessage;
	
	public ServiceCreationPage OpenFirstService() {
    ui_IsElementDisplay(ui_waitForElementToDisplay(serviceList.get(0), Pause.MEDIUM));
	ui_click(serviceList.get(0), "Service Link");
	 ui_wait(3);
		return this;
	}
		public ServiceCreationPage deleteService(String Servicename) {
			ui_wait(3);
			ui_IsElementDisplay(ui_waitForElementToDisplay(deleteServicebutton, Pause.MEDIUM));
			ui_click(deleteServicebutton, "deleteServicebutton");
			ui_wait(2);
			ui_setvalue(deletePopupInputField, "deletePopupInputField", "Automation");
			ui_wait(2);
			ui_click(deleteButton, "deleteButton");
			ui_wait(2);
			//-------------Search String
			ui_IsElementDisplay(ui_waitForElementToDisplay(searchServiceTextBox, Pause.MEDIUM));
			ui_click(searchServiceTextBox, "clicks on Search overview tab under applicartion name");
			ui_clearAndSetValue(searchServiceTextBox, Servicename);
			searchServiceTextBox.sendKeys(Keys.ENTER);
			ui_wait(3);
			Assert.assertEquals(ui_IsElementPresent(serviceNotFoundMessage, "4"), true);
		return this;
		
	}
	
	@FindBy(xpath = "//a[@class='text-anchor-blue d-flex align-center text-right btn btn-flaticon']")
	WebElement editEnvironment;
	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root btn btn-flaticon']")
	WebElement deleteEnvironment;
	@FindBy(xpath = "(//input[@name='manual_build'])[2]")
	WebElement allowManualBuildNo;
	@FindBy(xpath = "(//input[@name='manual_deploy'])[2]")
	WebElement allowManualDeployNo;
	@FindBy(xpath = "//div[text()='No Environment Found']")
	WebElement noEnvironmentFoundText;
	
	public ServiceCreationPage editandDeleteEnvironment(String Servicename) {
		ui_wait(3);
			ui_IsElementDisplay(ui_waitForElementToDisplay(editEnvironment, Pause.MEDIUM));
			ui_click(editEnvironment, "editEnvironment");
			ui_wait(3);
			ui_click(allowManualBuildNo, "Poc_QA allowManualBuildNo");
			ui_click(allowManualDeployNo, "Poc_QA allowManualDeployNo");
			ui_wait(3);
			ui_click(saveAndContinue_Create_Page, "Poc_QA SubmitEnvPage");
			ui_wait(3);
			Assert.assertEquals(ui_IsElementPresent(buildButton, "5"), false);
			Assert.assertEquals(ui_IsElementPresent(deployButton, "5"), false);
			ui_wait(3);
			// Again Click on Edit Link and Add Manual build and Deploy
			ui_click(editEnvironment, "editEnvironment");
			ui_wait(3);
			ui_IsElementDisplay(ui_waitForElementToDisplay(envDropdown, Pause.LOW));
			Select dropdown = new Select(envDropdown);
			dropdown.selectByVisibleText("devcommunity");
			ui_click(saveAndContinue_Create_Page, "Poc_QA SubmitEnvPage");
			ui_wait(4);
			Assert.assertEquals(ui_IsElementPresent(buildButton, "5"), true);
			Assert.assertEquals(ui_IsElementPresent(deployButton, "5"), true);
			ui_wait(3);
			//Delete Environment
			ui_click(deleteEnvironment, "deleteEnvironment");
			ui_wait(2);
			ui_IsElementDisplay(ui_waitForElementToDisplay(deletePopupInputField, Pause.MEDIUM));
			ui_setvalue(deletePopupInputField, "deletePopupInputField", "Automation");
			ui_wait(1);
			ui_click(deleteButton, "deleteButton");
			ui_wait(3);
			Assert.assertEquals(ui_IsElementPresent(noEnvironmentFoundText, "3"), true);
		return this;
		
	}

	public ServiceCreationPage buildAndValidateService(String appName, String ProjectName, String buildRadioButtonName,
			ArrayList<String> UserRoles, String JobTemplateValue) {

		boolean projectSelection = false;
		ui_wait(5);
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for (WebElement element : poc_qaProjectLink) {
			if (element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if (projectSelection) {
			ui_wait(3);
			ui_IsElementDisplay(ui_waitForElementToDisplay(serviceOverViewTab, Pause.MEDIUM));
			ui_ActionMoveAndClick(serviceOverViewTab, "serviceOverViewTab");
			ui_IsElementDisplay(ui_waitForElementToDisplay(addServiceBtn, Pause.MEDIUM));
			ui_click(addServiceBtn, "Poc_QA addServiceBtn");
			ui_IsElementDisplay(ui_waitForElementToDisplay(main_Heading, Pause.MEDIUM));
			String mainHeadingText = main_Heading.getText();
			///// Create Page Text Validations //////////////////////////
			Assert.assertEquals(mainHeadingText, "Benefits of creating Microservices",
					"Unable to validate 'Benefits of creating Microservices'");

			boolean muiTxtStatus = true;
			for (WebElement muicontainer : muiGridContainerText) {
				String muiText = muicontainer.getText();
				System.out.println(muiText);
				if (!(muiText.contains("Go Live with your App in just 24 hours")
						|| muiText.contains("Spin up new Environment in few clicks")
						|| muiText.contains("Onboard a Dockerized service in minutes")
						|| muiText.contains("Enable most robust & secure DevSecOps CI in few clicks")
						|| muiText.contains("Setup & Run hassle free secured Pipelines")
						|| muiText.contains("Speed, Security & Compliance together in one Platform")
						|| muiText.contains("Setup Observability tooling in just 5 mins"))) {
					muiTxtStatus = false;
					break;
				}
			}
			Assert.assertTrue(muiTxtStatus, "Unable to  valudate the MUI container Text on left side");

			String Text8 = createaServiceHeading.getText();
			Assert.assertEquals(Text8, "Create a New Service", "Unable to validate 'Create  new service label'");
			ui_IsElementDisplay(ui_waitForElementToDisplay(subHeading, Pause.MEDIUM));
			String Text9 = subHeading.getText();
			Assert.assertEquals(Text9, "Microservice are used to group pipeline and other setting together",
					"Unable to validate 'Microservice are used to group pipeline and other setting together'");
			servicename=ServiceName;
			ui_setvalue(service_Name_SearchBox, "sets service name", ServiceName);
			ui_wait(3);
			//get service name 
			//servicename=service_Name_SearchBox.getText();
			ui_setvalue(external_Name_SearchBox, "sets external name", ExternalName);

			if (buildRadioButtonName.contains("Build once and promote")) {
				ui_click(buildForOnceBuild_Radiobtn, "Poc_QA selectOnceRadioBtn");

			} else {
				ui_click(buildForEveryBuild_Radiobtn, "Poc_QA selectEveryRadioBtn");
			}
			ui_click(saveAndContinue_Create_Page, "Poc_QA SubmitCreatePage");

			////////////// Create a Service Environment ////////////////////////

			ui_IsElementDisplay(ui_waitForElementToDisplay(environmentHeader, Pause.LOW));
			String Text10 = environmentHeader.getText();
			Assert.assertEquals(Text10, "Create a Environment", "Unable to validate 'Create a Environment'");
			ui_IsElementDisplay(ui_waitForElementToDisplay(environmentSubHeader, Pause.MEDIUM));
			String Text11 = environmentSubHeader.getText();
			Assert.assertTrue(Text11.contains(
					"A Environment aims to mitigate such scenarios by encouraging automation and documentation, there by increasing communication. In this environment, every release is committed in an automated fashion, enabling the rapid building, testing and deployment of every project."),
					"Unable to validate 'A Environment aims to mitigate such scenarios by encouraging automation and documentation, there by increasing communication. In this environment, every release is committed in an automated fashion, enabling the rapid building, testing and deployment of every project.'");
			Assert.assertTrue(Text11.contains("To learn more about how to setup a Microservice please read"),
					"Unable to validate 'To learn more about how to setup a Microservice please read'");
			ui_IsElementDisplay(ui_waitForElementToDisplay(envDropdown, Pause.LOW));
			Select dropdown = new Select(envDropdown);
			dropdown.selectByVisibleText(ProjectName);
			// ui_wait(3);

			if (allowManualBuildYes.getAttribute("value").equals("false"))
				ui_click(allowManualBuildYes, "Poc_QA allowManualBuildYes");
			if (allowManualDeployYes.getAttribute("value").equals("false"))
				ui_click(allowManualDeployYes, "Poc_QA allowManualDeployYes");

			///////////////// change //////////////////////////////////

//			String UserRoleGroupText = userRoleGroupText.getText();
//			softAssert.assertEquals(UserRoleGroupText,
//					"Users in the selected roles will have access to the Environment & Microservices above. To learn more about user access roles and groups read the",
//					"Unable to validate 'Users in the selected roles will have access to the Environment & Microservices above. To learn more about user access roles and groups read the'");

			///////////////// change //////////////////////////////////
            ui_wait(5);
			ui_selectValueFromDropDownByXPath(jobTemplateDropdown, "jobTemplateDropdown");
			Select jobdropdown = new Select(jobTemplateDropdown);
			jobdropdown.selectByVisibleText(JobTemplateValue);

			for (int i = 0; i < roleGroupCheckbox.size(); i++) {
				if (UserRoles.contains(roleGroupCheckbox.get(i).getAttribute("value").trim())) {
					roleGroupCheckbox.get(i).click();
				}
			}
			if (allowManualBuildYes.getAttribute("value").equals("false"))
				ui_click(selectJobTemplateRadioBtn, "Poc_QA selectJobTemplateRadioBtn");
			ui_IsElementDisplay(ui_waitForElementToDisplay(saveAndContinue_Create_Page, Pause.LOW));
			ui_click(saveAndContinue_Create_Page, "Poc_QA SubmitEnvPage");
			// ui_wait(5);

			///////////////// Validate Service Overview Page //////////////////////

			ui_IsElementDisplay(ui_waitForElementToDisplay(createdServiceName, Pause.MEDIUM));
			String CreatedServiceName = createdServiceName.getText();
			Assert.assertEquals(CreatedServiceName, ServiceName, "Unable to validate 'ServiceName'");
			ui_IsElementDisplay(ui_waitForElementToDisplay(projectNameCheck, Pause.MEDIUM));
			String ProjectNameCheck = projectNameCheck.getText();
			// Assert.assertEquals(ProjectNameCheck, appName, "Unable to validate
			// 'poc-qa'");
//			ui_IsElementDisplay(ui_waitForElementToDisplay(validateJobTemplate, Pause.MEDIUM));
//			String ValidateJobTemplate = validateJobTemplate.getText();
			// Assert.assertEquals(ValidateJobTemplate, JobTemplateValue, "Unable to
			// validate 'poc-pinelabs-v2'");

			////////////// change /////////////////////////////////////////

//			ui_IsElementDisplay(ui_waitForElementToDisplay(validateUserRole, Pause.MEDIUM));
//			String ValidateUserRole = validateUserRole.getText();
			// Assert.assertEquals(ValidateUserRole, "QA", "Unable to validate 'QA'");

			////////////// change /////////////////////////////////////////

			////////////////// Validate Build Details Empty ///////////////////

			ui_IsElementDisplay(ui_waitForElementToDisplay(validateBuildDetails, Pause.MEDIUM));
			ui_click(validateBuildDetails, "Poc_QA validateBuildDetails");
			ui_IsElementDisplay(ui_waitForElementToDisplay(buildDetailsTextMain, Pause.MEDIUM));
			String BuildDetailsTextMain = buildDetailsTextMain.getText();
			Assert.assertEquals(BuildDetailsTextMain, "Build Details Not Configured",
					"Unable to validate 'Build Details Not Configured'");
			// assert BuildDetailsTextMain.equals("Build Details Not Configured");
			ui_IsElementDisplay(ui_waitForElementToDisplay(buildDetailsTextSub, Pause.MEDIUM));
			String BuildDetailsTextSub = buildDetailsTextSub.getText();
			Assert.assertTrue(BuildDetailsTextSub.contains("Please note to build a service CI is required."),
					"Unable to validate 'Please note to build a service CI is required.'");
			// assert BuildDetailsTextSub.contains("Please note to build a service CI is
			// required.");
			Assert.assertTrue(BuildDetailsTextSub.contains("please click the button below to add Build Details."),
					"Unable to validate 'please click the button below to add Build Details.'");
			// assert BuildDetailsTextSub.contains("please click the button below to add
			// Build Details.");

			////////////////// Validate Deploy Details Empty ///////////////////

			ui_IsElementDisplay(ui_waitForElementToDisplay(validateDeployDetails, Pause.MEDIUM));
			ui_click(validateDeployDetails, "Poc_QA validateDeployDetails");
			ui_IsElementDisplay(ui_waitForElementToDisplay(deployDetailsTextMain, Pause.MEDIUM));
			String DeployDetailsTextMain = deployDetailsTextMain.getText();
			Assert.assertEquals(DeployDetailsTextMain, "CD Details Not Configured",
					"Unable to validate 'CD Details Not Configured'");
			// assert DeployDetailsTextMain.equals("CD Details Not Configured");
			ui_IsElementDisplay(ui_waitForElementToDisplay(deployDetailsTextSub, Pause.MEDIUM));
			String DeployDetailsTextSub = deployDetailsTextSub.getText();
			Assert.assertEquals(DeployDetailsTextSub,
					"Please note to deploy a service CD is required. Please choose from options below to add CD.",
					"Unable to validate 'Please note to deploy a service CD is required. Please choose from options below to add CD.'");
			// assert DeployDetailsTextSub.equals("Please note to deploy a service CD is
			// required. Please choose from options below to add CD.");
			ui_IsElementDisplay(ui_waitForElementToDisplay(deployDetailsTextSub1, Pause.MEDIUM));
			String DeployDetailsTextSub1 = deployDetailsTextSub1.getText();
			softAssert.assertTrue(DeployDetailsTextSub1.contains("BuildPiper-UI: "),
					"Unable to validate 'BuildPiper-UI: '");
			// assert DeployDetailsTextSub1.contains("BuildPiper-UI: ");
			softAssert.assertTrue(
					DeployDetailsTextSub1
							.contains("To have a very smooth configuration we strongly recommend BuildPiper UI."),
					"Unable to validate 'To have a very smooth configuration we strongly recommend BuildPiper UI.'");
			// assert DeployDetailsTextSub1.contains("To have a very smooth configuration we
			// strongly recommend BuildPiper UI.");
			ui_IsElementDisplay(ui_waitForElementToDisplay(deployDetailsTextSub2, Pause.MEDIUM));
			String DeployDetailsTextSub2 = deployDetailsTextSub2.getText();
			softAssert.assertTrue(DeployDetailsTextSub2.contains("Custom Manifest file/GitOps: "),
					"Unable to validate 'Custom Manifest file/GitOps: '");
			// assert DeployDetailsTextSub2.contains("Custom Manifest file/GitOps: ");
			softAssert.assertTrue(
					DeployDetailsTextSub2
							.contains("you can also configure the CD by uploading your custom manifest file."),
					"Unable to validate 'you can also configure the CD by uploading your custom manifest file.'");
			// assert DeployDetailsTextSub2.contains("you can also configure the CD by
			// uploading your custom manifest file.");

			////////////////// Validate Integration Details Empty ///////////////////

//			ui_IsElementDisplay(ui_waitForElementToDisplay(validateIntegrationDetails, Pause.MEDIUM));
//			ui_click(validateIntegrationDetails, "Poc_QA validateIntegrationDetails");
//			ui_IsElementDisplay(ui_waitForElementToDisplay(integrationText1, Pause.MEDIUM));
//			ui_IsElementDisplay(ui_waitForElementToDisplay(integrationText2, Pause.MEDIUM));
//			ui_IsElementDisplay(ui_waitForElementToDisplay(integrationText3, Pause.MEDIUM));
//
//			////////////////// Validate Other Deployment Details Empty ///////////////////
//
//			ui_IsElementDisplay(ui_waitForElementToDisplay(validateOtherDeploymentDetails, Pause.MEDIUM));
//			ui_click(validateOtherDeploymentDetails, "Poc_QA validateOtherDeploymentDetails");
//			ui_IsElementDisplay(ui_waitForElementToDisplay(otherDeploymentDetails1, Pause.MEDIUM));
//			ui_IsElementDisplay(ui_waitForElementToDisplay(otherDeploymentDetails2, Pause.MEDIUM));
//			ui_IsElementDisplay(ui_waitForElementToDisplay(otherDeploymentDetails3, Pause.MEDIUM));
//
//			////////////////// Validate Generated Manifest Details Empty ///////////////////
//
//			ui_IsElementDisplay(ui_waitForElementToDisplay(validateGeneratedManifest, Pause.MEDIUM));
//			ui_click(validateGeneratedManifest, "Poc_QA validateGeneratedManifest");
//			ui_IsElementDisplay(ui_waitForElementToDisplay(generatedManifestText, Pause.MEDIUM));
		}

		return this;

	}

//		ui_selectValueFromDropDownByXPath(pocQaDropdown, "Poc_QA");
//		ui_selectValueFromDropDownByXPath(preTestAppDropdown, "Pre_Test");
//        Select pocQaSelect = new Select(pocQaDropdown);
//        pocQaSelect.selectByVisibleText("Service Overview");
//        Select preTestAppSelect = new Select(preTestAppDropdown);
//        preTestAppSelect.selectByVisibleText("Service Overview");
//		ui_IsElementDisplay(ui_waitForElementToDisplay(preTestAppDropdown, Pause.MEDIUM));
//		ui_click(preTestAppDropdown, "Poc_QA project");
//		ui_click(serviceOverViewTab, "Poc_QA serviceOverView");
//		ui_click(addServiceBtn, "Poc_QA addServiceBtn");

	// Wait for the dropdown elements to be present and visible
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("poc-qa")));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pre-test-app")));

	// Select an option from the "poc-qa" dropdown
//        WebElement pocQaDropdown = driver.findElement(By.id("poc-qa"));

	// Select an option from the "pre-test-app" dropdown
//        WebElement preTestAppDropdown = driver.findElement(By.id("pre-test-app"));

	@FindBy(xpath = "//div[@class='input-component']//div[@class='error-message']")
	WebElement errorMessage;

	public ServiceCreationPage CreateSesrviceNegativeTest3(String appName, String ProjectName,
			String buildRadioButtonName, String existingServiceName) {

		boolean projectSelection = false;
		ui_wait(5);
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for (WebElement element : poc_qaProjectLink) {
			if (element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if (projectSelection) {
			ui_click(serviceOverViewTab, "Poc_QA serviceOverviewLink");
			ui_IsElementDisplay(ui_waitForElementToDisplay(addServiceBtn, Pause.MEDIUM));
			ui_click(addServiceBtn, "Poc_QA addServiceBtn");
			ui_IsElementDisplay(ui_waitForElementToDisplay(main_Heading, Pause.MEDIUM));
			String mainHeadingText = main_Heading.getText();
			///// Create Page Text Validations //////////////////////////
			Assert.assertEquals(mainHeadingText, "Benefits of creating Microservices",
					"Unable to validate 'Benefits of creating Microservices'");

			boolean muiTxtStatus = true;
			for (WebElement muicontainer : muiGridContainerText) {
				String muiText = muicontainer.getText();
				System.out.println(muiText);
				if (!(muiText.contains("Go Live with your App in just 24 hours")
						|| muiText.contains("Spin up new Environment in few clicks")
						|| muiText.contains("Onboard a Dockerized service in minutes")
						|| muiText.contains("Enable most robust & secure DevSecOps CI in few clicks")
						|| muiText.contains("Setup & Run hassle free secured Pipelines")
						|| muiText.contains("Speed, Security & Compliance together in one Platform")
						|| muiText.contains("Setup Observability tooling in just 5 mins"))) {
					muiTxtStatus = false;
					break;
				}
			}
			Assert.assertTrue(muiTxtStatus, "Unable to  valudate the MUI container Text on left side");

			String Text8 = createaServiceHeading.getText();
			Assert.assertEquals(Text8, "Create a New Service", "Unable to validate 'Create  new service label'");
			ui_IsElementDisplay(ui_waitForElementToDisplay(subHeading, Pause.MEDIUM));
			String Text9 = subHeading.getText();
			Assert.assertEquals(Text9, "Microservice are used to group pipeline and other setting together",
					"Unable to validate 'Microservice are used to group pipeline and other setting together'");

			ui_setvalue(service_Name_SearchBox, "sets service name", existingServiceName);
			ui_setvalue(external_Name_SearchBox, "sets external name", ExternalName);

			if (buildRadioButtonName.contains("Build once and promote")) {
				ui_click(buildForOnceBuild_Radiobtn, "Poc_QA selectOnceRadioBtn");

			} else {
				ui_click(buildForEveryBuild_Radiobtn, "Poc_QA selectEveryRadioBtn");
			}
			ui_click(saveAndContinue_Create_Page, "Poc_QA SubmitCreatePage");
			ui_IsElementDisplay(ui_waitForElementToDisplay(errorMessage, Pause.MEDIUM));
			Assert.assertEquals(errorMessage.getText().trim(), "component with this name already exists.",
					"Service already exists");

		}
		return this;
	}

	@FindBy(xpath = "//*[text()='Configure Build']")
	WebElement clickConfigBuild;

	@FindBy(xpath = "//div[@class='md-step-circle current']")
	WebElement currentStepCircle;

	@FindBy(xpath = "//h4[@class='mainHeading']")
	WebElement sourceDetailsHeading;

	@FindBy(xpath = "//*[text()='Please Select the Git URL']")
	WebElement sourceDetailsTitle1;

	@FindBy(xpath = "//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiAutocomplete-inputRoot MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-adornedEnd MuiOutlinedInput-adornedEnd']")
	WebElement gitUrlEnterDropdown;

	@FindBy(xpath = "//input[@name='git_url']")
	WebElement gitUrlInputField;

	@FindBy(xpath = "//ul[@id='git_url-popup']//li")
	List<WebElement> autoCompleteURLList;

	@FindBy(xpath = "//*[text()='Load Branches']")
	WebElement loadBranchesBtn;

	@FindBy(xpath = "//select[@name='branch_name']")
	WebElement selectBranchName;

	@FindBy(xpath = "//input[@name='file_paths']")
	WebElement fillFilePath;

	@FindBy(xpath = "//input[@name='file_paths_build_context']")
	WebElement fillDockerFilePath;

	@FindBy(xpath = "//input[@name='image_name']")
	WebElement enterImageName;

	@FindBy(xpath = "//*[text()='Advance Configurations']")
	WebElement sourceDetailsTitle2;

	@FindBy(xpath = "//span[@class='switch-handle']")
	WebElement advanceConfigSwitch;

	@FindBy(xpath = "//*[text()='Default Image is generated for AMD 64 Platform/OS']")
	WebElement sourceDetailsTitle3;

	@FindBy(xpath = "//input[@name='buildkit_enabled']/..//span[@class='switch-handle']")
	WebElement defaultImageSwitch;

	@FindBy(xpath = "//*[text()='Select Platforms']")
	WebElement sourceDetailsTitle4;

	@FindBy(xpath = "//*[text()='Please note we use ']")
	WebElement sourceDetailsTitle5;

	@FindBy(xpath = "//div[@class='input-component']//div[@class='input-chip-checkbox']//label")
	List<WebElement> selectChipType;

	@FindBy(xpath = "//*[text()='linux/amd64']")
	WebElement selectamd64;

	@FindBy(xpath = "//*[text()='linux/arm64']")
	WebElement selectarm64;

	@FindBy(xpath = "//button[text()='Continue' or text()='Submit']")
	WebElement clickContinueBtn;

	@FindBy(xpath = "//h4[@class='mainHeading']")
	WebElement ciDetailsHeading;

	@FindBy(xpath = "//div[@class='d-flex space-between']")
	WebElement ciDetailsSubHeading;

	@FindBy(xpath = "//input[@name='language'][@type='checkbox']")
	List<WebElement> selectLanguage;

	@FindBy(xpath = "//*[text()=' Publish CI Report to Sonar?']")
	WebElement ciDetailsSubHeading2;

	@FindBy(xpath = "//span[@class='switch-label'][@data-on]")
	WebElement sonarSwitch;

	@FindBy(xpath = "//*[text()='Project Key']")
	WebElement ciDetailsSubHeading3;

	@FindBy(xpath = "//input[@name='sonar_project_key']")
	WebElement sonarKeyEnter;

	@FindBy(xpath = "//h4[@class='mainHeading']")
	WebElement envHeading;

	@FindBy(xpath = "//*[text()='Build Env Details']")
	WebElement envSubHeading;

	@FindBy(xpath = "//span[@class='switch-label'][@data-on]")
	WebElement envDetailsSwitch;

	@FindBy(xpath = "//*[text()='Use Field view to manage small number of variables. Use Editor view in case you want to copy paste or manage large number of variables']")
	WebElement envDetailsDefText;

	@FindBy(xpath = "//input[@name='key']")
	WebElement envName;

	@FindBy(xpath = "//input[@name='value']")
	WebElement envValue;

	@FindBy(xpath = "//h4[@class='mainHeading']")
	WebElement hooksHeading;

	@FindBy(xpath = "//*[text()='Do you have build pre hooks?']")
	WebElement hooksSubHeading;

	@FindBy(xpath = "//*[text()='Do you have build post hooks?']")
	WebElement hooksSubHeading2;

	@FindBy(xpath = "//input[@name='pre_hook_enabled']/../span[@class='switch-handle']")
	WebElement preHooksSwitch;

	@FindBy(xpath = "//input[@name='post_hook_enabled']/../span[@class='switch-handle']")
	WebElement postHooksSwitch;

	@FindBy(xpath = "//p[contains(.,'Add Pre Hook')]/../../..//input[@placeholder='Run Command' and string-length(@value)=0]")
	WebElement preHooksPasswordBox;

	@FindBy(xpath = "//button[@class='nowrap']")
	WebElement addNewPreHook;

	@FindBy(xpath = "(//button[@class='nowrap'])[2]")
	WebElement addNewPostHook;

	@FindBy(xpath = "//p[contains(.,'Add Post Hook')]/../../..//input[@placeholder='Run Command' and string-length(@value)=0]")
	WebElement postHooksPasswordBox;

	@FindBy(xpath = "//button[@class='btn btn-submit']")
	WebElement submitHooks;

	@FindBy(xpath = "//*[text()='Repository Details']")
	WebElement repoDetails;

	@FindBy(xpath = "//button[@title='Clear']")
	WebElement clearClickGitDropDown;

	@FindBy(xpath = "//a[@class='btn btn-submit' ][contains(@href,'/manifest/add')]")
	WebElement buildPiperCustomManifest;

	@FindBy(xpath = "//input[@name='deployment_name' and @placeholder='service-env-master-project-env']")
	WebElement actualDeploymentName;

	@FindBy(xpath = "//input[@name='service_name' and @placeholder='service-envmaster-project-env']")
	WebElement actualServiceName;

	@FindBy(xpath = "//input[@name='image_name' and @placeholder='service-test/env-master-test/project-env-test']")
	WebElement actualImageName;

	@FindBy(xpath = "//input[@class='switch-input' and @name='deploy_variable_raw_input']/..//span[@class='switch-label']")
	WebElement rawKeyValuePairSwitch;

	@FindBy(xpath = "//input[@name='env_key' and @placeholder='Name']")
	WebElement keyInputField;

	@FindBy(xpath = "//input[@name='env_value' and @placeholder='Value']")
	WebElement valueInputField;

	@FindBy(xpath = "//button[@class='transparent-btn nowrap' ][text()=' Add Row']")
	WebElement addRowButton;

	@FindBy(xpath = "//input[@name='env_key' and @placeholder='Name' and @value[not(string())]]")
	WebElement keyInputField2;

	@FindBy(xpath = "//input[@name='env_value' and @placeholder='Value' and @value[not(string())]]")
	WebElement valueInputField2;

	@FindBy(xpath = "//div[contains(@class,'MuiFormGroup-row') and @role='radiogroup']//input[@name='option' and @value='MANIFEST_HELM']")
	WebElement helmUploadType;

	@FindBy(xpath = "//input[@name='file_paths' and @placeholder='/xyz/abc.yaml']")
	WebElement fileFolderPathInput;

	@FindBy(xpath = "//input[@name='helm_release_name' and @placeholder='Enter Helm Release name']")
	WebElement hemReleaseNameInput;

	@FindBy(xpath = "//div[contains(@class,'MuiFormGroup-row') and @role='radiogroup']//span[text()='Via Git Repo']")
	WebElement valueFileUpload;

	@FindBy(xpath = "//div[@class='value-files']//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiAutocomplete-inputRoot MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-adornedEnd MuiOutlinedInput-adornedEnd']")
	WebElement valueFieldGitDropdown;

	@FindBy(xpath = "//div[@class='value-files']//button[@title='Clear']")
	WebElement clearClickValueGitDropDown;

	@FindBy(xpath = "//div[@class='value-files']//input[@name='git_url']")
	WebElement valueGitUrlInputField;

//	@FindBy(xpath = "//input[@id='git_url']")
//	List<WebElement> autoCompleteURLList1;

//	@FindBy(xpath = "//div[@class='value-files']//input[@id='git_url']")
//	List<WebElement> autoCompleteValueURLList;

	@FindBy(xpath = "//div[@class='value-files']//input[@name='file_paths' and @placeholder='/xyz/abc.yaml']")
	WebElement fileFolderValuePathInput;

	@FindBy(xpath = "//button[@class='btn btn-submit' and text()='Save & Continue']")
	WebElement saveAndContinueBtn;

	@FindBy(xpath = "//div[@class='value-files']//*[text()='Load Branches']")
	WebElement loadValueBranchesBtn;

	@FindBy(xpath = "//div[@class='value-files']//select[@name='branch_name']")
	WebElement selectValueBranchName;

	public ServiceCreationPage CreateHelmNewService(String appName, String ProjectName, String buildRadioButtonName,
			ArrayList<String> UserRoles, String JobTemplateValue, String gitURL, String BranchName, String FilePath,
			String DockerFilePath, ArrayList<String> LanguageName, String preHookPass, String EnvName, String helmKey1,
			String helmValue1, String helmKey2, String helmValue2, String helmKey3, String helmValue3,
			String UploadTypeName, String BranchName1, String folderPath, String helmReleaseName,
			String folderPathValue) {

		boolean projectSelection = false;
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for (WebElement element : poc_qaProjectLink) {
			if (element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if (projectSelection) {
			ui_click(serviceOverViewTab, "Poc_QA serviceOverviewLink");
			ui_IsElementDisplay(ui_waitForElementToDisplay(addServiceBtn, Pause.MEDIUM));
			ui_click(addServiceBtn, "Poc_QA addServiceBtn");
			ui_IsElementDisplay(ui_waitForElementToDisplay(main_Heading, Pause.MEDIUM));
			servicename=ServiceHelmName;
			ui_setvalue(service_Name_SearchBox, "sets service name", ServiceHelmName);
			ui_setvalue(external_Name_SearchBox, "sets external name", ExternalHelmName);

			if (buildRadioButtonName.contains("Build once and promote")) {
				ui_click(buildForOnceBuild_Radiobtn, "Poc_QA selectOnceRadioBtn");

			} else {
				ui_click(buildForEveryBuild_Radiobtn, "Poc_QA selectEveryRadioBtn");
			}
			ui_click(saveAndContinue_Create_Page, "Poc_QA SubmitCreatePage");

			////////////// Create a Service Environment ////////////////////////

			ui_IsElementDisplay(ui_waitForElementToDisplay(environmentHeader, Pause.LOW));
			ui_IsElementDisplay(ui_waitForElementToDisplay(envDropdown, Pause.LOW));
			Select dropdown = new Select(envDropdown);
			dropdown.selectByVisibleText(ProjectName);
			// ui_wait(3);

			if (allowManualBuildYes.getAttribute("value").equals("false"))
				ui_click(allowManualBuildYes, "Poc_QA allowManualBuildYes");
			if (allowManualDeployYes.getAttribute("value").equals("false"))
				ui_click(allowManualDeployYes, "Poc_QA allowManualDeployYes");

			ui_selectValueFromDropDownByXPath(jobTemplateDropdown, "jobTemplateDropdown");
			Select jobdropdown = new Select(jobTemplateDropdown);
			jobdropdown.selectByVisibleText(JobTemplateValue);

			for (int i = 0; i < roleGroupCheckbox.size(); i++) {
				if (UserRoles.contains(roleGroupCheckbox.get(i).getAttribute("value").trim())) {
					roleGroupCheckbox.get(i).click();
				}
			}
			if (allowManualBuildYes.getAttribute("value").equals("false"))
				ui_click(selectJobTemplateRadioBtn, "Poc_QA selectJobTemplateRadioBtn");
			ui_IsElementDisplay(ui_waitForElementToDisplay(saveAndContinue_Create_Page, Pause.LOW));
			ui_click(saveAndContinue_Create_Page, "Poc_QA SubmitEnvPage");
			// ui_wait(5);
			ui_IsElementDisplay(ui_waitForElementToDisplay(clickConfigBuild, Pause.MEDIUM));
			ui_click(clickConfigBuild, "Poc_QA clickConfigBuild");

			/////////// Source Details Fill ////////////////////////////
			ui_wait(3);

			ui_IsElementDisplay(ui_waitForElementToDisplay(currentStepCircle, Pause.MEDIUM));
			ui_IsElementDisplay(ui_waitForElementToDisplay(gitUrlEnterDropdown, Pause.MEDIUM));
			ui_click(gitUrlInputField, "Poc_QA gitUrlInputField");
			ui_wait(5);

			ui_click(clearClickGitDropDown, "ClicksclearField");

			ui_clearAndSetValue(gitUrlInputField, gitURL);
			ui_wait(2);
			ui_clickfromList(autoCompleteURLList, gitURL);
			ui_wait(5);

			ui_IsElementDisplay(ui_waitForElementToDisplay(loadBranchesBtn, Pause.MEDIUM));
			ui_click(loadBranchesBtn, "Poc_QA loadBranchesBtn");
			ui_wait(10);
			ui_IsElementDisplay(ui_waitForElementToDisplay(selectBranchName, Pause.MEDIUM));
			ui_selectValueFromDropDownByXPath(selectBranchName, "Selects Branch Name");
			Select dropdown1 = new Select(selectBranchName);
			dropdown1.selectByVisibleText(BranchName);
			ui_wait(3);
			ui_clearAndSetValue(fillFilePath, FilePath);
			ui_clearAndSetValue(fillDockerFilePath, DockerFilePath);
			ui_IsElementDisplay(ui_waitForElementToDisplay(sourceDetailsTitle2, Pause.MEDIUM));
			ui_wait(5);
			ui_click(clickContinueBtn, "Poc_QA clickContinueBtn");
			ui_wait(5);
/*
			/////////// CI Details Fill ////////////////////////////

			ui_IsElementDisplay(ui_waitForElementToDisplay(ciDetailsHeading, Pause.MEDIUM));

			for (int i = 0; i < selectLanguage.size(); i++) {
				System.out.println(selectLanguage.get(i).getAttribute("value").trim());
				if (LanguageName.contains(selectLanguage.get(i).getAttribute("value").trim())) {

					selectLanguage.get(i).click();
				}
			}
            ui_wait(4);
			ui_click(clickContinueBtn, "Poc_QA clickContinueBtn");
*/
			/////////// ENV Details Fill ////////////////////////////

			ui_IsElementDisplay(ui_waitForElementToDisplay(envHeading, Pause.MEDIUM));
			ui_IsElementDisplay(ui_waitForElementToDisplay(envSubHeading, Pause.MEDIUM));
			ui_click(envDetailsSwitch, "Poc_QA envDetailsSwitch");
			ui_setvalue(envName, "Poc_QA envName", "QA");
			ui_setvalue(envValue, "Poc_QA envValue", "UAT-QA");
			ui_wait(5);
			ui_click(clickContinueBtn, "Poc_QA clickContinueBtn");

			/////////// HOOKS Details Fill ////////////////////////////
			
			//ui_IsElementDisplay(ui_waitForElementToDisplay(hooksHeading, Pause.MEDIUM));
			//Assert.assertEquals(hooksHeading, "Hooks Details");
			//ui_IsElementDisplay(ui_waitForElementToDisplay(hooksSubHeading, Pause.MEDIUM));
			//Assert.assertEquals(hooksSubHeading, "Hooks Details");
			//ui_IsElementDisplay(ui_waitForElementToDisplay(hooksSubHeading2, Pause.MEDIUM));
			ui_click(preHooksSwitch, "Poc_QA preHooksSwitch");
			ui_setvalue(preHooksPasswordBox, "Poc_QA preHooksPasswordBox1", preHookPass);
			
			ui_click(addNewPreHook, "clicks on add New Hook");
			ui_setvalue(preHooksPasswordBox, "Poc_QA preHooksPasswordBox2", preHookPass);
			
			ui_click(postHooksSwitch, "Poc_QA postHooksSwitch");
			//ui_IsElementDisplay(ui_waitForElementToDisplay(postHooksPasswordBox, Pause.MEDIUM));
			ui_setvalue(postHooksPasswordBox, "Poc_QA postHooksPasswordBox1", preHookPass);

			ui_click(addNewPostHook, "clicks on add New Post Hook");
			ui_setvalue(postHooksPasswordBox, "Poc_QA postHooksPasswordBox2", preHookPass);
			
			ui_click(submitHooks, "Poc_QA submitHooks");
			
			
			ui_IsElementDisplay(ui_waitForElementToDisplay(validateDeployDetails, Pause.MEDIUM));
			ui_click(validateDeployDetails, "Poc_QA validateDeployDetails");
			ui_IsElementDisplay(ui_waitForElementToDisplay(buildPiperCustomManifest, Pause.MEDIUM));
			ui_click(buildPiperCustomManifest, "clicks on custom manifest button under deploy details");
			String expDeploymentName = ServiceHelmName + "-" + "dev" + "-" + ProjectName;
			Assert.assertEquals(actualDeploymentName.getAttribute("value").trim(), expDeploymentName,
					"Validating expeceted and actual deployment name");
			Assert.assertEquals(actualServiceName.getAttribute("value").trim(), expDeploymentName,
					"Validating expeceted and actual service name");
			String expImageName = ServiceHelmName + "/" + "dev" + "/" + ProjectName;
			Assert.assertEquals(actualImageName.getAttribute("value").trim(), expImageName,
					"Validating expeceted and actual image name");
			
			Select imagepule=new Select(imagePullPolicy);
			imagepule.selectByValue("Always");	
			ui_IsElementDisplay(ui_waitForElementToDisplay(rawKeyValuePairSwitch, Pause.MEDIUM));
			ui_click(rawKeyValuePairSwitch, "clicks on switch handle for raw key value pairs");
			ui_clearAndSetValue(keyInputField, helmKey1);
			ui_clearAndSetValue(valueInputField, helmValue1);
			ui_IsElementDisplay(ui_waitForElementToDisplay(addRowButton, Pause.MEDIUM));
			ui_click(addRowButton, "clicks on add row button for key value pairs");
			ui_clearAndSetValue(keyInputField2, helmKey2);
			ui_clearAndSetValue(valueInputField2, helmValue2);
			ui_click(addRowButton, "clicks on add row button for key value pairs");
			ui_clearAndSetValue(keyInputField2, helmKey3);
			ui_clearAndSetValue(valueInputField2, helmValue3);
			ui_IsElementDisplay(ui_waitForElementToDisplay(helmUploadType, Pause.MEDIUM));
			ui_click(helmUploadType, "clicks on upload type");
			ui_IsElementDisplay(ui_waitForElementToDisplay(gitUrlEnterDropdown, Pause.MEDIUM));
			ui_click(gitUrlInputField, "Poc_QA gitUrlInputField");
			ui_wait(5);

			ui_click(clearClickGitDropDown, "ClicksclearField");

			ui_clearAndSetValue(gitUrlInputField, gitURL);
			ui_wait(2);
			ui_clickfromList(autoCompleteURLList, gitURL);
			ui_wait(5);

			ui_IsElementDisplay(ui_waitForElementToDisplay(loadBranchesBtn, Pause.MEDIUM));
			ui_click(loadBranchesBtn, "Poc_QA loadBranchesBtn");
			ui_wait(10);
			ui_IsElementDisplay(ui_waitForElementToDisplay(selectBranchName, Pause.MEDIUM));
			ui_selectValueFromDropDownByXPath(selectBranchName, "Selects Branch Name");
			Select dropdownBranch = new Select(selectBranchName);
			dropdownBranch.selectByVisibleText(BranchName1);
			ui_wait(3);
			ui_IsElementDisplay(ui_waitForElementToDisplay(fileFolderPathInput, Pause.MEDIUM));
			ui_clearAndSetValue(fileFolderPathInput, folderPath);
			ui_IsElementDisplay(ui_waitForElementToDisplay(hemReleaseNameInput, Pause.MEDIUM));
			ui_clearAndSetValue(hemReleaseNameInput, helmReleaseName);
			ui_IsElementDisplay(ui_waitForElementToDisplay(valueFileUpload, Pause.MEDIUM));
			ui_click(valueFileUpload, "clicks value file option");

			ui_IsElementDisplay(ui_waitForElementToDisplay(valueFieldGitDropdown, Pause.MEDIUM));
			ui_click(valueFieldGitDropdown, "value Field Git Dropdown");
			ui_wait(5);

			ui_click(clearClickValueGitDropDown, "ClicksclearField");

			ui_clearAndSetValue(valueGitUrlInputField, gitURL);
			ui_wait(2);
			ui_clickfromList(autoCompleteURLList, gitURL);
			ui_wait(5);

			ui_IsElementDisplay(ui_waitForElementToDisplay(loadValueBranchesBtn, Pause.MEDIUM));
			ui_click(loadValueBranchesBtn, "Poc_QA loadBranchesBtn");
			ui_wait(10);
			ui_IsElementDisplay(ui_waitForElementToDisplay(selectValueBranchName, Pause.MEDIUM));
			ui_selectValueFromDropDownByXPath(selectValueBranchName, "Selects Branch Name");
			Select dropdownBranch1 = new Select(selectValueBranchName);
			dropdownBranch1.selectByVisibleText(BranchName1);
			ui_wait(3);
			ui_IsElementDisplay(ui_waitForElementToDisplay(fileFolderValuePathInput, Pause.MEDIUM));
			ui_clearAndSetValue(fileFolderValuePathInput, folderPathValue);
			ui_IsElementDisplay(ui_waitForElementToDisplay(saveAndContinueBtn, Pause.MEDIUM));
			ui_click(saveAndContinueBtn, "save And Continue Btn");
		}
		return this;
	}

	public ServiceCreationPage CreateBuildXService(String appName, String ProjectName, String buildRadioButtonName,
			ArrayList<String> UserRoles, String JobTemplateValue) {

		boolean projectSelection = false;
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for (WebElement element : poc_qaProjectLink) {
			if (element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if (projectSelection) {
			ui_click(serviceOverViewTab, "Poc_QA serviceOverviewLink");
			ui_IsElementDisplay(ui_waitForElementToDisplay(addServiceBtn, Pause.MEDIUM));
			ui_click(addServiceBtn, "Poc_QA addServiceBtn");

		}
		return this;

	}

	@FindBy(xpath = "//a[text()='Add Environment']")
	WebElement addNewEnvToRunningService;

	@FindBy(xpath = "//span[@class='badge badge-dev']")
	WebElement devEnvBadge;

	@FindBy(xpath = "//label//..//..//..//select")
	WebElement selectEnvDrop;

	@FindBy(xpath = "//div[@class='input-component']//label")
	WebElement cloneFromEnvValidateTxt;

	@FindBy(xpath = "//button[@class='btn btn-primary' and text()=' Next ']")
	WebElement nextBtn;

	@FindBy(xpath = "//button[@class='btn btn-submit']")
	WebElement buildPiperUIDeployConfigBtn;

//	@FindBy(xpath = "//button[@class='btn btn-submit']")
//	WebElement continueBtn;

	@FindBy(xpath = "//button[@class='btn btn-submit']")
	WebElement continueBtn;

	@FindBy(xpath = "//input[@placeholder='Image Name']")
	WebElement accessLevelImageName;

	@FindBy(xpath = "//span//input[@type='radio' and @value='PRIVATE']")
	WebElement privateAccess;

	@FindBy(xpath = "//span//input[@type='radio' and @value='PUBLIC']")
	WebElement publicAccess;

	@FindBy(xpath = "//span//input[@type='radio' and @value='PROTECTED']")
	WebElement protectedAccess;

	@FindBy(xpath = "//button//span[text()=' Add Access Level']")
	WebElement addAcessLevel;

	@FindBy(xpath = "//input[@placeholder='name'][@name='name']")
	WebElement accessName;

	@FindBy(xpath = "//input[@placeholder='4001'][@name='port']")
	WebElement port;

	@FindBy(xpath = "//input[@placeholder='4001'][@name='target_port']")
	WebElement targetPort;

	@FindBy(xpath = "//button[@class='btn btn-v2-primary btn-sm']")
	WebElement addAccessBtn;
	
	@FindBy(xpath = "//select[@name='image_pull_policy']")
	WebElement imagePullPolicy;

	public ServiceCreationPage addNewEnvironmentToService(String ProjectName, ArrayList<String> UserRoles,
			String JobTemplateValue, String cloneText, String envCloneValue, String BranchName,String AccessType, String AccessName,
			String portNumber, String TargetPort) {

		ui_click(addNewEnvToRunningService, "adds new environment to running service");
		ui_IsElementDisplay(ui_waitForElementToDisplay(environmentHeader, Pause.LOW));
		String Text10 = environmentHeader.getText();
		Assert.assertEquals(Text10, "Create a Environment", "Unable to validate 'Create a Environment'");
		ui_IsElementDisplay(ui_waitForElementToDisplay(environmentSubHeader, Pause.MEDIUM));
		String Text11 = environmentSubHeader.getText();
		Assert.assertTrue(Text11.contains(
				"A Environment aims to mitigate such scenarios by encouraging automation and documentation, there by increasing communication. In this environment, every release is committed in an automated fashion, enabling the rapid building, testing and deployment of every project."),
				"Unable to validate 'A Environment aims to mitigate such scenarios by encouraging automation and documentation, there by increasing communication. In this environment, every release is committed in an automated fashion, enabling the rapid building, testing and deployment of every project.'");
		Assert.assertTrue(Text11.contains("To learn more about how to setup a Microservice please read"),
				"Unable to validate 'To learn more about how to setup a Microservice please read'");
		ui_IsElementDisplay(ui_waitForElementToDisplay(envDropdown, Pause.LOW));
		Select dropdown = new Select(envDropdown);
		dropdown.selectByVisibleText(ProjectName);
		// ui_wait(3);

		if (allowManualBuildYes.getAttribute("value").equals("false"))
			ui_click(allowManualBuildYes, "Poc_QA allowManualBuildYes");
		if (allowManualDeployYes.getAttribute("value").equals("false"))
			ui_click(allowManualDeployYes, "Poc_QA allowManualDeployYes");

//		String UserRoleGroupText = userRoleGroupText.getText();
//		softAssert.assertEquals(UserRoleGroupText,
//				"Users in the selected roles will have access to the Environment & Microservices above. To learn more about user access roles and groups read the",
//				"Unable to validate 'Users in the selected roles will have access to the Environment & Microservices above. To learn more about user access roles and groups read the'");
//		ui_selectValueFromDropDownByXPath(jobTemplateDropdown, "jobTemplateDropdown");
		ui_wait(3);
		ui_IsElementDisplay(ui_waitForElementToDisplay(jobTemplateDropdown, Pause.LOW));
		Select jobdropdown = new Select(jobTemplateDropdown);
		jobdropdown.selectByVisibleText(JobTemplateValue);

		for (int i = 0; i < roleGroupCheckbox.size(); i++) {
			if (UserRoles.contains(roleGroupCheckbox.get(i).getAttribute("value").trim())) {
				roleGroupCheckbox.get(i).click();
			}
		}
		if (allowManualBuildYes.getAttribute("value").equals("false"))
			ui_click(selectJobTemplateRadioBtn, "Poc_QA selectJobTemplateRadioBtn");
		ui_IsElementDisplay(ui_waitForElementToDisplay(saveAndContinue_Create_Page, Pause.LOW));
		ui_click(saveAndContinue_Create_Page, "Poc_QA SubmitEnvPage");
		ui_IsElementDisplay(ui_waitForElementToDisplay(devEnvBadge, Pause.LOW));
//		ui_click(devEnvBadge, "dev environment badge");
		ui_IsElementDisplay(ui_waitForElementToDisplay(clickConfigBuild, Pause.MEDIUM));
		ui_getUIDriver().navigate().refresh();
		ui_IsElementDisplay(ui_waitForElementToDisplay(clickConfigBuild, Pause.MEDIUM));
		ui_click(clickConfigBuild, "Poc_QA clickConfigBuild");
		ui_wait(3);
		ui_IsElementDisplay(ui_waitForElementToDisplay(cloneFromEnvValidateTxt, Pause.MEDIUM));
		Assert.assertEquals(cloneFromEnvValidateTxt.getText().trim(), cloneText, "cloning text validated");
		ui_selectValueFromDropDownByXPath(selectEnvDrop, "selectEnvDrop");
		Select envDrop = new Select(selectEnvDrop);
		envDrop.selectByVisibleText(envCloneValue);
		ui_wait(4);
		ui_click(nextBtn, "user clicks next button");
		ui_wait(4);
		//ui_getUIDriver().navigate().refresh();
		//ui_wait(4);
		ui_IsElementDisplay(ui_waitForElementToDisplay(loadBranchesBtn, Pause.MEDIUM));
		ui_click(loadBranchesBtn, "Poc_QA loadBranchesBtn");
		ui_wait(5);
		ui_selectValueFromDropDownByXPath(selectBranchName, "Selects Branch Name");
		Select dropdown2 = new Select(selectBranchName);
		dropdown2.selectByVisibleText(BranchName);
		ui_wait(4);
		ui_click(clickContinueBtn, "Poc_QA clickContinueBtn");
		ui_wait(5);
		ui_click(clickContinueBtn, "Poc_QA clickContinueBtn");
		ui_wait(3);
		ui_click(clickContinueBtn, "Poc_QA clickContinueBtn");
		//ui_click(submitHooks, "Poc_QA submitHooks");
		ui_IsElementDisplay(ui_waitForElementToDisplay(validateDeployDetails, Pause.MEDIUM));
		ui_click(validateDeployDetails, "Poc_QA validateDeployDetails");
		ui_IsElementDisplay(ui_waitForElementToDisplay(buildPiperUIDeployConfigBtn, Pause.MEDIUM));
		ui_click(buildPiperUIDeployConfigBtn, "clicks on buildPiperUI button");
		ui_wait(3);
		ui_IsElementDisplay(ui_waitForElementToDisplay(selectEnvDrop, Pause.MEDIUM));
		ui_selectValueFromDropDownByXPath(selectEnvDrop, "selectEnvDrop");
		Select envDrop1 = new Select(selectEnvDrop);
		envDrop1.selectByVisibleText(envCloneValue);
		ui_click(nextBtn, "user clicks next button");
		ui_click(addAcessLevel, "Add Access Level");
		ui_wait(2);

		if (AccessType.contains("PRIVATE")) {
			ui_click(privateAccess, "Poc_QA privateAccess");

		} else if (AccessType.contains("PUBLIC")) {

			ui_click(publicAccess, "Poc_QA publicAccess");

		} else {

			ui_click(protectedAccess, "Poc_QA protectedAccess");

		}
		ui_clearAndSetValue(accessName, AccessName);
		ui_clearAndSetValue(port, portNumber);
		ui_clearAndSetValue(targetPort, TargetPort);
		ui_click(addAccessBtn, "clicks add button");
		ui_wait(2);
		Select imagepule=new Select(imagePullPolicy);
		imagepule.selectByValue("Always");
		ui_click(continueBtn, "clicks continue button");
		ui_wait(2);
		ui_click(continueBtn, "clicks continue button");
		ui_wait(2);
//		ui_click(addConfigToDeploy, "switches config maps add to yes");
//		Select dropdown = new Select(selectDropDownConfigNames);
//		dropdown.selectByVisibleText(configName);
		ui_click(continueBtn, "clicks continue button");
		ui_wait(2);
		ui_click(continueBtn, "clicks continue button");
		ui_wait(2);
		ui_click(continueBtn, "clicks continue button");
		ui_wait(2);
		ui_click(continueBtn, "clicks continue button");
		ui_wait(2);
		ui_click(continueBtn, "clicks continue button");
		ui_wait(2);
		ui_click(continueBtn, "clicks continue button");
		ui_wait(2);
		ui_click(continueBtn, "clicks continue button");
		ui_wait(2);

		return this;
	}
	
	@FindBy(xpath = "//button[@title='Build']")
	WebElement buildButton;
	
	@FindBy(xpath = "//button[text()='Trigger Build']")
	WebElement triggerBuild;
	@FindBy(xpath = "//div[contains(@class,'popup-card mb')]//button[@class='btn-round border-navy bg-clear-btn']")
	WebElement refreshBuildandDeploybutton;
		
	@FindBy(xpath = "//button[contains(text(),'Trigger Build & Deploy')]")
	WebElement triggerBuildAndDeploy;
	
	public ServiceCreationPage buildTrigger() {

		ui_click(buildButton, "clicks buildButton");
		ui_wait(5);
		ui_click(triggerBuild, "clicks triggerBuild");

		return this;
	}
	

	public ServiceCreationPage buildButton_Click() {

		ui_click(buildButton, "buildButton");
		ui_wait(1);
		if(ui_IsElementPresent(buildButton, "2")) {
			ui_click(buildButton, "buildButton");
		}

		return this;
	}
	public ServiceCreationPage triggerBuild_Click() {

		ui_click(triggerBuild, "triggerBuild");

		return this;
	}
    
	public ServiceCreationPage CacheCheckbox_Click() {

		ui_click(cacheToggle, "cacheToggle");

		return this;
	}
	
	public ServiceCreationPage RefreshBuildandDeploy_Click() {

		ui_click(refreshBuildandDeploybutton, "refresh BuildandDeploy button");

		return this;
	}
	public ServiceCreationPage TriggerBuildandDeploy_Click() {

		ui_click(triggerBuildAndDeploy, "trigger Build and Deploy button");

		return this;
	}
	@FindBy(xpath = "//button[@title='Clear']")
	WebElement clearbranch;
	@FindBy(xpath = "//input[@name='branch_name']")
	WebElement branchInput;
	@FindBy(xpath = "//ul[@id='branch_name-popup']//li")
	List<WebElement> branchList;
	public ServiceCreationPage SelectBranch(String branch) {
		
		ui_click(branchInput, "branchInput");
		ui_wait(2);
		ui_click(clearbranch, "clear branch");
		ui_wait(2);
		ui_clearAndSetValue(branchInput, branch);
		ui_wait(2);
		ui_clickfromList(branchList, branch);
		ui_wait(5);
		return this;
	}
	
	@FindBy(xpath = "//div[contains(@class,'service-lising-detailed-card card')]//button[@class='btn-round border-navy bg-clear-btn']")
	WebElement refreshService;
	public ServiceCreationPage RefreshService_Click() {
		
		ui_click(refreshService, "refresh BuildandDeploy button");
		
		return this;
	}
	
	//RK
	@FindBy(xpath = "//span[contains(text(),'Please note You are building image in Env.')]/following-sibling::span[1]")
	WebElement environmentCheck;
	@FindBy(xpath = "//span[contains(text(),'Sub Env:')]/span")
	WebElement subEnvironmentCheck;
	@FindBy(xpath = "//input[@placeholder='Name']")
	WebElement searchServiceTextBox;
	
	public ServiceCreationPage Verify_EnvironmentandSubEnvironment(String Env,String SubEnv) {
	ui_wait(4);
	ui_IsElementDisplay(ui_waitForElementToDisplay(environmentCheck, Pause.MEDIUM));
    String Environment=environmentCheck.getText();
    String SubEnvironment=subEnvironmentCheck.getText();
    assertEquals(Environment, Env);
    assertEquals(SubEnvironment, SubEnv);
	return this;
	}
	public ServiceCreationPage SearchServiceViaRandomStringValue(String appName,String Servicename) {
		boolean projectSelection = false;
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for (WebElement element : poc_qaProjectLink) {
			if (element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if (projectSelection) {
			ui_IsElementDisplay(ui_waitForElementToDisplay(serviceOverViewTab, Pause.MEDIUM));
			ui_ActionMoveAndClick(serviceOverViewTab, "serviceOverViewTab");
			ui_wait(10);
		//Search with RandomString
		ui_IsElementDisplay(ui_waitForElementToDisplay(searchServiceTextBox, Pause.MEDIUM));
		ui_click(searchServiceTextBox, "clicks on environment overview tab under applicartion name");
		ui_clearAndSetValue(searchServiceTextBox, Servicename);
		searchServiceTextBox.sendKeys(Keys.ENTER);
		ui_wait(3);
		Assert.assertEquals(serviceList.get(0).getText(), Servicename.toUpperCase());
		}
		return this;
	}
	
	public ServiceCreationPage switchEnvironmentTab(String Environment) {
    WebElement Tab=ui_getUIDriver().findElement(By.xpath("//span[text()='"+Environment+"']/../span[2]/following-sibling::span"));
	ui_click(Tab, "Select Environment Tab");
	return this;
}
	public ServiceCreationPage switchServiceType(String ServiceType) {
		WebElement Tab=ui_getUIDriver().findElement(By.xpath("//ul[@class='headerul']/li[text()='"+ServiceType+"']"));
		ui_click(Tab, "Select ServiceType Tab");
		return this;
	}

	public ServiceCreationPage SearchServiceViaServiceName(String appName,String Servicename) {
		boolean projectSelection = false;
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for (WebElement element : poc_qaProjectLink) {
			if (element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if (projectSelection) {
			ui_wait(3);
			ui_IsElementDisplay(ui_waitForElementToDisplay(serviceOverViewTab, Pause.MEDIUM));
			ui_ActionMoveAndClick(serviceOverViewTab, "Poc_QA serviceOverviewLink");
			ui_wait(3);
		//Search with RandomString
		ui_IsElementDisplay(ui_waitForElementToDisplay(searchServiceTextBox, Pause.MEDIUM));
		ui_click(searchServiceTextBox, "clicks on environment overview tab under applicartion name");
		ui_clearAndSetValue(searchServiceTextBox, Servicename);
		searchServiceTextBox.sendKeys(Keys.ENTER);
		ui_wait(3);
		}
		return this;
	}
	
	@FindBy(xpath = "//*[text()='Other Deployment Info']")
	WebElement otherDeploymentInfo;
	@FindBy(xpath = "//div[@class='btn-group btn-icon-group ml-auto d-inline-block']/button[@class='btn btn-flaticon'][1]")
	WebElement uploadHPA;
	@FindBy(xpath = "//button[text()='Confirm']")
	WebElement confirmHPA;
	@FindBy(xpath = "//div[@class='card ']//div[1]/div/div/p[1]")
	WebElement confirmHPAMessage;
	@FindBy(xpath = "(//*[@class='msg-div']/span[2])[1]")
	WebElement generateManifestHPA_Status;
	@FindBy(xpath = "(//*[@class='msg-div']/span[2])[2]")
	WebElement loadKubeConfigHPA_Status;
	@FindBy(xpath = "(//*[@class='msg-div']/span[2])[3]")
	WebElement deployHPA_Status;	
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continuebutton;
	@FindBy(xpath = "//div[@class='btn-group btn-icon-group ml-auto d-inline-block']/button[@class='btn btn-flaticon'][2]")
	WebElement editHPA;
	@FindBy(xpath = "//div[@class='btn-group btn-icon-group ml-auto d-inline-block']/button[@class='MuiButtonBase-root MuiIconButton-root']")
	WebElement deleteHPA;
	@FindBy(xpath = "//*[text()='Add Time Based HPA']")
	WebElement addTimeBasedHPA;
	@FindBy(xpath = "//input[@placeholder='HPA Name']")
	WebElement inputHPAname;
	@FindBy(xpath = "//input[@name='minimum_replication']")
	WebElement inputMinimumReplication;
	@FindBy(xpath = "//input[@name='maximum_replication']")
	WebElement inputMaximumReplication;
	@FindBy(xpath = "(//input[@class='range-slider-input'])[1]")
	WebElement cpuThreshold;
	@FindBy(xpath = "(//input[@class='range-slider-input'])[2]")
	WebElement ramThreshold;
	@FindBy(xpath = "//*[text()='Save']")
	WebElement saveHPA;
	
	
	@FindBy(xpath = "//div[text()='Min Replication Count ']/following-sibling::div")
	WebElement minreplicationCount;
	@FindBy(xpath = "//div[text()='Max Replication Count ']/following-sibling::div")
	WebElement maxreplicationCount;
	@FindBy(xpath = "//div[text()='CPU Threshold ']/following-sibling::div")
	WebElement cpuThresholdCount;
	@FindBy(xpath = "//div[text()='Memory Threshold ']/following-sibling::div")
	WebElement memoryThresholdCount;
	@FindBy(xpath = "//p[text()='Status :']/span")
	WebElement otherDeploymentInfoStatus;
	@FindBy(xpath = "//button[text()='Add Default HPA']")
	WebElement addDefaultHPA;
	@FindBy(xpath = "(//button[@class='btn btn-with-icon btn-round']/span[@class='flaticon-refresh-button-1'])[2]")
	WebElement refreshHPA;
	
public ServiceCreationPage CreateHPA(String Servicename,String min,String max,String cpu,String memory) {
		
		ui_wait(3);
		ui_IsElementDisplay(ui_waitForElementToDisplay(validateDeployDetails, Pause.MEDIUM));
	    ui_click(validateDeployDetails, "validateDeployDetails");
	    ui_wait(2);
	    ui_click(otherDeploymentInfo, "otherDeploymentInfo");
	    ui_wait(3);
	    ui_IsElementDisplay(ui_waitForElementToDisplay(addDefaultHPA, Pause.MEDIUM));
	    ui_click(addDefaultHPA, "addDefaultHPA");
	    ui_IsElementDisplay(ui_waitForElementToDisplay(inputHPAname, Pause.MEDIUM));
	    ui_clearAndSetValue(inputHPAname,"HPA Test");
	    ui_wait(1);
	    ui_clearAndSetValue(inputMinimumReplication,min);
	    ui_wait(1);
	    ui_clearAndSetValue(inputMaximumReplication, max);
	    ui_wait(1);
	    ui_clearAndSetValue(cpuThreshold, cpu);
	    ui_wait(1);
	    ui_clearAndSetValue(ramThreshold, memory);
	    ui_wait(1);
	    ui_click(saveHPA, "saveHPA");
	    ui_wait(5);
	    ui_click(refreshHPA, "refreshHPA");
	    //--------------------Verify Values
	    Assert.assertEquals(min, minreplicationCount.getText());
	    Assert.assertEquals(max, maxreplicationCount.getText());
	    Assert.assertEquals(cpu, cpuThresholdCount.getText());
	    Assert.assertEquals(memory, memoryThresholdCount.getText());
	    Assert.assertEquals(otherDeploymentInfoStatus.getText(),"IN USE");
	    
	    //------------------Deploy HPA
		 ui_IsElementDisplay(ui_waitForElementToDisplay(uploadHPA, Pause.MEDIUM));
		 ui_click(uploadHPA, "uploadHPA");
		 ui_wait(2);
		 Assert.assertEquals(confirmHPAMessage.getText(), "Are you sure you want to switch new HPA");
		 ui_IsElementDisplay(ui_waitForElementToDisplay(confirmHPA, Pause.MEDIUM));
		 ui_click(confirmHPA, "ConfirmHPA");
		 ui_wait(15);
		 Assert.assertEquals(generateManifestHPA_Status.getText(), "Success");
		 Assert.assertEquals(loadKubeConfigHPA_Status.getText(), "Success");
		 Assert.assertEquals(deployHPA_Status.getText(), "Success");
		 ui_wait(2);
		 ui_click(continuebutton, "continuebutton");
		 ui_wait(3);
		return this;
	}
	
	public ServiceCreationPage VerifyOtherDeployDetailInfo(String Servicename,String min,String max,String cpu,String memory) {
		
		ui_click(serviceList.get(0), "Service Link");
		ui_wait(3);
		ui_IsElementDisplay(ui_waitForElementToDisplay(validateDeployDetails, Pause.MEDIUM));
	    ui_click(validateDeployDetails, "validateDeployDetails");
	    ui_wait(2);
	    ui_click(otherDeploymentInfo, "otherDeploymentInfo");
	    ui_wait(3);
	    ui_IsElementDisplay(ui_waitForElementToDisplay(editHPA, Pause.MEDIUM));
	    ui_click(editHPA, "editHPA");
	    ui_IsElementDisplay(ui_waitForElementToDisplay(inputHPAname, Pause.MEDIUM));
	    ui_clearAndSetValue(inputHPAname,"test");
	    ui_wait(1);
	    ui_clearAndSetValue(inputMinimumReplication,min);
	    ui_wait(1);
	    ui_clearAndSetValue(inputMaximumReplication, max);
	    ui_wait(1);
	    ui_clearAndSetValue(cpuThreshold, cpu);
	    ui_wait(1);
	    ui_clearAndSetValue(ramThreshold, memory);
	    ui_wait(1);
	    ui_click(saveHPA, "saveHPA");
	    ui_wait(4);
	    ui_click(refreshHPA, "refreshHPA");
	    
	    //--------------------Verify Values
	    Assert.assertEquals(min, minreplicationCount.getText());
	    Assert.assertEquals(max, maxreplicationCount.getText());
	    Assert.assertEquals(cpu, cpuThresholdCount.getText());
	    Assert.assertEquals(memory, memoryThresholdCount.getText());
	    Assert.assertEquals(otherDeploymentInfoStatus.getText(),"IN USE");
	    
	    //------------------Deploy HPA
		 ui_IsElementDisplay(ui_waitForElementToDisplay(uploadHPA, Pause.MEDIUM));
		 ui_click(uploadHPA, "uploadHPA");
		 ui_wait(2);
		 Assert.assertEquals(confirmHPAMessage.getText(), "Are you sure you want to switch new HPA");
		 ui_IsElementDisplay(ui_waitForElementToDisplay(confirmHPA, Pause.MEDIUM));
		 ui_click(confirmHPA, "ConfirmHPA");
		 ui_wait(20);
		 Assert.assertEquals(generateManifestHPA_Status.getText(), "Success");
		 Assert.assertEquals(loadKubeConfigHPA_Status.getText(), "Success");
		 Assert.assertEquals(deployHPA_Status.getText(), "Success");
		 ui_wait(2);
		 ui_click(continuebutton, "continuebutton");
		 ui_wait(3);
		//-----------------------Search Service--------
	    ui_IsElementDisplay(ui_waitForElementToDisplay(serviceOverViewTab, Pause.MEDIUM));
		ui_ActionMoveAndClick(serviceOverViewTab, "Poc_QA serviceOverviewLink");
		 ui_wait(1);
		ui_IsElementDisplay(ui_waitForElementToDisplay(searchServiceTextBox, Pause.MEDIUM));
		ui_click(searchServiceTextBox, "clicks on environment overview tab under applicartion name");
		ui_clearAndSetValue(searchServiceTextBox, Servicename);
		searchServiceTextBox.sendKeys(Keys.ENTER);
		return this;
	}
	@FindBy(xpath = "(//*[contains(text(),'Replication Status:')])[2]/following-sibling::p/span[text()='Min: ']/following-sibling::span")
	WebElement replicationStatusMin;
	@FindBy(xpath = "(//*[contains(text(),'Replication Status:')])[2]/following-sibling::p/span[text()='Max: ']/following-sibling::span")
	WebElement replicationStatusMax;
	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-edgeEnd']")
	WebElement monitorwindow_closeButton;
public ServiceCreationPage VerifyHPAMonitoring(String ReplicationStatusMin,String ReplicationStatusMax) {
	
		ui_wait(3);
		ui_IsElementDisplay(ui_waitForElementToDisplay(monitoring, Pause.MEDIUM));
		ui_click(monitoring, "monitoring");
		ui_wait(1);
		String min=replicationStatusMin.getText();
		String max=replicationStatusMax.getText();
		Assert.assertEquals(min, ReplicationStatusMin);
		Assert.assertEquals(max, ReplicationStatusMax);
		ui_wait(1);
		ui_click(monitorwindow_closeButton, "monitorwindow_closeButton");
		return this;
	}
	
	
	
	
	
	public ServiceCreationPage SearchServiceandValidate(String appName,String Servicename) {
		boolean projectSelection = false;
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for (WebElement element : poc_qaProjectLink) {
			if (element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if (projectSelection) {
			ui_IsElementDisplay(ui_waitForElementToDisplay(serviceOverViewTab, Pause.MEDIUM));
			ui_click(serviceOverViewTab, "Poc_QA serviceOverviewLink");
			ui_wait(3);
		//Search with RandomString
		ui_IsElementDisplay(ui_waitForElementToDisplay(searchServiceTextBox, Pause.MEDIUM));
		ui_click(searchServiceTextBox, "clicks on environment overview tab under applicartion name");
		ui_clearAndSetValue(searchServiceTextBox, Servicename);
		searchServiceTextBox.sendKeys(Keys.ENTER);
		ui_wait(3);
		Assert.assertEquals(serviceList.get(0).getText(), Servicename.toUpperCase());
		ui_IsElementDisplay(ui_waitForElementToDisplay(searchServiceTextBox, Pause.MEDIUM));
		ui_click(searchServiceTextBox, "clicks on environment overview tab under applicartion name");
		ui_clearAndSetValue(searchServiceTextBox, Servicename);
		searchServiceTextBox.sendKeys(Keys.ENTER);
		ui_wait(3);
		Assert.assertEquals(serviceList.get(0).getText(), Servicename.toUpperCase());
		//Health Check
		ui_click(statusCheck, "Click on statusCheck");
		ui_wait(5);
		Assert.assertEquals(healthStatus.getText(), "SUCCESS");	
		ui_wait(5);
		
		//Build UI Verify
		Assert.assertEquals(ui_IsElementDisplay(promotedOn), true);
		Assert.assertEquals(ui_IsElementDisplay(buildArtifact), true);
		Assert.assertEquals(ui_IsElementDisplay(commitID), true);
		Assert.assertEquals(ui_IsElementDisplay(commitMessage), true);
		Assert.assertEquals(ui_IsElementDisplay(promotedBy), true);
		
		//get the Value of Build Fields
		String BuildArtifact=buildArtifact.getText();
		String BuildcommitID=commitID.getText();
		String BuildcommitMessage=commitMessage.getText();
		String BuildBy=promotedBy.getText();	
		
		//get the Value of Deployed Fields
		String DeployNumber=deployNumber.getText();
		String DeployArtifact=deployArtifact.getText();
		String DeployManifestApplied=deployManifestApplied.getText();
		String DeployRollout=deployRollout.getText();
		String DeployOn=deployOn.getText();
		String DeployBy=deployBy.getText();
		
		
		//-----------------Service build deploy promote history monitoring icon 
		Assert.assertEquals(ui_IsElementDisplay(build), true);
		Assert.assertEquals(ui_IsElementDisplay(deploy), true);
		Assert.assertEquals(ui_IsElementDisplay(promote), true);
		Assert.assertEquals(ui_IsElementDisplay(history), true);
		Assert.assertEquals(ui_IsElementDisplay(monitoring), true);
			
		ui_click(history, "Click on History Icon");
		ui_wait(4);
		//-----Verify Build UI---
		Assert.assertEquals(history_buildType.getText(),"Build #1");
		Assert.assertEquals(history_buildStatus.getText(),"SUCCESS");
		Assert.assertEquals(BuildArtifact, history_buildArtifact.getText());
		Assert.assertEquals(BuildBy, history_buildby.getText());
		Assert.assertEquals(BuildcommitID, history_CommitID.getText());
		Assert.assertEquals(BuildcommitMessage, history_CommitMessage.getText());
		
		Assert.assertEquals(ui_IsElementDisplay(historyTag), true);
		Assert.assertEquals(ui_IsElementDisplay(historyCacheorNoCache), true);
		Assert.assertEquals(ui_IsElementDisplay(historyIsDeploy), true);
		Assert.assertEquals(ui_IsElementDisplay(historyCustomtag), true);
		Assert.assertEquals(ui_IsElementDisplay(historyBranchname), true);
		Assert.assertEquals(ui_IsElementDisplay(historyActivity_MasterCode), true);
		
		//-------------Search Artifact and Validate--
		String buildArtifacteValue=history_buildArtifact.getText();
		ui_click(searchArtifact, "clicks on searchArtifact");
		ui_clearAndSetValue(searchArtifact, history_buildArtifact.getText());
		ui_wait(2);
		searchArtifact.sendKeys(Keys.ENTER);
		ui_wait(3);
		Assert.assertEquals(history_buildArtifact.getText(), buildArtifacteValue);
		
		//------- switch to Deploy and Validate UI
		switchServiceType("Deploy");
		ui_wait(4);
		Assert.assertEquals(DeployNumber.contains(history_buildType.getText()),true);
		Assert.assertEquals(DeployManifestApplied, history_buildStatus.getText());
		Assert.assertEquals(DeployOn, history_buildDateandTime.getText());
		Assert.assertEquals(DeployArtifact, history_buildArtifact.getText());
		Assert.assertEquals(DeployBy, history_buildby.getText());
		
		Assert.assertEquals(ui_IsElementDisplay(historyTag), true);
		Assert.assertEquals(ui_IsElementDisplay(deployDryrun), true);
		Assert.assertEquals(ui_IsElementDisplay(deployComponentid), true);
		Assert.assertEquals(ui_IsElementDisplay(deploybyuser), true);
		Assert.assertEquals(ui_IsElementDisplay(deploymenttype), true);
		Assert.assertEquals(ui_IsElementDisplay(deploymentstatuscheck), true);
		
		//------- switch to Deploy and Validate UI-----
		switchServiceType("Promote");
		
		ui_wait(3);
		
		ui_click(historywindow_closeButton, "Click on historywindow_closeButton");
		
				
		//-----------------------------Swtich to QA Tab------------------------------------------------------
		switchEnvironmentTab("QA");
		ui_wait(4);
		
		//Build UI Verify
		Assert.assertEquals(ui_IsElementDisplay(promotedOn), true);
		Assert.assertEquals(ui_IsElementDisplay(buildArtifact), true);
		Assert.assertEquals(ui_IsElementDisplay(commitID), true);
		Assert.assertEquals(ui_IsElementDisplay(commitMessage), true);
		Assert.assertEquals(ui_IsElementDisplay(promotedBy), true);
		
		//get the Value of Build Fields
		String BuildArtifactQA=buildArtifact.getText();
		String BuildcommitIDQA=commitID.getText();
		String BuildcommitMessageQA=commitMessage.getText();
		String BuildByQA=promotedBy.getText();	
		
		//get the Value of Deployed Fields
		String DeployNumberQA=deployNumber.getText();
		String DeployArtifactQA=deployArtifact.getText();
		String DeployManifestAppliedQA=deployManifestApplied.getText();
		String DeployRolloutQA=deployRollout.getText();
		String DeployOnQA=deployOn.getText();
		String DeployByQA=deployBy.getText();
		
		
		//-----------------Service build deploy promote history monitoring icon 
		Assert.assertEquals(ui_IsElementDisplay(build), true);
		Assert.assertEquals(ui_IsElementDisplay(deploy), true);
		Assert.assertEquals(ui_IsElementDisplay(promote), true);
		Assert.assertEquals(ui_IsElementDisplay(history), true);
		Assert.assertEquals(ui_IsElementDisplay(monitoring), true);
				
		ui_click(history, "Click on History Icon");
		ui_wait(4);
		
		
		//-----Verify Build UI---
		Assert.assertEquals(history_buildType.getText(),"Build #1");
		Assert.assertEquals(history_buildStatus.getText(),"SUCCESS");
		Assert.assertEquals(BuildArtifactQA, history_buildArtifact.getText());
		Assert.assertEquals(BuildByQA, history_buildby.getText());
		Assert.assertEquals(BuildcommitIDQA, history_CommitID.getText());
		Assert.assertEquals(BuildcommitMessageQA, history_CommitMessage.getText());
		
		Assert.assertEquals(ui_IsElementDisplay(historyTag), true);
		Assert.assertEquals(ui_IsElementDisplay(historyCacheorNoCache), true);
		Assert.assertEquals(ui_IsElementDisplay(historyIsDeploy), true);
		Assert.assertEquals(ui_IsElementDisplay(historyCustomtag), true);
		Assert.assertEquals(ui_IsElementDisplay(historyBranchname), true);
		Assert.assertEquals(ui_IsElementDisplay(historyActivity_MasterCode), true);
		
		//-------------Search Artifact and Validate--
		String buildArtifacteValue1=history_buildArtifact.getText();
		ui_click(searchArtifact, "clicks on searchArtifact");
		ui_clearAndSetValue(searchArtifact, history_buildArtifact.getText());
		ui_wait(2);
		searchArtifact.sendKeys(Keys.ENTER);
		Assert.assertEquals(history_buildArtifact.getText(), buildArtifacteValue1);
		
		//------- switch to Deploy and Validate UI
		switchServiceType("Deploy");
		ui_wait(4);
		Assert.assertEquals(DeployNumberQA.contains(history_buildType.getText()),true);
		Assert.assertEquals(DeployManifestAppliedQA, history_buildStatus.getText());
		Assert.assertEquals(DeployOnQA, history_buildDateandTime.getText());
		Assert.assertEquals(DeployArtifactQA, history_buildArtifact.getText());
		Assert.assertEquals(DeployByQA, history_buildby.getText());
		
		Assert.assertEquals(ui_IsElementDisplay(historyTag), true);
		Assert.assertEquals(ui_IsElementDisplay(deployDryrun), true);
		Assert.assertEquals(ui_IsElementDisplay(deployComponentid), true);
		Assert.assertEquals(ui_IsElementDisplay(deploybyuser), true);
		Assert.assertEquals(ui_IsElementDisplay(deploymenttype), true);
		Assert.assertEquals(ui_IsElementDisplay(deploymentstatuscheck), true);
		
		//------- switch to Deploy and Validate UI-----
		switchServiceType("Promote");
		
		ui_wait(3);

		
		//-----------------------------Swtich to PROD Tab------------------------------------------------------
		switchEnvironmentTab("PROD");
		//Build UI Verify
		//Deploy UI Verify
		
		}
		return this;
		}
	
	@FindBy(xpath = "//div[contains(@class,'md-step-title-step')]")
	List<WebElement> logsTabs;
	public ServiceCreationPage SearchServiceandValidateUI(String appName,String Servicename,ArrayList<String> logtabs1,ArrayList<String> logtabs2,ArrayList<String> logtabs3) {
		boolean projectSelection = false;
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for (WebElement element : poc_qaProjectLink) {
			if (element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if (projectSelection) {
			ui_IsElementDisplay(ui_waitForElementToDisplay(serviceOverViewTab, Pause.MEDIUM));
			ui_click(serviceOverViewTab, "Poc_QA serviceOverviewLink");
			ui_wait(3);
		//Search with RandomString
		ui_IsElementDisplay(ui_waitForElementToDisplay(searchServiceTextBox, Pause.MEDIUM));
		ui_click(searchServiceTextBox, "clicks on environment overview tab under applicartion name");
		ui_clearAndSetValue(searchServiceTextBox, Servicename);
		searchServiceTextBox.sendKeys(Keys.ENTER);
		ui_wait(3);
		Assert.assertEquals(serviceList.get(0).getText(), Servicename.toUpperCase());
		ui_IsElementDisplay(ui_waitForElementToDisplay(searchServiceTextBox, Pause.MEDIUM));
		ui_click(searchServiceTextBox, "clicks on environment overview tab under applicartion name");
		ui_clearAndSetValue(searchServiceTextBox, Servicename);
		searchServiceTextBox.sendKeys(Keys.ENTER);
		ui_wait(3);
		Assert.assertEquals(serviceList.get(0).getText(), Servicename.toUpperCase());
		//Health Check
		ui_click(statusCheck, "Click on statusCheck");
		ui_wait(5);
		Assert.assertEquals(healthStatus.getText(), "SUCCESS");	
		ui_wait(5);
		
		//Build UI Verify
		Assert.assertEquals(ui_IsElementDisplay(buildArtifact), true);
		//Assert.assertEquals(ui_IsElementDisplay(commitID), true);
		//Assert.assertEquals(ui_IsElementDisplay(commitMessage), true);	
		
		//-----------------Service build deploy promote history monitoring icon 
		Assert.assertEquals(ui_IsElementDisplay(build), true);
		Assert.assertEquals(ui_IsElementDisplay(deploy), true);
		Assert.assertEquals(ui_IsElementDisplay(promote), true);
		Assert.assertEquals(ui_IsElementDisplay(history), true);
		Assert.assertEquals(ui_IsElementDisplay(monitoring), true);
			
		//----go to History Page and Verify Fields----
		ui_click(history, "Click on History Icon");
		
		Assert.assertEquals(ui_IsElementDisplay(historyTag), true);
		Assert.assertEquals(ui_IsElementDisplay(historyCacheorNoCache), true);
		Assert.assertEquals(ui_IsElementDisplay(historyIsDeploy), true);
		Assert.assertEquals(ui_IsElementDisplay(historyCustomtag), true);
		Assert.assertEquals(ui_IsElementDisplay(historyBranchname), true);
		Assert.assertEquals(ui_IsElementDisplay(historyActivity_MasterCode), true);
		
		ui_click(historywindow_closeButton, "Click on historywindow_closeButton");
		ui_wait(4);
		buildButton_Click();
		ui_wait(1);
		buildRecentButtonClick();
		ui_wait(1);
		String parent=ui_getUIDriver().getWindowHandle();

		Set<String> s=ui_getUIDriver().getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();

		if(!parent.equals(child_window))
		{
		ui_getUIDriver().switchTo().window(child_window);		
		}
		}
		//---------------verify DEV Logs Tabs--------------------
		ui_wait(2);
		for(int i=0;i<logtabs1.size();i++) {
			Assert.assertEquals(logsTabs.get(i).getText(),logtabs1.get(i));
		}	
		
		ui_getUIDriver().close();
		//switch to the parent window
	    ui_getUIDriver().switchTo().window(parent);
	    closeBuildWindow();
	    
		//-----------------------------Swtich to QA Tab------------------------------------------------------
		switchEnvironmentTab("QA");
		ui_wait(4);
		
		//Build UI Verify
		Assert.assertEquals(ui_IsElementDisplay(buildArtifact), true);
		//Assert.assertEquals(ui_IsElementDisplay(commitID), true);
		//Assert.assertEquals(ui_IsElementDisplay(commitMessage), true);
				
		//-----------------Service build deploy promote history monitoring icon 
		Assert.assertEquals(ui_IsElementDisplay(build), true);
		Assert.assertEquals(ui_IsElementDisplay(deploy), true);
		Assert.assertEquals(ui_IsElementDisplay(promote), true);
		Assert.assertEquals(ui_IsElementDisplay(history), true);
		Assert.assertEquals(ui_IsElementDisplay(monitoring), true);
		
		//----go to History Page and Verify Fields----
		ui_click(history, "Click on History Icon");
		ui_wait(4);				
		Assert.assertEquals(ui_IsElementDisplay(historyCustomtag), true);
		Assert.assertEquals(ui_IsElementDisplay(historyBranchname), true);
		Assert.assertEquals(ui_IsElementDisplay(historyActivity_MasterCode), true);
		
		ui_click(historywindow_closeButton, "Click on historywindow_closeButton");
		ui_wait(4);
		buildButton_Click();
		ui_wait(1);
		buildRecentButtonClick();
		ui_wait(1);
		String parent1=ui_getUIDriver().getWindowHandle();

		Set<String> s1=ui_getUIDriver().getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I2= s1.iterator();

		while(I2.hasNext())
		{

		String child_window1=I2.next();

		if(!parent1.equals(child_window1))
		{
		ui_getUIDriver().switchTo().window(child_window1);		
		}
		}
		
		//---------------verify QA Logs Tabs--------------------
		ui_wait(2);
		for(int i=0;i<logtabs2.size();i++) {
			Assert.assertEquals(logsTabs.get(i).getText(),logtabs2.get(i));
		}	
		
		ui_getUIDriver().close();
		//switch to the parent window
	    ui_getUIDriver().switchTo().window(parent);
	    closeBuildWindow();
				
		//-----------------------------Swtich to PROD Tab------------------------------------------------------
		switchEnvironmentTab("PROD");
		ui_wait(4);
		
		//Build UI Verify
		Assert.assertEquals(ui_IsElementDisplay(buildArtifact), true);
				
		//-----------------Service build deploy promote history monitoring icon 
		Assert.assertEquals(ui_IsElementDisplay(build), true);
		Assert.assertEquals(ui_IsElementDisplay(deploy), true);
		Assert.assertEquals(ui_IsElementDisplay(promote), true);
		Assert.assertEquals(ui_IsElementDisplay(history), true);
		Assert.assertEquals(ui_IsElementDisplay(monitoring), true);
			
		//----go to History Page and Verify Fields----
		ui_click(history, "Click on History Icon");
		ui_wait(4);
				
		Assert.assertEquals(ui_IsElementDisplay(historyTag), true);
		Assert.assertEquals(ui_IsElementDisplay(historyCacheorNoCache), true);
		Assert.assertEquals(ui_IsElementDisplay(historyIsDeploy), true);
		Assert.assertEquals(ui_IsElementDisplay(historyCustomtag), true);
		Assert.assertEquals(ui_IsElementDisplay(historyBranchname), true);
		Assert.assertEquals(ui_IsElementDisplay(historyActivity_MasterCode), true);
		
		ui_click(historywindow_closeButton, "Click on historywindow_closeButton");
		ui_wait(4);
		buildButton_Click();
		ui_wait(1);
		buildRecentButtonClick();
		ui_wait(1);
		String parent2=ui_getUIDriver().getWindowHandle();

		Set<String> s2=ui_getUIDriver().getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I3= s2.iterator();

		while(I3.hasNext())
		{

		String child_window2=I3.next();

		if(!parent2.equals(child_window2))
		{
		ui_getUIDriver().switchTo().window(child_window2);		
		}
		}
		
		//---------------verify PROD Logs Tabs--------------------
		ui_wait(2);
		for(int i=0;i<logtabs3.size();i++) {
			Assert.assertEquals(logsTabs.get(i).getText(),logtabs3.get(i));
		}
		
		ui_getUIDriver().close();
		//switch to the parent window
	    ui_getUIDriver().switchTo().window(parent2);
	    closeBuildWindow();
		
		}
		return this;
		}
	
	@FindBy(xpath = "(//button[text()='Parameters'])[1]")
	WebElement parametersFirstButton;
	@FindBy(xpath = "//span[text()='Deploy Parameters']")
	WebElement deployParametersButton;
	@FindBy(xpath = "//span[text()='tag']/following-sibling::span")
	WebElement tag;
	@FindBy(xpath = "//span[text()='dry_run']/following-sibling::span")
	WebElement dryRun;
	@FindBy(xpath = "//span[text()='component_id']/following-sibling::span")
	WebElement component_Id;
	@FindBy(xpath = "//span[text()='deploy_by_user']/following-sibling::span")
	WebElement deployByuser;
	@FindBy(xpath = "//span[text()='deployment_type']/following-sibling::span")
	WebElement deploymentType;
	@FindBy(xpath = "//span[text()='deplymenent_name']/following-sibling::span")
	WebElement deplymenentName;
	@FindBy(xpath = "//span[text()='task_instance_id']/following-sibling::span")
	WebElement taskInstance_id;
	@FindBy(xpath = "//span[text()='deploy_by_pipeline']/following-sibling::span")
	WebElement deploy_by_pipeline;
	@FindBy(xpath = "//span[text()='parent_activity_token']/following-sibling::span")
	WebElement parent_activity_token;
	@FindBy(xpath = "//span[text()='deployment_status_check']/following-sibling::span")
	WebElement deployment_status_check;
	@FindBy(xpath = "//span[text()='component_global_task_id']/following-sibling::span")
	WebElement component_global_task_id;
	public ServiceCreationPage BuildDetailstoDeploymentAccessibilty(String appName,String Servicename) {
		boolean projectSelection = false;
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
		for (WebElement element : poc_qaProjectLink) {
			if (element.getText().trim().equalsIgnoreCase(appName)) {
				element.click();
				projectSelection = true;
				break;
			}
		}
		if (projectSelection) {
			ui_IsElementDisplay(ui_waitForElementToDisplay(serviceOverViewTab, Pause.MEDIUM));
			ui_click(serviceOverViewTab, "Poc_QA serviceOverviewLink");
			ui_wait(3);
		//Search with RandomString
		ui_IsElementDisplay(ui_waitForElementToDisplay(searchServiceTextBox, Pause.MEDIUM));
		ui_click(searchServiceTextBox, "clicks on environment overview tab under applicartion name");
		ui_clearAndSetValue(searchServiceTextBox, Servicename);
		searchServiceTextBox.sendKeys(Keys.ENTER);
		ui_wait(3);
		Assert.assertEquals(serviceList.get(0).getText(), Servicename.toUpperCase());
		ui_IsElementDisplay(ui_waitForElementToDisplay(searchServiceTextBox, Pause.MEDIUM));
		ui_click(searchServiceTextBox, "clicks on environment overview tab under applicartion name");
		ui_clearAndSetValue(searchServiceTextBox, Servicename);
		searchServiceTextBox.sendKeys(Keys.ENTER);
		ui_wait(5);
		
		ui_click(history, "Click on History Icon");
		ui_wait(4);
		
		//------- switch to Deploy and Validate UI
		switchServiceType("Deploy");
		ui_wait(4);
		ui_click(parametersFirstButton, "parameters First Button");
		ui_wait(2);
		ui_click(deployParametersButton, "deployParameters Button");
		ui_wait(2);
		Assert.assertEquals(ui_IsElementPresent(tag, "3"), true);
		Assert.assertEquals(ui_IsElementPresent(dryRun, "3"), true);
		Assert.assertEquals(ui_IsElementPresent(component_Id, "3"), true);
		Assert.assertEquals(ui_IsElementPresent(deployByuser, "3"), true);
		Assert.assertEquals(ui_IsElementPresent(deploymentType, "3"), true);
		Assert.assertEquals(ui_IsElementPresent(deplymenentName, "3"), true);
		Assert.assertEquals(ui_IsElementPresent(taskInstance_id, "3"), true);
		Assert.assertEquals(ui_IsElementPresent(deploy_by_pipeline, "3"), true);
		Assert.assertEquals(ui_IsElementPresent(parent_activity_token, "3"), true);
		Assert.assertEquals(ui_IsElementPresent(deployment_status_check, "3"), true);
		Assert.assertEquals(ui_IsElementPresent(component_global_task_id, "3"), true);
		}
		return this;
		}

	
	@FindBy(xpath = "//div[contains(@class,'popup-card')]//td//div[contains(@class,'round-chip')]")
	WebElement buildStatus;	
	@FindBy(xpath = "//div[contains(@class,'popup-card')]//td//span[contains(@class,'round-chip')]")
	WebElement deployStatus;	
	@FindBy(xpath = "//div[contains(@class,'popup-card')]//td//p[contains(@class,'round-chip')]")
	WebElement promoteStatus;	
	
	@FindBy(xpath = "//div[contains(@class,'popup-card')]//span[text()='Build #']")
	WebElement buildRecent;	
	@FindBy(xpath = "//div[contains(@class,'popup-card')]//span[text()='Deploy#']")
	WebElement deployRecent;	
	@FindBy(xpath = "//div[contains(@class,'popup-card')]//a[text()='Promote#']")
	WebElement promoteRecent;	
	
	public ServiceCreationPage Verify_buildStatus(String Status) {
	ui_IsElementDisplay(ui_waitForElementToDisplay(buildStatus, Pause.MEDIUM));
    String BuildStatus=buildStatus.getText();
    assertEquals(BuildStatus, Status);
	return this;
	}
	
	public ServiceCreationPage Verify_deployStatus(String Status) {
		ui_IsElementDisplay(ui_waitForElementToDisplay(deployStatus, Pause.MEDIUM));
	    String DeployStatus=deployStatus.getText();
	    assertEquals(DeployStatus, Status);
		return this;
		}
	
	public ServiceCreationPage Verify_promoteStatus(String Status) {
		ui_IsElementDisplay(ui_waitForElementToDisplay(promoteStatus, Pause.MEDIUM));
	    String DeployStatus=promoteStatus.getText();
	    assertEquals(DeployStatus, Status);
		return this;
		}
	
	public ServiceCreationPage buildRecentButtonClick() {
	ui_click(buildRecent, "buildRecent");
		return this;
	}
	
	public ServiceCreationPage deployRecentButtonClick() {
		ui_click(deployRecent, "deployRecent");
		return this;
	}
	
	public ServiceCreationPage promoteRecentButtonClick() {
		ui_click(promoteRecent, "promoteRecent");
		return this;
	}
		
		
	@FindBy(xpath = "//input[@name='no_cache' and @class='switch-input']")
	WebElement cacheToggle;
	
	public ServiceCreationPage buildTriggerAndDeploy() {

		ui_click(buildButton, "clicks buildButton");
		ui_wait(5);
		ui_click(cacheToggle, "toggles cacheToggle yes");
		ui_wait(5);
		ui_click(triggerBuildAndDeploy, "clicks triggerBuildAndDeploy");

		return this;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Trigger Deploy ')]")
	WebElement triggerDeploy;
	@FindBy(xpath = "//button[contains(text(),'Trigger Promote')]")
	WebElement triggerPromote;
	
	@FindBy(xpath = "//button[@title='Deploy']")
	WebElement deployButton;
	@FindBy(xpath = "//button[@title='Clear']")
	WebElement cleardeployDropDown;
	@FindBy(xpath = "//input[@id='deploy_tag']")
	WebElement deploytagInput;
	@FindBy(xpath = "//ul[@id='deploy_tag-popup']//li")
	List<WebElement> deploytagList;
	
	@FindBy(xpath = "//input[@id='promote_tag']")
	WebElement promotetagInput;
	@FindBy(xpath = "//ul[@id='promote_tag-popup']//li")
	List<WebElement> promotetagList;
	
	
	public ServiceCreationPage deployService(String Artifactid) {

		ui_click(deployButton, "clicks deployButton");
		ui_wait(5);
		ui_click(deploytagInput, "deploytagInput");
		ui_click(cleardeployDropDown, "cleardeployDropDown");
		ui_clearAndSetValue(deploytagInput, Artifactid);
		ui_wait(2);
		ui_clickfromList(deploytagList, Artifactid);
		ui_wait(5);
		ui_click(triggerDeploy, "clicks triggerDeploy");

		return this;
	}
	@FindBy(xpath = "//button[@title='View Activity Details']")
	WebElement viewActivityDetails;
	@FindBy(xpath = "(//div[@class='md-step active md-step-log']/div[@class='md-step-circle success'])[1]")
	WebElement ActivityStatus1;
	@FindBy(xpath = "(//div[@class='md-step active md-step-log']/div[@class='md-step-circle success']/following-sibling::div/a/span[1])[1]")
	WebElement ActivityText1;
	@FindBy(xpath = "(//div[@class='md-step active md-step-log']/div[@class='md-step-circle success'])[2]")
	WebElement ActivityStatus2;
	@FindBy(xpath = "(//div[@class='md-step active md-step-log']/div[@class='md-step-circle success']/following-sibling::div/a/span[1])[2]")
	WebElement ActivityText2;
	@FindBy(xpath = "(//div[@class='md-step active md-step-log']/div[@class='md-step-circle success'])[3]")
	WebElement ActivityStatus3;
	@FindBy(xpath = "(//div[@class='md-step active md-step-log']/div[@class='md-step-circle success']/following-sibling::div/a/span[1])[3]")
	WebElement ActivityText3;
	@FindBy(xpath = "(//div[@class='md-step active md-step-log']/div[@class='md-step-circle success'])[4]")
	WebElement ActivityStatus4;
	@FindBy(xpath = "(//div[@class='md-step active md-step-log']/div[@class='md-step-circle success']/following-sibling::div/a/span[1])[4]")
	WebElement ActivityText4;
	@FindBy(xpath = "(//div[@class='md-step active md-step-log']/div[@class='md-step-circle success'])[5]")
	WebElement ActivityStatus5;
	@FindBy(xpath = "(//div[@class='md-step active md-step-log']/div[@class='md-step-circle success']/following-sibling::div/a/span[1])[5]")
	WebElement ActivityText5;
	@FindBy(xpath = "(//div[@class='md-step active md-step-log']/div[@class='md-step-circle success'])[6]")
	WebElement ActivityStatus6;
	@FindBy(xpath = "(//div[@class='md-step active md-step-log']/div[@class='md-step-circle success']/following-sibling::div/a/span[1])[6]")
	WebElement ActivityText6;
	
	@FindBy(xpath = "//button[@title='Rebuild']")
	WebElement rebuildbutton;
	@FindBy(xpath = "//button[@title='Redeploy']")
	WebElement reDeploybutton;
	@FindBy(xpath = "(//button[@title='Revoke Build'])[1]")
	WebElement revokeBuildbutton;
	@FindBy(xpath = "(//button[@title='Revoke Deploy'])[1]")
	WebElement revokeDeploybutton;
	@FindBy(xpath = "(//div[contains(@class,'history-body')]//div//p[contains(@class,'round-chip')])[1]")
	WebElement reBuildandDeployStatus;
	@FindBy(xpath = "//div[contains(@class,'tab-with-refresh')]//button[@class='btn-round border-navy bg-clear-btn']")
	WebElement buildandDeployRefresh;
	public ServiceCreationPage serviceHistory() {

		ui_click(history, "history button");
		ui_wait(5);
		ui_click(viewActivityDetails, "viewActivityDetails");
		ui_wait(2);
		Assert.assertEquals(ui_IsElementPresent(ActivityStatus1,"2"),true);
		Assert.assertEquals(ActivityText1.getText().trim(),"Cloning Repository");		
		Assert.assertEquals(ui_IsElementPresent(ActivityStatus2,"2"),true);
		Assert.assertEquals(ActivityText2.getText().trim(),"Pre Hooks Executing");
		Assert.assertEquals(ui_IsElementPresent(ActivityStatus3,"2"),true);
		Assert.assertEquals(ActivityText3.getText().trim(),"Build Docker Image");
		Assert.assertEquals(ui_IsElementPresent(ActivityStatus4,"2"),true);
		Assert.assertEquals(ActivityText4.getText().trim(),"Push docker image");
		Assert.assertEquals(ui_IsElementPresent(ActivityStatus5,"2"),true);
		Assert.assertEquals(ActivityText5.getText().trim(),"Post Hooks Executing");
		
		//Switch to Deploy and Validate Activity
		switchServiceType("Deploy");
		ui_wait(2);
		ui_click(viewActivityDetails, "viewActivityDetails");
		ui_wait(2);
		Assert.assertEquals(ui_IsElementPresent(ActivityStatus1,"2"),true);
		Assert.assertEquals(ActivityText1.getText().trim(),"Deployment rollout validation");		
		Assert.assertEquals(ui_IsElementPresent(ActivityStatus2,"2"),true);
		Assert.assertEquals(ActivityText2.getText().trim(),"Post Hooks Executing");
		Assert.assertEquals(ui_IsElementPresent(ActivityStatus3,"2"),true);
		Assert.assertEquals(ActivityText3.getText().trim(),"Deploy Stateless app");
		Assert.assertEquals(ui_IsElementPresent(ActivityStatus4,"2"),true);
		Assert.assertEquals(ActivityText4.getText().trim(),"Load Kube Config");
		Assert.assertEquals(ui_IsElementPresent(ActivityStatus5,"2"),true);
		Assert.assertEquals(ActivityText5.getText().trim(),"Pre Hooks Executing");
		Assert.assertEquals(ui_IsElementPresent(ActivityStatus6,"2"),true);
		Assert.assertEquals(ActivityText6.getText().trim(),"Generate Manifest");
		
		//Switch to Deploy and Validate Activity
		switchServiceType("Promote");
		ui_wait(2);
		//ui_click(viewActivityDetails, "viewActivityDetails");
		ui_wait(2);
		
		//Switch to Build and Rebuild
		switchServiceType("Build");
		ui_wait(2);
		ui_click(rebuildbutton, "rebuildbutton");
		ui_wait(20);
		//Assert.assertEquals(reBuildandDeployStatus.getText(), "RUNNING");
		ui_wait(90);
		ui_click(buildandDeployRefresh, "buildandDeployRefresh");
		ui_wait(30);
		ui_click(buildandDeployRefresh, "buildandDeployRefresh");
		ui_wait(3);
		Assert.assertEquals(reBuildandDeployStatus.getText(), "SUCCESS");
		
		//Switch to Deploy and Rebuild
		switchServiceType("Deploy");
		ui_wait(2);
		ui_click(reDeploybutton, "reDeploybutton");
		ui_wait(5);
		//Assert.assertEquals(reBuildandDeployStatus.getText(), "RUNNING");
		ui_wait(90);
		ui_click(buildandDeployRefresh, "buildandDeployRefresh");
		ui_wait(30);
		ui_click(buildandDeployRefresh, "buildandDeployRefresh");
		ui_wait(10);
		ui_click(buildandDeployRefresh, "buildandDeployRefresh");
		ui_wait(3);
		Assert.assertEquals(reBuildandDeployStatus.getText(), "SUCCESS");
		
		//Switch to Build and Revoke
		switchServiceType("Build");
		ui_wait(3);
		ui_click(rebuildbutton, "rebuildbutton");
		ui_wait(5);
		ui_click(revokeBuildbutton, "revokeBuildbutton");
		ui_wait(4);
		Assert.assertEquals(reBuildandDeployStatus.getText(), "REVOKED");
		
		//Switch to Deploy and Revoke
		switchServiceType("Deploy");
		ui_wait(3);
		ui_click(reDeploybutton, "reDeploybutton");
		ui_wait(5);
		ui_click(revokeDeploybutton, "revokeDeploybutton");
		ui_wait(4);
		Assert.assertEquals(reBuildandDeployStatus.getText(), "REVOKED");		
		return this;
	}
	
	@FindBy(xpath = "//div[contains(@class,'bg-round')]//span")
	WebElement monitoringStatus;
	@FindBy(xpath = "(//ul[@class='headerul']/li[2])[1]")
	WebElement podsStatusTab;
	@FindBy(xpath = "//div[@class='card pod-card ']//p[1]/span")
	WebElement podsStatus;
	
	public ServiceCreationPage monitorService() {

		ui_click(monitoring, "monitoring button");
		ui_wait(10);
		System.out.println(monitoringStatus.getText());
		ui_click(podsStatusTab, "podsStatusTab");
		ui_wait(10);
		ui_IsElementDisplay(ui_waitForElementToDisplay(podsStatus, Pause.MEDIUM));
		ui_click(podsStatus, "podsStatus");
		Assert.assertEquals(podsStatus.getText(), "Insufficient Space, cannot create pods");

		return this;
	}
	
	@FindBy(xpath = "(//table[contains(@class,'table table-responsive pd-')]/tr/td[1]/following-sibling::td/div)[1]")
	WebElement initializedStatus;
	@FindBy(xpath = "(//table[contains(@class,'table table-responsive pd-')]/tr/td[1]/following-sibling::td/div)[2]")
	WebElement readyStatus;
	@FindBy(xpath = "(//table[contains(@class,'table table-responsive pd-')]/tr/td[1]/following-sibling::td/div)[3]")
	WebElement containersReadyStatus;
	@FindBy(xpath = "(//table[contains(@class,'table table-responsive pd-')]/tr/td[1]/following-sibling::td/div)[4]")
	WebElement podScheduledStatus;
	@FindBy(xpath = "//ul[contains(@class,'headerul')]/..//button[contains(@class,'btn-round border-navy bg-clear-btn ml-')]")
	WebElement refreshMonitor;
	@FindBy(xpath = "//div[@class='bottom-panel']//li[text()='Events']")
	WebElement eventsTab;
	@FindBy(xpath = "//div[@class='bottom-panel']//li[text()='Containers']")
	WebElement containersTab;
	@FindBy(xpath = "//div[@class='view-lines monaco-mouse-cursor-text']/div[@class='view-line'][2]/span/span[1]")
	WebElement containersTabData;
	@FindBy(xpath = "//div[@class='bottom-panel']//li[text()='Logs']")
	WebElement logsTab;
	@FindBy(xpath = "//div[@id='podsLogViewSCreen']/div[1]")
	WebElement logsTabData;
	
	public ServiceCreationPage validateServiceMonitoring() {

		ui_click(monitoring, "monitoring button");
		ui_wait(10);
		ui_click(refreshMonitor, "refreshMonitor");
		ui_wait(3);
		SoftAssert softAssert = new SoftAssert(); 
		softAssert.assertEquals(monitoringStatus.getText(), "Success");
		ui_wait(3);
		ui_click(podsStatusTab, "podsStatusTab");
		ui_wait(10);
		ui_IsElementDisplay(ui_waitForElementToDisplay(podsStatus, Pause.MEDIUM));
		softAssert.assertEquals(podsStatus.getText(), "Ready");
		ui_wait(1);
		softAssert.assertEquals(initializedStatus.getText(), "True");
		softAssert.assertEquals(readyStatus.getText(), "True");
		softAssert.assertEquals(containersReadyStatus.getText(), "True");
		softAssert.assertEquals(podScheduledStatus.getText(), "True");
		
		//Switch to Events Tab
		ui_click(eventsTab, "eventsTab");
		
		//Switch to Container Tab
		ui_click(containersTab, "containersTab");
		ui_wait(2);
        Assert.assertEquals(containersTabData.getText().contains("containerID"), true);
        
		//Switch to logs Tab
		ui_click(logsTab, "logsTab");
		ui_wait(2);
		Assert.assertEquals(logsTabData.getText().contains("POD: "), true);
		ui_click(historywindow_closeButton, "historywindow_closeButton");
		return this;
	}
	
	public ServiceCreationPage promoteService(String env,String Artifactid) {
		
		ui_click(promote, "clicks Promote Button");
		ui_wait(5);
		Select dropdown = new Select(promoteEnvironmentSelect);
		dropdown.selectByVisibleText(env);
		ui_wait(2);
		ui_click(promotetagInput, "deploytagInput");
		ui_click(cleardeployDropDown, "cleardeployDropDown");
		ui_clearAndSetValue(promotetagInput, Artifactid);
		ui_wait(2);
		ui_clickfromList(promotetagList, Artifactid);
		ui_wait(5);
		ui_click(triggerPromote, "clicks triggerPromote");
		
		return this;
	}
	
	public ServiceCreationPage closeBuildWindow() {

		ui_click(buildwindow_closeButton, "clicks buildwindow_closeButton");

		return this;
	}
	
	public ServiceCreationPage closeDeployWindow() {

		ui_click(deploywindow_closeButton, "clicks deploywindow_closeButton");

		return this;
	}
	public ServiceCreationPage historyButton() {
		
		ui_click(history, "click on history Button");
		
		return this;
	}
	public ServiceCreationPage verify_BuildHistory() {
		
		Assert.assertEquals(history_buildType.getText(),"Build #1");
		Assert.assertEquals(history_buildStatus.getText(),"SUCCESS");
		Assert.assertEquals("1-20231127T1", history_buildArtifact.getText());
		Assert.assertEquals("Super Admin", history_buildby.getText());
		Assert.assertEquals("-", history_CommitID.getText());
		Assert.assertEquals("-", history_CommitMessage.getText());
		
		return this;
	}
	
	

}
