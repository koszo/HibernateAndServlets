package com.sda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Regions")
public class Region {

    @Id
    @Column(name = "REGION_ID")
    private int regionId;
    @Column(name = "REGION_NAME")
    private String name;

    public Region() {
        super();
    }

    public Region(int regionId, String regionName) {
        super();
        this.regionId = regionId;
        this.name = regionName;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return name;
    }

    public void setRegionName(String regionName) {
        this.name = regionName;
    }

    @Override
    public String toString() {
        return "Regions [regionId=" + regionId + ", regionName=" + name + "]";
    }

}
