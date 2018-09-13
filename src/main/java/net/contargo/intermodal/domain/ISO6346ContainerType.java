package net.contargo.intermodal.domain;

import java.util.Arrays;
import java.util.Optional;


/**
 * Overview of valid ISO 6346 {@link Container} types.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public enum ISO6346ContainerType {

    G0("G0", "General purpose container (without ventilation)", "GP", "Openings at one or both ends"),
    G1("G1", "General purpose container (without ventilation)", "GP", "Passive vents at upper part of cargo space"),
    G2("G2", "General purpose container (without ventilation)", "GP",
        "Openings at one or both ends + full openings on one or both sides"),
    G3("G3", "General purpose container (without ventilation)", "GP",
        "Openings at one or both ends + partial openings on one or both sides"),
    V0("V0", "General purpose container (with ventilation)", "VH",
        "Non-mechanical, vents at lower and upper parts of cargo space"),
    V2("V2", "General purpose container (with ventilation)", "VH", "Mechanical ventilation system located internally"),
    V4("V4", "General purpose container (with ventilation)", "VH", "Mechanical ventilation system located externally"),
    B0("B0", "Dry bulk container (Non-pressurized, box type)", "BU", "Closed"),
    B1("B1", "Dry bulk container (Non-pressurized, box type)", "BU", "Airtight"),
    B3("B3", "Dry bulk container (Pressurized)", "BK", "Horizontal discharge, test pressure 1.50 bar"),
    B4("B4", "Dry bulk container (Pressurized)", "BK", "Horizontal discharge, test pressure 2.65 bar"),
    B5("B5", "Dry bulk container (Pressurized)", "BK", "Tipping discharge, test pressure 1.50 bar"),
    B6("B6", "Dry bulk container (Pressurized)", "BK", "Tipping discharge, test pressure 2.65 bar"),
    S0("S0", "Named cargo container", "SN", "Livestock carrier"),
    S1("S1", "Named cargo container", "SN", "Automobile carrier"),
    S2("S2", "Named cargo container", "SN", "Live fish carrier"),
    R0("R0", "Thermal container", "RE", "Mechanically refrigerated"),
    R1("R1", "Thermal container", "RT", "Mechanically refrigerated and heated"),
    R2("R2", "Thermal container", "RS", "Mechanically refrigerated"),
    R3("R3", "Thermal container", "RS", "Mechanically refrigerated and heated"),
    H0("H0", "Thermal container (Refrigerated and/or heated with removable equipment)", "HR",
        "Refrigerated or heated with removable equipment located externally; heat transfer coefficient K=0.4W/m²*K"),
    H1("H1", "Thermal container (Refrigerated and/or heated with removable equipment)", "HR",
        "Refrigerated or heated with removable equipment located internally"),
    H2("H2", "Thermal container (Refrigerated and/or heated with removable equipment)", "HR",
        "Refrigerated or heated with removable equipment located externally; heat transfer coefficient K=0.7W/m²*K"),
    H5("H5", "Thermal container (Insulated)", "HI", "Insulated - Heat transfer coefficient K=0.4W/m²*K"),
    H6("H6", "Thermal container (Insulated)", "HI", "Insulated - Heat transfer coefficient K=0.7W/m²*K"),
    U0("U0", "Open-top container", "UT", "Openings at one or both ends"),
    U1("U1", "Open-top container", "UT", "Idem + removable top members in end frames"),
    U2("U2", "Open-top container", "UT", "Openings at one or both ends + openings at one or both sides"),
    U3("U3", "Open-top container", "UT", "Idem + removable top members in end frames"),
    U4("U4", "Open-top container", "UT", "Openings at one or both ends + partial on one and full at other side"),
    U5("U5", "Open-top container", "UT", "Complete, fixed side and end walls ( no doors )"),
    P0("P0", "Platform (container)", "PL", "Platform (container)"),
    P1("P1", "Platform (container) (Fixed)", "PF", "Two complete and fixed ends"),
    P2("P2", "Platform (container) (Fixed)", "PF", "Fixed posts, either free-standing or with removable top member"),
    P3("P3", "Platform (container) (Folding (collapsible))", "PC", "Folding complete end structure"),
    P4("P4", "Platform (container) (Folding (collapsible))", "PC",
        "Folding posts, either free-standing or with removable top member"),
    P5("P5", "Platform (container) (Platform-based containers with complete super-structure)", "PS",
        "Open top, open ends (skeletal)"),
    T0("T0", "Tank container (For non-dangerous liquids)", "TN", "Minimum pressure 45 kPa"),
    T1("T1", "Tank container (For non-dangerous liquids)", "TN", "Minimum pressure 150 kPa"),
    T2("T2", "Tank container (For non-dangerous liquids)", "TN", "Minimum pressure 265 kPa"),
    T3("T3", "Tank container (For dangerous liquids)", "TD", "Minimum pressure 150 kPa"),
    T4("T4", "Tank container (For dangerous liquids)", "TD", "Minimum pressure 265 kPa"),
    T5("T5", "Tank container (For dangerous liquids)", "TD", "Minimum pressure 400 kPa"),
    T6("T6", "Tank container (For dangerous liquids)", "TD", "Minimum pressure 600 kPa"),
    T7("T7", "Tank container (For gases)", "TG", "Minimum pressure 910 kPa"),
    T8("T8", "Tank container (For gases)", "TG", "Minimum pressure 2200 kPa"),
    T9("T9", "Tank container (For gases)", "TG", "Minimum pressure (to be decided)"),
    A0("A0", "Air/surface container", "AS", "Air/surface container");

    private String type;

    private String typeDesignation;

    private String mainCharacteristics;

    private String typeGroupCode;

    ISO6346ContainerType(String type, String typeDesignation, String typeGroupCode, String mainCharacteristics) {

        this.type = type;
        this.typeDesignation = typeDesignation;
        this.mainCharacteristics = mainCharacteristics;
        this.typeGroupCode = typeGroupCode;
    }

    public String getType() {

        return type;
    }


    public String getTypeDesignation() {

        return typeDesignation;
    }


    public String getMainCharacteristics() {

        return mainCharacteristics;
    }


    public String getTypeGroupCode() {

        return typeGroupCode;
    }


    public static Optional<ISO6346ContainerType> getByType(String typeCode) {

        return Arrays.stream(ISO6346ContainerType.values()).filter(containerType ->
                    typeCode.equals(containerType.getType())).findAny();
    }
}
