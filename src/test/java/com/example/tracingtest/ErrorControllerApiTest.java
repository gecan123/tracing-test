package com.example.tracingtest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.actuate.observability.AutoConfigureObservability;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.Matchers.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith({ SpringExtension.class})
@AutoConfigureObservability
class ErrorControllerApiTest {

    @LocalServerPort
    private int port;

    @Test
    void shouldHaveTraceIdWhenCallErrorPathDirectly() {
        assertResponse("/error");
    }

    @Test
    void shouldHaveTraceIdWhenPathHaveExceptionHandler() {
        assertResponse("/has-exception-handler" );
    }

    @Test
    void shouldHaveTraceIdWhenPathHaveNoExceptionHandler() {
        assertResponse("/no-exception-handler" );
    }

    @Test
    void shouldHaveTraceIdWhenPathNotFound() {
        assertResponse("/not-found-path" );
    }

    @Test
    void shouldHaveTraceIdWhenMethodNotMatch() {
        assertResponse("/only-support-patch" );
    }

    private void assertResponse(String uri) {
        RestAssured.given().port(port).post(uri)
            .then()
            .assertThat()
            .contentType(APPLICATION_JSON_VALUE)
            .body("traceId", not(emptyOrNullString()));
    }
}
