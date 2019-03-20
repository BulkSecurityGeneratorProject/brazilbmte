package com.nsc.brazil.bmte.service.impl;

import com.nsc.brazil.bmte.service.TenderService;
import com.nsc.brazil.bmte.domain.Tender;
import com.nsc.brazil.bmte.repository.TenderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing Tender.
 */
@Service
@Transactional
public class TenderServiceImpl implements TenderService {

    private final Logger log = LoggerFactory.getLogger(TenderServiceImpl.class);

    private final TenderRepository tenderRepository;

    public TenderServiceImpl(TenderRepository tenderRepository) {
        this.tenderRepository = tenderRepository;
    }

    /**
     * Save a tender.
     *
     * @param tender the entity to save
     * @return the persisted entity
     */
    @Override
    public Tender save(Tender tender) {
        log.debug("Request to save Tender : {}", tender);
        return tenderRepository.save(tender);
    }

    /**
     * Get all the tenders.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Tender> findAll() {
        log.debug("Request to get all Tenders");
        return tenderRepository.findAll();
    }


    /**
     * Get one tender by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Tender> findOne(Long id) {
        log.debug("Request to get Tender : {}", id);
        return tenderRepository.findById(id);
    }

    /**
     * Delete the tender by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Tender : {}", id);
        tenderRepository.deleteById(id);
    }
}
