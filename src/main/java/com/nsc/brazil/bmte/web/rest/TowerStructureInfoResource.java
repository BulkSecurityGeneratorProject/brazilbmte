package com.nsc.brazil.bmte.web.rest;
import com.nsc.brazil.bmte.domain.TowerStructureInfo;
import com.nsc.brazil.bmte.service.TowerStructureInfoService;
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
 * REST controller for managing TowerStructureInfo.
 */
@RestController
@RequestMapping("/api")
public class TowerStructureInfoResource {

    private final Logger log = LoggerFactory.getLogger(TowerStructureInfoResource.class);

    private static final String ENTITY_NAME = "towerStructureInfo";

    private final TowerStructureInfoService towerStructureInfoService;

    public TowerStructureInfoResource(TowerStructureInfoService towerStructureInfoService) {
        this.towerStructureInfoService = towerStructureInfoService;
    }

    /**
     * POST  /tower-structure-infos : Create a new towerStructureInfo.
     *
     * @param towerStructureInfo the towerStructureInfo to create
     * @return the ResponseEntity with status 201 (Created) and with body the new towerStructureInfo, or with status 400 (Bad Request) if the towerStructureInfo has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/tower-structure-infos")
    public ResponseEntity<TowerStructureInfo> createTowerStructureInfo(@RequestBody TowerStructureInfo towerStructureInfo) throws URISyntaxException {
        log.debug("REST request to save TowerStructureInfo : {}", towerStructureInfo);
        if (towerStructureInfo.getId() != null) {
            throw new BadRequestAlertException("A new towerStructureInfo cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TowerStructureInfo result = towerStructureInfoService.save(towerStructureInfo);
        return ResponseEntity.created(new URI("/api/tower-structure-infos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /tower-structure-infos : Updates an existing towerStructureInfo.
     *
     * @param towerStructureInfo the towerStructureInfo to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated towerStructureInfo,
     * or with status 400 (Bad Request) if the towerStructureInfo is not valid,
     * or with status 500 (Internal Server Error) if the towerStructureInfo couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/tower-structure-infos")
    public ResponseEntity<TowerStructureInfo> updateTowerStructureInfo(@RequestBody TowerStructureInfo towerStructureInfo) throws URISyntaxException {
        log.debug("REST request to update TowerStructureInfo : {}", towerStructureInfo);
        if (towerStructureInfo.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TowerStructureInfo result = towerStructureInfoService.save(towerStructureInfo);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, towerStructureInfo.getId().toString()))
            .body(result);
    }

    /**
     * GET  /tower-structure-infos : get all the towerStructureInfos.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of towerStructureInfos in body
     */
    @GetMapping("/tower-structure-infos")
    public List<TowerStructureInfo> getAllTowerStructureInfos() {
        log.debug("REST request to get all TowerStructureInfos");
        return towerStructureInfoService.findAll();
    }

    /**
     * GET  /tower-structure-infos/:id : get the "id" towerStructureInfo.
     *
     * @param id the id of the towerStructureInfo to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the towerStructureInfo, or with status 404 (Not Found)
     */
    @GetMapping("/tower-structure-infos/{id}")
    public ResponseEntity<TowerStructureInfo> getTowerStructureInfo(@PathVariable Long id) {
        log.debug("REST request to get TowerStructureInfo : {}", id);
        Optional<TowerStructureInfo> towerStructureInfo = towerStructureInfoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(towerStructureInfo);
    }

    /**
     * DELETE  /tower-structure-infos/:id : delete the "id" towerStructureInfo.
     *
     * @param id the id of the towerStructureInfo to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/tower-structure-infos/{id}")
    public ResponseEntity<Void> deleteTowerStructureInfo(@PathVariable Long id) {
        log.debug("REST request to delete TowerStructureInfo : {}", id);
        towerStructureInfoService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
