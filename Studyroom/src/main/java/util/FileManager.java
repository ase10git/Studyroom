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
***REMOVED***
	
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
		***REMOVED*** else {
				long time = System.currentTimeMillis(); // ���ε� �ð� ���
				fileName = String.format("%d_%s", time, fileName); // ���� �̸��� ���ε� �ð� �����ؼ� ����
				saveFile = new File(savePath, fileName); // �� ���� �̸����� ���� ����
		***REMOVED***
						
			// ���������� ������ ���ε�
			try {
				file.transferTo(saveFile);
		***REMOVED*** catch (Exception e) {***REMOVED***

	***REMOVED***
				
		// DB�� ���� ���� �̸� ����
		new_dto.setFile_name(fileName);
		
***REMOVED***
	
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
				
	***REMOVED*** else { // ���� ����� �����ۿ� ÷�� ������ ���� ���
			if (flag == 1) { // ÷�� ���� ���� ��û ����
				fileDelete(origin_dto); // ÷�� ���� ����
		***REMOVED*** else { // ÷�� ���� ���� ��û�� ����
				return;
		***REMOVED***
	***REMOVED***
***REMOVED***
	
	// ���� ��ǻ�Ϳ��� ���� ����
	public void fileDelete(CourseBoardDTO dto) {
		// dto�� ����� ���� �̸����� ���� ��ǻ�Ϳ� ����� ���� ���� ��������
		File saveFile = new File(savePath, dto.getFile_name());
		if (saveFile.exists()) { // ���� �������� ÷�� ������ ������ ����Ǿ� �ִ� ���
			saveFile.delete();
	***REMOVED***
		dto.setFile_name("no_file"); // DB�� ÷�������� ������ ǥ��
***REMOVED***

	
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
//	***REMOVED***
//
//		String value = "";
//		// IE�� ���
//		// IE ������ ����Ǿ� ���Ŀ� IE �κ��� �ʿ� �������� �𸥴�.
//		if (strAgent.indexOf("MSIE") > -1) {
//			// IE 5.5 �� ���
//			if (strAgent.indexOf("MSIE 5.5") > -1) {
//				value = "filename="+fileName;
//		***REMOVED*** else if (strAgent.indexOf("MSIE 7.0") > -1) { // IE 7.0�� ���
//				// ���ڵ� Ÿ�� ��
//				if (userCharset.equalsIgnoreCase("UTF-8")) {
//					fileName = URLEncoder.encode(fileName, userCharset);
//					fileName = fileName.replaceAll("\\+", " ");
//					value = "attachment; filename=\""+fileName+"\"";
//			***REMOVED*** else {
//					value = "attachment; filename=" + new String(fileName.getBytes(userCharset), "ISO-8859-1"); 
//			***REMOVED***
//		***REMOVED*** else { // IE 8.0 �̻��� ��� �� �� ȣ���
//				// ���ڵ� Ÿ�� ��
//				if (userCharset.equalsIgnoreCase("UTF-8")) {
//					fileName = URLEncoder.encode(fileName, userCharset);
//					fileName = fileName.replaceAll("\\+", " ");
//					value = "attachment; filename=\""+fileName+"\"";
//			***REMOVED*** else {
//					value = "attachment; filename" + new String(fileName.getBytes(userCharset), "ISO-8859-1");
//			***REMOVED***
//		***REMOVED*** // IE Ȯ�� ����
//	***REMOVED*** else if (strAgent.indexOf("Firefox") > -1) { // Firefox�� ���
//			// Firefox�� ���� ���� ���İ� �νĵ��� ����
//			// �ٸ� ��Ÿ �������� �ڵ�� ������..
//			value = "attachment; filename=" + new String(fileName.getBytes(), "ISO-8859-1");
//	***REMOVED*** else { // �׿� ������
//			value = "attachment; filename=" + new String(fileName.getBytes(), "ISO-8859-1");
//	***REMOVED***
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
//			***REMOVED***
//		***REMOVED*** catch (Exception e) {
//		***REMOVED*** finally {
//				if (bos != null) bos.close();
//				if (bis != null) bis.close();
//		***REMOVED***
//	***REMOVED***
//***REMOVED***
	
***REMOVED***
