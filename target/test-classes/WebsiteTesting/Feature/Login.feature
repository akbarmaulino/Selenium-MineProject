Feature: Login Feature

    Scenario: Login With Valid Credentials
        Given I am on the login page
        When I enter valid username and password
        And I click the login button
        Then I should be redirected to the homepage