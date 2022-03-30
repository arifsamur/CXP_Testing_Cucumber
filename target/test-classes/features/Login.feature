
Feature: Login to CX-P Dashboard
  User Story: An authorized user should be able to login to CX-P Dashboard with valid credentials

  Background:
    Given User open login page

  @Surgeon
  Scenario: User navigate to Dashboard
    When User login as Surgeon
    Then User ported to dashboard
    And User see Cases

