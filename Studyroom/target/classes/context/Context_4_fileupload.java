***REMOVED***

***REMOVED***
***REMOVED***
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

***REMOVED***
public class Context_4_fileupload {
	
***REMOVED***
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setDefaultEncoding("utf-8");
		
//		// �ִ� ���ε� �뷮�� 10mb�� ����
		multipartResolver.setMaxUploadSize(10485760);
		
		return multipartResolver;
***REMOVED***
***REMOVED***
