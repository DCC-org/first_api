package com.DCC.skarf.api.DataObjects.Grafana.Query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "raw",
		value = "raw.")
public class GrafanaQueryRangeRaw {
	
	@ApiModelProperty(value = "now-6h", required = true, example = "now-6h")
	private String from;
	
	@ApiModelProperty(value = "now", required = true, example = "now")
	private String to;
	
	public String getFrom() {
		return this.from;
	}
	
	public String getTo() {
		return this.to;
	}
	
	public void setFrom(String s) {
		this.from = s;
	}
	
	public void setTo(String s) {
		this.to = s;
	}

}
