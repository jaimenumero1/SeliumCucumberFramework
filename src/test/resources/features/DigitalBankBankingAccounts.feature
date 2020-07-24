Feature:
"""As a Customer, I want to add/edit/manage Bank Account Payment Profile"""

  @S1
  Scenario: As a user, I want to be able to view all details in my account home page.

    Given User navigates to Digital Bank login page
    And Verify that web title is "Digital Bank"
    When User logs in with "JohnDoe@testemail.com " and "Password1"
    Then User successfully logged in to home page
    And Verify that "Welcome John" welcoming message is displayed
    And Verify that panel with account information is displayed

  @S2
  Scenario: As a User, I want have the ability to create a new Checking bank account so that my payment can be processed from my preferred account.

    Given User navigates to Digital Bank login page
    And Verify that web title is "Digital Bank"
    When User logs in with "JohnDoe@testemail.com " and "Password1"
    Then User successfully logged in to home page
    And Verify that "Welcome John" welcoming message is displayed
    And Verify that "Checking" dropdown has following options
      | View Checking |
      | New Checking  |

  @S3
  Scenario: Checking account page validations
    Given User navigates to Digital Bank login page
    And Verify that web title is "Digital Bank"
    When User logs in with "JohnDoe@testemail.com " and "Password1"
    Then User successfully logged in to home page
    And User clicks on "Checking" account
    Then Verify "New Checking Account" header is displayed
    And  Verify "Select Checking Account Type" label is displayed
    And Verify that radio buttons are unchecked
    Then Verify "Select Account Ownership" label is displayed
    Then Verify "Account Name" label is displayed
    Then Verify "Initial Deposit Amount" label is displayed
    And Verify that "Submit" button is displayed
    And Verify that "Reset" button is displayed


  Scenario Outline: Verify the Reset button clears out filled fields
    Given User navigates to Digital Bank login page
    And Verify that web title is "Digital Bank"
    And User logs in with "JohnDoe@testemail.com " and "Password1"
    And User successfully logged in to home page
    And User clicks on "<type>" account
    When User creates "<type>" account with following info and click Reset button
      | accountType   | accountOwnership   | accountName   | initialDeposit   |
      | <accountType> | <accountOwnership> | <accountName> | <initialDeposit> |
    Then Verify that fields are reset to default values
    Examples:
      | type     | accountType       | accountOwnership | accountName  | initialDeposit |
      | Savings  | Money Market      | Joint            | Test Account | 200            |
      | Checking | Interest Checking | Individual       | Test Account | 200            |

  @S4
  Scenario: Checking account page validations without account type
    Given User navigates to Digital Bank login page
    And Verify that web title is "Digital Bank"
    And User logs in with "JohnDoe@testemail.com " and "Password1"
    And User successfully logged in to home page
    And User clicks on "Checking" account
    When User submits an account without Account Type
    Then Verify field error message "Please select one of these options." is displayed

  @S5
  Scenario: Checking account page validations without account ownership
    Given User navigates to Digital Bank login page
    And Verify that web title is "Digital Bank"
    And User logs in with "JohnDoe@testemail.com " and "Password1"
    And User successfully logged in to home page
    And User clicks on "Checking" account
    When User submits an account without Account Ownership
    Then Verify field error message "Please select one of these options." is displayed

  @S6
  Scenario: Checking account page validations without account name
    Given User navigates to Digital Bank login page
    And Verify that web title is "Digital Bank"
    And User logs in with "JohnDoe@testemail.com " and "Password1"
    And User successfully logged in to home page
    And User clicks on "Checking" account
    When User submits an account without Account Name
    Then Verify field error message "Please fill out this field." is displayed

  @S7
  Scenario: Checking account page validations without account deposit
    Given User navigates to Digital Bank login page
    And Verify that web title is "Digital Bank"
    And User logs in with "JohnDoe@testemail.com " and "Password1"
    And User successfully logged in to home page
    And User clicks on "Checking" account
    When User submits an account without Initial Deposit Amount
    Then Verify field error message "Please fill out this field." is displayed

  @S8
  Scenario Outline: Checking account page validations with Invalid account deposit
    Given User navigates to Digital Bank login page
    And Verify that web title is "Digital Bank"
    And User logs in with "JohnDoe@testemail.com " and "Password1"
    And User successfully logged in to home page
    And User clicks on "Checking" account
    When User submits an account with "<deposit>" deposit
    Then Verify field error message "<errorMsg>" is displayed
    Examples:
      | deposit | errorMsg                           |
      | abc123  | Please match the requested format. |
      | @#$1q   | Please match the requested format. |
      | 200,33  | Please match the requested format. |

  @S9
  Scenario Outline: Checking account page validations with less then minimum account deposit
    Given User navigates to Digital Bank login page
    And Verify that web title is "Digital Bank"
    And User logs in with "JohnDoe@testemail.com " and "Password1"
    And User successfully logged in to home page
    And User clicks on "Checking" account
    When User submits an account with "<deposit>" deposit
    Then Verify alert error message "The initial deposit ($<deposit>) entered does not meet the minimum amount ($25.00) required. Please enter a valid deposit amount." is displayed
    Examples:
      | deposit |
      | 24.99   |

  @S10
  Scenario: Create a checking account with valid data
    Given User navigates to Digital Bank login page
    And Verify that web title is "Digital Bank"
    And User logs in with "JohnDoe@testemail.com " and "Password1"
    And User successfully logged in to home page
    And User clicks on "Checking" account
    When User creates "Checking" account with following info:
      | accountType       | accountOwnership | accountName  | initialDeposit |
      | Interest Checking | Joint            | Test Account | 200            |
    Then Verify newly created account information


  @SavingsUserStories1
  Scenario: As a User, I want have the ability to create a new Savings bank account so that my payment can be processed from my preferred account.

    Given User navigates to Digital Bank login page
    And Verify that web title is "Digital Bank"
    When User logs in with "JohnDoe@testemail.com " and "Password1"
    Then User successfully logged in to home page
    And Verify that "Welcome John" welcoming message is displayed
    And Verify that "Savings" dropdown has following options
      | View Savings |
      | New Savings  |

  @SavingsUserStories2
  Scenario: Savings account page validations
    Given User navigates to Digital Bank login page
    And Verify that web title is "Digital Bank"
    When User logs in with "JohnDoe@testemail.com " and "Password1"
    Then User successfully logged in to home page
    When User clicks on "Savings" account
    Then Verify "New Savings Account" header is displayed
    And  Verify "Select Checking Account Type" label is displayed
    And Verify that radio buttons are unchecked
    Then Verify "Select Account Ownership" label is displayed
    Then Verify "Account Name" label is displayed
    Then Verify "Initial Deposit" label is displayed
    And Verify that "Submit" button is displayed
    And Verify that "Reset" button is displayed


  @SavingsUserStories3
  Scenario: Savings account page validations without account type
    Given User navigates to Digital Bank login page
    And Verify that web title is "Digital Bank"
    And User logs in with "JohnDoe@testemail.com " and "Password1"
    And User successfully logged in to home page
    When User clicks on "Savings" account
    When User submits an account without Account Type
    Then Verify field error message "Please select one of these options." is displayed

  @SavingsUserStories4
  Scenario: Savings account page validations without account ownership
    Given User navigates to Digital Bank login page
    And Verify that web title is "Digital Bank"
    And User logs in with "JohnDoe@testemail.com " and "Password1"
    And User successfully logged in to home page
    When User clicks on "Savings" account
    When User submits an account without Account Ownership
    Then Verify field error message "Please select one of these options." is displayed

  @SavingsUserStories5
  Scenario: Savings account page validations without account name
    Given User navigates to Digital Bank login page
    And Verify that web title is "Digital Bank"
    And User logs in with "JohnDoe@testemail.com " and "Password1"
    And User successfully logged in to home page
    When User clicks on "Savings" account
    When User submits an account without Account Name
    Then Verify field error message "Please fill out this field." is displayed

  @SavingsUserStories6
  Scenario: Savings account page validations without account deposit
    Given User navigates to Digital Bank login page
    And Verify that web title is "Digital Bank"
    And User logs in with "JohnDoe@testemail.com " and "Password1"
    And User successfully logged in to home page
    When User clicks on "Savings" account
    When User submits an account without Initial Deposit Amount
    Then Verify field error message "Please fill out this field." is displayed

  @SavingsUserStories7
  Scenario Outline: Savings account page validations with Invalid account deposit
    Given User navigates to Digital Bank login page
    And Verify that web title is "Digital Bank"
    And User logs in with "JohnDoe@testemail.com " and "Password1"
    And User successfully logged in to home page
    When User clicks on "Savings" account
    When User submits an account with "<deposit>" deposit
    Then Verify field error message "<errorMsg>" is displayed
    Examples:
      | deposit | errorMsg                           |
      | abc123  | Please match the requested format. |
      | @#$1q   | Please match the requested format. |
      | 200,33  | Please match the requested format. |

  @SavingsUserStories8
  Scenario Outline: Savings account page validations with less then minimum account deposit
    Given User navigates to Digital Bank login page
    And Verify that web title is "Digital Bank"
    And User logs in with "JohnDoe@testemail.com " and "Password1"
    And User successfully logged in to home page
    When User clicks on "Savings" account
    When User submits an account with "<deposit>" deposit
    Then Verify alert error message "The initial deposit ($<deposit>) entered does not meet the minimum amount ($2500.00) required. Please enter a valid deposit amount." is displayed
    Examples:
      | deposit |
      | 150.22  |

  @SavingsUserStories10
  Scenario: Create a Savings account with valid data
    Given User navigates to Digital Bank login page
    And Verify that web title is "Digital Bank"
    And User logs in with "JohnDoe@testemail.com " and "Password1"
    And User successfully logged in to home page
    When User clicks on "Savings" account
    When User creates "Savings" account with following info:
      | accountType  | accountOwnership | accountName  | initialDeposit |
      | Money Market | Joint            | Test Account | 2500           |
    Then Verify newly created account information