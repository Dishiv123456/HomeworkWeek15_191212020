package com.bestbuy.bestbuyinfo;

import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.UtilTest;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SerenityRunner.class)
public class EndToEndProductsTest extends TestBase {

    static String name = "xyz" + UtilTest.getRandomValue();
    static String type = "abc";
    static int price = UtilTest.getRandomNumber();
    static int shipping = UtilTest.getRandomNumber();
    static String upc = "abc";
    static String description = UtilTest.getRandomValue();
    static String manufacturer = "International LTD";
    static String model = "Super";
    static String url = "https://www.youtube.com/watch?v=1ji_9scA2C4";
    static String image = "https://www.google.com/search?q=images&rlz=1C1CHBF_en-GBGB923GB923&sxsrf=ALeKk033DGH84Bf6sKQe5my77cmEyBPusQ:1608483305549&tbm=isch&source=iu&ictx=1&fir=vVS58LFDRUHxpM%252CFYJXWK8vb1mDrM%252C_&vet=1&usg=AI4_-kTsx43TKpQBCNRAc8yu3rrpfMSU7Q&sa=X&ved=2ahUKEwiNnLegg93tAhUeaRUIHWTKB4UQ9QF6BAgMEAE#imgrc=vVS58LFDRUHxpM";
    static int productId;

    @Steps
    ProductSteps productSteps;

    //This method will create new record
    @Title("This will create new Product")
    @Test
    public void test001() {

        productSteps.createProduct(name, type, price, shipping, upc, description, manufacturer, model, url, image)
                .statusCode(201);
    }
    //This method will retrieve product by id
      @Title("This test will get a specific product by Id")
   @Test
   public void test002() {
       productId = productSteps.getAllProducts().extract().path("data[0].id");
       productSteps.getProductByID(productId).statusCode(200);
       System.out.println(productId);
   }
  //  This method will retrieve all products
    @Title("Getting  all product information")
    @Test
    public void test003(){
        productSteps.getAllProducts().log().all().statusCode(200);
    }
    //This method will delete single product by id and verify data has been deleted
    @Title("Delete the product and verify if the product is deleted!")
    @Test
    public void test004() {
        productId = productSteps.getAllProducts().extract().path("data[0].id");
        productSteps.deleteProduct(productId).statusCode(200);
        productSteps.getProductByID(productId).log().all().statusCode(404);
    }
   /* @Title("This test will get a specific product by Id")
    @Test
    public void test005() {
        productId = productSteps.getAllProducts().extract().path("data[0].id");
        productSteps.getProductByID(productId).statusCode(200);
        productSteps.updateProduct(productId,name,type,price,shipping,upc,description,manufacturer,model,url,image).statusCode(200);

    }
*/
}