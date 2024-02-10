package util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import dto.CourseBoardDTO;

// ���� ���ε�� �ٿ�ε带 �����ϴ� Ŭ����
public class FileManager {

	// ���� ���ε� ��� ����
	String webPath = "/resources/upload/"; // ������Ʈ ���
	String savePath = null; // ���� ��ǻ�� ���
	
	// �����ڿ� request ��ü�� �޾� ���� ���� ���� ���θ� ����
	public FileManager(HttpServletRequest request) {
		savePath = request.getServletContext().getRealPath(webPath); // ���� ��ǻ�� ���
//		System.out.println(savePath); // ��� ���
	}
	
	// �� ������ �߰� �� ���� ���ε�
	public void fileUpload(CourseBoardDTO new_dto, HttpServletRequest request) {

		// ���ε�� ���� Ŭ���� �ν��Ͻ�
		MultipartFile file = new_dto.getFile();
		
		// �⺻ �̸� ����
		String fileName = "no_file";
		
		if(!file.isEmpty()) { // ������ ���ε� �ߴ��� �˻�(������ �ִ� ���)
			fileName = file.getOriginalFilename(); // ���� ���� �̸�
			
			// ������ ���� ����
			File saveFile = new File(savePath, fileName);
			
			if(!saveFile.exists()) { // �ߺ� ���� �˻�
				saveFile.mkdirs(); // ������ ����, ���Ŀ� ���Ϸ� �����
			} else {
				long time = System.currentTimeMillis(); // ���ε� �ð� ���
				fileName = String.format("%d_%s", time, fileName); // ���� �̸��� ���ε� �ð� �����ؼ� ����
				saveFile = new File(savePath, fileName); // �� ���� �̸����� ���� ����
			}
						
			// ���������� ������ ���ε�
			try {
				file.transferTo(saveFile);
			} catch (Exception e) {}

		}
				
		// DB�� ���� ���� �̸� ����
		new_dto.setFile_name(fileName);
		
	}
	
	// ������ ���� �� ���� ���ε�
	public void fileUpload(CourseBoardDTO new_dto, CourseBoardDTO origin_dto, HttpServletRequest request, int flag) {

		// ���� ����� �������� ���� ÷�� �� ���� �̸��� new_dto�� ����
		fileUpload(new_dto, request);
		
		// ���� ����� �������� ���� �̸�
		String fileName = new_dto.getFile_name();
	
		if (fileName != "no_file") { // ���� ����� �����ۿ� ������ ÷�ε� ��쿡��			
			// ������ ���� �� ���� ���� ����
			fileDelete(origin_dto); 
					
			// DB�� ���� ���� �̸��� ���� origin_dto�� ����(���� ������Ʈ)
			origin_dto.setFile_name(fileName);
				
		} else { // ���� ����� �����ۿ� ÷�� ������ ���� ���
			if (flag == 1) { // ÷�� ���� ���� ��û ����
				fileDelete(origin_dto); // ÷�� ���� ����
			} else { // ÷�� ���� ���� ��û�� ����
				return;
			}
		}
	}
	
	// ���� ��ǻ�Ϳ��� ���� ����
	public void fileDelete(CourseBoardDTO dto) {
		// dto�� ����� ���� �̸����� ���� ��ǻ�Ϳ� ����� ���� ���� ��������
		File saveFile = new File(savePath, dto.getFile_name());
		if (saveFile.exists()) { // ���� �������� ÷�� ������ ������ ����Ǿ� �ִ� ���
			saveFile.delete();
		}
		dto.setFile_name("no_file"); // DB�� ÷�������� ������ ǥ��
	}

	
	// ���� �ٿ�ε�
//	public void fileDownload(HttpServletRequest request, HttpServletResponse response) {
//		// ������ ������ ����� ��� ��������
//		String dir = request.getParameter("dir");
//		String fullPath = request.getServletContext().getRealPath(dir);
//		
//		String fileName = "";
//		fileName = request.getParameter("filename");
//		String fullPathName = String.format("%s%s", fullPath, fileName);
//		
//		// ���� ��������
//		File file = new File(fullPathName);
//		byte[] b = new byte[1024*1024*100]; // ���� �ִ� �ѵ���ŭ ����Ʈ �迭 ����
//		
//		// ����� ������ Ÿ�� ������
//		String strAgent = request.getHeader("User-Agent");
//		System.out.println("browser : " + strAgent);
//		
//		String userCharset = request.getCharacterEncoding();
//		if (userCharset == null) {
//			userCharset = "utf-8";
//		}
//
//		String value = "";
//		// IE�� ���
//		// IE ������ ����Ǿ� ���Ŀ� IE �κ��� �ʿ� �������� �𸥴�.
//		if (strAgent.indexOf("MSIE") > -1) {
//			// IE 5.5 �� ���
//			if (strAgent.indexOf("MSIE 5.5") > -1) {
//				value = "filename="+fileName;
//			} else if (strAgent.indexOf("MSIE 7.0") > -1) { // IE 7.0�� ���
//				// ���ڵ� Ÿ�� ��
//				if (userCharset.equalsIgnoreCase("UTF-8")) {
//					fileName = URLEncoder.encode(fileName, userCharset);
//					fileName = fileName.replaceAll("\\+", " ");
//					value = "attachment; filename=\""+fileName+"\"";
//				} else {
//					value = "attachment; filename=" + new String(fileName.getBytes(userCharset), "ISO-8859-1"); 
//				}
//			} else { // IE 8.0 �̻��� ��� �� �� ȣ���
//				// ���ڵ� Ÿ�� ��
//				if (userCharset.equalsIgnoreCase("UTF-8")) {
//					fileName = URLEncoder.encode(fileName, userCharset);
//					fileName = fileName.replaceAll("\\+", " ");
//					value = "attachment; filename=\""+fileName+"\"";
//				} else {
//					value = "attachment; filename" + new String(fileName.getBytes(userCharset), "ISO-8859-1");
//				}
//			} // IE Ȯ�� ����
//		} else if (strAgent.indexOf("Firefox") > -1) { // Firefox�� ���
//			// Firefox�� ���� ���� ���İ� �νĵ��� ����
//			// �ٸ� ��Ÿ �������� �ڵ�� ������..
//			value = "attachment; filename=" + new String(fileName.getBytes(), "ISO-8859-1");
//		} else { // �׿� ������
//			value = "attachment; filename=" + new String(fileName.getBytes(), "ISO-8859-1");
//		}
//		
//		// �������� ĳ������ �ʵ��� ����
//		response.setContentType("Pragma : no-cache");
//		
//		// ���� �����Ͱ� stream ó���ǵ��� ����. �� �� ���� ���ڼ��� 8859_1
//		response.setContentType("application/octect-stream;charset=8859_1;");
//		
//		// ������ ���� ���� ����(attachment : ÷������)
//		response.setHeader("Content-Disposition", value);
//		
//		// ���빰 ���ڵ� ��� ����
//		response.setHeader("Content-Transfer-Encoding", "binary");
//		
//		// ���� �������� - ��Ȯ�ϰԴ� �̹����� �ƴ� ��� ������
//		if (file.isFile()) {
//			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
//			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
//			
//			int i = 0;
//			
//			try {
//				while((i=bis.read(b)) != -1) {
//					bos.write(b, 0, i);
//				}
//			} catch (Exception e) {
//			} finally {
//				if (bos != null) bos.close();
//				if (bis != null) bis.close();
//			}
//		}
//	}
	
}
