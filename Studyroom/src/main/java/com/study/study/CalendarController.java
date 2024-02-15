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
import dto.CalendarDTO;
import lombok.RequiredArgsConstructor;
import util.Common;

@Controller

@RequiredArgsConstructor
public class CalendarController {
	
	final CalendarDAO cal_dao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	
	@RequestMapping("calendar_list")
	public String calendar(Model model){ 
        int user_id = (int) session.getAttribute("userId");
        List<CalendarDTO> calendarEvent = cal_dao.calendar_list(user_id);
        model.addAttribute("calendarEvent", calendarEvent);
        return Common.CALENDAR_PATH + "calendar_list.jsp";
    }
	
	@RequestMapping(value = "getEventsByMonth", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<CalendarDTO> getEventsByMonth(@RequestParam("year") int year, @RequestParam("month") int month) {
	    int user_id = (int) session.getAttribute("userId");
	    List<CalendarDTO> events = cal_dao.getEventsByMonth(user_id, year, month);

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	    for (CalendarDTO event : events) {
	        LocalDateTime dateTime = LocalDateTime.parse(event.getDatetime(), formatter);
	        LocalDate date = dateTime.toLocalDate();
	        event.setDatetime(date.toString());
	    }

	    return events;
	}
	
	@RequestMapping(value = "deleteEvent", method = RequestMethod.POST)
	@ResponseBody
	public String deleteEvent(@RequestParam("id") int id) {
	    if (cal_dao == null) {
	        System.out.println("cal_dao is null");
	        return "fail";
	    } else {
	        cal_dao.deleteEvent(id);
	        return "success";
	    }
	}
	
	@PostMapping("addEvent")
    @ResponseBody
    public String addEvent(@RequestParam String type, @RequestParam String comment, @RequestParam String datetime, HttpSession session) {
        if (comment.isEmpty()) {
            return "내용을 입력해 주세요";
        }

        
        int userId = (int) session.getAttribute("userId");
        
        return cal_dao.insertEvent(type, comment, datetime, userId) ? "" : "";
        
        
    }
	
	@RequestMapping(value = "editEvent", method = RequestMethod.POST)
	@ResponseBody
	public void editEvent(@RequestParam("id") int id, @RequestParam("type") String type, @RequestParam("comment") String comment) {
	    cal_dao.updateEvent(id, type, comment);
	}
	
	
 	    
}
