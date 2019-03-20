package com.nsc.brazil.bmte.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Tender.
 */
@Entity
@Table(name = "tender")
public class Tender implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tender_name")
    private String tenderName;

    @Column(name = "tender_length")
    private String tenderLength;

    @Column(name = "tower_count")
    private Integer towerCount;

    @OneToOne
    @JoinColumn(unique = true)
    private Geometry geometryJson;

    @ManyToOne
    @JsonIgnoreProperties("tenders")
    private Project project;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenderName() {
        return tenderName;
    }

    public Tender tenderName(String tenderName) {
        this.tenderName = tenderName;
        return this;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public String getTenderLength() {
        return tenderLength;
    }

    public Tender tenderLength(String tenderLength) {
        this.tenderLength = tenderLength;
        return this;
    }

    public void setTenderLength(String tenderLength) {
        this.tenderLength = tenderLength;
    }

    public Integer getTowerCount() {
        return towerCount;
    }

    public Tender towerCount(Integer towerCount) {
        this.towerCount = towerCount;
        return this;
    }

    public void setTowerCount(Integer towerCount) {
        this.towerCount = towerCount;
    }

    public Geometry getGeometryJson() {
        return geometryJson;
    }

    public Tender geometryJson(Geometry geometry) {
        this.geometryJson = geometry;
        return this;
    }

    public void setGeometryJson(Geometry geometry) {
        this.geometryJson = geometry;
    }

    public Project getProject() {
        return project;
    }

    public Tender project(Project project) {
        this.project = project;
        return this;
    }

    public void setProject(Project project) {
        this.project = project;
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
        Tender tender = (Tender) o;
        if (tender.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tender.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Tender{" +
            "id=" + getId() +
            ", tenderName='" + getTenderName() + "'" +
            ", tenderLength='" + getTenderLength() + "'" +
            ", towerCount=" + getTowerCount() +
            "}";
    }
}
