package dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class CourseBoardDTO {
	private int id; // �ڽ� �Խñ� ID
	private int course_id; // �ڽ� ID
	private int del_flag; // ���� ���� ����(����)
	
	private String title; // �ڽ� ������ �̸�
	private String content; // �ڽ� ������ ����
	private String register_date; // ������ ��� ��¥
	private String file_name; // ÷������ �̸�
	
	private MultipartFile file;  // ���� ÷������ -- ���� ��ǻ�Ϳ� �����
}
