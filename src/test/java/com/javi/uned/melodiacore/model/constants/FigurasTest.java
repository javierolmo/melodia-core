package com.javi.uned.melodiacore.model.constants;

import com.javi.uned.melodiacore.model.Figura;
import com.javi.uned.melodiacore.util.MelodiaRandom;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FigurasTest {

    MelodiaRandom melodiaRandom = new MelodiaRandom();

    @RepeatedTest(100)
    void Random_MinAndMax_BoundsCheck() {
        Figura minFigura = melodiaRandom.randomFigura(Figuras.SEMIFUSA, Figuras.NEGRA);
        Figura maxFigura = melodiaRandom.randomFigura(Figuras.NEGRA, Figuras.REDONDA);

        Figura randomFigura = melodiaRandom.randomFigura(minFigura, maxFigura);
        assert randomFigura.getDuration() <= maxFigura.getDuration();
        assert randomFigura.getDuration() >= minFigura.getDuration();
        System.out.println(randomFigura);
    }

    @Test
    void Random_WrongBounds_Exception(){
        assertThrows(IllegalArgumentException.class, () -> melodiaRandom.randomFigura(Figuras.NEGRA, Figuras.CORCHEA));
    }

}