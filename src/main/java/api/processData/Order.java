package api.processData;

import api.masterData.Operator;

import api.masterData.meansOfTransport.MeansOfTransport;
import api.masterData.meansOfTransport.Vessel;

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

    private boolean transportPickUpLUEmpty;

    private String transportPickUpLUReference;

    private String transportPickUpBillingReference;

    private Operator transportPickUpLUOperator;

    /**
     * DateTime ISO 8601 incl. UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
     */
    private Date transportPickUpEarliest;

    /**
     * DateTime ISO 8601 incl. UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
     */
    private Date transportPickUpLatest;

    private MeansOfTransport transportPickUpMot;

    private String transportDropOffLocationCity;

    private String transportDropOffLocationDesignation;

    private String transportDropOffLocationType;

    private boolean transportDropOffUnitEmpty;

    private String transportDropOffUnitReference;

    private String transportDropOffBillingReference;

    private Operator transportDropOffUnitOperator;

    /**
     * DateTime ISO 8601 incl. UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
     */
    private Date transportDropOffEarliest;

    /**
     * DateTime ISO 8601 incl. UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
     */
    private Date transportDropOffLatest;

    private MeansOfTransport transportDropOffMot;

    private List<String> transportStopLocation;

    private List<String> transportStopLocationCity;

    private List<String> transportStopLocationDesignation;

    private String transportStopLocationType;

    private String transportStopSequence;

    /**
     * Format: ISO 8601 incl. UTC.
     */
    private Date transportStopEarliest;

    /**
     * Format: ISO 8601 incl. UTC.
     */
    private Date transportStopLatest;

    private String transportStopReference;

    private MeansOfTransport transportStopMot;

    private Vessel destinationVessel;

    private String destinationSeaportName;

    private String destinationLocationDesignation;

    /**
     * 2 characters (UN/LOCODE).
     */
    private String destinationCountryCode;

    private String destinationLocationCity;
}
