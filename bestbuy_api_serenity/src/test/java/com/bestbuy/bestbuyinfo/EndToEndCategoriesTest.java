package com.bestbuy.bestbuyinfo;

import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.UtilTest;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class EndToEndCategoriesTest extends TestBase {
    static String name = "abc" + UtilTest.getRandomNumber();
    static String id = "abc123" + UtilTest.getRandomNumber();
    String categoriesId;
    @Steps
    CategoriesSteps categoriesSteps;

    //This method will create new record
    @Title("Create new categories")
    @Test
    public void test001() {
        categoriesSteps.createCategories(name, id).statusCode(201);
    }

    @Title("Getting categories information by Id")
    //This method will retrieve category by id
    @Test
    public void test002() {
        categoriesId = categoriesSteps.getAllCategories().extract().path("data[0].id");
        categoriesSteps.getCategoriesById(categoriesId).statusCode(200);
        System.out.println(categoriesId);
    }

    //This method will retrieve all categories
    @Title("Getting all categories information")
    @Test
    public void test003() {

        categoriesSteps.getAllCategories().log().all().statusCode(200);


    }
    //This method will delete single category by id and verify data has been deleted
    @Title("Delete the categories and verify if the categories is deleted!")
    @Test
    public void test004() {
        categoriesId = categoriesSteps.getAllCategories().extract().path("data[0].id");
        categoriesSteps.deleteCategories(categoriesId).statusCode(200);
        categoriesSteps.getCategoriesById(categoriesId).log().all().statusCode(404);
    }

}
