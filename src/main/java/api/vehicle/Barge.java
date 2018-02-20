package api.vehicle;

import api.transport.Operator;


public class Barge {

    private String name;

// TODO - type: 9 Ziffern
    private Object mmsi;

// TODO - type: „Europanummer“
    private Object eni;

// TODO - type: siehe Daten zu @Operator (Key: Ust.-ID)
    private Operator operatorMd;

    private double length;

    private double width;

    private double draught;

    private int bays;

    private int rows;

    private int tiers;

    private boolean suitabilityDangerousGoods;

    private double capacityTeu;

    private double capacityTons;
}
