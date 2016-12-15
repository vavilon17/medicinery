package com.medicinery.core.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "manufacturer")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manufacturerid")
    private Long id;

    @Column(name = "manufacturername_ru")
    private String manufacturerName_ru;

    @Column(name = "manufacturername_en")
    private String manufacturerName_en;

    @Column(name = "manufactureraddress")
    private String manufacturerAddress;

    @Column(name = "manufacturerphone")
    private String manufacturerPhone;

    @Column(name = "manufacturerinfo")
    private String manufacturerInfo;

    @Column(name = "manufacturerviewcount", columnDefinition = "integer default 0")
    private Integer manufacturerViewCount;

    @Column(name = "manufacturerseotext")
    private String manufacturerSeoText;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturerName_ru() {
        return manufacturerName_ru;
    }

    public void setManufacturerName_ru(String manufacturerName_ru) {
        this.manufacturerName_ru = manufacturerName_ru;
    }

    public String getManufacturerName_en() {
        return manufacturerName_en;
    }

    public void setManufacturerName_en(String manufacturerName_en) {
        this.manufacturerName_en = manufacturerName_en;
    }

    public String getManufacturerAddress() {
        return manufacturerAddress;
    }

    public void setManufacturerAddress(String manufacturerAddress) {
        this.manufacturerAddress = manufacturerAddress;
    }

    public String getManufacturerPhone() {
        return manufacturerPhone;
    }

    public void setManufacturerPhone(String manufacturerPhone) {
        this.manufacturerPhone = manufacturerPhone;
    }

    public String getManufacturerInfo() {
        return manufacturerInfo;
    }

    public void setManufacturerInfo(String manufacturerInfo) {
        this.manufacturerInfo = manufacturerInfo;
    }

    public Integer getManufacturerViewCount() {
        return manufacturerViewCount;
    }

    public void setManufacturerViewCount(Integer manufacturerViewCount) {
        this.manufacturerViewCount = manufacturerViewCount;
    }

    public String getManufacturerSeoText() {
        return manufacturerSeoText;
    }

    public void setManufacturerSeoText(String manufacturerSeoText) {
        this.manufacturerSeoText = manufacturerSeoText;
    }
}
