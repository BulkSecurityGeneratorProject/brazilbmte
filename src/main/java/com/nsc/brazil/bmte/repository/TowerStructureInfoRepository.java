package com.nsc.brazil.bmte.repository;

import com.nsc.brazil.bmte.domain.TowerStructureInfo;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the TowerStructureInfo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TowerStructureInfoRepository extends JpaRepository<TowerStructureInfo, Long> {

}
