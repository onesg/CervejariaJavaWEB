<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="./_login_register_css/style.css">

        <title>Painel do Administrador</title>

    </head>

    <body class="img js-fullheight" style="background-image: url(_login_register_img/bg.jpg);">
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 col-lg-4">
                        <div class="login-wrap p-0">
                            <h3 class="mb-4 text-center">Painel Administrador</h3>
                            <form action="LogarAdminCTR" class="signin-form" method="POST">
                                <!-- INICIO CAMPO LOGIN -->
                                <div class="form-group">
                                    <input id="form_admin_login" name="form_admin_login" type="text" class="form-control"
                                           placeholder="Nome de usuário" maxlength="64" required>
                                </div>
                                <!-- FIM CAMPO LOGIN -->

                                <!-- INICIO CAMPO SENHA -->
                                <div class="form-group">
                                    <input id="form_admin_senha" name="form_admin_senha" type="password"
                                           class="form-control" placeholder="Senha" maxlength="64" required>
                                    <span toggle="#form_admin_senha"
                                          class="fa fa-fw fa-eye field-icon toggle-password"></span>
                                </div>
                                <!-- FIM CAMPO SENHA -->

                                <!-- INICIO BOTAO ENTRAR -->
                                <div class="form-group">
                                    <button type="submit" class="form-control btn btn-primary submit px-3">Entrar</button>
                                </div>
                                <!-- FIM BOTAO ENTRAR -->

                                <div class="form-group d-md-flex">
                                    <!-- INICIO CHECKBOX -->
                                    <div class="w-50">
                                        <label class="checkbox-wrap checkbox-primary">Salvar Informações<input
                                                type="checkbox" checked>
                                            <span class="checkmark"></span>
                                        </label>
                                    </div>
                                    <!-- FIM CHECKBOX -->
                                    <div class="w-50 text-md-right">
                                        <a href="./form_register.jsp" style="color: #fff">Registrar-se</a>
                                    </div>
                                </div>
                            </form>
                            <!-- INICIO ICONES -->
                            <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
                            <symbol id="exclamation-triangle-fill" fill="currentColor" viewBox="0 0 16 16">
                                <path
                                    d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
                            </symbol>
                            </svg>
                            <!-- FIM ICONES -->
                            
                            <% if(request.getAttribute("status") != null && request.getAttribute("status").equals("erro-logar")) { %>
                            <!-- INICIO ALERTAS -->
                            <div class="alert alert-danger d-flex align-items-center" role="alert">
                                <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:">
                                <use xlink:href="#exclamation-triangle-fill" /></svg>
                                <div>${mensagem}</div>
                            </div>
                            <!-- FIM ALERTAS -->
                            <% } %>
                            
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <script src="./_login_register_js/jquery.min.js"></script>
        <script src="./_login_register_js/popper.js"></script>
        <script src="./_login_register_js/bootstrap.min.js"></script>
        <script src="./_login_register_js/main.js"></script>
    </body>

</html>