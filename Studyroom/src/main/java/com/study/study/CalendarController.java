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
	
	//이건 임시로 유저아이디를 세션에 저장하는겁니당.
	@RequestMapping("userform")
	public String userform(HttpSession session) { //이부분만 userid 세션정보 불러와서 받으면 될거같아요.
		session.setAttribute("userId", 3);
		return Common.CALENDAR_PATH+"userForm.jsp";
	}
	
	
	//해당 유저의 캘린더 데이터를 가져오고 캘린더 페이지로 이동하는 컨트롤러 메서드
	@RequestMapping("calendar_list") //**************** 편집자 - 세션과 캘린더 연결 **********************
	public String calendar(Model model){ //, @RequestParam("userId") int user_id
			int user_id = (int)session.getAttribute("userId");
			//************************************************************************************
			List<CalendarDTO> dto = cal_dao.calendar_list(user_id);
			model.addAttribute("dto",dto);
			//현재 날짜를 가져와서 연도와 월을 구함.>3<
			LocalDate today = LocalDate.now();
	        int currentMonth = today.getMonthValue();
	        int currentYear = today.getYear();
	        
	        //해당 월의 모든 날짜를 가져옴.>3<
	        List<Integer> daysInMonth = getDaysInMonth(currentYear, currentMonth);
	        model.addAttribute("daysInMonth", daysInMonth);
	        model.addAttribute("currentMonth", currentMonth);
	        model.addAttribute("currentYear", currentYear);

	        return Common.CALENDAR_PATH+"calendar_list.jsp";
		}
	
	
	// 특정 연도와 월에 대한 모든 날짜를 가져오는 메서드
	 private List<Integer> getDaysInMonth(int year, int month) {
		 	//해당 월의 모든 날짜를 저장할 리스트 생성 >.<
	        List<Integer> daysInMonth = new ArrayList<>();
	        
	        //해당 월의 총 날짜 수를 구함 ><
	        int days = LocalDate.of(year, month, 1).lengthOfMonth();
	        
	        //해당 월의 첫 날의 요일을 구하깅 아잉><
	        int firstDay = LocalDate.of(year, month,1).getDayOfWeek().getValue();
	        //한 주의 시작을 일요일로 설정하기 위해 값 조정 ><
	        int calendarDayOfWeek = firstDay == 7 ? 1 : firstDay + 1;
	        //첫주의 시작 요일은 null로 채우깅 ><
	        for(int i = 1; i< calendarDayOfWeek; i++) {
	        	daysInMonth.add(null);
	        }
	        
	        //해당 월에 모든 날짜를 리스트에 추가하깅><
	        for (int i = 1; i <= days; i++) {
	            daysInMonth.add(i);
	        }
	        return daysInMonth;
	 	}
	 
	// 특정 연도와 월에 대한 캘린더 데이터를 가져오는 컨트롤러 메서드
	 @RequestMapping("calendar_data")
	 @ResponseBody
	 public Map<String, Object> getCalendarData(@RequestParam("year") int year, @RequestParam("month") int month, HttpSession session) {
	     // 해당 월의 모든 날짜를 가져옴.
	     List<Integer> daysInMonth = getDaysInMonth(year, month);
	     int userId = (int) session.getAttribute("userId");
	     // 이전 달의 마지막 날짜를 구함.
	     int prevMonthLastDay;
	     if (month == 1) { // 1월의 이전 달은 12월.
	         prevMonthLastDay = LocalDate.of(year - 1, 12, 1).lengthOfMonth();
	     } else { // 그 외의 달은 month - 1.
	         prevMonthLastDay = LocalDate.of(year, month - 1, 1).lengthOfMonth();
	     }
	    List<CalendarDTO> calList = cal_dao.getCalYearAndMonth(userId,year, month);
	    System.out.println(calList);
	    
	     // 반환할 데이터를 Map에 담아보자구!
	     Map<String, Object> data = new HashMap<>();
	     data.put("daysInMonth", daysInMonth);
	     data.put("year", year);
	     data.put("month", month);
	     data.put("prevMonthLastDay", prevMonthLastDay);
	     data.put("calList", calList);
	     return data;
	 }
	 
	// 특정 이벤트에 대한 상세 정보를 가져오는 컨트롤러 메서드
	 @RequestMapping("calendar_view")
	 public String calendarView(Model model, @RequestParam("id") int id, HttpSession session) {
	     int userId = (int) session.getAttribute("userId");
	     CalendarDTO calendarEvent = cal_dao.getCalendarEvent(userId, id);
	     model.addAttribute("calendarEvent", calendarEvent);
	     return Common.CALENDAR_PATH + "calendar_view.jsp";
	 }
	 
	 //이건 수정이 필요해요. // 편집자 : CourseController나 CourseBoardController 참고
	 @RequestMapping(value = "calendar_del", method = RequestMethod.POST)
	 public String calendar_delete(@RequestParam("id") int id) {
		 cal_dao.deleteEvent(id);
		 return "redirect:calendar_list";
	 }
 	    
}
