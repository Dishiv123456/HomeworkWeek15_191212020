package com.bestbuy.bestbuyinfo;

import com.bestbuy.constant.EndPoint;
import com.bestbuy.model.ServicesPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class ServicesSteps {
    @Step("Creating services with name :{0}")
    public ValidatableResponse createService(String name){

        ServicesPojo servicesPojo =new ServicesPojo();
        servicesPojo.setName(name);

        return SerenityRest.rest()
                .given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .body(servicesPojo)
                .post(EndPoint.CREATE_SERVICES)
                .then();
    }

    @Step("getting services by id: {0}")
    public ValidatableResponse getServicesById(int id) {

        return SerenityRest.rest()
                .given()
                .pathParam("id", id)
                .when()
                .get(EndPoint.GET_SERVICES_BY_ID)
                .then();
    }

    @Step("getting all service information}")
    public ValidatableResponse getService() {

        return SerenityRest.rest()
                .given()

                .when()
                .get(EndPoint.GET_ALL_SERVICES)
                .then();
    }
    @Step("Deleting services  information with id: {0}")
    public ValidatableResponse deleteService(int id) {
        return SerenityRest.rest()
                .given()
                .pathParam("id", id)
                .when()
                .delete(EndPoint.DELETE_SERVICES_BY_ID)
                .then();
    }

}
