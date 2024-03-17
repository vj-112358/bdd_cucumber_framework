Feature: Trigger the Del API and validate the Response body and Response Parameters

@delete
Scenario: Trigger the DEL API request with valid string Request Body Parameters
		Given Name and Job in Del Request body
		When Send the Request with Payload to the Del Endpoint
		Then Validate Del Status Code
		