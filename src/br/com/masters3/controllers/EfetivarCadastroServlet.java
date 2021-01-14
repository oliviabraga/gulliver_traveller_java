package br.com.masters3.controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.masters3.beans.Cidade;
import br.com.masters3.beans.Usuario;
import br.com.masters3.dao.DataSource;
import br.com.masters3.dao.UsuarioDAO;

@WebServlet("/efetivar_cadastro")
@MultipartConfig(maxFileSize = 2 * 1024 * 1024, maxRequestSize = 4 * 1024 * 1024)
public class EfetivarCadastroServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paginaDestino="";
		try {
			
			// 1. antes de mais nada - usuario tem que estar conectado
			if (request.getSession().getAttribute("Usuario") != null) {
				
				//2 - recuperando dados que virão do formulário
				String txtNome       = request.getParameter("txtNome");
				String txtEmail      = request.getParameter("txtEmail");
				String txtSenha      = request.getParameter("txtSenha");
				String txtNascimento = request.getParameter("txtNascimento");
				String txtPerfil  = request.getParameter("txtPerfil");
				int    txtCidade     = Integer.parseInt(request.getParameter("txtCidade"));
				String txtGenero     = request.getParameter("txtGenero");
				
				// 3 - tratamento do arquivo de foto que será enviado
				InputStream arquivoOriginal = request.getPart("txtFoto").getInputStream();
				String nomeArquivoOriginal = request.getPart("txtFoto").getSubmittedFileName();
				String nomeArquivo = getServletContext().getRealPath("/")+"assets/images/"+nomeArquivoOriginal;
				
				FileOutputStream fotoUsuario = new FileOutputStream(nomeArquivo);
				byte buf[] = new byte[1024];
				
				// copiando blocos de 1K do arquivo original para o arquivo destino
				while (arquivoOriginal.available() > 0) {
					arquivoOriginal.read(buf);
					fotoUsuario.write(buf);
				}
				arquivoOriginal.close();
				fotoUsuario.close();
				
				
				// 4 - preenchimento dos dados do usuário 
				Usuario usuario = new Usuario();
				usuario.setNome(txtNome);
				usuario.setEmail(txtEmail);
				usuario.setSenha(txtSenha);
				usuario.setNascimento(LocalDate.parse(txtNascimento));
				usuario.setNivel(txtPerfil);
				usuario.setGenero(txtGenero);
				usuario.setFoto(nomeArquivo);
				Cidade cidade = new Cidade();
				cidade.setId(txtCidade);
				usuario.setCidade(cidade);
				
				// 5 - gravando objeto no banco de Dados
				DataSource dataSource = new DataSource();
				UsuarioDAO udao = new UsuarioDAO(dataSource);
				udao.create(usuario);
				dataSource.getConnection().close();
				
				paginaDestino = "/sucesso.jsp";
			}
			else {
				paginaDestino = "/erro.jsp";
				request.setAttribute("ErroMSG", "Erro ao realizar cadastro!");
			}
		}
		catch(Exception ex) {
			paginaDestino = "/erro.jsp";
			request.setAttribute("ErroMSG", "Erro desconhecido no cadastro");
			ex.printStackTrace();
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		dispatcher.forward(request, response);
		
	}

}
