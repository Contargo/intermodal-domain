package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * Facility for transport of persons or goods.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Verkehrsmittel
 * @abbreviation_german  VM
 * @abbreviation_english  MoT
 * @name_english  means of transport
 * @definition_german  Einrichtung zum Transport von Personen und Gütern.
 * @definition_english  Facility for transport of persons or goods.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(
    {
        @JsonSubTypes.Type(value = Barge.class, name = "barge"),
        @JsonSubTypes.Type(value = Chassis.class, name = "chassis"),
        @JsonSubTypes.Type(value = Truck.class, name = "truck"),
        @JsonSubTypes.Type(value = Vessel.class, name = "vessel")
    }
)
public interface MeansOfTransport {
}
