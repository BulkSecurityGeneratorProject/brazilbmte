package com.nsc.brazil.bmte.service;

import com.nsc.brazil.bmte.domain.Tower;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Tower.
 */
public interface TowerService {

    /**
     * Save a tower.
     *
     * @param tower the entity to save
     * @return the persisted entity
     */
    Tower save(Tower tower);

    /**
     * Get all the towers.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<Tower> findAll(Pageable pageable);


    /**
     * Get the "id" tower.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<Tower> findOne(Long id);

    /**
     * Delete the "id" tower.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
