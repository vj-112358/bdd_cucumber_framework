Feature: Trigger the Post API and validate the Response body and Response Parameters
@post
Scenario: Trigger the POST API request with valid string Request Body Parameters
		Given Name and Job in Request body
		When Send the Request with Payload to the Endpoint
		Then Validate Status Code
		And Validate Response Body Parameters
		