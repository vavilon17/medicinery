package com.medicinery.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "medicine_info_core")
public class MedicineInfoCore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "orig_id")
    private Long origId;

    @Column(name = "tradenamename", nullable = false)
    private String tradeNameName;

    @Column(name = "tradenameviewcount", columnDefinition = "integer default 0")
    private Integer tradeNameViewCount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "details_id", unique = true, nullable = false)
    private MedicineInfoDetails details;

    @Column(name = "visible")
    private boolean visible;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrigId() {
        return origId;
    }

    public void setOrigId(Long origId) {
        this.origId = origId;
    }

    public String getTradeNameName() {
        return tradeNameName;
    }

    public void setTradeNameName(String tradeNameName) {
        this.tradeNameName = tradeNameName;
    }

    public Integer getTradeNameViewCount() {
        return tradeNameViewCount;
    }

    public void setTradeNameViewCount(Integer tradeNameViewCount) {
        this.tradeNameViewCount = tradeNameViewCount;
    }

    public MedicineInfoDetails getDetails() {
        return details;
    }

    public void setDetails(MedicineInfoDetails details) {
        this.details = details;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}