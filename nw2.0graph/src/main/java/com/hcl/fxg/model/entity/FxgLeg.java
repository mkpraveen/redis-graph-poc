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
@ToString
@EqualsAndHashCode
@Builder
@Table(name = "FXG_LEG")
public class FxgLeg {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LEG_ID")
	private long id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORIG_ID", referencedColumnName = "REC_ID")
	private FxgFacility originFacility;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DEST_ID", referencedColumnName = "REC_ID")
	private FxgFacility destinationFacility;
	
	@Column(name = "ORIG_DOW_ID")
	private int originDowId;
	@Column(name = "DEST_DOW_ID")
	private int destinationDowId;
	@Column(name = "DEST_SPLIT_ID")
	private int destinationSplitTypeId;
	
}
