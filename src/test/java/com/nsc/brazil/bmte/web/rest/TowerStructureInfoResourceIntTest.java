package com.nsc.brazil.bmte.web.rest;

import com.nsc.brazil.bmte.BrazilbmteApp;

import com.nsc.brazil.bmte.domain.TowerStructureInfo;
import com.nsc.brazil.bmte.repository.TowerStructureInfoRepository;
import com.nsc.brazil.bmte.service.TowerStructureInfoService;
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
 * Test class for the TowerStructureInfoResource REST controller.
 *
 * @see TowerStructureInfoResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BrazilbmteApp.class)
public class TowerStructureInfoResourceIntTest {

    private static final Double DEFAULT_FOLHA = 1D;
    private static final Double UPDATED_FOLHA = 2D;

    private static final Double DEFAULT_SIRGAS_2000_X = 1D;
    private static final Double UPDATED_SIRGAS_2000_X = 2D;

    private static final Double DEFAULT_SIRGAS_2000_Y = 1D;
    private static final Double UPDATED_SIRGAS_2000_Y = 2D;

    private static final Double DEFAULT_SIRGAS_2000_COTA = 1D;
    private static final Double UPDATED_SIRGAS_2000_COTA = 2D;

    private static final Double DEFAULT_CONDUTOR_COTA = 1D;
    private static final Double UPDATED_CONDUTOR_COTA = 2D;

    private static final Double DEFAULT_PONTOS_TOWER = 1D;
    private static final Double UPDATED_PONTOS_TOWER = 2D;

    private static final Double DEFAULT_UTM_COTA = 1D;
    private static final Double UPDATED_UTM_COTA = 2D;

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
    private TowerStructureInfoRepository towerStructureInfoRepository;

    @Autowired
    private TowerStructureInfoService towerStructureInfoService;

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

    private MockMvc restTowerStructureInfoMockMvc;

    private TowerStructureInfo towerStructureInfo;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final TowerStructureInfoResource towerStructureInfoResource = new TowerStructureInfoResource(towerStructureInfoService);
        this.restTowerStructureInfoMockMvc = MockMvcBuilders.standaloneSetup(towerStructureInfoResource)
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
    public static TowerStructureInfo createEntity(EntityManager em) {
        TowerStructureInfo towerStructureInfo = new TowerStructureInfo()
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
        return towerStructureInfo;
    }

    @Before
    public void initTest() {
        towerStructureInfo = createEntity(em);
    }

    @Test
    @Transactional
    public void createTowerStructureInfo() throws Exception {
        int databaseSizeBeforeCreate = towerStructureInfoRepository.findAll().size();

        // Create the TowerStructureInfo
        restTowerStructureInfoMockMvc.perform(post("/api/tower-structure-infos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(towerStructureInfo)))
            .andExpect(status().isCreated());

        // Validate the TowerStructureInfo in the database
        List<TowerStructureInfo> towerStructureInfoList = towerStructureInfoRepository.findAll();
        assertThat(towerStructureInfoList).hasSize(databaseSizeBeforeCreate + 1);
        TowerStructureInfo testTowerStructureInfo = towerStructureInfoList.get(towerStructureInfoList.size() - 1);
        assertThat(testTowerStructureInfo.getFolha()).isEqualTo(DEFAULT_FOLHA);
        assertThat(testTowerStructureInfo.getSirgas2000X()).isEqualTo(DEFAULT_SIRGAS_2000_X);
        assertThat(testTowerStructureInfo.getSirgas2000Y()).isEqualTo(DEFAULT_SIRGAS_2000_Y);
        assertThat(testTowerStructureInfo.getSirgas2000Cota()).isEqualTo(DEFAULT_SIRGAS_2000_COTA);
        assertThat(testTowerStructureInfo.getCondutorCota()).isEqualTo(DEFAULT_CONDUTOR_COTA);
        assertThat(testTowerStructureInfo.getPontosTower()).isEqualTo(DEFAULT_PONTOS_TOWER);
        assertThat(testTowerStructureInfo.getUtmCota()).isEqualTo(DEFAULT_UTM_COTA);
        assertThat(testTowerStructureInfo.getInfoA()).isEqualTo(DEFAULT_INFO_A);
        assertThat(testTowerStructureInfo.getInfoB()).isEqualTo(DEFAULT_INFO_B);
        assertThat(testTowerStructureInfo.getInfoC()).isEqualTo(DEFAULT_INFO_C);
        assertThat(testTowerStructureInfo.getInfoDA()).isEqualTo(DEFAULT_INFO_DA);
        assertThat(testTowerStructureInfo.getInfoDB()).isEqualTo(DEFAULT_INFO_DB);
        assertThat(testTowerStructureInfo.getInfoDC()).isEqualTo(DEFAULT_INFO_DC);
        assertThat(testTowerStructureInfo.getInfoDD()).isEqualTo(DEFAULT_INFO_DD);
        assertThat(testTowerStructureInfo.getInfoE()).isEqualTo(DEFAULT_INFO_E);
        assertThat(testTowerStructureInfo.getInfoF()).isEqualTo(DEFAULT_INFO_F);
        assertThat(testTowerStructureInfo.getInfoG()).isEqualTo(DEFAULT_INFO_G);
        assertThat(testTowerStructureInfo.getInfoHA()).isEqualTo(DEFAULT_INFO_HA);
        assertThat(testTowerStructureInfo.getInfoHB()).isEqualTo(DEFAULT_INFO_HB);
        assertThat(testTowerStructureInfo.getInfoHC()).isEqualTo(DEFAULT_INFO_HC);
        assertThat(testTowerStructureInfo.getInfoIA()).isEqualTo(DEFAULT_INFO_IA);
        assertThat(testTowerStructureInfo.getInfoIB()).isEqualTo(DEFAULT_INFO_IB);
        assertThat(testTowerStructureInfo.getInfoIC()).isEqualTo(DEFAULT_INFO_IC);
        assertThat(testTowerStructureInfo.getInfoID()).isEqualTo(DEFAULT_INFO_ID);
        assertThat(testTowerStructureInfo.getInfoIE()).isEqualTo(DEFAULT_INFO_IE);
        assertThat(testTowerStructureInfo.getInfoJ()).isEqualTo(DEFAULT_INFO_J);
        assertThat(testTowerStructureInfo.getInfoKA()).isEqualTo(DEFAULT_INFO_KA);
        assertThat(testTowerStructureInfo.getInfoKB()).isEqualTo(DEFAULT_INFO_KB);
        assertThat(testTowerStructureInfo.getInfoKC()).isEqualTo(DEFAULT_INFO_KC);
        assertThat(testTowerStructureInfo.getInfoKD()).isEqualTo(DEFAULT_INFO_KD);
        assertThat(testTowerStructureInfo.getInfoKE()).isEqualTo(DEFAULT_INFO_KE);
        assertThat(testTowerStructureInfo.getInfoKF()).isEqualTo(DEFAULT_INFO_KF);
        assertThat(testTowerStructureInfo.getInfoL()).isEqualTo(DEFAULT_INFO_L);
        assertThat(testTowerStructureInfo.getInfoM()).isEqualTo(DEFAULT_INFO_M);
        assertThat(testTowerStructureInfo.getInfoN()).isEqualTo(DEFAULT_INFO_N);
        assertThat(testTowerStructureInfo.getInfoOA()).isEqualTo(DEFAULT_INFO_OA);
        assertThat(testTowerStructureInfo.getInfoOB()).isEqualTo(DEFAULT_INFO_OB);
        assertThat(testTowerStructureInfo.getInfoP()).isEqualTo(DEFAULT_INFO_P);
        assertThat(testTowerStructureInfo.getInfoQ()).isEqualTo(DEFAULT_INFO_Q);
        assertThat(testTowerStructureInfo.getInfoR()).isEqualTo(DEFAULT_INFO_R);
    }

    @Test
    @Transactional
    public void createTowerStructureInfoWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = towerStructureInfoRepository.findAll().size();

        // Create the TowerStructureInfo with an existing ID
        towerStructureInfo.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restTowerStructureInfoMockMvc.perform(post("/api/tower-structure-infos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(towerStructureInfo)))
            .andExpect(status().isBadRequest());

        // Validate the TowerStructureInfo in the database
        List<TowerStructureInfo> towerStructureInfoList = towerStructureInfoRepository.findAll();
        assertThat(towerStructureInfoList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllTowerStructureInfos() throws Exception {
        // Initialize the database
        towerStructureInfoRepository.saveAndFlush(towerStructureInfo);

        // Get all the towerStructureInfoList
        restTowerStructureInfoMockMvc.perform(get("/api/tower-structure-infos?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(towerStructureInfo.getId().intValue())))
            .andExpect(jsonPath("$.[*].folha").value(hasItem(DEFAULT_FOLHA.doubleValue())))
            .andExpect(jsonPath("$.[*].sirgas2000X").value(hasItem(DEFAULT_SIRGAS_2000_X.doubleValue())))
            .andExpect(jsonPath("$.[*].sirgas2000Y").value(hasItem(DEFAULT_SIRGAS_2000_Y.doubleValue())))
            .andExpect(jsonPath("$.[*].sirgas2000Cota").value(hasItem(DEFAULT_SIRGAS_2000_COTA.doubleValue())))
            .andExpect(jsonPath("$.[*].condutorCota").value(hasItem(DEFAULT_CONDUTOR_COTA.doubleValue())))
            .andExpect(jsonPath("$.[*].pontosTower").value(hasItem(DEFAULT_PONTOS_TOWER.doubleValue())))
            .andExpect(jsonPath("$.[*].utmCota").value(hasItem(DEFAULT_UTM_COTA.doubleValue())))
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
    public void getTowerStructureInfo() throws Exception {
        // Initialize the database
        towerStructureInfoRepository.saveAndFlush(towerStructureInfo);

        // Get the towerStructureInfo
        restTowerStructureInfoMockMvc.perform(get("/api/tower-structure-infos/{id}", towerStructureInfo.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(towerStructureInfo.getId().intValue()))
            .andExpect(jsonPath("$.folha").value(DEFAULT_FOLHA.doubleValue()))
            .andExpect(jsonPath("$.sirgas2000X").value(DEFAULT_SIRGAS_2000_X.doubleValue()))
            .andExpect(jsonPath("$.sirgas2000Y").value(DEFAULT_SIRGAS_2000_Y.doubleValue()))
            .andExpect(jsonPath("$.sirgas2000Cota").value(DEFAULT_SIRGAS_2000_COTA.doubleValue()))
            .andExpect(jsonPath("$.condutorCota").value(DEFAULT_CONDUTOR_COTA.doubleValue()))
            .andExpect(jsonPath("$.pontosTower").value(DEFAULT_PONTOS_TOWER.doubleValue()))
            .andExpect(jsonPath("$.utmCota").value(DEFAULT_UTM_COTA.doubleValue()))
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
    public void getNonExistingTowerStructureInfo() throws Exception {
        // Get the towerStructureInfo
        restTowerStructureInfoMockMvc.perform(get("/api/tower-structure-infos/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateTowerStructureInfo() throws Exception {
        // Initialize the database
        towerStructureInfoService.save(towerStructureInfo);

        int databaseSizeBeforeUpdate = towerStructureInfoRepository.findAll().size();

        // Update the towerStructureInfo
        TowerStructureInfo updatedTowerStructureInfo = towerStructureInfoRepository.findById(towerStructureInfo.getId()).get();
        // Disconnect from session so that the updates on updatedTowerStructureInfo are not directly saved in db
        em.detach(updatedTowerStructureInfo);
        updatedTowerStructureInfo
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

        restTowerStructureInfoMockMvc.perform(put("/api/tower-structure-infos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedTowerStructureInfo)))
            .andExpect(status().isOk());

        // Validate the TowerStructureInfo in the database
        List<TowerStructureInfo> towerStructureInfoList = towerStructureInfoRepository.findAll();
        assertThat(towerStructureInfoList).hasSize(databaseSizeBeforeUpdate);
        TowerStructureInfo testTowerStructureInfo = towerStructureInfoList.get(towerStructureInfoList.size() - 1);
        assertThat(testTowerStructureInfo.getFolha()).isEqualTo(UPDATED_FOLHA);
        assertThat(testTowerStructureInfo.getSirgas2000X()).isEqualTo(UPDATED_SIRGAS_2000_X);
        assertThat(testTowerStructureInfo.getSirgas2000Y()).isEqualTo(UPDATED_SIRGAS_2000_Y);
        assertThat(testTowerStructureInfo.getSirgas2000Cota()).isEqualTo(UPDATED_SIRGAS_2000_COTA);
        assertThat(testTowerStructureInfo.getCondutorCota()).isEqualTo(UPDATED_CONDUTOR_COTA);
        assertThat(testTowerStructureInfo.getPontosTower()).isEqualTo(UPDATED_PONTOS_TOWER);
        assertThat(testTowerStructureInfo.getUtmCota()).isEqualTo(UPDATED_UTM_COTA);
        assertThat(testTowerStructureInfo.getInfoA()).isEqualTo(UPDATED_INFO_A);
        assertThat(testTowerStructureInfo.getInfoB()).isEqualTo(UPDATED_INFO_B);
        assertThat(testTowerStructureInfo.getInfoC()).isEqualTo(UPDATED_INFO_C);
        assertThat(testTowerStructureInfo.getInfoDA()).isEqualTo(UPDATED_INFO_DA);
        assertThat(testTowerStructureInfo.getInfoDB()).isEqualTo(UPDATED_INFO_DB);
        assertThat(testTowerStructureInfo.getInfoDC()).isEqualTo(UPDATED_INFO_DC);
        assertThat(testTowerStructureInfo.getInfoDD()).isEqualTo(UPDATED_INFO_DD);
        assertThat(testTowerStructureInfo.getInfoE()).isEqualTo(UPDATED_INFO_E);
        assertThat(testTowerStructureInfo.getInfoF()).isEqualTo(UPDATED_INFO_F);
        assertThat(testTowerStructureInfo.getInfoG()).isEqualTo(UPDATED_INFO_G);
        assertThat(testTowerStructureInfo.getInfoHA()).isEqualTo(UPDATED_INFO_HA);
        assertThat(testTowerStructureInfo.getInfoHB()).isEqualTo(UPDATED_INFO_HB);
        assertThat(testTowerStructureInfo.getInfoHC()).isEqualTo(UPDATED_INFO_HC);
        assertThat(testTowerStructureInfo.getInfoIA()).isEqualTo(UPDATED_INFO_IA);
        assertThat(testTowerStructureInfo.getInfoIB()).isEqualTo(UPDATED_INFO_IB);
        assertThat(testTowerStructureInfo.getInfoIC()).isEqualTo(UPDATED_INFO_IC);
        assertThat(testTowerStructureInfo.getInfoID()).isEqualTo(UPDATED_INFO_ID);
        assertThat(testTowerStructureInfo.getInfoIE()).isEqualTo(UPDATED_INFO_IE);
        assertThat(testTowerStructureInfo.getInfoJ()).isEqualTo(UPDATED_INFO_J);
        assertThat(testTowerStructureInfo.getInfoKA()).isEqualTo(UPDATED_INFO_KA);
        assertThat(testTowerStructureInfo.getInfoKB()).isEqualTo(UPDATED_INFO_KB);
        assertThat(testTowerStructureInfo.getInfoKC()).isEqualTo(UPDATED_INFO_KC);
        assertThat(testTowerStructureInfo.getInfoKD()).isEqualTo(UPDATED_INFO_KD);
        assertThat(testTowerStructureInfo.getInfoKE()).isEqualTo(UPDATED_INFO_KE);
        assertThat(testTowerStructureInfo.getInfoKF()).isEqualTo(UPDATED_INFO_KF);
        assertThat(testTowerStructureInfo.getInfoL()).isEqualTo(UPDATED_INFO_L);
        assertThat(testTowerStructureInfo.getInfoM()).isEqualTo(UPDATED_INFO_M);
        assertThat(testTowerStructureInfo.getInfoN()).isEqualTo(UPDATED_INFO_N);
        assertThat(testTowerStructureInfo.getInfoOA()).isEqualTo(UPDATED_INFO_OA);
        assertThat(testTowerStructureInfo.getInfoOB()).isEqualTo(UPDATED_INFO_OB);
        assertThat(testTowerStructureInfo.getInfoP()).isEqualTo(UPDATED_INFO_P);
        assertThat(testTowerStructureInfo.getInfoQ()).isEqualTo(UPDATED_INFO_Q);
        assertThat(testTowerStructureInfo.getInfoR()).isEqualTo(UPDATED_INFO_R);
    }

    @Test
    @Transactional
    public void updateNonExistingTowerStructureInfo() throws Exception {
        int databaseSizeBeforeUpdate = towerStructureInfoRepository.findAll().size();

        // Create the TowerStructureInfo

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTowerStructureInfoMockMvc.perform(put("/api/tower-structure-infos")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(towerStructureInfo)))
            .andExpect(status().isBadRequest());

        // Validate the TowerStructureInfo in the database
        List<TowerStructureInfo> towerStructureInfoList = towerStructureInfoRepository.findAll();
        assertThat(towerStructureInfoList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteTowerStructureInfo() throws Exception {
        // Initialize the database
        towerStructureInfoService.save(towerStructureInfo);

        int databaseSizeBeforeDelete = towerStructureInfoRepository.findAll().size();

        // Delete the towerStructureInfo
        restTowerStructureInfoMockMvc.perform(delete("/api/tower-structure-infos/{id}", towerStructureInfo.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<TowerStructureInfo> towerStructureInfoList = towerStructureInfoRepository.findAll();
        assertThat(towerStructureInfoList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(TowerStructureInfo.class);
        TowerStructureInfo towerStructureInfo1 = new TowerStructureInfo();
        towerStructureInfo1.setId(1L);
        TowerStructureInfo towerStructureInfo2 = new TowerStructureInfo();
        towerStructureInfo2.setId(towerStructureInfo1.getId());
        assertThat(towerStructureInfo1).isEqualTo(towerStructureInfo2);
        towerStructureInfo2.setId(2L);
        assertThat(towerStructureInfo1).isNotEqualTo(towerStructureInfo2);
        towerStructureInfo1.setId(null);
        assertThat(towerStructureInfo1).isNotEqualTo(towerStructureInfo2);
    }
}
