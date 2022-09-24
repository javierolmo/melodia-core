package com.javi.uned.melodiacore.model.structure;

import java.util.List;

public class Structure {

    private List<Section> sections;

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public int measures() {
        int result = 0;
        for (Section section : sections) {
            result += section.measures();
        }
        return result;
    }
}
