package com.DCC.skarf.api.Helper.DataGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.DCC.skarf.api.Grafana.Request.DataObjects.Query.GrafanaQueryRequest;
import com.DCC.skarf.api.Grafana.Request.DataObjects.Query.GrafanaQueryTargets;
import com.DCC.skarf.api.Grafana.Response.DataObjects.Query.GrafanaQueryResponse;

public class GrafanaQueryDataGenerator {
	
	private List<GrafanaQueryResponse> responseList = new ArrayList<GrafanaQueryResponse>();
	
	public GrafanaQueryDataGenerator() {
		//Nothing
	}
	
	public GrafanaQueryDataGenerator(GrafanaQueryRequest input) {
		
		for (GrafanaQueryTargets target : input.getTargets()) {
			GrafanaQueryResponse oneResponse = new GrafanaQueryResponse();
			//Get target name as requested
			oneResponse.setTarget(target.getTarget());
			
			//Get sample DataPoint amount as requested
			long baseTime = System.currentTimeMillis();
			baseTime = baseTime - (baseTime%1000);
			List<long[]> datapoints = new ArrayList<long[]>();
			for (int i = 1; i <= input.getMaxDataPoints(); i++) {
				datapoints.add(new long[] {(long) ThreadLocalRandom.current().nextInt(0, 301), baseTime});
				baseTime = baseTime - 50000;
			}
			Collections.reverse(datapoints);
			oneResponse.setDatapoints(datapoints);
			
			//Adding the response to ArrayList for output
			this.responseList.add(oneResponse);
		}
				
	}
	
	public List<GrafanaQueryResponse> getResponseList() {
		return this.responseList;
	}

}
