Feature: Communication Borne - Comptoir

  Scenario: Happy hour
    Given User go to url "https://srv-0002.uat.tabesto.com/"
    And User login as admin
    And User click on submenu "Liste des produits"
#    And User double click on product "" in BO
#    And User set secondary price "2" for this product
#    And Kiosk app is launched
#    When User touch "TOUCHER POUR COMMENCER"
#    And User set his firstname "Test Fisrt"
#    And User click on validate button
#    And User choose "SUR PLACE"
#    And Counter app is launched
#    And User activate happy hour
#    Then Popin happy Hour appears
#    When User click on validate button
#    And User select category ""
#    And User choose food product ""
#    Then Icon happy hour is displayed
#    And Then new price for product "" is 2
#
#
#  Scenario: Order
#    Given Kiosk app is launched
#    When User touch "TOUCHER POUR COMMENCER"
#    And User set his firstname "Test Fisrt"
#    And User click on validate button
#    And User choose "SUR PLACE"
#    When User click on "LA CARTE"
#    And User select category "Burgers"
#    And User choose food product "Hamburger"
#    And User set quantity as "3"
#    And User click on ajouter button
#    And User click on Non merci button
#    And User click on Non merci button
#    And User select category "Snacks"
#    And User choose food product "Chicken tenders x3"
#    And User click on ajouter button
#    And User click on Non merci button
#    And User select category "Desserts"
#    And User choose food product "Cookie Choco Noisettes"
#    And User set quantity as "2"
#    And User click on ajouter button
#    Then User see at the top right corner of screen "0,00 €"
#    When User click on "MA COMMANDE"
#    Then The order contains "3x Double Cheeseburger, Chicken Tenders x3, 2x Cookie Choco Noisettes"
#    And User click on "CONFIRMER ET PAYER"
#    And On counter a new order is displayed
#    When User click on  this new order
#    Then The order on counter app contains "3x Double Cheeseburger, Chicken Tenders x3, 2x Cookie Choco Noisettes"