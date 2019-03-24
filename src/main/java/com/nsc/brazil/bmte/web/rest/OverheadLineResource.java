package com.nsc.brazil.bmte.web.rest;
import com.nsc.brazil.bmte.domain.OverheadLine;
import com.nsc.brazil.bmte.repository.OverheadLineRepository;
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
 * REST controller for managing OverheadLine.
 */
@RestController
@RequestMapping("/api")
public class OverheadLineResource {

    private final Logger log = LoggerFactory.getLogger(OverheadLineResource.class);

    private static final String ENTITY_NAME = "overheadLine";

    private final OverheadLineRepository overheadLineRepository;

    public OverheadLineResource(OverheadLineRepository overheadLineRepository) {
        this.overheadLineRepository = overheadLineRepository;
    }

    /**
     * POST  /overhead-lines : Create a new overheadLine.
     *
     * @param overheadLine the overheadLine to create
     * @return the ResponseEntity with status 201 (Created) and with body the new overheadLine, or with status 400 (Bad Request) if the overheadLine has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/overhead-lines")
    public ResponseEntity<OverheadLine> createOverheadLine(@RequestBody OverheadLine overheadLine) throws URISyntaxException {
        log.debug("REST request to save OverheadLine : {}", overheadLine);
        if (overheadLine.getId() != null) {
            throw new BadRequestAlertException("A new overheadLine cannot already have an ID", ENTITY_NAME, "idexists");
        }
        OverheadLine result = overheadLineRepository.save(overheadLine);
        return ResponseEntity.created(new URI("/api/overhead-lines/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /overhead-lines : Updates an existing overheadLine.
     *
     * @param overheadLine the overheadLine to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated overheadLine,
     * or with status 400 (Bad Request) if the overheadLine is not valid,
     * or with status 500 (Internal Server Error) if the overheadLine couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/overhead-lines")
    public ResponseEntity<OverheadLine> updateOverheadLine(@RequestBody OverheadLine overheadLine) throws URISyntaxException {
        log.debug("REST request to update OverheadLine : {}", overheadLine);
        if (overheadLine.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        OverheadLine result = overheadLineRepository.save(overheadLine);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, overheadLine.getId().toString()))
            .body(result);
    }

    /**
     * GET  /overhead-lines : get all the overheadLines.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of overheadLines in body
     */
    @GetMapping("/overhead-lines")
    public List<OverheadLine> getAllOverheadLines() {
        log.debug("REST request to get all OverheadLines");
        return overheadLineRepository.findAll();
    }

    /**
     * GET  /overhead-lines/:id : get the "id" overheadLine.
     *
     * @param id the id of the overheadLine to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the overheadLine, or with status 404 (Not Found)
     */
    @GetMapping("/overhead-lines/{id}")
    public ResponseEntity<OverheadLine> getOverheadLine(@PathVariable Long id) {
        log.debug("REST request to get OverheadLine : {}", id);
        Optional<OverheadLine> overheadLine = overheadLineRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(overheadLine);
    }

    /**
     * DELETE  /overhead-lines/:id : delete the "id" overheadLine.
     *
     * @param id the id of the overheadLine to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/overhead-lines/{id}")
    public ResponseEntity<Void> deleteOverheadLine(@PathVariable Long id) {
        log.debug("REST request to delete OverheadLine : {}", id);
        overheadLineRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
