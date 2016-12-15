package com.medicinery.core.data.entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "medicine_id", nullable = false)
    private MedicineInfoCore medicine;

    @OneToOne
    @JoinColumn(name = "drugstore_id", nullable = false)
    private Drugstore drugstore;

    @Column(name = "drug_name", nullable = false)
    private String drugName;

    @Column(name = "form")
    private String form;

    @Column(name = "price", nullable = false)
    private String price;

    @Column(name = "vendor")
    private String vendor;

    @Column(name = "url", nullable = false)
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MedicineInfoCore getMedicine() {
        return medicine;
    }

    public void setMedicine(MedicineInfoCore medicine) {
        this.medicine = medicine;
    }

    public Drugstore getDrugstore() {
        return drugstore;
    }

    public void setDrugstore(Drugstore drugstore) {
        this.drugstore = drugstore;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
