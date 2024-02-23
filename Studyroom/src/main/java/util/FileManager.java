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
// 파일 업로드와 다운로드를 관리하는 클래스
public class FileManager {
	
	// 파일 업로드 경로 설정
//	String webPath = "/resources/upload/"; // 프로젝트 경로
	String savePath = "D:\\Program Files (x86)\\Develop\\Web\\spring-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Studyroom\\resources\\upload\\";
	
//			"D:\\Program Files (x86)\\Develop\\Web\\spring-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Studyroom\\resources\\upload\\";
	
	// =================================== 파일 업로드 ===========================================
	// 새 공지글 추가 시 파일 업로드
	public void fileUpload(CourseBoardDTO new_dto) {

		// 업로드된 파일 클래스 인스턴스
		MultipartFile file = new_dto.getFile();
		
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
		***REMOVED*** catch (Exception e) {***REMOVED***

	***REMOVED***
				
		// DB에 보낼 파일 이름 저장
		new_dto.setFile_name(fileName);
***REMOVED***
	
	// 새 커뮤니티글 추가 시 파일 업로드
	public void fileUpload(CommunityDTO new_dto) {

		// 업로드된 파일 클래스 인스턴스
		MultipartFile file = new_dto.getFile();
		
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
		***REMOVED*** catch (Exception e) {***REMOVED***

	***REMOVED***
				
		// DB에 보낼 파일 이름 저장
		new_dto.setFile_name(fileName);
***REMOVED***
	
	
	// =================================== 파일 수정 ===========================================
	// 공지글 수정 시 파일 업로드
	public void fileUpload(CourseBoardDTO new_dto, CourseBoardDTO origin_dto, int flag) {

		// 새로 변경된 공지글의 파일 첨부 및 파일 이름을 new_dto에 저장
		fileUpload(new_dto);
		
		// 새로 변경된 공지글의 파일 이름
		String fileName = new_dto.getFile_name();
	
		if (fileName != "no_file") { // 새로 변경된 공지글에 파일이 첨부된 경우에만			
			// 공지글 수정 시 기존 파일 제거
			fileDelete(origin_dto); 
					
			// DB에 보낼 파일 이름을 기존 origin_dto에 저장(새로 업데이트)
			origin_dto.setFile_name(fileName);
				
	***REMOVED*** else { // 새로 변경된 공지글에 첨부 파일이 없는 경우
			if (flag == 1) { // 첨부 파일 삭제 요청 있음
				fileDelete(origin_dto); // 첨부 파일 제거
		***REMOVED*** else { // 첨부 파일 삭제 요청이 없음
				return;
		***REMOVED***
	***REMOVED***
***REMOVED***
	
	
	// 공지글 수정 시 파일 업로드
	public void fileUpload(CommunityDTO new_dto, CommunityDTO origin_dto, int flag) {

		// 새로 변경된 공지글의 파일 첨부 및 파일 이름을 new_dto에 저장
		fileUpload(new_dto);
		
		// 새로 변경된 공지글의 파일 이름
		String fileName = new_dto.getFile_name();
	
		if (fileName != "no_file") { // 새로 변경된 공지글에 파일이 첨부된 경우에만			
			// 공지글 수정 시 기존 파일 제거
			fileDelete(origin_dto); 
	***REMOVED*** else { // 새로 변경된 공지글에 첨부 파일이 없는 경우
			if (flag == 1) { // 첨부 파일 삭제 요청 있음
				fileDelete(origin_dto); // 첨부 파일 제거
		***REMOVED*** else { // 첨부 파일 삭제 요청이 없음
				return;
		***REMOVED***
	***REMOVED***
***REMOVED***
		
	// =================================== 파일 제거 ===========================================
	// 서버 컴퓨터에서 코스 첨부 파일 제거
	public void fileDelete(CourseBoardDTO dto) {
		// dto에 저장된 파일 이름으로 서버 컴퓨터에 저장된 파일 정보 가져오기
		File saveFile = new File(savePath, dto.getFile_name());
		if (saveFile.exists()) { // 기존 공지글의 첨부 파일이 서버에 저장되어 있는 경우
			saveFile.delete();
	***REMOVED***
		dto.setFile_name("no_file"); // DB에 첨부파일이 없음을 표시
***REMOVED***

	// 서버 컴퓨터에서 커뮤니티 첨부 파일 제거
	public void fileDelete(CommunityDTO dto) {
		// dto에 저장된 파일 이름으로 서버 컴퓨터에 저장된 파일 정보 가져오기
		File saveFile = new File(savePath, dto.getFile_name());
		if (saveFile.exists()) { // 기존 공지글의 첨부 파일이 서버에 저장되어 있는 경우
			saveFile.delete();
	***REMOVED***
		dto.setFile_name("no_file"); // DB에 첨부파일이 없음을 표시
***REMOVED***
	
	// =================================== 파일 다운로드 ===========================================
	// 코스 공지글 파일 다운로드
	public void fileDownload(CourseBoardDTO dto, HttpServletRequest request, HttpServletResponse response) {
		
		// dto에 저장된 파일 이름 가져오기
		String fileName = dto.getFile_name();
		
		// 첨부 파일이 없는 경우엔 함수 동작 종료
		if (fileName.equals("no_file")) {
			return;
	***REMOVED***
		
		String fullPathName = String.format("%s%s", savePath, fileName);
		
		// 파일 가져오기
		File file = new File(fullPathName);
		byte[] b = new byte[1024*1024*100]; // 파일 최대 한도만큼 바이트 배열 설정
		
		// Charset을 확인하고, 없다면 utf-8로 설정
		String userCharset = request.getCharacterEncoding();
		if (userCharset == null) {
			userCharset = "utf-8";
	***REMOVED***

		// 브라우저가 캐싱하지 않도록 설정
		response.setContentType("Pragma : no-cache");
		
		// 전송 데이터가 stream 처리되도록 설정(웹 상 전송 문자셋은 8859_1)
		response.setContentType("application/octect-stream;charset=8859_1;");
		
		// 데이터 형식 성향 설정(attachment : 첨부파일)
		response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\"");
		
		// 내용물 인코딩 방식 결정
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		// 파일 내보내기
		try {
			if (file.isFile()) { // 파일 존재 여부 확인
				// 파일 입출력 스트림 생성
				//response.getOutputStream()가 이미 호출되었다는 에러가 뜨지만 파일 다운에 지장이 없음
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
				BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());

				int i = 0;
				
				try {
					while((i=bis.read(b)) != -1) { // 파일을 읽어서 출력 스트림에 저장
						bos.write(b, 0, i);
				***REMOVED***
			***REMOVED*** catch (Exception e) {
			***REMOVED*** finally { // 파일 입출력 스트림 종료
					if (bos != null) bos.close();
					if (bis != null) bis.close();
			***REMOVED***
		***REMOVED***
	***REMOVED*** catch (Exception e) {***REMOVED***
***REMOVED***
	
***REMOVED***
