package com.medicinery.core.entity;

import com.medicinery.core.entity.type.DrugProviderStatus;
import com.medicinery.core.entity.type.ExportType;
import com.medicinery.core.entity.type.Segment;

import javax.persistence.*;

@Entity
@Table(name = "drugstore")
public class Drugstore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "export_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ExportType exportType;

    @Column(name = "print_name", nullable = false)
    private String printName;

    @Column(name = "address")
    private String address;

    @Column(name = "website", nullable = false)
    private String website;

    @Column(name = "phone")
    private String phone;

    @Column(name = "export_url", nullable = false)
    private String exportUrl;

    @Column(name = "extra_info")
    private String extraInfo;

    @Column(name = "segment", nullable = false)
    @Enumerated(EnumType.STRING)
    private Segment segment;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private DrugProviderStatus status;

    @Column(name = "url_suffix")
    private String urlSuffix;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExportType getExportType() {
        return exportType;
    }

    public void setExportType(ExportType exportType) {
        this.exportType = exportType;
    }

    public String getPrintName() {
        return printName;
    }

    public void setPrintName(String printName) {
        this.printName = printName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getExportUrl() {
        return exportUrl;
    }

    public void setExportUrl(String exportUrl) {
        this.exportUrl = exportUrl;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public Segment getSegment() {
        return segment;
    }

    public void setSegment(Segment segment) {
        this.segment = segment;
    }

    public DrugProviderStatus getStatus() {
        return status;
    }

    public void setStatus(DrugProviderStatus status) {
        this.status = status;
    }

    public String getUrlSuffix() {
        return urlSuffix;
    }

    public void setUrlSuffix(String urlSuffix) {
        this.urlSuffix = urlSuffix;
    }
}
