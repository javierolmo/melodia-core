package com.javi.uned.melodiacore.domain;

import com.javi.uned.melodiacore.domain.enums.Step;

public class MelodiaToken {

    private Step step;
    private byte octave;
    private Figure figure;
    private byte alter;

    public Step getStep() {
        return step;
    }

    public void setStep(Step step) {
        this.step = step;
    }

    public byte getOctave() {
        return octave;
    }

    public void setOctave(byte octave) {
        this.octave = octave;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public byte getAlter() {
        return alter;
    }

    public void setAlter(byte alter) {
        this.alter = alter;
    }

    public int pitch() {
        return octave*Step.values().length + step.ordinal() + alter;
    }

    public String toStaccatoString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(step.name());
        switch (alter) {
            case -2: stringBuilder.append("bb"); break;
            case -1: stringBuilder.append("b"); break;
            case 1: stringBuilder.append("#"); break;
            case 2: stringBuilder.append("##"); break;
            default: break;
        }
        if(octave != 0) stringBuilder.append(octave);
        stringBuilder.append(figure.toStaccatoChar());
        return stringBuilder.toString();
    }
}
