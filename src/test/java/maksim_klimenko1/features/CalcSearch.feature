Feature: Calc Search


  Scenario Outline: Checking search on calc page
   Given I opened new page
    And  I move to product page
    And  I move to pricing page
    And  I Select calc
    When I Write "<search>"
    Then I Check result "<result>"

    Examples:
      | search     | result                         |
      | Networking | Google Cloud Network Bandwidth |
      | Cloud Run  | Cloud Run                      |