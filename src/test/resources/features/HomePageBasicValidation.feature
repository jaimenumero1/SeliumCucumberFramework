Feature: Homepage basic validation

  Background:
    Given user successfully logged into his account

  Scenario: Welcome message Validation
    Then welcome message should be displayed

    Scenario: Banking Accounts validation
      Then Banking Accounts part
