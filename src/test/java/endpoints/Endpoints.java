package endpoints;

import helper.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Endpoints {

    public Endpoints() {
        // Set the base URI for the API
        String baseUrl = ConfigManager.getBaseUrl();
        RestAssured.baseURI = baseUrl;
    }

    public Response registerEmployee(String bodyRequest) {
        Response responseCreateEmployee = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")
                .body(bodyRequest)
                .log().all()
                .when()
                .post("api/users");
        System.out.println("Response from registerEmployee:");
        System.out.println(responseCreateEmployee.asPrettyString());
        return responseCreateEmployee;
    }


    public Response loginEmployee(String bodyRequest) {
        Response responseLogin = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")
                .body(bodyRequest)
                .log().all()
                .when()
                .post("api/login");
        System.out.println("Response from loginEmployee:");
        System.out.println(responseLogin.asPrettyString());
        return responseLogin;
    }

    public Response getEmployee(String token) {
        Response responseGetEmployee = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")
                .log().all()
                .when()
                .get("api/users/" + ConfigManager.ID());
        System.out.println("Response from getEmployee:");
        System.out.println(responseGetEmployee.asPrettyString());
        return responseGetEmployee;
    }

    public Response updateEmployee(String bodyRequest, String token) {
        Response responseUpdateEmployee = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")
                .body(bodyRequest)
                .log().all()
                .when()
                .put("api/users/" + ConfigManager.ID());
        System.out.println("Response from updateEmployee:");
        System.out.println(responseUpdateEmployee.asPrettyString());
        return responseUpdateEmployee;
    }

    public Response deleteEmployee(String token) {
        Response responseDeleteEmployee = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")
                .log().all()
                .when()
                .delete("api/users/" + ConfigManager.ID());
        System.out.println("Response from deleteEmployee:");
        System.out.println(responseDeleteEmployee.asPrettyString());
        return responseDeleteEmployee;
    }

    public Response getAllEmployee(){
        Response responseGetAllEmployee = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")
                .log().all()
                .when()
                .get("api/users?page=" + ConfigManager.ID());
        System.out.println("Response from getAllEmployee:");
        System.out.println(responseGetAllEmployee.asPrettyString());
        return responseGetAllEmployee;
    }


}