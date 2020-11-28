@CreatePost
Feature: user create a post

  Scenario Outline: User try to create a post with valid data
    Given I send post request with valid credentials
      | title   | body   | userId   |
      | <title> | <body> | <userId> |
    Then status code is "<statusCode>"
    And  the users id of the created body is "<userId>"
    And  response body matches "JsonSchemas/PostBody.json" in Api contract
    Examples:
      | title | body        | userId | statusCode |
      | Test  | RestAssured | 10     | 201        |



