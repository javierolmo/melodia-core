package com.javi.uned.melodiacore.domain;

import org.jfugue.midi.MidiDictionary;
import org.jfugue.player.Player;

import java.util.Set;

public class SpecsHelper {

    private static String[] instruments() {
        return MidiDictionary.INSTRUMENT_STRING_TO_BYTE.keySet().toArray(new String[]{});
    }

    private static String[] tempos() {
        return MidiDictionary.TEMPO_STRING_TO_INT.keySet().toArray(new String[]{});
    }

}
