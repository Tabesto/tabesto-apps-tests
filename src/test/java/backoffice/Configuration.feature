Feature: Change default configuration

  Scenario: Edit fields presentation
    Given User set "srv-3.uat.tabesto.com" as server url
    When User click on menuItem "Administration"
    And User click on submenu "Champs de config"
    And User remove logo
    And User edit address
    And User


  Scenario: Activate multilingual
    Given User set "srv-3.uat.tabesto.com" as server url
    When User click on menuItem "Administration"
    And User click on submenu "Champs de config"
    And User activate option multilingual
    Then (texte)


  Scenario: Edit tech section
    Given User set "srv-3.uat.tabesto.com" as server url
    And User click on menuItem "Administration"
    And User click on submenu "Champs de config"
    And User change default theme color
    And Kiosk app is synchronized
    Then Theme color for kiosk app is changed
