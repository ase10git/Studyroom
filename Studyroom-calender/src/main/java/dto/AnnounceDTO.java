package dto;

import lombok.Data;

@Data
public class AnnounceDTO {
	private int id;
	private int course_id;
	private int title;
	private int del_flag;
	
	private String content;
	private String register_date;
}
