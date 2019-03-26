package com.nsc.brazil.bmte.web.rest;
import com.nsc.brazil.bmte.domain.Tower;
import com.nsc.brazil.bmte.repository.TowerRepository;
import com.nsc.brazil.bmte.service.TowerService;
import com.nsc.brazil.bmte.web.rest.errors.BadRequestAlertException;
import com.nsc.brazil.bmte.web.rest.util.HeaderUtil;
import com.nsc.brazil.bmte.web.rest.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Tower.
 */
@RestController
@RequestMapping("/api")
public class TowerResource {

    private final Logger log = LoggerFactory.getLogger(TowerResource.class);

    private static final String ENTITY_NAME = "tower";

    private final TowerService towerService;

    private final TowerRepository towerRepository;

    public TowerResource(TowerService towerService,TowerRepository towerRepository) {
        this.towerRepository = towerRepository;
        this.towerService = towerService;
    }

    /**
     * POST  /towers : Create a new tower.
     *
     * @param tower the tower to create
     * @return the ResponseEntity with status 201 (Created) and with body the new tower, or with status 400 (Bad Request) if the tower has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/towers")
    public ResponseEntity<Tower> createTower(@RequestBody Tower tower) throws URISyntaxException {
        log.debug("REST request to save Tower : {}", tower);
        if (tower.getId() != null) {
            throw new BadRequestAlertException("A new tower cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Tower result = towerService.save(tower);
        return ResponseEntity.created(new URI("/api/towers/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /towers : Updates an existing tower.
     *
     * @param tower the tower to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated tower,
     * or with status 400 (Bad Request) if the tower is not valid,
     * or with status 500 (Internal Server Error) if the tower couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/towers")
    public ResponseEntity<Tower> updateTower(@RequestBody Tower tower) throws URISyntaxException {
        log.debug("REST request to update Tower : {}", tower);
        if (tower.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Tower result = towerService.save(tower);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, tower.getId().toString()))
            .body(result);
    }

    /**
     * GET  /towers : get all the towers.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of towers in body
     */
    @GetMapping("/towers")
    public ResponseEntity<List<Tower>> getAllTowers(Pageable pageable) {
        log.debug("REST request to get a page of Towers");
        Page<Tower> page = towerService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/towers");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/towers/all")
    public List<Tower> getAllTowersNoPage() {
        log.debug("REST request to get all Towers");
        return towerRepository.findAll();
    }

    /**
     * GET  /towers/:id : get the "id" tower.
     *
     * @param id the id of the tower to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the tower, or with status 404 (Not Found)
     */
    @GetMapping("/towers/{id}")
    public ResponseEntity<Tower> getTower(@PathVariable Long id) {
        log.debug("REST request to get Tower : {}", id);
        Optional<Tower> tower = towerService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tower);
    }

    /**
     * DELETE  /towers/:id : delete the "id" tower.
     *
     * @param id the id of the tower to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/towers/{id}")
    public ResponseEntity<Void> deleteTower(@PathVariable Long id) {
        log.debug("REST request to delete Tower : {}", id);
        towerService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
