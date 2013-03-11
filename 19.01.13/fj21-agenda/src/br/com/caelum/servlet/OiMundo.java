package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OiMundo extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest requisicao, HttpServletResponse resposta) {
		
		try {
			PrintWriter saida = resposta.getWriter();
		
			saida.println("<html>");
			saida.println("<body>Ol&aacute; Mundo </body>");
			saida.println("</html>");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
