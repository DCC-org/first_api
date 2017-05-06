package com.DCC.skarf.api.Grafana.Request.DataObjects.Query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "targets", value = "targets.")
public class GrafanaQueryTargets {

	@ApiModelProperty(value = "upper_50", required = true, example = "upper_50", position = 1)
	private String target;

	@ApiModelProperty(value = "A", required = true, example = "A", position = 2)
	private String refId;

	@ApiModelProperty(value = "timeserie", required = true, example = "timeserie", position = 3)
	private String type;

	@ApiModelProperty(value = "false", required = true, example = "false", position = 3)
	private boolean hide;

	public void setTarget(String s) {
		this.target = s;
	}

	public void setRefId(String s) {
		this.refId = s;
	}

	public String getTarget() {
		return this.target;
	}

	public String getRefId() {
		return this.refId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isHide() {
		return hide;
	}

	public void setHide(boolean hide) {
		this.hide = hide;
	}

}
