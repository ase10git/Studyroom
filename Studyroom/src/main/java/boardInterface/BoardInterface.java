package boardInterface;

import org.springframework.ui.Model;

public interface BoardInterface {
	
	public String board_list(Model model);
	
	public String board_list_user(); 
	
	public String board_view(Model model); 
	
	public String board_view_delete(int idx); 
	
	public String board_insert_form(); 
	
	public String board_insert(); 
	
	public String board_reply_insert(int idx); 
	
	public String board_modify_form(); 
	
	public String board_modify(int idx);
	
	
	
***REMOVED***
