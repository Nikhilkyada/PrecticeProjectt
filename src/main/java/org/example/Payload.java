package org.example;

public class Payload {

    public static String AddPlace(){
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Nikhil\",\n" +
                "  \"phone_number\": \"(+91)9898133533\",\n" +
                "  \"address\": \"North\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}";
    }

    public static String coursePrice(){
        return "{\n" +
                "\"dashboard\": {\n" +
                "\"purchaseAmount\": 1210,\n" +
                "\"website\": \"rahulshettyacademy.com\"\n" +
                "},\n" +
                "\"courses\": [\n" +
                "{\n" +
                "\"title\": \"Selenium Python\",\n" +
                "\"price\": 50,\n" +
                "\"copies\": 6\n" +
                "},\n" +
                "{\n" +
                "\"title\": \"Cypress\",\n" +
                "\"price\": 40,\n" +
                "\"copies\": 4\n" +
                "},\n" +
                "{\n" +
                "\"title\": \"RPA\",\n" +
                "\"price\": 45,\n" +
                "\"copies\": 10\n" +
                "},\n" +
                "  {\n" +
                "\"title\": \"JAVA\",\n" +
                "\"price\": 60,\n" +
                "\"copies\": 5\n" +
                "}\n" +
                "]\n" +
                "}";
    }

    //Dynamic Paylod by using parameterize method
    public static String addBook(String isbn, String aisle){
        String payload = "{\n" +
                "\"name\":\"Rest-Assured Lerning\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +                //Dynamic isbn
                "\"aisle\":\""+aisle+"\",\n" +              //Dynamic aisle
                "\"author\":\"Nikhil Kyada\"\n" +
                "}";
        return payload;
    }

    public static String delete(String id){
        String payload = "{\n" +
                "    \"ID\": \""+id+"\"\n" +
                "}";
        return payload;
    }
}
