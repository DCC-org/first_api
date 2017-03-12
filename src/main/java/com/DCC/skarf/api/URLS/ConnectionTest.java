package com.DCC.skarf.api.URLS;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.DCC.skarf.api.DataObjects.ApiResponse;

@Controller
@RequestMapping("/")
public class ConnectionTest {

	@RequestMapping(method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public @ResponseBody ApiResponse testConnection() {
		return new ApiResponse(4, "Don't follow dreams, hunt goals");
	}

	
}
