Feature: Login to CX-P Dashboard
  User Story: An authorized user should be able to login to CX-P Dashboard and see all KPIs.

  Background:
    Given User navigate to login page

  @KPI
  Scenario: User login to Dashboard
    When User deselect all KPIs
    Then User see no KPI


