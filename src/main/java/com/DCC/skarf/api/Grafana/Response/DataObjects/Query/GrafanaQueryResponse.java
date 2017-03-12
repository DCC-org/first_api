package com.DCC.skarf.api.Grafana.Response.DataObjects.Query;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Grafana Query Response",
	description = "Describes the Grafana Query Response Object")
public class GrafanaQueryResponse {
	
	@ApiModelProperty(value = "upper_75", required = true, example = "upper_75", position = 1)
	private String target;
	
	@ApiModelProperty(required = true, position = 2)
	private List<long[]> datapoints = new ArrayList<long[]>(); 
	
	public void setTarget (String s) {
		this.target = s;
	}
	
	public void setDatapoints (List<long[]> l) {
		this.datapoints = l;
	}
	
	public String getTarget () {
		return target;
	}
	
	public List<long[]> getDatapoints () {
		return datapoints;
	}

}
