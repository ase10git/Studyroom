package com.study.study;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.CalenderDAO;
import dto.CalendarDTO;
import lombok.RequiredArgsConstructor;
import util.Common;

@Controller

public class CalenderController {
	
	
	@RequestMapping("calender_list")
	public String calendar(Model model){
			System.out.println("호출됨.");
			//현재 날짜를 가져와서 연도와 월을 구함.>3<
			LocalDate today = LocalDate.now();
	        int currentMonth = today.getMonthValue();
	        int currentYear = today.getYear();
	        
	        //해당 월의 모든 날짜를 가져옴.>3<
	        List<Integer> daysInMonth = getDaysInMonth(currentYear, currentMonth);
	        model.addAttribute("daysInMonth", daysInMonth);
	        model.addAttribute("currentMonth", currentMonth);
	        model.addAttribute("currentYear", currentYear);

	        return Common.CALENDER_PATH+"calender_list.jsp";
		}
	
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
	 
	 @RequestMapping("calendar_data")
	 @ResponseBody
	 public Map<String, Object> getCalendarData(@RequestParam("year") int year, @RequestParam("month") int month) {
	     // 해당 월의 모든 날짜를 가져옴.
	     List<Integer> daysInMonth = getDaysInMonth(year, month);
	     
	     // 이전 달의 마지막 날짜를 구함.
	     int prevMonthLastDay;
	     if (month == 1) { // 1월의 이전 달은 12월.
	         prevMonthLastDay = LocalDate.of(year - 1, 12, 1).lengthOfMonth();
	     } else { // 그 외의 달은 month - 1.
	         prevMonthLastDay = LocalDate.of(year, month - 1, 1).lengthOfMonth();
	     }

	     // 반환할 데이터를 Map에 담아보자구!
	     Map<String, Object> data = new HashMap<>();
	     data.put("daysInMonth", daysInMonth);
	     data.put("year", year);
	     data.put("month", month);
	     data.put("prevMonthLastDay", prevMonthLastDay);
	     return data;
	 }
 	    
}
