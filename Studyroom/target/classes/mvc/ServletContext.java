package mvc;

***REMOVED***
***REMOVED***
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.study.study.AdminController;
import com.study.study.AnnouncementController;
import com.study.study.CalendarController;
import com.study.study.CommunityController;
import com.study.study.CourseBoardController;
import com.study.study.CourseController;
import com.study.study.LoginController;
import com.study.study.UserController;

import dao.AnnouncementDAO;
import dao.CalendarDAO;
import dao.CommunityDAO;
import dao.CourseBoardDAO;
import dao.CourseDAO;
import dao.UserCourseDAO;
import dao.UserCourseViewDAO;
import dao.UserDAO;

***REMOVED***
@EnableWebMvc
//@ComponentScan("com.study.study")
public class ServletContext implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
***REMOVED***
	
	// LoginController Bean
***REMOVED***
	public LoginController loginController(UserDAO userDAO) {
		return new LoginController(userDAO);
***REMOVED***
	
	// UserController Bean
***REMOVED***
	public UserController userController(UserDAO userDAO) {
		return new UserController(userDAO);
***REMOVED***
	
	// AnnouncementController Bean
***REMOVED***
	public AnnouncementController announcemnetController(AnnouncementDAO announcementDAO) {
		return new AnnouncementController(announcementDAO);
***REMOVED***

	// CourseController Bean
***REMOVED***
	public CourseController courseController(UserDAO userDAO, CourseDAO course_dao, CourseBoardDAO course_board_dao, UserCourseViewDAO us_view_dao) {
		return new CourseController(userDAO, course_dao, course_board_dao, us_view_dao);
***REMOVED***
	
	// CourseBoardController Bean
***REMOVED***
	public CourseBoardController courseBoardController(CourseDAO course_dao, CourseBoardDAO course_board_dao) {
		return new CourseBoardController(course_dao, course_board_dao);
***REMOVED***
	
	// CommunityController Bean
***REMOVED***
	public CommunityController communityController(CommunityDAO dao) {
		return new CommunityController(dao);
***REMOVED***
	
	// CalendarController Bean
***REMOVED***
	public CalendarController calendarController(CalendarDAO calendar_dao) {
		return new CalendarController(calendar_dao);
***REMOVED***
	
	// AdminController Bean
***REMOVED***
	public AdminController adminController(UserDAO user_dao, CourseDAO course_dao, UserCourseDAO user_course_dao, CourseBoardDAO course_board_dao, CommunityDAO community_dao) {
		return new AdminController(user_dao, course_dao, user_course_dao, course_board_dao, community_dao);
***REMOVED***

***REMOVED***
