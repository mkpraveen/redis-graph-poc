package com.hcl.fxg.model;

public class FxgFacility {
	private int facilityId;
	private String facilityCode;
	private int facilityType;
	private FxgFacilityAddress facilityAddress;
	private FxgFacility parentHub; 
	private FxgFacilitySchedule facilitySchedule;
	
	public int getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}
	public String getFacilityCode() {
		return facilityCode;
	}
	public void setFacilityCode(String facilityCode) {
		this.facilityCode = facilityCode;
	}
	public int getFacilityType() {
		return facilityType;
	}
	public void setFacilityType(int facilityType) {
		this.facilityType = facilityType;
	}
	public FxgFacilityAddress getFacilityAddress() {
		return facilityAddress;
	}
	public void setFacilityAddress(FxgFacilityAddress facilityAddress) {
		this.facilityAddress = facilityAddress;
	}
	public FxgFacility getParentHub() {
		return parentHub;
	}
	public void setParentHub(FxgFacility parentHub) {
		this.parentHub = parentHub;
	}
	public FxgFacilitySchedule getFacilitySchedule() {
		return facilitySchedule;
	}
	public void setFacilitySchedule(FxgFacilitySchedule facilitySchedule) {
		this.facilitySchedule = facilitySchedule;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((facilityAddress == null) ? 0 : facilityAddress.hashCode());
		result = prime * result + ((facilityCode == null) ? 0 : facilityCode.hashCode());
		result = prime * result + facilityId;
		result = prime * result + ((facilitySchedule == null) ? 0 : facilitySchedule.hashCode());
		result = prime * result + facilityType;
		result = prime * result + ((parentHub == null) ? 0 : parentHub.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FxgFacility other = (FxgFacility) obj;
		if (facilityAddress == null) {
			if (other.facilityAddress != null)
				return false;
		} else if (!facilityAddress.equals(other.facilityAddress))
			return false;
		if (facilityCode == null) {
			if (other.facilityCode != null)
				return false;
		} else if (!facilityCode.equals(other.facilityCode))
			return false;
		if (facilityId != other.facilityId)
			return false;
		if (facilitySchedule == null) {
			if (other.facilitySchedule != null)
				return false;
		} else if (!facilitySchedule.equals(other.facilitySchedule))
			return false;
		if (facilityType != other.facilityType)
			return false;
		if (parentHub == null) {
			if (other.parentHub != null)
				return false;
		} else if (!parentHub.equals(other.parentHub))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FxgFacility [facilityId=" + facilityId + ", facilityCode=" + facilityCode + ", facilityType="
				+ facilityType + ", facilityAddress=" + facilityAddress + ", parentHub=" + parentHub
				+ ", facilitySchedule=" + facilitySchedule + "]";
	}
	
	
}
