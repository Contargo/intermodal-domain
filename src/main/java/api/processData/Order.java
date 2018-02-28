package api.processData;

import api.masterData.Operator;

import api.masterData.vehicle.Vessel;

import java.util.Date;
import java.util.List;


/**
 * Contains all data of an order.
 *
 * <p>In german Auftrag</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Order {

    private String reference;

    private Operator client;

    private Operator billRecipient;

    private api.processData.loadingUnit.Order luOrder;

    private Direction transportDirection;

    private String transportPickUpLocationCity;

    private String transportPickUpLocationDesignation;

    private String transportPickUpLocationType;

    private boolean transportPickUpLuEmpty;

    private String transportPickUpUnitReference;

    private String transportPickUpBillingReference;

    private Operator transportPickUpUnitOperator;

    /**
     * DateTime ISO 8601 incl. UTC.
     */
    private Date transportPickUpEarliest;

    /**
     * DateTime ISO 8601 incl. UTC.
     */
    private Date transportPickUpLatest;

    // TODO : type?
    private String transportPickUpMot;

    private String transportDropOffLocationCity;

    private String transportDropOffLocationDesignation;

    private String transportDropOffLocationType;

    private boolean transportDropOffUnitEmpty;

    private String transportDropOffUnitReference;

    private String transportDropOffBillingReference;

    private Operator transportDropOffUnitOperator;

    /**
     * DateTime ISO 8601 incl. UTC.
     */
    private Date transportDropOffEarliest;

    /**
     * DateTime ISO 8601 incl. UTC.
     */
    private Date transportDropOffLatest;

    // TODO : type?
    private String transportDropOffMot;

    private List<String> transportStopLocation;

    private List<String> transportStopLocationCity;

    private List<String> transportStopLocationDesignation;

    private String transportStopLocationType;

    private String transportStopSequence;

    /**
     * DateTime ISO 8601 incl. UTC.
     */
    private Date transportStopEarliest;

    /**
     * DateTime ISO 8601 incl. UTC.
     */
    private Date transportStopLatest;

    private String transportStopReference;

    // TODO - type: type?
    private String transportStopMot;

    private Vessel destinationVessel;

    private String destinationSeaportName;

    private String destinationLocationDesignation;

    /**
     * 2 characters (UN/LOCODE).
     */
    private String destinationCountryCode;

    private String destinationLocationCity;
}
