package com.DCC.skarf.api.DataObjects.Grafana.Query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "targets",
		value = "targets.")
public class GrafanaQueryTargets {
	
	@ApiModelProperty(value = "upper_50", required = true, example = "upper_50", position = 1)
	private String target;
	
	@ApiModelProperty(value = "A", required = true, example = "A", position = 2)
	private String refId;
	
	public void setTarget (String s) {
		this.target = s;
	}
	
	public void setRefId (String s) {
		this.refId = s;
	}
	
	public String getTarget () {
		return this.target;
	}
	
	public String getRefId () {
		return this.refId;
	}

}
