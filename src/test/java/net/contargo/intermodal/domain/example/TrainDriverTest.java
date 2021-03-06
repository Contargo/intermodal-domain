package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Address;
import net.contargo.intermodal.domain.Location;
import net.contargo.intermodal.domain.TestDataCreator;
import net.contargo.intermodal.domain.TrainDriver;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class TrainDriverTest {

    @Test
    void ensureTrainDriverCanBeCreated() {

        Address address = TestDataCreator.createAddress();

        TrainDriver trainDriver = TrainDriver.newBuilder()
                .withName("Mustermann")
                .withFirstName("Max")
                .withAddress(address)
                .withCellphone("01234/56789")
                .bornOn("1980-01-13")
                .bornIn(Location.newBuilder().withCity("Karlsruhe").buildAndValidate())
                .withNationality("DE")
                .withRid(Instant.parse("2018-12-31T00:00:00Z"))
                .buildAndValidate();

        assertEquals("Mustermann", trainDriver.getName());
        assertEquals("Max", trainDriver.getFirstName());
        assertNotNull(trainDriver.getAddress());
        assertEquals("01234/56789", trainDriver.getCellphone());
        assertEquals("1980-01-13", trainDriver.getDateOfBirth().toString());
        assertEquals("Karlsruhe", trainDriver.getCityOfBirth().getCity());
        assertEquals("DE", trainDriver.getNationality());
        assertEquals("2018-12-31T00:00:00Z", trainDriver.getRid().toString());
    }


    @Test
    void ensureCanBeCopied() {

        TrainDriver trainDriver = TrainDriver.newBuilder()
                .withName("Mustermann")
                .withFirstName("Max")
                .withAddress(TestDataCreator.createAddress())
                .withCellphone("01234/56789")
                .bornOn("1980-01-13")
                .bornIn(Location.newBuilder().withCity("Karlsruhe").buildAndValidate())
                .withNationality("DE")
                .withRid(Instant.parse("2018-12-31T00:00:00Z"))
                .buildAndValidate();

        TrainDriver copiedTrainDriver = TrainDriver.newBuilder(trainDriver).buildAndValidate();

        assertEquals("Mustermann", copiedTrainDriver.getName());
        assertEquals("Max", copiedTrainDriver.getFirstName());
        assertNotNull(copiedTrainDriver.getAddress());
        assertEquals("01234/56789", copiedTrainDriver.getCellphone());
        assertEquals("1980-01-13", copiedTrainDriver.getDateOfBirth().toString());
        assertEquals("Karlsruhe", copiedTrainDriver.getCityOfBirth().getCity());
        assertEquals("DE", copiedTrainDriver.getNationality());
        assertEquals("2018-12-31T00:00:00Z", copiedTrainDriver.getRid().toString());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        Address address = TestDataCreator.createAddress();

        TrainDriver trainDriver = TrainDriver.newBuilder()
                .withName("Mustermann")
                .withFirstName("Max")
                .withAddress(address)
                .withCellphone("01234/56789")
                .bornOn("1980-01-13")
                .bornIn(Location.newBuilder().withCity("Karlsruhe").buildAndValidate())
                .withNationality("DE")
                .withRid(Instant.parse("2018-12-31T00:00:00Z"))
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(trainDriver);

        TrainDriver deserialize = mapper.readValue(jsonString, TrainDriver.class);

        assertEquals("Mustermann", deserialize.getName());
        assertEquals("Max", deserialize.getFirstName());
        assertNotNull(deserialize.getAddress());
        assertEquals("01234/56789", deserialize.getCellphone());
        assertEquals("1980-01-13", deserialize.getDateOfBirth().toString());
        assertEquals("Karlsruhe", deserialize.getCityOfBirth().getCity());
        assertEquals("DE", deserialize.getNationality());
        assertEquals("2018-12-31T00:00:00Z", deserialize.getRid().toString());
    }
}
