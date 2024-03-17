Feature: Trigger Post API on the basis of Input Data
@DataDriven
Scenario Outline: Trigger the DDT Post API request with valid request Parameters
		Given "<Name>" and "<Job>" in Request body
		When Send the Request with Payload to the Endpoint
		Then Validate Status Code
		And Validate Response Body Parameters

Examples: 

		|Name |Job |
		|Jarvis|Engg|
		|raster|graphics|
		|big|elephant|
				