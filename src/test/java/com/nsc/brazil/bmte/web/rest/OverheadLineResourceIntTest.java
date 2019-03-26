package com.nsc.brazil.bmte.web.rest;

import com.nsc.brazil.bmte.BrazilbmteApp;

import com.nsc.brazil.bmte.domain.OverheadLine;
import com.nsc.brazil.bmte.repository.OverheadLineRepository;
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
 * Test class for the OverheadLineResource REST controller.
 *
 * @see OverheadLineResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BrazilbmteApp.class)
public class OverheadLineResourceIntTest {

    private static final String DEFAULT_TOWER_ID = "AAAAAAAAAA";
    private static final String UPDATED_TOWER_ID = "BBBBBBBBBB";

    private static final String DEFAULT_TOWER_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_TOWER_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_GEOMETRY = "AAAAAAAAAA";
    private static final String UPDATED_GEOMETRY = "BBBBBBBBBB";

    @Autowired
    private OverheadLineRepository overheadLineRepository;

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

    private MockMvc restOverheadLineMockMvc;

    private OverheadLine overheadLine;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final OverheadLineResource overheadLineResource = new OverheadLineResource(overheadLineRepository);
        this.restOverheadLineMockMvc = MockMvcBuilders.standaloneSetup(overheadLineResource)
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
    public static OverheadLine createEntity(EntityManager em) {
        OverheadLine overheadLine = new OverheadLine()
            .towerId(DEFAULT_TOWER_ID)
            .towerNumber(DEFAULT_TOWER_NUMBER)
            .geometry(DEFAULT_GEOMETRY);
        return overheadLine;
    }

    @Before
    public void initTest() {
        overheadLine = createEntity(em);
    }

    @Test
    @Transactional
    public void createOverheadLine() throws Exception {
        int databaseSizeBeforeCreate = overheadLineRepository.findAll().size();

        // Create the OverheadLine
        restOverheadLineMockMvc.perform(post("/api/overhead-lines")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(overheadLine)))
            .andExpect(status().isCreated());

        // Validate the OverheadLine in the database
        List<OverheadLine> overheadLineList = overheadLineRepository.findAll();
        assertThat(overheadLineList).hasSize(databaseSizeBeforeCreate + 1);
        OverheadLine testOverheadLine = overheadLineList.get(overheadLineList.size() - 1);
        assertThat(testOverheadLine.getTowerId()).isEqualTo(DEFAULT_TOWER_ID);
        assertThat(testOverheadLine.getTowerNumber()).isEqualTo(DEFAULT_TOWER_NUMBER);
        assertThat(testOverheadLine.getGeometry()).isEqualTo(DEFAULT_GEOMETRY);
    }

    @Test
    @Transactional
    public void createOverheadLineWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = overheadLineRepository.findAll().size();

        // Create the OverheadLine with an existing ID
        overheadLine.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restOverheadLineMockMvc.perform(post("/api/overhead-lines")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(overheadLine)))
            .andExpect(status().isBadRequest());

        // Validate the OverheadLine in the database
        List<OverheadLine> overheadLineList = overheadLineRepository.findAll();
        assertThat(overheadLineList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllOverheadLines() throws Exception {
        // Initialize the database
        overheadLineRepository.saveAndFlush(overheadLine);

        // Get all the overheadLineList
        restOverheadLineMockMvc.perform(get("/api/overhead-lines?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(overheadLine.getId().intValue())))
            .andExpect(jsonPath("$.[*].towerId").value(hasItem(DEFAULT_TOWER_ID.toString())))
            .andExpect(jsonPath("$.[*].towerNumber").value(hasItem(DEFAULT_TOWER_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].geometry").value(hasItem(DEFAULT_GEOMETRY.toString())));
    }
    
    @Test
    @Transactional
    public void getOverheadLine() throws Exception {
        // Initialize the database
        overheadLineRepository.saveAndFlush(overheadLine);

        // Get the overheadLine
        restOverheadLineMockMvc.perform(get("/api/overhead-lines/{id}", overheadLine.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(overheadLine.getId().intValue()))
            .andExpect(jsonPath("$.towerId").value(DEFAULT_TOWER_ID.toString()))
            .andExpect(jsonPath("$.towerNumber").value(DEFAULT_TOWER_NUMBER.toString()))
            .andExpect(jsonPath("$.geometry").value(DEFAULT_GEOMETRY.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingOverheadLine() throws Exception {
        // Get the overheadLine
        restOverheadLineMockMvc.perform(get("/api/overhead-lines/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateOverheadLine() throws Exception {
        // Initialize the database
        overheadLineRepository.saveAndFlush(overheadLine);

        int databaseSizeBeforeUpdate = overheadLineRepository.findAll().size();

        // Update the overheadLine
        OverheadLine updatedOverheadLine = overheadLineRepository.findById(overheadLine.getId()).get();
        // Disconnect from session so that the updates on updatedOverheadLine are not directly saved in db
        em.detach(updatedOverheadLine);
        updatedOverheadLine
            .towerId(UPDATED_TOWER_ID)
            .towerNumber(UPDATED_TOWER_NUMBER)
            .geometry(UPDATED_GEOMETRY);

        restOverheadLineMockMvc.perform(put("/api/overhead-lines")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedOverheadLine)))
            .andExpect(status().isOk());

        // Validate the OverheadLine in the database
        List<OverheadLine> overheadLineList = overheadLineRepository.findAll();
        assertThat(overheadLineList).hasSize(databaseSizeBeforeUpdate);
        OverheadLine testOverheadLine = overheadLineList.get(overheadLineList.size() - 1);
        assertThat(testOverheadLine.getTowerId()).isEqualTo(UPDATED_TOWER_ID);
        assertThat(testOverheadLine.getTowerNumber()).isEqualTo(UPDATED_TOWER_NUMBER);
        assertThat(testOverheadLine.getGeometry()).isEqualTo(UPDATED_GEOMETRY);
    }

    @Test
    @Transactional
    public void updateNonExistingOverheadLine() throws Exception {
        int databaseSizeBeforeUpdate = overheadLineRepository.findAll().size();

        // Create the OverheadLine

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restOverheadLineMockMvc.perform(put("/api/overhead-lines")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(overheadLine)))
            .andExpect(status().isBadRequest());

        // Validate the OverheadLine in the database
        List<OverheadLine> overheadLineList = overheadLineRepository.findAll();
        assertThat(overheadLineList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteOverheadLine() throws Exception {
        // Initialize the database
        overheadLineRepository.saveAndFlush(overheadLine);

        int databaseSizeBeforeDelete = overheadLineRepository.findAll().size();

        // Delete the overheadLine
        restOverheadLineMockMvc.perform(delete("/api/overhead-lines/{id}", overheadLine.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<OverheadLine> overheadLineList = overheadLineRepository.findAll();
        assertThat(overheadLineList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(OverheadLine.class);
        OverheadLine overheadLine1 = new OverheadLine();
        overheadLine1.setId(1L);
        OverheadLine overheadLine2 = new OverheadLine();
        overheadLine2.setId(overheadLine1.getId());
        assertThat(overheadLine1).isEqualTo(overheadLine2);
        overheadLine2.setId(2L);
        assertThat(overheadLine1).isNotEqualTo(overheadLine2);
        overheadLine1.setId(null);
        assertThat(overheadLine1).isNotEqualTo(overheadLine2);
    }
}
