package com.javi.uned.melodiacore.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javi.uned.melodiacore.model.constants.Compases;
import com.javi.uned.melodiacore.model.constants.Instrumentos;
import com.javi.uned.melodiacore.model.constants.Tonalidades;
import com.javi.uned.melodiacore.model.specs.ScoreSpecs;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserSpecsTest {

    private ScoreSpecs scoreSpecs;
    private ObjectMapper objectMapper;

    @BeforeAll
    public void setupSpecs(){
        scoreSpecs = new ScoreSpecs();
        scoreSpecs.setMovementTitle("Título");
        scoreSpecs.setMovementNumber("1");
        scoreSpecs.setMelodiaInstruments(Arrays.asList(Instrumentos.PIANO));
        scoreSpecs.setCompas(Compases.COMPAS_4x4);
        scoreSpecs.setAuthors(Arrays.asList("Javier Olmo Injerto"));
        scoreSpecs.setTonalidad(Tonalidades.DO_M);
    }

    @BeforeAll
    public void setupObjectMapper(){
        objectMapper = new ObjectMapper();
    }

    @Test
    void checkSerializable() throws JsonProcessingException {
        String serialized = objectMapper.writeValueAsString(scoreSpecs);
        System.out.println(serialized);
        ScoreSpecs deserialized = objectMapper.readValue(serialized, ScoreSpecs.class);
        assertEquals(scoreSpecs, deserialized);
    }

}