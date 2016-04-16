Feature: Users Management 
  Scenario: User login
  	Given I'm a user and on the /login.xhtml page
  	Then I fill the User DNI field writing "75443827R"
  	And I fill the Password field writing "f6FVZov56c"
    And I click the login button
    Then I receive the string "Partidos Disponibles"
    And I close the browser