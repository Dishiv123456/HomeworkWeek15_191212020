package com.bestbuy.bestbuyinfo;

import com.bestbuy.constant.EndPoint;
import com.bestbuy.model.StoresPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.aspectj.weaver.ast.Var;

public class StoresSteps {
    @Step("Create stores with name: {0},type: {1},address: {2},address2: {3},city: {4},state: {5},zip: {6},lat: {7},lng: {8}")
    public ValidatableResponse createStore(String name, String type, String address, String address2, String city, String state, String zip, float lat, float lng) {
        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName(name);
        storesPojo.setType(type);
        storesPojo.setAddress(address);
        storesPojo.setAddress2(address2);
        storesPojo.setCity(city);
        storesPojo.setState(state);
        storesPojo.setZip(zip);
        storesPojo.setLat(lat);
        storesPojo.setLng(lng);

        return SerenityRest.rest()
                .given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .body(storesPojo)
                .post(EndPoint.CREATE_STORE)
                .then();
    }

    @Step("getting store by id: {0}")
    public ValidatableResponse getStoreById(int id) {

        return SerenityRest.rest()
                .given()
                .pathParam("id", id)
                .when()
                .get(EndPoint.GET_STORE_BY_ID)
                .then();
    }

    @Step("getting all stores information}")
    public ValidatableResponse getStore() {

        return SerenityRest.rest()
                .given()

                .when()
                .get(EndPoint.GET_ALL_STORES)
                .then();
    }
    @Step("Deleting stores  information with id: {0}")
    public ValidatableResponse deleteStore(int id) {
        return SerenityRest.rest()
                .given()
                .pathParam("id", id)
                .when()
                .delete(EndPoint.DELETE_STORE_BY_ID)
                .then();
    }
}


