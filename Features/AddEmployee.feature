#Author: your.email@your.domain.com
#Keywords Summary :



Feature: Add Employee
  I want to use this template for Add Employee feature verification

  
  Scenario: Add Employee
     Given The Url to Browser
    And Provided "Admin" and "admin123"
    When Appliaion is loaded verify the Homepage
    And Click on add button
    Then user in Add Employee form
    And enter "Naresh" as first name and "Busireddy" as last name
    And click on save button
    Then Verify user added cconfirmation
   
    

