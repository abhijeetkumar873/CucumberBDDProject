Feature: Login
 
 @Regression
Scenario Outline: Sucessful login with valid credentials DDT
    Given User launch chrome browser
    When User open URL "https://www.saucedemo.com/"
    And user enter username "standard_user" and password "secret_sauce"
    And click on login button.
    Then Page Title Should be "Swag Labs"
    When user click on menu button
    And user click on logout link
    Then close browser.

@Sanity
Scenario Outline:  Unsucessful login with Invalid credentials DDT
    Given User launch chrome browser
    When User open URL "https://www.saucedemo.com/"
    And user enter username "<email>" and password "<password>"
    And click on login button.
    And Error message Should be "Epic sadface: Username and password do not match any user in this service"
    And close browser.

Examples:

| email|password|
|standard_user1|secret_sauce|
|standard_user|secret_saucee|
|standard_user1|secret_saucee|
