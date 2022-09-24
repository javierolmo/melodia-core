package com.javi.uned.melodiacore.model.specs;

import com.javi.uned.melodiacore.model.Compas;
import com.javi.uned.melodiacore.model.Figura;
import com.javi.uned.melodiacore.model.MelodiaInstrument;
import com.javi.uned.melodiacore.model.Tonalidad;
import com.javi.uned.melodiacore.model.constants.Compases;
import com.javi.uned.melodiacore.model.constants.Figuras;
import com.javi.uned.melodiacore.model.constants.Instrumentos;
import com.javi.uned.melodiacore.model.constants.Tonalidades;

import java.util.*;

public class ScoreSpecsDTO {

    private int requesterId;
    private String movementTitle;
    private String movementNumber;
    private List<String> authors;
    private String compasRef;
    private List<String> refInstrumentos;
    private String tonalidadRef;
    private String minFiguraRef;
    private String maxFiguraRef;

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

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getCompasRef() {
        return compasRef;
    }

    public void setCompasRef(String compasRef) {
        this.compasRef = compasRef;
    }

    public List<String> getRefInstrumentos() {
        return refInstrumentos;
    }

    public void setRefInstrumentos(List<String> refInstrumentos) {
        this.refInstrumentos = refInstrumentos;
    }

    public String getTonalidadRef() {
        return tonalidadRef;
    }

    public void setTonalidadRef(String tonalidadRef) {
        this.tonalidadRef = tonalidadRef;
    }

    public String getMinFiguraRef() {
        return minFiguraRef;
    }

    public void setMinFiguraRef(String minFiguraRef) {
        this.minFiguraRef = minFiguraRef;
    }

    public String getMaxFiguraRef() {
        return maxFiguraRef;
    }

    public void setMaxFiguraRef(String maxFiguraRef) {
        this.maxFiguraRef = maxFiguraRef;
    }

    /**
     * Transforms a ScoreSpecsDTO into a ScoreSpecs model object.
     *
     * @return the ScoreSpecs model object
     */
    public ScoreSpecs toScoreSpecs() {

        List<MelodiaInstrument> melodiaInstruments = new ArrayList<>();
        for (String refInstrumento : refInstrumentos) {
            melodiaInstruments.add(Instrumentos.byRef(refInstrumento).get());
        }
        Compas compas = Compases.byRef(compasRef)
                .orElseThrow(() -> new IllegalArgumentException("Measure not found by ref: " + compasRef));
        Tonalidad tonalidad = Tonalidades.byRef(tonalidadRef)
                .orElseThrow(() -> new IllegalArgumentException("Tonality not found by ref: " + tonalidadRef));
        Figura minFigura = Figuras.byRef(minFiguraRef)
                .orElseThrow(() -> new IllegalArgumentException("Figure not found by ref: " + minFiguraRef));
        Figura maxFigura = Figuras.byRef(maxFiguraRef)
                .orElseThrow(() -> new IllegalArgumentException("Figure not found by ref: " + maxFiguraRef));

        ScoreSpecs scoreSpecs = new ScoreSpecs();
        scoreSpecs.setRequesterId(requesterId);
        scoreSpecs.setMovementTitle(movementTitle);
        scoreSpecs.setMovementNumber(movementNumber);
        scoreSpecs.setAuthors(authors);
        scoreSpecs.setCompas(compas);
        scoreSpecs.setMelodiaInstruments(melodiaInstruments);
        scoreSpecs.setTonalidad(tonalidad);
        scoreSpecs.setMinFigura(minFigura);
        scoreSpecs.setMaxFigura(maxFigura);

        return scoreSpecs;
    }


    @Override
    public String toString() {
        return "ScoreSpecsDTO{" +
                "requesterId=" + requesterId +
                ", movementTitle='" + movementTitle + '\'' +
                ", movementNumber='" + movementNumber + '\'' +
                ", authors=" + String.join(", ", authors) +
                ", compasRef='" + compasRef + '\'' +
                ", refInstrumentos=" + String.join(", ", refInstrumentos)  +
                ", tonalidadRef='" + tonalidadRef + '\'' +
                ", minFiguraRef='" + minFiguraRef + '\'' +
                ", maxFiguraRef='" + maxFiguraRef + '\'' +
                '}';
    }
}
