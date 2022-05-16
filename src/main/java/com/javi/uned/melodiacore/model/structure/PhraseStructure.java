package com.javi.uned.melodiacore.model.structure;

import com.javi.uned.melodiacore.model.Tonalidad;

import java.util.ArrayList;
import java.util.List;

public class PhraseStructure {

    private List<MeasureStructure> measureStructureList;
    private Tonalidad tonalidad;

    public PhraseStructure(Tonalidad tonalidad) {
        this.tonalidad = tonalidad;
        this.measureStructureList = new ArrayList<>();
    }

    public PhraseStructure(Tonalidad tonalidad, int measures) {
        this.tonalidad = tonalidad;
        this.measureStructureList = new ArrayList<>();
        for(int i=0; i< measures; i++) {
            this.measureStructureList.add(new MeasureStructure());
        }
    }

    public List<MeasureStructure> getMeasureStructureList() {
        return measureStructureList;
    }

    public void setMeasureStructureList(List<MeasureStructure> measureStructureList) {
        this.measureStructureList = measureStructureList;
    }

}
