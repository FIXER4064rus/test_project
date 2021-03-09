Feature: Language Check

  Background: Driver setup
    Given Create new driver

  Scenario: Checking different language option

    Given I opened page
    And  I check ENG language
    When  I switch language
    Then  I check GER language
    And  Shutdown