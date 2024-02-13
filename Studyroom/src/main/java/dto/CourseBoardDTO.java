package dto;

import lombok.Data;

@Data
public class CourseBoardDTO {
	private int id;
	private int course_id;
	private int del_flag;
	private int ref;
	private int step;
	
	private String title;
	private String content;
	private String register_date;
	private String file_name;
}
