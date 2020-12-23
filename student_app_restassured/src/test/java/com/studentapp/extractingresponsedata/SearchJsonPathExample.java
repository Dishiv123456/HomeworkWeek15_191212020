package com.studentapp.extractingresponsedata;

import com.studentapp.testbase.TestBase;
import com.sun.org.apache.xpath.internal.objects.XObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SearchJsonPathExample {
    private static final String API_KEY = "75e3u4sgb2khg673cbv2gjup";
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://api.walmartlabs.com";
        RestAssured.basePath = "/v1";
        response = given()
                .queryParam("query", "Samsung")
                .queryParam("format", "json")
                .queryParam("apiKey", API_KEY)
                .when()
                .get("/search")
                .then();

    }


    // 1) Extract numItems
    @Test
    public void test001() {
        int numItem = response
                .extract().path("numItems");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total number of items are: " + numItem);
        System.out.println("------------------End of Test---------------------------");

    }

    // 2) Extract query
    @Test
    public void test002() {
        String query = response
                .extract().path("query");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The search query is: " + query);
        System.out.println("------------------End of Test---------------------------");

    }

    // 3) Extract first productName by providing list index value
    @Test
    public void test003() {

        List<HashMap<String, Object>> imageEntity = response
                .extract().path("items[0].imageEntities");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The product name is: " + imageEntity);
        System.out.println("------------------End of Test---------------------------");
    }

    // 4) Get the first list from imageEntities for the first product
    @Test
    public void test004() {
        List<HashMap<String, Object>> name = response
                .extract().path("items[0].imageEntities[]");


        //Home work items[0].imageEntities[0].thumbnailImage

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The gift options under the first product are: " + name);
        System.out.println("------------------End of Test---------------------------");

    }

    // 5)Print the size of items
    @Test
    public void test005() {

       int size =response.extract().path("items.size()");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the items is: "+size);
        System.out.println("------------------End of Test---------------------------");
    }

    // 6) Get All the Names from Items
    @Test
    public void test006() {
        List<String> names = response.extract().path("items.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the products are:: " + names);
        System.out.println("------------------End of Test---------------------------");
    }

    // 7) Get the all the values for Name == Straight Talk SAMSUNG Galaxy A20, 32GB Black - Prepaid Smartphone
    @Test
    public void test007() {
        List<HashMap<String, Object>> values = response.extract().path("items.findAll{it.name=='Straight Talk SAMSUNG Galaxy A20, 32GB Black - Prepaid Smartphone'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The values for item name Straight Talk SAMSUNG Galaxy A20, 32GB Black - Prepaid Smartphone are: " + values);
        System.out.println("------------------End of Test---------------------------");
    }

    // 8) Get the sale price for Name == Straight Talk SAMSUNG Galaxy A01, 16GB Black - Prepaid Smartphone
    @Test
    public void test008() {
        List<HashMap<Integer,Object>> values=response.extract().path("items.findAll{it.name=='Straight Talk SAMSUNG Galaxy A20, 32GB Black - Prepaid Smartphone'}.salePrice");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The sale price is "+values);
        System.out.println("------------------End of Test---------------------------");
    }

    // 9) Get the Names which have salePrice less than 200
    @Test
    public void test009() {

        List<String> names = response.extract().path("items.findAll{it.salePrice>200}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of items that price is less than 200 are: " + names);
        System.out.println("------------------End of Test---------------------------");
    }

    // 10) Get the msrp of items that Start with name = Str
    @Test
    public void test010() {
        List<String> msrp = response.extract().path("items.findAll{it.name==~/Str.*/}.msrp");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The msrp of items that start with Str are: " + msrp);
        System.out.println("------------------End of Test---------------------------");
    }
    // 11) Get the sale price of items that End with name = 2020
    @Test
    public void test011() {
        List<String> salePrice = response.extract().path("items.findAll{it.name==~/.*2020/}.salePrice");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The msrp of items that end with 2020 are: "+salePrice);
        System.out.println("------------------End of Test---------------------------");
    }


}
