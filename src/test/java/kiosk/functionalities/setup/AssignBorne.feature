Feature: Configure Borne

  #Scenario: Got error if there is no assign table to the terminal
    #Given Kiosk app is launched
    #When User touch "TOUCHER POUR COMMENCER"
    #And User set his firstname "Test Fisrt"
    #And User click on validate button
    #Then "Test Fisrt" is displayed on choice screen
    #When User choose "A EMPORTER"
    #Then Toast message "Assign a table to this terminal in back-office" is displayed

#  Scenario:Create a table and assign it in back-office without sync
#    Given User go to url "https://qa1-1001.uat.tbst.me/"
#    When User login as admin
#    Then User will be redirect to "menu/food/list"
#    When User click on menuItem "Plan de salle"
#    And User click on submenu "Tables"
#    And User click on button "CRÉER NOUVELLE TABLE"
#    And User create new "Bornes"
#    When User click on menuItem "Administration"
#    And User click on submenu "Gestion tablettes"
#    And User edit default table as "2" for tab name "2"
#    And User touch "TOUCHER POUR COMMENCER"
#    And User set his firstname "Test Fisrt"
#    And User click on validate button
#    And User choose "SUR PLACE"
#    Then Toast message "Assign a table to this terminal in back-office" is displayed



  Scenario: Create an order take away with 1 product
    Given Kiosk app is launched
    When User click on debug mode
    And User set "https://mob2-1001.uat.tbst.me/" as server url
    And User set "https://oca.uat.tbst.me/" as oca url
    And User click on Ok button
    When User touch "TOUCHER POUR COMMENCER"
    And User set his firstname "Test Fisrt"
    And User click on validate button
    And User choose "A EMPORTER"
    And User select category "Burgers"
    And User choose food product "Cheeseburger"
    And User select options "bacon,Extra Cheddar,Sans Salade"
    And User click on Ajouter button
    And User click on Non merci button
    And User click on Non merci button
    Then The order contains product "Cheeseburger"
    And User see at the top right corner of screen "Votre panier est vide 0,00 €"
    And User see at the top left corner of screen "MA COMMANDE A EMPORTER"
