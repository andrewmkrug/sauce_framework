package com.saucelabs.framework.apis;

import com.saucelabs.framework.data.DataObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import static io.restassured.RestAssured.given;

public abstract class APIObject {
    @Getter @Setter private String index;
    @Getter private String baseURL;
    @Getter private String endpoint;

    public String getPath() {
        return this.getBaseURL() + this.getEndpoint();
    }

    public Response create(Object object) {
        RequestSpecification requestSpecification = this.generateGiven();
        return requestSpecification
                .contentType(ContentType.JSON)
                .body(object)
                .when()
                .post(this.getPath())
                .then()
                .extract()
                .response();
    }

    protected RequestSpecification generateGiven() {
        return given();
    }

    @SneakyThrows
    public Response read(String id) {
        return this.generateGiven()
                .contentType(ContentType.JSON)
                .when()
                .get(this.getPath() + "/" + id)
                .then()
                .extract()
                .response();
    }

    public Response list() {
        return this.generateGiven()
                .contentType(ContentType.JSON)
                .when()
                .get(this.getPath())
                .then()
                .extract()
                .response();
    }

    // TODO - implement update
    public void update(String id, DataObject data) {
    }

    // TODO - implement destroy
    public void destroy(String id) {
    }


}
