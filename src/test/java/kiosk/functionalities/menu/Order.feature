@test
Feature: non reg Borne
#    Scenario: 1004 - Endurance - Check language on borne
#        Given Kiosk app is launched and configured
#        When User change language
#        When User touch "TOUCHER POUR COMMENCER"
#        When User choose type of command "location-id:1"
#        And User set his firstname "Test First"
#        And User click on validate button
#        When User ignore eventSuggestion
#        When User exit session
#        When User change language
#        When User touch "TOUCHER POUR COMMENCER"
#        When User choose type of command "location-id:1"
#        And User set his firstname "Test First"
#        And User click on validate button
#        When User ignore eventSuggestion
#        When User exit session
#        When User change language

    Scenario: 1000 - Endurance - Create an order with a mealSequence
        Given Kiosk app is launched and configured
        When User touch "TOUCHER POUR COMMENCER"
        When User choose type of command "location-id:1"
        And User set his firstname "Test First"
        And User click on validate button
        When User ignore eventSuggestion
        When User select category "category-id:3"
        When User choose a food product in MealSequence "category-id:3"
        When User select category "category-id:1"
        When User choose a food product in "category-id:1"
        When select options
        When User click on Ajouter button
        When User ignore productsuggestion
        When User exit session
        When User touch "TOUCHER POUR COMMENCER"
        When User choose type of command "location-id:1"
        And User set his firstname "Test First"
        And User click on validate button
        When User ignore eventSuggestion
        When User select category "category-id:2"
        When User choose a food product in "category-id:2"
        When select options
        When User click on Ajouter button
        When User ignore productsuggestion
        When User click on "MA COMMANDE"
        When User click on "confirmer et payer"
        When User click on choice counter payment

        #Scenario: 1001 - Endurance - Create session and exit
        #Given Kiosk app is launched and configured
#        When User touch "TOUCHER POUR COMMENCER"
#        When User choose type of command "location-id:1"
#        And User set his firstname "Test First"
#        And User click on validate button
#        When User ignore eventSuggestion
#        When User exit session
#        When User touch "TOUCHER POUR COMMENCER"
#        When User choose type of command "location-id:1"
#        And User set his firstname "Test First"
#        And User click on validate button
#        When User ignore eventSuggestion
#        When User exit session
#        When User touch "TOUCHER POUR COMMENCER"
#        When User choose type of command "location-id:1"
#        And User set his firstname "Test First"
#        And User click on validate button
#        When User ignore eventSuggestion
#        When User exit session
#        When User touch "TOUCHER POUR COMMENCER"
#        When User choose type of command "location-id:0"
#        And User set his firstname "Test First"
#        And User click on validate button
#        When User ignore eventSuggestion
#        When User exit session
        #Scenario: 1002 - Endurance - Create an order and exit session many times
            #Given Kiosk app is launched and configured
#        When User touch "TOUCHER POUR COMMENCER"
#        When User choose type of command "location-id:1"
#        And User set his firstname "Test First"
#        And User click on validate button
#        When User ignore eventSuggestion
#        When User select category "category-id:1"
#        When User choose a food product in "category-id:1"
#        When select options
#        When User click on Ajouter button
#        When User ignore productsuggestion
#        When User exit session
#        When User touch "TOUCHER POUR COMMENCER"
#        When User choose type of command "location-id:1"
#        And User set his firstname "Test First"
#        And User click on validate button
#        When User ignore eventSuggestion
#        When User select category "category-id:2"
#        When User choose a food product in "category-id:2"
#        When select options
#        When User click on Ajouter button
#        When User ignore productsuggestion
#        When User click on "MA COMMANDE"
#        When User click on "confirmer et payer"
#        When User click on choice counter payment
##        #Then status "Ticket imprimé !" is displayed with success
#        When User select first choice "burger"
#        Then startScreen is displayed
#
#    Scenario: Create an order with products
#        Given Kiosk app is launched and configured
#        When User touch "TOUCHER POUR COMMENCER"
#        When User choose type of command "location-id:1"
#        And User set his firstname "Test First"
#        And User click on validate button
#        When User ignore eventSuggestion
#        When User select category "category-id:1"
#        When User choose a food product in "category-id:1"
#        When select options
#        When User click on Ajouter button
#        When User ignore productsuggestion
#        When User click on "LA CARTE"
#        When User select category "category-id:0"
#        When User choose a food product in "category-id:0"
#        When select options
#        When User click on Ajouter button
#        When User ignore productsuggestion
#        When User click on "MA COMMANDE"
#        When User click on "confirmer et payer"
#        When User click on choice counter payment
#        #Then status "Ticket imprimé !" is displayed with success
#        Then startScreen is displayed
#
#    Scenario: Create an order and exit command
#        Given Kiosk app is launched and configured
#        When User touch "TOUCHER POUR COMMENCER"
#        When User choose type of command "location-id:1"
#        And User set his firstname "Test First"
#        And User click on validate button
#        When User ignore eventSuggestion
#        When User select category "category-id:1"
#        When User choose a food product in "category-id:1"
#        When select options
#        When User click on Ajouter button
#        When User ignore productsuggestion
#        When User exit session


    #    Scenario: Create an order with formula product and CB
#        Given Kiosk app is launched and configured
#        When User touch "TOUCHER POUR COMMENCER"
#        When User choose type of command "location-id:1"
#        And User set his firstname "Test First"
#        And User click on validate button
#        When User ignore eventSuggestion
#        When User select category "category-id:1"
#        When User choose a food product in "category-id:1"
#        When select options
#        When User click on Ajouter button
#        When User ignore productsuggestion
#        When User click on "MA COMMANDE"
#        When User click on "confirmer et payer"
#        When User ignore eventSuggestion
#        When User click on choice CB payment
        #Then "PAIEMENT ACCEPTE" is displayed with success
        #Then status "Ticket imprimé !" is displayed with success
#
#    Scenario: check lost wifi on borne
#        Given Kiosk app is launched and configured
#        When User change language
#        When User touch "TOUCHER POUR COMMENCER"
#        When User choose type of command "location-id:1"
#        And User set his firstname "Test First"
#        And User click on validate button
#        When User ignore eventSuggestion
#When Wifi is down then then error message is displayed
#        When User change language
#        When User touch "TOUCHER POUR COMMENCER"
#        When User choose type of command "location-id:1"
#        And User set his firstname "Test First"
#        When User ignore eventSuggestion
#        When Wifi is down then then error message is displayed
#        When User change language
#        When User touch "TOUCHER POUR COMMENCER"
#        When User choose type of command "location-id:1"
#        And User set his firstname "Test First"
#        When User ignore eventSuggestion
When Wifi is down then then error message is displayed



#    Scenario: Create an order with formula product and CB
#        Given Kiosk app is launched and configured
#        When User touch "TOUCHER POUR COMMENCER"
#        When User choose type of command "location-id:1"
#        And User set his firstname "Test First"
#        And User click on validate button
#        When User ignore eventSuggestion
#        When User select category "category-id:1"
#        When User choose a food product in "category-id:1"
#        When select options
#        When User click on Ajouter button
#        When User ignore productsuggestion
#        When User click on "MA COMMANDE"
#        When User click on "confirmer et payer"
#        When User ignore eventSuggestion
#        When User click on choice CB payment
#        Then "PAIEMENT ACCEPTE" is displayed with success
#        Then status "Ticket imprimé !" is displayed with success
#
#







#Feature: non reg Borne

#Scenario: Create an order take away with 1 product with options
#  Given Kiosk app is launched
#  When User click on debug mode
#  And User set as server url
#  And User set oca url
#  And User click on Ok button
#  #When User touch "TOUCHER POUR COMMENCER"
#  And User set his firstname "Test First"
#  And User click on validate button
#  And User choose type of command
#  And User select category
#  And User choose food product
#  And Product screen details is displayed
#  And User select options
#  And User click on Ajouter button
#  And User click on Non merci button
#  And User click on "MA COMMANDE"
#Then The order contains products
#  And User see at the top right corner of screen
#  And User see at the top left corner of screen
#  When User click on "confirmer et payer"
#  Then "Votre commande est en cours d'envoi…" is displayed on screen order

#  Scenario: Create an order on site
#    Given Kiosk app is launched
#    When User click on debug mode
#    And User set as server url
#    And User set oca url
#    And User click on Ok button
#    When User touch "TOUCHER POUR COMMENCER"
#    When User set his firstname "Test Fisrt"
#    And User click on validate button
#    And User choose type of command
#    And User select category "Fries"
#    And User choose food product "Ultimate Fries"
#    Then Product screen details is displayed
#    And Product quantity is "1"
#    When User click on Ajouter button
#    And User click on Non merci button
#    And User click on "LA CARTE"
#    And User select category "Boissons"
#    And User choose food product "Vittel 50 cl"
#    Then Product screen details is displayed
#    And Product quantity is "1"
#    And User click on button retour
#    When User click on "MA COMMANDE"
#    Then The order contains product "Ultimate Fries"
#  #And User see at the top right corner of screen "0,00 €"
#    And User see at the top left corner of screen "MA COMMANDE SUR PLACE"




#Feature: Manage order
#
#  Scenario: Empty cart
#    Given Kiosk app is launched
#    When User click on debug mode
#    And User set as server url
#    And User set oca url
#    And User click on Ok button
#    #When User touch "TOUCHER POUR COMMENCER"
#    And User set his firstname "Test Fisrt"
#    And User click on validate button
#    When User choose type of command
#    Then "Test Fisrt" is displayed on choice screen
#    When User click on "MA COMMANDE"
#    Then "Aucun produit sélectionné pour le moment" is displayed
#    And Button "REVENIR AU MENU" is present

#  Scenario: Create an order take away with 1 product
#    Given Kiosk app is launched
#    When User touch "TOUCHER POUR COMMENCER"
#    And User set his firstname "Test Fisrt"
#    And User click on validate button
#    And User choose "A EMPORTER"
#    And User select category "Burger"
#    And User choose food product "Cheeseburger"
#    And User click on Ajouter button
#    And User click on Non merci button
#    And User click on Non merci button
#    Then The order contains product "Cheeseburger"
#    And User see at the top right corner of screen "Votre panier est vide 0,00 €"
#    And User see at the top left corner of screen "MA COMMANDE A EMPORTER"
#
#  Scenario: Create an order on site
#    Given Kiosk app is launched
#    When User touch "TOUCHER POUR COMMENCER"
#    And User set his firstname "Test Fisrt"
#    And User click on validate button
#    And User choose "SUR PLACE"
#    And User click on "LA CARTE"
#    And User select category "Frites"
#    And User choose food product "Ultimate Fries"
#    Then Product screen details is displayed
#    And Product quantity is "1"
#    When User click on Ajouter button
#    And User click on Non merci button
        #And User click on Non merci button
#    And User select category "Boissons"
#    And User choose food product "Vittel 50 cl"
#    Then Product screen details is displayed
#    And Product quantity is "1"
#    And User click on button "RETOUR"
#    When User click on "MA COMMANDE"
#    Then The order contains product "Ultimate Fries"
#    And User see at the top right corner of screen "0,00 €"
#    And User see at the top left corner of screen "MA COMMANDE SUR PLACE"





#    #Then Warning "Veuillez compléter votre menu" is displayed
#    When User choose food product "product3-options3"
#    And Product screen details is displayed
#    When User click on Ajouter button
#    When User choose food product "product4-options4"
#    When User click on Ajouter button
#    When User choose food product "product5-option5"
#    When User click on Ajouter button
#    Then User seen all as choices
#    When User click on Ajouter button
#    And User click on "LA CARTE"
#    When User select category "category"
#    When User choose food product "CAT:product2"
#    When User click on Ajouter button
#    #Then Warning "Veuillez compléter votre menu" is displayed
#    When User choose food product "product3-options3"
#    When User click on Ajouter button
#    When User choose food product "product4-options4"
#    When User click on Ajouter button
#    When User choose food product "product5-option5"
#    When User click on Ajouter button
#    When User click on Ajouter button
#    And User click on "LA CARTE"
#    When User select category "category1"
#    When User choose food product "product6-options6"
#    When User click on Ajouter button
    #When User click on "MA COMMANDE"
    #Then The order contains all products
  #Then The order contains "menu" with option "Veggie Cheeseburger,Ultimate Fries,Soda 40cl,Milkshake Fraise"


#  Scenario: Create an order on site
#    Given Kiosk app is launched and configured
#    When User touch "TOUCHER POUR COMMENCER"
#    And User set his firstname "Test Fisrt"
#    And User click on validate button
#    When User choose type of command "type1"
#    And User click on "LA CARTE"
#    And User select category "category1"
#    And User choose food product "product6"
#    Then Product screen details is displayed
#    And Product quantity is "1"
#    When User click on Ajouter button
#    And User click on Non merci button
#    And User click on "LA CARTE"
#    And User select category "category2"
#    And User choose food product "product7"
#    Then Product screen details is displayed
#    And Product quantity is "1"
#    And User click on button retour
#    When User click on "MA COMMANDE"
#    Then The order contains product "product6"
#    And User see at the top right corner of screen "price6"
#    And User see at the top left corner of screen "type1"

#And User click on ajouter button
#Then User see "HUltimate Fries" as second choice
#    And User click on ajouter la formule button
#    Then Warning "Veuillez compléter votre menu" is displayed
#    When User select third choice "Soda 40cl"
#    And User click on ajouter button
#    Then User see "Soda 40cl" as second choice
#    When User select fourth choice "Milkshake Fraise"
#    And User click on ajouter button
#    Then User see "Milkshake Fraise" as second choice
#    When User click on ajouter la formule button
#    And User click on Non merci button
#    Then User see at the top right corner of screen "9,80 €"
#    When User click on "MA COMMANDE"
#Then The order contains "menu" with option "Veggie Cheeseburger,Ultimate Fries,Soda 40cl,Milkshake Fraise"

#  Scenario: Create an order with formula conversion
#    Given Kiosk app is launched
#    When User touch "TOUCHER POUR COMMENCER"
#    And User set his firstname "Test Fisrt"
#    And User click on validate button
#    And User choose "SUR PLACE"
#    When User click on "LA CARTE"
#    And User select category "Burgers"
#    And User choose food product "Hamburger"
#    And User click on Ajouter button
#    And User choose convert product to menu "burger +Frites+Boisson"
#    And User click on ajouter la formule button
#    Then Warning "Veuillez compléter votre menu" is displayed
#    When User select second choice "French Fries"
#    And User click on ajouter button
#    And User User click on ajouter la formule button
#    Then Warning "Veuillez compléter votre menu" is displayed
#    When User seelct third choice Jus Multifruits 25cl
#    And User click on on ajouter button
#    When User click on Annuler button for second choice
#    And User validate annuler French Fries
#    Then The section of the second choose appear
#    When User select second choice "French Fries"
#    And User click on ajouter button
#    And User click on ajouter la formule button
#    And User click on add Grilled Cheese
#    And User select bacon
#    And User click on ajouter button
#    And User click on valider button
#    Then User see at the top right corner of screen "0,00 €"
#    When User click on "MA COMMANDE"
#Then The order contains "menu" with option "Double Cheeseburger,French Fries,Jus Multifruits 25cl" and "Grilled cheese"
#
#  Scenario: Create an order with multiple products
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
#
#  Scenario: Modify an order
#    Given Kiosk app is launched
#    When User touch "TOUCHER POUR COMMENCER"
#    And User set his firstname "Test Fisrt"
#    And User click on validate button
#    And User choose "SUR PLACE"
#    When User click on "LA CARTE"
#    And User select category "Burgers"
#    And User choose food product "Hamburger"
#    And User select options "Bacon"
#    And User click on ajouter button
#    And User click on Non merci button
#    And User click on Non merci button
#    When User click on "MA COMMANDE"
#    And User click on his order "Double Cheeseburger"
#    And User select options "Pickles"
#    And User set quantity as "2"
#    And User add comment "1 sans Tomate, 2 sans Oignons"
#    And User click on valider button
#    When User click on "MA COMMANDE"
#    Then The order contains "2x Hamburger, 1 sans Tomate, 2 sans Oignons"
#
#  Scenario: Cancel an order
#    Given Kiosk app is launched
#    When User touch "TOUCHER POUR COMMENCER"
#    And User set his firstname "Test Fisrt"
#    And User click on validate button
#    And User choose "SUR PLACE"
#    When User click on "LA CARTE"
#    And User select category "Burgers"
#    And User choose food product "Hamburger"
#    And User click on ajouter button
#    And User click on Non merci button
#    And User click on Non merci button
#    When User click on "MA COMMANDE"
#    And User click on "Annuler" button
#    And User click on "oui" button
#    Then "Aucun produit sélectionné pour le moment" is displayed
#    And Button "REVENIR AU MENU" is present