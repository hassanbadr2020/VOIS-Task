@registration
Feature: Registration

  Scenario Outline: User try to create an account with valid data
    Given A user in the home page
    And   click on the signIn button
    And   Redirected to the login page
    When  Enter email valid "<email>"
    And   Click on the Create An Account button
    And   Redirected to continue registration page
    And   Fill all the required fields of personal information section "<gender>" , "<firstName>", "<lastName>" ,"<password>" and data of birth is "<day>", "<month>" and "<year>" and "<newsletter>" and "<option>"
    And   Fill all the required fields of the your Address section "<address>", "<city>", "<state>", "<zipCode>", "<Country>", "<mobilePhone>" and "<alias>"
    And   click on Register button
    Then  the account has been created successfully
    Examples:
      | email          | gender | firstName | lastName | password | day | month | year | newsletter | option | address   | city  | state   | zipCode | Country       | mobilePhone | alias |
      | FakerGenerated | male   | Test      | Test     | 123456   | 27  | 5     | 2010 | 1          | 0      | CairoTest | Cairo | Alabama | 12345   | United States | 0112345698  | Test  |



