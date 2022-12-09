Feature: Menu

  Scenario: Add Formulas
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

  Scenario: Add Category with products
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


  Scenario: Add Suggestion per event
    Given User set "srv-3.uat.tabesto.com" as server url
    And User click on menuItem "Administration"
    And User click on submenu "Champs de config"

  Scenario: Add Suggestion
    Given User set "srv-3.uat.tabesto.com" as server url
    And User click on menuItem "Administration"
    And User click on submenu "Champs de config"

  Scenario: Modify picture
    Given Admin-user connect to server "srv-0002.uat.tabesto.com"

    When Admin-user add "role_product, role_config" to the new-user
    And Admin-user change password for new-user
    And Admin-user logout
    And Admin-user connect with "new_user" credentials
    Then User will be redirect to "/menu/food/list"
    And New-user add new food product "product-test" for category ""
    And New-user activate option multilingual
    And New-user logout
    When Admin-user connect to server "srv-0002.uat.tabesto.com"
    Then Product "test_product" is "present" in the list of products
    And The config multilingual is activate
    And Admin-user logout