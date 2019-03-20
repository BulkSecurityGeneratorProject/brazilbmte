package com.nsc.brazil.bmte.domain;



import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Geometry.
 */
@Entity
@Table(name = "geometry")
public class Geometry implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "geometry_json")
    private String geometryJson;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGeometryJson() {
        return geometryJson;
    }

    public Geometry geometryJson(String geometryJson) {
        this.geometryJson = geometryJson;
        return this;
    }

    public void setGeometryJson(String geometryJson) {
        this.geometryJson = geometryJson;
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
        Geometry geometry = (Geometry) o;
        if (geometry.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), geometry.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Geometry{" +
            "id=" + getId() +
            ", geometryJson='" + getGeometryJson() + "'" +
            "}";
    }
}
