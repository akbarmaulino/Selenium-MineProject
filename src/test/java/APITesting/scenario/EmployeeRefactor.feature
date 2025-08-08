Feature: Employee API


  Scenario: Register a new employee
    When Send employee to register with body:
      """
      {
          "name": "Akbar Maulino",
          "job": "Quality Assurance"
      }
      """
    Then The response status must be 201
    And The response schema should be match with schema "RegisterSchema.json"


  Scenario: Login with registered employee
    When Send employee to login with body:
      """
      {
          "email": "eve.holt@reqres.in",
          "password": "pistol"
      }
      """
    Then The response status must be 200
    And Save the token from the response to local storage

  Scenario: Update employee details
    Given Make sure token in local storage not empty
    When Send a request to update with body:
      """
      {
          "name": "Akbar Maulino Edited",
          "job": "Quality Assurance Edited"
      }
      """
    Then The response status must be 200
    And name in the response must be "Akbar Maulino Edited"
    And job in the response must be "Quality Assurance Edited"

  Scenario: Get employee details
    Given Make sure token in local storage not empty
    When Send a request to get employee
    Then The response status must be 200
    And email in the response must be "janet.weaver@reqres.in"
    And first_name in the response must be "Janet"
    And last_name in the response must be "Weaver"

  Scenario: Delete employee
    Given Make sure token in local storage not empty
    When Send a request to delete employee
    Then The response status must be 204