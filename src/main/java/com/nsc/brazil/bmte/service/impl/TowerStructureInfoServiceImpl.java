package com.nsc.brazil.bmte.service.impl;

import com.nsc.brazil.bmte.service.TowerStructureInfoService;
import com.nsc.brazil.bmte.domain.TowerStructureInfo;
import com.nsc.brazil.bmte.repository.TowerStructureInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing TowerStructureInfo.
 */
@Service
@Transactional
public class TowerStructureInfoServiceImpl implements TowerStructureInfoService {

    private final Logger log = LoggerFactory.getLogger(TowerStructureInfoServiceImpl.class);

    private final TowerStructureInfoRepository towerStructureInfoRepository;

    public TowerStructureInfoServiceImpl(TowerStructureInfoRepository towerStructureInfoRepository) {
        this.towerStructureInfoRepository = towerStructureInfoRepository;
    }

    /**
     * Save a towerStructureInfo.
     *
     * @param towerStructureInfo the entity to save
     * @return the persisted entity
     */
    @Override
    public TowerStructureInfo save(TowerStructureInfo towerStructureInfo) {
        log.debug("Request to save TowerStructureInfo : {}", towerStructureInfo);
        return towerStructureInfoRepository.save(towerStructureInfo);
    }

    /**
     * Get all the towerStructureInfos.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<TowerStructureInfo> findAll() {
        log.debug("Request to get all TowerStructureInfos");
        return towerStructureInfoRepository.findAll();
    }


    /**
     * Get one towerStructureInfo by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<TowerStructureInfo> findOne(Long id) {
        log.debug("Request to get TowerStructureInfo : {}", id);
        return towerStructureInfoRepository.findById(id);
    }

    /**
     * Delete the towerStructureInfo by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete TowerStructureInfo : {}", id);
        towerStructureInfoRepository.deleteById(id);
    }
}
