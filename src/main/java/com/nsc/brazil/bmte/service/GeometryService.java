package com.nsc.brazil.bmte.service;

import com.nsc.brazil.bmte.domain.Geometry;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Geometry.
 */
public interface GeometryService {

    /**
     * Save a geometry.
     *
     * @param geometry the entity to save
     * @return the persisted entity
     */
    Geometry save(Geometry geometry);

    /**
     * Get all the geometries.
     *
     * @return the list of entities
     */
    List<Geometry> findAll();


    /**
     * Get the "id" geometry.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<Geometry> findOne(Long id);

    /**
     * Delete the "id" geometry.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
