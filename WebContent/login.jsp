<!doctype html>
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
        <header class="p-4 text-light cor__fundo">
            <h3>Projeto Traveller</h3>
            <h5>Area de Login</h5>
        </header>

        <div class="container my-5">
            <div class="text-center">
                <img src="./assets/images/login.png" class="logo" alt="">
            </div>

            <div class="row justify-content-center px-3">
                <div class="col-12 col-sm-12 col-md-6 align-self-center">
                    <form method="post" action="./login">

                        <div class="form-group">
                            <label for="email" class="titulos">Email</label>
                            <input type="email" class="form-control" id="email" name="email"
                                placeholder="Ex: seuemail@traveller.com.br" autofocus required>
                        </div>

                        <div class="form-group">
                            <label for="senha" class="titulos">Senha</label>
                            <div class="input-group mb-2">
                                <input type="password" class="form-control senha" id="senha" name="senha"
                                    placeholder="Ex: sua senha" required>
                                <div class="input-group-prepend">
                                    <div class="input-group-text"> <img src="./assets/images/visibilidade.png"
                                            class="pointer visibilidade" alt="Imagem para exibir senha">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <button type="submit" class="btn btn-primary">Efetuar Login <span
                                class="fas fa-paper-plane"></span></button>

                    </form>
                </div>
            </div>
        </div>

        <script src="./assets/js/exibir_senha.js"></script>
    </body>
</html>