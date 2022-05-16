package com.javi.uned.melodiacore.model.measures;

import com.javi.uned.melodiacore.model.Instrumento;
import com.javi.uned.melodiacore.model.Staff;

public class SimpleMeasure extends MelodiaMeasure{

    public SimpleMeasure(Instrumento instrumento) {
        super(instrumento);
    }

    public Staff staff() {
        return this.getStaves()[0];
    }

}
