package com.bestbuy.bestbuyinfo;

import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.UtilTest;
import net.serenitybdd.junit.runners.SerenityRunner;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class EndToEndServicesTest extends TestBase {
    static String name = "Varsha" + UtilTest.getRandomValue();
    int servicesId;
    @Steps
    ServicesSteps servicesSteps;

    //This method will create new record
    @Title("Create new Service")
    @Test
    public void test001() {
        servicesSteps.createService(name).statusCode(201);
    }

    //This method will retrieve service by id
    @Title("Getting service information by Id")
    @Test
    public void test002() {
        servicesId = servicesSteps.getService().extract().path("data[0].id");
        servicesSteps.getServicesById(servicesId).statusCode(200);
        System.out.println(servicesId);
    }

    //This method will retrieve all services
    @Title("Getting all service information")
    @Test
    public void test003() {

        servicesSteps.getService().log().all().statusCode(200);

    }

    //This method will delete single Service  by id and verify data has been deleted
    @Title("Delete the service and verify if the service is deleted!")
    @Test
    public void test004() {
        servicesId = servicesSteps.getService().extract().path("data[0].id");
        servicesSteps.deleteService(servicesId).statusCode(200);
        servicesSteps.getServicesById(servicesId).log().all().statusCode(404);
    }


}

