package stepDefinations;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import org.testng.Assert;

import Common_Methods.API_Trigger;
import Common_Methods.Utility;
import Repository.Environment;
import Repository.RequestBody;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class PoststepDefination {
	int statuscode;
	String responsebody;
	Response response;
	JsonPath jsp_req;
	String req_name;
	String req_job;
	String res_name;
	String res_job;
	String res_id;
	String res_createdAt;
	
	 
	@Given("{string} and {string} in Request body")
	public void and_in_request_body(String name, String job) throws IOException {
		Hooks.dir_name = Utility.CreateLogDirectory("Post_API_Logs");
		Hooks.requestBody = "{\r\n" + "    \"name\": \"" + req_name + "\",\r\n" + "    \"job\": \"" + req_job + "\"\r\n"
				+ "}";
		Hooks.Endpoint = Environment.Hostname() + Environment.Resource_create();
		response = API_Trigger.Post_trigger(RequestBody.HeaderName(), RequestBody.HeaderValue(), Hooks.requestBody, Hooks.Endpoint);
		Utility.evidenceFileCreator(Utility.testLogName("Post_TC1"), Hooks.dir_name, Hooks.Endpoint, Hooks.requestBody,
				response.getHeader("Date"), response.getBody().asString());
		statuscode = response.statusCode();
		
	}

	
	
	@Given("Name and Job in Request body")
	public void name_and_job_in_request_body() throws IOException {
		response = API_Trigger.Post_trigger(RequestBody.HeaderName(), RequestBody.HeaderValue(), Hooks.requestBody, Hooks.Endpoint);
		Utility.evidenceFileCreator(Utility.testLogName("Post_TC1"), Hooks.dir_name, Hooks.Endpoint, Hooks.requestBody,
				response.getHeader("Date"), response.getBody().asString());
		statuscode = response.statusCode();

	}

	@When("Send the Request with Payload to the Endpoint")
	public void send_the_request_with_payload_to_the_endpoint() {

		ResponseBody res_body = response.getBody();
		res_name = res_body.jsonPath().getString("name");
		res_job = res_body.jsonPath().getString("job");
		res_id = res_body.jsonPath().getString("id");
		res_createdAt = res_body.jsonPath().getString("createdAt");
		res_createdAt = res_createdAt.substring(0, 11);

		// throw new io.cucumber.java.PendingException();
	}

	@Then("Validate Status Code")
	public void validate_status_code() {
		Assert.assertEquals(statuscode, 201);

	}

	@Then("Validate Response Body Parameters")
	public void validate_response_body_parameters() {
		jsp_req = new JsonPath(Hooks.requestBody);
		req_name = jsp_req.getString("name");
		req_job = jsp_req.getString("job");
		LocalDateTime currentdate = LocalDateTime.now();
		String expecteddate = currentdate.toString().substring(0, 11);
		Assert.assertEquals(response.statusCode(), 201);
		Assert.assertEquals(res_name, req_name);
		Assert.assertEquals(res_job, req_job);
		Assert.assertNotNull(res_id);
		//Assert.assertEquals(res_createdAt, expecteddate);

	}
}