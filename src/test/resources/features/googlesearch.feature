Feature: Google Search
  Scenario: Searching for a keyword
    Given I am on the Google homepage
    When I enter the keyword "Youtube" in the search box
    And I click the search button
    Then I should see search results related to "Youtube"
