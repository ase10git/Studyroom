package mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.study.study.CourseBoardController;
import com.study.study.CourseController;
import com.study.study.TestController;

import dao.CourseBoardDAO;
import dao.CourseDAO;

@Configuration
@EnableWebMvc
//@ComponentScan("com.study.study")
public class ServletContext implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

//	// testController Bean
	@Bean
	public TestController testController() {
		return new TestController();
	}
	
	// CourseController Bean
	@Bean
	public CourseController courseController(CourseDAO course_dao) {
		return new CourseController(course_dao);
	}
	
	// CourseBoardController Bean
	@Bean
	public CourseBoardController courseBoardController(CourseDAO course_dao, CourseBoardDAO course_board_dao) {
		return new CourseBoardController(course_dao, course_board_dao);
	}
}
