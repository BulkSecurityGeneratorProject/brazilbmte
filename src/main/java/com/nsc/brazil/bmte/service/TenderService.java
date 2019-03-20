package com.nsc.brazil.bmte.service;

import com.nsc.brazil.bmte.domain.Tender;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Tender.
 */
public interface TenderService {

    /**
     * Save a tender.
     *
     * @param tender the entity to save
     * @return the persisted entity
     */
    Tender save(Tender tender);

    /**
     * Get all the tenders.
     *
     * @return the list of entities
     */
    List<Tender> findAll();


    /**
     * Get the "id" tender.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<Tender> findOne(Long id);

    /**
     * Delete the "id" tender.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
