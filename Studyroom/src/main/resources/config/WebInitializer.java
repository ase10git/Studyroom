package config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import context.Context_1_dataSource;
import context.Context_2_myBatis;
import context.Context_3_dao;
import context.Context_4_fileupload;
import mvc.ServletContext;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	// getRootConfigClasses
	// 프로젝트의 모델 영역 설정 담당
	// 데이터베이스 연결풀(DBCP), Mybatis, mapper 등과 같은 로직 설정 담당
		
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {Context_1_dataSource.class, 
							Context_2_myBatis.class, 
							Context_3_dao.class,
							Context_4_fileupload.class***REMOVED***;
***REMOVED***
	
	// getServletConfigClasses
	// DispatcherServlet이 사용할 설정 클래스를 반환
	// Spring MVC 웹 영역 설정과 View, Controller 설정 담당
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletContext.class***REMOVED***;
***REMOVED***
	
	// getServletMappings
	// DispatcherServlet의 URL 패턴 지정
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"***REMOVED***; // 모든 요청 처리
***REMOVED***
	
	// filter
	// 클라이언트 요청이 Servlet에 도달하기 전이나 후에 
	// 요청 및 응답 데이터 변형하거나 추가 작업 수행
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return new Filter[] {characterEncodingFilter***REMOVED***;
***REMOVED***
***REMOVED***
