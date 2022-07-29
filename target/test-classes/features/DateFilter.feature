Feature: Click When Filter

  Background:
    Given User login to CXP Dashboard

  @DateFilter
  Scenario: User open When filter
    When User click dateFilter
    Then User see filter
