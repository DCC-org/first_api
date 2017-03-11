package com.DCC.skarf.api.URLS;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.DCC.skarf.api.DataObjects.Text;
import com.DCC.skarf.api.DataObjects.Grafana.Query.GrafanaQueryRequest;

@Controller
@RequestMapping("/query")
public class GrafanaQuery {
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = "application/json; charset=UTF-8")
	public @ResponseBody Text runQuery(@RequestBody GrafanaQueryRequest jsonString) {		
		return new Text(jsonString.getRange().getFrom());
	}

}
