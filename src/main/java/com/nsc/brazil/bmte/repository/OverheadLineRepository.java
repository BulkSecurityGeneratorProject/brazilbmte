package com.nsc.brazil.bmte.repository;

import com.nsc.brazil.bmte.domain.OverheadLine;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the OverheadLine entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OverheadLineRepository extends JpaRepository<OverheadLine, Long> {

}
