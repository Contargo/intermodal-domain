package api.vehicle;

public class Truck {

    // TODO - type: z.B. DU CO 1234; Formatierung inkl. Leerzeichen!
    private Object numberPlate;

    // TODO - type: z.B. relevant für die Formatierung des Kennzeichens (DUCO1234 && DE = DU CO 1234)
    private Object countryCode;

    // TODO - type: Gültigkeit
    private Object mot;

    // TODO - type: rot, gelb, grün
    private Object environmentBadge;

    private String type;

    private boolean euAuthorization;

    // TODO - type: Sicherheitsprüfung
    private Object st;

    private boolean suitabilityDangerousGoods;

    private boolean suitabilityWaste;

    private double weightTara;
}
