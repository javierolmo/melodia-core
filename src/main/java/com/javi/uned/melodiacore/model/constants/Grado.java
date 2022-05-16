package com.javi.uned.melodiacore.model.constants;

public enum Grado {
    I,
    II,
    III,
    IV,
    V,
    VI,
    VII;

    public static Grado[] getGrados() {
        return new Grado[]{I, II, III, IV, V, VI, VII};
    }
}
