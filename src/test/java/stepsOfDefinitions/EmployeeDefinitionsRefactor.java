package stepsOfDefinitions;


import endpoints.Endpoints;
import helper.TextContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class EmployeeDefinitionsRefactor extends Endpoints {
    public static String baseUrl;
    public static Response response;
    public static String token;
    private final TextContext context;

    public EmployeeDefinitionsRefactor(TextContext context) {
        this.context = context;
    }

    @Given("Make sure token in local storage not empty")
    public void make_sure_token_not_empty() {
        assert context.get(token, String.class) != null : "Token in context null";
    }

    @When("Send employee to register with body:")
    public void send_request_register(String body) {
        response = registerEmployee(body);
        context.setResponse(response);
    }

    @When("Send employee to login with body:")
    public void send_request_login(String body) {
        response = loginEmployee(body);
        context.setResponse(response);
    }

    @When("Send a request to update with body:")
    public void send_request(String body) {
        response = updateEmployee(body, context.get(token, String.class));
        context.setResponse(response);  
    }

    @When("Send a request to get employee")
    public void send_request_get_employee() {
        response = getEmployee(context.get(token, String.class));
        context.setResponse(response);
    }

    @When("Send a request to delete employee")
    public void send_request_delete_employee() {
        response = deleteEmployee(context.get(token, String.class));
        context.setResponse(response);
    }

    
    

    @Then("The response status must be {int}")
    public void send_request_http(int statusCode) {
        assert context.getResponse().statusCode() == statusCode : "Error, due to actual status code is " + context.getResponse().statusCode();
    }

    @And("The response schema should be match with schema {string}")
    public void schema_validation(String schemaPath) {
        context.getResponse().then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaPath));
    }

    @And("Save the token from the response to local storage")
    public void save_token() {
        context.set(token, context.getResponse().jsonPath().getString("token"));
    }

    @And("name in the response must be {string}")
    public void name_in_response(String name) {
        assert context.getResponse().jsonPath().getString("name").equals(name) : "Error, due to actual name is " + context.getResponse().jsonPath().getString("name");
    }

    @And("job in the response must be {string}")
    public void job_in_response(String job) {
        assert context.getResponse().jsonPath().getString("job").equals(job) : "Error, due to actual job is " + context.getResponse().jsonPath().getString("job");
    }

    @And("email in the response must be {string}")
    public void email_in_response(String email) {
        assert context.getResponse().jsonPath().getString("data.email").equals(email) : "Error, due to actual email is " + context.getResponse().jsonPath().getString("data.email");
    }

    @And("first_name in the response must be {string}")
    public void first_name_in_response(String firstName) {
        assert context.getResponse().jsonPath().getString("data.first_name").equals(firstName) : "Error, due to actual email is " + context.getResponse().jsonPath().getString("data.first_name");
    }

    @And("last_name in the response must be {string}")
    public void last_name_in_response(String lastName) {
        assert context.getResponse().jsonPath().getString("data.last_name").equals(lastName) : "Error, due to actual email is " + context.getResponse().jsonPath().getString("data.last_name");
    }
    
}

    