package com.aryan.bankaks.Model;

public class FieldModel {

    private String name, placeholder, regex, hint_text;
    private TypeModel type;
    private UiTypeModel ui_type;
    private boolean is_mandatory;

    public FieldModel(String name, String placeholder, String regex, String hint_text, TypeModel type, UiTypeModel ui_type, boolean is_mandatory) {
        this.name = name;
        this.placeholder = placeholder;
        this.regex = regex;
        this.hint_text = hint_text;
        this.type = type;
        this.ui_type = ui_type;
        this.is_mandatory = is_mandatory;
    }

    public String getName() {
        return name;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public String getRegex() {
        return regex;
    }

    public String getHint_text() {
        return hint_text;
    }

    public TypeModel getType() {
        return type;
    }

    public UiTypeModel getUi_type() {
        return ui_type;
    }

    public boolean isIs_mandatory() {
        return is_mandatory;
    }
}
