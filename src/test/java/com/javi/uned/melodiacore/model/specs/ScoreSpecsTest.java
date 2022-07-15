package com.javi.uned.melodiacore.model.specs;

import com.javi.uned.melodiacore.model.Compas;
import com.javi.uned.melodiacore.model.Instrumento;
import com.javi.uned.melodiacore.model.constants.Compases;
import com.javi.uned.melodiacore.model.constants.Figuras;
import com.javi.uned.melodiacore.model.constants.Instrumentos;
import com.javi.uned.melodiacore.model.constants.Tonalidades;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ScoreSpecsTest {

    private ScoreSpecs scoreSpecs;

    @BeforeAll
    public void setUp() {
        scoreSpecs = new ScoreSpecs();
        scoreSpecs.setRequesterId(1);
        scoreSpecs.setMovementTitle("Movement title");
        scoreSpecs.setMovementNumber("Movement number");
        scoreSpecs.setAuthors(Arrays.asList("Author 1", "Author 2"));
        scoreSpecs.setMeasures(4);
        scoreSpecs.setCompas(Compases.COMPAS_2x4);
        scoreSpecs.setInstrumentos(new Instrumento[] { Instrumentos.VIOLIN, Instrumentos.PIANO });
        scoreSpecs.setTonalidad(Tonalidades.LA_B_M);
        scoreSpecs.setPhraseLength(8);
        scoreSpecs.setMinFigura(Figuras.FUSA);
        scoreSpecs.setMaxFigura(Figuras.BLANCA);
    }

    @Test
    void toDTO() {

        ScoreSpecsDTO scoreSpecsDTO = scoreSpecs.toDTO();
        ScoreSpecs scoreSpecs2 = scoreSpecsDTO.toScoreSpecs();

        assertEquals(scoreSpecs, scoreSpecs2);

    }
}