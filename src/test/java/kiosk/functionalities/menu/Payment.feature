Feature: Payment

 Scenario: Choose config none identification and counter payment and location take away
  Given Go to url "https://srv-0002.uat.tabesto.com/"
  When User login as admin
  When User click on menuItem "Administration"
  And User click on submenu "Champs de config"
  And User select "aucune" as client identification
  And User choose "comptoir" as payment method
  And User choose "A emporter" as order location
  And User save configuration
  When Kiosk app is synchronized
  When User touch "TOUCHER POUR COMMENCER"
  And User set his firstname "Test Fisrt"
  And User click on validate button
  And User select category "Burger"
  And User choose food product "Cheeseburger"
  And User click on Non merci button
  And User click on Non merci button
  And User click on "MA COMMANDE"
  And User click on "CONFIRMER ET PAYER"
  Then Popin send order appears
  Then Inside the ticket there is site name, client name "Test Fisrt", location "take away", total order  "" and num order ""
  And Home screen of kiosk app is displayed
  # verify print ticket

 Scenario: Choose config name identification and counter payment and location on site
  Given Go to url "https://srv-0002.uat.tabesto.com/"
  When User login as admin
  When User click on menuItem "Administration"
  And User click on submenu "Champs de config"
  And User select "aucune" as client identification
  And User choose "comptoir" as payment method
  And User choose "Sur place" as order location
  And User save configuration
  When Kiosk app is synchronized
  When User touch "TOUCHER POUR COMMENCER"
  And User set his firstname "Test Fisrt"
  And User click on validate button
  And User select category "Etudiants"
  And User click on Ajouter button
  And User select first choice "Veggie Burger"
  And User click on ajouter button
  Then User see "Humburger - sans oignon - Menu à 7,90" as first choice
  When User select second choice "Ultimate Fries"
  And User click on ajouter button
  Then User see "HUltimate Fries" as second choice
  When User select third choice "Soda 40cl"
  And User click on on ajouter button
  Then User see "Soda 40cl" as second choice
  When User select fourth choice "Milkshake Fraise"
  And User click on on ajouter button
  Then User see "Milkshake Fraise" as second choice
  When User User click on ajouter la formule button
  And User click on Non merci button
  And User click on "MA COMMANDE"
  And User click on "CONFIRMER ET PAYER"
  Then Popin send order appears
  Then Inside the ticket there is site name, client name "", location "on site", total order  "" and num order ""
  # verify print ticket

 Scenario: Choose config name identification and payment nepting and location take away
  Given Go to url "https://srv-0002.uat.tabesto.com/"
  When User login as admin
  When User click on menuItem "Administration"
  And User click on submenu "Champs de config"
  And User select "name" as client identification
  And User choose "nepting" as payment method
  And User set ID CLIENT NEPTING "172.16.1.234"
  And User choose "Sur place" as order location
  And User save configuration
  When Kiosk app is synchronized
  When User touch "TOUCHER POUR COMMENCER"
  And User set his firstname "Test Fisrt"
  And User click on validate button
  And User select category "Burger"
  And User choose food product "Cheeseburger"
  And User set quantity as "3"
  And User click on ajouter button
  And User click on Non merci button
  And User click on Non merci button
  And User select category "Snacks"
  And User choose food product "Chicken tenders x3"
  And User click on ajouter button
  And User click on Non merci button
  And User click on "MA COMMANDE"
  And User click on "CONFIRMER ET PAYER"
  Then Screen payment appears with message "login in progress"
  When User present his CB and add his access code
  Then Popin send order appears
  Then Inside the ticket there is site name, client name "Test Fisrt", location "on site", total order  "" and num order ""
  # verify print ticket

 Scenario: Choose config none identification and payment nepting and location on site
  Given Go to url "https://srv-0002.uat.tabesto.com/"
  When User login as admin
  When User click on menuItem "Administration"
  And User click on submenu "Champs de config"
  And User select "aucune" as client identification
  And User choose "nepting" as payment method
  And User set ID CLIENT NEPTING "172.16.1.234"
  And User choose "Sur place" as order location
  And User save configuration
  When Kiosk app is synchronized
  When User touch "TOUCHER POUR COMMENCER"
  And User set his firstname "Test Fisrt"
  And User click on validate button
  And User select category "Burger"
  And User choose food product "Cheeseburger"
  And User click on Non merci button
  And User click on Non merci button
  And User click on "MA COMMANDE"
  And User click on "CONFIRMER ET PAYER"
  Then Popin send order appears
  Then Screen payment appears with message "login in progress"
  When User present his CB and add his access code
  Then Popin send order appears
  Then Inside the ticket there is site name, client name "Test Fisrt", location "on site", total order  "" and num order ""
  And Home screen of kiosk app is displayed
    # verify print ticket

 Scenario: Choose config pager identification and payment nepting and location on site
  Given Go to url "https://srv-0002.uat.tabesto.com/"
  When User login as admin
  And User select "aucune" as client identification
  When User click on menuItem "Administration"
  And User click on submenu "Champs de config"
  And User choose "nepting" as payment method
  And User set ID CLIENT NEPTING "172.16.1.234"
  And User choose "Sur place" as order location
  And User save configuration
  When Kiosk app is synchronized
  When User touch "TOUCHER POUR COMMENCER"
  And User set his firstname "Test Fisrt"
  And User click on validate button
  And User select category "Burger"
  And User choose food product "Cheeseburger"
  And User click on Non merci button
  And User click on Non merci button
  And User click on "MA COMMANDE"
  And User click on "CONFIRMER ET PAYER"
  Then Popin send order appears
  Then Screen payment appears with message "login in progress"
  When User present his CB and add his access code
  Then Popin send order appears
  Then Inside the ticket there is site name, client name "Test Fisrt", location "on site", total order  "" and num order ""
  And Home screen of kiosk app is displayed
    # verify print ticket

 Scenario: Payment method Nepting and counter
  Given Go to url "https://srv-0002.uat.tabesto.com/"
  When User login as admin
  When User click on menuItem "Administration"
  And User click on submenu "Champs de config"
  And User select "aucune" as client identification
  And User choose "comptoir,nepting" as payment method
  And User set ID CLIENT NEPTING "172.16.1.234"
  And User choose "Sur place" as order location
  And User save configuration
  When Kiosk app is synchronized
  When User touch "TOUCHER POUR COMMENCER"
  When Kiosk app is synchronized
  When User touch "TOUCHER POUR COMMENCER"
  And User set his firstname "Test Fisrt"
  And User click on validate button
  And User select category "Burger"
  And User choose food product "Cheeseburger"
  And User click on "MA COMMANDE"
  And User click on "CONFIRMER ET PAYER"
  Then Payment method screen is displayed
  When User click on retour commande
  And User click on "La Carte"
  And User select category "Boissons"
  And User choose food product "Vittel 50cl"
  And User click on ajouter button
  And User click on "MA COMMANDE"
  And User click on "CONFIRMER ET PAYER"
  Then Payment method screen is displayed
  When User select "payer par carte"
  Then Screen payment appears with message "login in progress"
  When User present his CB and add his access code
  Then Popin send order appears
  Then Inside the ticket there is site name, client name "Test Fisrt", location "on site", total order  "" and num order ""
  And Home screen of kiosk app is displayed
    # verify print ticket

 Scenario: Minimum payment CB
  Given Go to url "https://srv-0002.uat.tabesto.com/"
  When User login as admin
  When User click on menuItem "Administration"
  And User click on submenu "Champs de config"
  And User select "aucune" as client identification
  And User choose "nepting" as payment method
  And User set ID CLIENT NEPTING "172.16.1.234"
  And User save configuration
  And User set MINIMUN CB as 10
  And User choose "Sur place" as order location
  And Kiosk app is synchronized
  When User touch "TOUCHER POUR COMMENCER"
  And User set his firstname "Test Fisrt"
  And User click on validate button
  And User select category "Burger"
  And User choose food product "Cheeseburger"
  And User click on ajouter button
  And User click on Non merci button
  And User click on Non merci button
  And User click on "MA COMMANDE"
  And User click on "CONFIRMER ET PAYER"
  Then Message "attention votre commande n'a pas atteint le minimum CB: 10,00$" appears
  And User click on "LA CARTE"
  And User select category "Milkshake"
  And User choose food product "Milkshake Vanille"
  And User click on ajouter button
  And User click on "MA COMMANDE"
  And User click on "CONFIRMER ET PAYER"
  Then Message "attention votre commande n'a pas atteint le minimum CB: 10,00$" appears
  When User click on his order "Double Cheeseburger"
  And User set quantity "2"
  And User click on valider button
  And User click on "CONFIRMER ET PAYER"
  Then Popin send order appears
  Then Screen payment appears with message "login in progress"
  When User present his CB and add his access code
  Then Popin send order appears
  Then Inside the ticket there is site name, client name "Test Fisrt", location "on site", total order "15" and num order "XX"
  And Home screen of kiosk app is displayed
    # verify print ticket

 Scenario: Retry after wrong credit cart code
  Given Go to url "https://srv-0002.uat.tabesto.com/"
  And User login as admin
  When User click on menuItem "Administration"
  And User click on submenu "Champs de config"
  And User choose "nepting" as payment method
  And User set ID CLIENT NEPTING "172.16.1.234"
  And User choose "Sur place" as order location
  And User save configuration
  When Kiosk app is synchronized
  When User touch "TOUCHER POUR COMMENCER"
  And User set his firstname "Test Fisrt"
  And User click on validate button
  And User select category "Burger"
  And User choose food product "Cheeseburger"
  And User click on ajouter button
  And User click on Non merci button
  And User click on Non merci button
  And User click on "MA COMMANDE"
  And User click on "CONFIRMER ET PAYER"
  Then Connexion lecteur .. is displayed
  Then Screen payment appears with message "login in progress"
  When User present his CB and add wrong access code
  And error message "Votre paiment n'a pas pu aboutir" is displayed
  And User clik on "reesayer" button
  Then Screen payment appears with message "login in progress"
  When User present his CB and add his access code
  Then Popin send order appears
  Then Inside the ticket there is site name, client name "Test Fisrt", location "on site", total order "15" and num order "XX"
  And Start screen is displayed
 #verify print ticket

 Scenario: Modify availability of product
  When Kiosk app is synchronized
  When User touch "TOUCHER POUR COMMENCER"
  And User set his firstname "Test Fisrt"
  And User click on validate button
  And User choose "SUR PLACE"
  And User select category "Burger"
  And User choose food product "Cheeseburger"
  And User click on ajouter button
  And User click on Non merci button
  And User click on Non merci button
  And User click on "MA COMMANDE"
  And Go to url "https://srv-0002.uat.tabesto.com/"
  And User login as admin
  And User click on submenu "Disponibilités"
  And User set product "Cheeseburger" unavailable
  Then Pop-in "cart has been modified " is displayed
  When User click on "voir mes commandes" button
  Then "Aucun produit sélectionné pour le moment" is displayed

 Scenario: Payment nepting error - TPE switch off
  Given Go to url "https://srv-0002.uat.tabesto.com/"
  And User login as admin
  When User click on menuItem "Administration"
  And User click on submenu "Champs de config"
  And User choose "nepting" as payment method
  And User set ID CLIENT NEPTING "172.16.1.234"
  And User choose "Sur place" as order location
  And User save configuration
  When Kiosk app is synchronized
  When User touch "TOUCHER POUR COMMENCER"
  And User set his firstname "Test Fisrt"
  And User choose "SUR PLACE"
  And User click on validate button
  And User select category "Burger"
  And User choose food product "Cheeseburger"
  And User click on ajouter button
  And User click on Non merci button
  And User click on Non merci button
  And User click on "MA COMMANDE"
  And User click on "CONFIRMER ET PAYER"
  Then Connexion lecteur .. is displayed
  And error message "Votre paiment n'a pas pu aboutir" is displayed
  And User clik on "reesayer" button
  Then Connexion lecteur .. is displayed
  And Popin payment error appears
  And Start screen is displayed
 #verify print ticket

