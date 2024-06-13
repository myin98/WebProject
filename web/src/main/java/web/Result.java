package web;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Result")
public class Result extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String cnt =req.getParameter("cnt");
		String txt = req.getParameter("txt");
		System.out.println(cnt + " , " + txt);
		print(req, resp, cnt, txt);
		
	}
	
	private void print(HttpServletRequest req, HttpServletResponse resp, String cnt, String txt) throws ServletException, IOException{
		
	
		String html = ""
				+ "<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<head>\n"
				+ "<meta charset=\"UTF-8\">\n"
				+ "<title>데이터 출력 화면</title>\n"
				+ "<link rel=\"icon\" href=\"<%=request.getContextPath()%>/www/img/logo.png\" type=\"image/x-icon\">\n"
				+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "\n"
				+ "<div class=\"container mt-3\">\n";
		html		+= "	<div class=\"d-grid gap-3\">\n";
				
		html		+= "		<a href=\"Form\" class=\"btn btn-success btn-block\">돌아가기</a>\n";
								
		html		+= "	</div>\n"
				
				+ "	<h1 class=\"text-center mt-3\">입력한 결과</h1>\n"
				+ "	<ol class=\"list-group list-group-numbered\">\n"; //끈어
		
		int c = Integer.parseInt(cnt);
		if(c == 0) {
			html	+=	"    <li class=\"list-group-item\">입력 받은 값이 없습니다</li>\n";	//대입
		} else {
				for(int i = 0; i < c; i++) {
				html	+=	"<li class=\"list-group-item\">" + txt + "</li>\n"; //대입
			}
		}
		
			html += "	</ol>\n"			//대입 ; 없이
				+ "</div>\n"
				+ "</body>\n"
				+ "</html>";


		System.out.println(html);
		resp.getWriter().append(html);
		
		
		
		
	}

}
