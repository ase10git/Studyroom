package dto;

import lombok.Data;

@Data
public class CalendarDTO {
	private int id; // ���� id
	private int user_id; // ����� id
	private int del_flag; // ���� ����
	
	private String type; // ���� Ÿ��
	private String datetime; // ����
	private String comment; // �޸�
}
