package com.DCC.skarf.api.URLS;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.DCC.skarf.api.Grafana.Request.DataObjects.Query.GrafanaQueryRequest;
import com.DCC.skarf.api.Grafana.Response.DataObjects.Query.GrafanaQueryResponse;

@Controller
@RequestMapping("/query")
public class GrafanaQuery {
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = "application/json; charset=UTF-8")
	public @ResponseBody GrafanaQueryResponse runQuery(@RequestBody GrafanaQueryRequest jsonString) {
		GrafanaQueryResponse response = new GrafanaQueryResponse();
		List<long[]> datapoints = new ArrayList<long[]>();
		
		datapoints.add(new long[] {(long) 622, System.currentTimeMillis()});
		datapoints.add(new long[] {(long) 365, System.currentTimeMillis()});
		response.setTarget("upper_75");
		response.setDatapoints(datapoints);
		
		
		return response;
	}

}
