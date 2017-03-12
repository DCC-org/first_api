package com.DCC.skarf.api.Grafana.Request.DataObjects.Annotation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Grafana Annotation Request",
		description = "Describes the Grafana Annotation Request Object")
public class GrafanaAnnotationRequest {
	
	@ApiModelProperty(required = true, name = "range", position = 1)
	private GrafanaAnnotationRange range = new GrafanaAnnotationRange();
	
	@ApiModelProperty(required = true, name = "rangeRaw", position = 2)
	private GrafanaAnnotationRangeRaw rangeRaw = new GrafanaAnnotationRangeRaw();
	
	@ApiModelProperty(required = true, name = "annotation", position = 3)
	private GrafanaAnnotationBase annotation = new GrafanaAnnotationBase();

	public GrafanaAnnotationRange getRange() {
		return range;
	}

	public void setRange(GrafanaAnnotationRange range) {
		this.range = range;
	}

	public GrafanaAnnotationRangeRaw getRangeRaw() {
		return rangeRaw;
	}

	public void setRangeRaw(GrafanaAnnotationRangeRaw rangeRaw) {
		this.rangeRaw = rangeRaw;
	}

	public GrafanaAnnotationBase getAnnotation() {
		return annotation;
	}

	public void setAnnotation(GrafanaAnnotationBase annotation) {
		this.annotation = annotation;
	}
	
}
