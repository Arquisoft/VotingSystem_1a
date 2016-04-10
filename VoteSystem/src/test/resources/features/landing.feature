Feature: landing page 
  Scenario: client makes call to GET /
    When the client calls /login.xhtml
    Then the client receives status code of 200
    And the client receives the string "Login"