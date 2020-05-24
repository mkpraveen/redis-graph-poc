package com.hcl.fxg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.fxg.model.entity.FxgLeg;
import com.hcl.fxg.model.repository.FxgLegRepository;

@Service
public class FxgLegServiceImpl implements FxgLegService {

	@Autowired
	private FxgLegRepository fxgLegRepo;
	
	@Override
	public FxgLeg createLeg(FxgLeg fxgLeg) {
		return fxgLegRepo.save(fxgLeg);
	}

	@Override
	public List<FxgLeg> getAllFxgLegs() {
		return fxgLegRepo.findAll();
	}

	
}
