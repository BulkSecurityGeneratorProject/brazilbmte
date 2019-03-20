package com.nsc.brazil.bmte.web.rest;
import com.nsc.brazil.bmte.domain.TowerTemp;
import com.nsc.brazil.bmte.repository.TowerTempRepository;
import com.nsc.brazil.bmte.web.rest.errors.BadRequestAlertException;
import com.nsc.brazil.bmte.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing TowerTemp.
 */
@RestController
@RequestMapping("/api")
public class TowerTempResource {

    private final Logger log = LoggerFactory.getLogger(TowerTempResource.class);

    private static final String ENTITY_NAME = "towerTemp";

    private final TowerTempRepository towerTempRepository;

    public TowerTempResource(TowerTempRepository towerTempRepository) {
        this.towerTempRepository = towerTempRepository;
    }

    /**
     * POST  /tower-temps : Create a new towerTemp.
     *
     * @param towerTemp the towerTemp to create
     * @return the ResponseEntity with status 201 (Created) and with body the new towerTemp, or with status 400 (Bad Request) if the towerTemp has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/tower-temps")
    public ResponseEntity<TowerTemp> createTowerTemp(@RequestBody TowerTemp towerTemp) throws URISyntaxException {
        log.debug("REST request to save TowerTemp : {}", towerTemp);
        if (towerTemp.getId() != null) {
            throw new BadRequestAlertException("A new towerTemp cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TowerTemp result = towerTempRepository.save(towerTemp);
        return ResponseEntity.created(new URI("/api/tower-temps/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /tower-temps : Updates an existing towerTemp.
     *
     * @param towerTemp the towerTemp to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated towerTemp,
     * or with status 400 (Bad Request) if the towerTemp is not valid,
     * or with status 500 (Internal Server Error) if the towerTemp couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/tower-temps")
    public ResponseEntity<TowerTemp> updateTowerTemp(@RequestBody TowerTemp towerTemp) throws URISyntaxException {
        log.debug("REST request to update TowerTemp : {}", towerTemp);
        if (towerTemp.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TowerTemp result = towerTempRepository.save(towerTemp);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, towerTemp.getId().toString()))
            .body(result);
    }

    /**
     * GET  /tower-temps : get all the towerTemps.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of towerTemps in body
     */
    @GetMapping("/tower-temps")
    public List<TowerTemp> getAllTowerTemps() {
        log.debug("REST request to get all TowerTemps");
        List<TowerTemp> towerTemps = towerTempRepository.findAll();
        return towerTemps;
    }

    /**
     * GET  /tower-temps/:id : get the "id" towerTemp.
     *
     * @param id the id of the towerTemp to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the towerTemp, or with status 404 (Not Found)
     */
    @GetMapping("/tower-temps/{id}")
    public ResponseEntity<TowerTemp> getTowerTemp(@PathVariable Long id) {
        log.debug("REST request to get TowerTemp : {}", id);
        Optional<TowerTemp> towerTemp = towerTempRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(towerTemp);
    }

    /**
     * DELETE  /tower-temps/:id : delete the "id" towerTemp.
     *
     * @param id the id of the towerTemp to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/tower-temps/{id}")
    public ResponseEntity<Void> deleteTowerTemp(@PathVariable Long id) {
        log.debug("REST request to delete TowerTemp : {}", id);
        towerTempRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
