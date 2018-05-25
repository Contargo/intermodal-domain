package net.contargo.intermodal.domain;

/**
 * @author  Isabell Dürlich - duerlich@synyx.de
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
