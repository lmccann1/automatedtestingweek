
Feature: Searching for terms
As a User
I want to search for a particular term
So that I can see information about it

	Scenario: Search Google for term
	Given I go to www.google.com
	When I search for "dogs"
	Then I am taken to a list of data for that search