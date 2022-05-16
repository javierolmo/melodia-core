package com.javi.uned.melodiacore.model.measures;

import com.javi.uned.melodiacore.model.Staff;
import com.javi.uned.melodiacore.model.constants.Instrumentos;

public class PianoMeasure extends MelodiaMeasure{

    public PianoMeasure() {
        super(Instrumentos.PIANO);
    }

    public Staff rightHand() {
        return this.getStaves()[0];
    }

    public Staff leftHand() {
        return this.getStaves()[1];
    }
}
