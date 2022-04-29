package com.qa.customassertion;

import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class ResponseAssert extends AbstractAssert<ResponseAssert, Response> {

    private ResponseAssert(Response response, Class<?> selfType) {
        super(response, selfType);
    }

    public static ResponseAssert assertThat(Response response){
        return new ResponseAssert(response,ResponseAssert.class);
    }

    public ResponseAssert isSuccessFulPostResponse() {
        Assertions.assertThat(actual.getStatusCode())
                .isEqualTo(201)
                .withFailMessage(() -> "status code is not 201");
        return this;
    }

    public ResponseAssert hasHeaderApplicationJson() {
        Assertions.assertThat(actual.header("Content-Type"))
                .contains("application/json")
                .withFailMessage(() -> "header with content type as application/json is not present");
        return this;
    }

    public ResponseAssert hasCacheControlHeader() {
        Assertions.assertThat(actual.header("Cache-Control"))
                .contains("no-cache")
                .withFailMessage(() -> "header with cache-control is not having no cache value");
        return this;
    }

}
