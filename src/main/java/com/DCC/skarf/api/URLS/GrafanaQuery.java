package com.DCC.skarf.api.URLS;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.DCC.skarf.api.Grafana.Request.DataObjects.Query.GrafanaQueryRequest;
import com.DCC.skarf.api.Grafana.Response.DataObjects.Query.GrafanaQueryResponse;
import com.DCC.skarf.api.Helper.DataGenerator.GrafanaQueryDataGenerator;

import io.swagger.util.Json;

@Controller
@RequestMapping("/query")
public class GrafanaQuery {
	
	public int get_org_id(String url) {
		if (url.contains("?"))
		{
		    url = url.substring(url.indexOf("?") + 1);
			String[] pairs = url.split("&");
		    for (String pair : pairs) {
		        int idx = pair.indexOf("=");
		        String value = pair.substring(pair.indexOf("=") + 1);
		        String name = pair.substring(0, idx);
		        if (name.equals("orgId"))
		        	return Integer.parseInt(value);
;
		    }
		}
	    return -1;
	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = "application/json; charset=UTF-8")
	public @ResponseBody List<GrafanaQueryResponse> runQuery(@RequestBody GrafanaQueryRequest jsonString, @RequestHeader(value="referer") String org_id) throws Exception {
        int iorg_id = this.get_org_id(org_id);
		System.out.println("OrgId" + iorg_id);
		System.out.println(Json.pretty(jsonString));
		if (iorg_id == -1)
		{
			throw new Exception("Keine orgID angegeben");
		}
		return new GrafanaQueryDataGenerator(jsonString, iorg_id).getResponseList();
	}

}
