package br.com.masters3.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.masters3.beans.Cidade;
import br.com.masters3.dao.CidadeDAO;
import br.com.masters3.dao.DataSource;

@WebServlet("/cadastrar_usuario")
public class CadastrarUsuarioServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String paginaDestino = "";

		// para cadastrar novo usuário é necessário estar "logado"
		if (request.getSession().getAttribute("Usuario") != null) {
			try {
				DataSource dataSource = new DataSource();
				CidadeDAO dao = new CidadeDAO(dataSource);
				ArrayList<Cidade> listaCidades = (ArrayList<Cidade>) dao.read(null);
				System.out.println(listaCidades);
				dataSource.getConnection().close();
				request.setAttribute("ListaCidades", listaCidades);

				paginaDestino = "/cadastrar_usuario.jsp";
			} catch (Exception ex) {
				paginaDestino = "/erro.jsp";
				request.setAttribute("ErroMSG", "Erro ao estabelecer conexao com Banco de Dados");
			}
		} else {
			request.setAttribute("ErroMSG", "Usuario Nao Conectado");
			paginaDestino = "/erro.jsp";

		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		dispatcher.forward(request, response);
	}
}
