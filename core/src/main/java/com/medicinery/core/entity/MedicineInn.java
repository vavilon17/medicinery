package com.medicinery.core.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "inn")
public class MedicineInn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "innid")
    private Long id;

    @Column(name = "innname_ru")
    private String innName_ru;

    @Column(name = "innname_en")
    private String innName_en;

    @Column(name = "innviewcount", columnDefinition = "integer default 0")
    private Integer innViewCount;

    @ManyToMany
    @JoinTable(name = "inn_has_mkb10", joinColumns = @JoinColumn(name = "inn_innid"),
            inverseJoinColumns = @JoinColumn(name = "mkb10_mkb10id"))
    private Set<Mkb10> mkb10Set;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInnName_ru() {
        return innName_ru;
    }

    public void setInnName_ru(String innName_ru) {
        this.innName_ru = innName_ru;
    }

    public String getInnName_en() {
        return innName_en;
    }

    public void setInnName_en(String innName_en) {
        this.innName_en = innName_en;
    }

    public Integer getInnViewCount() {
        return innViewCount;
    }

    public void setInnViewCount(Integer innViewCount) {
        this.innViewCount = innViewCount;
    }

    public Set<Mkb10> getMkb10Set() {
        return mkb10Set;
    }

    public void setMkb10Set(Set<Mkb10> mkb10Set) {
        this.mkb10Set = mkb10Set;
    }
}
