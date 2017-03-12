package com.DCC.skarf.api.Helper.DataGenerator;

import java.util.ArrayList;
import java.util.List;

import com.DCC.skarf.api.Grafana.Request.DataObjects.Annotation.GrafanaAnnotationBase;
import com.DCC.skarf.api.Grafana.Response.DataObjects.Annotation.GrafanaAnnotationResponse;

public class GrafanaAnnotationDataGenerator {
	
	private List<GrafanaAnnotationResponse> responseList = new ArrayList<GrafanaAnnotationResponse>();
	
	public GrafanaAnnotationDataGenerator(GrafanaAnnotationBase annotation) {
		GrafanaAnnotationResponse new_response = new GrafanaAnnotationResponse();
		new_response.setAnnotation(annotation);
		
		responseList.add(new_response);
	}
	
	public List<GrafanaAnnotationResponse> getResponseList() {
		return this.responseList;
	}

}
