package mvc;

***REMOVED***
***REMOVED***
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.study.study.CommunityController;
import com.study.study.TestController;

import dao.CommunityDAO;

***REMOVED***
@EnableWebMvc
//@ComponentScan("com.study.study")
public class ServletContext implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
***REMOVED***
	
***REMOVED***
	public TestController testController() {
		return new TestController();
***REMOVED***
	
***REMOVED***
	public CommunityController communityController(CommunityDAO dao) {
		return new CommunityController(dao);
***REMOVED***
***REMOVED***
