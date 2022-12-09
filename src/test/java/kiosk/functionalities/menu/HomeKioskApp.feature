Feature: Menu Details

  Scenario: Verify information Borne
#    Given User is on categories page
    Given Kiosk app is launched
  #  And Url server is configured
#    When User touch "TOUCHER POUR COMMENCER"
#    And User set his firstname "Test Fisrt"
#    And User click on validate button
#    #Then "Test Fisrt" is displayed on choice screen
#    Then User see in the header of screen "TABESTO" N°,"BORNE" N° and "Test Fisrt"
#    And User see at the top left corner of screen "MA COMMANDE SUR PLACE"
#    And User see at the top right corner of screen "Votre panier est vide 0,00 €"
#    And All categories in back-office are displayed on screen
#    When User click on "abondonner" button
#    And User click on "valider" button
#    Then Kiosk app is relaunched
#    When User touch "TOUCHER POUR COMMENCER"
#    And User set his firstname "Test Fisrt"
#    And User click on validate button
#    When User choose "A EMPORTER"
#    Then User see at the top left corner of screen "MA COMMANDE A EMPORTER"

  Scenario: Activate bar menu
    When Admin-user connect to server "https://srv-0002.uat.tabesto.com/"
    #And User login as admin
    #Then User will be redirect to "menu/food/list"
    #When User click on menuItem "Administration"
    #And User click on submenu "Champs de config"
    #And User activate option bar menu
#    And Kiosk app is relaunched
    #And User touch "TOUCHER POUR COMMENCER"
    #And User set his firstname "Test Fisrt"
    #And User click on validate button
    #Then Menu bar is displayed
    #When User click on tab "Les plats"
#    And All categories tabs are opened
#    When User click on tab "Les boissons"
#    And No product exist
#
#  Scenario: Add new food category in back-office
#    When User is on categories page
#    And User add new food category "Test New Product"
#    And User add new food product "test product" for category "Test New Product"
#    And Kiosk app is relaunched
#    #And User click on debug mode
#    #And User set "https://srv-0002.uat.tabesto.com/" as server url
#    #And User click on Ok button
#    And User touch "TOUCHER POUR COMMENCER"
#    And User set his firstname "Test Fisrt"
#    And User click on validate button
#    Then Home screen of kiosk app is displayed
#    When User click on tab "Les plats"
#    Then Category "Test New Product" with product "test product" is present
#
##  Scenario: Add new drink category in back-office
##    When Go to url "https://srv-0002.uat.tabesto.com/"
##    When User login as admin
##    Then User will be redirect to "menu/food/list"
##    When User click on submenu "Catégories"
##    And User add new drink category "Test New Drink Product"
##    And User add new drink product "drink product" for category "Test New Drink Product"
##    And Kiosk app is relaunched
##    And User click on debug mode
##    #And User set "https://srv-0002.uat.tabesto.com/" as server url
##    And User click on Ok button
##    And User touch "TOUCHER POUR COMMENCER"
##    And User set his firstname "Test Fisrt"
##    And User click on validate button
##    Then Home screen of kiosk app is displayed
##    When User click on tab "Les boissons"
##    Then Category "Test New Drink Product" with product "drink product" is present
##
##  Scenario: Delete category
##    When User is on categories page
##    When Kiosk app is launched
##    And User click on debug mode
##    #And User set "https://srv-0002.uat.tabesto.com/" as server url
##    And User click on Ok button
##    And User touch "TOUCHER POUR COMMENCER"
##    And User set his firstname "Test Fisrt"
##    And User click on validate button
##    And Home screen of kiosk app is displayed
##    And User click on tab "Les plats"
##    Then Category "Test New Product" is not present
##    When User click on tab "Les boissons"
##    Then Category "Test New Drink Product" is not present
##
##  Scenario: Change menu
##    Given Go to url "https://srv-0002.uat.tabesto.com/"
##    When User login as admin
##    And User click on submenu "Liste des cartes"
##    Then User will be redirect to "menus/list"
##    And User double click on "Carte par défaut"
##    And User choose personalize period
##    And User set start hour and duration as actually datetime
##    And User click on button "SAUVEGARDER"
##    And User click on icon duplicate "Carte par défaut"
##    Then User will be redirect to "menus/clone"
##    And User search category "Boissons"
##    And User select group "Boissons"
##    And User click on duplicate button
##    Then User will be redirect to "menus/edit"
##    When User set "carte avec juste des boissons" as name
##    And User set "boissons" as description
##    And User choose personalize period
##    And User set start hour and duration for second menu
##    And User click on button "SAUVEGARDER"
##    Given Kiosk app is synchronized
##    Then "Désolé, il semblait qu'aucune carte ne soit activée Veuillez vous rendre au comptoir" displayed
##    And User wait for new sync
##    And User touch "TOUCHER POUR COMMENCER"
##    And User set his firstname "Test Fisrt"
##    And User click on validate button
##    And User click on tab "Les plats"
##    Then Only category "Boissons" exist