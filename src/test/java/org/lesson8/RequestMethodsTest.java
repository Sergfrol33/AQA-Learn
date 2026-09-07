package org.lesson8;

import org.junit.jupiter.api.Test;
import org.lesson8.models.Person;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RequestMethodsTest extends BaseTest {

    @Test
    public void PositiveGet() {
        given()
                .when()
                .get("/get").then()
                .statusCode(200);

    }

    @Test
    public void QueryPositiveGet() {
        given()
                .when().queryParam("foo1", "bar1")
                .get("/get")
                .then().log().body()
                .and().body("args.foo1", equalTo("bar1"));

    }

    @Test
    public void QueryNotNullGet() {
        given()
                .when().queryParam("foo1", "bar1")
                .get("/get")
                .then().log().body()
                .and().body("args.foo1", notNullValue());

    }

    @Test
    void shouldReturnCorrectUrl() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body(
                        "url",
                        equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2")
                );
    }

    @Test
    public void QueryNegativeGet() {
        given()
                .when().queryParam("hand", "wave")
                .get("/get")
                .then().log().body()
                .and().body("args.foo1", not(equalTo("bar1")));

    }

    @Test
    public void emptyPost() {
        given().contentType("text/plain")
                .when().post("/post")
                .then().statusCode(200);
    }

    @Test
    public void whenCreationPersonWithoutId() {
        Person person = new Person("Sergey");
        given().contentType("application/json").body(person)
                .when()
                .post("/post")
                .then().log().body().statusCode(200)
                .and().body("data.name", equalTo(person.getName()));
    }

    @Test
    public void whenCreationPersonWithId() {
        Person person = new Person("Sergey", 3);
        given().contentType("application/json").body(person)
                .when()
                .post("/post")
                .then().log().body()
                .statusCode(200)
                .body("data.name", equalTo(person.getName()))
                .body("data.id", equalTo(person.getId()));
    }

    @Test
    public void whenCreationPersonNegative() {
        Person person = new Person("Michael", 10);
        given().contentType("application/json").body(person)
                .when()
                .post("/post")
                .then().log().body()
                .statusCode(200)
                .body("data.name", not(equalTo("Sergey")))
                .body("data.id", not(equalTo(3)));
    }

    @Test
    public void whenCreationPersonFormData() {
        Person person = new Person("Michael", 10);
        given().multiPart("name", person.getName())
                .multiPart("id", person.getId())
                .when()
                .post("/post")
                .then().log().body()
                .statusCode(200)
                .body("form.name", equalTo(person.getName()))
                .body("form.id", equalTo(Integer.toString(person.getId())));
    }

    @Test
    public void emptyPut() {
        given().contentType("text/plain")
                .when().put("/put")
                .then().statusCode(200);
    }

    @Test
    public void whenUpdatePersonWithoutId() {
        Person person = new Person("Sergey");
        given().contentType("application/json").body(person)
                .when()
                .put("/put")
                .then().log().body().statusCode(200)
                .and().body("data.name", equalTo(person.getName()));
    }

    @Test
    public void whenUpdatePersonWithId() {
        Person person = new Person("Sergey", 3);
        given().contentType("application/json").body(person)
                .when()
                .put("/put")
                .then().log().body()
                .statusCode(200)
                .body("data.name", equalTo(person.getName()))
                .body("data.id", equalTo(person.getId()));
    }

    @Test
    public void whenUpdatePersonNegative() {
        Person person = new Person("Michael", 10);
        given().contentType("application/json").body(person)
                .when()
                .put("/put")
                .then().log().body()
                .statusCode(200)
                .body("data.name", not(equalTo("Sergey")))
                .body("data.id", not(equalTo(3)));
    }

    @Test
    public void whenUpdatePersonFormData() {
        Person person = new Person("Michael", 10);
        given().multiPart("name", person.getName())
                .multiPart("id", person.getId())
                .when()
                .put("/put")
                .then().log().body()
                .statusCode(200)
                .body("form.name", equalTo(person.getName()))
                .body("form.id", equalTo(Integer.toString(person.getId())));
    }

    @Test
    void patchPositive() {
        Person person = new Person("Michael", 10);

        given()
                .contentType("application/json")
                .body(person)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200);
    }

    @Test
    void emptyPatch() {
        given()
                .when()
                .patch("/patch")
                .then()
                .statusCode(200);
    }

    @Test
    void patchCorrectResponseData() {
        Person person = new Person("Michael", 10);

        given()
                .contentType("application/json")
                .body(person)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data.name", equalTo(person.getName()))
                .body("data.id", equalTo(person.getId()));
    }

    @Test
    void patchWithTextContentType() {
        given()
                .contentType("text/plain")
                .body("Hello")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo("Hello"));
    }


    @Test
    void deletePositive() {
        Person person = new Person("Michael", 10);

        given()
                .contentType("application/json")
                .body(person)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200);
    }

    @Test
    void emptyDelete() {
        given()
                .when()
                .patch("/patch")
                .then()
                .statusCode(200);
    }

    @Test
    void deleteCorrectResponseData() {
        Person person = new Person("Michael", 10);

        given()
                .contentType("application/json")
                .body(person)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data.name", equalTo(person.getName()))
                .body("data.id", equalTo(person.getId()));
    }

    @Test
    void deleteWithTextContentType() {
        given()
                .contentType("text/plain")
                .body("Hello")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo("Hello"));
    }
}
