package com.nsc.brazil.bmte.domain;



import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Project.
 */
@Entity
@Table(name = "project")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "voltage")
    private String voltage;

    @Column(name = "description")
    private String description;

    @Column(name = "project_length")
    private String projectLength;

    @Column(name = "tower_count")
    private Integer towerCount;

    @OneToOne
    @JoinColumn(unique = true)
    private Geometry geometryJson;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public Project projectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getVoltage() {
        return voltage;
    }

    public Project voltage(String voltage) {
        this.voltage = voltage;
        return this;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    public String getDescription() {
        return description;
    }

    public Project description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProjectLength() {
        return projectLength;
    }

    public Project projectLength(String projectLength) {
        this.projectLength = projectLength;
        return this;
    }

    public void setProjectLength(String projectLength) {
        this.projectLength = projectLength;
    }

    public Integer getTowerCount() {
        return towerCount;
    }

    public Project towerCount(Integer towerCount) {
        this.towerCount = towerCount;
        return this;
    }

    public void setTowerCount(Integer towerCount) {
        this.towerCount = towerCount;
    }

    public Geometry getGeometryJson() {
        return geometryJson;
    }

    public Project geometryJson(Geometry geometry) {
        this.geometryJson = geometry;
        return this;
    }

    public void setGeometryJson(Geometry geometry) {
        this.geometryJson = geometry;
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
        Project project = (Project) o;
        if (project.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), project.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Project{" +
            "id=" + getId() +
            ", projectName='" + getProjectName() + "'" +
            ", voltage='" + getVoltage() + "'" +
            ", description='" + getDescription() + "'" +
            ", projectLength='" + getProjectLength() + "'" +
            ", towerCount=" + getTowerCount() +
            "}";
    }
}
