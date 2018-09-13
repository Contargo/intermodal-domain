package net.contargo.intermodal.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.contargo.intermodal.domain.Chassis;
import net.contargo.intermodal.domain.Truck;
import net.contargo.intermodal.domain.TruckChassisCombination;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class TruckChassisCombinationTest {

    @Test
    void ensureCanBeCreated() {

        TruckChassisCombination truckChassisCombination = TruckChassisCombination.newBuilder()
                .withTruck(Truck.newBuilder().buildAndValidate())
                .withChassis(Chassis.newBuilder().buildAndValidate())
                .buildAndValidate();

        assertNotNull(truckChassisCombination.getChassis());
        assertNotNull(truckChassisCombination.getTruck());
    }


    @Test
    void ensureCanBeCopied() {

        TruckChassisCombination truckChassisCombination = TruckChassisCombination.newBuilder()
                .withTruck(Truck.newBuilder().buildAndValidate())
                .withChassis(Chassis.newBuilder().buildAndValidate())
                .buildAndValidate();

        TruckChassisCombination copiedTruckChassisCombination = TruckChassisCombination.newBuilder(
                truckChassisCombination)
                .buildAndValidate();

        assertNotNull(copiedTruckChassisCombination.getChassis());
        assertNotNull(copiedTruckChassisCombination.getTruck());
    }


    @Test
    void ensureCanBeParsedToJson() throws IOException {

        TruckChassisCombination truckChassisCombination = TruckChassisCombination.newBuilder()
                .withTruck(Truck.newBuilder().withEuAuthorization(true).buildAndValidate())
                .withChassis(Chassis.newBuilder().withEuAuthorization(true).buildAndValidate())
                .buildAndValidate();

        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(truckChassisCombination);

        TruckChassisCombination deserialize = mapper.readValue(jsonString, TruckChassisCombination.class);

        assertNotNull(deserialize.getChassis());
        assertNotNull(deserialize.getTruck());
        assertEquals(true, deserialize.getChassis().getEuAuthorization());
        assertEquals(true, deserialize.getTruck().getEuAuthorization());
    }
}
