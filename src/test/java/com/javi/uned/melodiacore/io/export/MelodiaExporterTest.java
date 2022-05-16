package com.javi.uned.melodiacore.io.export;

import com.javi.uned.melodiacore.exceptions.ExportException;
import com.javi.uned.melodiacore.model.MelodiaScore;
import com.javi.uned.melodiacore.model.specs.ScoreSpecs;
import com.javi.uned.melodiacore.util.MelodiaRandom;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MelodiaExporterTest {

    private MelodiaScore melodiaScore;
    private String testDir = "test/unexistingfolder";

    @BeforeAll
    void setUp() {
        MelodiaRandom melodiaRandom = new MelodiaRandom();
        melodiaScore = melodiaRandom.randomScore(ScoreSpecs.builder().build());
    }

    @AfterAll
    void tearDown() throws IOException {
        FileUtils.forceDelete(new File("test"));
    }

    @Test
    void toXML_success() {
        try {
            MelodiaExporter.toXML(melodiaScore, testDir+"/test1.musicxml");
        } catch (ExportException e) {
            e.printStackTrace();
            assert false;
        }
    }

    @Test
    void toXML_invalid_format() throws IOException {
        File folder = new File(this.testDir);
        folder.mkdirs();
        File file = new File(folder, "test2.musicxml");
        file.createNewFile();
        assertThrows(ExportException.class, () -> MelodiaExporter.toXML(melodiaScore, testDir+"/test2.musicxml"));
    }

    @Test
    void toXML_invalid_path() {
        assertThrows(ExportException.class, () -> MelodiaExporter.toXML(melodiaScore, testDir+"/test2.invalid"));
    }
}