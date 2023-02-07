package com.javi.uned.melodiacore.domain;

import java.util.Objects;
import java.util.Optional;

public class TimeSignature {

    public static final TimeSignature COMPAS_2x4 = new TimeSignature(2, 4, 2);
    public static final TimeSignature COMPAS_3x4 = new TimeSignature(3, 4, 3);
    public static final TimeSignature COMPAS_4x4 = new TimeSignature(4, 4, 4);
    public static final TimeSignature COMPAS_3X8 = new TimeSignature(3, 8, 3);
    public static final TimeSignature COMPAS_6X8 = new TimeSignature(6, 8, 2);
    public static final TimeSignature COMPAS_9X8 = new TimeSignature(9, 8, 3);
    public static final TimeSignature COMPAS_12X8 = new TimeSignature(12, 8, 4);

    private int topNumber;
    private int bottomNumber;
    private int beats;

    public TimeSignature(){

    }

    public TimeSignature(int numerador, int denominador, int pulsos) {
        this.topNumber = numerador;
        this.bottomNumber = denominador;
        this.beats = pulsos;
    }

    public int getTopNumber() {
        return topNumber;
    }

    public void setTopNumber(int topNumber) {
        this.topNumber = topNumber;
    }

    public int getBottomNumber() {
        return bottomNumber;
    }

    public void setBottomNumber(int bottomNumber) {
        this.bottomNumber = bottomNumber;
    }

    public int getBeats() {
        return beats;
    }

    public void setBeats(int beats) {
        this.beats = beats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeSignature that = (TimeSignature) o;
        return topNumber == that.topNumber && bottomNumber == that.bottomNumber && beats == that.beats;
    }

    @Override
    public int hashCode() {
        return Objects.hash(topNumber, bottomNumber, beats);
    }

    public String ref() {
        return String.format("%d/%d", topNumber, bottomNumber);
    }

    public static TimeSignature[] all(){
        return new TimeSignature[]{COMPAS_2x4, COMPAS_3x4, COMPAS_4x4, COMPAS_3X8, COMPAS_6X8, COMPAS_6X8, COMPAS_9X8, COMPAS_12X8};
    }

    public static Optional<TimeSignature> byRef(String compasRef) {
        for (TimeSignature compas : all()) {
            if (compasRef.equals(compas.ref())) {
                return Optional.of(compas);
            }
        }
        return Optional.empty();
    }

    public int getDuration() {
        return topNumber * Figure.byValue(bottomNumber).getDuration();
    }
}
