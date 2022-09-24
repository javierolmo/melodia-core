package com.javi.uned.melodiacore.util;

import com.javi.uned.melodiacore.model.*;
import com.javi.uned.melodiacore.model.constants.Figuras;
import com.javi.uned.melodiacore.model.constants.Instrumentos;
import com.javi.uned.melodiacore.model.constants.MelodiaAbsolutePitches;
import com.javi.uned.melodiacore.model.measures.MelodiaMeasure;
import com.javi.uned.melodiacore.model.parts.MelodiaPart;
import com.javi.uned.melodiacore.model.specs.ScoreSpecs;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MelodiaRandomTest {

    private MelodiaRandom melodiaRandom;

    @BeforeEach
    void setUp() {
        melodiaRandom = new MelodiaRandom();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void randomScore() {

        ScoreSpecs scoreSpecs = ScoreSpecs.builder().build();

        MelodiaScore melodiaScore = melodiaRandom.randomScore(scoreSpecs);

        assertEquals(scoreSpecs.getMovementTitle(), melodiaScore.getMovementTitle());
        assertEquals(scoreSpecs.getAuthors(), melodiaScore.getAuthors());
        assertEquals(scoreSpecs.getMovementNumber(), melodiaScore.getMovementNumber());
        assertEquals(scoreSpecs.getCompas(), melodiaScore.getParts().get(0).getMeasures().get(0).getCompas());

        for (MelodiaPart part : melodiaScore.getParts()) {
            for (MelodiaMeasure measure : part.getMeasures()) {
                for (Staff staff : measure.getStaves()) {
                    assertTrue(staff.isFull());
                    for (MelodiaNote note : staff.getNotes()) {
                        assertTrue(scoreSpecs.getMinFigura().getDuration() <= note.getFigura().getDuration());
                        assertTrue(scoreSpecs.getMaxFigura().getDuration() >= note.getFigura().getDuration());
                    }
                }
            }
        }
    }

    @Test
    void randomInstrumento() {
        MelodiaInstrument melodiaInstrument = melodiaRandom.randomInstrumento();
        assertNotNull(melodiaInstrument);
    }

    @Test
    @RepeatedTest(100)
    void randomNote() {
        Figura minFigura = Figuras.SEMICORCHEA;
        Figura maxFigura = Figuras.BLANCA;
        MelodiaAbsolutePitch minPitch = MelodiaAbsolutePitches.A2;
        MelodiaAbsolutePitch maxPitch = MelodiaAbsolutePitches.A5;

        MelodiaNote melodiaNote = melodiaRandom.randomNote(minFigura, maxFigura, minPitch, maxPitch);

        assertTrue(melodiaNote.getFigura().getDuration() >= minFigura.getDuration());
        assertTrue(melodiaNote.getFigura().getDuration() <= maxFigura.getDuration());
        assertTrue(melodiaNote.getPitch().compareTo(minPitch) >= 0);
        assertTrue(melodiaNote.getPitch().compareTo(maxPitch) <= 0);
    }

    @Test
    @RepeatedTest(50)
    void randomFigura() {
        Figura minFigura = Figuras.FUSA;
        Figura maxFigura = Figuras.BLANCA;

        Figura figura = melodiaRandom.randomFigura(minFigura, maxFigura);

        assertTrue(figura.getDuration() >= minFigura.getDuration());
        assertTrue(figura.getDuration() <= maxFigura.getDuration());
    }

    @Test
    void randomCompas() {
        //TODO
    }

    @Test
    @RepeatedTest(50)
    void randomMeasure() {
        MelodiaInstrument melodiaInstrument = Instrumentos.PIANO;
        Figura minFigura = Figuras.FUSA;
        Figura maxFigura = Figuras.BLANCA;

        MelodiaMeasure melodiaMeasure = melodiaRandom.randomMeasure(melodiaInstrument, minFigura, maxFigura);

        assertEquals(melodiaMeasure.getInstrumento(), melodiaInstrument);
        assertEquals(melodiaMeasure.getStaves().length, 2);
        for (Staff staff : melodiaMeasure.getStaves()) {
            for (MelodiaNote note : staff.getNotes()) {
                assertTrue(minFigura.getDuration() <= note.getFigura().getDuration());
                assertTrue(maxFigura.getDuration() >= note.getFigura().getDuration());
            }
        }
    }

    @Test
    void randomPitch() {
        //TODO
    }

    @Test
    void randomTonality() {
        //TODO
    }

    @Test
    void randomGrado() {
        //TODO
    }
}