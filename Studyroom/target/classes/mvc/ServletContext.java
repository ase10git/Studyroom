package mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.study.study.AnnouncementController;
import com.study.study.UserController;

import dao.AnnouncementDAO;
import dao.UserDAO;

@Configuration
@EnableWebMvc
//@ComponentScan("com.study.study")
public class ServletContext implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	//UserController Bean
	@Bean
	public UserController userController(UserDAO userDAO) {
		return new UserController(userDAO);
	}
	
	@Bean
	public AnnouncementController(AnnouncementDAO announcemnetDAO) {
		return new AnnouncementController(announcemnetDAO);
	}
	
}
