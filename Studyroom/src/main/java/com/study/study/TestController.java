package com.study.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import util.Common;

// 테스트용 컨트롤러
// 파일을 변경하지 말고 복사해서 사용해주세요
@Controller
@RequiredArgsConstructor
public class TestController {

	@RequestMapping("home")
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
