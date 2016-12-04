package com.medicinery.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "mkb10")
public class Mkb10 {

    @Id
    @Column(name = "mkb10id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mkb10code", nullable = false)
    private String mkb10Code;

    @Column(name = "mkb10name", nullable = false)
    private String mkb10Name;

    @Column(name = "disease_diseaseid")
    private Integer disease_diseaseId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMkb10Code() {
        return mkb10Code;
    }

    public void setMkb10Code(String mkb10Code) {
        this.mkb10Code = mkb10Code;
    }

    public String getMkb10Name() {
        return mkb10Name;
    }

    public void setMkb10Name(String mkb10Name) {
        this.mkb10Name = mkb10Name;
    }

    public Integer getDisease_diseaseId() {
        return disease_diseaseId;
    }

    public void setDisease_diseaseId(Integer disease_diseaseId) {
        this.disease_diseaseId = disease_diseaseId;
    }

    /*static belongsTo = MedicineInn
    static hasMany = [medicines: MedicineInn]*/

    /*static mapping = {
        table 'mkb10'
        version false
        id column: 'mkb10Id', type: 'long'
        mkb10Code column: 'mkb10Code'
        mkb10Name column: 'mkb10Name'
        mkb10Name index: 'mkb10Name_idx'
        disease_diseaseId column: 'disease_diseaseId'

        medicines joinTable:[name: 'inn_has_mkb10', key: 'mkb10_mkb10Id']
    }

    static constraints = {
        disease_diseaseId nullable: true
    }*/
}
