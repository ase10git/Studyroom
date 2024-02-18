package advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SessionCheckAspect {
	    
//	@Autowired
//    private HttpSession session;
//    
//    @Before("execution(* com.study.study.UserController.user_*(..))")
//    public void checkSession() {
//        UserDTO currentSession = (UserDTO) session.getAttribute("email");
//        if (currentSession == null) {
//            throw new IllegalStateException("세션이 만료되었습니다.");
//        ***REMOVED***   
//    ***REMOVED***
//    
//    @Before("execution(* com.study.study.UserController.user_*(..)) && args(.., model)")
//    public void addDtoToModel(Model model) {
//        UserDTO dto = (UserDTO) model.asMap().get("dto");
//        if (dto != null) {
//            model.addAttribute("dto", dto);
//        ***REMOVED***
//    ***REMOVED***
	
	@Pointcut("execution(* com.study.study.*.*(..))")
	public void myPoint() {***REMOVED***
	
	@Before("myPoint()") 
	public void before(JoinPoint jp) {
		System.out.println("----before:"+jp.getSignature());
***REMOVED***
	
	
***REMOVED***
