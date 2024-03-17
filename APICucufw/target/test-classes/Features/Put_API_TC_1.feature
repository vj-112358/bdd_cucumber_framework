Feature: Trigger the Put API and validate the Response body and Response Parameters
@put
Scenario: Trigger the PUT API request with valid string Request Body Parameters
		Given Name and Job in Put Request body
		When Send the Request with Payload to the Put Endpoint
		Then Validate Put Status Code
		And Validate Put Response Body Parameters
		