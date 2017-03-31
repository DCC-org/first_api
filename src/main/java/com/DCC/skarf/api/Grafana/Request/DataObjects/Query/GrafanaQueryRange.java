package com.DCC.skarf.api.Grafana.Request.DataObjects.Query;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "range",
		value = "range.")
public class GrafanaQueryRange {
	
	@ApiModelProperty(value = "2016-10-31T06:33:44.866Z", required = true, example = "2016-10-31T06:33:44.866Z", position = 1)
	private String from;
	
	@ApiModelProperty(required = false, hidden = true)
	private long fromUnixTimestamp;
	
	@ApiModelProperty(value = "2016-10-31T12:33:44.866Z", required = true, example = "2016-10-31T12:33:44.866Z", position = 2)
	private String to;
	
	@ApiModelProperty(required = false, hidden = true)
	private long toUnixTimestamp;
	
	@ApiModelProperty(required = true, name = "raw", position = 3)
	private GrafanaQueryRangeRaw raw = new GrafanaQueryRangeRaw();
	
	private SimpleDateFormat format = 
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	
	public String getFrom() {
		return this.from;
	}
	
	public String getTo() {
		return this.to;
	}
	
	public GrafanaQueryRangeRaw getRaw() {
		return this.raw;
	}
	
	public void setFrom(String s) {
		this.from = s;
		
		try {
            Date parsed = format.parse(s);
            this.fromUnixTimestamp = parsed.getTime();
        }
        catch(ParseException pe) {
            System.out.println("ERROR: Cannot parse \"" + s + "\"");
        }
        
	}
	
	public void setTo(String s) {
		this.to = s;
		
		try {
            Date parsed = format.parse(s);
            this.toUnixTimestamp = parsed.getTime();
        }
        catch(ParseException pe) {
            System.out.println("ERROR: Cannot parse \"" + s + "\"");
        }
	}
	
	public void setRaw(GrafanaQueryRangeRaw r) {
		this.raw = r;
	}
	
	public long getfromUnixTimestamp() {
		return this.fromUnixTimestamp;
	}
	
	public long gettoUnixTimestamp() {
		return this.toUnixTimestamp;
	}

}
