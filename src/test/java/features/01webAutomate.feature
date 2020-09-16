@tag1 
Feature: Web Automate NDTV Weather Report 

Scenario: Get the details 

	Given Launch NDTV web Page 
	When Reach the weather section 
	And Use the 'Pin your city' section, Select Bangalore city 
	Then Store city with temperature information 
	
	
