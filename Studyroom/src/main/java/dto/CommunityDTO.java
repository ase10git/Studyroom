package dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class CommunityDTO {
	private int id; // �Խñ� id
	private int user_id; // �ۼ��� id
	private int readhit; // ��ȸ��
	private int likehit; // ��õ��
	private int del_flag; // ���� ����
	private int ref; // ������
	private int step; // ���� ����
	private int depth; // ���
	
	private String title; // ����
	private String content; // ����
	private String register_date; // �ۼ���
	private String ip_addr; // ip�ּ�
	private String file_name; // �̹��� ���� �̸�
	private String anon_flag; // �͸���
	private String nickname; // �г���
	
	private MultipartFile file; // ���� ����
***REMOVED***
