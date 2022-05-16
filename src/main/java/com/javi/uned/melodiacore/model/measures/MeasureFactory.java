package com.javi.uned.melodiacore.model.measures;

import com.javi.uned.melodiacore.model.Instrumento;
import com.javi.uned.melodiacore.model.constants.Instrumentos;
import com.javi.uned.melodiacore.model.specs.ScoreSpecs;
import com.javi.uned.melodiacore.model.specs.ScoreSpecsBuilder;

public class MeasureFactory {

    private static final ScoreSpecs defaultSpecs = ScoreSpecsBuilder.defaultBuilder().build();

    public static MelodiaMeasure createEmptyMeasure(Instrumento instrumento) {
        if(instrumento.equals(Instrumentos.PIANO)){
            return new PianoMeasure();
        } else {
            return new SimpleMeasure(instrumento);
        }
    }
}
