package com.aryan.bankaks.Model;

public class ResultModel {

    private String screen_title, operator_name, service_id;
    private int number_of_fields;
    private FieldModel[] fields;

    public ResultModel(String screen_title, String operator_name, String service_id, int number_of_fields, FieldModel[] fields) {
        this.screen_title = screen_title;
        this.operator_name = operator_name;
        this.service_id = service_id;
        this.number_of_fields = number_of_fields;
        this.fields = fields;
    }

    public String getScreen_title() {
        return screen_title;
    }

    public String getOperator_name() {
        return operator_name;
    }

    public String getService_id() {
        return service_id;
    }

    public int getNumber_of_fields() {
        return number_of_fields;
    }

    public FieldModel[] getFields() {
        return fields;
    }
}
