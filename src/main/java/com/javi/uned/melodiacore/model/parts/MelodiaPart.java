package com.javi.uned.melodiacore.model.parts;

import com.javi.uned.melodiacore.model.MelodiaInstrument;
import com.javi.uned.melodiacore.model.measures.MelodiaMeasure;

import java.util.ArrayList;
import java.util.List;

public class MelodiaPart {

    private final MelodiaInstrument melodiaInstrument;
    private final List<MelodiaMeasure> measures;

    public MelodiaPart(int size, MelodiaInstrument melodiaInstrument) {
        this.melodiaInstrument = melodiaInstrument;
        this.measures = new ArrayList<>();

        //Inicializar compases vacios
        for(int i=0; i<size; i++){
            MelodiaMeasure melodiaMeasure = new MelodiaMeasure(melodiaInstrument);
            measures.add(melodiaMeasure);
        }
    }

    public MelodiaInstrument getInstrumento() {
        return melodiaInstrument;
    }

    public List<MelodiaMeasure> getMeasures() {
        return measures;
    }

}
