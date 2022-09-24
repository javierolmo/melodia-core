package com.javi.uned.melodiacore.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javi.uned.melodiacore.model.constants.Instrumentos;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MelodiaInstrumentTest {

    private MelodiaInstrument melodiaInstrument = Instrumentos.PIANO;
    private ObjectMapper objectMapper;


    @BeforeAll
    public void setupObjectMapper(){
        objectMapper = new ObjectMapper();
    }

    @Test
    void checkSerializable() throws JsonProcessingException {
        String serialized = objectMapper.writeValueAsString(melodiaInstrument);
        System.out.println(serialized);
        MelodiaInstrument deserialized = objectMapper.readValue(serialized, MelodiaInstrument.class);
        assertEquals(melodiaInstrument, deserialized);
    }

}