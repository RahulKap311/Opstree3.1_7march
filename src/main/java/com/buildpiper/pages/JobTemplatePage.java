package com.buildpiper.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.buildpiper.base.BasePage;
import com.buildpiper.utils.Pause;
import com.buildpiper.utils.RandomStrings;

import groovyjarjarantlr4.v4.parse.ANTLRParser.throwsSpec_return;

public class JobTemplatePage extends BasePage {

	@FindBy(xpath = "//li//button[contains(@class,'main-nav-1')]//span[1][@title]")
	List<WebElement> poc_qaProjectLink;

	@FindBy(xpath = "//button//span[2][@class='flaticon-expand-arrow']/../..//div//span[@title='Job Templates']")
	WebElement jobTemplateLink;

	@FindBy(xpath = "//div[contains(text(),'perfeasy-testing-')]")
	WebElement v3TemplateName;

	@FindBy(xpath = "//div//p//div[contains(text(),'perfeasy-testing-')]/../../../../..//a[@class='text-anchor-blue'][contains(@href,'/application/')][contains(@href,'/application/')]")
	WebElement jobTemplateEditLink;

	@FindBy(xpath = "//label[text()='integration_Job']/..//button[@class='transparent-btn nowrap']")
	WebElement jiraIntegrationJobEyeLink;

	@FindBy(xpath = "//div[contains(@class,'step-card-design')]//label[text()='integration_testing']/..//button[@class='transparent-btn nowrap']")
	WebElement editIntegrationDetails;

	@FindBy(xpath = "//div[text()='Edit Step']")
	WebElement editIntegrationStep;

	@FindBy(xpath = "//div[@class='custom-notify-header']/../..//button[text()='Close']")
	WebElement closeEditIntegrationStep;

	@FindBy(xpath = "//label[text()='Add New Step']")
	WebElement addNewIntegrationStep;

	@FindBy(xpath = "//label[text()='No Steps Selected']")
	WebElement displayEmptyStepsSelected;

	@FindBy(xpath = "//div[@class='card-body ']//div[contains(@class,'card-description')]//span")
	List<WebElement> integrationImageTagContainer;

	@FindBy(xpath = "//div[@class='card-body ']//div[contains(@class,'card-description')]//div[@title]")
	List<WebElement> integrationTextContainer;

	@FindBy(xpath = "//div[@class='click-btn']")
	List<WebElement> clickSelectStepUnderIntegrationJob;

	@FindBy(xpath = "//input[@name='WORKSPACE']")
	WebElement inputWorkspaceName;

	@FindBy(xpath = "//input[@name='INSTRUCTION']")
	WebElement inputInstruction;

	@FindBy(xpath = "(//div//h5)[1]")
	WebElement selectStepLeftHeader;

	@FindBy(xpath = "//div[@class='left-content']//button")
	List<WebElement> stepnameList;
	
	@FindBy(xpath = "//a[@class='addbtn' and text()='Add Custom Variable']")
	WebElement addCustomVariable;
	
	@FindBy(xpath = "//input[@name='variable_name']")
	WebElement inputVariableName;
	
	@FindBy(xpath = "//input[@name='variable_value']")
	WebElement inputVariableValue;
	
	@FindBy(xpath = "(//button[@class='btn btn-submit'])[2]")
	WebElement addVariable;
	
	@FindBy(xpath = "(//button[@class='btn btn-submit'])[3]")
	WebElement saveMavenExecute;
	
	@FindBy(xpath = "///div[@class='staticwrap-inner']//h5")
	WebElement openedCardHeader;
	
	@FindBy(xpath = "//button[@class='btn btn-submit'][text()='Save']")
	WebElement saveStep;

	public JobTemplatePage() {

	}

	public JobTemplatePage V3MultipleIntegrationSupport(String appName, String templateStr,
			String buildTestStepImageName, String mavenExecuteImageName, String s3FileUploadImageName,
			String s3FileDownloadImageName, String manageRemoteProcessImageName, String secureCopyImageName,
			String k8ManifestApplyImageName, String googleChatNotificationImageName, String cloneRepositoryImageName,
			String dockerImageBuildImageName, String workSpaceName, String instructionsText, String step1, String step2,
			String step3, String step4, String step5, String step6, String step7, String step8, String step9,
			String step10, String variableName, String variableValue) {

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

			ui_IsElementDisplay(ui_waitForElementToDisplay(jobTemplateLink, Pause.MEDIUM));
			ui_click(jobTemplateLink, "User clicks on job template link in left panel");
			ui_wait(2);
			ui_IsElementDisplay(ui_waitForElementToDisplay(v3TemplateName, Pause.MEDIUM));
			ui_click(jobTemplateEditLink, "User clicks on job template edit");
			ui_click(jiraIntegrationJobEyeLink, "User Clicks on eye button over Integration Job");
			ui_click(editIntegrationDetails, "User clicks on edit integration details");
			ui_click(editIntegrationStep, "User clicks on edit integration step button");
			ui_click(closeEditIntegrationStep, "User clicks on close edit step button");
			ui_click(addNewIntegrationStep, "User clicks on add new step for integration job");
			ui_IsElementDisplay(ui_waitForElementToDisplay(displayEmptyStepsSelected, Pause.MEDIUM));
			boolean imageTxtStatus = true;
			for (WebElement imageContainer : integrationImageTagContainer) {
				String imageText = imageContainer.getText();
				System.out.println(imageText);
				if (!(imageText.contains(buildTestStepImageName) || imageText.contains(mavenExecuteImageName)
						|| imageText.contains(s3FileUploadImageName) || imageText.contains(s3FileDownloadImageName)
						|| imageText.contains(manageRemoteProcessImageName) || imageText.contains(secureCopyImageName)
						|| imageText.contains(k8ManifestApplyImageName)
						|| imageText.contains(googleChatNotificationImageName)
						|| imageText.contains(cloneRepositoryImageName)
						|| imageText.contains(dockerImageBuildImageName))) {
					imageTxtStatus = false;
					break;
				}
			}
			Assert.assertTrue(imageTxtStatus, "Unable to  validate the Image container Text");
//			boolean StepTxtStatus = true;
//			for (WebElement stepContainer : integrationTextContainer) {
//				String stepTxt = stepContainer.getAttribute("title");
//				System.out.println(stepTxt);
//				if (!(stepTxt.contains("This step helps to build a Maven project.")
//						|| stepTxt.contains("This step helps to upload s3 file.")
//						|| stepTxt.contains("This step helps to download s3 file.")
//						|| stepTxt.contains(
//								"This step helps to request a service from a program located in another computer on a network without having to understand the network's details.")
//						|| stepTxt.contains(
//								"This step helps to securely copy files/folders between Linux systems on a network.")
//						|| stepTxt.contains("This step helps to apply/delete/update k8's resources.")
//						|| stepTxt.contains("This will send notification of Build/Deploy Status.")
//						|| stepTxt.contains("This step helps to clone the git repository of your service source code")
//						|| stepTxt.contains("This step helps to build docker images for your services"))) {
//					StepTxtStatus = false;
//					break;
//				}
//			}
//			Assert.assertTrue(StepTxtStatus, "Unable to  validate the integration step text container");
//			int randmDigit = RandomStrings.generateRandomInt(1);
//			System.out.println(clickSelectStepUnderIntegrationJob.get(randmDigit));
			ArrayList<String> stepNameArr = new ArrayList<String>();
			for (int i = 0; i < stepnameList.size(); i++) {
				stepNameArr.add(stepnameList.get(i).getAttribute("title").trim());
			}
			Collections.sort(stepNameArr);

			ArrayList<String> stepNameExpArr = new ArrayList<String>();
			stepNameExpArr.add(step1);
			stepNameExpArr.add(step2);
			stepNameExpArr.add(step3);
			stepNameExpArr.add(step4);
			stepNameExpArr.add(step5);
			stepNameExpArr.add(step6);
			stepNameExpArr.add(step7);
			stepNameExpArr.add(step8);
			stepNameExpArr.add(step9);
			stepNameExpArr.add(step10);

			Collections.sort(stepNameExpArr);
			System.out.println(stepNameExpArr);
			
			//Assert.assertTrue(stepNameArr.equals(stepNameExpArr),"");
//			for (int i = 0; i < clickSelectStepUnderIntegrationJob.size(); i++) {
//				ui_click(clickSelectStepUnderIntegrationJob.get(i), "User Clicks on Step Name");
//				SoftAssertion.assertEquals(stepNameExpArr.contains(openedCardHeader.getText()),
//						"Validated left header on each step");
////				for (int k = 0; k < stepNameExpArr.size(); k++) {
////					for (int j = 0; j < stepNameArr.size(); j++) {
////						SoftAssertion.assertEquals(stepNameArr.get(j), stepNameExpArr.get(k), "Validated left header on each step");
////					}
////				}
//				ui_click(closeEditIntegrationStep, "clicks on close button");
//			}
	
//			ui_IsElementDisplay(ui_waitForElementToDisplay(clickSelectStepUnderIntegrationJob.get(0), Pause.MEDIUM));
			ui_click(clickSelectStepUnderIntegrationJob.get(1), "User clicks on random step to be added");
//			ui_clearAndSetValue(inputWorkspaceName, workSpaceName);
//			ui_setvalue(inputWorkspaceName, "sets value for input workspace field", workSpaceName);
//			ui_setvalue(inputInstruction, "Instructions Text", instructionsText);
			ui_click(addCustomVariable, "User clicks on add custom step button");
			ui_IsElementDisplay(ui_waitForElementToDisplay(inputVariableName, Pause.MEDIUM));
			ui_clearAndSetValue(inputVariableName, variableName);
			ui_clearAndSetValue(inputVariableValue, variableValue);
			ui_click(addVariable, "User clicks on add variable hyperlink");
			ui_click(saveMavenExecute, "User clicks on save maven button");
			ui_click(saveStep, "User clicks on save step button");

			ui_wait(5);
			

		}

		return this;

	}
	
	@FindBy(xpath = "//a[text()='New Job Templates']")
	WebElement addNewTemplatebutton;
	@FindBy(xpath = "//label[@class='switch']/span[@class='switch-handle']")
	WebElement cloneTemplateSwitchbutton;
	@FindBy(xpath = "//input[@placeholder='Enter Name']")
	WebElement templateNamefield;
	@FindBy(xpath = "//textarea[@name='description']")
	WebElement templateDescription;
	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath = "//select[@name='clone_template']/option")
	List<WebElement> cloneTemplateDropdownOptions;
	@FindBy(xpath = "(//div[@class='template-name-ellipsis'])[1]")
	WebElement createdtemplateName;
	@FindBy(xpath = "(//div[@class='d-flex align-center']//a[@class='text-anchor-blue'])[1]")
	WebElement firsttemplateEditbutton;
	@FindBy(xpath = "(//div[@class='d-flex align-center']//button[@class='MuiButtonBase-root MuiIconButton-root'])[1]")
	WebElement firsttemplateDeletebutton;
	@FindBy(xpath = "(//div[@class='overlay-wrap']/div[text()='Select step'])[1]")
	WebElement selectFirstStep;
	@FindBy(xpath = "(//button[@class='btn btn-submit'])[2]")
	WebElement saveStepWindow;
	@FindBy(xpath = "//div[@class='d-flex align-centre']/button")
	List<WebElement> kebobIcon;
	@FindBy(xpath = "//label[text()='View Step']")
	List<WebElement> viewStep;
	@FindBy(xpath = "//div[@class='env-var-table']/following-sibling::div/label")
	WebElement viewStepVariablevalue;
	@FindBy(xpath = "//div[text()='Edit Step']")
	List<WebElement> editStep;
	@FindBy(xpath = "//input[@name='rest_api']")
	WebElement editStepInputField;
	@FindBy(xpath = "//div[text()='Delete Step']")
	List<WebElement> deleteStep;
	@FindBy(xpath = "//label[text()='Step : Slack Notification']")
	WebElement slackPopupheading;
	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root'])[3]")
	WebElement closeSlackPopup;
	@FindBy(xpath = "//button[text()='Back']")
	WebElement backTemplatebutton;
	@FindBy(xpath = "//input[@placeholder='Please enter the reason to delete']")
	WebElement deleteConfirmation;
	@FindBy(xpath = "//button[text()='Delete']")
	WebElement deleteButton;
	
	public JobTemplatePage AddNewTemplate(String appName, String templateName) {

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
			
			ui_IsElementDisplay(ui_waitForElementToDisplay(jobTemplateLink, Pause.MEDIUM));
			ui_click(jobTemplateLink, "User clicks on job template link in left panel");
			ui_wait(2);
			ui_click(addNewTemplatebutton, "Add New Template Button");
			ui_wait(2);
			ui_click(cloneTemplateSwitchbutton, "cloneTemplateSwitchbutton");
			boolean flag=false;
			for(int i=0;i<cloneTemplateDropdownOptions.size();i++) {
				
				if(cloneTemplateDropdownOptions.get(i).getText().contains("perfeasy-testing")) {
					flag=true;
				}			
			}
			if(flag=false) {
				throw new ElementNotVisibleException("Element not Found");
			}	
			ui_click(cloneTemplateSwitchbutton, "cloneTemplateSwitchbutton");
			ui_wait(2);
			ui_setvalue(templateNamefield, "templateName", templateName);
			ui_wait(2);
			ui_setvalue(templateDescription, "templateDescription", "test");
			ui_wait(2);
			ui_click(saveButton, "saveButton");
			ui_wait(2);
			Assert.assertEquals(createdtemplateName.getText(), templateName);
			ui_click(firsttemplateEditbutton, "firsttemplateEditbutton");
			
			ui_click(addNewIntegrationStep, "User clicks on add new step for integration job");
			ui_wait(2);
			ui_click(selectFirstStep, "select FirstStep");
			ui_wait(2);
			ui_click(saveStepWindow, "save StepWindow");
			ui_wait(2);
			ui_click(saveStep, "User clicks on save step button");
			ui_wait(4);
			ui_IsElementDisplay(ui_waitForElementToDisplay(kebobIcon.get(0), Pause.MEDIUM));
			int size=kebobIcon.size()-1;
			// View Step
			ui_click(kebobIcon.get(size), "kebobIcon");
			for(int i=0;i<viewStep.size();i++) {
				if(ui_IsElementDisplay(viewStep.get(i))){
					ui_click(viewStep.get(i), "view Step Click");
					
				}
			}
			Assert.assertEquals(ui_IsElementPresent(slackPopupheading, "4"), true);
			Assert.assertEquals(viewStepVariablevalue.getText(), "test");
			ui_click(closeSlackPopup, "closeSlackPopup");
			
			//Edit Step
			ui_click(kebobIcon.get(size), "kebobIcon");
			for(int i=0;i<editStep.size();i++) {
				if(ui_IsElementDisplay(editStep.get(i))){
					ui_click(editStep.get(i), "edit Step Click");
					
				}
			}
			ui_wait(2);
			ui_setvalue(editStepInputField, "editStepInputField", "123");
			ui_wait(2);
			ui_click(saveStepWindow, "save StepWindow");
			ui_wait(2);
			
			//After Edit Verify Detail on View Step
			ui_click(kebobIcon.get(size), "kebobIcon");
			for(int i=0;i<viewStep.size();i++) {
				if(ui_IsElementDisplay(viewStep.get(i))){
					ui_click(viewStep.get(i), "view Step Click");
					
				}
			}
			ui_wait(2);
			Assert.assertEquals(ui_IsElementPresent(slackPopupheading, "4"), true);
			Assert.assertEquals(viewStepVariablevalue.getText(), "test123");
			ui_click(closeSlackPopup, "closeSlackPopup");						
			
			//Delete Step
			ui_click(kebobIcon.get(size), "kebobIcon");
			for(int i=0;i<deleteStep.size();i++) {
				if(ui_IsElementDisplay(deleteStep.get(i))){
					ui_click(deleteStep.get(i), "delete Step Click");
					
				}
			}
			ui_click(backTemplatebutton, "back Template button");
			ui_wait(2);
			ui_click(firsttemplateDeletebutton, "first template Delete button");
			ui_wait(2);
			ui_setvalue(deleteConfirmation, "deleteConfirmation", "Automation");
			ui_wait(2);
			ui_click(deleteButton, "delete Button");
		}
		return this;
	}
	
	@FindBy(xpath = "(//li//a[contains(@class,'main-nav-1')]//span/span[@class='color-black'])[1]")
	WebElement poc_stepCatelog;
	@FindBy(xpath = "//a[text()='New Step']")
	WebElement newStepButton;
	@FindBy(xpath = "//input[@placeholder='Clone Repository']")
	WebElement stepNameField;
	@FindBy(xpath = "//input[@placeholder='Step Code (Must be Unique)']")
	WebElement stepCodeField;
	@FindBy(xpath = "(//input[@name='category'])[1]")
	WebElement stepCategoryAllCheckbox;
	@FindBy(xpath = "(//input[@name='container_type'])[1]")
	WebElement containertypeRadiobutton;
	@FindBy(xpath = "//input[@name='image_name_with_tag']")
	WebElement dockerImagetag;
	@FindBy(xpath = "//select[@name='mount_path']")
	WebElement mountNameDropdown;
	@FindBy(xpath = "(//input[@name='data_requirement'])[1]")
	WebElement buildDataPathCheckbox;
	@FindBy(xpath = "//select[@name='input_type']")
	WebElement variableDataTypeDropdown;
	@FindBy(xpath = "//input[@name='key']")
	WebElement variableName;
	@FindBy(xpath = "//input[@name='default_value']")
	WebElement variableValue;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveNewStep;
	@FindBy(xpath = "//button[@class='transparent-btn nowrap']//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeLarge']")
	WebElement stepKebobIcon;
	@FindBy(xpath = "//label[text()='Delete']")
	WebElement deleteNewStep;
	public JobTemplatePage AddNewStep() {

		boolean projectSelection = false;
		ui_wait(5);
		ui_IsElementDisplay(ui_waitForElementToDisplay(poc_stepCatelog, Pause.MEDIUM));
		ui_click(poc_stepCatelog, "Step Catalog");
		projectSelection = true;
		if (projectSelection) {
			
			ui_IsElementDisplay(ui_waitForElementToDisplay(newStepButton, Pause.MEDIUM));
			ui_click(newStepButton, "New Step Button");
			ui_wait(2);
			ui_setvalue(stepNameField, "stepNameField", "New Step1");
			ui_wait(2);
			String stepcode = "test-" + RandomStrings.generateRandomString(5);
			ui_setvalue(stepCodeField, "stepCodeField", stepcode);
			ui_wait(1);
			ui_click(stepCategoryAllCheckbox, "stepCategoryAllCheckbox");
			ui_wait(1);
			ui_setvalue(dockerImagetag, "dockerImagetag", "test");
			ui_wait(1);			
			ui_click(containertypeRadiobutton, "containertypeRadiobutton");
			Select mountname=new Select(mountNameDropdown);
			mountname.selectByVisibleText("Docker daemon file");
			ui_wait(1);
			ui_click(buildDataPathCheckbox, "stepCategoryAllCheckbox");
			ui_wait(1);
			Select datatype=new Select(variableDataTypeDropdown);
			datatype.selectByVisibleText("Text box");
			ui_wait(2);
			ui_setvalue(variableName, "variableName", "rest_api");
			ui_wait(2);
			ui_setvalue(variableValue, "variableValue", "test");
			ui_wait(1);
			ui_click(saveNewStep, "save NewStep");
			ui_wait(4);
			ui_click(stepKebobIcon, "step KebobIcon");
			ui_wait(1);
			ui_click(deleteNewStep, "Delete Created Step");
			ui_wait(2);
			ui_setvalue(deleteConfirmation, "deleteConfirmation", "Automation");
			ui_wait(2);
			ui_click(deleteButton, "delete Button");
		}
		return this;
	}

}