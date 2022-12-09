Feature: Configure Server URL

  Scenario: Cancel debug mode
    Given Kiosk app is started correctly
    Then Message "Unable to resolve host \"tabesto_service.tabesto.lan\": No address associated with hostname" is displayed on start screen
    When User hold press on icon Tabesto
    Then Dialog with pin lock view appears
    When User click on cancel button
    Then Dialog with pin lock view disappears
    When User hold press on icon Tabesto
    And User press passcode 1,2,3,4
    Then Dialog with pin lock view still present
    And User click on cancel button
    Then Dialog with pin lock view disappears

  Scenario: Invalid server url
    When User hold press on icon Tabesto
    And User press passcode 9,8,5,5
    Then Dialog with pin lock view disappears
    #And Button Test printer is present
    When User set "www.srvcom" as server url
    And User click on Ok button
    Then Alert "Tabesto Kiosk has stopped" appears
    When User click on open app again
    Then Kiosk app is started correctly
    And Message "Unable to resolve host \"www.srvcom\": No address associated with hostname" is displayed on start screen
    When User click on try button
    Then  Message "Unable to resolve host \"www.srvcom\": No address associated with hostname" is displayed on start screen

  Scenario: Valid server url
    When User hold press on icon Tabesto
    And User press passcode 9,8,5,5
    And User set "srv-3.uat.tabesto.com" as server url
    And User click on Ok button
    Then Alert "Tabesto Kiosk keeps stopping" appears
    When User click on open app again
    Then  Message "🛠 Synchronisation des produits en cours..." is displayed on start screen
