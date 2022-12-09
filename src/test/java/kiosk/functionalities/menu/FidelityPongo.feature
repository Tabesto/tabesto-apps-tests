Feature: Fidelity tabesto - PONGO

  Scenario: Display on home screen
    Given User set "srv-3.uat.tabesto.com" as server url
    And User click on menuItem "Administration"
    And User click on submenu "Champs de config"
    And User activate option FID TABESTO
    And User select "Accueil" as display journey screen
    And User select "Pongo" as partenaire fid
    And User set store token
    And User click on button "SAUVEGARDER"
    When Kiosk app is synchronized
    And User click on Ok button
    And User touch "TOUCHER POUR COMMENCER"
    And User set his firstname "Test Fisrt"
    And User click on validate button
    And User choose "SUR PALCE"
    Then Screen phone is displayed
    When User click on Non merci button
    And User click on "abondonner" button
    And User click on "valider" button
    Then Kiosk app is relaunched
    When User touch "TOUCHER POUR COMMENCER"
    And User set his firstname "Test Fisrt"
    And User click on validate button
    And User choose "SUR PALCE"
    Then User set his phone number
    And Home screen of kiosk app is displayed

  Scenario: Display at the end
    Given User set "srv-3.uat.tabesto.com" as server url
    And User click on menuItem "Administration"
    And User click on submenu "Champs de config"
    And User activate option FID TABESTO
    And User select "Accueil" as display journey screen
    And User select "Pongo" as partenaire fid
    And User set store token
    And User click on button "SAUVEGARDER"
    When Kiosk app is synchronized
    And User click on Ok button
    And User touch "TOUCHER POUR COMMENCER"
    And User set his firstname "Test Fisrt"
    And User click on validate button
    And User choose "SUR PALCE"
    And User select category "Burger"
    And User choose food product "Cheeseburger"
    And User click on ajouter button
    And User click on Non merci button
    And User click on Non merci button
    And User click on "MA COMMANDE"
    And User click on "CONFIRMER ET PAYER"
    Then User set his phone number
    And Inside the ticket there is site name, client name "", location "on site", total order  "" and num order ""
    And Kiosk app is relaunched