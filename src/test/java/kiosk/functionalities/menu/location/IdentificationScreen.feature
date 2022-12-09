Feature: Client Identification

  Scenario: None identification
    Given Go to url "https://srv-0002.uat.tabesto.com/"
    When User login as admin
    Then User will be redirect to "menu/food/list"
    When User click on menuItem "Administration"
    And User click on submenu "Champs de config"
    And User select "aucune" as client identification
    And User click on button "SAUVEGARDER"
    When Kiosk app is launched
    And User click on debug mode
    And User set "https://srv-0003.uat.tabesto.com/" as server url
    And User click on Ok button
    And User touch "TOUCHER POUR COMMENCER"
    Then Home screen of kiosk app is displayed

  Scenario: Buzzer identification
    Given Go to url "https://srv-0002.uat.tabesto.com/"
    When User login as admin
    Then User will be redirect to "menu/food/list"
    When User click on menuItem "Administration"
    And User click on submenu "Champs de config"
    And User select "bipeur" as client identification
    And User click on button "SAUVEGARDER"
    When Kiosk app is launched
    And User click on debug mode
    And User set "https://srv-0003.uat.tabesto.com/" as server url
    And User click on Ok button
    And User touch "TOUCHER POUR COMMENCER"
    Then "bipeur" screen is displayed
    When User set numero 3
    And User choose "SUR PLACE"
    Then Home screen of kiosk app is displayed

  Scenario: Name identification
    Given Go to url "https://srv-0002.uat.tabesto.com/"
    When User login as admin
    Then User will be redirect to "menu/food/list"
    When User click on menuItem "Administration"
    And User click on submenu "Champs de config"
    And User select "name" as client identification
    And User click on button "SAUVEGARDER"
    When Kiosk app is launched
    And User click on debug mode
    And User set "https://srv-0003.uat.tabesto.com/" as server url
    And User click on Ok button
    And User touch "TOUCHER POUR COMMENCER"
    Then Name screen of kiosk app is displayed
    When User set his firstname "Test Fisrt"
    And User choose "SUR PALCE"
    Then Home screen of kiosk app is displayed