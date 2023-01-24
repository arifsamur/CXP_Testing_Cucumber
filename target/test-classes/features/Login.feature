Feature: Login to CX-P Dashboard
  User Story: Any authorized user should be able to login to CX-P Dashboard with valid credentials

  Background:
    Given User open login page

  @Smoke
  Scenario Outline: User navigate to Dashboard
    When User login as "<Persona>" with credentials "<Username>" and "<Password>"
    Then User ported to dashboard

    Examples:
      |Persona        |Username                       |Password  |
      |Surgeon        |surgeon@caresyntax.com         |C@r3synt@x|
      |Hospitaladmin  |hospitaladmin@caresyntax.com   |C@r3synt@x|
      |CXadmin        |cxadmin@caresyntax.com         |C@r3synt@x|
      |Medtech        |medtech@caresyntax.com         |C@r3synt@x|