package com.DCC.skarf.api.DataObjects.Grafana.Query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "range",
		value = "range.")
public class GrafanaQueryRange {
	
	@ApiModelProperty(value = "2016-10-31T06:33:44.866Z", required = true, example = "2016-10-31T06:33:44.866Z")
	private String from;
	
	@ApiModelProperty(value = "2016-10-31T12:33:44.866Z", required = true, example = "2016-10-31T12:33:44.866Z")
	private String to;
	
	@ApiModelProperty(required = true)
	private GrafanaQueryRangeRaw raw = new GrafanaQueryRangeRaw();
	
	public String getFrom() {
		return this.from;
	}
	
	public String getTo() {
		return this.to;
	}
	
	public GrafanaQueryRangeRaw getGrafanaQueryRangeRaw() {
		return this.raw;
	}
	
	public void setFrom(String s) {
		this.from = s;
	}
	
	public void setTo(String s) {
		this.to = s;
	}
	
	public void setGrafanaQueryRangeRaw(GrafanaQueryRangeRaw r) {
		this.raw = r;
	}

}
