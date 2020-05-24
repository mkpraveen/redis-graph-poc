package com.hcl.fxg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.fxg.service.FxgLegService;
import com.hcl.fxg.util.RedisGraphUtil;
import com.redislabs.redisgraph.impl.api.RedisGraph;

@RestController
public class FxgGraphController {

	@Autowired
	private FxgLegService fxgLegServiceImpl;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/seedGraph")
	public ResponseEntity<String> seedGraph() {
		
        // general context api. Not bound to graph key or connection
        RedisGraph graph = new RedisGraph("127.0.0.1",6379);
        
        final String FXG_NW_GRAPH_NAME = "FXG_NETWORK";
        //graph.deleteGraph(FXG_NW_GRAPH_NAME);
        
        fxgLegServiceImpl.getAllFxgLegs().forEach( leg ->  graph.query(FXG_NW_GRAPH_NAME, RedisGraphUtil.createLegGraphQuery(leg)) );		
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
}
