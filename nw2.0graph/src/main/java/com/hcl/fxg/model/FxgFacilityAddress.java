package com.hcl.fxg.model;

public class FxgFacilityAddress {
	private String addressLine1;
	private String addressLine2;
	private String zipCode5;
	private String zipCode4;
	private String cityName;
	private String stateCode;
	
	public FxgFacilityAddress() {
		super();
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getZipCode5() {
		return zipCode5;
	}
	public void setZipCode5(String zipCode5) {
		this.zipCode5 = zipCode5;
	}
	public String getZipCode4() {
		return zipCode4;
	}
	public void setZipCode4(String zipCode4) {
		this.zipCode4 = zipCode4;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressLine1 == null) ? 0 : addressLine1.hashCode());
		result = prime * result + ((addressLine2 == null) ? 0 : addressLine2.hashCode());
		result = prime * result + ((cityName == null) ? 0 : cityName.hashCode());
		result = prime * result + ((stateCode == null) ? 0 : stateCode.hashCode());
		result = prime * result + ((zipCode4 == null) ? 0 : zipCode4.hashCode());
		result = prime * result + ((zipCode5 == null) ? 0 : zipCode5.hashCode());
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
		FxgFacilityAddress other = (FxgFacilityAddress) obj;
		if (addressLine1 == null) {
			if (other.addressLine1 != null)
				return false;
		} else if (!addressLine1.equals(other.addressLine1))
			return false;
		if (addressLine2 == null) {
			if (other.addressLine2 != null)
				return false;
		} else if (!addressLine2.equals(other.addressLine2))
			return false;
		if (cityName == null) {
			if (other.cityName != null)
				return false;
		} else if (!cityName.equals(other.cityName))
			return false;
		if (stateCode == null) {
			if (other.stateCode != null)
				return false;
		} else if (!stateCode.equals(other.stateCode))
			return false;
		if (zipCode4 == null) {
			if (other.zipCode4 != null)
				return false;
		} else if (!zipCode4.equals(other.zipCode4))
			return false;
		if (zipCode5 == null) {
			if (other.zipCode5 != null)
				return false;
		} else if (!zipCode5.equals(other.zipCode5))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FxgFacilityAddress [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", zipCode5="
				+ zipCode5 + ", zipCode4=" + zipCode4 + ", cityName=" + cityName + ", stateCode=" + stateCode + "]";
	}
	
	
}
