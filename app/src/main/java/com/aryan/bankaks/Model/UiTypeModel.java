package com.aryan.bankaks.Model;

public class UiTypeModel {

    private String type;
    private ValueModel[] values;

    public UiTypeModel(String type, ValueModel[] values) {
        this.type = type;
        this.values = values;
    }

    public String getType() {
        return type;
    }

    public ValueModel[] getValues() {
        return values;
    }
}
