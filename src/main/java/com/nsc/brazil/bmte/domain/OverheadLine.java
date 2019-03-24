package com.nsc.brazil.bmte.domain;



import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A OverheadLine.
 */
@Entity
@Table(name = "overhead_line")
public class OverheadLine implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tower_id")
    private String towerId;

    @Column(name = "tower_number")
    private String towerNumber;

    @Column(name = "geometry")
    private String geometry;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTowerId() {
        return towerId;
    }

    public OverheadLine towerId(String towerId) {
        this.towerId = towerId;
        return this;
    }

    public void setTowerId(String towerId) {
        this.towerId = towerId;
    }

    public String getTowerNumber() {
        return towerNumber;
    }

    public OverheadLine towerNumber(String towerNumber) {
        this.towerNumber = towerNumber;
        return this;
    }

    public void setTowerNumber(String towerNumber) {
        this.towerNumber = towerNumber;
    }

    public String getGeometry() {
        return geometry;
    }

    public OverheadLine geometry(String geometry) {
        this.geometry = geometry;
        return this;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
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
        OverheadLine overheadLine = (OverheadLine) o;
        if (overheadLine.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), overheadLine.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "OverheadLine{" +
            "id=" + getId() +
            ", towerId='" + getTowerId() + "'" +
            ", towerNumber='" + getTowerNumber() + "'" +
            ", geometry='" + getGeometry() + "'" +
            "}";
    }
}
