package dto;

import lombok.Data;

@Data
public class UserCourseViewDTO {
	private int user_id; // �����id
	private int id; // �ڽ�id
	private int del_flag; // ��������
	
	private String title; // �ڽ��̸�
	private String instructor; // �����̸�
	private String summary; // �ڽ� ����
	private String start_date; // ������
	private String end_date; // ������
	
***REMOVED***
