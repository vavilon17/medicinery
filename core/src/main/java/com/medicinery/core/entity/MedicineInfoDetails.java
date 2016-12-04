package com.medicinery.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "medicine_info_details")
public class MedicineInfoDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "inn_id")
    private Long innId;

    @OneToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @Column(name = "tradenamemanual", columnDefinition = "text", nullable = false)
    private String tradeNameManual;

    @Column(name = "tradenameseotext")
    private String tradeNameSeoText;

    @Column(name = "tradenamepdf_ru")
    private Integer tradeNamePdf_ru;

    @Column(name = "tradenamepdf_ua")
    private Integer tradeNamePdf_ua;

    @Column(name = "main_img_src")
    private String mainImgSrc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInnId() {
        return innId;
    }

    public void setInnId(Long innId) {
        this.innId = innId;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getTradeNameManual() {
        return tradeNameManual;
    }

    public void setTradeNameManual(String tradeNameManual) {
        this.tradeNameManual = tradeNameManual;
    }

    public String getTradeNameSeoText() {
        return tradeNameSeoText;
    }

    public void setTradeNameSeoText(String tradeNameSeoText) {
        this.tradeNameSeoText = tradeNameSeoText;
    }

    public Integer getTradeNamePdf_ru() {
        return tradeNamePdf_ru;
    }

    public void setTradeNamePdf_ru(Integer tradeNamePdf_ru) {
        this.tradeNamePdf_ru = tradeNamePdf_ru;
    }

    public Integer getTradeNamePdf_ua() {
        return tradeNamePdf_ua;
    }

    public void setTradeNamePdf_ua(Integer tradeNamePdf_ua) {
        this.tradeNamePdf_ua = tradeNamePdf_ua;
    }

    public String getMainImgSrc() {
        return mainImgSrc;
    }

    public void setMainImgSrc(String mainImgSrc) {
        this.mainImgSrc = mainImgSrc;
    }
}
