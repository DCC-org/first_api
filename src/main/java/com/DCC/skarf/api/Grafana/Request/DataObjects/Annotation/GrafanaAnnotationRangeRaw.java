package com.DCC.skarf.api.Grafana.Request.DataObjects.Annotation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "rangeRaw",
		value = "rangeRaw.")
public class GrafanaAnnotationRangeRaw {

	@ApiModelProperty(value = "now-1h", required = true, example = "now-1h")
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
