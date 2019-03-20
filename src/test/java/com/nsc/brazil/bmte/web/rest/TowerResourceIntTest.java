package com.nsc.brazil.bmte.web.rest;

import com.nsc.brazil.bmte.BrazilbmteApp;

import com.nsc.brazil.bmte.domain.Tower;
import com.nsc.brazil.bmte.repository.TowerRepository;
import com.nsc.brazil.bmte.service.TowerService;
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
 * Test class for the TowerResource REST controller.
 *
 * @see TowerResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BrazilbmteApp.class)
public class TowerResourceIntTest {

    private static final String DEFAULT_TOWER_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_TOWER_NUMBER = "BBBBBBBBBB";

    private static final Long DEFAULT_SERIAL_NUMBER = 1L;
    private static final Long UPDATED_SERIAL_NUMBER = 2L;

    private static final Double DEFAULT_LONGITUDE = 1D;
    private static final Double UPDATED_LONGITUDE = 2D;

    private static final Double DEFAULT_LATITUDE = 1D;
    private static final Double UPDATED_LATITUDE = 2D;

    private static final Double DEFAULT_ALTITUDE = 1D;
    private static final Double UPDATED_ALTITUDE = 2D;

    private static final Double DEFAULT_UTM_X = 1D;
    private static final Double UPDATED_UTM_X = 2D;

    private static final Double DEFAULT_UTM_Y = 1D;
    private static final Double UPDATED_UTM_Y = 2D;

    private static final Double DEFAULT_PROGRESSIVE_DISTANCE = 1D;
    private static final Double UPDATED_PROGRESSIVE_DISTANCE = 2D;

    private static final Boolean DEFAULT_IS_CORNER = false;
    private static final Boolean UPDATED_IS_CORNER = true;

    private static final Double DEFAULT_CORNER = 1D;
    private static final Double UPDATED_CORNER = 2D;

    private static final Double DEFAULT_SPAN_DISTANCE = 1D;
    private static final Double UPDATED_SPAN_DISTANCE = 2D;

    private static final String DEFAULT_TOWER_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_TOWER_TYPE = "BBBBBBBBBB";

    @Autowired
    private TowerRepository towerRepository;

    @Autowired
    private TowerService towerService;

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

    private MockMvc restTowerMockMvc;

    private Tower tower;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final TowerResource towerResource = new TowerResource(towerService);
        this.restTowerMockMvc = MockMvcBuilders.standaloneSetup(towerResource)
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
    public static Tower createEntity(EntityManager em) {
        Tower tower = new Tower()
            .towerNumber(DEFAULT_TOWER_NUMBER)
            .serialNumber(DEFAULT_SERIAL_NUMBER)
            .longitude(DEFAULT_LONGITUDE)
            .latitude(DEFAULT_LATITUDE)
            .altitude(DEFAULT_ALTITUDE)
            .utmX(DEFAULT_UTM_X)
            .utmY(DEFAULT_UTM_Y)
            .progressiveDistance(DEFAULT_PROGRESSIVE_DISTANCE)
            .isCorner(DEFAULT_IS_CORNER)
            .corner(DEFAULT_CORNER)
            .spanDistance(DEFAULT_SPAN_DISTANCE)
            .towerType(DEFAULT_TOWER_TYPE);
        return tower;
    }

    @Before
    public void initTest() {
        tower = createEntity(em);
    }

    @Test
    @Transactional
    public void createTower() throws Exception {
        int databaseSizeBeforeCreate = towerRepository.findAll().size();

        // Create the Tower
        restTowerMockMvc.perform(post("/api/towers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(tower)))
            .andExpect(status().isCreated());

        // Validate the Tower in the database
        List<Tower> towerList = towerRepository.findAll();
        assertThat(towerList).hasSize(databaseSizeBeforeCreate + 1);
        Tower testTower = towerList.get(towerList.size() - 1);
        assertThat(testTower.getTowerNumber()).isEqualTo(DEFAULT_TOWER_NUMBER);
        assertThat(testTower.getSerialNumber()).isEqualTo(DEFAULT_SERIAL_NUMBER);
        assertThat(testTower.getLongitude()).isEqualTo(DEFAULT_LONGITUDE);
        assertThat(testTower.getLatitude()).isEqualTo(DEFAULT_LATITUDE);
        assertThat(testTower.getAltitude()).isEqualTo(DEFAULT_ALTITUDE);
        assertThat(testTower.getUtmX()).isEqualTo(DEFAULT_UTM_X);
        assertThat(testTower.getUtmY()).isEqualTo(DEFAULT_UTM_Y);
        assertThat(testTower.getProgressiveDistance()).isEqualTo(DEFAULT_PROGRESSIVE_DISTANCE);
        assertThat(testTower.isIsCorner()).isEqualTo(DEFAULT_IS_CORNER);
        assertThat(testTower.getCorner()).isEqualTo(DEFAULT_CORNER);
        assertThat(testTower.getSpanDistance()).isEqualTo(DEFAULT_SPAN_DISTANCE);
        assertThat(testTower.getTowerType()).isEqualTo(DEFAULT_TOWER_TYPE);
    }

    @Test
    @Transactional
    public void createTowerWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = towerRepository.findAll().size();

        // Create the Tower with an existing ID
        tower.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restTowerMockMvc.perform(post("/api/towers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(tower)))
            .andExpect(status().isBadRequest());

        // Validate the Tower in the database
        List<Tower> towerList = towerRepository.findAll();
        assertThat(towerList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllTowers() throws Exception {
        // Initialize the database
        towerRepository.saveAndFlush(tower);

        // Get all the towerList
        restTowerMockMvc.perform(get("/api/towers?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(tower.getId().intValue())))
            .andExpect(jsonPath("$.[*].towerNumber").value(hasItem(DEFAULT_TOWER_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].serialNumber").value(hasItem(DEFAULT_SERIAL_NUMBER.intValue())))
            .andExpect(jsonPath("$.[*].longitude").value(hasItem(DEFAULT_LONGITUDE.doubleValue())))
            .andExpect(jsonPath("$.[*].latitude").value(hasItem(DEFAULT_LATITUDE.doubleValue())))
            .andExpect(jsonPath("$.[*].altitude").value(hasItem(DEFAULT_ALTITUDE.doubleValue())))
            .andExpect(jsonPath("$.[*].utmX").value(hasItem(DEFAULT_UTM_X.doubleValue())))
            .andExpect(jsonPath("$.[*].utmY").value(hasItem(DEFAULT_UTM_Y.doubleValue())))
            .andExpect(jsonPath("$.[*].progressiveDistance").value(hasItem(DEFAULT_PROGRESSIVE_DISTANCE.doubleValue())))
            .andExpect(jsonPath("$.[*].isCorner").value(hasItem(DEFAULT_IS_CORNER.booleanValue())))
            .andExpect(jsonPath("$.[*].corner").value(hasItem(DEFAULT_CORNER.doubleValue())))
            .andExpect(jsonPath("$.[*].spanDistance").value(hasItem(DEFAULT_SPAN_DISTANCE.doubleValue())))
            .andExpect(jsonPath("$.[*].towerType").value(hasItem(DEFAULT_TOWER_TYPE.toString())));
    }
    
    @Test
    @Transactional
    public void getTower() throws Exception {
        // Initialize the database
        towerRepository.saveAndFlush(tower);

        // Get the tower
        restTowerMockMvc.perform(get("/api/towers/{id}", tower.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(tower.getId().intValue()))
            .andExpect(jsonPath("$.towerNumber").value(DEFAULT_TOWER_NUMBER.toString()))
            .andExpect(jsonPath("$.serialNumber").value(DEFAULT_SERIAL_NUMBER.intValue()))
            .andExpect(jsonPath("$.longitude").value(DEFAULT_LONGITUDE.doubleValue()))
            .andExpect(jsonPath("$.latitude").value(DEFAULT_LATITUDE.doubleValue()))
            .andExpect(jsonPath("$.altitude").value(DEFAULT_ALTITUDE.doubleValue()))
            .andExpect(jsonPath("$.utmX").value(DEFAULT_UTM_X.doubleValue()))
            .andExpect(jsonPath("$.utmY").value(DEFAULT_UTM_Y.doubleValue()))
            .andExpect(jsonPath("$.progressiveDistance").value(DEFAULT_PROGRESSIVE_DISTANCE.doubleValue()))
            .andExpect(jsonPath("$.isCorner").value(DEFAULT_IS_CORNER.booleanValue()))
            .andExpect(jsonPath("$.corner").value(DEFAULT_CORNER.doubleValue()))
            .andExpect(jsonPath("$.spanDistance").value(DEFAULT_SPAN_DISTANCE.doubleValue()))
            .andExpect(jsonPath("$.towerType").value(DEFAULT_TOWER_TYPE.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingTower() throws Exception {
        // Get the tower
        restTowerMockMvc.perform(get("/api/towers/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateTower() throws Exception {
        // Initialize the database
        towerService.save(tower);

        int databaseSizeBeforeUpdate = towerRepository.findAll().size();

        // Update the tower
        Tower updatedTower = towerRepository.findById(tower.getId()).get();
        // Disconnect from session so that the updates on updatedTower are not directly saved in db
        em.detach(updatedTower);
        updatedTower
            .towerNumber(UPDATED_TOWER_NUMBER)
            .serialNumber(UPDATED_SERIAL_NUMBER)
            .longitude(UPDATED_LONGITUDE)
            .latitude(UPDATED_LATITUDE)
            .altitude(UPDATED_ALTITUDE)
            .utmX(UPDATED_UTM_X)
            .utmY(UPDATED_UTM_Y)
            .progressiveDistance(UPDATED_PROGRESSIVE_DISTANCE)
            .isCorner(UPDATED_IS_CORNER)
            .corner(UPDATED_CORNER)
            .spanDistance(UPDATED_SPAN_DISTANCE)
            .towerType(UPDATED_TOWER_TYPE);

        restTowerMockMvc.perform(put("/api/towers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedTower)))
            .andExpect(status().isOk());

        // Validate the Tower in the database
        List<Tower> towerList = towerRepository.findAll();
        assertThat(towerList).hasSize(databaseSizeBeforeUpdate);
        Tower testTower = towerList.get(towerList.size() - 1);
        assertThat(testTower.getTowerNumber()).isEqualTo(UPDATED_TOWER_NUMBER);
        assertThat(testTower.getSerialNumber()).isEqualTo(UPDATED_SERIAL_NUMBER);
        assertThat(testTower.getLongitude()).isEqualTo(UPDATED_LONGITUDE);
        assertThat(testTower.getLatitude()).isEqualTo(UPDATED_LATITUDE);
        assertThat(testTower.getAltitude()).isEqualTo(UPDATED_ALTITUDE);
        assertThat(testTower.getUtmX()).isEqualTo(UPDATED_UTM_X);
        assertThat(testTower.getUtmY()).isEqualTo(UPDATED_UTM_Y);
        assertThat(testTower.getProgressiveDistance()).isEqualTo(UPDATED_PROGRESSIVE_DISTANCE);
        assertThat(testTower.isIsCorner()).isEqualTo(UPDATED_IS_CORNER);
        assertThat(testTower.getCorner()).isEqualTo(UPDATED_CORNER);
        assertThat(testTower.getSpanDistance()).isEqualTo(UPDATED_SPAN_DISTANCE);
        assertThat(testTower.getTowerType()).isEqualTo(UPDATED_TOWER_TYPE);
    }

    @Test
    @Transactional
    public void updateNonExistingTower() throws Exception {
        int databaseSizeBeforeUpdate = towerRepository.findAll().size();

        // Create the Tower

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTowerMockMvc.perform(put("/api/towers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(tower)))
            .andExpect(status().isBadRequest());

        // Validate the Tower in the database
        List<Tower> towerList = towerRepository.findAll();
        assertThat(towerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteTower() throws Exception {
        // Initialize the database
        towerService.save(tower);

        int databaseSizeBeforeDelete = towerRepository.findAll().size();

        // Delete the tower
        restTowerMockMvc.perform(delete("/api/towers/{id}", tower.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Tower> towerList = towerRepository.findAll();
        assertThat(towerList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Tower.class);
        Tower tower1 = new Tower();
        tower1.setId(1L);
        Tower tower2 = new Tower();
        tower2.setId(tower1.getId());
        assertThat(tower1).isEqualTo(tower2);
        tower2.setId(2L);
        assertThat(tower1).isNotEqualTo(tower2);
        tower1.setId(null);
        assertThat(tower1).isNotEqualTo(tower2);
    }
}
