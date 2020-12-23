package com.bestbuy.bestbuyinfo;

import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.UtilTest;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class EndToEndStoresTest extends TestBase {
    static String name = "abc" + UtilTest.getRandomValue();
    static String type = "xyz" + UtilTest.getRandomValue();
    static String address = "pqr" + UtilTest.getRandomValue();
    static String address2 = "stu" + UtilTest.getRandomValue();
    static String city = "London";
    static String state = "united kingdom";
    static String zip = "abc" + UtilTest.getRandomNumber();
    static float lat = 12.45f;
    static float lng = 578.13f;
    int storesId;
    @Steps
    StoresSteps storesSteps;

    //This method will create new record
    @Title("Create new Store")
    @Test
    public void test001() {
        storesSteps.createStore(name, type, address, address2, city, state, zip, lat, lng).statusCode(201);
    }

    //This method will retrieve store by id
    @Title("Getting store information by Id")
    @Test
    public void test002() {
        storesId = storesSteps.getStore().extract().path("data[0].id");
        storesSteps.getStoreById(storesId).statusCode(200);
        System.out.println(storesId);
    }

    //  This method will retrieve all stores
    @Title("Getting all stores information")
    @Test
    public void test003() {

        storesSteps.getStore().log().all().statusCode(200);

    }

    //This method will delete single Store by id and verify data has been deleted
    @Title("Delete the store and verify if the store is deleted!")
    @Test
    public void test004() {
        //  storesId = storesSteps.getStore().extract().path("data[0].id");
        storesSteps.deleteStore(storesId).statusCode(200);
        storesSteps.getStoreById(storesId).log().all().statusCode(404);
    }

}
