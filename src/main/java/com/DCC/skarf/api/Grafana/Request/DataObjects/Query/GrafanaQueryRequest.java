package com.DCC.skarf.api.Grafana.Request.DataObjects.Query;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Grafana Query Request",
	description = "Describes the Grafana Query Request Object")
public class GrafanaQueryRequest {

	@ApiModelProperty(value = "1", required = true, example = "1", position = 1)
	private int panelId;
	
	@ApiModelProperty(required = true, name = "range", position = 2)
	private GrafanaQueryRange range = new GrafanaQueryRange(); 
	
	@ApiModelProperty(required = true, name = "rangeRaw", position = 3)
	private GrafanaQueryRangeRaw rangeRaw = new GrafanaQueryRangeRaw();
	
	@ApiModelProperty(value = "30s", required = true, example = "30s", position = 4)
	private String interval;
	
	@ApiModelProperty(value = "30000", required = true, example = "30000", position = 5)
	private int intervalMs;
	
	@ApiModelProperty(required = true, position = 6)
	private List<GrafanaQueryTargets> targets = new ArrayList<GrafanaQueryTargets>();
	
	@ApiModelProperty(value = "json", required = true, example = "json", position = 7)
	private String format;
	
	@ApiModelProperty(value = "550", required = true, example = "550", position = 8)
	private int maxDataPoints;
	
	public void setPanelId (int i) {
		this.panelId = i;
	}
	
	public void setRange(GrafanaQueryRange a) {
		this.range = a;
	}
	
	public void setRangeRaw(GrafanaQueryRangeRaw a) {
		this.rangeRaw = a;
	}
	
	public void setInterval (String s) {
		this.interval = s;
	}
	
	public void setIntervalMs (int i) {
		this.intervalMs = i;
	}
	
	public void setTargets (List<GrafanaQueryTargets> l) {
		this.targets = l;
	}
	
	public void setFormat (String s) {
		this.format = s;
	}
	
	public void setMaxDataPoints (int i) {
		this.maxDataPoints = i;
	}
	
	public int getPanelId () {
		return this.panelId;
	}
	
	public GrafanaQueryRange getRange() {
		return this.range;
	}
	
	public GrafanaQueryRangeRaw getRangeRaw() {
		return this.rangeRaw;
	}
	
	public String getInterval () {
		return this.interval;
	}
	
	public int getIntervalMs () {
		return this.intervalMs;
	}
	
	public List<GrafanaQueryTargets> getTargets () {
		return this.targets;
	}
	
	public String getFormat () {
		return this.format;
	}
	
	public int getMaxDataPoints () {
		return this.maxDataPoints;
	}
}
