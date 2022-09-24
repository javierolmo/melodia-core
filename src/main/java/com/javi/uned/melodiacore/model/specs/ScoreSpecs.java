package com.javi.uned.melodiacore.model.specs;

import com.javi.uned.melodiacore.model.Compas;
import com.javi.uned.melodiacore.model.Figura;
import com.javi.uned.melodiacore.model.MelodiaInstrument;
import com.javi.uned.melodiacore.model.Tonalidad;
import com.javi.uned.melodiacore.model.constants.Style;
import com.javi.uned.melodiacore.model.structure.Structure;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ScoreSpecs {

    private int requesterId;
    private String movementTitle;
    private String movementNumber;
    private List<String> authors;
    private Compas compas;
    private List<MelodiaInstrument> melodiaInstruments;
    private Tonalidad tonalidad;
    private Structure structure;
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

    public Compas getCompas() {
        return compas;
    }

    public void setCompas(Compas compas) {
        this.compas = compas;
    }

    public List<MelodiaInstrument> getMelodiaInstruments() {
        return melodiaInstruments;
    }

    public void setMelodiaInstruments(List<MelodiaInstrument> melodiaInstruments) {
        this.melodiaInstruments = melodiaInstruments;
    }

    public Tonalidad getTonalidad() {
        return tonalidad;
    }

    public void setTonalidad(Tonalidad tonalidad) {
        this.tonalidad = tonalidad;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
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
        return requesterId == that.requesterId && Objects.equals(movementTitle, that.movementTitle) && Objects.equals(movementNumber, that.movementNumber) && Objects.equals(authors, that.authors) && Objects.equals(compas, that.compas) && Objects.equals(melodiaInstruments, that.melodiaInstruments) && Objects.equals(tonalidad, that.tonalidad) && Objects.equals(structure, that.structure) && Objects.equals(minFigura, that.minFigura) && Objects.equals(maxFigura, that.maxFigura) && style == that.style;
    }

    @Override
    public int hashCode() {
        return Objects.hash(requesterId, movementTitle, movementNumber, authors, compas, melodiaInstruments, tonalidad, structure, minFigura, maxFigura, style);
    }

    public ScoreSpecsDTO toDTO() {

        List<String> instrumentRefs = new ArrayList<>();
        for (MelodiaInstrument melodiaInstrument : melodiaInstruments) {
            instrumentRefs.add(melodiaInstrument.getRef());
        }

        ScoreSpecsDTO dto = new ScoreSpecsDTO();
        dto.setRequesterId(requesterId);
        dto.setMovementTitle(movementTitle);
        dto.setMovementNumber(movementNumber);
        dto.setAuthors(authors);
        dto.setCompasRef(compas.ref());
        dto.setRefInstrumentos(instrumentRefs);
        dto.setTonalidadRef(tonalidad.ref());
        dto.setMinFiguraRef(minFigura.ref());
        dto.setMaxFiguraRef(maxFigura.ref());

        return dto;

    }
}
