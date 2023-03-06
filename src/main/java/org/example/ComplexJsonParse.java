package org.example;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComplexJsonParse {

    //Print No of courses returned by API
    @Test
    public void complexJson(){

        //JsonPath js1 = new JsonPath(Payload.coursePrice()); //Normal Method
        JsonPath js1 = Utils.rawToJson(Payload.coursePrice());  //Re-usable method

        //Print No of courses returned by API
        int count = js1.getInt("courses.size()");

        //Print
        System.out.println(count);
    }

    //Get Cypress Price
    @Test
    public void getIntValue(){
        //Store json response in to js1 object
        JsonPath js1 = new JsonPath(Payload.coursePrice());

        //Getting value by parsing response and giving path
        int cypressPrice = js1.getInt("courses[1].price");

        //Assert point
        Assert.assertEquals(cypressPrice,40,"Cypress Price does not matched");

        //Printing
        System.out.println("Cypress price is " + cypressPrice);
    }

    //Print Purchase Amount
        @Test
    public void getPurchaseAmount() {
        JsonPath js1 = Utils.rawToJson(Payload.coursePrice());
        int purchase = js1.getInt("dashboard.purchaseAmount");
        Assert.assertEquals(purchase,910,"Purchase price doesn't match");
    }

    //3. Print Title of the first course
    @Test
    public void getTitle(){
        JsonPath js = Utils.rawToJson(Payload.coursePrice());

        String title = js.getString("courses[0].title");

        Assert.assertEquals(title,"Selenium Python","Title does not matched");
    }

    //4. Print All course titles and their respective Prices
    @Test
    public void titleAndPRice() {

        JsonPath js1 = Utils.rawToJson(Payload.coursePrice());  //Re-usable method
        //Print No of courses returned by API
        int count = js1.getInt("courses.size()");


        for (int i = 0; i < count; i++) {
            String title = js1.get("courses[" + i + "].title");
            int price = js1.getInt("courses[" + i + "].price");

            System.out.println(title);
            System.out.println(price);
            System.out.println("_______________");
        }
    }
    //6. Verify if Sum of all Course prices matches with Purchase Amount
    @Test
    public void sumOfPrice(){
        int sum = 0;
        JsonPath js = Utils.rawToJson(Payload.coursePrice());
        int count = js.getInt("courses.size()");

        for (int i=0 ; i <count; i++){
            int price = js.getInt("courses["+i+"].price");
            int copies =js.getInt("courses["+i+"].copies");
            int amount = price*copies;

            System.out.println(amount);

            sum = sum + amount;
        }

        System.out.println("Total sum-up "+sum);
        int totalAmount = js.getInt("dashboard.purchaseAmount");
        Assert.assertEquals(totalAmount,sum,"Total purchase amount does not matched");

    }



    //5. Print no of copies sold by RPA Course

}
