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

public class GetstepDefination {
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

	@Given("Name and Job in get Request body")
	public void name_and_job_in_get_request_body() throws IOException {
		Response response = API_Trigger.Get_trigger(Hooks.Endpoint);
		res_body = response.getBody();
		Utility.evidenceFileCreator(Utility.testLogName("get_tc_01"), Hooks.dir_name, Hooks.Endpoint, Hooks.requestBody,
				response.getHeader("Date"), response.getBody().asString());
		statuscode = response.statusCode();
//    throw new io.cucumber.java.PendingException();
	}

	@When("Send the Request with Payload to the get Endpoint")
	public void send_the_request_with_payload_to_the_get_endpoint() {

		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
		
		res_id=res_body.jsonPath().getString("data.id");
		res_email=res_body.jsonPath().getString("data.email");
		res_first_name=res_body.jsonPath().getString("data.first_name");
		res_last_name=res_body.jsonPath().getString("data.last_name");
		res_avatar=res_body.jsonPath().getString("data.avatar");
		// throw new io.cucumber.java.PendingException();
	}

	@Then("Validate get Status Code")
	public void validate_get_status_code() {
		Assert.assertEquals(statuscode, 200);
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
	}

	@Then("Validate get Response Body Parameters")
	public void validate_get_response_body_parameters() {
		// Write code here that turns the phrase above into concrete actions
		String exp_id="[7, 8, 9, 10, 11, 12]";
		String exp_email="[michael.lawson@reqres.in, lindsay.ferguson@reqres.in, tobias.funke@reqres.in, byron.fields@reqres.in, george.edwards@reqres.in, rachel.howell@reqres.in]";
		String exp_first_name="[Michael, Lindsay, Tobias, Byron, George, Rachel]";
		String exp_last_name="[Lawson, Ferguson, Funke, Fields, Edwards, Howell]";
		String exp_avatar="[https://reqres.in/img/faces/7-image.jpg, https://reqres.in/img/faces/8-image.jpg, https://reqres.in/img/faces/9-image.jpg, https://reqres.in/img/faces/10-image.jpg, https://reqres.in/img/faces/11-image.jpg, https://reqres.in/img/faces/12-image.jpg]";
		Assert.assertEquals(res_id, exp_id);
		Assert.assertEquals(res_email,exp_email );
		Assert.assertEquals(res_first_name, exp_first_name);
		Assert.assertEquals(res_last_name, exp_last_name);
		Assert.assertEquals(res_avatar, exp_avatar);
		// throw new io.cucumber.java.PendingException();
	}
}