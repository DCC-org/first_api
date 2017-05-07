package com.DCC.skarf.api.Grafana.Request.DataObjects.Annotation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "range", value = "range.")
public class GrafanaAnnotationRange {

	@ApiModelProperty(value = "2016-04-15T13:44:39.070Z", required = true, example = "2016-04-15T13:44:39.070Z")
	private String from;

	@ApiModelProperty(value = "2016-04-15T14:44:39.070Z", required = true, example = "2016-04-15T14:44:39.070Z")
	private String to;

	@ApiModelProperty(required = true, name = "rangeRaw")
	private GrafanaAnnotationRangeRaw raw = new GrafanaAnnotationRangeRaw();

	public String getFrom() {
		return this.from;
	}

	public String getTo() {
		return this.to;
	}

	public GrafanaAnnotationRangeRaw getRaw() {
		return this.raw;
	}

	public void setFrom(String s) {
		this.from = s;
	}

	public void setTo(String s) {
		this.to = s;
	}

	public void setRaw(GrafanaAnnotationRangeRaw o) {
		this.raw = o;
	}

}