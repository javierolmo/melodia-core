package com.javi.uned.melodiacore.io.export;

import com.javi.uned.melodiacore.model.*;
import com.javi.uned.melodiacore.model.constants.Claves;
import com.javi.uned.melodiacore.model.constants.Figuras;
import com.javi.uned.melodiacore.model.measures.MelodiaMeasure;
import com.javi.uned.melodiacore.model.parts.MelodiaPart;
import org.audiveris.proxymusic.*;
import org.audiveris.proxymusic.ScorePartwise.*;
import org.audiveris.proxymusic.ScorePartwise.Part.*;

import java.lang.String;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

//TODO: Testing
public class MusicProxyConverter {

    public Note toNote(MelodiaNote melodiaNote, int quarterDivisions, int staff) {
        Note note = new Note();

        //Pitch
        Pitch pitch = toPitch(melodiaNote.getPitch());
        note.setPitch(pitch);

        //Duration
        double duration = melodiaNote.getFigura().getDuration() * quarterDivisions;
        note.setDuration(BigDecimal.valueOf(duration));

        //Value
        NoteType noteType = new NoteType();
        noteType.setValue(melodiaNote.getFigura().getType());
        note.setType(noteType);

        //Staff
        note.setStaff(BigInteger.valueOf(staff+1));

        //Voice
        note.setVoice(""+staff);

        //Time modification
        if(melodiaNote.getTimeModification() != null) {
            note.setTimeModification(melodiaNote.getTimeModification());
        }
        return note;
    }

    public Pitch toPitch(MelodiaAbsolutePitch melodiaAbsolutePitch) {
        Pitch pitch = new Pitch();
        pitch.setStep(Step.valueOf(melodiaAbsolutePitch.getStep().getName()));
        pitch.setOctave(melodiaAbsolutePitch.getOctave());
        pitch.setAlter(BigDecimal.valueOf(melodiaAbsolutePitch.getAlter()));
        return pitch;
    }

    public Measure toMeasure(MelodiaMeasure melodiaMeasure, int number) {

        Measure measure = new Measure();
        Compas compas = melodiaMeasure.getCompas();

        //Attributes
        Attributes attributes = new Attributes();
        measure.getNoteOrBackupOrForward().add(attributes);
        attributes.setDivisions(BigDecimal.valueOf(melodiaMeasure.getDivisions()));

        if(number == 0) {

            //Staves
            attributes.setStaves(BigInteger.valueOf(melodiaMeasure.getStaves().length));

            //Clef
            for(int i=0; i<melodiaMeasure.getStaves().length; i++){
                Clef clef = Claves.toClef(melodiaMeasure.getStaves()[i].getClave());
                clef.setNumber(BigInteger.valueOf(i+1));
                attributes.getClef().add(clef);
            }

            // Time
            Time time = new Time();
            attributes.getTime().add(time);
            time.getTimeSignature().add(new ObjectFactory().createTimeBeats(String.valueOf(compas.getNumerador())));
            time.getTimeSignature().add(new ObjectFactory().createTimeBeatType(String.valueOf(compas.getDenominador())));
        }

        //Number
        measure.setNumber(String.valueOf(number));

        //Implicit
        measure.setImplicit(YesNo.NO);

        //Append notes to measure
        for(int i=0; i<melodiaMeasure.getStaves().length; i++){
            for(MelodiaNote melodiaNote : melodiaMeasure.getStaves()[i].getNotes()){
                Note note = toNote(melodiaNote, melodiaMeasure.getDivisions(), i);
                measure.getNoteOrBackupOrForward().add(note);
            }
            Backup backup = new Backup();
            int backupValue = (int) (melodiaMeasure.getDivisions()*compas.getNumerador()* Figuras.byValue(compas.getDenominador()).getDuration());
            backup.setDuration(BigDecimal.valueOf(backupValue));
            measure.getNoteOrBackupOrForward().add(backup);
        }
        return measure;
    }

    /**
     * Transformar en un objeto de clase {@link ScorePartwise} para poder exportarlo a xml
     * @param melodiaScore partitura
     * @return {@link ScorePartwise} con la misma información
     */
    public ScorePartwise toScorePartwise(MelodiaScore melodiaScore){
        ScorePartwise scorePartwise = new ScorePartwise();
        scorePartwise.setMovementTitle(melodiaScore.getMovementTitle());
        scorePartwise.setMovementNumber(melodiaScore.getMovementNumber());
        // scorePartwise.setVersion("1.0"); //TODO: Enterarme de como funciona esto
        scorePartwise.setDefaults(toDefaults());
        scorePartwise.setIdentification(toIdentification(melodiaScore.getAuthors()));
        scorePartwise.setWork(toWork(melodiaScore.getMovementTitle()));
        for(MelodiaPart melodiaPart : melodiaScore.getParts()){
            appendPart(scorePartwise, melodiaPart);
        }

        return scorePartwise;
    }

    public Defaults toDefaults(){
        Defaults defaults = new Defaults();

        //TODO:
        //Appearence
        //Lyric Font
        //Lyric Languaje
        //Music font
        //Page layout
        //Scalling
        //Staff Layout
        //System layout
        //Word font

        return defaults;
    }

    public Identification toIdentification(List<String> authors){
        Identification identification = new Identification();

        //Creators:
        for(String author : authors){
            TypedText typedText = new TypedText();
            typedText.setType("composer");
            typedText.setValue(author);
            identification.getCreator().add(typedText);
        }

        //TODO:
        //Encoding
        //Miscellaneous
        //Relation
        //Rights
        //Source

        return identification;
    }

    public Work toWork(String movementTitle){
        Work work = new Work();
        work.setWorkTitle(movementTitle);

        //TODO:
        //Work number
        //Opus

        return work;
    }

    private void appendPart(ScorePartwise scorePartwise, MelodiaPart melodiaPart) {

        //Append part to partlist
        PartList partList = scorePartwise.getPartList();
        if (scorePartwise.getPartList() == null) {
            partList = new PartList();
        }

        ScorePart scorePart = new ScorePart();
        partList.getPartGroupOrScorePart().add(scorePart);
        PartName partName = new PartName();
        partName.setValue(melodiaPart.getInstrumento().getName());
        scorePart.setPartName(partName);
        scorePart.setId(String.format("%s-%d", melodiaPart.getInstrumento().getCode(), 0)); //TODO: Esto debería cascar si hay dos parts con mismo instrumento, porque sus ids coincidirían

        scorePartwise.setPartList(partList);

        ScoreInstrument scoreInstrument = toScoreInstrument(melodiaPart.getInstrumento());
        scorePart.getScoreInstrument().add(scoreInstrument);


        //Append part to parts
        List<Part> parts = scorePartwise.getPart();
        Part part = new Part();
        part.setId(scorePart);
        parts.add(part);

        //Append measures to part
        for (int i = 0; i< melodiaPart.getMeasures().size(); i++) {
            MelodiaMeasure melodiaMeasure = melodiaPart.getMeasures().get(i);
            part.getMeasure().add(toMeasure(melodiaMeasure, i));
        }
    }

    public ScoreInstrument toScoreInstrument(MelodiaInstrument melodiaInstrument){
        ScoreInstrument scoreInstrument = new ScoreInstrument();
        scoreInstrument.setId(melodiaInstrument.getCode());
        scoreInstrument.setInstrumentName(melodiaInstrument.getName());
        scoreInstrument.setEnsemble(melodiaInstrument.getEnsemble());
        scoreInstrument.setInstrumentAbbreviation(melodiaInstrument.getAbbreviation());
        scoreInstrument.setInstrumentSound(melodiaInstrument.getSound());
        return scoreInstrument;
    }

}
