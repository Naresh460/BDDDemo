#Author: your.email@your.domain.com
#Keywords Summary :

Feature: Verify PIM feature
  I want to use this template for my feature file
  
  Scenario Outline: Verify the PIM Add functioality
    Given user in login Page
    When enter username and password and loggedin
    Then verify Homepage
    And user clicked on Add btton
    And enter the Employee firstname "<fname>" and lastname "<lname>" and EmployeeId "<employeeID>"
    And click on save button
    
    Examples:
    |fname|lname|employeeID|
|test1|test|111111|


 
  Scenario: Verify the PIM search functioality
    Given user in login Page
    When enter username and password and loggedin
    Then verify Homepage
    And enter id "111111" in the EmployeeId box
    And click on search buton
    Then I validate the outcomes
    

  