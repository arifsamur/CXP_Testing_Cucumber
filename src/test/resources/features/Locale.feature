
Feature: Login to CX-P Dashboard
  User Story: An authorized user should be change locale

  Background:
    Given User login to CXP



    @Locale
    Scenario: User see locale
      When User navigate to Settings
      Then User click General
      And User see Locale


