package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

***REMOVED***
***REMOVED***
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.study.study.AdminController;
import com.study.study.CourseBoardController;
import com.study.study.CourseController;
import com.study.study.TestController;

import dao.CourseBoardDAO;
import dao.CourseDAO;

***REMOVED***
@EnableWebMvc
//@ComponentScan("com.study.study")
public class ServletContext implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
***REMOVED***

//	// testController Bean
***REMOVED***
	public TestController testController() {
		return new TestController();
***REMOVED***
	
	// CourseController Bean
***REMOVED***
	public CourseController courseController(CourseDAO course_dao) {
		return new CourseController(course_dao);
***REMOVED***
	
	// CourseBoardController Bean
***REMOVED***
	public CourseBoardController courseBoardController(CourseDAO course_dao, CourseBoardDAO course_board_dao) {
		return new CourseBoardController(course_dao, course_board_dao);
***REMOVED***
	
	// AdminController Bean
***REMOVED***
	public AdminController adminController(CourseDAO course_dao, CourseBoardDAO course_board_dao) {
		return new AdminController(course_dao, course_board_dao);
***REMOVED***
***REMOVED***
