package com.hcl.fxg.model;

import java.util.Arrays;

public class FxgFacilitySchedule {

	public static final Integer HOURS_8AM_TO_5PM = 1;
	public static final Integer HOURS_11AM_TO_8PM = 2;
	public static final Integer HOURS_2PM_TO_11PM = 2;
	public static final Integer HOURS_00AM_TO_11PM = 3;
	
	private Boolean[] daysOfWeek = new Boolean[7];
	private Integer[] workingHours = new Integer[7];
	
	public Boolean[] getDaysOfWeek() {
		return daysOfWeek;
	}
	public void setDaysOfWeek(Boolean[] daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
	}
	public Integer[] getWorkingHours() {
		return workingHours;
	}
	public void setWorkingHours(Integer[] workingHours) {
		this.workingHours = workingHours;
	}
	
	@Override
	public String toString() {
		return "FxgFacilitySchedule [daysOfWeek=" + Arrays.toString(daysOfWeek) + ", workingHours="
				+ Arrays.toString(workingHours) + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(daysOfWeek);
		result = prime * result + Arrays.hashCode(workingHours);
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
		FxgFacilitySchedule other = (FxgFacilitySchedule) obj;
		if (!Arrays.equals(daysOfWeek, other.daysOfWeek))
			return false;
		if (!Arrays.equals(workingHours, other.workingHours))
			return false;
		return true;
	}
	
	
}
