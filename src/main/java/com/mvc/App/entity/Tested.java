package com.mvc.App.entity;

public enum Tested {

    None (""), POSITIVE("Positive"), NEGATIVE("Negative"), NOT_TESTED("Not tested");

    private final String displayValue;

    Tested(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}
