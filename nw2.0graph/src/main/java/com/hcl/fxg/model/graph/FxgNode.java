package com.hcl.fxg.model.graph;

import com.hcl.fxg.model.entity.FxgFacility;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
public class FxgNode {
	
	private int facilityId;
	private String facilityCode;
	private int facilityType;
	

	public FxgNode(FxgFacility fxgFacility) {
		super();
		this.facilityId = fxgFacility.getFacilityId();
		this.facilityCode = fxgFacility.getFacilityCode();
		this.facilityType = fxgFacility.getFacilityType();
	}

	public FxgNode() {
		super();
	}
}
