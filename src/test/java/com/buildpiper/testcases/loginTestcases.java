package com.buildpiper.testcases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.aeonbits.owner.ConfigFactory;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.buildpiper.base.BaseTest;
import com.buildpiper.pages.LoginPage;
import com.buildpiper.utils.ExcelUtility;
import com.buildpiper.utils.FrameworkConfig;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

@Listeners(com.buildpiper.report.ExtentReportListener.class)


public class loginTestcases extends BaseTest {
	
	FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);

	ExcelUtility reader = new ExcelUtility();

	@Test(groups = { "Regression" }, priority = 0)
	public void loginTest() {
		String baseurl="http://122.160.30.218:17901";
       //----------------------------------Login API-----------------------
		RequestSpecification requestSpec=RestAssured.given();
		requestSpec.baseUri(baseurl);
		requestSpec.basePath("/api/v1/user/login/");
		JSONObject logincredential=new JSONObject();
		logincredential.put("email", "opstree@opstree.com");
		logincredential.put("password", "Opstree@12345");
		requestSpec.contentType(ContentType.JSON);
		requestSpec.body(logincredential.toJSONString());
		io.restassured.response.Response res=requestSpec.post();
		String body=res.getBody().asString();
		JsonPath jsonpath=new JsonPath(body);
		String access=jsonpath.get("access");
		
		System.out.println("Status Code of login API:"+res.getStatusCode());
		
		
		//-----------------------------------PROJECT API----------------------
		
		RequestSpecification requestSpec1=RestAssured.given();
		requestSpec1.baseUri(baseurl);
		requestSpec1.basePath("/admin/api/v1/project/");
		requestSpec1
		       .header("Authorization","Bearer "+access)
		       .contentType(ContentType.JSON);
		
		io.restassured.response.Response res1=requestSpec1.get();
		String body1=res1.getBody().asString();
		
		JsonPath jsonpath1=new JsonPath(body1);
		ArrayList<String> projectname = new ArrayList<String>();
		Integer ProjectCount =null;
		ProjectCount=jsonpath1.get("count");
		 projectname=jsonpath1.get("results.name");
		
		System.out.println("Status Code of DashBoard API:"+res1.getStatusCode());
	    
	   System.out.println("Project Count:"+ProjectCount);
	    System.out.println("Project Name:"+projectname);
	    Assert.assertEquals(projectname, "");
	    Assert.assertEquals(ProjectCount, "1");
		
	}
	@Test(groups = { "Regression" }, priority = 0)
	public void fetchlogs() {
   String baseurl="http://122.160.30.218:17901";
   String Pipelinename="test23232";
   
   //----------------------------------Login API----------------------
	RequestSpecification requestSpec=RestAssured.given();
	requestSpec.baseUri(baseurl);
	requestSpec.basePath("/api/v1/user/login/");
	JSONObject logincredential=new JSONObject();
	logincredential.put("email", "opstree@opstree.com");
	logincredential.put("password", "Opstree@12345");
	requestSpec.contentType(ContentType.JSON);
	requestSpec.body(logincredential.toJSONString());
	io.restassured.response.Response res=requestSpec.post();
	String body=res.getBody().asString();
	JsonPath jsonpath=new JsonPath(body);
	String access=jsonpath.get("access");
	
	System.out.println(res.getBody().asString());
	System.out.println(res.getStatusCode());
	System.out.println(access);
	
	
	//-----------------------------------Activity API----------------
	
	RequestSpecification requestSpec2=RestAssured.given();
	requestSpec2.baseUri(baseurl);
	requestSpec2.basePath("/api/v1/project/1/pipeline/recent/activity/").param("name", Pipelinename);
	requestSpec2
	       .header("Authorization","Bearer "+access)
	       .contentType(ContentType.JSON);
	
	io.restassured.response.Response res2=requestSpec2.get();
	String body2=res2.getBody().asString();
	
	JsonPath jsonpath2=new JsonPath(body2);
	ArrayList<String> id = new ArrayList<String>();
	ArrayList<String> lasttrigger = new ArrayList<String>();
	id=jsonpath2.get("results.id");
	lasttrigger=jsonpath2.get("results.last_trigger.id");
	
	String StageinstanceidArray[]=id.toString().replace("[", "").replace("]", "").split(",");
	String lasttriggerArray[]=lasttrigger.toString().replace("[", "").replace("]", "").split(",");
	
	String triggerid=StageinstanceidArray[0];
	String stageid=lasttriggerArray[0];
	
	System.out.println(res2.getStatusCode());
	//System.out.println(res2.getBody().asString());	
	System.out.println("triggerid:"+triggerid);
	System.out.println("stageid:"+stageid);
	
	
	//-----------------------------------Stage API-----------------------------------------
		RequestSpecification requestSpec3=RestAssured.given();
		requestSpec3.baseUri(baseurl);
		requestSpec3.basePath("/api/v1/pipeline/"+triggerid+"/trigger/"+stageid+"/stage/");
		requestSpec3
		       .header("Authorization","Bearer "+access)
		       .contentType(ContentType.JSON);
		
		io.restassured.response.Response res3=requestSpec3.get();
		String body3=res3.getBody().asString();
		
		JsonPath jsonpath3=new JsonPath(body3);
		ArrayList<String> stage_instanceid = new ArrayList<String>();
		ArrayList<String> task_instanceid = new ArrayList<String>();
		stage_instanceid=jsonpath3.get("stage_instance.id");
		task_instanceid=jsonpath3.get("stage_instance.task_instance.id");
		
		
		String taskidArray[]=stage_instanceid.toString().replace("[", "").replace("]", "").split(",");
		String task_instanceidArray[]=task_instanceid.toString().replace("[", "").replace("]", "").split(",");
		
		String taskid=taskidArray[0];
		String taskinstanceid=task_instanceidArray[0];
		
		System.out.println(res3.getStatusCode());
		//System.out.println(res3.getBody().asString());	
		System.out.println("taskid:"+taskid);
		System.out.println("taskinstanceid:"+taskinstanceid);
		System.out.println("taskinstanceids:"+task_instanceid);
		
	
	//--------------------------------------Task API--------------------------------------
		Integer task1=Integer.parseInt(taskinstanceid)+1;
		Integer task2=Integer.parseInt(taskinstanceid)+2;
	String[] ar1= {taskinstanceid,task1.toString(),task2.toString()};
	for(int t=0;t<ar1.length;t++) {		   	
	RequestSpecification requestSpec4=RestAssured.given();
	requestSpec4.baseUri(baseurl);
	requestSpec4.basePath("/api/v1/pipeline/"+triggerid+"/trigger/"+stageid+"/stage/"+taskid+"/task/"+ar1[t]+"/");
	requestSpec4
	       .header("Authorization","Bearer "+access)
	       .contentType(ContentType.JSON);
	
	io.restassured.response.Response res4=requestSpec4.get();
	String body4=res4.getBody().asString();
	
	JsonPath jsonpath4=new JsonPath(body4);
	ArrayList<String> global_task_id = new ArrayList<String>();
	global_task_id=jsonpath4.get("component_task_instance.information.global_task_id");
	String global_task_idArray[]=global_task_id.toString().replace("[", "").replace("]", "").split(",");
	
	String task_id=global_task_idArray[0];
	
	System.out.println(res4.getStatusCode());
	//System.out.println(res4.getBody().asString());
	
	System.out.println("task_id:"+t+":"+task_id);

	//-----------------------------------Logs API-----------------------------------------
		RequestSpecification requestSpec5=RestAssured.given();
		requestSpec5.baseUri(baseurl);
		requestSpec5.basePath("/api/v1/default/celery/task/status/").param("task_id", task_id);
		requestSpec5
		       .header("Authorization","Bearer "+access)
		       .contentType(ContentType.JSON);
		
		io.restassured.response.Response res5=requestSpec5.get();
		String body5=res5.getBody().asString();
		
		JsonPath jsonpath5=new JsonPath(body5);
		ArrayList<String> subtask = new ArrayList<String>();
		ArrayList<String> discription = new ArrayList<String>();
		subtask=jsonpath5.get("sub_task_status.activity_sub_task");
		discription=jsonpath5.get("sub_task_status.description");
		String subtaskArray[]=subtask.toString().replace("[", "").replace("]", "").split(",");
		String discriptionArray[]=discription.toString().replace("[", "").replace("]", "").split(",");
		
		System.out.println(res5.getStatusCode());
		//System.out.println(res5.getBody().asString());
	
		if(t==0) {
			System.out.println("Build:"); 
		for (int j=0;j<subtaskArray.length;j++)
		{
			System.out.println(subtaskArray[j]+"---"+discriptionArray[j]);
			if(subtaskArray[j].contains("Cloning Repository")) {
				Assert.assertEquals(discriptionArray[j].trim(), "Successfully executed cmd");
			}
			if(subtaskArray[j].contains("Pre Hooks Executing")) {
				Assert.assertEquals(discriptionArray[j].trim(), "Successfully executed cmd");
			}
			if(subtaskArray[j].contains("Build Docker Image")) {
				Assert.assertEquals(discriptionArray[j].trim(), "Successfully executed cmd");
			}
			if(subtaskArray[j].contains("Push docker image")) {
				Assert.assertEquals(discriptionArray[j].trim(), "Successfully executed cmd");
			}
			if(subtaskArray[j].contains("Post Hooks Executing")) {
				Assert.assertEquals(discriptionArray[j].trim(), "Successfully executed cmd");
			}
			
		}
		
		}
		if(t==1) {
			System.out.println("Deploy:");	
			for (int j=0;j<subtaskArray.length;j++)
			{
				System.out.println(subtaskArray[j]+"---"+discriptionArray[j]);
				
				if(subtaskArray[j].contains("Pre Hooks Executing")) {
					Assert.assertEquals(discriptionArray[j].trim(), "Executed Successfully");
				}
				if(subtaskArray[j].contains("Load Kube Config")) {
					Assert.assertEquals(discriptionArray[j].contains("environment variable set properly for kubeconfig"), true);
				}
				if(subtaskArray[j].contains("Deployment rollout validation")) {
					Assert.assertEquals(discriptionArray[j].trim(), "Deployment Rollout successfully");
				}
				if(subtaskArray[j].contains("Post Hooks Executing")) {
					Assert.assertEquals(discriptionArray[j].trim(), "Executed Successfully");
				}
				if(subtaskArray[j].contains("Generate Manifest")) {
					Assert.assertEquals(discriptionArray[j].contains("successfully rendered template 'destination_rule.yaml' to kubernetes formatted manifest"), true);
				}
				if(subtaskArray[j].contains("Deploy Stateless app")) {
					Assert.assertEquals(discriptionArray[j].contains("stateless application was successfully deployed"), true);
				}
				
			}
			
		}
		if(t==2) {
			System.out.println("promote:");
			System.out.println(subtask+"---"+discription);
			Assert.assertEquals(subtask.contains("Tagging Image"), true);
			Assert.assertEquals(discription.contains("Successfully executed cmd"), true);
		}
		//System.out.println(map);
		ui_wait(3);
		
		}
		}
}
