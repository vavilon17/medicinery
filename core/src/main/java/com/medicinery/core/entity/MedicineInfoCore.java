package com.medicinery.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "medicine_info_core")
public class MedicineInfoCore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tradenamename")
    private String title;

    @Column(name = "orig_id")
    private Long origId;

    @Column(name = "tradenameviewcount")
    private Integer viewCount;

    @Column(name = "visible")
    private Boolean visible;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getOrigId() {
        return origId;
    }

    public void setOrigId(Long origId) {
        this.origId = origId;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "MedicineInfoCore{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", origId=" + origId +
                ", viewCount=" + viewCount +
                ", visible=" + visible +
                '}';
    }
}