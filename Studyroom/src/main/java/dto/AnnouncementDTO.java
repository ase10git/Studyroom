package dto;

import lombok.Data;

@Data
public class AnnouncementDTO {
	private int id; //�������� ��ȣ
	private int course_id; //���ǹ�ȣ
	private int title; //����
	private int del_flag; //����(����)
	
	private String content; //����
	private String register_date; //�����?

	//��ȸ��, �ۼ���, ī�װ� �ʿ�
	private int readhit;
***REMOVED***
