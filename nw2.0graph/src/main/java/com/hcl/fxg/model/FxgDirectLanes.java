package com.hcl.fxg.model;

public class FxgDirectLanes {
	private FxgFacility originFacility;
	private FxgFacility destinationFacility;
	
	private int originDowId;
	private int destinationDowId;
	private int destinationSplitTypeId;
	
	
	public FxgFacility getOriginFacility() {
		return originFacility;
	}
	public void setOriginFacility(FxgFacility originFacility) {
		this.originFacility = originFacility;
	}
	public FxgFacility getDestinationFacility() {
		return destinationFacility;
	}
	public void setDestinationFacility(FxgFacility destinationFacility) {
		this.destinationFacility = destinationFacility;
	}
	public int getOriginDowId() {
		return originDowId;
	}
	public void setOriginDowId(int originDowId) {
		this.originDowId = originDowId;
	}
	public int getDestinationDowId() {
		return destinationDowId;
	}
	public void setDestinationDowId(int destinationDowId) {
		this.destinationDowId = destinationDowId;
	}
	public int getDestinationSplitTypeId() {
		return destinationSplitTypeId;
	}
	public void setDestinationSplitTypeId(int destinationSplitTypeId) {
		this.destinationSplitTypeId = destinationSplitTypeId;
	}
	
}
