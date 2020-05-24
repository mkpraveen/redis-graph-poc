package com.hcl.fxg.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.fxg.model.FxgLane;
import com.hcl.fxg.model.entity.FxgLeg;
import com.hcl.fxg.model.graph.FxgEdge;
import com.hcl.fxg.model.graph.FxgNode;
import com.redislabs.redisgraph.Record;
import com.redislabs.redisgraph.ResultSet;
import com.redislabs.redisgraph.graph_entities.Node;
import com.redislabs.redisgraph.graph_entities.Path;
import com.redislabs.redisgraph.impl.api.RedisGraph;

public class RedisGraphUtil {
	public static final String REDIS_SERVER_HOSTNAME= "127.0.0.1";
	public static final int REDIS_SERVER_PORT = 6379;
	public static final String FXG_NW_GRAPH_NAME = "FXG_NETWORK";

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

		FxgNode originNode = null;
		for(int indx = 0;  indx < fxgLegs.size(); indx++) {
			
			FxgLeg leg = fxgLegs.get(indx);
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, false);
			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
			
			if (indx == 0) {
				originNode = new FxgNode(leg.getOriginFacility());
			}
			
			FxgNode destinationNode = new FxgNode(leg.getDestinationFacility());
			FxgEdge fxgEdgeConnect = new FxgEdge(leg);

			try {
				if (indx == 0) {
					retQuery = retQuery + "(:FxgNode" + mapper.writer().writeValueAsString(originNode) + ")-[:FxgEdge"
							+ mapper.writer().writeValueAsString(fxgEdgeConnect) + "]->(:FxgNode"
							+ mapper.writer().writeValueAsString(destinationNode) + ")";
				} else {
					retQuery = retQuery + "-[:FxgEdge"
							+ mapper.writer().writeValueAsString(fxgEdgeConnect) + "]->(:FxgNode"
							+ mapper.writer().writeValueAsString(destinationNode) + ")";
				}
				originNode = destinationNode;
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		return retQuery;
	}
	
	
	public static List<FxgLane> getLanesBetweenODPair(int origFacilityId, int destFacilityId) {
		List<FxgLane> retList = new ArrayList<>();
        Map<String, Object> params = new HashMap<>();
        params.put("origId", origFacilityId);
        params.put("destId", destFacilityId);
        
        // general context api. Not bound to graph key or connection
        RedisGraph graph = new RedisGraph(RedisGraphUtil.REDIS_SERVER_HOSTNAME,RedisGraphUtil.REDIS_SERVER_PORT);
        
        ResultSet resultSet = graph.query(FXG_NW_GRAPH_NAME, "MATCH p = (:FxgNode {facilityId:$origId})-[:FxgEdge*1..10]->(:FxgNode {facilityId:$destId}) RETURN p", params);
        
        FxgLane fxgLane = new FxgLane();
        fxgLane.setSortPoints(new ArrayList<>());
        
        fxgLane.setOrigFacilityId(origFacilityId);
        fxgLane.setDestFacilityId(destFacilityId);
        
        
        while(resultSet.hasNext()) {
            Record record = resultSet.next();
            Path p = record.getValue("p");

            
            // More path API at Javadoc.
            //System.out.println(p.nodeCount());
            
            p.getNodes().forEach( n -> {
            	System.out.println( "Node : " + new FxgNode(n));
            	System.out.println( "Node : " + n);
            });
            
            p.getEdges().forEach( e -> {
            	FxgEdge fxgEdge = new FxgEdge(e);
            	
            	Node node = p.getNodes().stream().filter( t -> t.getId() == e.getSource()).findFirst().orElse(null);
            	if (null != node) {
            		FxgNode fxgNode = new FxgNode(node);
            		
            		Map<Integer, Integer> sortPoint = new HashMap<>();
            		sortPoint.put(fxgNode.getFacilityId(), fxgEdge.getOriginDowId());
            		fxgLane.getSortPoints().add(sortPoint);
            	}
            });
            
            System.out.println(fxgLane);
            retList.add(fxgLane);
        }
		
		return retList;
	}
	
}
