package mvc;

***REMOVED***
***REMOVED***
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.study.study.CalenderController;

import dao.CalenderDAO;

***REMOVED***
@EnableWebMvc
//@ComponentScan("com.study.study")
public class ServletContext implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
***REMOVED***
	
***REMOVED***
	public CalenderController calenderController(CalenderDAO calenderDAO) {
		return new CalenderController(calenderDAO);
***REMOVED***
***REMOVED***
