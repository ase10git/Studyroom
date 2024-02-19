package com.study.study;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.CalendarDAO;
import dao.CourseDAO;
import dto.CalendarDTO;
import dto.UserDTO;
import lombok.RequiredArgsConstructor;
import util.Common;

@Controller

@RequiredArgsConstructor
public class CalendarController {
	
	final CalendarDAO cal_dao;
	
	@Autowired
	CourseDAO cus_dao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("calendar_list")
	public String calendar(Model model){ 
		
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) return "/";
		
        int user_id = user_dto.getId();
       
        List<CalendarDTO> calendarEvent = cal_dao.calendar_list(user_id);
        model.addAttribute("calendarEvent", calendarEvent);
        return Common.CALENDAR_PATH + "calendar_list.jsp";
    ***REMOVED***
	
	@RequestMapping(value = "getEventsByMonth", method = {RequestMethod.GET, RequestMethod.POST***REMOVED***)
	@ResponseBody
	public List<CalendarDTO> getEventsByMonth(@RequestParam("year") int year, @RequestParam("month") int month) {
	    
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		
		int user_id = user_dto.getId();
		
	    List<CalendarDTO> events = cal_dao.getEventsByMonth(user_id, year, month);

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	    for (CalendarDTO event : events) {
	        LocalDateTime dateTime = LocalDateTime.parse(event.getDatetime(), formatter);
	        LocalDate date = dateTime.toLocalDate();
	        event.setDatetime(date.toString());
	    ***REMOVED***

	    return events;
***REMOVED***
	
	@RequestMapping(value = "deleteEvent", method = RequestMethod.POST)
	@ResponseBody
	public String deleteEvent(@RequestParam("id") int id) {
	    
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) return "/";
		
		if (cal_dao == null) {
	        System.out.println("cal_dao is null");
	        return "fail";
	    ***REMOVED*** else {
	        cal_dao.deleteEvent(id);
	        return "success";
	    ***REMOVED***
***REMOVED***
	
	@PostMapping("addEvent")
    @ResponseBody
    public String addEvent(@RequestParam String type, @RequestParam String comment, @RequestParam String datetime, HttpSession session) {
        
		// 사용자 정보를 세션에서 가져옴
		UserDTO user_dto = (UserDTO)session.getAttribute("dto");
		// 비로그인 사용자 차단
		if (user_dto == null) return "/";
		
		if (comment.isEmpty()) {
            return "내용을 입력해 주세요";
        ***REMOVED***

        // HttpSession 객체를 사용하여 현재 로그인한 사용자의 ID를 가져옵니다.
        // 'userId'는 로그인할 때 세션에 저장한 키입니다. 실제 키는 프로젝트의 인증 시스템에 따라 다를 수 있습니다.
        int userId = user_dto.getId();
        
        return cal_dao.insertEvent(type, comment, datetime, userId) ? "" : "";
        
        
    ***REMOVED***
	
	@RequestMapping(value = "editEvent", method = RequestMethod.POST)
	@ResponseBody
	public void editEvent(@RequestParam("id") int id, @RequestParam("type") String type, @RequestParam("comment") String comment) {
	    		
		cal_dao.updateEvent(id, type, comment);
***REMOVED***
	
 	    
***REMOVED***
