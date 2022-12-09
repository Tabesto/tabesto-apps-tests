Feature: Food categories

  Scenario: Verify menu details
    Given Kiosk app is launched
    And Url server is configured
    When User touch "TOUCHER POUR COMMENCER"
    And User set his firstname "Test Fisrt"
    And User click on validate button
    And User choose "SUR PLACE"
    And User select category ""
    When Go to url "https://srv-0002.uat.tabesto.com/"
    And User login as admin
    Then User will be redirect to "menu/food/list"
    When User click on submenu "Liste des produits"
    And User search product for category ""
    Then All product for category "" are present in screen
    And verify description, price and image

  Scenario: Verify food details
    Given Kiosk app is launched
    And Url server is configured
    When User touch "TOUCHER POUR COMMENCER"
    And User set his firstname "Test Fisrt"
    And User click on validate button
    And User choose "SUR PLACE"
    And User select category ""
    And User choose food product ""
    Then Food product screen "" is displayed
    When Go to url "https://srv-0002.uat.tabesto.com/"
    And User login as admin
    Then User will be redirect to "menu/food/list"
    When User click on submenu "Liste des produits"
    And User select product ""
    Then all details for product "" exist on product screen
    When User click on "retour" button
    Then Home screen of kiosk app is displayed

  Scenario: Verify drink details
    Given Kiosk app is launched
    And Url server is configured
    When User touch "TOUCHER POUR COMMENCER"
    And User set his firstname "Test Fisrt"
    And User click on validate button
    And User choose "SUR PLACE"
    And User click on "Les boissons"
    When Go to url "https://srv-0002.uat.tabesto.com/"
    And User login as admin
    Then User will be redirect to "menu/food/list"
    When User click on submenu "Liste des produits"
    And User click on category "Boissons"
    Then All drinks in back-office exist on screen
    And User select drink ""
    Then Drink product screen "" is displayed
    Then all details for drink "" in back_office exist on product screen
    When User click on "retour" button
    Then Drinks screen of kiosk app is displayed

  Scenario: Modify availability of product in back-office
    Given Kiosk app is launched
    And Url server is configured
    When User touch "TOUCHER POUR COMMENCER"
    And User set his firstname "Test Fisrt"
    And User click on validate button
    And User choose "SUR PLACE"
    And User select category ""
    When Go to url "https://srv-0002.uat.tabesto.com/"
    And User login as admin
    And User click on submenu "Disponibilités"
    And User set product "" unavailable
    And User update availability
    Then Product "" is unavailable today appears
    And Product "" is not clickable