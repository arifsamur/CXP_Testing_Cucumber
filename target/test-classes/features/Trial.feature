
Feature: Trying new locators or methods whether they are working


  Background:
    Given User open login page

  @qa
  Scenario: User navigate to Dashboard
    When User login to dashboard
    Then User see dashboard

