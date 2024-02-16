package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.CalendarDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CalenderDAO {

	final SqlSession sqlSession;
	
	public List<CalendarDTO> calender_list(int user_id){
		return sqlSession.selectList("c.calender_list",user_id);
	}
	
	
}
