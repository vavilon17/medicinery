package com.medicinery.core.data.entity;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "findByTitle",
                query = "from MedicineInfoCore where title = :title"
        ),
        @NamedQuery(
                name = "medicineInfoCoreByTitlePart",
                query = "from MedicineInfoCore where title like :part"
        ),
        @NamedQuery(
                name = "medicineInfoCoreTitlesByTitlePart",
                query = "select title from MedicineInfoCore where title like :part"
        )
})
@Entity
@Table(name = "medicine_info_core")
public class MedicineInfoCore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "orig_id")
    private Long origId;

    @Column(name = "tradenamename", nullable = false)
    private String title;

    @Column(name = "tradenameviewcount", columnDefinition = "integer default 0")
    private Integer viewCount;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
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