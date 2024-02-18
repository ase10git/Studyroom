package dto;

import lombok.Data;

@Data
public class UserDTO {
	
	private int del_flag; //회원탈퇴표시
	private int id; //회원번호(시퀀스)
	
	private String email; //이메일
	private String pwd; //비밀번호
	private String username; //이름
	private String tel; //전화번호
	private String role; //유형
	
}
