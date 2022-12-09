Feature:  TestReg
  Background:
    Given Kiosk app is launched and configured

  Scenario Outline : Add Product Without Options
    When User touch "TOUCHER POUR COMMENCER"
    And User set his firstname <firstName>
    And User click on validate button
    And User choose <location>
    And User select category <category>
    And User choose food product <product>
    Then Product screen details is displayed
    And User click on ajouter button
    And User click on Non merci button
    And User click on "MA COMMANDE"
    Then The order contains product <product1>
    Examples:
      | firstName    | location    | category  | product               | product1  |
      | "Test First" | "SUR PLACE" | "Burgers" | "Double Cheeseburger" | "<title>" |


  Scenario Outline: Add Product With Options
    When User touch "TOUCHER POUR COMMENCER"
    And User set his firstname <firstName>
    And User click on validate button
    And User choose <location>
    And User select category <category>
    And User choose food product <product>
    Then Product screen details is displayed
    And User select <option>
    And User select <option1>
    And User select <option2>
    And User click on ajouter button
    And User click on Non merci button
    And User click on "MA COMMANDE"
    Then The order contains product <product1>
    Examples:
      | firstName    | location    | category  | product               | option  | option1       | option2   | product1  |
      | "Test First" | "SUR PLACE" | "Burgers" | "Double Cheeseburger" | "bacon" | "sans salade" | "ongions" | "<title>" |

  Scenario Outline: Empty Panier
    When User touch "TOUCHER POUR COMMENCER"
    And User set his firstname <firstName>
    And User click on validate button
    And User choose <location>
    And User click on "MA COMMANDE"
    Then <message> is displayed
    And Button <button> is present
    Examples:
      | firstName    | location    | message| button
      | "Test First" | "SUR PLACE" | "Aucun produit selectionne pour le moment" |"REVENIR AU MENU"

