Feature: Menu

  Scenario: Create a menu
    Given User set "srv-3.uat.tabesto.com" as server url
    And User click on menuItem "Administration"
    And User click on submenu "Champs de config"
    And User disable option display comment
    And User disable option show product quantity
    And User disable option bar menu
    When Kiosk app is synchronized
    And User click on Ok button
    And User touch "TOUCHER POUR COMMENCER"
    And User set his firstname "Test Fisrt"
    And User click on validate button
    Then Menu bar is not displayed
    When User select category "Burgers"
    And User choose food product "Double Cheeseburger"
    Then Field comment is not displayed
    And Field quantity is not displayed

  Scenario: Clone a menu
    Given User set "srv-3.uat.tabesto.com" as server url
    And User click on menuItem "Administration"
    And User click on submenu "Champs de config"
    And User activate option multilingual
    When Kiosk app is synchronized
    And User choose  en_EN
    And User touch "TOUCHER POUR COMMENCER"
    And User set his firstname "Test Fisrt"
    And User click on validate button
    When User select category "Burgers"
    And User choose food product "Double Cheeseburger"
    And User click on Non merci button
    And User click on Non merci button
    And User click on "MA COMMANDE"
    And User click on "CONFIRMER ET PAYER"
    And Kiosk app is synchronized
    And Default language is FR

  Scenario: Delete a menu
    Given User set "srv-3.uat.tabesto.com" as server url
    And User click on menuItem "Administration"
    And User click on submenu "Champs de config"