package com.javi.uned.melodiacore.model.constants;

import com.javi.uned.melodiacore.model.Acorde;

import static com.javi.uned.melodiacore.model.constants.Distancias.*;

public class Acordes {

    // Tríadas
    public static final Acorde TRIADA_MAYOR = new Acorde(D_1_U, D_3_M, D_5_J);
    public static final Acorde TRIADA_MENOR = new Acorde(D_1_U, D_3_m, D_5_J);
    public static final Acorde TRIADA_AUMENTADA = new Acorde(D_1_U, D_3_M, D_5_A);
    public static final Acorde TRIADA_DISMINUIDA = new Acorde(D_1_U, D_3_m, D_5_D);

    // Tétradas
    public static final Acorde TETRADA_MAYOR_7M = new Acorde(D_1_U, D_3_M, D_5_J, D_7_M);
    public static final Acorde TETRADA_MAYOR_7m = new Acorde(D_1_U, D_3_M, D_5_J, D_7_m);
    public static final Acorde TETRADA_MENOR_7M = new Acorde(D_1_U, D_3_m, D_5_J, D_7_M);
    public static final Acorde TETRADA_MENOR_7m = new Acorde(D_1_U, D_3_m, D_5_J, D_7_m);
    public static final Acorde TETRADA_AUMENTADA_7M = new Acorde(D_1_U, D_3_M, D_5_A, D_7_M);
    public static final Acorde TETRADA_AUMENTADA_7m = new Acorde(D_1_U, D_3_M, D_5_A, D_7_m);
    public static final Acorde TETRADA_DISMINUIDA_7M = new Acorde(D_1_U, D_3_m, D_5_D, D_7_m);
    public static final Acorde TETRADA_DISMINUIDA_7m = new Acorde(D_1_U, D_3_m, D_5_D, D_7_d);

    public static Acorde[] getAcordes() {
        return new Acorde[]{
                TRIADA_MAYOR, TRIADA_MENOR, TRIADA_AUMENTADA, TRIADA_DISMINUIDA, TETRADA_MAYOR_7M, TETRADA_MAYOR_7m,
                TETRADA_MENOR_7M, TETRADA_MENOR_7m, TETRADA_AUMENTADA_7M, TETRADA_AUMENTADA_7m, TETRADA_DISMINUIDA_7M,
                TETRADA_DISMINUIDA_7m};
    }

}
