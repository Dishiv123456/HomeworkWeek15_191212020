package com.studentapp.studentsinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StudentPutTest extends TestBase {

    @Test
    public void studentDetailsUpdate(){
        List<String> courses =new ArrayList<>();
        courses.add("JAVA");
        courses.add("API");
        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setFirstName("Dishiv");
        studentPojo.setLastName("Patel");
        studentPojo.setEmail("vpatel113@gmail.com");
        studentPojo.setProgramme("Software Testing");
        studentPojo.setCourses(courses);

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .put("/10");
        response.then().log().all().statusCode(200);
        response.prettyPrint();


    }
}
