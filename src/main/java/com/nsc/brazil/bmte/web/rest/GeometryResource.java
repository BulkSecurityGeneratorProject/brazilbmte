package com.nsc.brazil.bmte.web.rest;
import com.nsc.brazil.bmte.domain.Geometry;
import com.nsc.brazil.bmte.service.GeometryService;
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
 * REST controller for managing Geometry.
 */
@RestController
@RequestMapping("/api")
public class GeometryResource {

    private final Logger log = LoggerFactory.getLogger(GeometryResource.class);

    private static final String ENTITY_NAME = "geometry";

    private final GeometryService geometryService;

    public GeometryResource(GeometryService geometryService) {
        this.geometryService = geometryService;
    }

    /**
     * POST  /geometries : Create a new geometry.
     *
     * @param geometry the geometry to create
     * @return the ResponseEntity with status 201 (Created) and with body the new geometry, or with status 400 (Bad Request) if the geometry has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/geometries")
    public ResponseEntity<Geometry> createGeometry(@RequestBody Geometry geometry) throws URISyntaxException {
        log.debug("REST request to save Geometry : {}", geometry);
        if (geometry.getId() != null) {
            throw new BadRequestAlertException("A new geometry cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Geometry result = geometryService.save(geometry);
        return ResponseEntity.created(new URI("/api/geometries/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /geometries : Updates an existing geometry.
     *
     * @param geometry the geometry to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated geometry,
     * or with status 400 (Bad Request) if the geometry is not valid,
     * or with status 500 (Internal Server Error) if the geometry couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/geometries")
    public ResponseEntity<Geometry> updateGeometry(@RequestBody Geometry geometry) throws URISyntaxException {
        log.debug("REST request to update Geometry : {}", geometry);
        if (geometry.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Geometry result = geometryService.save(geometry);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, geometry.getId().toString()))
            .body(result);
    }

    /**
     * GET  /geometries : get all the geometries.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of geometries in body
     */
    @GetMapping("/geometries")
    public List<Geometry> getAllGeometries() {
        log.debug("REST request to get all Geometries");
        return geometryService.findAll();
    }

    /**
     * GET  /geometries/:id : get the "id" geometry.
     *
     * @param id the id of the geometry to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the geometry, or with status 404 (Not Found)
     */
    @GetMapping("/geometries/{id}")
    public ResponseEntity<Geometry> getGeometry(@PathVariable Long id) {
        log.debug("REST request to get Geometry : {}", id);
        Optional<Geometry> geometry = geometryService.findOne(id);
        return ResponseUtil.wrapOrNotFound(geometry);
    }

    /**
     * DELETE  /geometries/:id : delete the "id" geometry.
     *
     * @param id the id of the geometry to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/geometries/{id}")
    public ResponseEntity<Void> deleteGeometry(@PathVariable Long id) {
        log.debug("REST request to delete Geometry : {}", id);
        geometryService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
