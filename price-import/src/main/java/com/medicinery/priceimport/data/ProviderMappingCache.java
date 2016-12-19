package com.medicinery.priceimport.data;

public class ProviderMappingCache {

    private Long id;

//    private MedicineInfoCore medicine;

    private String drugName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public MedicineInfoCore getMedicine() {
        return medicine;
    }

    public void setMedicine(MedicineInfoCore medicine) {
        this.medicine = medicine;
    }*/

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }
}
