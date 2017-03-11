package com.DCC.skarf.api.DataObjects;

import java.util.ArrayList;


//Outdated
public class CpuDataCollection {
	
	private ArrayList<CpuData> datacollection = new ArrayList<CpuData>();
	
	public CpuDataCollection(int value){
		
		long time = System.currentTimeMillis();
		
		for (int i = 0; i < value; i++)
		{
			this.datacollection.add(new CpuData(time));
			time = time - 60000;
		}
	}
	
	public ArrayList<CpuData> getDataCollection() {
		return datacollection;
	}

}
