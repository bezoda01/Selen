package selen.js;

public enum JScripts {
    LOADSTATE("return document.readyState");

    private final String value;

    JScripts(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
