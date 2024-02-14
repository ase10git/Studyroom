package dto;

import lombok.Data;

@Data
public class CustomerServiceDTO {
	private int id; // 문의사항 id
	private int user_id; // 사용자 id
	private int del_flag; // 삭제 여부
	private int ref; // 원본글
	private int step; // 등재 순서
	
	private String title; // 제목
	private String content; // 내용
	private String register_date; // 작성일
	private String ip_addr; // ip주소
	private String progress_flag; // 진행도
}
