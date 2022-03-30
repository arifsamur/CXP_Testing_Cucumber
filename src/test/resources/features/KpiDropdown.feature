@CXP_login
Feature: Login to CX-P Dashboard
  User Story: An authorized user should be able to login to CX-P Dashboard with valid credentials

  Background:
    Given User open login page

  @KPI
  Scenario: User login to Dashboard
    When User deselect all KPIs
    Then User see no KPI


