package com.medicinery.priceimport.data.jaxb.werru;

import javax.xml.bind.annotation.XmlElement;

public class Drug {

    private String url;
    private String name;
    private String form;
    private String vendor;
    private String price;

    public String getUrl() {
        return url;
    }

    @XmlElement
    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getForm() {
        return form;
    }

    @XmlElement
    public void setForm(String form) {
        this.form = form;
    }

    public String getVendor() {
        return vendor;
    }

    @XmlElement
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getPrice() {
        return price;
    }

    @XmlElement
    public void setPrice(String price) {
        this.price = price;
    }
}
