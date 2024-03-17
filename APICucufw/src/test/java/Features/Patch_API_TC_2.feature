Feature: Trigger the Patch API and validate the Response body and Response Parameters
@put
Scenario: Trigger the Patch API request with valid string Request Body Parameters
		Given Name and Job in Patch Request body
		When Send the Request with Payload to the Patch Endpoint
		Then Validate Patch Status Code
		And Validate Patch Response Body Parameters
		