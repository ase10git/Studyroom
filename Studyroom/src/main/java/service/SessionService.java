package service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.UserDTO;

@Service
public class SessionService {
	
	@Autowired
    private HttpSession session;
	
	// 세션에서 사용자 정보 가져오기
	public UserDTO getUserFromSession() {
        return (UserDTO) session.getAttribute("email");
    ***REMOVED***
	
	// 세션에 사용자 정보 저장하기
    public void setUserInSession(String attr, UserDTO dto) {
        session.setAttribute(attr, dto);
    ***REMOVED***
    
    // 세션에 사용자 정보 제거하기
    public void removeAttribute(String attr) {
        session.removeAttribute(attr);
    ***REMOVED***

***REMOVED***
