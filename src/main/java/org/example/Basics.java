package org.example;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Basics {
    public static void main(String[] args) {

        //Given-All input details
        //When - Submit the API
        //Then - Validate the response

        //Base URI
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        //PUT
        String response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json" )
                .body(Payload.AddPlace()).when().post("/maps/api/place/add/json").then().statusCode(200).body("scope",equalTo("APP"))
                        .header("Server","Apache/2.4.41 (Ubuntu)").extract().response().asPrettyString();

        System.out.println(response); //Printing Json response which is stored in string in above step

        JsonPath js = new JsonPath(response); //For Parsing Json or Extract Json body response > It only accepts String as an Argument.
        String place_id = js.getString("place_id");

        System.out.println("Print Place_id: "+place_id);

       // Update (PUT)
        String newAddress = "31 Suraj Park Abad 382350";

        given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body("{\n" +
                        "\"place_id\":\""+place_id+"\",\n" +
                        "\"address\":\""+newAddress+"\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}").when().put("/maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));

        //GET
        String getPlaceName = given().log().all().queryParam("key","qaclick123").queryParam("place_id",place_id)
                .when().get("/maps/api/place/get/json")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();


        // Created re-usable method to convert RAW response to Json format and called by classname.methodname
        // JsonPath js1 = new JsonPath(getPlaceName);
        JsonPath js1 = Utils.rawToJson(getPlaceName);

        //Parse jason - Extract  value from json response
        String actualPlaceName = js1.getString("address");

        System.out.println(actualPlaceName);

        //TestNG Assert
        Assert.assertEquals(actualPlaceName,newAddress,"The Address is not matched");

    }
}
