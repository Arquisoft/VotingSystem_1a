Feature: Mesa Management 
  Scenario: Mesa login
  	Given I'm a member of the polling station and on the /loginMesa.xhtml page
  	Then I fill the ID field writing "1"
  	And I fill the Password field writing "pas1"
    And I click the login button
    Then I receive the string "DNI del votante"
    And I close the browser