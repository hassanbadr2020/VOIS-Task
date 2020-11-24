@GetAllPosts
Feature: User Get All Post

  Scenario: User Try to get All posts
    Given User send a get request to list all posts
    Then status code is "200"
    And the number of Posts is "100"
    And response body matches "JsonSchemas/ListOfPosts.json" in Api contract