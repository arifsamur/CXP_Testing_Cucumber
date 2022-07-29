
Feature: Login to CX-P Dashboard as a Surgeon Persona
  User Story: A Surgeon login to CX-P Dashboard

  Background:
    Given User open login page

  @Surgeon
  Scenario: Surgeon navigate to Dashboard
    When Surgeon login to dashboard
    Then Surgeon see main menu
    And Surgeon see cases
