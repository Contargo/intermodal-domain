package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.StatusLU;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class StatusLUTest {

    @Test
    void canBeCreated() {

        StatusLU statusLU = StatusLU.Builder.newStatusLU()
                .isReadyForLoading(true)
                .isLoaded(false)
                .isInspectionOut(false)
                .isOut(false)
                .hasInspectionIn(true)
                .isIn(true)
                .isReadyForUnloading(false)
                .isUnloaded(true)
                .buildAndValidate();

        assertTrue(statusLU.isReadyForLoading());
        assertTrue(statusLU.getInspectionIn());
        assertTrue(statusLU.isIn());
        assertTrue(statusLU.isUnloaded());
        assertFalse(statusLU.isLoaded());
        assertFalse(statusLU.getInspectionOut());
        assertFalse(statusLU.isOut());
        assertFalse(statusLU.isReadyForUnloading());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        StatusLU statusLU = StatusLU.Builder.newStatusLU()
                .isReadyForLoading(true)
                .isLoaded(false)
                .isInspectionOut(false)
                .isOut(false)
                .hasInspectionIn(true)
                .isIn(true)
                .isReadyForUnloading(false)
                .isUnloaded(true)
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(statusLU);

        StatusLU deserialize = mapper.readValue(jsonString, StatusLU.class);

        assertTrue(deserialize.isReadyForLoading());
        assertTrue(deserialize.getInspectionIn());
        assertTrue(deserialize.isIn());
        assertTrue(deserialize.isUnloaded());
        assertFalse(deserialize.isLoaded());
        assertFalse(deserialize.getInspectionOut());
        assertFalse(deserialize.isOut());
        assertFalse(deserialize.isReadyForUnloading());
    }
}
