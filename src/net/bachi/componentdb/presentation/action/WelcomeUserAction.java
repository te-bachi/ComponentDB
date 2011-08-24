package net.bachi.componentdb.presentation.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

public class WelcomeUserAction extends ActionSupport {
    private String userName;
    private String message;

    @Action(value = "/welcome", results = {
            @Result(name="success", location = "/results/successPage.jsp")
    })
    public String execute() {
        message = "Welcome " + userName;
        return SUCCESS;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public String getMessage() {
        return message;
    }
}