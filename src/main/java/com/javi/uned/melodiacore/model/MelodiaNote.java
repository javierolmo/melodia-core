package com.javi.uned.melodiacore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.audiveris.proxymusic.TimeModification;

import java.util.Objects;

public class MelodiaNote {

    private MelodiaAbsolutePitch pitch;
    private Figura figura;
    private TimeModification timeModification;

    public MelodiaNote(){

    }

    public MelodiaNote(MelodiaAbsolutePitch pitch, Figura figura) {
        this.figura = figura;
        this.pitch = pitch;
    }

    public MelodiaAbsolutePitch getPitch() {
        return pitch;
    }

    public void setPitch(MelodiaAbsolutePitch pitch) {
        this.pitch = pitch;
    }

    public Figura getFigura() {
        return figura;
    }

    public void setFigura(Figura figura) {
        this.figura = figura;
    }

    public TimeModification getTimeModification() {
        return timeModification;
    }

    public void setTimeModification(TimeModification timeModification) {
        this.timeModification = timeModification;
    }

    @JsonIgnore
    public int comparePitch(MelodiaNote note2){
        return this.pitch.compareTo(note2.pitch);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MelodiaNote that = (MelodiaNote) o;
        return Objects.equals(pitch, that.pitch) && Objects.equals(figura, that.figura) && Objects.equals(timeModification, that.timeModification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pitch, figura, timeModification);
    }

    @Override
    public String toString() {
        return "NoteComposite{" +
                "pitch=" + pitch +
                ", figura=" + figura +
                ", timeModification=" + timeModification +
                '}';
    }
}
