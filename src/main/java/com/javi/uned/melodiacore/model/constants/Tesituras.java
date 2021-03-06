package com.javi.uned.melodiacore.model.constants;

import com.javi.uned.melodiacore.model.Tesitura;

public class Tesituras {

    public static final Tesitura PIANO_MANO_DERECHA = new Tesitura(MelodiaAbsolutePitches.G3, MelodiaAbsolutePitches.C6);
    public static final Tesitura PIANO_MANO_IZQUIERDA = new Tesitura(MelodiaAbsolutePitches.A2, MelodiaAbsolutePitches.G4);
    public static final Tesitura VIOLIN = new Tesitura(MelodiaAbsolutePitches.G3, MelodiaAbsolutePitches.A6);

    private Tesituras () {  }
}
