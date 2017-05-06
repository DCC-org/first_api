package com.DCC.skarf.api.URLS;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.DCC.skarf.api.Grafana.Request.DataObjects.Search.GrafanaSearchRequest;
import com.DCC.skarf.api.Grafana.Response.DataObjects.Search.GrafanaSearchResponse;

import io.swagger.util.Json;

@Controller
@RequestMapping("/search")
public class GrafanaSearch {

	@RequestMapping(method = RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = "application/json; charset=UTF-8")
	public @ResponseBody String[] runSearch(@RequestBody GrafanaSearchRequest jsonString) {
		System.out.println(Json.pretty(jsonString));
		return new GrafanaSearchResponse().getDatapoints();
	}

}
