package com.DCC.skarf.api.DataObjects;

import java.text.SimpleDateFormat;

//Outdated
public class CpuData {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
	
	private final String host;
	private final String timestamp;
	private final String plugin;
	private final String type_instance;
	private final float value;
	public long time;
	
	public CpuData(long time)
	{
		this.host = "nikolai-test";
		this.timestamp = sdf.format(time).toString();
		this.plugin = "cpu";
		this.type_instance = "collected_type";
		this.value =  (float) ((Math.random()) * 5 + 1);
		this.time = time;
	}
	
	public String getHost() {
		return host;
	}
	
	public String getTimestamp() {
		return timestamp;
	}

	public String getPlugin() {
		return plugin;
	}
	
	public String getTypeInstance() {
		return type_instance;
	}
	
	public float getValue() {
		return value;	
	}
}
