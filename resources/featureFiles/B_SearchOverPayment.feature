@OverPayment
Feature: Log into ORMS application and search OverPayment

@OverPayment
  Scenario Outline: Search an OverPayment and verify that result is displayed
    
    Given User Selects Search option under Overpayment
    When User makes a search with data present in excel sheet "<Data_ID>"
    Then OverPayment details should be displayed for "<Data_ID>"
    And User returns to Home Page

    Examples:
    | Data_ID|
    | TD001  |
    | TD002  |

    @OverPayment
    Scenario Outline: Search an OverPayment and verify that result is not displayed
    
    Given User Selects Search option under Overpayment
    When User makes a search with data present in excel sheet "<Data_ID>"
    Then OverPayment details should not  be displayed for "<Data_ID>"
    And User returns to Home Page

    Examples:
    | Data_ID|
    | TD004  |
    
 


   