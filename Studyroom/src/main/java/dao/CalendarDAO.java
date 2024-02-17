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
	
	// 사용자별 일정 조회
	public List<CalendarDTO> calendar_list(int user_id) {
		return sqlSession.selectList("CalendarMapper.getEventsByUserId", user_id);
	}

	// 사용자의 월별 일정 조회
	public List<CalendarDTO> getEventsByMonth(int user_id, int year, int month) {
		Map<String, Object> params = new HashMap<>();
		params.put("user_id", user_id);
		params.put("year", year);
		params.put("month", month);
		return sqlSession.selectList("CalendarMapper.getEventsByMonth", params);
	}
	
	// 일정을 제거된 것처럼 처리
	public void deleteEvent(int id) {
	    sqlSession.update("CalendarMapper.deleteEvent", id);
	}

	// 일정 물리적 제거
	public void deleteEventPhysical() {
		sqlSession.delete("CalendarMapper.deleteEventPhysical");
	}
	
	// 일정 추가
	public boolean insertEvent(String type, String comment, String datetime, int userId) {
	    Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("userId", userId);
	    paramMap.put("type", type);
	    paramMap.put("comment", comment);
	    paramMap.put("datetime", datetime);
	    paramMap.put("delFlag", 0); // default
	    return sqlSession.insert("CalendarMapper.insertEvent", paramMap) == 1;
	}
	
	// 일정 수정
	public int updateEvent(int id, String type, String comment) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("type", type);
        params.put("comment", comment);

        return sqlSession.update("CalendarMapper.updateEvent", params);
    }
	
	
}
