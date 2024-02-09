package util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import dto.CourseBoardDTO;

// 파일 업로드 경로 설정과 파일 업로드를 담당하는 클래스
public class UploadFile {
	
	public void fileUpload(CourseBoardDTO dto, HttpServletRequest request) {
		
		// 파일 업로드 경로 설정
		String webPath = "/resources/upload/"; // 프로젝트 경로
		String savePath = request.getServletContext().getRealPath(webPath); // 실제 컴퓨터 경로
		System.out.println(savePath); // 경로 출력

		// 업로드된 파일 클래스 인스턴스
		MultipartFile file = dto.getFile();
		
		System.out.println("파일 검사 : " + file.isEmpty());
		
		// 기본 이름 설정
		String fileName = "no_file";
				
		if(!file.isEmpty()) { // 파일을 업로드 했는지 검사(파일이 있는 경우)
			fileName = file.getOriginalFilename(); // 원본 파일 이름
			
			// 저장할 파일 설정
			File saveFile = new File(savePath, fileName);
			
			if(!saveFile.exists()) { // 중복 파일 검사
				saveFile.mkdirs(); // 폴더로 생성, 이후에 파일로 변경됨
		***REMOVED*** else {
				long time = System.currentTimeMillis(); // 업로드 시간 기록
				fileName = String.format("%d_%s", time, fileName); // 파일 이름을 업로드 시간 포함해서 수정
				saveFile = new File(savePath, fileName); // 새 파일 이름으로 파일 설정
		***REMOVED***
			
			// 물리적으로 파일을 업로드
			try {
				file.transferTo(saveFile);
		***REMOVED*** catch (Exception e) {
		***REMOVED***
	***REMOVED*** 
		
		// DB에 보낼 파일 이름을 CourseBoardDTO dto에 저장
		dto.setFile_name(fileName);
		
***REMOVED***
	
***REMOVED***
