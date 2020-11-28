@login
Feature: User Login

  Scenario Outline: User try to login with valid email and password
    Given  A user in the home page
    And    click on the signIn button
    When   user enter name and password in fields "<email>" "<password>"
    And    click on the login button
    Then   I'm in the home page
    Examples:
      | email        | password  |
      | mmmm@mmm.com | Aa123456@ |

  Scenario Outline: User try to login with invalid credentials
    Given  A user in the home page
    And    click on the signIn button
    When   user enter name and password in fields "<email>" "<password>"
    And    click on the login button
    Then   In "login" system displays an error message says "<errorMessage>"
    Examples:
      | email        | password  | errorMessage               |
      #Valid Email and invalid Password
      | mmmm@mmm.com | Aa123456  | Authentication failed.     |
      #Invalid Email and valid Password
      | mmm@mmm.com  | Aa123456@ | Authentication failed.     |
      #Valid Email and missing password
      | mmmm@mmm.com |           | Password is required.      |
      #Missed Email and Valid password
      |              | Aa123456@ | An email address required. |

