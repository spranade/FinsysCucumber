#Author: swanand ranade
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@login
Feature: Login Feature

  Background: 
    When user opens the "_browser" browser
    And user enter the url "_url"

  @EndToEnd @test
  Scenario: Login Functionality for valid username and password
    Given user is on the application login page
    When user enters "dummyfm" as username
    And user enters "passw0rd" as password
    And user clicks on login button
    Then user is on the application home page
    And user gets the message starting with "Welcome" on the top

  @SmokeTest @EndToEnd
  Scenario: Login Functionality for Invalid username and password
    Given user is on the application login page
    When user enters "_username" as username
    And user enters "_password" as password
    And user clicks on login button
    Then user is on the same login page
    #Then user is on the application home page
    And user gets the message starting with "Welcome" on the bottom

  @SmokeTest @EndToEnd
  Scenario: Login Functionality for Invalid username and password
    Given user is on the application login page
    When user enters "_invUsername" as username
    And user enters "_password" as password
    And user clicks on login button
    Then user is on the same login page
    #Then user is on the application home page
    And user gets the message starting with "Wrong" on the bottom

  @SmokeTest @EndToEnd
  Scenario: Login Functionality for Invalid username and password
    Given user is on the application login page
    When user enters "_username" as username
    And user enters "_invPassword" as password
    And user clicks on login button
    Then user is on the same login page
    #Then user is on the application home page
    And user gets the message starting with "Wrong" on the bottom

  @EndToEnd
  Scenario: Login Functionality for valid username and invalid password
    Given user is on the application login page
    When user enters "dummyfm" as username
    And user enters "Password" as password
    And user clicks on login button
    Then user is on the same login page
    And user gets the message starting with "Wrong" on the bottom

  @EndToEnd
  Scenario: Login Functionality for invalid username and valid password
    Given user is on the application login page
    When user enters "dumyfm" as username
    And user enters "passw0rd" as password
    And user clicks on login button
    Then user is on the same login page
    And user gets the message starting with "Wrong" on the bottom

  @EndToEnd
  Scenario: Login Functionality for blank username and  password
    Given user is on the application login page
    When user enters "" as username
    And user enters "" as password
    And user clicks on login button
    Then user is on the same login page
    And user gets the message starting with "username and password must required" on the bottom

  @EndToEnd
  Scenario: Login Functionality by passing special characters in username and invalid password
    Given user is on the application login page
    When user enters "dummyfm%$#" as username
    And user enters "Password@#!" as password
    And user clicks on login button
    Then user is on the same login page
    And user gets the message starting with "Wrong" on the bottom

  @EndToEnd
  Scenario: Login Functionality by passing alphanumeric characters in username and invalid password
    Given user is on the application login page
    When user enters "dummyfm123" as username
    And user enters "Passw0rd3131" as password
    And user clicks on login button
    Then user is on the same login page
    And user gets the message starting with "Wrong" on the bottom
