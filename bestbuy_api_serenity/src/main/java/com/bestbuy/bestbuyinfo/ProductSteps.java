package com.bestbuy.bestbuyinfo;

import com.bestbuy.constant.EndPoint;
import com.bestbuy.model.ProductsPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class ProductSteps {

    @Step("Creating product with Name: {0}, type: {1}, price: {2}, shipping: {3},upc: {4},description: {5},manufacturer: {6},model: {7},url: {8} and image: {9}")
    public ValidatableResponse createProduct(String name, String type, int price, int shipping, String upc, String description, String manufacturer, String model, String url, String image) {
        ProductsPojo productsPojo = new ProductsPojo();
        productsPojo.setName(name);
        productsPojo.setType(type);
        productsPojo.setPrice(price);
        productsPojo.setShipping(shipping);
        productsPojo.setUpc(upc);
        productsPojo.setDescription(description);
        productsPojo.setManufacturer(manufacturer);
        productsPojo.setModel(model);
        productsPojo.setUrl(url);
        productsPojo.setImage(image);

        return SerenityRest.rest()
                .given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .body(productsPojo)
                .post(EndPoint.CREATE_SINGLE_PRODUCT)
                .then();
    }
/*
    @Step("Getting the product information with name: {0}")
    public static HashMap<String, Object> getProductInfoByName(String name) {
        String p1 = "findAll{it.name=='";
        String p2 = "'}.get(0)";

        HashMap<String, Object> value = SerenityRest.rest().given()
               .pathParam("name", name)
                .when()
                .get(EndPoint.GET_ALL_PRODUCTS)
                .then()
                .extract()
                .path(p1 + name + p2);
        return value;*/


  //  }
    @Step(" productId: {0}")
    public ValidatableResponse updateProduct( int productId,String name, String type, int price, int shipping, String upc, String description, String manufacturer, String model, String url, String image) {
        ProductsPojo productsPojo = new ProductsPojo();
        productsPojo.setName(name);
        productsPojo.setType(type);
        productsPojo.setPrice(price);
        productsPojo.setShipping(shipping);
        productsPojo.setUpc(upc);
        productsPojo.setDescription(description);
        productsPojo.setManufacturer(manufacturer);
        productsPojo.setModel(model);
        productsPojo.setUrl(url);
        productsPojo.setImage(image);

        return SerenityRest.rest()
                .given()
                .contentType(ContentType.JSON)
               .pathParam("productId", productId)
                .log().all()
                .when()
                .body(productsPojo)
               .put(EndPoint.UPDATE_PRODUCTS_BY_ID)
                .then();
    }
    @Step("Deleting product information with id: {0}")
    public ValidatableResponse deleteProduct(int id) {
        return SerenityRest.rest()
                .given()
                .pathParam("id", id)
                .when()
                .delete(EndPoint.DELETE_PRODUCTS_BY_ID)
                .then();
    }

    @Step("Getting information of the product with id: {0}")
    public ValidatableResponse getProductByID(int id) {
        return SerenityRest.rest()
                .given()
                .pathParam("id", id)
                .when()
                .get(EndPoint.GET_SINGLE_PRODUCTS_BY_ID)
                .then();
    }

    @Step("Getting all students information")
    public ValidatableResponse getAllProducts(){
        return SerenityRest.rest()
                .given()
                .when()
                .get(EndPoint.GET_ALL_PRODUCTS)
                .then();
    }

}
