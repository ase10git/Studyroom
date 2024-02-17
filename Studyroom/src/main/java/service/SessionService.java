package service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.UserDTO;

@Service
public class SessionService {
	
	@Autowired
    private HttpSession session;
	
	// ���ǿ��� ����� ���� ��������
	public UserDTO getUserFromSession() {
        return (UserDTO) session.getAttribute("email");
    ***REMOVED***
	
	// ���ǿ� ����� ���� �����ϱ�
    public void setUserInSession(String attr, UserDTO dto) {
        session.setAttribute(attr, dto);
    ***REMOVED***
    
    // ���ǿ� ����� ���� �����ϱ�
    public void removeAttribute(String attr) {
        session.removeAttribute(attr);
    ***REMOVED***

***REMOVED***
