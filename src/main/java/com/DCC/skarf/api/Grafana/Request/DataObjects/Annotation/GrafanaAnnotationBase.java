package com.DCC.skarf.api.Grafana.Request.DataObjects.Annotation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "annotation",
		value = "annotation.")
public class GrafanaAnnotationBase {
	
	@ApiModelProperty(value = "deploy", required = true, example = "deploy")
	private String name;
	
	@ApiModelProperty(value = "Simple JSON Datasource", required = true, example = "Simple JSON Datasource")
	private String datasource;
	
	@ApiModelProperty(value = "true", required = true, example = "true")
	private boolean enable;
	
	@ApiModelProperty(value = "rgb(96, 255, 209)", required = true, example = "rgb(96, 255, 209)")
	private String iconColor;
	
	@ApiModelProperty(value = "query", required = true, example = "query")
	private String query;
	
	@ApiModelProperty(value = "true", example = "true")
	private boolean showLine;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDatasource() {
		return datasource;
	}

	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	public boolean isShowLine() {
		return showLine;
	}
	
	public void setShowLine(boolean enable) {
		this.showLine = enable;
	}

	public String getIconColor() {
		return iconColor;
	}

	public void setIconColor(String iconColor) {
		this.iconColor = iconColor;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

}
