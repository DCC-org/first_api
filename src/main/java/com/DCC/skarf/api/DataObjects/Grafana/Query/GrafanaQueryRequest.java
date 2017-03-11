package com.DCC.skarf.api.DataObjects.Grafana.Query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Grafana Query Request",
	description = "Describes the Grafana Query Request Object")
public class GrafanaQueryRequest {

	@ApiModelProperty(value = "1", required = true, example = "1")
	private int panelId;
	
	@ApiModelProperty(required = true)
	private GrafanaQueryRange range = new GrafanaQueryRange(); 
	
	public void setRange(GrafanaQueryRange a) {
		this.range = a;
	}
	
	public void setPanelId (int i) {
		this.panelId = i;
	}
	
	public GrafanaQueryRange getRange() {
		return this.range;
	}
	
	public int getPanelId () {
		return this.panelId;
	}
	
}
