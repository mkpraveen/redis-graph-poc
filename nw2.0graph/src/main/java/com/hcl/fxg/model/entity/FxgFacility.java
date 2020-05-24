package com.hcl.fxg.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Builder
@ToString
@EqualsAndHashCode
@Table(name = "FXG_FACILITY")
public class FxgFacility {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "REC_ID")
	private long id;
	
	@Column(name = "FACILITY_ID")
	private int facilityId;
	@Column(name = "FACILITY_CODE")
	private String facilityCode;
	@Column(name = "FACILITY_TYPE")
	private int facilityType;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FACILITY_ADDRESS_ID", referencedColumnName = "ADDR_ID")
	private FxgFacilityAddress facilityAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PARENT_HUB_ID", referencedColumnName = "REC_ID")
	private FxgFacility parentHub;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FACILITY_SCHD_ID", referencedColumnName = "SCHD_ID")
	private FxgFacilitySchedule facilitySchedule;
	
}
