package com.studentapp.studentsinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StudentDeleteTest extends TestBase {
  @Test
    public void studentDelete(){


      Response response = given()
            //  .header("Content-Type", "application/json")
              .when()
            //  .body("/50")
              .delete("/50");
      response.then().log().all().statusCode(204);
      response.prettyPrint();


  }
}
