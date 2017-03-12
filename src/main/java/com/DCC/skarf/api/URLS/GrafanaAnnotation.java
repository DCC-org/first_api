package com.DCC.skarf.api.URLS;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.DCC.skarf.api.Grafana.Request.DataObjects.Annotation.GrafanaAnnotationRequest;
import com.DCC.skarf.api.Grafana.Response.DataObjects.Annotation.GrafanaAnnotationResponse;
import com.DCC.skarf.api.Helper.DataGenerator.GrafanaAnnotationDataGenerator;

import io.swagger.util.Json;

@Controller
@RequestMapping("/annotations")
public class GrafanaAnnotation {
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = "application/json; charset=UTF-8")
	public @ResponseBody List<GrafanaAnnotationResponse> runAnnotations(@RequestBody GrafanaAnnotationRequest jsonString) {
		System.out.println(Json.pretty(jsonString));
		return new GrafanaAnnotationDataGenerator(jsonString.getAnnotation()).getResponseList();
	}

}
