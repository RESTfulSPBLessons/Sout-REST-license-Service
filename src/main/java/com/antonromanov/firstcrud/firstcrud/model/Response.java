package com.antonromanov.firstcrud.firstcrud.model;
// This Project created by Anton Romanov (www.antonromanov.com) 26.03.2018 at 17:30
// Git Hub repo - https://github.com/RESTfulSPBLessons/Sout-REST-license-Service/tree/tomcat-version
// http://192.168.1.40:8080/license/rest/check?serial=1

public class Response {

    private String Message;
    private Boolean doExit;

    public Response(String message, Boolean doExit) {
        this.Message = message;
        this.doExit = doExit;
    }

    public Response() {
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Boolean getDoExit() {
        return doExit;
    }

    public void setDoExit(Boolean doExit) {
        this.doExit = doExit;
    }


}
