package dto;

import lombok.Data;

@Data
public class UserDTO {
	private int id;
	private int del_flag;
	
	private String username;
	private String email;
	private String tel;
	private String pwd;
	private String role;
}
