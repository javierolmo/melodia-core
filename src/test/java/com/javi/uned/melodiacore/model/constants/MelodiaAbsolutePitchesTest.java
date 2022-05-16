package com.javi.uned.melodiacore.model.constants;

import com.javi.uned.melodiacore.model.MelodiaAbsolutePitch;
import com.javi.uned.melodiacore.util.MelodiaRandom;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MelodiaAbsolutePitchesTest {

    MelodiaRandom melodiaRandom = new MelodiaRandom();

    @RepeatedTest(100)
    void Random_MinAndMaxWithSharps_BoundsCheck() {
        MelodiaAbsolutePitch minPitch = melodiaRandom.randomPitch(MelodiaAbsolutePitches.A0, MelodiaAbsolutePitches.A4, true);
        MelodiaAbsolutePitch maxPitch = melodiaRandom.randomPitch(MelodiaAbsolutePitches.A4, MelodiaAbsolutePitches.G7_S, true);

        MelodiaAbsolutePitch randomPitch = melodiaRandom.randomPitch(minPitch, maxPitch, true);
        assert randomPitch.compareTo(minPitch) >= 0;
        assert randomPitch.compareTo(maxPitch) <= 0;
        System.out.println(randomPitch);
    }

    @RepeatedTest(100)
    void Random_MinAndMaxWithFlats_BoundsCheck() {
        MelodiaAbsolutePitch minPitch = melodiaRandom.randomPitch(MelodiaAbsolutePitches.A0, MelodiaAbsolutePitches.A4, false);
        MelodiaAbsolutePitch maxPitch = melodiaRandom.randomPitch(MelodiaAbsolutePitches.A4, MelodiaAbsolutePitches.G7_S, false);

        MelodiaAbsolutePitch randomPitch = melodiaRandom.randomPitch(minPitch, maxPitch, false);
        assert randomPitch.compareTo(minPitch) >= 0;
        assert randomPitch.compareTo(maxPitch) <= 0;
        System.out.println(randomPitch);
    }

    @RepeatedTest(100)
    void Random_MinAndMaxC4B4_BoundsCheck() {
        MelodiaAbsolutePitch randomPitch = melodiaRandom.randomPitch(MelodiaAbsolutePitches.C4, MelodiaAbsolutePitches.B4, true);
        assert randomPitch.compareTo(MelodiaAbsolutePitches.C4) >= 0;
        assert randomPitch.compareTo(MelodiaAbsolutePitches.B4) <= 0;
        System.out.println(randomPitch);
    }

}