package com.javi.uned.melodiacore.model.structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreStructure {

    private Map<String, PhraseStructure> phraseMap;
    private List<String> sequence;

    public ScoreStructure() {
        phraseMap = new HashMap<>();
        sequence = new ArrayList<>();
    }

    public Map<String, PhraseStructure> getPhraseMap() {
        return phraseMap;
    }

    public void setPhraseMap(Map<String, PhraseStructure> phraseMap) {
        this.phraseMap = phraseMap;
    }

    public List<String> getSequence() {
        return sequence;
    }

    public void setSequence(List<String> sequence) {
        this.sequence = sequence;
    }
}
