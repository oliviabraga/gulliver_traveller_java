<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="ListaCidades" scope="request" type="java.util.ArrayList<br.com.masters3.beans.Cidade>"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Usuario</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
	integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
	crossorigin="anonymous" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12 text-center">
				<h3>Cadastrar Usuario</h3>
			</div>
		</div>

		<form action="./efetivar_cadastro" method="POST"
			enctype="multipart/form-data">
			<div class="row">
				<div class="col-12">
					<div class="form-group">
						<label for="txtNome">Digite seu nome</label> <input type="text"
							id="txtNome" name="txtNome" class="form-control">
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-6">
					<div class="form-group">
						<label for="txtEmail">Digite seu email</label> <input type="email"
							id="txtEmail" name="txtEmail" class="form-control">
					</div>
				</div>

				<div class="col-6">
					<div class="form-group">
						<label for="txtSenha">Digite sua senha</label> <input
							type="password" id="txtSenha" name="txtSenha"
							class="form-control">
					</div>
				</div>
			</div>


			<div class="row">
				<div class="col-6">
					<div class="form-group">
						<label for="txtNascimento">Data de Nascimento</label> 
						<input
							type="date" id="txtNascimento" name="txtNascimento"
							class="form-control">
					</div>
				</div>

				<div class="col-6">
					<div class="form-group">
						<label for="txtPerfil">Selecione seu perfil</label> 
						<select class="form-control"
							id="txtPerfil" name="txtPerfil">
							<option value="1">Usuario</option>
							<option value="2" selected>Administrador</option>
						</select>

					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<div class="form-group">
						<label for="txtGenero">Genero</label> 
						<select id="txtGenero"
							name="txtGenero" class="form-control">
							<option value="1">Masculino</option>
							<option value="2">Feminino</option>
							<option value="3">Outros</option>
							<option value="4">Prefiro nao citar</option>
						</select>

					</div>
				</div>
				
				 <div class="col-6">
					<div class="form-group">
						<label for="txtCidade">Selecione sua Cidade </label> 
						<select id="txtCidade" name="txtCidade" class="form-control">
						<c:forEach var="cidade" items="${ListaCidades}">
						    <option value="${cidade.id}"> <c:out value="${cidade.cidade}"/></option>
						</c:forEach>
						</select>
					</div>
				</div>
			</div>

			<div class="row">
			   
				<div class="col-12">
					<div class="form-group">
						<label for="txtFoto"> Insira sua foto </label> 
						<input type="file"
							name="txtFoto" id="txtFoto" class="form-control">
					</div>
				</div>
			</div>



			<div class="row">
				<div class="col-12">
					<button class="btn btn-primary" type="submit">Enviar Dados</button>
					<button class="btn btn-primary" type="reset">Limpar
						Formulário</button>
				</div>
			</div>

		</form>

	</div>


</body>
</html>