Feature:

  Scenario: Create user
    Given Admin-user connect to server "srv-0002.uat.tabesto.com"
    When Admin-user click on menuItem "Administration"
    And Admin-user click on submenu "Gestion utilisateurs"
    And Admin-user create a new-user
    And Admin-user activate account for new-user
    And Admin-user logout
    And Admin-user connect with "new_user" credentials
    Then User will be redirect to "/menu/food/list"
    And Verify error message "Expression \"has_role(\'ROLE_PRODUCTS\')\" denied access"
    When User go to url "srv-0002.uat.tabesto.com/menu/tablet/list"
    And Verify error message "Expression \"has_role(\'ROLE_PRODUCTS\')\" denied access"
    And Admin-user logout

  Scenario: Edit User
    Given Admin-user connect to server "srv-0002.uat.tabesto.com"
    When Admin-user add "role_product, role_config" to the new-user
    And Admin-user change password for new-user
    And Admin-user logout
    And Admin-user connect with "new_user" credentials
    Then User will be redirect to "/menu/food/list"
    And New-user add new food product "product-test" for category ""
    And New-user activate option multilingual
    And New-user logout
    When Admin-user connect to server "srv-0002.uat.tabesto.com"
    Then Product "test_product" is "present" in the list of products
    And The config multilingual is activate
    And Admin-user logout


  Scenario: Delete User
    Given Admin-user connect to server "srv-0002.uat.tabesto.com"
    When Admin-user disable account for new-user
    And Admin-user logout
    And Admin-user connect with "new_user" credentials
    Then Message Account is disabled appears
    When Admin-user connect to server "srv-0002.uat.tabesto.com"
    And Admin-user delete account for new-user
    And Admin-user logout
    When Admin-user connect with "new-user" credentials
    Then Message invalid credentials appears