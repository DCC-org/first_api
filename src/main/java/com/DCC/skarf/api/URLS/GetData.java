package com.DCC.skarf.api.URLS;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.DCC.skarf.api.DataObjects.CpuDataCollection;

@Controller
@RequestMapping("/getCpuData")
public class GetData {
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public @ResponseBody CpuDataCollection getCpuData(@RequestParam(value="count", defaultValue="100", required=false) int anz) {
		return new CpuDataCollection(anz);
	}

}
