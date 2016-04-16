Feature: Users Management 
  Scenario: User vote
  	Given I'm a user and I have logged in
    Then I choose an option
    And I confirm my choice
    Then I receive the string "Ya ha votado, no puede realizar mas votos"
    And I close the browser