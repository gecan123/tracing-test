package com.example.tracingtest;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.status;

@RestController
public class GlobalErrorController implements ErrorController {

    private static Logger log = LoggerFactory.getLogger(GlobalErrorController.class);

    @RequestMapping(value = "/error", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> error(HttpServletRequest request) {
        log.error("Exception occurred. apiError: {}", MDC.get("traceId"));
        return status(500).body(new ApiResponse());
    }
}
