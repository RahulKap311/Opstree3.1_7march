package com.buildpiper.pages;

import java.util.ArrayList;
import java.util.Arrays;
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

public class ManageApplicationPage extends BasePage {
	
	@FindBy(xpath = "//li//button[contains(@class,'main-nav-1')]//span[1][@title]")
	List<WebElement> poc_qaProjectLink;
	@FindBy(xpath = "(//li//a[contains(@class,'main-nav-1')]//span/span[@class='color-black'])[2]")
	WebElement manageApplicationLink;
	@FindBy(xpath = "//a[text()='Add Application']")
	WebElement addApplicationbutton;
	@FindBy(xpath = "//input[@placeholder='Application Name']")
	WebElement applicationNameField;
	@FindBy(xpath = "//*[@placeholder='Application Description']")
	WebElement applicationDescriptionField;
	@FindBy(xpath = "//select[@name='policy_template_id']")
	WebElement policyTemplateIdDropdown;
	@FindBy(xpath = "//select[@name='clusters']")
	WebElement clusterDropdown;
	@FindBy(xpath = "//button[text()='Add Application']")
	WebElement addApplicationSubmit;
	@FindBy(xpath = "//select[@name='JOB_TEMPLATE_V3_SUPPORT']")
	WebElement jobTemplateV3SupportDropdown;
	@FindBy(xpath = "//button[text()='Apply immediately']")
	WebElement applyImmediately;
	@FindBy(xpath = "//button//span[2][@class='flaticon-expand-arrow']/../..//div//span[@title='Job Templates']")
	WebElement jobTemplateLink;
	@FindBy(xpath = "//div[text()='devtest-v3']")
	WebElement v3template;
	@FindBy(xpath = "//div[text()='devtest-v3']/../../../following-sibling::div[1]//a")
	WebElement v3templateEditLink;
	@FindBy(xpath = "//div[contains(@class,'job-card-design d-grid align-center')]/button[@class='transparent-btn nowrap']")
	List<WebElement> eyeIconList;
	@FindBy(xpath = "//div[contains(@class,'job-card-design d-grid align-center')]/label")
	List<WebElement> templateJobList;
	@FindBy(xpath = "//div[contains(@class,'step-card-design d-grid space-between')]/label")
	List<WebElement> buildJobStepList;
	@FindBy(xpath = "(//div[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-')]//button[@class='MuiButtonBase-root MuiIconButton-root'])")
	WebElement firstApplicationKebobIcon;
	@FindBy(xpath = "//span[contains(text(),'Delete')]")
	List<WebElement> deleteButton;
	@FindBy(xpath = "//input[@placeholder='Please enter the reason to delete']")
	WebElement deleteInputField;
	@FindBy(xpath = "//button[text()='Delete']")
	WebElement DeleteSubmit;
	
	public ManageApplicationPage() {

	}
	
	@FindBy(xpath = "//div[text()='Job Template v3 Support']")
	WebElement jobTemplateV3Support;
	public ManageApplicationPage EnableTemplateV3Support() {
		new PreRequisitesPage().systemSettings();
		ui_wait(5);
		ui_IsElementDisplay(ui_waitForElementToDisplay(jobTemplateV3Support, Pause.MEDIUM));
		ui_click(jobTemplateV3Support, "Job TemplateV3 Support");
		ui_wait(2);
		Select jobtemplateV3=new Select(jobTemplateV3SupportDropdown);
		jobtemplateV3.selectByVisibleText("true");
		ui_wait(2);
		ui_click(applyImmediately, "Apply Immediately");
		return this;

	}


	public ManageApplicationPage AddApplication(String appName) {

		boolean projectSelection = false;
		ui_wait(5);
		ui_IsElementDisplay(ui_waitForElementToDisplay(manageApplicationLink, Pause.MEDIUM));
	    ui_click(manageApplicationLink, "manage Application Link");
	    projectSelection = true;
	
		if (projectSelection) {
			ui_wait(2);
			ui_IsElementDisplay(ui_waitForElementToDisplay(addApplicationbutton, Pause.MEDIUM));
			ui_click(addApplicationbutton, "Add Application button");
			ui_setvalue(applicationNameField, "Application Name Field", appName);
			ui_wait(1);
			ui_setvalue(applicationDescriptionField, "Application Description Field", "test");
			Select policyterm=new Select(policyTemplateIdDropdown);
			policyterm.selectByIndex(1);
			ui_wait(2);
			Select cluster=new Select(clusterDropdown);
			cluster.selectByVisibleText("community-cluster");
			ui_wait(2);
            //ui_click(addApplicationSubmit, "Add Application Submit");
            ui_wait(2);
            new PreRequisitesPage().switchUser();
            ui_wait(5);
            ui_IsElementDisplay(ui_waitForElementToDisplay(poc_qaProjectLink.get(0), Pause.MEDIUM));
    		for (WebElement element : poc_qaProjectLink) {
    			if (element.getText().trim().equalsIgnoreCase(appName)) {
    				element.click();
    				break;
    			}
    		}
    		ui_wait(5);
    		ui_IsElementDisplay(ui_waitForElementToDisplay(jobTemplateLink, Pause.MEDIUM));
			ui_click(jobTemplateLink, "User clicks on job template link in left panel");
			ui_wait(3);
			Assert.assertEquals(ui_IsElementPresent(v3template, "3"), true);
			ui_click(v3templateEditLink, "v3template Edit Link");
			ui_wait(2);
			
			//Verify Job List
			List<String> joblist = new ArrayList<>(Arrays.asList("Build Job", "deploy_Job","deploy_configmaps_Job","deploy_secrets_Job","promote Job","rollback_Job","jira_integration_Job","integration_Job"));
			
			for(int i=0;i<templateJobList.size();i++) {
			Assert.assertEquals(templateJobList.get(i).getText(), joblist.get(i));	
			}
			
			// Verify Each Build Steps
			List<String> buildjobSteplist = new ArrayList<>(Arrays.asList("clone_repo", "VM cmd execute","build_image","push_image","VM cmd execute"));
			
			for(int i=0;i<buildJobStepList.size();i++) {
				Assert.assertEquals(buildJobStepList.get(i).getText(), buildjobSteplist.get(i));	
			}
			ui_wait(2);
			ui_click(eyeIconList.get(1), "eye Icon Deploy Job");
			ui_wait(2);
			
			Assert.assertEquals(buildJobStepList.get(0).getText(), "k8 deploy");
			
			ui_wait(2);
			ui_click(eyeIconList.get(2), "eye Icon deploy_configmaps Job");
			ui_wait(2);
			
			Assert.assertEquals(buildJobStepList.get(0).getText(), "deploy_configmaps");
			
			ui_wait(2);
			ui_click(eyeIconList.get(3), "eye Icon deploy secret Job");
			ui_wait(2);
			
			Assert.assertEquals(buildJobStepList.get(0).getText(), "deploy_secrets");
			
			ui_wait(2);
			ui_click(eyeIconList.get(4), "eye Icon promote Job");
			ui_wait(2);
			
			Assert.assertEquals(buildJobStepList.get(0).getText(), "docker_image_promote");
			
			ui_wait(2);
			ui_click(eyeIconList.get(5), "eye Icon rollback Job");
			ui_wait(2);
			
			Assert.assertEquals(buildJobStepList.get(0).getText(), "rollback");
			
			ui_wait(2);
			ui_click(eyeIconList.get(6), "eye Icon jira integration Job");
			ui_wait(2);
			
			Assert.assertEquals(buildJobStepList.get(0).getText(), "jira_integration");
			
			ui_wait(2);
			ui_click(eyeIconList.get(7), "eye Icon integration testing Job");
			ui_wait(2);
			
			Assert.assertEquals(buildJobStepList.get(0).getText(), "integration_testing");
			ui_wait(2);
			
			//Switch to Admin and Delete created Application
            new PreRequisitesPage().switchToAdmin();
            ui_wait(5);
    		ui_IsElementDisplay(ui_waitForElementToDisplay(manageApplicationLink, Pause.MEDIUM));
    	    ui_click(manageApplicationLink, "manage Application Link");
    	    ui_wait(2);
    	    ui_click(firstApplicationKebobIcon, "First Application KebobIcon");
    	    ui_wait(1);
    	    for(int i=0;i<deleteButton.size();i++) {
    	    if(ui_IsElementDisplay(deleteButton.get(i))) {
    	    	deleteButton.get(i).click(); 	
     	    }
    	    }
    	    ui_setvalue(deleteInputField, "delete Input Field", "Automation");
    	   //ui_click(DeleteSubmit, "Delete Confirm");
            
		}

		return this;

	}
	
}