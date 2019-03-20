package com.nsc.brazil.bmte.service;

import com.nsc.brazil.bmte.domain.TowerStructureInfo;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing TowerStructureInfo.
 */
public interface TowerStructureInfoService {

    /**
     * Save a towerStructureInfo.
     *
     * @param towerStructureInfo the entity to save
     * @return the persisted entity
     */
    TowerStructureInfo save(TowerStructureInfo towerStructureInfo);

    /**
     * Get all the towerStructureInfos.
     *
     * @return the list of entities
     */
    List<TowerStructureInfo> findAll();


    /**
     * Get the "id" towerStructureInfo.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<TowerStructureInfo> findOne(Long id);

    /**
     * Delete the "id" towerStructureInfo.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
