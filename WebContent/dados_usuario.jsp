<!doctype html>
<jsp:useBean id="Usuario" type="br.com.masters3.beans.Usuario" scope="session"/> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
            integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
            integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
            crossorigin="anonymous" />

        <link rel="stylesheet" href="./assets/css/style.css">
        <title>Projeto Traveller</title>
    </head>

    <body>

        <header class="p-4 text-light cor__fundo meu__header">
            <div>
                <h3>Projeto Traveller</h3>
                <h5>A�rea do Usuario</h5>
            </div>
            <div>
                <a class="btn btn-outline-light" href="./login.jsp">Logout <i class="fas fa-sign-out-alt"></i></a>
            </div>
        </header>

        <div class="container my-5">
            <div class="text-center mb-5">
                <img src="${Usuario.foto}" class="logo" alt="">
                <h2 class="my-1">Ola <c:out value="${Usuario.nome}"/></h2>
                <p><c:out value="${Usuario.email}"/></p>
                <p>Nivel de Usuario: <c:if test="${Usuario.nivel==1}">Usuario</c:if>
                                     <c:if test="${Usuario.nivel==2}">Administrador</c:if>
                
                
                </p>
                <p>
                    <a href="./cadastrar_usuario" class="btn btn-success btn-sm mr-2">Cadastrar novo usuario</a>
                </p>
            </div>

            <p class="p-3 bg-info text-light meu__header">Dados da conta
                <button class="btn btn-outline-light " id="alterar"> <i class="fas fa-user-edit"></i> Alterar seus dados</button>
            </p>

            <form method="post" id="dados-conta" action="">

                <!-- Campos: nome - senha -->
                <div class="row">
                    <div class="col-12 col-sm-12 col-md-6">
                        <div class="form-group">
                            <label for="nome" class="titulos">Nome</label>
                            <input type="text" class="form-control" id="nome" name="nome" value="<c:out value="${Usuario.nome}"/>"
                                disabled required>
                        </div>
                    </div>

                    <div class="col-12 col-sm-12 col-md-6">
                        <div class="form-group disabled">
                            <label for="senha" class="titulos">Senha</label>
                            <div class="input-group mb-2">
                                <input type="password" class="form-control senha" id="senha" name="senha" value=""
                                    placeholder="Sua nova senha" disabled>
                                <div class="input-group-prepend">
                                    <div class="input-group-text "><img src="./assets/images/visibilidade.png"
                                            class="pointer visibilidade" alt="Imagem para exibir senha">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Campos: email - nivel de acesso -->
                <div class="row">
                    <div class="col-12 col-sm-12 col-md-6">
                        <div class="form-group">
                            <label for="email" class="titulos">Email</label>
                            <input type="email" class="form-control" id="email" name="email"
                                value="" disabled required>
                        </div>
                    </div>

                    <div class="col-12 col-sm-12 col-md-6">
                        <div class="form-group">
                            <label for="acesso" class="titulos">Nivel de acesso</label>
                            <select class="form-control" id="acesso" name="acesso" disabled required>
                                <option value="" disabled>Selecione o ni�vel de acesso</option>
                                <option value="1">Usuario</option>
                                <option value="2" selected>Administrador</option>
                            </select>
                        </div>
                    </div>
                </div>

                <!-- Campos: data nascimento - cidade -->
                <div class="row">
                    <div class="col-12 col-sm-12 col-md-6">
                        <div class="form-group">
                            <label for="data_nascimento" class="titulos">Data de Nascimento</label>
                            <input type="date" class="form-control" id="data_nascimento" name="data_nascimento"
                                value="<c:out value="${Usuario.nascimento}"/>" disabled required>
                        </div>
                    </div>

                    <div class="col-12 col-sm-12 col-md-6">
                        <div class="form-group">
                            <label for="cidade" class="titulos">Cidade</label>
                            <input type="date" class="form-control" id="cidade" name="cidade"
                                value="<c:out value="${Usuario.cidade.cidade}"/>" disabled required>
                        </div>
                    </div>
                </div>

                <!-- Campos: foto - gênero -->
                <div class="row">
                    <div class="col-12 col-sm-12 col-md-6">
                        <div class="form-group">
                            <label for="foto" class="titulos">Foto</label>
                            <input type="file" class="form-control" id="foto" name="foto" disabled required>
                        </div>
                    </div>

                    <div class="col-12 col-sm-12 col-md-6">
                        <div class="form-group">
                            <label for="genero" class="titulos">Genero</label>
                            <select class="form-control" id="genero" name="genero" disabled required>
                                <option value="" disabled selected>Selecione seu genero</option>
                                <option value="1">Masculino</option>
                                <option value="2">Feminino</option>
                                <option value="3">Outros</option>
                                <option value="4">Prefiro nao citar</option>
                            </select>
                        </div>
                    </div>
                </div>

                <!--  Botão Gravar alterações -->
                <div class="d-flex justify-content-end">
                    <button type="submit" class="btn btn-primary my-3" id="gravar" disabled>Gravar Alteracoes</button>
                        <i class="fas fa-cloud-upload-alt"></i>
                </div>

            </form>
        </div>

        <footer class="p-4 text-light cor__fundo">
            <h5 class="text-center">Projeto Traveller - Direitos reservados</h5>
        </footer>

        <script src="./assets/js/exibir_senha.js"></script>
        <script src="./assets/js/permite_alterar_dados.js"></script>

    </body>
</html>