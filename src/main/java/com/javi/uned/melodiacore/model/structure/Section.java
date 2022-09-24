package com.javi.uned.melodiacore.model.structure;

import java.util.List;

public class Section {

    private String name;
    private List<Phrase> phrases;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Phrase> getPhrases() {
        return phrases;
    }

    public void setPhrases(List<Phrase> phrases) {
        this.phrases = phrases;
    }

    public int measures() {
        int result = 0;
        for (Phrase phrase : phrases) {
            result += phrase.getLength();
        }
        return result;
    }
}
