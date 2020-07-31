Feature: Checking account

  Background:
    Given User navigates to Digital Bank login page
    When User logs in with "JohnDoe@testemail.com" and "Password1"
    Then User successfully logged in to home page

  Scenario: User is able to create a new checking account
    When User navigates to new Checking account page
    And User creates checking account with following fields
      | type      | ownershipType  | accountName   | initDeposit |
      | Standard  | Joint          | Test Name     | 20000       |
    Then User should be able to see a new account created
    And Account information is matching


  Scenario: HomePage basic Validation
    Given user successfully logged in
    When user creates account