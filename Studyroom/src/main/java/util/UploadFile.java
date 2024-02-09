package util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import dto.CourseBoardDTO;

// ���� ���ε� ��� ������ ���� ���ε带 ����ϴ� Ŭ����
public class UploadFile {
	
	public void fileUpload(CourseBoardDTO dto, HttpServletRequest request) {
		
		// ���� ���ε� ��� ����
		String webPath = "/resources/upload/"; // ������Ʈ ���
		String savePath = request.getServletContext().getRealPath(webPath); // ���� ��ǻ�� ���
		System.out.println(savePath); // ��� ���

		// ���ε�� ���� Ŭ���� �ν��Ͻ�
		MultipartFile file = dto.getFile();
		
		System.out.println("���� �˻� : " + file.isEmpty());
		
		// �⺻ �̸� ����
		String fileName = "no_file";
				
		if(!file.isEmpty()) { // ������ ���ε� �ߴ��� �˻�(������ �ִ� ���)
			fileName = file.getOriginalFilename(); // ���� ���� �̸�
			
			// ������ ���� ����
			File saveFile = new File(savePath, fileName);
			
			if(!saveFile.exists()) { // �ߺ� ���� �˻�
				saveFile.mkdirs(); // ������ ����, ���Ŀ� ���Ϸ� �����
		***REMOVED*** else {
				long time = System.currentTimeMillis(); // ���ε� �ð� ���
				fileName = String.format("%d_%s", time, fileName); // ���� �̸��� ���ε� �ð� �����ؼ� ����
				saveFile = new File(savePath, fileName); // �� ���� �̸����� ���� ����
		***REMOVED***
			
			// ���������� ������ ���ε�
			try {
				file.transferTo(saveFile);
		***REMOVED*** catch (Exception e) {
		***REMOVED***
	***REMOVED*** 
		
		// DB�� ���� ���� �̸��� CourseBoardDTO dto�� ����
		dto.setFile_name(fileName);
		
***REMOVED***
	
***REMOVED***
