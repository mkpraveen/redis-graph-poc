package com.hcl.fxg.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.fxg.model.entity.FxgLeg;

@Repository
public interface FxgLegRepository extends JpaRepository<FxgLeg, Long> {

}
