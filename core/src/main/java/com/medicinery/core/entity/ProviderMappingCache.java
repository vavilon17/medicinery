package com.medicinery.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "provider_mapping_cache")
public class ProviderMappingCache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicine_id")
    private MedicineInfoCore medicine;

    @Column(name = "drug_name")
    private String drugName;

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

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }
}
