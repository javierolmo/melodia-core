package com.javi.uned.melodiacore.domain;

import java.util.Optional;

public class Figure {

    public static final Figure SEMIFUSA = new Figure("64th", 'x', 1);
    public static final Figure FUSA = new Figure("32nd", 't', 2);
    public static final Figure SEMICORCHEA = new Figure("16th", 's', 4);
    public static final Figure CORCHEA = new Figure("eighth", 'i', 8);
    public static final Figure NEGRA = new Figure("quarter", 'q', 16);
    public static final Figure BLANCA = new Figure("half", 'h', 32);
    public static final Figure REDONDA = new Figure("whole", 'w',64);

    private String type;
    private char staccatoName;
    private int duration;

    public Figure() {

    }

    public Figure(String type, char staccatoName, int duration) {
        this.type = type;
        this.staccatoName = staccatoName;
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public char toStaccatoChar() {
        return staccatoName;
    }

    public void setStaccatoName(char staccatoName) {
        this.staccatoName = staccatoName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String ref() {
        return type;
    }

    public static Figure byValue(int value){
        switch (value){
            case 1: return REDONDA;
            case 2: return BLANCA;
            case 4: return NEGRA;
            case 8: return CORCHEA;
            case 16: return SEMICORCHEA;
            case 32: return FUSA;
            case 64: return SEMIFUSA;
            default: throw new IllegalArgumentException("Figura con valor "+value+" inválida");
        }
    }

    public static Figure[] getFigures(){
        return new Figure[] {SEMIFUSA, FUSA, SEMICORCHEA, CORCHEA, NEGRA, BLANCA, REDONDA};
    }

    public static Optional<Figure> byRef(String figuraRef) {
        for (Figure figura : getFigures()) {
            if(figura.ref().equals(figuraRef)) {
                return Optional.of(figura);
            }
        }
        return Optional.empty();
    }
}