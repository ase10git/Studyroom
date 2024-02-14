package dto;

import lombok.Data;

@Data
public class CalendarDTO {
	private int id; // 일정 id
	private int user_id; // 사용자 id
	private int del_flag; // 삭제 여부
	
	private String type; // 일정 타입
	private String datetime; // 일정
	private String comment; // 메모
}
