package com.DCC.skarf.api.URLS;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(method = RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = "application/json; charset=UTF-8")
	public @ResponseBody List<GrafanaQueryResponse> runQuery(@RequestBody GrafanaQueryRequest jsonString, HttpServletRequest request) {
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            System.out.println(key + " = " + value);
        }
		System.out.println(Json.pretty(jsonString));
		return new GrafanaQueryDataGenerator(jsonString).getResponseList();
	}

}
