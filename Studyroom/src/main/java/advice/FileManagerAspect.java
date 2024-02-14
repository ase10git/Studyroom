package advice;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.study.study.CourseBoardController;

@Aspect
@Component
public class FileManagerAspect {
	
	@Autowired
	HttpServletRequest request;
	
	// 작동이 안되는듯
    @Before("execution(* com.study.study.*Controller.login(..))")
    public void addFilePath() {
    	System.out.println("test");
    	if (CourseBoardController.fileManager.getSavePath() == null) {
    		String realPath = request.getServletContext().getRealPath("/resources/upload/");
    		CourseBoardController.fileManager.setSavePath(realPath);
    	}
    }
}
