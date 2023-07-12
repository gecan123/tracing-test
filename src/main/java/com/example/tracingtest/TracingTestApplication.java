package com.example.tracingtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@SpringBootApplication
@RestController
public class TracingTestApplication {

    private static Logger log = LoggerFactory.getLogger(TracingTestApplication.class);

    @RequestMapping("/has-exception-handler")
    public ApiResponse hasExceptionHandler() throws IOException {
        log.info("hasExceptionHandler invoked.");
        if (true) {
            throw new IOException("error");
        }
        return new ApiResponse();
    }

    @RequestMapping("/no-exception-handler")
    public ApiResponse hasNoExceptionHandler()  {
        log.info("hasNoExceptionHandler invoked.");
        if (true) {
            throw new RuntimeException("runtime");
        }
        return new ApiResponse();
    }

    @PatchMapping("/only-support-patch")
    public ApiResponse onlySupportPatch()  {
        log.info("onlySupportPatch invoked.");
        return new ApiResponse();
    }


    public static void main(String[] args) {
        SpringApplication.run(TracingTestApplication.class, args);
    }

}
