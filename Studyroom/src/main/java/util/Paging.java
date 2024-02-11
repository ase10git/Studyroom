package util;

public class Paging {

	public static String getPaging(String pageURL, int nowPage, int rowTotal, int blockList, int blockPage) {
		int totalPage, startPage, endPage;
		boolean isPrevPage, isNextPage;
		StringBuffer sb;
		
		isPrevPage = isNextPage = false;
		
		//�엯�젰�맂 �쟾泥� �옄�썝�쓣 �넻�빐 �쟾泥� �럹�씠吏� �닔瑜� 援ы븳�떎.
		totalPage = (int)(rowTotal / blockList);
		
		//寃뚯떆湲��씠 �븯�굹媛� �뜑 �궓�븘�룄 �럹�씠吏� �븯�굹 �뜑 �엳�뼱�빞 �븳�떎.
		if(rowTotal % blockList != 0) totalPage++;
		
		//�샊�떆�씪�룄 �옒紐삳맂 �뿰�궛怨� ��吏곸엫�쑝濡� �씤�빐 �쁽�옱 �럹�씠吏��닔媛� �쟾泥� �럹�씠吏��닔瑜�
		//�꽆�뼱媛� 寃쎌슦 媛뺤젣濡� �쁽�옱 �럹�씠吏� 媛믪쓣 �쟾泥� �럹�씠吏� 媛믪쑝濡� 蹂�寃�
		if(nowPage > totalPage) nowPage = totalPage;
		
		//�떆�옉�럹�씠吏��� 留덉�留됲럹�씠吏�瑜� 援ы븳�떎.
		startPage = (int)(((nowPage - 1)/blockPage)*blockPage+1);
		endPage = startPage + blockPage - 1;
		
		if(endPage > totalPage) endPage = totalPage;
		
		//留덉�留� �럹�씠吏�媛� �쟾泥댄럹�씠吏�蹂대떎 �옉�쓣 寃쎌슦 �떎�쓬 �럹�씠吏� �씠�룞踰꾪듉�씠 �옉�룞�븷 �닔 �엳�룄濡�
		//boolean�삎 蹂��닔�쓽 媛믪쓣 �꽦�젙
		if(endPage < totalPage) isNextPage = true;
		
		if(startPage > 1) isPrevPage = true;
		
		sb = new StringBuffer();
		
		if(isPrevPage) {
			sb.append("<a href='"+pageURL+"?page=");
			sb.append(startPage - 1);
			sb.append("'><img src='resources/img/btn_prev.gif'></a>");
		} else {
			sb.append("<img src='resources/img/btn_prev.gif'>");
		}
		
		sb.append(" ");
		for(int i = startPage; i <=endPage; i++) {
			if(i > totalPage) break;
			if(i == nowPage) {//�쁽�옱 �럹�씠吏� �씪�븣
				sb.append("&nbsp;<b><font color='#ff0000'>");
				sb.append(i);
				sb.append("</font></b>");
			} else {//�쁽�옱 �럹�씠吏�媛� �븘�땺�븣
				sb.append("&nbsp;<a href='"+pageURL+"?page=");
				sb.append(i);
				sb.append("'>");
				sb.append(i);
				sb.append("</a>");
			}
		}
		sb.append("&nbsp; ");
		
		if(isNextPage) {
			sb.append("<a href='"+pageURL+"?page=");
			sb.append(endPage+1);
			sb.append("'><img src='resources/img/btn_next.gif'></a>");
		}else {
			sb.append("<img src='resources/img/btn_next.gif'>");
		}
		
		return sb.toString();
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
