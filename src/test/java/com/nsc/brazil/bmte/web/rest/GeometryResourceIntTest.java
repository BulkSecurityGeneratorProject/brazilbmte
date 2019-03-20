package com.nsc.brazil.bmte.web.rest;

import com.nsc.brazil.bmte.BrazilbmteApp;

import com.nsc.brazil.bmte.domain.Geometry;
import com.nsc.brazil.bmte.repository.GeometryRepository;
import com.nsc.brazil.bmte.service.GeometryService;
import com.nsc.brazil.bmte.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.util.List;


import static com.nsc.brazil.bmte.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the GeometryResource REST controller.
 *
 * @see GeometryResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BrazilbmteApp.class)
public class GeometryResourceIntTest {

    private static final String DEFAULT_GEOMETRY_JSON = "AAAAAAAAAA";
    private static final String UPDATED_GEOMETRY_JSON = "BBBBBBBBBB";

    @Autowired
    private GeometryRepository geometryRepository;

    @Autowired
    private GeometryService geometryService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restGeometryMockMvc;

    private Geometry geometry;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final GeometryResource geometryResource = new GeometryResource(geometryService);
        this.restGeometryMockMvc = MockMvcBuilders.standaloneSetup(geometryResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Geometry createEntity(EntityManager em) {
        Geometry geometry = new Geometry()
            .geometryJson(DEFAULT_GEOMETRY_JSON);
        return geometry;
    }

    @Before
    public void initTest() {
        geometry = createEntity(em);
    }

    @Test
    @Transactional
    public void createGeometry() throws Exception {
        int databaseSizeBeforeCreate = geometryRepository.findAll().size();

        // Create the Geometry
        restGeometryMockMvc.perform(post("/api/geometries")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(geometry)))
            .andExpect(status().isCreated());

        // Validate the Geometry in the database
        List<Geometry> geometryList = geometryRepository.findAll();
        assertThat(geometryList).hasSize(databaseSizeBeforeCreate + 1);
        Geometry testGeometry = geometryList.get(geometryList.size() - 1);
        assertThat(testGeometry.getGeometryJson()).isEqualTo(DEFAULT_GEOMETRY_JSON);
    }

    @Test
    @Transactional
    public void createGeometryWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = geometryRepository.findAll().size();

        // Create the Geometry with an existing ID
        geometry.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restGeometryMockMvc.perform(post("/api/geometries")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(geometry)))
            .andExpect(status().isBadRequest());

        // Validate the Geometry in the database
        List<Geometry> geometryList = geometryRepository.findAll();
        assertThat(geometryList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllGeometries() throws Exception {
        // Initialize the database
        geometryRepository.saveAndFlush(geometry);

        // Get all the geometryList
        restGeometryMockMvc.perform(get("/api/geometries?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(geometry.getId().intValue())))
            .andExpect(jsonPath("$.[*].geometryJson").value(hasItem(DEFAULT_GEOMETRY_JSON.toString())));
    }
    
    @Test
    @Transactional
    public void getGeometry() throws Exception {
        // Initialize the database
        geometryRepository.saveAndFlush(geometry);

        // Get the geometry
        restGeometryMockMvc.perform(get("/api/geometries/{id}", geometry.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(geometry.getId().intValue()))
            .andExpect(jsonPath("$.geometryJson").value(DEFAULT_GEOMETRY_JSON.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingGeometry() throws Exception {
        // Get the geometry
        restGeometryMockMvc.perform(get("/api/geometries/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateGeometry() throws Exception {
        // Initialize the database
        geometryService.save(geometry);

        int databaseSizeBeforeUpdate = geometryRepository.findAll().size();

        // Update the geometry
        Geometry updatedGeometry = geometryRepository.findById(geometry.getId()).get();
        // Disconnect from session so that the updates on updatedGeometry are not directly saved in db
        em.detach(updatedGeometry);
        updatedGeometry
            .geometryJson(UPDATED_GEOMETRY_JSON);

        restGeometryMockMvc.perform(put("/api/geometries")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedGeometry)))
            .andExpect(status().isOk());

        // Validate the Geometry in the database
        List<Geometry> geometryList = geometryRepository.findAll();
        assertThat(geometryList).hasSize(databaseSizeBeforeUpdate);
        Geometry testGeometry = geometryList.get(geometryList.size() - 1);
        assertThat(testGeometry.getGeometryJson()).isEqualTo(UPDATED_GEOMETRY_JSON);
    }

    @Test
    @Transactional
    public void updateNonExistingGeometry() throws Exception {
        int databaseSizeBeforeUpdate = geometryRepository.findAll().size();

        // Create the Geometry

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restGeometryMockMvc.perform(put("/api/geometries")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(geometry)))
            .andExpect(status().isBadRequest());

        // Validate the Geometry in the database
        List<Geometry> geometryList = geometryRepository.findAll();
        assertThat(geometryList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteGeometry() throws Exception {
        // Initialize the database
        geometryService.save(geometry);

        int databaseSizeBeforeDelete = geometryRepository.findAll().size();

        // Delete the geometry
        restGeometryMockMvc.perform(delete("/api/geometries/{id}", geometry.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Geometry> geometryList = geometryRepository.findAll();
        assertThat(geometryList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Geometry.class);
        Geometry geometry1 = new Geometry();
        geometry1.setId(1L);
        Geometry geometry2 = new Geometry();
        geometry2.setId(geometry1.getId());
        assertThat(geometry1).isEqualTo(geometry2);
        geometry2.setId(2L);
        assertThat(geometry1).isNotEqualTo(geometry2);
        geometry1.setId(null);
        assertThat(geometry1).isNotEqualTo(geometry2);
    }
}
