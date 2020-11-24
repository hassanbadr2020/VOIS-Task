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