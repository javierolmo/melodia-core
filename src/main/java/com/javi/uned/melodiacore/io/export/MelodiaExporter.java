package com.javi.uned.melodiacore.io.export;

import com.javi.uned.melodiacore.exceptions.ExportException;
import com.javi.uned.melodiacore.model.MelodiaScore;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.audiveris.proxymusic.ScorePartwise;
import org.audiveris.proxymusic.util.Marshalling;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MelodiaExporter {

    private MelodiaExporter() {
    }

    public static void toXML(MelodiaScore melodiaScore, String path) throws ExportException {

        // Check extension
        String extension = FilenameUtils.getExtension(path);
        if(!extension.equals("musicxml")) {
            throw new ExportException("Los archivos MusicXML deben tener exteisón '.musicxml'");
        }

        // Check free path
        File file = new File(path);
        if (file.exists()) {
            throw new ExportException(String.format("Ya existe el archivo con la ruta '%s'.", path));
        } else {
            file.getParentFile().mkdirs();
        }

        try (FileOutputStream fos = new FileOutputStream(file)) {
            MusicProxyConverter musicProxyConverter = new MusicProxyConverter();
            ScorePartwise scorePartwise = musicProxyConverter.toScorePartwise(melodiaScore);
            Marshalling.marshal(scorePartwise, fos, true, 4);
        } catch (IOException | Marshalling.MarshallingException e) {
            throw new ExportException("Error al exportar al archivo " + file.getAbsolutePath(), e);
        }
    }


}
