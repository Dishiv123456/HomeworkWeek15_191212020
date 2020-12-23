package com.bestbuy.bestbuyinfo;

import com.bestbuy.constant.EndPoint;
import com.bestbuy.model.CategoriesPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CategoriesSteps {
   //
   @Step("Create categories with name: {0},id: {1}")
    public ValidatableResponse createCategories(String name,String id){
       CategoriesPojo categoriesPojo=new CategoriesPojo();
       categoriesPojo.setName(name);
       categoriesPojo.setId(id);

       return SerenityRest.rest()
               .given()
               .contentType(ContentType.JSON)
               .log().all()
               .when()
               .body(categoriesPojo)
               .post(EndPoint.CREATE_CATEGORIES)
               .then();
   }
   @Step("getting categories by id: {0}")
   public ValidatableResponse getCategoriesById(String id) {

      return SerenityRest.rest()
              .given()
              .pathParam("id", id)
              .when()
              .get(EndPoint.GET_CATEGORIES_BY_ID)
              .then();
   }

   @Step("getting all categories information}")
   public ValidatableResponse getAllCategories() {

      return SerenityRest.rest()
              .given()

              .when()
              .get(EndPoint.GET_ALL_CATEGORIES)
              .then();
   }
   @Step("Deleting categories  information with id: {0}")
   public ValidatableResponse deleteCategories(String id) {
      return SerenityRest.rest()
              .given()
              .pathParam("id", id)
              .when()
              .delete(EndPoint.DELETE_CATEGORIES_BY_ID)
              .then();
   }



}
