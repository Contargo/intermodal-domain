package net.contargo.intermodal.domain;

/**
 * Volume information necessary for the registration of a {@link RegistrationBarge barge} or
 * {@link RegistrationTrain train}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
class Volume {

    /**
     * Number of LUs.
     */
    private Integer toDischarge;

    /**
     * Number of LUs.
     */
    private Integer toLoad;

    public Integer getToDischarge() {

        return toDischarge;
    }


    public void setToDischarge(Integer toDischarge) {

        this.toDischarge = toDischarge;
    }


    public Integer getToLoad() {

        return toLoad;
    }


    public void setToLoad(Integer toLoad) {

        this.toLoad = toLoad;
    }
}
