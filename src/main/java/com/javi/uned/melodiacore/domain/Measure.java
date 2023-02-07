package com.javi.uned.melodiacore.domain;

public class Measure {

    private MelodiaToken[] tokens;

    public Measure(MelodiaToken[] tokens) {
        this.tokens = tokens;
    }

    public MelodiaToken[] getTokens() {
        return tokens;
    }

    public void setTokens(MelodiaToken[] tokens) {
        this.tokens = tokens;
    }
}
