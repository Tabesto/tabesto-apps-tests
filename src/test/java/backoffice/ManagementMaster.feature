Feature:

  Scenario: Connect to the master
    Given Admin-user connect to server "srv-0002.uat.tabesto.com"
    When Admin-user click on menuItem "Administration"
    And Admin-user click on submenu "Gestion utilisateurs"
    And Admin-user create a new_user
    And Admin-user activate account for new_user
    And Open a new private window
    And Admin-user connect with new_user credentials
