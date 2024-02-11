package dto;

import lombok.Data;

@Data
public class AnnouncementDTO {
	private int id; //공지사항 번호
	private int course_id; //강의번호
	private int title; //제목
	private int del_flag; //삭제(어드민)
	
	private String content; //내용
	private String register_date; //등록일?

	//조회수, 작성자, 카테고리 필요
	private int readhit;
***REMOVED***
