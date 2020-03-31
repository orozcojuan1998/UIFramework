Feature: Login
  As a user i want to login
  to buy products in the page


  Scenario: Test succesful login
    Given The user is in the Falabella homepage
    When The the user tries to login with its data
      | email                     | password |
      | testjuanorozco5@gmail.com | test1234 |
    Then The user is signed in

  Scenario: Test unsuccesful login password
    Given The user is in the Falabella homepage
    When The the user tries to login with its data
      | email                     | password  |
      | testjuanorozco2@gmail.com | test12345 |
    Then The user stays in the same page and is informed that credentials are wrong

  Scenario: Test unsuccesful login email
    Given The user is in the Falabella homepage
    When The the user tries to login with its data
      | email                        | password |
      | testjuanorozco78@gmail.com | test1234 |
    Then The user stays in the same page and is informed that credentials are wrong

  Scenario: Test successful log out
    Given The user is in the application home page logged in
    When The user hover on the account button and clicks the log out button
    Then The user is logout from the web page





