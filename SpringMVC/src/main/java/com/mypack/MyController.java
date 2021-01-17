package com.mypack;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cont")
public class MyController {

	@Autowired
	MyDao dao;

	@RequestMapping(value = "/reg", method = RequestMethod.GET)
	public String sayHello(@ModelAttribute("reg") Registration reg) {
		return "registration";
	}
	

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("reg") Registration reg) {
		String response = "";
		String result = "";
		try {
			result = dao.saveUser(reg);
		} catch (Exception e) {
			response = "error occured";
			e.printStackTrace();
		}
		if (result.equalsIgnoreCase("success")) {
			response = "welcome";
		} else {
			response = "error";
		}
		return response;
	}

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public String listUser(ModelMap modelMap) {

		List<Registration> listUser = null;
		try {
			listUser = dao.getAllUsers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		modelMap.put("listUser", listUser);
		return "data";
	}
}
