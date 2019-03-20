package com.nsc.brazil.bmte.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Tower.
 */
@Entity
@Table(name = "tower")
public class Tower implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tower_number")
    private String towerNumber;

    @Column(name = "serial_number")
    private Long serialNumber;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "altitude")
    private Double altitude;

    @Column(name = "utm_x")
    private Double utmX;

    @Column(name = "utm_y")
    private Double utmY;

    @Column(name = "progressive_distance")
    private Double progressiveDistance;

    @Column(name = "is_corner")
    private Boolean isCorner;

    @Column(name = "corner")
    private Double corner;

    @Column(name = "span_distance")
    private Double spanDistance;

    @Column(name = "tower_type")
    private String towerType;

    @OneToOne
    @JoinColumn(unique = true)
    private TowerStructureInfo towerStructureInfo;

    @OneToOne
    @JoinColumn(unique = true)
    private Geometry geometryJson;

    @ManyToOne
    @JsonIgnoreProperties("towers")
    private Tender tender;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTowerNumber() {
        return towerNumber;
    }

    public Tower towerNumber(String towerNumber) {
        this.towerNumber = towerNumber;
        return this;
    }

    public void setTowerNumber(String towerNumber) {
        this.towerNumber = towerNumber;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public Tower serialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Tower longitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Tower latitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getAltitude() {
        return altitude;
    }

    public Tower altitude(Double altitude) {
        this.altitude = altitude;
        return this;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public Double getUtmX() {
        return utmX;
    }

    public Tower utmX(Double utmX) {
        this.utmX = utmX;
        return this;
    }

    public void setUtmX(Double utmX) {
        this.utmX = utmX;
    }

    public Double getUtmY() {
        return utmY;
    }

    public Tower utmY(Double utmY) {
        this.utmY = utmY;
        return this;
    }

    public void setUtmY(Double utmY) {
        this.utmY = utmY;
    }

    public Double getProgressiveDistance() {
        return progressiveDistance;
    }

    public Tower progressiveDistance(Double progressiveDistance) {
        this.progressiveDistance = progressiveDistance;
        return this;
    }

    public void setProgressiveDistance(Double progressiveDistance) {
        this.progressiveDistance = progressiveDistance;
    }

    public Boolean isIsCorner() {
        return isCorner;
    }

    public Tower isCorner(Boolean isCorner) {
        this.isCorner = isCorner;
        return this;
    }

    public void setIsCorner(Boolean isCorner) {
        this.isCorner = isCorner;
    }

    public Double getCorner() {
        return corner;
    }

    public Tower corner(Double corner) {
        this.corner = corner;
        return this;
    }

    public void setCorner(Double corner) {
        this.corner = corner;
    }

    public Double getSpanDistance() {
        return spanDistance;
    }

    public Tower spanDistance(Double spanDistance) {
        this.spanDistance = spanDistance;
        return this;
    }

    public void setSpanDistance(Double spanDistance) {
        this.spanDistance = spanDistance;
    }

    public String getTowerType() {
        return towerType;
    }

    public Tower towerType(String towerType) {
        this.towerType = towerType;
        return this;
    }

    public void setTowerType(String towerType) {
        this.towerType = towerType;
    }

    public TowerStructureInfo getTowerStructureInfo() {
        return towerStructureInfo;
    }

    public Tower towerStructureInfo(TowerStructureInfo towerStructureInfo) {
        this.towerStructureInfo = towerStructureInfo;
        return this;
    }

    public void setTowerStructureInfo(TowerStructureInfo towerStructureInfo) {
        this.towerStructureInfo = towerStructureInfo;
    }

    public Geometry getGeometryJson() {
        return geometryJson;
    }

    public Tower geometryJson(Geometry geometry) {
        this.geometryJson = geometry;
        return this;
    }

    public void setGeometryJson(Geometry geometry) {
        this.geometryJson = geometry;
    }

    public Tender getTender() {
        return tender;
    }

    public Tower tender(Tender tender) {
        this.tender = tender;
        return this;
    }

    public void setTender(Tender tender) {
        this.tender = tender;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tower tower = (Tower) o;
        if (tower.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tower.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Tower{" +
            "id=" + getId() +
            ", towerNumber='" + getTowerNumber() + "'" +
            ", serialNumber=" + getSerialNumber() +
            ", longitude=" + getLongitude() +
            ", latitude=" + getLatitude() +
            ", altitude=" + getAltitude() +
            ", utmX=" + getUtmX() +
            ", utmY=" + getUtmY() +
            ", progressiveDistance=" + getProgressiveDistance() +
            ", isCorner='" + isIsCorner() + "'" +
            ", corner=" + getCorner() +
            ", spanDistance=" + getSpanDistance() +
            ", towerType='" + getTowerType() + "'" +
            "}";
    }
}
