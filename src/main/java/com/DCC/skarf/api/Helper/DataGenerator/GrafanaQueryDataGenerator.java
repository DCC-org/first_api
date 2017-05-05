package com.DCC.skarf.api.Helper.DataGenerator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.DCC.skarf.api.Grafana.Request.DataObjects.Query.GrafanaQueryRequest;
import com.DCC.skarf.api.Grafana.Request.DataObjects.Query.GrafanaQueryTargets;
import com.DCC.skarf.api.Grafana.Response.DataObjects.Query.GrafanaQueryResponse;
import com.DCC.skarf.api.Helper.JDBC.PostgresConnection;

public class GrafanaQueryDataGenerator {
	
	private List<GrafanaQueryResponse> responseList = new ArrayList<GrafanaQueryResponse>();
	private PostgresConnection db_connection = new PostgresConnection();
	private DecimalFormat df = new DecimalFormat("#.####");
	
	public GrafanaQueryDataGenerator() {
		//Nothing
	}
	
	public GrafanaQueryDataGenerator(GrafanaQueryRequest input) {
		
		for (GrafanaQueryTargets target : input.getTargets()) {
			String[] select_options = target.getTarget().split("_");
			List<String[]> output = this.db_connection.get_grafana_query_element(select_options[0], select_options[1]);
			List<List<String[]>> data_values = new ArrayList<List<String[]>>();
			
			int list_i = 0;
			for (int i = 0; i < output.size(); i++)
			{
				String[] s_array = output.get(i);
				//cpu_idle_2_percent | timestamp | value
				String values = select_options[0] + "_" + select_options[1] + "_" + s_array[2] + "_" + s_array[3];
				
				if (i == 0)
				{
					List<String[]> tmp_list = new ArrayList<String[]>();
					tmp_list.add(new String[]{values, s_array[0] + "000", df.format(Double.parseDouble(s_array[1])).toString().replace(',', '.')});
					data_values.add(tmp_list);
				} else {
					String[] s_array_davor = output.get((i-1));
					
					if (s_array[2].equals(s_array_davor[2]) &&
						s_array[3].equals(s_array_davor[3]))
					{
						List<String[]> tmp_list = data_values.get(list_i);
						tmp_list.add(new String[]{values, s_array[0] + "000", df.format(Double.parseDouble(s_array[1])).toString().replace(',', '.')});
						data_values.set(list_i, tmp_list);
					} else {
						List<String[]> tmp_list = new ArrayList<String[]>();
						tmp_list.add(new String[]{values, s_array[0] + "000", df.format(Double.parseDouble(s_array[1])).toString().replace(',', '.')});
						data_values.add(tmp_list);
						list_i++;
					}
					
				}
				
			}
			output = null;
			
			for (List<String[]> data : data_values)
			{
				GrafanaQueryResponse oneResponse = new GrafanaQueryResponse();
				//Get target name as requested
				String[] tmp = data.get(0);
				oneResponse.setTarget(tmp[0]);
				
				List<long[]> datapoints = new ArrayList<long[]>();
				for (String[] a_data : data)
				{
					datapoints.add(new long[] {(long) Double.parseDouble(a_data[2]), Long.parseLong(a_data[1])});
				}
				oneResponse.setDatapoints(datapoints);
				
				this.responseList.add(oneResponse);
			}
		}
				
	}
	
	public List<GrafanaQueryResponse> getResponseList() {
		return this.responseList;
	}

}
