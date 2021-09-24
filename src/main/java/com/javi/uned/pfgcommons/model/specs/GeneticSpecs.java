package com.javi.uned.pfgcommons.model.specs;

import com.javi.uned.pfgcommons.model.Compas;
import com.javi.uned.pfgcommons.model.Figura;
import com.javi.uned.pfgcommons.model.Instrumento;
import com.javi.uned.pfgcommons.model.Tonalidad;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GeneticSpecs {

    private int requesterId;
    private String movementTitle;
    private String movementNumber;
    private String[] authors;
    private int measures;
    private Compas compas;
    private Instrumento[] instrumentos;
    private Tonalidad tonalidad;
    private int phraseLength = 8;
    private Figura minFigura;
    private Figura maxFigura;

    public int getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(int requesterId) {
        this.requesterId = requesterId;
    }

    public String getMovementTitle() {
        return movementTitle;
    }

    public void setMovementTitle(String movementTitle) {
        this.movementTitle = movementTitle;
    }

    public String getMovementNumber() {
        return movementNumber;
    }

    public void setMovementNumber(String movementNumber) {
        this.movementNumber = movementNumber;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public int getMeasures() {
        return measures;
    }

    public void setMeasures(int measures) {
        this.measures = measures;
    }

    public Compas getCompas() {
        return compas;
    }

    public void setCompas(Compas compas) {
        this.compas = compas;
    }

    public Instrumento[] getInstrumentos() {
        return instrumentos;
    }

    public void setInstrumentos(Instrumento[] instrumentos) {
        this.instrumentos = instrumentos;
    }

    public Tonalidad getTonalidad() {
        return tonalidad;
    }

    public void setTonalidad(Tonalidad tonalidad) {
        this.tonalidad = tonalidad;
    }

    public int getPhraseLength() {
        return phraseLength;
    }

    public void setPhraseLength(int phraseLength) {
        this.phraseLength = phraseLength;
    }

    public Figura getMinFigura() {
        return minFigura;
    }

    public void setMinFigura(Figura minFigura) {
        this.minFigura = minFigura;
    }

    public Figura getMaxFigura() {
        return maxFigura;
    }

    public void setMaxFigura(Figura maxFigura) {
        this.maxFigura = maxFigura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneticSpecs that = (GeneticSpecs) o;
        return requesterId == that.requesterId && measures == that.measures && phraseLength == that.phraseLength && Objects.equals(movementTitle, that.movementTitle) && Objects.equals(movementNumber, that.movementNumber) && Arrays.equals(authors, that.authors) && Objects.equals(compas, that.compas) && Arrays.equals(instrumentos, that.instrumentos) && Objects.equals(tonalidad, that.tonalidad) && Objects.equals(minFigura, that.minFigura) && Objects.equals(maxFigura, that.maxFigura);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(requesterId, movementTitle, movementNumber, measures, compas, tonalidad, phraseLength, minFigura, maxFigura);
        result = 31 * result + Arrays.hashCode(authors);
        result = 31 * result + Arrays.hashCode(instrumentos);
        return result;
    }
}
