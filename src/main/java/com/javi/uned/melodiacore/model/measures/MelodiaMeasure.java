package com.javi.uned.melodiacore.model.measures;

import com.javi.uned.melodiacore.model.*;
import com.javi.uned.melodiacore.model.constants.Compases;
import com.javi.uned.melodiacore.model.constants.Figuras;
import com.javi.uned.melodiacore.model.constants.Grado;

public abstract class MelodiaMeasure {

    private Compas compas;
    private Staff[] staves;
    private int divisions;
    private Instrumento instrumento;
    private Tonalidad tonality;
    private Grado grade;

    public MelodiaMeasure(Instrumento instrumento){
        this.divisions = 1;
        this.compas = Compases.COMPAS_4x4;
        this.staves = new Staff[instrumento.getScopes().length];
        this.instrumento = instrumento;

        //Create staffs
        for(int i=0; i<instrumento.getScopes().length; i++){
            Scope scope = instrumento.getScopes()[i];
            this.staves[i] = new Staff(this, scope.getClave(), i+1, scope.getTesitura());
        }
    }

    public void updateDivisions(){
        Figura minDurationFigure = Figuras.REDONDA;

        for(int i=0; i<staves.length; i++){
            for(MelodiaNote note : staves[i].getNotes()){
                if(note.getFigura().getValue() > minDurationFigure.getValue()){
                    minDurationFigure = note.getFigura();
                }
            }
        }

        int tmpDivisions = minDurationFigure.getValue() / Figuras.NEGRA.getValue();
        if(tmpDivisions >= 1) this.divisions = tmpDivisions;
    }

    public Compas getCompas() {
        return compas;
    }

    public void setCompas(Compas compas) {
        this.compas = compas;
    }

    public Staff[] getStaves() {
        return staves;
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public Tonalidad getTonality() {
        return tonality;
    }

    public void setTonality(Tonalidad tonality) {
        this.tonality = tonality;
    }

    public Grado getGrade() {
        return grade;
    }

    public void setGrade(Grado grade) {
        this.grade = grade;
    }

    public int getDivisions() {
        return divisions;
    }
}
