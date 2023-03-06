package org.example;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LibraryAPI {



    //Dynamically passing values to Payload by using parameterize method
    //If you use dataprovider , make method parameterize and pass same parameter to body parameter.
    @Test (dataProvider = "BooksData")
    public void addBook(String isbn , String aisle){
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        //DYNAMIC Method
        String response = given().log().all().header("Content-Type","application/json").body(Payload.addBook(isbn,aisle))
                .when().post("/Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();

        JsonPath js = Utils.rawToJson(response);
        String id = js.getString("ID");

        System.out.println(id);

        //DYNAMIC Method
        String response1 = given().log().all().header("Content-Type","application/json").body(Payload.delete(id)).when().delete("/Library/DeleteBook.php")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();

        JsonPath js1 = Utils.rawToJson(response);
        String msg = js1.getString("msg");
        System.out.println(msg);
        System.out.println("--------------------------------------------------");
    }




    @DataProvider(name = "BooksData")
    public Object[][] getData(){

        //Multidimensional Array = Collection of Arrays
        return new Object[][] {{"dk","1811"},{"uk","8573"},{"vk","2407"}};
    }
}
