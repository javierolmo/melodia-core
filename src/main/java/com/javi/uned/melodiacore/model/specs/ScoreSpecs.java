package com.javi.uned.melodiacore.model.specs;

import com.javi.uned.melodiacore.model.Compas;
import com.javi.uned.melodiacore.model.Figura;
import com.javi.uned.melodiacore.model.Instrumento;
import com.javi.uned.melodiacore.model.Tonalidad;
import com.javi.uned.melodiacore.model.constants.Instrumentos;
import com.javi.uned.melodiacore.model.constants.Style;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ScoreSpecs {

    private int requesterId;
    private String movementTitle;
    private String movementNumber;
    private List<String> authors;
    private int measures;
    private Compas compas;
    private Instrumento[] instrumentos;
    private Tonalidad tonalidad;
    private int phraseLength = 8;
    private Figura minFigura;
    private Figura maxFigura;

    private Style style;

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

    public static ScoreSpecsBuilder builder() {
        return ScoreSpecsBuilder.defaultBuilder();
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreSpecs that = (ScoreSpecs) o;
        return requesterId == that.requesterId && measures == that.measures && phraseLength == that.phraseLength && Objects.equals(movementTitle, that.movementTitle) && Objects.equals(movementNumber, that.movementNumber) && Objects.equals(authors, that.authors) && Objects.equals(compas, that.compas) && Arrays.equals(instrumentos, that.instrumentos) && Objects.equals(tonalidad, that.tonalidad) && Objects.equals(minFigura, that.minFigura) && Objects.equals(maxFigura, that.maxFigura);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(requesterId, movementTitle, movementNumber, authors, measures, compas, tonalidad, phraseLength, minFigura, maxFigura);
        result = 31 * result + Arrays.hashCode(instrumentos);
        return result;
    }

    public ScoreSpecsDTO toDTO() {

        String[] instrumentoRefs = Arrays.stream(instrumentos)
                .map(instrumento -> instrumento.getRef())
                .toArray(String[]::new);

        ScoreSpecsDTO dto = new ScoreSpecsDTO();
        dto.setRequesterId(requesterId);
        dto.setMovementTitle(movementTitle);
        dto.setMovementNumber(movementNumber);
        dto.setAuthors(authors);
        dto.setMeasures(measures);
        dto.setCompasRef(compas.ref());
        dto.setRefInstrumentos(instrumentoRefs);
        dto.setTonalidadRef(tonalidad.ref());
        dto.setPhraseLength(phraseLength);
        dto.setMinFiguraRef(minFigura.ref());
        dto.setMaxFiguraRef(maxFigura.ref());

        return dto;

    }
}
