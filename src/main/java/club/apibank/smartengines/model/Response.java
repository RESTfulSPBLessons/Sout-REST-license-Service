package club.apibank.smartengines.model;
// This Project created by Anton Romanov (www.antonromanov.com) 05.03.2018 at 16:49

import java.sql.Date;

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
