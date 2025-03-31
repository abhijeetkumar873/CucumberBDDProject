Feature: Products Add to Cart

Background: Step commons for all scenarios
    Given User launch chrome browser
    When User open URL "https://www.saucedemo.com/"
    And user enter username "standard_user" and password "secret_sauce"
    And click on login button.
    Then user can view the "Products" on the homepage

@Regression
Scenario: Product should be add in cart
    
    When user click on filter button
    And select the "Price (low to high)"
    And user clicks Add to Cart for "Sauce Labs Onesie"
    And user clicks Add to Cart for "Sauce Labs Bike Light"
    Then button name should change with "Remove"
    Then close browser.
    
@Regression

Scenario: validate product should be added in cart list
		
    When click on cart icon
    Then user can view Product added successfully in cart
    And verify only selected product should be added in the cart.
    And close browser.