package com.javi.uned.melodiacore.model;

import com.javi.uned.melodiacore.model.parts.MelodiaPart;
import com.javi.uned.melodiacore.model.specs.ScoreSpecs;

import java.util.ArrayList;
import java.util.List;

public class MelodiaScore {

    private List<MelodiaPart> parts;
    private final String movementTitle;
    private final String movementNumber;
    private final List<String> authors;

    public MelodiaScore(List<MelodiaPart> parts, String movementTitle, String movementNumber, List<String> authors) {
        this.parts = parts;
        this.movementTitle = movementTitle;
        this.movementNumber = movementNumber;
        this.authors = authors;
    }

    public String getMovementTitle() {
        return movementTitle;
    }

    public String getMovementNumber() {
        return movementNumber;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public List<MelodiaPart> getParts() {
        return parts;
    }

    public void setParts(List<MelodiaPart> parts) {
        this.parts = parts;
    }

}
