package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import dto.CommunityDTO;
import dto.CourseBoardDTO;
import lombok.Data;

@Data
// ���� ���ε�� �ٿ�ε带 �����ϴ� Ŭ����
public class FileManager {
	
	// ���� ���ε� ��� ����
//	String webPath = "/resources/upload/"; // ������Ʈ ���
	String savePath = null; // ���� ��ǻ�� ���
	
	// =================================== ���� ���ε� ===========================================
	// �� ������ �߰� �� ���� ���ε�
	public void fileUpload(CourseBoardDTO new_dto) {

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
	
	// �� Ŀ�´�Ƽ�� �߰� �� ���� ���ε�
	public void fileUpload(CommunityDTO new_dto) {

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
	
	
	// =================================== ���� ���� ===========================================
	// ������ ���� �� ���� ���ε�
	public void fileUpload(CourseBoardDTO new_dto, CourseBoardDTO origin_dto, int flag) {

		// ���� ����� �������� ���� ÷�� �� ���� �̸��� new_dto�� ����
		fileUpload(new_dto);
		
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
	
	
	// ������ ���� �� ���� ���ε�
	public void fileUpload(CommunityDTO new_dto, CommunityDTO origin_dto, int flag) {

		// ���� ����� �������� ���� ÷�� �� ���� �̸��� new_dto�� ����
		fileUpload(new_dto);
		
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
		
	// =================================== ���� ���� ===========================================
	// ���� ��ǻ�Ϳ��� �ڽ� ÷�� ���� ����
	public void fileDelete(CourseBoardDTO dto) {
		// dto�� ����� ���� �̸����� ���� ��ǻ�Ϳ� ����� ���� ���� ��������
		File saveFile = new File(savePath, dto.getFile_name());
		if (saveFile.exists()) { // ���� �������� ÷�� ������ ������ ����Ǿ� �ִ� ���
			saveFile.delete();
		}
		dto.setFile_name("no_file"); // DB�� ÷�������� ������ ǥ��
	}

	// ���� ��ǻ�Ϳ��� Ŀ�´�Ƽ ÷�� ���� ����
	public void fileDelete(CommunityDTO dto) {
		// dto�� ����� ���� �̸����� ���� ��ǻ�Ϳ� ����� ���� ���� ��������
		File saveFile = new File(savePath, dto.getFile_name());
		if (saveFile.exists()) { // ���� �������� ÷�� ������ ������ ����Ǿ� �ִ� ���
			saveFile.delete();
		}
		dto.setFile_name("no_file"); // DB�� ÷�������� ������ ǥ��
	}
	
	// =================================== ���� �ٿ�ε� ===========================================
	// �ڽ� ������ ���� �ٿ�ε�
	public void fileDownload(CourseBoardDTO dto, HttpServletRequest request, HttpServletResponse response) {
		
		// dto�� ����� ���� �̸� ��������
		String fileName = dto.getFile_name();
		
		// ÷�� ������ ���� ��쿣 �Լ� ���� ����
		if (fileName.equals("no_file")) {
			return;
		}
		
		String fullPathName = String.format("%s%s", savePath, fileName);
		
		// ���� ��������
		File file = new File(fullPathName);
		byte[] b = new byte[1024*1024*100]; // ���� �ִ� �ѵ���ŭ ����Ʈ �迭 ����
		
		// Charset�� Ȯ���ϰ�, ���ٸ� utf-8�� ����
		String userCharset = request.getCharacterEncoding();
		if (userCharset == null) {
			userCharset = "utf-8";
		}

		// �������� ĳ������ �ʵ��� ����
		response.setContentType("Pragma : no-cache");
		
		// ���� �����Ͱ� stream ó���ǵ��� ����(�� �� ���� ���ڼ��� 8859_1)
		response.setContentType("application/octect-stream;charset=8859_1;");
		
		// ������ ���� ���� ����(attachment : ÷������)
		response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\"");
		
		// ���빰 ���ڵ� ��� ����
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		// ���� ��������
		try {
			if (file.isFile()) { // ���� ���� ���� Ȯ��
				// ���� ����� ��Ʈ�� ����
				//response.getOutputStream()�� �̹� ȣ��Ǿ��ٴ� ������ ������ ���� �ٿ ������ ����
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
				BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());

				int i = 0;
				
				try {
					while((i=bis.read(b)) != -1) { // ������ �о ��� ��Ʈ���� ����
						bos.write(b, 0, i);
					}
				} catch (Exception e) {
				} finally { // ���� ����� ��Ʈ�� ����
					if (bos != null) bos.close();
					if (bis != null) bis.close();
				}
			}
		} catch (Exception e) {}
	}
	
}
