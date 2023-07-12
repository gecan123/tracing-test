package com.example.tracingtest;


import org.slf4j.MDC;

public class ApiResponse {

    private String traceId;

    public ApiResponse() {
        this.traceId = MDC.get("traceId");
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
}
