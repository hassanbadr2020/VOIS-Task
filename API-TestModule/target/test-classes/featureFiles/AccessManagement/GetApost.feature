@getAPost
Feature: Get a post with a post id

  @HappyScenario
  Scenario Outline: User try to get a post with the id of the post
    Given user send a request to get post with valid "<id>"
    Then status code is "200"
    And response body matches "JsonSchemas/PostBody.json" in Api contract
    Examples:
      | id |
      | 1  |
      | 2  |

  @NegativeScenarios
  Scenario Outline: User try to get a post with the invalid id of the post
    Given user send a request to get post with valid "<id>"
    Then status code is "404"
    And response body is empty
    Examples:
      | id  |
      | 0   |
      | 101 |
      | jk  |