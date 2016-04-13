Feature: Users Management 
  Scenario: User login
  	Given I'm a user and on the /login.xhtml page
  	Then I fill the DNI field
  	And I fill the Password field
    And I click the login button
    Then I receive status code of 200
    And  I receive the string "Cerrar Sesion"