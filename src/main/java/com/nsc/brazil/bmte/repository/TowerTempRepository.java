package com.nsc.brazil.bmte.repository;

import com.nsc.brazil.bmte.domain.TowerTemp;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the TowerTemp entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TowerTempRepository extends JpaRepository<TowerTemp, Long> {

}
