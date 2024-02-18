package dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class CourseBoardDTO {
	private int id; // 코스 게시글 ID
	private int course_id; // 코스 ID
	private int del_flag; // 논리적 삭제 여부(어드민)
	
	private String title; // 코스 공지글 이름
	private String content; // 코스 공지글 내용
	private String register_date; // 공지글 등록 날짜
	private String file_name; // 첨부파일 이름
	
	private MultipartFile file;  // 실제 첨부파일 -- 서버 컴퓨터에 저장됨
}
