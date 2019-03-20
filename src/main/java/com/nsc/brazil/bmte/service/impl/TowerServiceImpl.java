package com.nsc.brazil.bmte.service.impl;

import com.nsc.brazil.bmte.service.TowerService;
import com.nsc.brazil.bmte.domain.Tower;
import com.nsc.brazil.bmte.repository.TowerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing Tower.
 */
@Service
@Transactional
public class TowerServiceImpl implements TowerService {

    private final Logger log = LoggerFactory.getLogger(TowerServiceImpl.class);

    private final TowerRepository towerRepository;

    public TowerServiceImpl(TowerRepository towerRepository) {
        this.towerRepository = towerRepository;
    }

    /**
     * Save a tower.
     *
     * @param tower the entity to save
     * @return the persisted entity
     */
    @Override
    public Tower save(Tower tower) {
        log.debug("Request to save Tower : {}", tower);
        return towerRepository.save(tower);
    }

    /**
     * Get all the towers.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Tower> findAll(Pageable pageable) {
        log.debug("Request to get all Towers");
        return towerRepository.findAll(pageable);
    }


    /**
     * Get one tower by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Tower> findOne(Long id) {
        log.debug("Request to get Tower : {}", id);
        return towerRepository.findById(id);
    }

    /**
     * Delete the tower by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Tower : {}", id);
        towerRepository.deleteById(id);
    }
}
