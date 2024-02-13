package dto;

import lombok.Data;

@Data
public class CommunityDTO {
	private int id;
	private int user_id;
	private int readhit;
	private int likehit;
	private int del_flag;
	private int ref;
	private int step;
	private int depth;
	
	private String title;
	private String content;
	private String register_date;
	private String ip_addr;
	private Object image;
	private String anon_flag;
	private String nickname;

***REMOVED***
