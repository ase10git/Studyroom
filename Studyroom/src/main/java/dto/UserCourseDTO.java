package dto;

import lombok.Data;

@Data
public class UserCourseDTO {
	private int user_id; // 사용자id
	private int id; // 코스id
	private int del_flag; // 삭제여부
	
	private String title; // 코스이름
	private String instructor; // 강사이름
	private String summary; // 코스 설명
	private String start_date; // 시작일
	private String end_date; // 종료일
	
***REMOVED***
