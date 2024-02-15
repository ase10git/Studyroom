package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import dto.CalendarDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CalendarDAO {

	final SqlSession sqlSession;
	
	 public List<CalendarDTO> calendar_list(int userId) {
	        return sqlSession.selectList("c.calendar_list", userId);
	 ***REMOVED***
	 
	 public List<CalendarDTO> getCalYearAndMonth(int userId,int year, int month) {
	        Map<String, Object> params = new HashMap<>();
	        params.put("userId", userId);
	        params.put("year", year);
	        params.put("month", month);
	        return sqlSession.selectList("c.getCalYearAndMonth", params);
	 ***REMOVED***
	 
	 public CalendarDTO getCalendarEvent(int userId, int id) {
		    Map<String, Integer> params = new HashMap<>();
		    params.put("userId", userId);
		    params.put("id", id);
		    return sqlSession.selectOne("c.getcalendarEvent", params);
***REMOVED***
	 
	public void deleteEvent(int id) {
		sqlSession.update("c.calendarEventUpdate",id);
***REMOVED***

	
***REMOVED***
