Feature:

  Scenario: Without no image carousel
    Given User go to url "https://srv-0002.uat.tabesto.com/"
    When User login as admin
    Then User will be redirect to "menu/food/list"
    When User click on menuItem "Présentation"
    And User click on submenu "Écrans d'accueil"
  #  And User remove all images on tab "CARROUSSEL"
    Then "0" cart exist in tab start
  #  When Kiosk app is synchronized
    And User touch "TOUCHER POUR COMMENCER"
    And User set his firstname "Test Fisrt"
    And User click on validate button
 #   Then Bloc carousel not displayed

  Scenario: Carousel image linked to category
 #   Given Go to url "https://srv-0002.uat.tabesto.com/"
    When User login as admin
    Then User will be redirect to "menu/food/list"
    When User click on menuItem "Présentation"
    And User click on submenu "Écrans d'accueil"
    And User click on button "CRÉER UN ÉCRAN D'ACCUEIL"
    Then User will be redirect to "menu/mainmenuitem/new"
    When User select cart "Carte par défaut ( Sur place, A emporter )"
    And User set title "Etudiant"
    And User select position "Carroussel"
    And User select type category
    And User upload image "screen_1.jpg"
    And User click on button "SAUVEGARDER"
    Then User will be redirect to "menu/mainmenuitem/list"
    And "1" cart exist in tab caroussel
    When Kiosk app is synchronized
    And User click on debug mode
    And User touch "TOUCHER POUR COMMENCER"
    And User set his firstname "Test Fisrt"
    And User click on validate button
    Then Bloc carousel is displayed
    When User select category "Etudiant"
    Then All product for category "" are present in screen

  Scenario: Carousel image linked to food
  #  Given Go to url "https://srv-0002.uat.tabesto.com/"
    When User login as admin
    Then User will be redirect to "menu/food/list"
    When User click on menuItem "Présentation"
    And User click on submenu "Écrans d'accueil"
    And User click on button "CRÉER UN ÉCRAN D'ACCUEIL"
    Then User will be redirect to "menu/mainmenuitem/new"
    When User select cart "Carte par défaut ( Sur place, A emporter )"
    And User set title "Burgerss"
 #   And User select position "Carroussel"
#    And User select type food
 #   And User set option cheeseburger
    And User upload image "screen_1.jpg"
    And User click on button "SAUVEGARDER"
    Then User will be redirect to "menu/mainmenuitem/list"
#    And "2" cart exist in tab caroussel
  #  When Kiosk app is synchronized
    And User click on debug mode
    And User touch "TOUCHER POUR COMMENCER"
    And User set his firstname "Test Fisrt"
    And User click on validate button
 #   Then Bloc carousel is displayed with 2 image
    When User select category "Test"
 #   Then Food product screen "cheeseburger" is displayed
