package dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class CommunityDTO {
	private int id; // 게시글 id
	private int user_id; // 작성자 id
	private int readhit; // 조회수
	private int likehit; // 추천수
	private int del_flag; // 삭제 여부
	private int ref; // 원본글
	private int step; // 등재 순서
	private int depth; // 댓글
	
	private String title; // 제목
	private String content; // 내용
	private String register_date; // 작성일
	private String ip_addr; // ip주소
	private String file_name; // 이미지 파일 이름
	private String anon_flag; // 익명여부
	private String nickname; // 닉네임
	
	private MultipartFile file; // 실제 파일
***REMOVED***
