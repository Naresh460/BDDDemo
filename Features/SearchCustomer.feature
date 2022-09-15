#Author: your.email@your.domain.com
#Keywords Summary :



Feature: Search Employee Information
  
    Scenario: Search Employee Information
    Given The Url to Browser
    And Provided "Admin" and "admin123"
    When Appliaion is loaded verify the Homepage
    And enter the keyword "na" in the search box
    Then click on search icon