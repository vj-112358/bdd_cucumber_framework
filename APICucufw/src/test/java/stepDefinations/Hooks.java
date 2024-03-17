package stepDefinations;

import java.io.File;
import java.io.IOException;

import Common_Methods.Utility;
import Repository.Environment;
import Repository.RequestBody;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	public static File dir_name;
	public static String Endpoint;
	public static String requestBody;
	

	public static Scenario scenario;

	@Before
    public void beforeScenario(Scenario scenario) {
        this.scenario = scenario;
    }
	@Before("@post")
    public void beforeScenariopost() throws IOException{
		dir_name = Utility.CreateLogDirectory("Post_API_Logs");
		requestBody = RequestBody.req_post_tc("Post_TC1");
		Endpoint = Environment.Hostname() + Environment.Resource_create();
    }
	
		
	@Before("@put")
    public void beforeScenarioput() throws IOException{
		dir_name = Utility.CreateLogDirectory("Put_API_Logs");
		requestBody = RequestBody.req_put_tc("Put_TC1");
		Endpoint = Environment.Hostname() + Environment.Resource_Put();
    }
	@Before("@patch")
    public void beforeScenariopatch() throws IOException{
		dir_name = Utility.CreateLogDirectory("Patch_API_Logs");
		requestBody = RequestBody.req_put_tc("Patch_TC1");
		Endpoint = Environment.Hostname() + Environment.Resource_Patch();
    }
	@Before("@delete")
    public void beforeScenariodelete() throws IOException{
		dir_name = Utility.CreateLogDirectory("Delete_API_Logs");
		requestBody = RequestBody.req_delete_tc("Delete_TC1");
		Endpoint = Environment.Hostname() + Environment.Resource_Delete() + Hooks.requestBody;
    }	
	@Before("@get")
    public void beforeScenarioget() throws IOException{
		dir_name = Utility.CreateLogDirectory("Get_API_Logs");
		requestBody = RequestBody.req_get_tc("Get_TC1");
		Endpoint = Environment.Hostname() + Environment.Resource_get() + requestBody;
    }
}