package com.nsc.brazil.bmte.web.rest;

import com.nsc.brazil.bmte.BrazilbmteApp;

import com.nsc.brazil.bmte.domain.TowerTemp;
import com.nsc.brazil.bmte.repository.TowerTempRepository;
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
 * Test class for the TowerTempResource REST controller.
 *
 * @see TowerTempResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BrazilbmteApp.class)
public class TowerTempResourceIntTest {

    private static final String DEFAULT_TOWER_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_TOWER_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_SERIAL_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_SERIAL_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_LONGITUDE = "AAAAAAAAAA";
    private static final String UPDATED_LONGITUDE = "BBBBBBBBBB";

    private static final String DEFAULT_LATITUDE = "AAAAAAAAAA";
    private static final String UPDATED_LATITUDE = "BBBBBBBBBB";

    private static final String DEFAULT_ALTITUDE = "AAAAAAAAAA";
    private static final String UPDATED_ALTITUDE = "BBBBBBBBBB";

    private static final String DEFAULT_UTM_X = "AAAAAAAAAA";
    private static final String UPDATED_UTM_X = "BBBBBBBBBB";

    private static final String DEFAULT_UTM_Y = "AAAAAAAAAA";
    private static final String UPDATED_UTM_Y = "BBBBBBBBBB";

    private static final String DEFAULT_PROGRESSIVE_DISTANCE = "AAAAAAAAAA";
    private static final String UPDATED_PROGRESSIVE_DISTANCE = "BBBBBBBBBB";

    private static final String DEFAULT_IS_CORNER = "AAAAAAAAAA";
    private static final String UPDATED_IS_CORNER = "BBBBBBBBBB";

    private static final String DEFAULT_CORNER = "AAAAAAAAAA";
    private static final String UPDATED_CORNER = "BBBBBBBBBB";

    private static final String DEFAULT_SPAN_DISTANCE = "AAAAAAAAAA";
    private static final String UPDATED_SPAN_DISTANCE = "BBBBBBBBBB";

    private static final String DEFAULT_TOWER_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_TOWER_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_FOLHA = "AAAAAAAAAA";
    private static final String UPDATED_FOLHA = "BBBBBBBBBB";

    private static final String DEFAULT_SIRGAS_2000_X = "AAAAAAAAAA";
    private static final String UPDATED_SIRGAS_2000_X = "BBBBBBBBBB";

    private static final String DEFAULT_SIRGAS_2000_Y = "AAAAAAAAAA";
    private static final String UPDATED_SIRGAS_2000_Y = "BBBBBBBBBB";

    private static final String DEFAULT_SIRGAS_2000_COTA = "AAAAAAAAAA";
    private static final String UPDATED_SIRGAS_2000_COTA = "BBBBBBBBBB";

    private static final String DEFAULT_CONDUTOR_COTA = "AAAAAAAAAA";
    private static final String UPDATED_CONDUTOR_COTA = "BBBBBBBBBB";

    private static final String DEFAULT_PONTOS_TOWER = "AAAAAAAAAA";
    private static final String UPDATED_PONTOS_TOWER = "BBBBBBBBBB";

    private static final String DEFAULT_UTM_COTA = "AAAAAAAAAA";
    private static final String UPDATED_UTM_COTA = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_A = "AAAAAAAAAA";
    private static final String UPDATED_INFO_A = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_B = "AAAAAAAAAA";
    private static final String UPDATED_INFO_B = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_C = "AAAAAAAAAA";
    private static final String UPDATED_INFO_C = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_DA = "AAAAAAAAAA";
    private static final String UPDATED_INFO_DA = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_DB = "AAAAAAAAAA";
    private static final String UPDATED_INFO_DB = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_DC = "AAAAAAAAAA";
    private static final String UPDATED_INFO_DC = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_DD = "AAAAAAAAAA";
    private static final String UPDATED_INFO_DD = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_E = "AAAAAAAAAA";
    private static final String UPDATED_INFO_E = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_F = "AAAAAAAAAA";
    private static final String UPDATED_INFO_F = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_G = "AAAAAAAAAA";
    private static final String UPDATED_INFO_G = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_HA = "AAAAAAAAAA";
    private static final String UPDATED_INFO_HA = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_HB = "AAAAAAAAAA";
    private static final String UPDATED_INFO_HB = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_HC = "AAAAAAAAAA";
    private static final String UPDATED_INFO_HC = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_IA = "AAAAAAAAAA";
    private static final String UPDATED_INFO_IA = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_IB = "AAAAAAAAAA";
    private static final String UPDATED_INFO_IB = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_IC = "AAAAAAAAAA";
    private static final String UPDATED_INFO_IC = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_ID = "AAAAAAAAAA";
    private static final String UPDATED_INFO_ID = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_IE = "AAAAAAAAAA";
    private static final String UPDATED_INFO_IE = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_J = "AAAAAAAAAA";
    private static final String UPDATED_INFO_J = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_KA = "AAAAAAAAAA";
    private static final String UPDATED_INFO_KA = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_KB = "AAAAAAAAAA";
    private static final String UPDATED_INFO_KB = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_KC = "AAAAAAAAAA";
    private static final String UPDATED_INFO_KC = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_KD = "AAAAAAAAAA";
    private static final String UPDATED_INFO_KD = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_KE = "AAAAAAAAAA";
    private static final String UPDATED_INFO_KE = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_KF = "AAAAAAAAAA";
    private static final String UPDATED_INFO_KF = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_L = "AAAAAAAAAA";
    private static final String UPDATED_INFO_L = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_M = "AAAAAAAAAA";
    private static final String UPDATED_INFO_M = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_N = "AAAAAAAAAA";
    private static final String UPDATED_INFO_N = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_OA = "AAAAAAAAAA";
    private static final String UPDATED_INFO_OA = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_OB = "AAAAAAAAAA";
    private static final String UPDATED_INFO_OB = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_P = "AAAAAAAAAA";
    private static final String UPDATED_INFO_P = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_Q = "AAAAAAAAAA";
    private static final String UPDATED_INFO_Q = "BBBBBBBBBB";

    private static final String DEFAULT_INFO_R = "AAAAAAAAAA";
    private static final String UPDATED_INFO_R = "BBBBBBBBBB";

    @Autowired
    private TowerTempRepository towerTempRepository;

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

    private MockMvc restTowerTempMockMvc;

    private TowerTemp towerTemp;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final TowerTempResource towerTempResource = new TowerTempResource(towerTempRepository);
        this.restTowerTempMockMvc = MockMvcBuilders.standaloneSetup(towerTempResource)
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
    public static TowerTemp createEntity(EntityManager em) {
        TowerTemp towerTemp = new TowerTemp()
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
            .towerType(DEFAULT_TOWER_TYPE)
            .folha(DEFAULT_FOLHA)
            .sirgas2000X(DEFAULT_SIRGAS_2000_X)
            .sirgas2000Y(DEFAULT_SIRGAS_2000_Y)
            .sirgas2000Cota(DEFAULT_SIRGAS_2000_COTA)
            .condutorCota(DEFAULT_CONDUTOR_COTA)
            .pontosTower(DEFAULT_PONTOS_TOWER)
            .utmCota(DEFAULT_UTM_COTA)
            .infoA(DEFAULT_INFO_A)
            .infoB(DEFAULT_INFO_B)
            .infoC(DEFAULT_INFO_C)
            .infoDA(DEFAULT_INFO_DA)
            .infoDB(DEFAULT_INFO_DB)
            .infoDC(DEFAULT_INFO_DC)
            .infoDD(DEFAULT_INFO_DD)
            .infoE(DEFAULT_INFO_E)
            .infoF(DEFAULT_INFO_F)
            .infoG(DEFAULT_INFO_G)
            .infoHA(DEFAULT_INFO_HA)
            .infoHB(DEFAULT_INFO_HB)
            .infoHC(DEFAULT_INFO_HC)
            .infoIA(DEFAULT_INFO_IA)
            .infoIB(DEFAULT_INFO_IB)
            .infoIC(DEFAULT_INFO_IC)
            .infoID(DEFAULT_INFO_ID)
            .infoIE(DEFAULT_INFO_IE)
            .infoJ(DEFAULT_INFO_J)
            .infoKA(DEFAULT_INFO_KA)
            .infoKB(DEFAULT_INFO_KB)
            .infoKC(DEFAULT_INFO_KC)
            .infoKD(DEFAULT_INFO_KD)
            .infoKE(DEFAULT_INFO_KE)
            .infoKF(DEFAULT_INFO_KF)
            .infoL(DEFAULT_INFO_L)
            .infoM(DEFAULT_INFO_M)
            .infoN(DEFAULT_INFO_N)
            .infoOA(DEFAULT_INFO_OA)
            .infoOB(DEFAULT_INFO_OB)
            .infoP(DEFAULT_INFO_P)
            .infoQ(DEFAULT_INFO_Q)
            .infoR(DEFAULT_INFO_R);
        return towerTemp;
    }

    @Before
    public void initTest() {
        towerTemp = createEntity(em);
    }

    @Test
    @Transactional
    public void createTowerTemp() throws Exception {
        int databaseSizeBeforeCreate = towerTempRepository.findAll().size();

        // Create the TowerTemp
        restTowerTempMockMvc.perform(post("/api/tower-temps")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(towerTemp)))
            .andExpect(status().isCreated());

        // Validate the TowerTemp in the database
        List<TowerTemp> towerTempList = towerTempRepository.findAll();
        assertThat(towerTempList).hasSize(databaseSizeBeforeCreate + 1);
        TowerTemp testTowerTemp = towerTempList.get(towerTempList.size() - 1);
        assertThat(testTowerTemp.getTowerNumber()).isEqualTo(DEFAULT_TOWER_NUMBER);
        assertThat(testTowerTemp.getSerialNumber()).isEqualTo(DEFAULT_SERIAL_NUMBER);
        assertThat(testTowerTemp.getLongitude()).isEqualTo(DEFAULT_LONGITUDE);
        assertThat(testTowerTemp.getLatitude()).isEqualTo(DEFAULT_LATITUDE);
        assertThat(testTowerTemp.getAltitude()).isEqualTo(DEFAULT_ALTITUDE);
        assertThat(testTowerTemp.getUtmX()).isEqualTo(DEFAULT_UTM_X);
        assertThat(testTowerTemp.getUtmY()).isEqualTo(DEFAULT_UTM_Y);
        assertThat(testTowerTemp.getProgressiveDistance()).isEqualTo(DEFAULT_PROGRESSIVE_DISTANCE);
        assertThat(testTowerTemp.getIsCorner()).isEqualTo(DEFAULT_IS_CORNER);
        assertThat(testTowerTemp.getCorner()).isEqualTo(DEFAULT_CORNER);
        assertThat(testTowerTemp.getSpanDistance()).isEqualTo(DEFAULT_SPAN_DISTANCE);
        assertThat(testTowerTemp.getTowerType()).isEqualTo(DEFAULT_TOWER_TYPE);
        assertThat(testTowerTemp.getFolha()).isEqualTo(DEFAULT_FOLHA);
        assertThat(testTowerTemp.getSirgas2000X()).isEqualTo(DEFAULT_SIRGAS_2000_X);
        assertThat(testTowerTemp.getSirgas2000Y()).isEqualTo(DEFAULT_SIRGAS_2000_Y);
        assertThat(testTowerTemp.getSirgas2000Cota()).isEqualTo(DEFAULT_SIRGAS_2000_COTA);
        assertThat(testTowerTemp.getCondutorCota()).isEqualTo(DEFAULT_CONDUTOR_COTA);
        assertThat(testTowerTemp.getPontosTower()).isEqualTo(DEFAULT_PONTOS_TOWER);
        assertThat(testTowerTemp.getUtmCota()).isEqualTo(DEFAULT_UTM_COTA);
        assertThat(testTowerTemp.getInfoA()).isEqualTo(DEFAULT_INFO_A);
        assertThat(testTowerTemp.getInfoB()).isEqualTo(DEFAULT_INFO_B);
        assertThat(testTowerTemp.getInfoC()).isEqualTo(DEFAULT_INFO_C);
        assertThat(testTowerTemp.getInfoDA()).isEqualTo(DEFAULT_INFO_DA);
        assertThat(testTowerTemp.getInfoDB()).isEqualTo(DEFAULT_INFO_DB);
        assertThat(testTowerTemp.getInfoDC()).isEqualTo(DEFAULT_INFO_DC);
        assertThat(testTowerTemp.getInfoDD()).isEqualTo(DEFAULT_INFO_DD);
        assertThat(testTowerTemp.getInfoE()).isEqualTo(DEFAULT_INFO_E);
        assertThat(testTowerTemp.getInfoF()).isEqualTo(DEFAULT_INFO_F);
        assertThat(testTowerTemp.getInfoG()).isEqualTo(DEFAULT_INFO_G);
        assertThat(testTowerTemp.getInfoHA()).isEqualTo(DEFAULT_INFO_HA);
        assertThat(testTowerTemp.getInfoHB()).isEqualTo(DEFAULT_INFO_HB);
        assertThat(testTowerTemp.getInfoHC()).isEqualTo(DEFAULT_INFO_HC);
        assertThat(testTowerTemp.getInfoIA()).isEqualTo(DEFAULT_INFO_IA);
        assertThat(testTowerTemp.getInfoIB()).isEqualTo(DEFAULT_INFO_IB);
        assertThat(testTowerTemp.getInfoIC()).isEqualTo(DEFAULT_INFO_IC);
        assertThat(testTowerTemp.getInfoID()).isEqualTo(DEFAULT_INFO_ID);
        assertThat(testTowerTemp.getInfoIE()).isEqualTo(DEFAULT_INFO_IE);
        assertThat(testTowerTemp.getInfoJ()).isEqualTo(DEFAULT_INFO_J);
        assertThat(testTowerTemp.getInfoKA()).isEqualTo(DEFAULT_INFO_KA);
        assertThat(testTowerTemp.getInfoKB()).isEqualTo(DEFAULT_INFO_KB);
        assertThat(testTowerTemp.getInfoKC()).isEqualTo(DEFAULT_INFO_KC);
        assertThat(testTowerTemp.getInfoKD()).isEqualTo(DEFAULT_INFO_KD);
        assertThat(testTowerTemp.getInfoKE()).isEqualTo(DEFAULT_INFO_KE);
        assertThat(testTowerTemp.getInfoKF()).isEqualTo(DEFAULT_INFO_KF);
        assertThat(testTowerTemp.getInfoL()).isEqualTo(DEFAULT_INFO_L);
        assertThat(testTowerTemp.getInfoM()).isEqualTo(DEFAULT_INFO_M);
        assertThat(testTowerTemp.getInfoN()).isEqualTo(DEFAULT_INFO_N);
        assertThat(testTowerTemp.getInfoOA()).isEqualTo(DEFAULT_INFO_OA);
        assertThat(testTowerTemp.getInfoOB()).isEqualTo(DEFAULT_INFO_OB);
        assertThat(testTowerTemp.getInfoP()).isEqualTo(DEFAULT_INFO_P);
        assertThat(testTowerTemp.getInfoQ()).isEqualTo(DEFAULT_INFO_Q);
        assertThat(testTowerTemp.getInfoR()).isEqualTo(DEFAULT_INFO_R);
    }

    @Test
    @Transactional
    public void createTowerTempWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = towerTempRepository.findAll().size();

        // Create the TowerTemp with an existing ID
        towerTemp.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restTowerTempMockMvc.perform(post("/api/tower-temps")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(towerTemp)))
            .andExpect(status().isBadRequest());

        // Validate the TowerTemp in the database
        List<TowerTemp> towerTempList = towerTempRepository.findAll();
        assertThat(towerTempList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllTowerTemps() throws Exception {
        // Initialize the database

        towerTempRepository.saveAndFlush(towerTemp);

        List<TowerTemp> towerTemps = towerTempRepository.findAll();
        System.out.println(towerTemps.size());

        // Get all the towerTempList
        restTowerTempMockMvc.perform(get("/api/tower-temps?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(towerTemp.getId().intValue())))
            .andExpect(jsonPath("$.[*].towerNumber").value(hasItem(DEFAULT_TOWER_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].serialNumber").value(hasItem(DEFAULT_SERIAL_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].longitude").value(hasItem(DEFAULT_LONGITUDE.toString())))
            .andExpect(jsonPath("$.[*].latitude").value(hasItem(DEFAULT_LATITUDE.toString())))
            .andExpect(jsonPath("$.[*].altitude").value(hasItem(DEFAULT_ALTITUDE.toString())))
            .andExpect(jsonPath("$.[*].utmX").value(hasItem(DEFAULT_UTM_X.toString())))
            .andExpect(jsonPath("$.[*].utmY").value(hasItem(DEFAULT_UTM_Y.toString())))
            .andExpect(jsonPath("$.[*].progressiveDistance").value(hasItem(DEFAULT_PROGRESSIVE_DISTANCE.toString())))
            .andExpect(jsonPath("$.[*].isCorner").value(hasItem(DEFAULT_IS_CORNER.toString())))
            .andExpect(jsonPath("$.[*].corner").value(hasItem(DEFAULT_CORNER.toString())))
            .andExpect(jsonPath("$.[*].spanDistance").value(hasItem(DEFAULT_SPAN_DISTANCE.toString())))
            .andExpect(jsonPath("$.[*].towerType").value(hasItem(DEFAULT_TOWER_TYPE.toString())))
            .andExpect(jsonPath("$.[*].folha").value(hasItem(DEFAULT_FOLHA.toString())))
            .andExpect(jsonPath("$.[*].sirgas2000X").value(hasItem(DEFAULT_SIRGAS_2000_X.toString())))
            .andExpect(jsonPath("$.[*].sirgas2000Y").value(hasItem(DEFAULT_SIRGAS_2000_Y.toString())))
            .andExpect(jsonPath("$.[*].sirgas2000Cota").value(hasItem(DEFAULT_SIRGAS_2000_COTA.toString())))
            .andExpect(jsonPath("$.[*].condutorCota").value(hasItem(DEFAULT_CONDUTOR_COTA.toString())))
            .andExpect(jsonPath("$.[*].pontosTower").value(hasItem(DEFAULT_PONTOS_TOWER.toString())))
            .andExpect(jsonPath("$.[*].utmCota").value(hasItem(DEFAULT_UTM_COTA.toString())))
            .andExpect(jsonPath("$.[*].infoA").value(hasItem(DEFAULT_INFO_A.toString())))
            .andExpect(jsonPath("$.[*].infoB").value(hasItem(DEFAULT_INFO_B.toString())))
            .andExpect(jsonPath("$.[*].infoC").value(hasItem(DEFAULT_INFO_C.toString())))
            .andExpect(jsonPath("$.[*].infoDA").value(hasItem(DEFAULT_INFO_DA.toString())))
            .andExpect(jsonPath("$.[*].infoDB").value(hasItem(DEFAULT_INFO_DB.toString())))
            .andExpect(jsonPath("$.[*].infoDC").value(hasItem(DEFAULT_INFO_DC.toString())))
            .andExpect(jsonPath("$.[*].infoDD").value(hasItem(DEFAULT_INFO_DD.toString())))
            .andExpect(jsonPath("$.[*].infoE").value(hasItem(DEFAULT_INFO_E.toString())))
            .andExpect(jsonPath("$.[*].infoF").value(hasItem(DEFAULT_INFO_F.toString())))
            .andExpect(jsonPath("$.[*].infoG").value(hasItem(DEFAULT_INFO_G.toString())))
            .andExpect(jsonPath("$.[*].infoHA").value(hasItem(DEFAULT_INFO_HA.toString())))
            .andExpect(jsonPath("$.[*].infoHB").value(hasItem(DEFAULT_INFO_HB.toString())))
            .andExpect(jsonPath("$.[*].infoHC").value(hasItem(DEFAULT_INFO_HC.toString())))
            .andExpect(jsonPath("$.[*].infoIA").value(hasItem(DEFAULT_INFO_IA.toString())))
            .andExpect(jsonPath("$.[*].infoIB").value(hasItem(DEFAULT_INFO_IB.toString())))
            .andExpect(jsonPath("$.[*].infoIC").value(hasItem(DEFAULT_INFO_IC.toString())))
            .andExpect(jsonPath("$.[*].infoID").value(hasItem(DEFAULT_INFO_ID.toString())))
            .andExpect(jsonPath("$.[*].infoIE").value(hasItem(DEFAULT_INFO_IE.toString())))
            .andExpect(jsonPath("$.[*].infoJ").value(hasItem(DEFAULT_INFO_J.toString())))
            .andExpect(jsonPath("$.[*].infoKA").value(hasItem(DEFAULT_INFO_KA.toString())))
            .andExpect(jsonPath("$.[*].infoKB").value(hasItem(DEFAULT_INFO_KB.toString())))
            .andExpect(jsonPath("$.[*].infoKC").value(hasItem(DEFAULT_INFO_KC.toString())))
            .andExpect(jsonPath("$.[*].infoKD").value(hasItem(DEFAULT_INFO_KD.toString())))
            .andExpect(jsonPath("$.[*].infoKE").value(hasItem(DEFAULT_INFO_KE.toString())))
            .andExpect(jsonPath("$.[*].infoKF").value(hasItem(DEFAULT_INFO_KF.toString())))
            .andExpect(jsonPath("$.[*].infoL").value(hasItem(DEFAULT_INFO_L.toString())))
            .andExpect(jsonPath("$.[*].infoM").value(hasItem(DEFAULT_INFO_M.toString())))
            .andExpect(jsonPath("$.[*].infoN").value(hasItem(DEFAULT_INFO_N.toString())))
            .andExpect(jsonPath("$.[*].infoOA").value(hasItem(DEFAULT_INFO_OA.toString())))
            .andExpect(jsonPath("$.[*].infoOB").value(hasItem(DEFAULT_INFO_OB.toString())))
            .andExpect(jsonPath("$.[*].infoP").value(hasItem(DEFAULT_INFO_P.toString())))
            .andExpect(jsonPath("$.[*].infoQ").value(hasItem(DEFAULT_INFO_Q.toString())))
            .andExpect(jsonPath("$.[*].infoR").value(hasItem(DEFAULT_INFO_R.toString())));
    }
    
    @Test
    @Transactional
    public void getTowerTemp() throws Exception {
        // Initialize the database
        towerTempRepository.saveAndFlush(towerTemp);

        // Get the towerTemp
        restTowerTempMockMvc.perform(get("/api/tower-temps/{id}", towerTemp.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(towerTemp.getId().intValue()))
            .andExpect(jsonPath("$.towerNumber").value(DEFAULT_TOWER_NUMBER.toString()))
            .andExpect(jsonPath("$.serialNumber").value(DEFAULT_SERIAL_NUMBER.toString()))
            .andExpect(jsonPath("$.longitude").value(DEFAULT_LONGITUDE.toString()))
            .andExpect(jsonPath("$.latitude").value(DEFAULT_LATITUDE.toString()))
            .andExpect(jsonPath("$.altitude").value(DEFAULT_ALTITUDE.toString()))
            .andExpect(jsonPath("$.utmX").value(DEFAULT_UTM_X.toString()))
            .andExpect(jsonPath("$.utmY").value(DEFAULT_UTM_Y.toString()))
            .andExpect(jsonPath("$.progressiveDistance").value(DEFAULT_PROGRESSIVE_DISTANCE.toString()))
            .andExpect(jsonPath("$.isCorner").value(DEFAULT_IS_CORNER.toString()))
            .andExpect(jsonPath("$.corner").value(DEFAULT_CORNER.toString()))
            .andExpect(jsonPath("$.spanDistance").value(DEFAULT_SPAN_DISTANCE.toString()))
            .andExpect(jsonPath("$.towerType").value(DEFAULT_TOWER_TYPE.toString()))
            .andExpect(jsonPath("$.folha").value(DEFAULT_FOLHA.toString()))
            .andExpect(jsonPath("$.sirgas2000X").value(DEFAULT_SIRGAS_2000_X.toString()))
            .andExpect(jsonPath("$.sirgas2000Y").value(DEFAULT_SIRGAS_2000_Y.toString()))
            .andExpect(jsonPath("$.sirgas2000Cota").value(DEFAULT_SIRGAS_2000_COTA.toString()))
            .andExpect(jsonPath("$.condutorCota").value(DEFAULT_CONDUTOR_COTA.toString()))
            .andExpect(jsonPath("$.pontosTower").value(DEFAULT_PONTOS_TOWER.toString()))
            .andExpect(jsonPath("$.utmCota").value(DEFAULT_UTM_COTA.toString()))
            .andExpect(jsonPath("$.infoA").value(DEFAULT_INFO_A.toString()))
            .andExpect(jsonPath("$.infoB").value(DEFAULT_INFO_B.toString()))
            .andExpect(jsonPath("$.infoC").value(DEFAULT_INFO_C.toString()))
            .andExpect(jsonPath("$.infoDA").value(DEFAULT_INFO_DA.toString()))
            .andExpect(jsonPath("$.infoDB").value(DEFAULT_INFO_DB.toString()))
            .andExpect(jsonPath("$.infoDC").value(DEFAULT_INFO_DC.toString()))
            .andExpect(jsonPath("$.infoDD").value(DEFAULT_INFO_DD.toString()))
            .andExpect(jsonPath("$.infoE").value(DEFAULT_INFO_E.toString()))
            .andExpect(jsonPath("$.infoF").value(DEFAULT_INFO_F.toString()))
            .andExpect(jsonPath("$.infoG").value(DEFAULT_INFO_G.toString()))
            .andExpect(jsonPath("$.infoHA").value(DEFAULT_INFO_HA.toString()))
            .andExpect(jsonPath("$.infoHB").value(DEFAULT_INFO_HB.toString()))
            .andExpect(jsonPath("$.infoHC").value(DEFAULT_INFO_HC.toString()))
            .andExpect(jsonPath("$.infoIA").value(DEFAULT_INFO_IA.toString()))
            .andExpect(jsonPath("$.infoIB").value(DEFAULT_INFO_IB.toString()))
            .andExpect(jsonPath("$.infoIC").value(DEFAULT_INFO_IC.toString()))
            .andExpect(jsonPath("$.infoID").value(DEFAULT_INFO_ID.toString()))
            .andExpect(jsonPath("$.infoIE").value(DEFAULT_INFO_IE.toString()))
            .andExpect(jsonPath("$.infoJ").value(DEFAULT_INFO_J.toString()))
            .andExpect(jsonPath("$.infoKA").value(DEFAULT_INFO_KA.toString()))
            .andExpect(jsonPath("$.infoKB").value(DEFAULT_INFO_KB.toString()))
            .andExpect(jsonPath("$.infoKC").value(DEFAULT_INFO_KC.toString()))
            .andExpect(jsonPath("$.infoKD").value(DEFAULT_INFO_KD.toString()))
            .andExpect(jsonPath("$.infoKE").value(DEFAULT_INFO_KE.toString()))
            .andExpect(jsonPath("$.infoKF").value(DEFAULT_INFO_KF.toString()))
            .andExpect(jsonPath("$.infoL").value(DEFAULT_INFO_L.toString()))
            .andExpect(jsonPath("$.infoM").value(DEFAULT_INFO_M.toString()))
            .andExpect(jsonPath("$.infoN").value(DEFAULT_INFO_N.toString()))
            .andExpect(jsonPath("$.infoOA").value(DEFAULT_INFO_OA.toString()))
            .andExpect(jsonPath("$.infoOB").value(DEFAULT_INFO_OB.toString()))
            .andExpect(jsonPath("$.infoP").value(DEFAULT_INFO_P.toString()))
            .andExpect(jsonPath("$.infoQ").value(DEFAULT_INFO_Q.toString()))
            .andExpect(jsonPath("$.infoR").value(DEFAULT_INFO_R.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingTowerTemp() throws Exception {
        // Get the towerTemp
        restTowerTempMockMvc.perform(get("/api/tower-temps/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateTowerTemp() throws Exception {
        // Initialize the database
        towerTempRepository.saveAndFlush(towerTemp);

        int databaseSizeBeforeUpdate = towerTempRepository.findAll().size();

        // Update the towerTemp
        TowerTemp updatedTowerTemp = towerTempRepository.findById(towerTemp.getId()).get();
        // Disconnect from session so that the updates on updatedTowerTemp are not directly saved in db
        em.detach(updatedTowerTemp);
        updatedTowerTemp
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
            .towerType(UPDATED_TOWER_TYPE)
            .folha(UPDATED_FOLHA)
            .sirgas2000X(UPDATED_SIRGAS_2000_X)
            .sirgas2000Y(UPDATED_SIRGAS_2000_Y)
            .sirgas2000Cota(UPDATED_SIRGAS_2000_COTA)
            .condutorCota(UPDATED_CONDUTOR_COTA)
            .pontosTower(UPDATED_PONTOS_TOWER)
            .utmCota(UPDATED_UTM_COTA)
            .infoA(UPDATED_INFO_A)
            .infoB(UPDATED_INFO_B)
            .infoC(UPDATED_INFO_C)
            .infoDA(UPDATED_INFO_DA)
            .infoDB(UPDATED_INFO_DB)
            .infoDC(UPDATED_INFO_DC)
            .infoDD(UPDATED_INFO_DD)
            .infoE(UPDATED_INFO_E)
            .infoF(UPDATED_INFO_F)
            .infoG(UPDATED_INFO_G)
            .infoHA(UPDATED_INFO_HA)
            .infoHB(UPDATED_INFO_HB)
            .infoHC(UPDATED_INFO_HC)
            .infoIA(UPDATED_INFO_IA)
            .infoIB(UPDATED_INFO_IB)
            .infoIC(UPDATED_INFO_IC)
            .infoID(UPDATED_INFO_ID)
            .infoIE(UPDATED_INFO_IE)
            .infoJ(UPDATED_INFO_J)
            .infoKA(UPDATED_INFO_KA)
            .infoKB(UPDATED_INFO_KB)
            .infoKC(UPDATED_INFO_KC)
            .infoKD(UPDATED_INFO_KD)
            .infoKE(UPDATED_INFO_KE)
            .infoKF(UPDATED_INFO_KF)
            .infoL(UPDATED_INFO_L)
            .infoM(UPDATED_INFO_M)
            .infoN(UPDATED_INFO_N)
            .infoOA(UPDATED_INFO_OA)
            .infoOB(UPDATED_INFO_OB)
            .infoP(UPDATED_INFO_P)
            .infoQ(UPDATED_INFO_Q)
            .infoR(UPDATED_INFO_R);

        restTowerTempMockMvc.perform(put("/api/tower-temps")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedTowerTemp)))
            .andExpect(status().isOk());

        // Validate the TowerTemp in the database
        List<TowerTemp> towerTempList = towerTempRepository.findAll();
        assertThat(towerTempList).hasSize(databaseSizeBeforeUpdate);
        TowerTemp testTowerTemp = towerTempList.get(towerTempList.size() - 1);
        assertThat(testTowerTemp.getTowerNumber()).isEqualTo(UPDATED_TOWER_NUMBER);
        assertThat(testTowerTemp.getSerialNumber()).isEqualTo(UPDATED_SERIAL_NUMBER);
        assertThat(testTowerTemp.getLongitude()).isEqualTo(UPDATED_LONGITUDE);
        assertThat(testTowerTemp.getLatitude()).isEqualTo(UPDATED_LATITUDE);
        assertThat(testTowerTemp.getAltitude()).isEqualTo(UPDATED_ALTITUDE);
        assertThat(testTowerTemp.getUtmX()).isEqualTo(UPDATED_UTM_X);
        assertThat(testTowerTemp.getUtmY()).isEqualTo(UPDATED_UTM_Y);
        assertThat(testTowerTemp.getProgressiveDistance()).isEqualTo(UPDATED_PROGRESSIVE_DISTANCE);
        assertThat(testTowerTemp.getIsCorner()).isEqualTo(UPDATED_IS_CORNER);
        assertThat(testTowerTemp.getCorner()).isEqualTo(UPDATED_CORNER);
        assertThat(testTowerTemp.getSpanDistance()).isEqualTo(UPDATED_SPAN_DISTANCE);
        assertThat(testTowerTemp.getTowerType()).isEqualTo(UPDATED_TOWER_TYPE);
        assertThat(testTowerTemp.getFolha()).isEqualTo(UPDATED_FOLHA);
        assertThat(testTowerTemp.getSirgas2000X()).isEqualTo(UPDATED_SIRGAS_2000_X);
        assertThat(testTowerTemp.getSirgas2000Y()).isEqualTo(UPDATED_SIRGAS_2000_Y);
        assertThat(testTowerTemp.getSirgas2000Cota()).isEqualTo(UPDATED_SIRGAS_2000_COTA);
        assertThat(testTowerTemp.getCondutorCota()).isEqualTo(UPDATED_CONDUTOR_COTA);
        assertThat(testTowerTemp.getPontosTower()).isEqualTo(UPDATED_PONTOS_TOWER);
        assertThat(testTowerTemp.getUtmCota()).isEqualTo(UPDATED_UTM_COTA);
        assertThat(testTowerTemp.getInfoA()).isEqualTo(UPDATED_INFO_A);
        assertThat(testTowerTemp.getInfoB()).isEqualTo(UPDATED_INFO_B);
        assertThat(testTowerTemp.getInfoC()).isEqualTo(UPDATED_INFO_C);
        assertThat(testTowerTemp.getInfoDA()).isEqualTo(UPDATED_INFO_DA);
        assertThat(testTowerTemp.getInfoDB()).isEqualTo(UPDATED_INFO_DB);
        assertThat(testTowerTemp.getInfoDC()).isEqualTo(UPDATED_INFO_DC);
        assertThat(testTowerTemp.getInfoDD()).isEqualTo(UPDATED_INFO_DD);
        assertThat(testTowerTemp.getInfoE()).isEqualTo(UPDATED_INFO_E);
        assertThat(testTowerTemp.getInfoF()).isEqualTo(UPDATED_INFO_F);
        assertThat(testTowerTemp.getInfoG()).isEqualTo(UPDATED_INFO_G);
        assertThat(testTowerTemp.getInfoHA()).isEqualTo(UPDATED_INFO_HA);
        assertThat(testTowerTemp.getInfoHB()).isEqualTo(UPDATED_INFO_HB);
        assertThat(testTowerTemp.getInfoHC()).isEqualTo(UPDATED_INFO_HC);
        assertThat(testTowerTemp.getInfoIA()).isEqualTo(UPDATED_INFO_IA);
        assertThat(testTowerTemp.getInfoIB()).isEqualTo(UPDATED_INFO_IB);
        assertThat(testTowerTemp.getInfoIC()).isEqualTo(UPDATED_INFO_IC);
        assertThat(testTowerTemp.getInfoID()).isEqualTo(UPDATED_INFO_ID);
        assertThat(testTowerTemp.getInfoIE()).isEqualTo(UPDATED_INFO_IE);
        assertThat(testTowerTemp.getInfoJ()).isEqualTo(UPDATED_INFO_J);
        assertThat(testTowerTemp.getInfoKA()).isEqualTo(UPDATED_INFO_KA);
        assertThat(testTowerTemp.getInfoKB()).isEqualTo(UPDATED_INFO_KB);
        assertThat(testTowerTemp.getInfoKC()).isEqualTo(UPDATED_INFO_KC);
        assertThat(testTowerTemp.getInfoKD()).isEqualTo(UPDATED_INFO_KD);
        assertThat(testTowerTemp.getInfoKE()).isEqualTo(UPDATED_INFO_KE);
        assertThat(testTowerTemp.getInfoKF()).isEqualTo(UPDATED_INFO_KF);
        assertThat(testTowerTemp.getInfoL()).isEqualTo(UPDATED_INFO_L);
        assertThat(testTowerTemp.getInfoM()).isEqualTo(UPDATED_INFO_M);
        assertThat(testTowerTemp.getInfoN()).isEqualTo(UPDATED_INFO_N);
        assertThat(testTowerTemp.getInfoOA()).isEqualTo(UPDATED_INFO_OA);
        assertThat(testTowerTemp.getInfoOB()).isEqualTo(UPDATED_INFO_OB);
        assertThat(testTowerTemp.getInfoP()).isEqualTo(UPDATED_INFO_P);
        assertThat(testTowerTemp.getInfoQ()).isEqualTo(UPDATED_INFO_Q);
        assertThat(testTowerTemp.getInfoR()).isEqualTo(UPDATED_INFO_R);
    }

    @Test
    @Transactional
    public void updateNonExistingTowerTemp() throws Exception {
        int databaseSizeBeforeUpdate = towerTempRepository.findAll().size();

        // Create the TowerTemp

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTowerTempMockMvc.perform(put("/api/tower-temps")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(towerTemp)))
            .andExpect(status().isBadRequest());

        // Validate the TowerTemp in the database
        List<TowerTemp> towerTempList = towerTempRepository.findAll();
        assertThat(towerTempList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteTowerTemp() throws Exception {
        // Initialize the database
        towerTempRepository.saveAndFlush(towerTemp);

        int databaseSizeBeforeDelete = towerTempRepository.findAll().size();

        // Delete the towerTemp
        restTowerTempMockMvc.perform(delete("/api/tower-temps/{id}", towerTemp.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<TowerTemp> towerTempList = towerTempRepository.findAll();
        assertThat(towerTempList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(TowerTemp.class);
        TowerTemp towerTemp1 = new TowerTemp();
        towerTemp1.setId(1L);
        TowerTemp towerTemp2 = new TowerTemp();
        towerTemp2.setId(towerTemp1.getId());
        assertThat(towerTemp1).isEqualTo(towerTemp2);
        towerTemp2.setId(2L);
        assertThat(towerTemp1).isNotEqualTo(towerTemp2);
        towerTemp1.setId(null);
        assertThat(towerTemp1).isNotEqualTo(towerTemp2);
    }
}
