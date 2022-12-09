Feature: Snapshot

  Scenario: Create snapshot without updating products
    Given Admin-user connect to server "srv-0002.uat.tabesto.com"
    And Admin-user click on submenu "Snapshots"
    And Admin-user click on "create client snapshot"
    And Admin-user refresh page
    Then Snapshot creation history is displayed
    When Admin-user import snapshot
    And Admin-user verify that all images for products are displayed
    And Admin-user verify that all images for home screen are displayed

  Scenario: Create and import snapshot after adding new product
    Given Admin-user connect to server "srv-0002.uat.tabesto.com"
    When Admin-user click on submenu "Snapshots"
    And Admin-user click on "create client snapshot"
    And Admin-user refresh page
    Then Snapshot creation history is displayed
    When Admin-user add new food product "product-test" for category ""
    When Admin-user import snapshot
    Then Product "test_product" is "not present" in the list of products
    When Admin-user add new food product "product-test" for category ""
    And Admin-user click on "create client snapshot"
    And Admin-user refresh page
    Then Snapshot creation history is displayed
    When Admin-user import snapshot
    Then Product "test_product" is "present" in the list of products
    And Admin-user verify that all images for products are displayed
    And Admin-user verify that all images for home screen are displayed

  Scenario: Create and import snapshot after deleting product
    Given Admin-user connect to server "srv-0002.uat.tabesto.com"
    When Admin-user delete the head of list product
    And Admin-user click on submenu "Snapshots"
    And Admin-user click on "create client snapshot"
    And Admin-user refresh page
    Then Snapshot creation history is displayed
    When Admin-user import snapshot
    Then Product "test_product" is "not present" in the list of products
    And Admin-user verify that all images for products are displayed
    And Admin-user verify that all images for home screen are displayed

