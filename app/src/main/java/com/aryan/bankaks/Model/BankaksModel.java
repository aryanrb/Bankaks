package com.aryan.bankaks.Model;

public class BankaksModel {
    private String status, message;
    private ResultModel result;

    public BankaksModel(String status, String message, ResultModel result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ResultModel getResult() {
        return result;
    }
}
