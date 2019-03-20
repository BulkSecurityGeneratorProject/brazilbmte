package com.nsc.brazil.bmte.domain;



import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A TowerTemp.
 */
@Entity
@Table(name = "tower_temp")
public class TowerTemp implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tower_number")
    private String towerNumber;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "altitude")
    private String altitude;

    @Column(name = "utm_x")
    private String utmX;

    @Column(name = "utm_y")
    private String utmY;

    @Column(name = "progressive_distance")
    private String progressiveDistance;

    @Column(name = "is_corner")
    private String isCorner;

    @Column(name = "corner")
    private String corner;

    @Column(name = "span_distance")
    private String spanDistance;

    @Column(name = "tower_type")
    private String towerType;

    @Column(name = "folha")
    private String folha;

    @Column(name = "sirgas_2000_x")
    private String sirgas2000X;

    @Column(name = "sirgas_2000_y")
    private String sirgas2000Y;

    @Column(name = "sirgas_2000_cota")
    private String sirgas2000Cota;

    @Column(name = "condutor_cota")
    private String condutorCota;

    @Column(name = "pontos_tower")
    private String pontosTower;

    @Column(name = "utm_cota")
    private String utmCota;

    @Column(name = "info_a")
    private String infoA;

    @Column(name = "info_b")
    private String infoB;

    @Column(name = "info_c")
    private String infoC;

    @Column(name = "info_da")
    private String infoDA;

    @Column(name = "info_db")
    private String infoDB;

    @Column(name = "info_dc")
    private String infoDC;

    @Column(name = "info_dd")
    private String infoDD;

    @Column(name = "info_e")
    private String infoE;

    @Column(name = "info_f")
    private String infoF;

    @Column(name = "info_g")
    private String infoG;

    @Column(name = "info_ha")
    private String infoHA;

    @Column(name = "info_hb")
    private String infoHB;

    @Column(name = "info_hc")
    private String infoHC;

    @Column(name = "info_ia")
    private String infoIA;

    @Column(name = "info_ib")
    private String infoIB;

    @Column(name = "info_ic")
    private String infoIC;

    @Column(name = "info_id")
    private String infoID;

    @Column(name = "info_ie")
    private String infoIE;

    @Column(name = "info_j")
    private String infoJ;

    @Column(name = "info_ka")
    private String infoKA;

    @Column(name = "info_kb")
    private String infoKB;

    @Column(name = "info_kc")
    private String infoKC;

    @Column(name = "info_kd")
    private String infoKD;

    @Column(name = "info_ke")
    private String infoKE;

    @Column(name = "info_kf")
    private String infoKF;

    @Column(name = "info_l")
    private String infoL;

    @Column(name = "info_m")
    private String infoM;

    @Column(name = "info_n")
    private String infoN;

    @Column(name = "info_oa")
    private String infoOA;

    @Column(name = "info_ob")
    private String infoOB;

    @Column(name = "info_p")
    private String infoP;

    @Column(name = "info_q")
    private String infoQ;

    @Column(name = "info_r")
    private String infoR;

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

    public TowerTemp towerNumber(String towerNumber) {
        this.towerNumber = towerNumber;
        return this;
    }

    public void setTowerNumber(String towerNumber) {
        this.towerNumber = towerNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public TowerTemp serialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getLongitude() {
        return longitude;
    }

    public TowerTemp longitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public TowerTemp latitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAltitude() {
        return altitude;
    }

    public TowerTemp altitude(String altitude) {
        this.altitude = altitude;
        return this;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getUtmX() {
        return utmX;
    }

    public TowerTemp utmX(String utmX) {
        this.utmX = utmX;
        return this;
    }

    public void setUtmX(String utmX) {
        this.utmX = utmX;
    }

    public String getUtmY() {
        return utmY;
    }

    public TowerTemp utmY(String utmY) {
        this.utmY = utmY;
        return this;
    }

    public void setUtmY(String utmY) {
        this.utmY = utmY;
    }

    public String getProgressiveDistance() {
        return progressiveDistance;
    }

    public TowerTemp progressiveDistance(String progressiveDistance) {
        this.progressiveDistance = progressiveDistance;
        return this;
    }

    public void setProgressiveDistance(String progressiveDistance) {
        this.progressiveDistance = progressiveDistance;
    }

    public String getIsCorner() {
        return isCorner;
    }

    public TowerTemp isCorner(String isCorner) {
        this.isCorner = isCorner;
        return this;
    }

    public void setIsCorner(String isCorner) {
        this.isCorner = isCorner;
    }

    public String getCorner() {
        return corner;
    }

    public TowerTemp corner(String corner) {
        this.corner = corner;
        return this;
    }

    public void setCorner(String corner) {
        this.corner = corner;
    }

    public String getSpanDistance() {
        return spanDistance;
    }

    public TowerTemp spanDistance(String spanDistance) {
        this.spanDistance = spanDistance;
        return this;
    }

    public void setSpanDistance(String spanDistance) {
        this.spanDistance = spanDistance;
    }

    public String getTowerType() {
        return towerType;
    }

    public TowerTemp towerType(String towerType) {
        this.towerType = towerType;
        return this;
    }

    public void setTowerType(String towerType) {
        this.towerType = towerType;
    }

    public String getFolha() {
        return folha;
    }

    public TowerTemp folha(String folha) {
        this.folha = folha;
        return this;
    }

    public void setFolha(String folha) {
        this.folha = folha;
    }

    public String getSirgas2000X() {
        return sirgas2000X;
    }

    public TowerTemp sirgas2000X(String sirgas2000X) {
        this.sirgas2000X = sirgas2000X;
        return this;
    }

    public void setSirgas2000X(String sirgas2000X) {
        this.sirgas2000X = sirgas2000X;
    }

    public String getSirgas2000Y() {
        return sirgas2000Y;
    }

    public TowerTemp sirgas2000Y(String sirgas2000Y) {
        this.sirgas2000Y = sirgas2000Y;
        return this;
    }

    public void setSirgas2000Y(String sirgas2000Y) {
        this.sirgas2000Y = sirgas2000Y;
    }

    public String getSirgas2000Cota() {
        return sirgas2000Cota;
    }

    public TowerTemp sirgas2000Cota(String sirgas2000Cota) {
        this.sirgas2000Cota = sirgas2000Cota;
        return this;
    }

    public void setSirgas2000Cota(String sirgas2000Cota) {
        this.sirgas2000Cota = sirgas2000Cota;
    }

    public String getCondutorCota() {
        return condutorCota;
    }

    public TowerTemp condutorCota(String condutorCota) {
        this.condutorCota = condutorCota;
        return this;
    }

    public void setCondutorCota(String condutorCota) {
        this.condutorCota = condutorCota;
    }

    public String getPontosTower() {
        return pontosTower;
    }

    public TowerTemp pontosTower(String pontosTower) {
        this.pontosTower = pontosTower;
        return this;
    }

    public void setPontosTower(String pontosTower) {
        this.pontosTower = pontosTower;
    }

    public String getUtmCota() {
        return utmCota;
    }

    public TowerTemp utmCota(String utmCota) {
        this.utmCota = utmCota;
        return this;
    }

    public void setUtmCota(String utmCota) {
        this.utmCota = utmCota;
    }

    public String getInfoA() {
        return infoA;
    }

    public TowerTemp infoA(String infoA) {
        this.infoA = infoA;
        return this;
    }

    public void setInfoA(String infoA) {
        this.infoA = infoA;
    }

    public String getInfoB() {
        return infoB;
    }

    public TowerTemp infoB(String infoB) {
        this.infoB = infoB;
        return this;
    }

    public void setInfoB(String infoB) {
        this.infoB = infoB;
    }

    public String getInfoC() {
        return infoC;
    }

    public TowerTemp infoC(String infoC) {
        this.infoC = infoC;
        return this;
    }

    public void setInfoC(String infoC) {
        this.infoC = infoC;
    }

    public String getInfoDA() {
        return infoDA;
    }

    public TowerTemp infoDA(String infoDA) {
        this.infoDA = infoDA;
        return this;
    }

    public void setInfoDA(String infoDA) {
        this.infoDA = infoDA;
    }

    public String getInfoDB() {
        return infoDB;
    }

    public TowerTemp infoDB(String infoDB) {
        this.infoDB = infoDB;
        return this;
    }

    public void setInfoDB(String infoDB) {
        this.infoDB = infoDB;
    }

    public String getInfoDC() {
        return infoDC;
    }

    public TowerTemp infoDC(String infoDC) {
        this.infoDC = infoDC;
        return this;
    }

    public void setInfoDC(String infoDC) {
        this.infoDC = infoDC;
    }

    public String getInfoDD() {
        return infoDD;
    }

    public TowerTemp infoDD(String infoDD) {
        this.infoDD = infoDD;
        return this;
    }

    public void setInfoDD(String infoDD) {
        this.infoDD = infoDD;
    }

    public String getInfoE() {
        return infoE;
    }

    public TowerTemp infoE(String infoE) {
        this.infoE = infoE;
        return this;
    }

    public void setInfoE(String infoE) {
        this.infoE = infoE;
    }

    public String getInfoF() {
        return infoF;
    }

    public TowerTemp infoF(String infoF) {
        this.infoF = infoF;
        return this;
    }

    public void setInfoF(String infoF) {
        this.infoF = infoF;
    }

    public String getInfoG() {
        return infoG;
    }

    public TowerTemp infoG(String infoG) {
        this.infoG = infoG;
        return this;
    }

    public void setInfoG(String infoG) {
        this.infoG = infoG;
    }

    public String getInfoHA() {
        return infoHA;
    }

    public TowerTemp infoHA(String infoHA) {
        this.infoHA = infoHA;
        return this;
    }

    public void setInfoHA(String infoHA) {
        this.infoHA = infoHA;
    }

    public String getInfoHB() {
        return infoHB;
    }

    public TowerTemp infoHB(String infoHB) {
        this.infoHB = infoHB;
        return this;
    }

    public void setInfoHB(String infoHB) {
        this.infoHB = infoHB;
    }

    public String getInfoHC() {
        return infoHC;
    }

    public TowerTemp infoHC(String infoHC) {
        this.infoHC = infoHC;
        return this;
    }

    public void setInfoHC(String infoHC) {
        this.infoHC = infoHC;
    }

    public String getInfoIA() {
        return infoIA;
    }

    public TowerTemp infoIA(String infoIA) {
        this.infoIA = infoIA;
        return this;
    }

    public void setInfoIA(String infoIA) {
        this.infoIA = infoIA;
    }

    public String getInfoIB() {
        return infoIB;
    }

    public TowerTemp infoIB(String infoIB) {
        this.infoIB = infoIB;
        return this;
    }

    public void setInfoIB(String infoIB) {
        this.infoIB = infoIB;
    }

    public String getInfoIC() {
        return infoIC;
    }

    public TowerTemp infoIC(String infoIC) {
        this.infoIC = infoIC;
        return this;
    }

    public void setInfoIC(String infoIC) {
        this.infoIC = infoIC;
    }

    public String getInfoID() {
        return infoID;
    }

    public TowerTemp infoID(String infoID) {
        this.infoID = infoID;
        return this;
    }

    public void setInfoID(String infoID) {
        this.infoID = infoID;
    }

    public String getInfoIE() {
        return infoIE;
    }

    public TowerTemp infoIE(String infoIE) {
        this.infoIE = infoIE;
        return this;
    }

    public void setInfoIE(String infoIE) {
        this.infoIE = infoIE;
    }

    public String getInfoJ() {
        return infoJ;
    }

    public TowerTemp infoJ(String infoJ) {
        this.infoJ = infoJ;
        return this;
    }

    public void setInfoJ(String infoJ) {
        this.infoJ = infoJ;
    }

    public String getInfoKA() {
        return infoKA;
    }

    public TowerTemp infoKA(String infoKA) {
        this.infoKA = infoKA;
        return this;
    }

    public void setInfoKA(String infoKA) {
        this.infoKA = infoKA;
    }

    public String getInfoKB() {
        return infoKB;
    }

    public TowerTemp infoKB(String infoKB) {
        this.infoKB = infoKB;
        return this;
    }

    public void setInfoKB(String infoKB) {
        this.infoKB = infoKB;
    }

    public String getInfoKC() {
        return infoKC;
    }

    public TowerTemp infoKC(String infoKC) {
        this.infoKC = infoKC;
        return this;
    }

    public void setInfoKC(String infoKC) {
        this.infoKC = infoKC;
    }

    public String getInfoKD() {
        return infoKD;
    }

    public TowerTemp infoKD(String infoKD) {
        this.infoKD = infoKD;
        return this;
    }

    public void setInfoKD(String infoKD) {
        this.infoKD = infoKD;
    }

    public String getInfoKE() {
        return infoKE;
    }

    public TowerTemp infoKE(String infoKE) {
        this.infoKE = infoKE;
        return this;
    }

    public void setInfoKE(String infoKE) {
        this.infoKE = infoKE;
    }

    public String getInfoKF() {
        return infoKF;
    }

    public TowerTemp infoKF(String infoKF) {
        this.infoKF = infoKF;
        return this;
    }

    public void setInfoKF(String infoKF) {
        this.infoKF = infoKF;
    }

    public String getInfoL() {
        return infoL;
    }

    public TowerTemp infoL(String infoL) {
        this.infoL = infoL;
        return this;
    }

    public void setInfoL(String infoL) {
        this.infoL = infoL;
    }

    public String getInfoM() {
        return infoM;
    }

    public TowerTemp infoM(String infoM) {
        this.infoM = infoM;
        return this;
    }

    public void setInfoM(String infoM) {
        this.infoM = infoM;
    }

    public String getInfoN() {
        return infoN;
    }

    public TowerTemp infoN(String infoN) {
        this.infoN = infoN;
        return this;
    }

    public void setInfoN(String infoN) {
        this.infoN = infoN;
    }

    public String getInfoOA() {
        return infoOA;
    }

    public TowerTemp infoOA(String infoOA) {
        this.infoOA = infoOA;
        return this;
    }

    public void setInfoOA(String infoOA) {
        this.infoOA = infoOA;
    }

    public String getInfoOB() {
        return infoOB;
    }

    public TowerTemp infoOB(String infoOB) {
        this.infoOB = infoOB;
        return this;
    }

    public void setInfoOB(String infoOB) {
        this.infoOB = infoOB;
    }

    public String getInfoP() {
        return infoP;
    }

    public TowerTemp infoP(String infoP) {
        this.infoP = infoP;
        return this;
    }

    public void setInfoP(String infoP) {
        this.infoP = infoP;
    }

    public String getInfoQ() {
        return infoQ;
    }

    public TowerTemp infoQ(String infoQ) {
        this.infoQ = infoQ;
        return this;
    }

    public void setInfoQ(String infoQ) {
        this.infoQ = infoQ;
    }

    public String getInfoR() {
        return infoR;
    }

    public TowerTemp infoR(String infoR) {
        this.infoR = infoR;
        return this;
    }

    public void setInfoR(String infoR) {
        this.infoR = infoR;
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
        TowerTemp towerTemp = (TowerTemp) o;
        if (towerTemp.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), towerTemp.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TowerTemp{" +
            "id=" + getId() +
            ", towerNumber='" + getTowerNumber() + "'" +
            ", serialNumber='" + getSerialNumber() + "'" +
            ", longitude='" + getLongitude() + "'" +
            ", latitude='" + getLatitude() + "'" +
            ", altitude='" + getAltitude() + "'" +
            ", utmX='" + getUtmX() + "'" +
            ", utmY='" + getUtmY() + "'" +
            ", progressiveDistance='" + getProgressiveDistance() + "'" +
            ", isCorner='" + getIsCorner() + "'" +
            ", corner='" + getCorner() + "'" +
            ", spanDistance='" + getSpanDistance() + "'" +
            ", towerType='" + getTowerType() + "'" +
            ", folha='" + getFolha() + "'" +
            ", sirgas2000X='" + getSirgas2000X() + "'" +
            ", sirgas2000Y='" + getSirgas2000Y() + "'" +
            ", sirgas2000Cota='" + getSirgas2000Cota() + "'" +
            ", condutorCota='" + getCondutorCota() + "'" +
            ", pontosTower='" + getPontosTower() + "'" +
            ", utmCota='" + getUtmCota() + "'" +
            ", infoA='" + getInfoA() + "'" +
            ", infoB='" + getInfoB() + "'" +
            ", infoC='" + getInfoC() + "'" +
            ", infoDA='" + getInfoDA() + "'" +
            ", infoDB='" + getInfoDB() + "'" +
            ", infoDC='" + getInfoDC() + "'" +
            ", infoDD='" + getInfoDD() + "'" +
            ", infoE='" + getInfoE() + "'" +
            ", infoF='" + getInfoF() + "'" +
            ", infoG='" + getInfoG() + "'" +
            ", infoHA='" + getInfoHA() + "'" +
            ", infoHB='" + getInfoHB() + "'" +
            ", infoHC='" + getInfoHC() + "'" +
            ", infoIA='" + getInfoIA() + "'" +
            ", infoIB='" + getInfoIB() + "'" +
            ", infoIC='" + getInfoIC() + "'" +
            ", infoID='" + getInfoID() + "'" +
            ", infoIE='" + getInfoIE() + "'" +
            ", infoJ='" + getInfoJ() + "'" +
            ", infoKA='" + getInfoKA() + "'" +
            ", infoKB='" + getInfoKB() + "'" +
            ", infoKC='" + getInfoKC() + "'" +
            ", infoKD='" + getInfoKD() + "'" +
            ", infoKE='" + getInfoKE() + "'" +
            ", infoKF='" + getInfoKF() + "'" +
            ", infoL='" + getInfoL() + "'" +
            ", infoM='" + getInfoM() + "'" +
            ", infoN='" + getInfoN() + "'" +
            ", infoOA='" + getInfoOA() + "'" +
            ", infoOB='" + getInfoOB() + "'" +
            ", infoP='" + getInfoP() + "'" +
            ", infoQ='" + getInfoQ() + "'" +
            ", infoR='" + getInfoR() + "'" +
            "}";
    }
}
