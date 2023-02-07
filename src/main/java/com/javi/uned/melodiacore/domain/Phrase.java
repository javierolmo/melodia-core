package com.javi.uned.melodiacore.domain;

import java.util.Arrays;
import java.util.stream.Stream;

public class Phrase {

    private Measure[] measures;

    public Phrase(Measure[] measures) {
        this.measures = measures;
    }

    public Measure[] getMeasures() {
        return measures;
    }

    public void setMeasures(Measure[] measures) {
        this.measures = measures;
    }

    public MelodiaToken[] tokens() {
        return Arrays.stream(measures)
                .map(Measure::getTokens)
                .flatMap(Stream::of)
                .toArray(MelodiaToken[]::new);
    }
}
