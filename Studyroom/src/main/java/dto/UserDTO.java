package dto;

import lombok.Data;

@Data
public class UserDTO {
	
	private int del_flag; //ȸ��Ż��ǥ��
	private int id; //ȸ����ȣ(������)
	
	private String email; //�̸���
	private String pwd; //��й�ȣ
	private String username; //�̸�
	private String tel; //��ȭ��ȣ
	private String role; //����
	
}
