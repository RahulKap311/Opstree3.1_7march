package com.buildpiper.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.aeonbits.owner.ConfigFactory;
//import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.buildpiper.base.BasePage;
import com.buildpiper.utils.FrameworkConfig;
import com.buildpiper.utils.Pause;
import com.buildpiper.utils.RandomStrings;

import groovyjarjarantlr4.v4.parse.ANTLRParser.throwsSpec_return;

public class GitEventsPage extends BasePage {
	FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);
	@FindBy(xpath = "//li//button[contains(@class,'main-nav-1')]//span[1][@title]")
	List<WebElement> poc_qaProjectLink;
	@FindBy(xpath = "(//li//button[contains(@class,'main-nav-1')]//span/span[@class='color-black'])[1]")
	WebElement integrationsLink;
	@FindBy(xpath = "(//span[@class='material-icons material-icons-outlined']/following-sibling::span)[3]")
	WebElement gitEventsLink;
	@FindBy(xpath = "//button[text()=' Add Listener']")
	WebElement addListenerButton;
	@FindBy(xpath = "//input[@placeholder='Please give a name to Event Listener']")
	WebElement addListenerNameField;
	@FindBy(xpath = "//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiAutocomplete-inputRoot MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-adornedEnd MuiOutlinedInput-adornedEnd']")
	WebElement gitUrlEnterDropdown;

	@FindBy(xpath = "//input[@name='git_url']")
	WebElement gitUrlInputField;
	@FindBy(xpath = "//button[@title='Clear']")
	WebElement clearClickGitDropDown;
	@FindBy(xpath = "//ul[@id='git_url-popup']//li")
	List<WebElement> autoCompleteURLList;

	@FindBy(xpath = "//*[text()='Load Branches']")
	WebElement loadBranchesBtn;

	@FindBy(xpath = "//select[@name='branch_name']")
	WebElement selectBranchName;
	@FindBy(xpath = "//input[@placeholder='Enter Issue Name']")
	WebElement selectEventname;
	@FindBy(xpath = "//ul[@class='MuiAutocomplete-listbox']/li[1]")
	WebElement autoCompleteEvenetList;
	@FindBy(xpath = "//select[@name='project_id']")
	WebElement selectApplication;
	@FindBy(xpath = "//select[@name='project_env_id']")
	WebElement selectEnvironment;
	@FindBy(xpath = "//select[@name='service_id']")
	WebElement selectService;
	@FindBy(xpath = "//select[@name='project_job_template_id']")
	WebElement selectJobTemplate;
	@FindBy(xpath = "//select[@name='action']")
	WebElement selectJob;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveListener;
	@FindBy(xpath = "(//div[@class='events']//button[@class='MuiButtonBase-root MuiIconButton-root']/span[1])[1]")
	WebElement firstKebobIcon;
	@FindBy(xpath = "//span[contains(text(),'Delete')]")
	WebElement deleteNewEvent;
	@FindBy(xpath = "//input[@placeholder='Please enter the reason to delete']")
	WebElement deleteConfirmation;
	@FindBy(xpath = "//button[text()='Delete']")
	WebElement deleteButton;
	
		public GitEventsPage() {

	}



	public GitEventsPage AddListener(String ListenerName,String gitURL,String BranchName,String ApplicationName,String Environment,String Service,String Template,String Job) {

		boolean projectSelection = false;
		ui_wait(5);
		ui_IsElementDisplay(ui_waitForElementToDisplay(integrationsLink, Pause.MEDIUM));
	    ui_click(integrationsLink, "integrations Link Link");
	    ui_click(gitEventsLink, "git Events Link Link");
	    projectSelection = true;
	
		if (projectSelection) {
			ui_wait(2);
			ui_IsElementDisplay(ui_waitForElementToDisplay(addListenerButton, Pause.MEDIUM));
			ui_click(addListenerButton, "Add New Listener Button");
			ui_wait(2);
			ui_setvalue(addListenerNameField, "addListenerNameField", ListenerName);
			ui_wait(2);
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
			ui_selectValueFromDropDownByXPath(selectBranchName, "Selects Branch Name");
			Select dropdown = new Select(selectBranchName);
			dropdown.selectByVisibleText(BranchName);
			ui_wait(3);
			ui_click(selectEventname, "Select Event name");
			ui_setvalue(selectEventname, "selectEventname", "Push Hook");
			ui_wait(2);
			ui_ActionMoveAndClick(autoCompleteEvenetList, "autoCompleteEvenetList");
			ui_wait(3);
			ui_click(selectEventname, "Select Event name");
			ui_setvalue(selectEventname, "selectEventname", "Commit comment");
			ui_wait(2);
			ui_click(autoCompleteEvenetList, "autoCompleteEvenetList");
			ui_wait(3);
			ui_click(selectEventname, "Select Event name");
		    ui_setvalue(selectEventname, "selectEventname", "Merge Request Hook");
		    ui_wait(2);
			ui_click(autoCompleteEvenetList, "autoCompleteEvenetList");
			ui_wait(2);
			Select application=new Select(selectApplication);
			application.selectByVisibleText(ApplicationName);
			ui_wait(4);
			ui_IsElementDisplay(ui_waitForElementToDisplay(selectEnvironment, Pause.MEDIUM));
			ui_wait(2);
			Select env=new Select(selectEnvironment);
			env.selectByVisibleText(Environment);
			ui_wait(4);
			ui_IsElementDisplay(ui_waitForElementToDisplay(selectService, Pause.MEDIUM));
			Select service=new Select(selectService);
			service.selectByVisibleText(Service);
			ui_wait(4);
			ui_IsElementDisplay(ui_waitForElementToDisplay(selectJobTemplate, Pause.MEDIUM));
			Select jobTemplate=new Select(selectJobTemplate);
			jobTemplate.selectByVisibleText(Template);
			ui_wait(4);
			ui_IsElementDisplay(ui_waitForElementToDisplay(selectJob, Pause.MEDIUM));
			Select job=new Select(selectJob);
			job.selectByVisibleText(Job);
			ui_wait(4);
            ui_click(saveListener, "Save Listener");
        	ui_wait(4);
			ui_click(firstKebobIcon, "step KebobIcon");
			ui_wait(1);
			if(ui_IsElementDisplay(deleteNewEvent)) {
			ui_click(deleteNewEvent, "Delete Created Event");
			ui_wait(2);	
			}			
			ui_setvalue(deleteConfirmation, "deleteConfirmation", "Automation");
			ui_wait(2);
			ui_click(deleteButton, "delete Button");
		}

		return this;

	}
	
	@FindBy(xpath = "//input[@id='login_field']")
	WebElement githubUsername;
	@FindBy(xpath = "//input[@id='password']")
	WebElement githubpassword;
	@FindBy(xpath = "//input[@class='btn btn-primary btn-block js-sign-in-button']")
	WebElement githubLoginButton;
	@FindBy(xpath = "//span[@class='Button-label']/img[@class='avatar circle']")
	WebElement githubMenu;
	@FindBy(xpath = "//span[@class='ActionListItem-label'][contains(text(),'Your repositories')]")
	WebElement githubRepository;
	@FindBy(xpath = "//a[contains(text(),'Opstree3.2_29Dec')]")
	WebElement githubRepositoryName;
	@FindBy(xpath = "//a[text()='README.md']")
	WebElement githubFile;
	@FindBy(xpath = "//a[@class='types__StyledButton-sc-ws60qy-0 HrSzO']")
	WebElement githubFileEditLink;
	@FindBy(xpath = "(//div[@class='cm-line'])[1]")
	WebElement githubFileEnterValue;
	@FindBy(xpath = "//span[text()='Commit changes...']")
	WebElement githubFileCommitChanges;
	@FindBy(xpath = "//textarea[@class='Textarea__StyledTextarea-sc-1lf8it-0 gBIQdK']")
	WebElement githubFileCommitDescription;
	@FindBy(xpath = "//span[text()='Commit changes']")
	WebElement githubFileCommitChangeConfirm;
	@FindBy(xpath = "//span[contains(text(),'Sign out')]")
	WebElement githublogout;
	
	public GitEventsPage GitHubFileUpdate(String Username,String Password,String Filename,String Value) {
 
		ui_launch("https://github.com/login");
		ui_getUIDriver().navigate().refresh();
		ui_wait(2);
		ui_waitForPageLoad();
		ui_wait(2);
		ui_clearAndSetValue(githubUsername, Username);
		ui_clearAndSetValue(githubpassword, Password);
        ui_click(githubLoginButton, "github LoginButton");
        ui_click(githubMenu, "github Menu");
        ui_click(githubRepository, "github Repository");
        ui_click(githubRepositoryName, "github RepositoryName");
        ui_click(githubFile, "github File");
        ui_click(githubFileEditLink, "githubFile EditLink");
		ui_setvalue(githubFileEnterValue, "File Text Area", Value);
        ui_click(githubFileCommitChanges, "github File CommitChanges");
		ui_setvalue(githubFileCommitDescription, "githubFile Commit Description", "Testing");
		ui_click(githubFileCommitChangeConfirm, "githubFile Commit Change Confirm");
        ui_click(githubMenu, "github Menu");
        //ui_click(githublogout, "github logout");
		return this;

	}
	
}