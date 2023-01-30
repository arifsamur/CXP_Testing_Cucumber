
Feature: Login to CX-P Professional Organization Dashboard as a Surgeon from Professional Organization Persona
  User Story: A Surgeon login to CX-P Dashboard

  Background:
    Given User go to login page

  @Surgeon_Pro_Org
  Scenario: Surgeon navigate to Pro_Org Dashboard
    When Surgeon login to Pro_Org dashboard
    Then Surgeon see My Assessments
