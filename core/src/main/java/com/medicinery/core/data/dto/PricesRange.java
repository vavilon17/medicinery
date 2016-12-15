package com.medicinery.core.data.dto;

import java.io.Serializable;

public class PricesRange implements Serializable {

    private boolean isFilled;
    private String lowPrice;
    private String highPrice;

    public PricesRange() {
    }

    public PricesRange(boolean isFilled) {
        this.isFilled = isFilled;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    public String getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(String lowPrice) {
        this.lowPrice = lowPrice;
    }

    public String getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(String highPrice) {
        this.highPrice = highPrice;
    }
}
