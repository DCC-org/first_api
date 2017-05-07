package com.DCC.skarf.api.Grafana.Request.DataObjects.Search;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Grafana Search Request", description = "Describes the Grafana Search Request Object")
public class GrafanaSearchRequest {

	@ApiModelProperty(value = "upper_50", required = true, example = "upper_50", position = 1)
	private String target;

	public void setTarget(String s) {
		this.target = s;
	}

	public String getTarget() {
		return this.target;
	}

}
