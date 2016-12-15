package com.medicinery.core.data.entity;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "medicineSummaryByTitle",
                query = "from MedicineSummary where medicineTitle = :title"
        ),
        @NamedQuery(
                name = "popular",
                query = "from MedicineSummary where viewCount is not null order by viewCount desc"
        ),
        @NamedQuery(
                name = "similar",
                query = "select medicineTitle from MedicineSummary where innId = :innId and medicineId != :medicineId"
        )
})
@Entity
@Table(name = "mv_medicine_summary")
public class MedicineSummary {

    @Id
    @Column(name = "medicine_id")
    private Long medicineId;

    @Column(name = "medicine_title")
    private String medicineTitle;

    @Column(name = "view_count")
    private Integer viewCount;

    @Column(name = "main_img_src")
    private String mainImgSrc;

    @Column(name = "inn_id")
    private Long innId;

    @Column(name = "manufacturer_name")
    private String manufacturerName;

    public Long getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Long medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineTitle() {
        return medicineTitle;
    }

    public void setMedicineTitle(String medicineTitle) {
        this.medicineTitle = medicineTitle;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public String getMainImgSrc() {
        return mainImgSrc;
    }

    public void setMainImgSrc(String mainImgSrc) {
        this.mainImgSrc = mainImgSrc;
    }

    public Long getInnId() {
        return innId;
    }

    public void setInnId(Long innId) {
        this.innId = innId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }
}
