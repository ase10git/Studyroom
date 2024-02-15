package dto;

import lombok.Data;

@Data
public class CustomerServiceDTO {
	private int id; // ���ǻ��� id
	private int user_id; // ����� id
	private int del_flag; // ���� ����
	private int ref; // ������
	private int step; // ���� ����
	
	private String title; // ����
	private String content; // ����
	private String register_date; // �ۼ���
	private String ip_addr; // ip�ּ�
	private String progress_flag; // ���൵
}
