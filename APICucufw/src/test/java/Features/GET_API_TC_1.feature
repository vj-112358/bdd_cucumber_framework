Feature: Trigger the Get API and validate the Response body and Response Parameters

@get
Scenario: Trigger the GET API request with valid string Request Body Parameters
		Given Name and Job in get Request body
		When Send the Request with Payload to the get Endpoint
		Then Validate get Status Code
		And Validate get Response Body Parameters
		