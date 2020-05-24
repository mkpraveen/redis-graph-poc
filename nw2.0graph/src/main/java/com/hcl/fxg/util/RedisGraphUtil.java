package com.hcl.fxg.util;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.fxg.model.entity.FxgLeg;
import com.hcl.fxg.model.graph.FxgEdge;
import com.hcl.fxg.model.graph.FxgNode;

public class RedisGraphUtil {

    public static String createLegGraphQuery(FxgLeg fxgLeg) {
    	String retQuery = "";
    	
    	FxgNode originNode = new FxgNode(fxgLeg.getOriginFacility());
    	FxgNode destinationNode = new FxgNode(fxgLeg.getDestinationFacility());
    	
    	FxgEdge fxgEdgeConnect = new FxgEdge(fxgLeg);
    	
    	ObjectMapper mapper = new ObjectMapper();
    	mapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, false);
    	mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		try {		
			retQuery = "CREATE (:FxgNode" + mapper.writer().writeValueAsString(originNode) 
					+ ")-[:FxgEdge" + mapper.writer().writeValueAsString(fxgEdgeConnect) + "]->(:FxgNode" 
					+ mapper.writer().writeValueAsString(destinationNode) + ")";
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    	return retQuery;
    }
    
    
	public static String createPathGraphQuery(List<FxgLeg> fxgLegs) {
		String retQuery = "CREATE ";

		fxgLegs.stream().map( leg -> {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, false);
			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
			String gQry = "";
			FxgNode originNode = new FxgNode(leg.getOriginFacility());
			FxgNode destinationNode = new FxgNode(leg.getDestinationFacility());
			FxgEdge fxgEdgeConnect = new FxgEdge(leg);

			try {
				gQry = "(:FxgNode" + mapper.writer().writeValueAsString(originNode) + ")-[:FxgEdge"
						+ mapper.writer().writeValueAsString(fxgEdgeConnect) + "]->(:FxgNode"
						+ mapper.writer().writeValueAsString(destinationNode) + ")";
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return gQry;
		}).collect(Collectors.joining( "->"));
			

		return retQuery;
	}
}
