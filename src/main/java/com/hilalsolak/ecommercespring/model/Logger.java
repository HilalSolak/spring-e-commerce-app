package com.hilalsolak.ecommercespring.model;

import jakarta.persistence.Entity;

@Entity
public class Logger extends BaseModel {
    private String request;
    private String response;

    public Logger() {
    }

    public Logger(String request, String response) {
        this.request = request;
        this.response = response;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
