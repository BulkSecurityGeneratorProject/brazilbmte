package com.nsc.brazil.bmte.service.impl;

import com.nsc.brazil.bmte.service.GeometryService;
import com.nsc.brazil.bmte.domain.Geometry;
import com.nsc.brazil.bmte.repository.GeometryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing Geometry.
 */
@Service
@Transactional
public class GeometryServiceImpl implements GeometryService {

    private final Logger log = LoggerFactory.getLogger(GeometryServiceImpl.class);

    private final GeometryRepository geometryRepository;

    public GeometryServiceImpl(GeometryRepository geometryRepository) {
        this.geometryRepository = geometryRepository;
    }

    /**
     * Save a geometry.
     *
     * @param geometry the entity to save
     * @return the persisted entity
     */
    @Override
    public Geometry save(Geometry geometry) {
        log.debug("Request to save Geometry : {}", geometry);
        return geometryRepository.save(geometry);
    }

    /**
     * Get all the geometries.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Geometry> findAll() {
        log.debug("Request to get all Geometries");
        return geometryRepository.findAll();
    }


    /**
     * Get one geometry by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Geometry> findOne(Long id) {
        log.debug("Request to get Geometry : {}", id);
        return geometryRepository.findById(id);
    }

    /**
     * Delete the geometry by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Geometry : {}", id);
        geometryRepository.deleteById(id);
    }
}
