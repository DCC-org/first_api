package com.DCC.skarf.api.Grafana.Response.DataObjects.Annotation;

import com.DCC.skarf.api.Grafana.Request.DataObjects.Annotation.GrafanaAnnotationBase;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Grafana Annotation Response", description = "Describes the Grafana Annotation Response Object")
public class GrafanaAnnotationResponse {

	@ApiModelProperty(position = 1)
	private GrafanaAnnotationBase annotation = new GrafanaAnnotationBase();

	@ApiModelProperty(position = 2)
	private String title = "Donlad trump is kinda funny";

	@ApiModelProperty(position = 3)
	private long time = System.currentTimeMillis() - 120000;

	@ApiModelProperty(position = 3)
	private String text = "It's me Mario";

	@ApiModelProperty(position = 4)
	private String tags = "tag_mario";

	public GrafanaAnnotationBase getAnnotation() {
		return annotation;
	}

	public void setAnnotation(GrafanaAnnotationBase annotation) {
		this.annotation = annotation;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

}