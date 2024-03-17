package stepDefinations;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import org.testng.Assert;

import Common_Methods.API_Trigger;
import Common_Methods.Utility;
import Repository.Environment;
import Repository.RequestBody;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class PatchstepDefination {
	int statuscode;
	String responsebody;
	Response response;
	JsonPath jsp_req;
	String req_name;
	String req_job;
	String res_name;
	String res_job;
	String res_id;
	String res_updatedAt;

	@Given("Name and Job in Patch Request body")
	public void name_and_job_in_request_body() throws IOException {
		response = API_Trigger.Patch_trigger(RequestBody.HeaderName(), RequestBody.HeaderValue(),
				Hooks.requestBody, Hooks.Endpoint);
		Utility.evidenceFileCreator(Utility.testLogName("Patch_TC_01"), Hooks.dir_name, Hooks.Endpoint, Hooks.requestBody,
				response.getHeader("Date"), response.getBody().asString());
		statuscode = response.statusCode();
//    throw new io.cucumber.java.PendingException();
	}

	@When("Send the Request with Payload to the Patch Endpoint")
	public void send_the_request_with_payload_to_the_endpoint() {

		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
		ResponseBody res_body = response.getBody();
		res_name = res_body.jsonPath().getString("name");
		res_job = res_body.jsonPath().getString("job");
		res_id = res_body.jsonPath().getString("id");
		//res_updatedAt = res_body.jsonPath().getString("updatedAt");
		//res_updatedAt = res_updatedAt.substring(0, 11);

		// throw new io.cucumber.java.PendingException();
	}

	@Then("Validate Patch Status Code")
	public void validate_status_code() {
		Assert.assertEquals(statuscode, 200);
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
	}

	@Then("Validate Patch Response Body Parameters")
	public void validate_response_body_parameters() {
		// Write code here that turns the phrase above into concrete actions
		jsp_req = new JsonPath(Hooks.requestBody);
		req_name = jsp_req.getString("name");
		req_job = jsp_req.getString("job");
		LocalDateTime currentdate = LocalDateTime.now();
		String expecteddate = currentdate.toString().substring(0, 11);
		Assert.assertEquals(res_name, req_name);
		Assert.assertEquals(res_job, req_job);
		//Assert.assertEquals(res_updatedAt, expecteddate);
		//Assert.assertEquals(res_createdAt, expecteddate);
		// throw new io.cucumber.java.PendingException();
	}
}