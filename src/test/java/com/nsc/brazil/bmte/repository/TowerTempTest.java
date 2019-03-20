package com.nsc.brazil.bmte.repository;

import com.nsc.brazil.bmte.BrazilbmteApp;
import com.nsc.brazil.bmte.domain.Tower;
import com.nsc.brazil.bmte.domain.TowerStructureInfo;
import com.nsc.brazil.bmte.domain.TowerTemp;
import com.nsc.brazil.bmte.web.rest.TowerTempResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BrazilbmteApp.class)
public class TowerTempTest {

    @Autowired
    private TowerTempRepository towerTempRepository;

    @Autowired
    private TowerRepository towerRepository;

    @Autowired
    private TowerStructureInfoRepository towerStructureInfoRepository;


    @Test
    public void getAllTowerTemps(){
        List<TowerTemp> towerTemps = towerTempRepository.findAll();
        System.out.println(towerTemps.size());
    }

    @Test
    public void dataStringToDouble(){
        List<TowerTemp> towerTemps = towerTempRepository.findAll();
        for (TowerTemp towertemp:towerTemps) {
            long id = towertemp.getId();
            String errorField = "";
            try {
                errorField = "getSerialNumber";
                Double.parseDouble(towertemp.getSerialNumber().trim());
                errorField = "getUtmX";
                Double.parseDouble(towertemp.getUtmX().trim());
                errorField = "getUtmY";
                Double.parseDouble(towertemp.getUtmY().trim());
                errorField = "getProgressiveDistance";
                Double.parseDouble(towertemp.getProgressiveDistance().trim());
                errorField = "getSpanDistance";
                Double.parseDouble(towertemp.getSpanDistance().trim());
                errorField = "getFolha";
                Double.parseDouble(towertemp.getFolha().trim());
                errorField = "getSirgas2000X";
                Double.parseDouble(towertemp.getSirgas2000X().trim());
                errorField = "getSirgas2000Y";
                Double.parseDouble(towertemp.getSirgas2000Y().trim());
                errorField = "getCondutorCota";
                Double.parseDouble(towertemp.getCondutorCota().trim());
                errorField = "getUtmCota";
                Double.parseDouble(towertemp.getUtmCota().trim());
                errorField = "getSirgas2000Cota";
                Double.parseDouble(towertemp.getSirgas2000Cota().trim());
                errorField = "getPontosTower";
                Double.parseDouble(towertemp.getPontosTower().trim());

            }catch (Exception exc){
                System.out.println(id);
                System.out.println(errorField);
            }

        }
    }


    @Test
    public void SplicTowerTempToTowerAndTowerStructure(){
        List<TowerTemp> towerTemps = towerTempRepository.findAll();
        for (TowerTemp towertemp:towerTemps) {

            TowerStructureInfo info = new TowerStructureInfo();
            info.setFolha(0.0);
            info.setCondutorCota(Double.parseDouble(towertemp.getCondutorCota().trim()));
            info.setInfoA(towertemp.getInfoA());
            info.setInfoB(towertemp.getInfoB());
            info.setInfoC(towertemp.getInfoC());
            info.setInfoDA(towertemp.getInfoDA());
            info.setInfoDB(towertemp.getInfoDB());
            info.setInfoDC(towertemp.getInfoDC());
            info.setInfoDD(towertemp.getInfoDD());
            info.setInfoE(towertemp.getInfoE());
            info.setInfoF(towertemp.getInfoF());
            info.setInfoG(towertemp.getInfoG());
            info.setInfoHA(towertemp.getInfoHA());
            info.setInfoHB(towertemp.getInfoHB());
            info.setInfoHC(towertemp.getInfoHC());
            info.setInfoIA(towertemp.getInfoIA());
            info.setInfoIB(towertemp.getInfoIB());
            info.setInfoIC(towertemp.getInfoIC());
            info.setInfoID(towertemp.getInfoID());
            info.setInfoIE(towertemp.getInfoIE());
            info.setInfoJ(towertemp.getInfoJ());
            info.setInfoKA(towertemp.getInfoKA());
            info.setInfoKB(towertemp.getInfoKB());
            info.setInfoKC(towertemp.getInfoKC());
            info.setInfoKD(towertemp.getInfoKD());
            info.setInfoKE(towertemp.getInfoKE());
            info.setInfoKF(towertemp.getInfoKF());
            info.setInfoL(towertemp.getInfoL());
            info.setInfoM(towertemp.getInfoM());
            info.setInfoN(towertemp.getInfoN());
            info.setInfoOA(towertemp.getInfoOA());
            info.setInfoOB(towertemp.getInfoOB());
            info.setInfoP(towertemp.getInfoP());
            info.setInfoQ(towertemp.getInfoQ());
            info.setInfoR(towertemp.getInfoR());

            TowerStructureInfo infoResult = towerStructureInfoRepository.saveAndFlush(info);

            Tower tower = new Tower();
            tower.setTowerNumber(towertemp.getTowerNumber());
            tower.setSerialNumber(Long.parseLong(towertemp.getSerialNumber()));
            tower.setUtmX(Double.parseDouble(towertemp.getUtmX().trim()));
            tower.setUtmY(Double.parseDouble(towertemp.getUtmY().trim()));
            tower.setProgressiveDistance(Double.parseDouble(towertemp.getProgressiveDistance().trim()));
            tower.setCorner(0.0);
            tower.setSpanDistance(Double.parseDouble(towertemp.getSpanDistance().trim()));

            tower.setTowerStructureInfo(infoResult);

            Tower result = towerRepository.saveAndFlush(tower);
            System.out.println(result.getId());
        }
    }

    @Test
    public void addTower(){
        TowerStructureInfo info = new TowerStructureInfo();
        info.setId(new Long(100));
        info.setFolha(1.1);
        TowerStructureInfo infoResult = towerStructureInfoRepository.saveAndFlush(info);

        Tower tower = new Tower();
        tower.setTowerNumber("0/1");
        tower.setSerialNumber(new Long(1));
        tower.setCorner(100.0);
        tower.setTowerStructureInfo(infoResult);
        Tower result = towerRepository.saveAndFlush(tower);
        System.out.println(result);
    }
}
