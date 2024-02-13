package com.study.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Common;

@Controller
public class TestController{

	@RequestMapping("/login")
	public String mainTest() {
		return Common.VIEW_PATH + "login/login.jsp";
***REMOVED***
	
***REMOVED***
