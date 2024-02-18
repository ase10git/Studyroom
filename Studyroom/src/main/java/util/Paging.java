package util;

public class Paging {
	
	public static String getPaging(String pageURL, int nowPage, int rowTotal, int blockList, int blockPage) {
		int totalPage, startPage, endPage;
		boolean isPrevPage, isNextPage;
		StringBuffer sb;
		
		isPrevPage = isNextPage = false;
		
		totalPage = (int)(rowTotal / blockList);
		
		if (rowTotal % blockList != 0) totalPage++;
		
		if (nowPage > totalPage) nowPage = totalPage;
		
		startPage = (int)(((nowPage - 1)/blockPage)*blockPage+1);
		endPage = startPage + blockPage -1;
		
		if (endPage > totalPage) endPage = totalPage;
		
		if (endPage < totalPage) isNextPage = true;
		
		if (startPage > 1) isPrevPage = true;
		
		sb = new StringBuffer();

		sb.append("<nav aria-label=\"page\">"
				+ "&nbsp;<ul class=\"pagination justify-content-center\">");
		
		if(isPrevPage) {
			sb.append("<li class=\"page-item\"><a class=\"page-link\" href=\""+pageURL+"?page=");
			sb.append(startPage-1);
			sb.append("\"><i class=\"fi fi-br-arrow-alt-square-right\"></i></a>");
		} else {
			sb.append("<li class=\"page-item disabled\"><i class=\\\"fi fi-br-arrow-alt-square-right\\\"></i></li>");
		}
		
		sb.append("");
		for (int i = startPage; i <= endPage; i++) {
			if(i > totalPage) break;
			if(i == nowPage) {
				sb.append("<li class=\"page-item active\" aria-current=\"page\"><span class=\"page-link\">");
				sb.append(i);
				sb.append("</span></li>");
			} else {
				sb.append("<li class=\"page-item\"><a class=\"page-link\" href=\""+pageURL+"?page=");
				sb.append(i);
				sb.append("\">");
				sb.append(i);
				sb.append("</a>");
			}
		}
		
		if(isNextPage) {
			sb.append("<li class=\"page-item\"><a class=\"page-link\" href=\""+pageURL+"?page=");
			sb.append(endPage+1);
			sb.append("\"><i class=\"fi fi-br-arrow-alt-square-left\"></i></a>");
		} else {
			sb.append("<li class=\"page-item disabled\"><i class=\\\"fi fi-br-arrow-alt-square-left\\\"></i></li>");
		}
		
		sb.append("&nbsp;</ul>\n"
				+ "</nav>\n");
		
		return sb.toString();
	}
}
