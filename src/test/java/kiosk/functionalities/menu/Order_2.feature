Feature: Manage order

# Scenario: Empty cart
#  Given Kiosk app is launched
#  When User touch "TOUCHER POUR COMMENCER"
#  And User set his firstname "Test Fisrt"
#  And User click on validate button
#  Then "Test Fisrt" is displayed on choice screen
#  When User choose "A EMPORTER"
#  When User click on "MA COMMANDE"
#  Then "Aucun produit sélectionné pour le moment" is displayed
#  And Button "REVENIR AU MENU" is present
#
# Scenario: Create an order take away with 1 product
#  Given Kiosk app is launched
#  When User touch "TOUCHER POUR COMMENCER"
#  And User set his firstname "Test Fisrt"
#  And User click on validate button
#  And User choose "A EMPORTER"
#  And User select category "Burger"
#  And User choose food product "Cheeseburger"
#  And User click on Ajouter button
#  And User click on Non merci button
#  And User click on Non merci button
#  Then The order contains product "Cheeseburger"
#  And User see at the top right corner of screen "Votre panier est vide 0,00 €"
#  And User see at the top left corner of screen "MA COMMANDE A EMPORTER"

 Scenario: Create an order on site
  Given Kiosk app is launched
  #When User touch "TOUCHER POUR COMMENCER"
  When User set his firstname "Test Fisrt"
  And User click on validate button
  And User choose "SUR PLACE"
  And User click on "LA CARTE"
  And User select category "Frites"
  And User choose food product "Ultimate Fries"
  Then Product screen details is displayed
  And Product quantity is "1"
  When User click on Ajouter button
  And User click on Non merci button
  And User click on button retour
  And User click on "LA CARTE"
  And User select category "Boissons"
  And User choose food product "Vittel 50 cl"
  Then Product screen details is displayed
  And Product quantity is "1"
  And User click on button retour
  When User click on "MA COMMANDE"
  Then The order contains product "Ultimate Fries"
  #And User see at the top right corner of screen "0,00 €"
  And User see at the top left corner of screen "MA COMMANDE SUR PLACE"

# Scenario: Create an order with formula product
#  Given Kiosk app is launched
#  When User touch "TOUCHER POUR COMMENCER"
#  And User set his firstname "Test Fisrt"
#  And User click on validate button
#  And User choose "SUR PLACE"
#  When User click on "LA CARTE"
#  And User select category "Etuudiants"
#  And User click on Ajouter button
#  And User click on ajouter la formule button
#  Then Warning "Veuillez compléter votre menu" is displayed
#  When User select first choice "Veggie Burger"
#  And User add "sans oigon"
#  And User click on ajouter button
#  Then User see "Humburger - sans oignon - Menu à 7,90" as first choice
#  When User select second choice "Ultimate Fries"
#  And User click on ajouter button
#  Then User see "HUltimate Fries" as second choice
#  And User click on ajouter la formule button
#  Then Warning "Veuillez compléter votre menu" is displayed
#  When User select third choice "Soda 40cl"
#  And User click on ajouter button
#  Then User see "Soda 40cl" as second choice
#  When User select fourth choice "Milkshake Fraise"
#  And User click on ajouter button
#  Then User see "Milkshake Fraise" as second choice
#  When User click on ajouter la formule button
#  And User click on Non merci button
#  Then User see at the top right corner of screen "9,80 €"
#  When User click on "MA COMMANDE"
#  Then The order contains "menu" with option "Veggie Cheeseburger,Ultimate Fries,Soda 40cl,Milkshake Fraise"
#
# Scenario: Create an order with formula conversion
#  Given Kiosk app is launched
#  When User touch "TOUCHER POUR COMMENCER"
#  And User set his firstname "Test Fisrt"
#  And User click on validate button
#  And User choose "SUR PLACE"
#  When User click on "LA CARTE"
#  And User select category "Burgers"
#  And User choose food product "Hamburger"
#  And User click on Ajouter button
#  And User choose convert product to menu "burger +Frites+Boisson"
#  And User click on ajouter la formule button
#  Then Warning "Veuillez compléter votre menu" is displayed
#  When User select second choice "French Fries"
#  And User click on ajouter button
#  And User User click on ajouter la formule button
#  Then Warning "Veuillez compléter votre menu" is displayed
#  When User seelct third choice Jus Multifruits 25cl
#  And User click on on ajouter button
#  When User click on Annuler button for second choice
#  And User validate annuler French Fries
#  Then The section of the second choose appear
#  When User select second choice "French Fries"
#  And User click on ajouter button
#  And User click on ajouter la formule button
#  And User click on add Grilled Cheese
#  And User select bacon
#  And User click on ajouter button
#  And User click on valider button
#  Then User see at the top right corner of screen "0,00 €"
#  When User click on "MA COMMANDE"
#  Then The order contains "menu" with option "Double Cheeseburger,French Fries,Jus Multifruits 25cl" and "Grilled cheese"
#
# Scenario: Create an order with multiple products
#  Given Kiosk app is launched
#  When User touch "TOUCHER POUR COMMENCER"
#  And User set his firstname "Test Fisrt"
#  And User click on validate button
#  And User choose "SUR PLACE"
#  When User click on "LA CARTE"
#  And User select category "Burgers"
#  And User choose food product "Hamburger"
#  And User set quantity as "3"
#  And User click on ajouter button
#  And User click on Non merci button
#  And User click on Non merci button
#  And User select category "Snacks"
#  And User choose food product "Chicken tenders x3"
#  And User click on ajouter button
#  And User click on Non merci button
#  And User select category "Desserts"
#  And User choose food product "Cookie Choco Noisettes"
#  And User set quantity as "2"
#  And User click on ajouter button
#  Then User see at the top right corner of screen "0,00 €"
#  When User click on "MA COMMANDE"
#  Then The order contains "3x Double Cheeseburger, Chicken Tenders x3, 2x Cookie Choco Noisettes"
#
# Scenario: Modify an order
#  Given Kiosk app is launched
#  When User touch "TOUCHER POUR COMMENCER"
#  And User set his firstname "Test Fisrt"
#  And User click on validate button
#  And User choose "SUR PLACE"
#  When User click on "LA CARTE"
#  And User select category "Burgers"
#  And User choose food product "Hamburger"
#  And User select options "Bacon"
#  And User click on ajouter button
#  And User click on Non merci button
#  And User click on Non merci button
#  When User click on "MA COMMANDE"
#  And User click on his order "Double Cheeseburger"
#  And User select options "Pickles"
#  And User set quantity as "2"
#  And User add comment "1 sans Tomate, 2 sans Oignons"
#  And User click on valider button
#  When User click on "MA COMMANDE"
#  Then The order contains "2x Hamburger, 1 sans Tomate, 2 sans Oignons"
#
# Scenario: Cancel an order
#  Given Kiosk app is launched
#  When User touch "TOUCHER POUR COMMENCER"
#  And User set his firstname "Test Fisrt"
#  And User click on validate button
#  And User choose "SUR PLACE"
#  When User click on "LA CARTE"
#  And User select category "Burgers"
#  And User choose food product "Hamburger"
#  And User click on ajouter button
#  And User click on Non merci button
#  And User click on Non merci button
#  When User click on "MA COMMANDE"
#  And User click on "Annuler" button
#  And User click on "oui" button
#  Then "Aucun produit sélectionné pour le moment" is displayed
#  And Button "REVENIR AU MENU" is present