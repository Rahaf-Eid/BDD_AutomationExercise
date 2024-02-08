@UiAutomationExercise
Feature: products

  @prerequisite
  Scenario: login to the website
    Given Navigate to "http://automationexercise.com"
    And verify "loginSignup" is visible
    And Click on "loginSignup"
    And verify "username" is visible
    When fill in the "username" field with "rahaf@mail.com"
    When fill in the "password" field with "A123"
    And Click on "loginButton"
    Then verify "ProductsButton" is visible

  Scenario: Verify that product detail is visible
    Given "HomeScreen" is opened
    And verify "ProductsButton" is visible
    And Click on "ProductsButton"
    And verify "allProductsPage" is visible
    And verify "fullList" is visible
    And Click on "viewFirstProduct"
    And verify "productInformation" is visible
    And verify "productName" is visible
    And verify "category" is visible
    And verify "price" is visible
    And verify "availability" is visible
    And verify "condition" is visible
    And verify "brand" is visible


