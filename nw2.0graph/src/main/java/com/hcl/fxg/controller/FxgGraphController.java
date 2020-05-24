package com.hcl.fxg.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.fxg.model.FxgLane;
import com.hcl.fxg.util.RedisGraphUtil;

@RestController
public class FxgGraphController {


	@GetMapping(value = "/getLanes")
	public ResponseEntity<Object> getLanes(@RequestParam(value = "origFacilityId") String origFacilityId, @RequestParam(value = "destFacilityId") String destFacilityId) {
		List<FxgLane> fxgLanes =  RedisGraphUtil.getLanesBetweenODPair(Integer.parseInt(origFacilityId), Integer.parseInt(destFacilityId));
		return ResponseEntity.status(HttpStatus.OK).body(fxgLanes);
		
	}
}
