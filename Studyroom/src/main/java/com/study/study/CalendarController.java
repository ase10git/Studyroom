package com.study.study;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	//�̰� �ӽ÷� �������̵� ���ǿ� �����ϴ°̴ϴ�.
	@RequestMapping("userform")
	public String userform(HttpSession session) { //�̺κи� userid �������� �ҷ��ͼ� ������ �ɰŰ��ƿ�.
		session.setAttribute("userId", 3);
		return Common.CALENDAR_PATH+"userForm.jsp";
	}
	
	
	//�ش� ������ Ķ���� �����͸� �������� Ķ���� �������� �̵��ϴ� ��Ʈ�ѷ� �޼���
	@RequestMapping("calendar_list") //**************** ������ - ���ǰ� Ķ���� ���� **********************
	public String calendar(Model model){ //, @RequestParam("userId") int user_id
			int user_id = (int)session.getAttribute("userId");
			//************************************************************************************
			List<CalendarDTO> dto = cal_dao.calendar_list(user_id);
			model.addAttribute("dto",dto);
			//���� ��¥�� �����ͼ� ������ ���� ����.>3<
			LocalDate today = LocalDate.now();
	        int currentMonth = today.getMonthValue();
	        int currentYear = today.getYear();
	        
	        //�ش� ���� ��� ��¥�� ������.>3<
	        List<Integer> daysInMonth = getDaysInMonth(currentYear, currentMonth);
	        model.addAttribute("daysInMonth", daysInMonth);
	        model.addAttribute("currentMonth", currentMonth);
	        model.addAttribute("currentYear", currentYear);

	        return Common.CALENDAR_PATH+"calendar_list.jsp";
		}
	
	
	// Ư�� ������ ���� ���� ��� ��¥�� �������� �޼���
	 private List<Integer> getDaysInMonth(int year, int month) {
		 	//�ش� ���� ��� ��¥�� ������ ����Ʈ ���� >.<
	        List<Integer> daysInMonth = new ArrayList<>();
	        
	        //�ش� ���� �� ��¥ ���� ���� ><
	        int days = LocalDate.of(year, month, 1).lengthOfMonth();
	        
	        //�ش� ���� ù ���� ������ ���ϱ� ����><
	        int firstDay = LocalDate.of(year, month,1).getDayOfWeek().getValue();
	        //�� ���� ������ �Ͽ��Ϸ� �����ϱ� ���� �� ���� ><
	        int calendarDayOfWeek = firstDay == 7 ? 1 : firstDay + 1;
	        //ù���� ���� ������ null�� ä��� ><
	        for(int i = 1; i< calendarDayOfWeek; i++) {
	        	daysInMonth.add(null);
	        }
	        
	        //�ش� ���� ��� ��¥�� ����Ʈ�� �߰��ϱ�><
	        for (int i = 1; i <= days; i++) {
	            daysInMonth.add(i);
	        }
	        return daysInMonth;
	 	}
	 
	// Ư�� ������ ���� ���� Ķ���� �����͸� �������� ��Ʈ�ѷ� �޼���
	 @RequestMapping("calendar_data")
	 @ResponseBody
	 public Map<String, Object> getCalendarData(@RequestParam("year") int year, @RequestParam("month") int month, HttpSession session) {
	     // �ش� ���� ��� ��¥�� ������.
	     List<Integer> daysInMonth = getDaysInMonth(year, month);
	     int userId = (int) session.getAttribute("userId");
	     // ���� ���� ������ ��¥�� ����.
	     int prevMonthLastDay;
	     if (month == 1) { // 1���� ���� ���� 12��.
	         prevMonthLastDay = LocalDate.of(year - 1, 12, 1).lengthOfMonth();
	     } else { // �� ���� ���� month - 1.
	         prevMonthLastDay = LocalDate.of(year, month - 1, 1).lengthOfMonth();
	     }
	    List<CalendarDTO> calList = cal_dao.getCalYearAndMonth(userId,year, month);
	    System.out.println(calList);
	    
	     // ��ȯ�� �����͸� Map�� ��ƺ��ڱ�!
	     Map<String, Object> data = new HashMap<>();
	     data.put("daysInMonth", daysInMonth);
	     data.put("year", year);
	     data.put("month", month);
	     data.put("prevMonthLastDay", prevMonthLastDay);
	     data.put("calList", calList);
	     return data;
	 }
	 
	// Ư�� �̺�Ʈ�� ���� �� ������ �������� ��Ʈ�ѷ� �޼���
	 @RequestMapping("calendar_view")
	 public String calendarView(Model model, @RequestParam("id") int id, HttpSession session) {
	     int userId = (int) session.getAttribute("userId");
	     CalendarDTO calendarEvent = cal_dao.getCalendarEvent(userId, id);
	     model.addAttribute("calendarEvent", calendarEvent);
	     return Common.CALENDAR_PATH + "calendar_view.jsp";
	 }
	 
	 //�̰� ������ �ʿ��ؿ�. // ������ : CourseController�� CourseBoardController ����
	 @RequestMapping(value = "calendar_del", method = RequestMethod.POST)
	 public String calendar_delete(@RequestParam("id") int id) {
		 cal_dao.deleteEvent(id);
		 return "redirect:calendar_list";
	 }
 	    
}
