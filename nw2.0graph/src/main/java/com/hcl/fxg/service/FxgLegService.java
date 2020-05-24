package com.hcl.fxg.service;

import java.util.List;

import com.hcl.fxg.model.entity.FxgLeg;

public interface FxgLegService {
	public FxgLeg createLeg(FxgLeg fxgLeg);
	public List<FxgLeg> getAllFxgLegs();
}
