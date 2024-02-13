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
	// ������Ʈ�� �� ���� ���� ���
	// �����ͺ��̽� ����Ǯ(DBCP), Mybatis, mapper ��� ���� ���� ���� ���
		
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {Context_1_dataSource.class, 
							Context_2_myBatis.class, 
							Context_3_dao.class,
							Context_4_fileupload.class***REMOVED***;
***REMOVED***
	
	// getServletConfigClasses
	// DispatcherServlet�� ����� ���� Ŭ������ ��ȯ
	// Spring MVC �� ���� ������ View, Controller ���� ���
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletContext.class***REMOVED***;
***REMOVED***
	
	// getServletMappings
	// DispatcherServlet�� URL ���� ����
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"***REMOVED***; // ��� ��û ó��
***REMOVED***
	
	// filter
	// Ŭ���̾�Ʈ ��û�� Servlet�� �����ϱ� ���̳� �Ŀ� 
	// ��û �� ���� ������ �����ϰų� �߰� �۾� ����
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return new Filter[] {characterEncodingFilter***REMOVED***;
***REMOVED***
***REMOVED***
