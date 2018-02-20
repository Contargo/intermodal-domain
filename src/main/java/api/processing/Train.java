package api.processing;

public class Train {

// TODO - type: 
private Object trainNumber;

// TODO - type: {1-n}  (SGNRS etc.), siehe Daten zu @LE.Auftrag
private LE.Auftrag waggonListType;

// TODO - type: 
private Object waggonListSize;

private double waggonListWeightBrutto;

// TODO - type: 
private Object waggonListWaggonID;

// TODO - type: Sequenz in Fahrtrichtung
private Object waggonListWaggonRanking;

// TODO - type: siehe Daten zu @LE.Auftrag; Welche Units auf welchem Waggon…
private LE.Auftrag; waggonListLEOrderPD;

// TODO - type: ...auf welchem Platz
private Object waggonListStoragePosition;

// TODO - type: 
private Object dangerousGoodsIndication;

// TODO - type: yyyy-MM-dd'T'HH:mm:ss.SSSX
private Object terminalETA;

// TODO - type: yyyy-MM-dd'T'HH:mm:ss.SSSX
private Object terminalETD;

// TODO - type: yyyy-MM-dd'T'HH:mm:ss.SSSX
private Object shuntingYardETA;

private String shunter;

// TODO - type: 
private Object waggonTechnicalInspection;

// TODO - type: 
private Object trainPaths;

// TODO - type: (inkl. Zolldokumente, Reefer, Gefahrgut)
private Object manifest;

}