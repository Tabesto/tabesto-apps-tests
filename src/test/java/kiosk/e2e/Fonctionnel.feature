Feature:
  Verify feature availability

  Scenario: 1010 - FUNCTIONAL - Change availability to Unavailable for a new Product
    Given I perform authentication operation for "/login_check" with body
      | username | password              |
      | admin  | is7M7pzGgf2zvZl7PQfCJE8W |
    Then User is authenticated with success
    When User create "1" new Products
      | Type | PAC  | OnlyMealSequence| CATEGORY |
      | FOOD  | NON | NON             | Healthy Bowls |
    Then Product is created with success
    When App is synchronized
    When User touch "TOUCHER POUR COMMENCER"
    When User create a new session "ONSITE"
    When User ignore eventSuggestion
    When User select category "Healthy Bowls"
    And User modify disponibility for "1" Products
    | Product | Disponibility  | TYPE |
    | NewProduct | UNAVAILABLE | PRODUCT|
    Then product is marked as unavailable

  Scenario: 1012 - FUNCTIONAL - Change availability to Unavailable for a new Product in ProductDetails Page
    Given I perform authentication operation for "/login_check" with body
      | username | password              |
      | admin  | is7M7pzGgf2zvZl7PQfCJE8W |
    Then User is authenticated with success
    When User create "1" new Products
      | Type | PAC  | OnlyMealSequence| CATEGORY |
      | FOOD  | NON | NON             | Healthy Bowls |
    Then Product is created with success
    When App is synchronized
    When User touch "TOUCHER POUR COMMENCER"
    When User create a new session "ONSITE"
    When User ignore eventSuggestion
    When User select category "Healthy Bowls"
    Then User choose the "NewProduct" product in "Healthy Bowls"
    And User modify disponibility for "1" Products
      | Product | Disponibility  | TYPE |
      | NewProduct | UNAVAILABLE | PRODUCT|
    Then Update Popin is displayed and product is marked as unavailable

  Scenario: 1011 - FUNCTIONAL - Change availability to Unavailable for a new CustomProduct
    Given I perform authentication operation for "/login_check" with body
      | username | password              |
      | admin  | is7M7pzGgf2zvZl7PQfCJE8W |
    Then User is authenticated with success
    And User create an option with many choices with max allowed "1,3,3"
      | Type | MaxAllowed  | multiple| Required | quantitative | WithImages|
      | FOOD  |     7      |  OUI    | OUI |         OUI       | OUI       |
    When User create "1" new Products
      | Type | PAC  | OnlyMealSequence| CATEGORY |
      | FOOD  | OUI | NON             | Healthy Bowls |
    Then Product is created with success
    And User create an option with many choices with max allowed "1,2,1"
      | Type | MaxAllowed  | multiple| Required | quantitative | WithImages|
      | FOOD  |     5      |  OUI    | OUI |         NON       | OUI       |
    When User create "1" new Products
      | Type | PAC  | OnlyMealSequence| CATEGORY |
      | FOOD  | OUI | NON             | Healthy Bowls |
    Then Product is created with success
    And User create a new custom Product Parent
      | Type | CATEGORY |
      | FOOD  | Healthy Bowls |
    Then Custom Product is created with success
    And User add customs Products Child to custom Product Parent
    When App is synchronized
    When User touch "TOUCHER POUR COMMENCER"
    When User create a new session "ONSITE"
    When User ignore eventSuggestion
    When User select category "Healthy Bowls"
    And User modify disponibility for "1" Products
      | Product | Disponibility  | TYPE |
      | NewProduct | UNAVAILABLE | CUSTOMPRODUCT|
    Then product is marked as unavailable


  Scenario: 1016 - FUNCTIONAL - Modify disponibility of products
    Given I perform authentication operation for "/login_check" with body
      | username | password              |
      | admin  | yKWtaZyCKGWhKulfhfNCADrE |
    Then User is authenticated with success
    And User modify disponibility for "2" Products
      | Product | Disponibility  | TYPE | CATEGORY
      | ACAI BOWL  | UNAVAILABLE | PRODUCT| Healthy Bowls
      | testPacApi | DISABLED| CUSTOMPRODUCT| Healthy Bowls

  Scenario: 1015 - FUNCTIONAL - Add a new Product to the cart
    Given I perform authentication operation for "/login_check" with body
      | username | password              |
      | admin  | is7M7pzGgf2zvZl7PQfCJE8W |
    Then User is authenticated with success
    When User create "1" new Products
      | Type | PAC  | OnlyMealSequence| CATEGORY |
      | FOOD  | NON | NON             | Healthy Bowls |
    Then Product is created with success
    Then App is synchronized
    When User touch "TOUCHER POUR COMMENCER"
    When User create a new session "ONSITE"
    When User ignore eventSuggestion
    When User select category "Healthy Bowls"
    Then User choose the "NewProduct" product in "Healthy Bowls"
    When User add product to the cart
    When User go to the cart

  @smoke
  Scenario: 1018 - FUNCTIONAL - Check products in Cart
  Then The order contains all products
