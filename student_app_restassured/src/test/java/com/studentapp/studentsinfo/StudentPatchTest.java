package com.studentapp.studentsinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StudentPatchTest extends TestBase {

    @Test
    public void updateStudentEmailId() {

        StudentPojo studentPojo1 = new StudentPojo();

        studentPojo1.setEmail("vpatel123@gmail.com");

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo1)
                .patch("/1");
        response.then().log().all().statusCode(200);
        response.prettyPrint();

    }

}

