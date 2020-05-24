package com.hcl.fxg.model.graph;

import com.hcl.fxg.model.entity.FxgFacility;
import com.redislabs.redisgraph.graph_entities.Node;

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
	
	public FxgNode(Node redisNode) {
		super();
		this.facilityId = Integer.parseInt(redisNode.getProperty("facilityId").getValue().toString());
		this.facilityCode = redisNode.getProperty("facilityCode").getValue().toString();
		this.facilityType = Integer.parseInt(redisNode.getProperty("facilityType").getValue().toString());;
	}
}
