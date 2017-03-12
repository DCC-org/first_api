package com.DCC.skarf.api.Grafana.Response.DataObjects.Search;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Grafana Search Response",
description = "Describes the Grafana Search Response Object")
public class GrafanaSearchResponse {
	
	@ApiModelProperty(required = true, position = 1)
	private String[] targets = new String[] {"upper_25","upper_50","upper_75","upper_90","upper_95"}; //Sample for test
	
	public GrafanaSearchResponse() {
		//Nothing
	}
	
	public String[] getDatapoints () {
		return targets;
	}

}
