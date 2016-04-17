Feature: Users Management 
  Scenario: User login
  	Given I'm a user and on the /login.xhtml page
  	Then I fill the User DNI field writing "45443827R"
  	And I fill the Password field writing "fcW3i1ciT8"
    And I click the login button
    Then I receive the string "Partidos Disponibles"
    And I close the browser