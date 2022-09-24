package com.javi.uned.melodiacore.model.specs;

import com.javi.uned.melodiacore.model.Compas;
import com.javi.uned.melodiacore.model.Figura;
import com.javi.uned.melodiacore.model.MelodiaInstrument;
import com.javi.uned.melodiacore.model.Tonalidad;
import com.javi.uned.melodiacore.model.constants.*;

import java.util.Arrays;

public class ScoreSpecsBuilder {

    private final ScoreSpecs scoreSpecs;

    private ScoreSpecsBuilder() {
        this.scoreSpecs = new ScoreSpecs();
    }

    public static ScoreSpecsBuilder defaultBuilder() {
        ScoreSpecsBuilder scoreSpecsBuilder = new ScoreSpecsBuilder();

        // Set default values
        scoreSpecsBuilder.scoreSpecs.setCompas(Compases.COMPAS_4x4);
        scoreSpecsBuilder.scoreSpecs.setMaxFigura(Figuras.BLANCA);
        scoreSpecsBuilder.scoreSpecs.setMinFigura(Figuras.SEMICORCHEA);
        scoreSpecsBuilder.scoreSpecs.setTonalidad(Tonalidades.DO_M);
        scoreSpecsBuilder.scoreSpecs.setMelodiaInstruments(Arrays.asList(Instrumentos.PIANO));
        scoreSpecsBuilder.scoreSpecs.setAuthors(Arrays.asList("Melodia"));
        scoreSpecsBuilder.scoreSpecs.setMovementTitle("Melodía default title");
        scoreSpecsBuilder.scoreSpecs.setMovementNumber("1");
        scoreSpecsBuilder.scoreSpecs.setStyle(Style.BOOGIE_WOOGIE);

        return scoreSpecsBuilder;
    }

    public ScoreSpecsBuilder compas(Compas compas) {
        this.scoreSpecs.setCompas(compas);
        return this;
    }

    public ScoreSpecsBuilder maxFigura(Figura figura) {
        this.scoreSpecs.setMaxFigura(figura);
        return this;
    }

    public ScoreSpecsBuilder minFigura(Figura figura) {
        this.scoreSpecs.setMinFigura(figura);
        return this;
    }

    public ScoreSpecsBuilder tonalidad(Tonalidad tonalidad) {
        this.scoreSpecs.setTonalidad(tonalidad);
        return this;
    }

    public ScoreSpecsBuilder instruments(MelodiaInstrument... melodiaInstruments) {
        this.scoreSpecs.setMelodiaInstruments(Arrays.asList(melodiaInstruments));
        return this;
    }

    public ScoreSpecsBuilder authors(String...authors) {
        this.scoreSpecs.setAuthors(Arrays.asList(authors));
        return this;
    }

    public ScoreSpecsBuilder movementTitle(String movementTitle) {
        this.scoreSpecs.setMovementTitle(movementTitle);
        return this;
    }

    public ScoreSpecsBuilder movementNumber(String movementNumber) {
        this.scoreSpecs.setMovementNumber(movementNumber);
        return this;
    }

    public ScoreSpecs build() {
        return this.scoreSpecs;
    }
}
