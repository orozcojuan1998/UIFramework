Feature: Register
  As a user i want to register
  in the web page to perfom actions

  Scenario: Test invalid register without cellphone
    Given The user is in the register form
    When The user tries to register with invalid cellphone
    Then The user stays in the same page and is informed that cellphone is required

