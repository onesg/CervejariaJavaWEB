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

        <title>Registrar Administrador</title>

    </head>

    <body class="img js-fullheight" style="background-image: url(_login_register_img/bg.jpg);">
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 col-lg-4">
                        <div class="login-wrap p-0">
                            <h3 class="mb-4 text-center">Registrar Administrador</h3>
                            <form action="CadastrarAdminCTR" class="signin-form" method="POST">
                                <!-- INICIO CAMPO LOGIN -->
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Nome de usuário"
                                           name="form_admin_login" id="form_admin_login" maxlength="64" required>
                                </div>
                                <!-- FIM CAMPO LOGIN -->

                                <!-- INICIO CAMPO SENHA -->
                                <div class="form-group">
                                    <input type="password" class="form-control" placeholder="Senha" name="form_admin_senha"
                                           id="form_admin_senha" maxlength="64" required>
                                    <span toggle="#form_admin_senha"
                                          class="fa fa-fw fa-eye field-icon toggle-password"></span>
                                </div>
                                <!-- FIM CAMPO SENHA -->

                                <!-- INICIO CAMPO CONFIRMAR SENHA -->
                                <div class="form-group">
                                    <input type="password" class="form-control" placeholder="Confirme a senha"
                                           name="form_admin_senha_confirm" id="form_admin_senha_confirm" maxlength="64" required>
                                    <span toggle="#form_admin_senha_confirm"
                                          class="fa fa-fw fa-eye field-icon toggle-password"></span>
                                </div>
                                <!-- INICIO CAMPO CONFIRMAR SENHA -->

                                <!-- INICIO BOTAO REGISTRAR -->
                                <div class="form-group">
                                    <button type="submit"
                                            class="form-control btn btn-primary submit px-3">Registrar</button>
                                </div>
                                <!-- FIM BOTAO REGISTRAR -->

                                <div class="form-group d-md-flex">
                                    <div class="w-50">
                                    </div>
                                    <div class="w-50 text-md-right">
                                        <a href="./form_login.jsp" style="color: #fff">Fazer login</a>
                                    </div>
                                </div>
                            </form>
                            <!-- INICIO ICONES -->
                            <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
                            <symbol id="check-circle-fill" fill="currentColor" viewBox="0 0 16 16">
                                <path
                                    d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z" />
                            </symbol>
                            <symbol id="exclamation-triangle-fill" fill="currentColor" viewBox="0 0 16 16">
                                <path
                                    d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
                            </symbol>
                            </svg>
                            <!-- FIM ICONES -->
                            
                            <% if(request.getAttribute("status") != null && request.getAttribute("status").equals("sucesso-cadastrar")){ %>
                            <!-- INICIO ALERTAS -->
                            <div class="alert alert-success d-flex align-items-center" role="alert">
                                <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Success:">
                                <use xlink:href="#check-circle-fill" /></svg>
                                <div>${mensagem}</div>
                            </div>
                            <% } else if(request.getAttribute("status") != null && request.getAttribute("status").equals("erro-cadastrar")) { %>
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
        <script>
            var password = document.getElementById("form_admin_senha")
                    , confirm_password = document.getElementById("form_admin_senha_confirm");

            function validatePassword() {
                if (password.value != confirm_password.value) {
                    confirm_password.setCustomValidity("Senhas diferentes!");
                } else {
                    confirm_password.setCustomValidity('');
                }
            }

            password.onchange = validatePassword;
            confirm_password.onkeyup = validatePassword;

        </script>
        <script src="./_login_register_js/jquery.min.js"></script>
        <script src="./_login_register_js/popper.js"></script>
        <script src="./_login_register_js/bootstrap.min.js"></script>
        <script src="./_login_register_js/main.js"></script>
    </body>

</html>