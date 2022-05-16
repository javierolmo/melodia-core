package com.javi.uned.melodiacore.model;

import com.javi.uned.melodiacore.model.constants.Acordes;
import com.javi.uned.melodiacore.model.constants.MelodiaRelativePitches;
import org.junit.jupiter.api.Test;

class AcordeTest {

    @Test
    public void test() {
        MelodiaRelativePitch[] pitches = Acordes.TRIADA_MAYOR.of(MelodiaRelativePitches.D);
        System.out.println("Hola");
    }

}