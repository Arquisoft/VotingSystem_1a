Feature: Mesa Management 
  Scenario: Mesa vote
  	Given I'm a member of the polling station and I have logged in
    Then I fill the DNI field writing "54313432L"
    And I click the comprueba button
    Then I receive the string "Se ha registrado el votante con éxito"
    And I close the browser