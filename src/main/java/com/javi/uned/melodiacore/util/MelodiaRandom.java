package com.javi.uned.melodiacore.util;

import com.javi.uned.melodiacore.model.*;
import com.javi.uned.melodiacore.model.constants.*;
import com.javi.uned.melodiacore.model.measures.MelodiaMeasure;
import com.javi.uned.melodiacore.model.parts.MelodiaPart;
import com.javi.uned.melodiacore.model.specs.ScoreSpecs;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.random.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MelodiaRandom {

    private RandomGenerator randomGenerator;

    public MelodiaRandom(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public MelodiaScore randomScore(ScoreSpecs scoreSpecs) {
        MelodiaScore melodiaScore = new MelodiaScore(
                randomMelodiaPartList(scoreSpecs),
                scoreSpecs.getMovementTitle(),
                scoreSpecs.getMovementNumber(),
                scoreSpecs.getAuthors()
        );
        return melodiaScore;
    }

    public List<MelodiaPart> randomMelodiaPartList(ScoreSpecs scoreSpecs) {
        List<MelodiaPart> parts = new ArrayList<>();
        for (MelodiaInstrument melodiaInstrument : scoreSpecs.getMelodiaInstruments()) {
            MelodiaPart melodiaPart = randomPart(
                    scoreSpecs.getStructure().measures(),
                    melodiaInstrument,
                    scoreSpecs.getMinFigura(),
                    scoreSpecs.getMaxFigura());
            parts.add(melodiaPart);
        }
        return parts;
    }

    public MelodiaInstrument randomInstrumento() {
        MelodiaInstrument[] melodiaInstruments = Instrumentos.getInstrumentos();
        return melodiaInstruments[this.randomGenerator.nextInt(melodiaInstruments.length)];
    }

    public MelodiaNote randomNote (Figura minFigura, Figura maxFigura, MelodiaAbsolutePitch minPitch, MelodiaAbsolutePitch maxPitch) {
        return new MelodiaNote(
                randomPitch(minPitch, maxPitch, this.randomGenerator.nextBoolean()),
                randomFigura(minFigura, maxFigura));

    }

    public Figura randomFigura(Figura min, Figura max){
        Figura[] figuras = Figuras.getFiguras();

        int minIndex = ArrayUtils.indexOf(figuras, min);
        int maxIndex = ArrayUtils.indexOf(figuras, max);
        int selectedIndex = this.randomGenerator.nextInt(maxIndex-minIndex+1) + minIndex;

        return figuras[selectedIndex];
    }

    public Compas randomCompas() {
        Compas[] compases = Compases.getCompases();
        return compases[this.randomGenerator.nextInt(compases.length)];
    }

    public MelodiaMeasure randomMeasure(MelodiaInstrument melodiaInstrument, Figura minFigura, Figura maxFigura){
        MelodiaMeasure melodiaMeasure = new MelodiaMeasure(melodiaInstrument);
        melodiaMeasure.setTonality(randomTonality());
        melodiaMeasure.setGrade(randomGrado());
        for (int i=0; i<melodiaMeasure.getStaves().length; i++) {
            melodiaMeasure.getStaves()[i].randomize(minFigura, maxFigura, randomGenerator); //TODO: Desacoplar staves de measures para poder manipular independientemente
        }
        return melodiaMeasure;
    }

    public MelodiaAbsolutePitch randomPitch(MelodiaAbsolutePitch min, MelodiaAbsolutePitch max, boolean preferSharps) {
        int pitchRange = max.calculateSemitones() - min.calculateSemitones();
        int pitch = this.randomGenerator.nextInt(pitchRange) + min.calculateSemitones();
        int octave = pitch / 12;
        MelodiaStep step = MelodiaStep.of(pitch % 12, preferSharps);
        int alter = pitch % 12 - step.getSemitones();
        return new MelodiaAbsolutePitch(octave, step, alter);
    }

    public Tonalidad randomTonality(){
        Tonalidad[] tonalidades = Tonalidades.getTonalidades();
        int index = this.randomGenerator.nextInt(tonalidades.length);
        return tonalidades[index];
    }

    public Grado randomGrado() {
        Grado[] grados = Grado.getGrados();
        int index = this.randomGenerator.nextInt(grados.length);
        return grados[index];
    }

    public MelodiaPart randomPart(int measures, MelodiaInstrument melodiaInstrument, Figura minFigura, Figura maxFigura) {
        MelodiaPart melodiaPart = new MelodiaPart(measures, melodiaInstrument);

        for (int i = 0; i < melodiaPart.getMeasures().size(); i++) {
            melodiaPart.getMeasures().set(i, randomMeasure(melodiaInstrument, minFigura, maxFigura));
        }

        return melodiaPart;
    }

    //TODO: Aquí se puede mejorar. Aleatorizar nueva figura en función del espacio disponible
    /*
    public void randomStaff(GeneticSpecs geneticSpecs) {
        Staff staff = new Staff();
        while(!isFull()){
            MelodiaNote melodiaNote = randomNote(
                    geneticSpecs.getMinFigura(),
                    geneticSpecs.getMaxFigura(),
                    tesitura.getIntervalo().getLower(),
                    tesitura.getIntervalo().getHigher());
            appendNote(melodiaNote);
        }
    }
     */

}
