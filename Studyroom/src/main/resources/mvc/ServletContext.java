package mvc;

***REMOVED***
***REMOVED***
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.study.study.UserController;

import dao.UserDAO;

***REMOVED***
@EnableWebMvc
//@ComponentScan("com.study.study")
public class ServletContext implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
***REMOVED***

	//UserController Bean
***REMOVED***
	public UserController userController(UserDAO userDAO) {
		return new UserController(userDAO);
***REMOVED***
	
//***REMOVED***
//	public AnnouncementController(AnnouncementDAO announcementDAO) {
//		return new AnnouncementController(announcementDAO);
//***REMOVED***
	
***REMOVED***
