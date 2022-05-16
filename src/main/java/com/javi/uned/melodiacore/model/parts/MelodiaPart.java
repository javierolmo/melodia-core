package com.javi.uned.melodiacore.model.parts;

import com.javi.uned.melodiacore.model.Instrumento;
import com.javi.uned.melodiacore.model.measures.MeasureFactory;
import com.javi.uned.melodiacore.model.measures.MelodiaMeasure;

import java.util.ArrayList;
import java.util.List;

public class MelodiaPart {

    private final Instrumento instrumento;
    private final List<MelodiaMeasure> measures;

    public MelodiaPart(int size, Instrumento instrumento) {
        this.instrumento = instrumento;
        this.measures = new ArrayList<>();

        //Inicializar compases vacios
        for(int i=0; i<size; i++){
            MelodiaMeasure melodiaMeasure = MeasureFactory.createEmptyMeasure(instrumento);
            measures.add(melodiaMeasure);
        }
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public List<MelodiaMeasure> getMeasures() {
        return measures;
    }

}
