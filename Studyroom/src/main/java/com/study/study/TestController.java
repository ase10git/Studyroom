package com.study.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Common;

// �׽�Ʈ�� ��Ʈ�ѷ�
// ������ �������� ���� �����ؼ� ������ּ���
@Controller
public class TestController {

	@RequestMapping("/")
	public String test() {
		return Common.VIEW_PATH + "home.jsp";
***REMOVED***
	
	/*
	@RequestMapping("/")
	public String board_list(Model model) {
		
***REMOVED***
	
	@RequestMapping("/")
	public String board_list_user() {
		
***REMOVED***
	
	@RequestMapping("/")
	public String board_view(Model model) {
		
***REMOVED***
	
	@RequestMapping("/")
	public String board_view_delete(int idx) {
		
***REMOVED***
	
	@RequestMapping("/")
	public String board_insert_form() {
		
***REMOVED***
	
	@RequestMapping("/")
	public String board_insert() {
		
***REMOVED***
	
	@RequestMapping("/")
	public String board_reply_insert(int idx) {
		
***REMOVED***
	
	@RequestMapping("/")
	public String board_modify_form() {
		
***REMOVED***
	
	@RequestMapping("/")
	public String board_modify(int idx) {
		
***REMOVED***
	*/
***REMOVED***
