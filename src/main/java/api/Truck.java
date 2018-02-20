package api;

public class Truck {

// TODO - type: z.B. DU CO 1234; Formatierung inkl. Leerzeichen!
    private Object numberPlate;

// TODO - type: z.B. relevant für die Formatierung des Kennzeichens (DUCO1234 && DE = DU CO 1234)
    private Object country;

// TODO - type: Gültigkeit
    private Object mOT;

// TODO - type: rot, gelb, grün
    private Object environmentBadge;

    private String type;

    private boolean eUAuthorization;

// TODO - type: Sicherheitsprüfung
    private Object sP;

    private boolean suitabilityDangerousGoods;

    private boolean suitabilityWaste;

    private double weightTara;
}
