package com.studentapp.studentsinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StudentPostTest extends TestBase {

    @Test
    public void createStudent(){
        List<String> courses =new ArrayList<>();
        courses.add("JAVA");
        courses.add("API");
        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setFirstName("Varsha");
        studentPojo.setLastName("Patel");
        studentPojo.setEmail("vpatel12@gmail.com");
        studentPojo.setProgramme("Software Testing");
        studentPojo.setCourses(courses);

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().log().all().statusCode(201);
        response.prettyPrint();

    }


}
