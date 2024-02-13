package advice;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dto.UserDTO;

@Aspect
@Component
public class SessionCheckAspect {
	    
	@Autowired
    private HttpSession session;
    
    @Before("execution(* com.study.study.UserController.*(..))")
    public void checkSession() {
        UserDTO current_session = (UserDTO)session.getAttribute("email");
        if (current_session == null) {
            throw new IllegalStateException("세션이 만료되었습니다.");
        }
    }
	
}
