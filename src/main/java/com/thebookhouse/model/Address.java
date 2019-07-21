package com.thebookhouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="ADDRESS")
public class Address {

    @Column(name="ID")
    private int id;

    @Column(name="CITY_CODE")
    @NotBlank
    private short cityCode;

    @Column(name="DISTRICT_CODE")
    @NotBlank
    private short districtCode;

    @Column(name="WARD_CODE")
    @NotBlank
    private short wardCode;

    @Column(name="DETAIL")
    @NotBlank
    private String detail;

    @Column(name="FULL_ADDRESS")
    private String fullAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public short getCityCode() {
        return cityCode;
    }

    public void setCityCode(short cityCode) {
        this.cityCode = cityCode;
    }

    public short getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(short districtCode) {
        this.districtCode = districtCode;
    }

    public short getWardCode() {
        return wardCode;
    }

    public void setWardCode(short wardCode) {
        this.wardCode = wardCode;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }
}
