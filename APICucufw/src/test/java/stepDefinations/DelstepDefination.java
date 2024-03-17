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

public class DelstepDefination {
	int statuscode;
	String responsebody;
	Response response;
	JsonPath jsp_req;
	String res_id;
	String res_createdAt;
	String res_email;
	String res_first_name;
	String res_last_name;
	String res_avatar;
	ResponseBody res_body;

	@Given("Name and Job in Del Request body")
	public void name_and_job_in_Del_request_body() throws IOException {
		Response response = API_Trigger.Delete_trigger(Hooks.Endpoint);
		Utility.evidenceFileCreator(Utility.testLogName("del_tc_01"), Hooks.dir_name, Hooks.Endpoint, Hooks.requestBody,
				response.getHeader("Date"), response.getBody().asString());
		statuscode = response.statusCode();
//    throw new io.cucumber.java.PendingException();
	}

	@When("Send the Request with Payload to the Del Endpoint")
	public void send_the_request_with_payload_to_the_Del_endpoint() {

	}

		

	@Then("Validate Del Status Code")
	public void validate_Del_status_code() {
		Assert.assertEquals(statuscode, 204);
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
	}
}