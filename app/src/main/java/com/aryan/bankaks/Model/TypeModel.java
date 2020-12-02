package com.aryan.bankaks.Model;

public class TypeModel {

    private String array_name, data_type;
    private boolean is_array;

    public TypeModel(String array_name, String data_type, boolean is_array) {
        this.array_name = array_name;
        this.data_type = data_type;
        this.is_array = is_array;
    }

    public String getArray_name() {
        return array_name;
    }

    public String getData_type() {
        return data_type;
    }

    public boolean isIs_array() {
        return is_array;
    }
}
