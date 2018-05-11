package net.contargo.intermodal.domain.loadingUnit;

import net.contargo.intermodal.domain.LoadingUnit;
import net.contargo.intermodal.domain.LoadingUnitCategory;
import net.contargo.intermodal.domain.MeansOfTransport;

import javax.validation.constraints.NotNull;


/**
 * Case for the transport of goods for the change to another {@link MeansOfTransport means of transport}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Container
 * @name_english  Container
 * @definition_german  Behälter für den Gütertransport für den Wechsel von einer zur anderen
 *                     {@link MeansOfTransport Transportform}.
 * @definition_english  Case for the transport of goods for the change to another
 *                      {@link MeansOfTransport means of transport}.
 * @note_german  Containertypen können Flat-, Open-Top-, High-Cube-, Bulk-, ISO-, Reefer- oder Tank-Container sein.
 *               (@see DIN EN ISO 17261:2012-12, 3.14 — modifiziert, Änderung der Anmerkung)
 * @note_english  Container types can be flat, open top, high cube, bulk, ISO, reefer- or tank containers. (@see DIN EN
 *                ISO 17261:2012-12, 3.14 — modifiziert, Änderung der Anmerkung)
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 * @minimum_requirement  number, category, reefer, sizeType, type, size
 */
//TODO - Builder
public class Container extends LoadingUnit {

    /**
     * ISO 6346 Container Size Type e.g. 20G0 for GENERAL PURPOSE CONTAINERS
     */
    @NotNull(message = "sizeType is part of minimum requirement")
    private String sizeType;

    /**
     * e.g. flat, open top, high cube, bulk, ISO, reefer- or tank containers.
     */
    @NotNull(message = "type is part of minimum requirement")
    private String type;

    /**
     * in foot.
     */
    @NotNull(message = "size is part of minimum requirement")
    private Integer size;

    public Container withSizeType(String sizeType) {

        this.sizeType = sizeType;

        return this;
    }


    public Container withType(String type) {

        this.type = type;

        return this;
    }


    public Container withSize(Integer size) {

        this.size = size;

        return this;
    }


    public String getSizeType() {

        return sizeType;
    }


    public String getType() {

        return type;
    }


    public Integer getSize() {

        return size;
    }


    @Override
    public String toString() {

        return "Container {" + String.format("identification='%s', ", super.getIdentification())
            + String.format("number='%s', ", super.getNumber()) + String.format("category='%s', ", super.getCategory())
            + String.format("weightBruttoMax='%s', ", super.getWeightBruttoMax())
            + String.format("weightNettoMax='%s', ", super.getWeightNettoMax())
            + String.format("weightTara='%s', ", super.getWeightTara())
            + String.format("condition='%s', ", super.getCondition())
            + String.format("reefer='%s', ", super.isReefer()) + String.format("operator='%s', ", super.getOperator())
            + String.format("size='%s', ", this.size) + String.format("type='%s', ", this.type)
            + String.format("sizeType='%s'", this.sizeType) + "}";
    }
}
