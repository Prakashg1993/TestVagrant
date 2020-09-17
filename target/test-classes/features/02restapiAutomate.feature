@tag2 
Feature: Get value from api call 

Scenario: get weather details for City 

	Given set api call for weather 
	When hit the api call 
	Then get the responce into object class 
