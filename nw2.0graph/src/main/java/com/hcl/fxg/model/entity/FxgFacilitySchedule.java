package com.hcl.fxg.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@ToString
@EqualsAndHashCode
@Builder
@Table(name = "FXG_FACILITY_SCHEDULE")
public class FxgFacilitySchedule {

//	public static final Integer HOURS_8AM_TO_5PM = 1;
//	public static final Integer HOURS_11AM_TO_8PM = 2;
//	public static final Integer HOURS_2PM_TO_11PM = 2;
//	public static final Integer HOURS_00AM_TO_11PM = 3;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SCHD_ID")
	private long id;
	
	private Boolean[] daysOfWeek = new Boolean[7];
	private Integer[] workingHours = new Integer[7];
		
}
