Feature: Configure start screen

  Scenario: No image in start screen
    Given Admin-user connect to server "https://srv-0002.uat.tabesto.com/"
    When User login as admin
    Then User will be redirect to "menu/food/list"
    When User click on menuItem "Présentation"
    And User click on submenu "Écrans d'accueil"
    And User remove all images on tab "ACCUEIL"
    Then "0" cart exist in tab start
    When Kiosk app is launched
    And User click on debug mode
    And User set "https://srv-0003.uat.tabesto.com/" as server url
    And User click on Ok button
    Then No image on start screen

  Scenario: Start screen with one image
    Given Go to url "https://srv-0002.uat.tabesto.com/"
    When User login as admin
    Then User will be redirect to "menu/food/list"
    When User click on menuItem "Présentation"
    And User click on submenu "Écrans d'accueil"
    And User click on button "CRÉER UN ÉCRAN D'ACCUEIL"
    Then User will be redirect to "menu/mainmenuitem/new"
    When User select cart "Carte par défaut ( Sur place, A emporter )"
    And User set title "Test start screen"
    And User upload image "screen_1.jpg"
    And User click on button "SAUVEGARDER"
    Then User will be redirect to "menu/mainmenuitem/list"
    And "1" cart exist in tab start
    When Kiosk app is started correctly
    And User click on debug mode
    And User set "https://srv-0003.uat.tabesto.com/" as server url
    And User click on Ok button
    Then 1 image on start screen

  Scenario: Start screen with many images
    Given Go to url "https://srv-0002.uat.tabesto.com/"
    When User login as admin
    Then User will be redirect to "menu/food/list"
    When User click on menuItem "Présentation"
    And User click on submenu "Écrans d'accueil"
    Then "1" cart exist in tab start
    When User click on button "CRÉER UN ÉCRAN D'ACCUEIL"
    Then User will be redirect to "menu/mainmenuitem/new"
    When User select cart "Carte par défaut ( Sur place, A emporter )"
    And User set title "Test start screen"
    And User upload image "screen_1.jpg"
    And User click on button "SAUVEGARDER"
    Then User will be redirect to "menu/mainmenuitem/list"
    Then "2" cart exist in tab start
    When Kiosk app is started correctly
    And User click on debug mode
    And User set "https://srv-0003.uat.tabesto.com/" as server url
    And User click on Ok button
    Then 2 image on start screen

  Scenario: Suggestion per event (home - category)
    Given User set "srv-3.uat.tabesto.com" as server url
    And User click on menuItem "Présentation"
    And User click on submenu "Suggestions par événement"
    And User click on create new suggestion
    And User set text as "New suggestion home -category"
    And User select type of event "Home"
    And User select type "Catégorie"
    And User click on add option
    And User upload image ""
    And User click on button "SAUVEGARDER"
    When Kiosk app is relaunched
    And User click on Ok button
    And User touch "TOUCHER POUR COMMENCER"
    And User set his firstname "Test Fisrt"
    Then Suggestion screen appears
    When User click on button decouvrir
    Then Screen of menu appears

  Scenario: Suggestion per event (home - food)
    Given User set "srv-3.uat.tabesto.com" as server url
    And User click on menuItem "Présentation"
    And User click on submenu "Suggestions par événement"
    And User click on create new suggestion
    And User set text as "New suggestion home -category"
    And User select type of event "Home"
    And User select type "Plat"
    And User click on add option
    And User upload image ""
    And User click on button "SAUVEGARDER"
    When Kiosk app is relaunched
    And User click on Ok button
    And User touch "TOUCHER POUR COMMENCER"
    And User set his firstname "Test Fisrt"
    Then Suggestion screen appears
    When User click on button decouvrir
    Then Screen of product "" appears
