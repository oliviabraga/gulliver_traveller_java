package br.com.masters3.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.masters3.beans.Usuario;
import br.com.masters3.dao.DataSource;
import br.com.masters3.dao.UsuarioDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String pagina="";
		try {
			// crio a conexao com o banco
			DataSource dataSource = new DataSource();
			// passo isso para o DAO
			UsuarioDAO usuarioDao = new UsuarioDAO(dataSource);
			// agora vamos criar um usuário para recuperar os dados via request
			Usuario userLogin = new Usuario();
			userLogin.setEmail(request.getParameter("email"));
			userLogin.setSenha(request.getParameter("senha"));
			
			Usuario user = usuarioDao.read(userLogin);
			if (user != null) {
				// aqui um segredo importantíssimo: manter o vínculo do usuário conectado!
				request.getSession().setAttribute("Usuario", user);
				pagina = "/dados_usuario.jsp";
			}
			else {
				request.setAttribute("ErroMSG", "Usuario nao encontrado");
				pagina = "/erro.jsp";
			}
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}
		catch(Exception ex) {
			System.out.println("ERRO on LOGINSERVLET "+ex.getMessage());
		}
		
	}

}
