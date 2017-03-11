package com.DCC.skarf.api.DataObjects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Anzahl", description = "TODO")
public class Text {
	
	@ApiModelProperty(value = "Content Anz", required = true, example = "10")
	private String anz;
	
	public Text () {
		//Nothing
	}
	
	public Text (String a) {
		this.anz = a;
	}
	
	public String getAnz() {
		return this.anz;
	}
	
	public void setAnz(String a) {
		this.anz = a;
	}

}
