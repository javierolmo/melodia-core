package com.javi.uned.melodiacore.model.constants;

import com.javi.uned.melodiacore.model.MelodiaInstrument;
import com.javi.uned.melodiacore.model.Scope;

import java.util.Optional;

public class Instrumentos {

    public static final MelodiaInstrument PIANO = new MelodiaInstrument("PIANO", "PNO", "Piano", null, "Pno.","keyboard.piano", new Scope(Tesituras.PIANO_MANO_DERECHA, Claves.SOL2), new Scope(Tesituras.PIANO_MANO_IZQUIERDA, Claves.FA4));
    public static final MelodiaInstrument VIOLIN = new MelodiaInstrument("VIOLIN","VLN", "Violin", null, "Vln.", "strings.violin", new Scope(Tesituras.VIOLIN, Claves.SOL2));
    public static final MelodiaInstrument SAXOFON_TENOR = new MelodiaInstrument("SAXOFON_TENOR","SAX", "Saxofon", null, "Sax.", "wind.reed.saxophone.tenor", new Scope(Tesituras.VIOLIN, Claves.SOL2));

    private Instrumentos () {  }

    public static MelodiaInstrument[] getInstrumentos(){
        return new MelodiaInstrument[]{PIANO, VIOLIN, SAXOFON_TENOR};
    }

    public static Optional<MelodiaInstrument> byRef(String instrumentoRef) {
        switch (instrumentoRef) {
            case "PIANO": return Optional.of(PIANO);
            case "VIOLIN": return Optional.of(VIOLIN);
            case "SAXOFON_TENOR": return Optional.of(SAXOFON_TENOR);
            default: return Optional.empty();
        }
    }
}
