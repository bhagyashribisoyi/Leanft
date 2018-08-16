
Feature: Log into ORMS application and search OverPayment

@login
   Scenario Outline: Search a OverPayment
    
    
      When User makes a search with data present in ORMS excel sheet "<Data_ID>"
   

    Examples:
    | Row_Index  |
    | TD001       |
    | TD002       |
    | TD003       |




   