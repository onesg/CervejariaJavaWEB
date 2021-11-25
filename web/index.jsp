<!--<%//@page contentType="text/html" pageEncoding="UTF-8"//%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pagina Principal</h1>
        <a href="./form_login.jsp">Link para login</a>
        <a href="./dashboard.jsp">Link para o dashboard</a>
    </body>
</html>-->


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <title>Cervejaria Java WEB</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Nothing+You+Could+Do" rel="stylesheet">

        <link rel="stylesheet" href="./_cervejaria_css/open-iconic-bootstrap.min.css">
        <link rel="stylesheet" href="./_cervejaria_css/animate.css">

        <link rel="stylesheet" href="./_cervejaria_css/owl.carousel.min.css">
        <link rel="stylesheet" href="./_cervejaria_css/owl.theme.default.min.css">
        <link rel="stylesheet" href="./_cervejaria_css/magnific-popup.css">

        <link rel="stylesheet" href="./_cervejaria_css/aos.css">

        <link rel="stylesheet" href="./_cervejaria_css/ionicons.min.css">

        <link rel="stylesheet" href="./_cervejaria_css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="./_cervejaria_css/jquery.timepicker.css">


        <link rel="stylesheet" href="./_cervejaria_css/flaticon.css">
        <link rel="stylesheet" href="./_cervejaria_css/icomoon.css">
        <link rel="stylesheet" href="./_cervejaria_css/style.css">
    </head>

    <body>
        <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
            <div class="container">
                <a class="navbar-brand" href="./index.jsp"><!--span
                                class="flaticon-pizza-1 mr-1"></span-->Cervejaria<br><small>Bora beber</small></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav"
                        aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="oi oi-menu"></span> Menu
                </button>
                <div class="collapse navbar-collapse" id="ftco-nav">
                    <ul class="navbar-nav ml-auto">
                        <!--li class="nav-item active"><a href="./index.jsp" class="nav-link">Home</a></li-->
                        <li class="nav-item"><a href="./form_login.jsp" class="nav-link">Fazer Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- END nav -->

        <!-- INICIO CARROSSEL CERVEJAS -->
        <section class="home-slider owl-carousel img" style="background-image: url(./_cervejaria_img/bg_1.jpg);">

            <!-- INICIO SLIDE 1 -->
            <div class="slider-item">
                <div class="overlay"></div>
                <div class="container">
                    <div class="row slider-text align-items-center" data-scrollax-parent="true">

                        <div class="col-md-6 col-sm-12 ftco-animate">
                            <span class="subheading">Experimente</span>
                            <h1 class="mb-4">CERVEJA HEINEKEN</h1>
                            <p class="mb-4 mb-md-5">
                                Heineken é uma cerveja lager Puro Malte, refrescante e de cor amarelo-dourado, produzida com ingredientes 100% naturais: água, malte e lúpulo. Durante o processo de fermentação da Heineken, a exclusiva Levedura A é responsável pelo sabor característico e bem equilibrado, com notas frutadas sutis. A cerveja é fabricada em tanques horizontais para mais sabor e consistência. É por isso que nenhuma outra cerveja tem o gosto de Heineken.
                            </p>
                            <p><a href="#" class="btn btn-primary p-3 px-xl-4 py-xl-3">Experimente</a> <a href="#"
                                                                                                          class="btn btn-white btn-outline-white p-3 px-xl-4 py-xl-3">Ver no Menu</a></p>
                        </div>
                        <div class="col-md-6 ftco-animate">
                            <img src="./_cervejaria_img/bg_1.png" class="img-fluid" alt="">
                        </div>

                    </div>
                </div>
            </div>
            <!-- FIM SLIDE 1 -->

            <!-- INICIO SLIDE 2 -->
            <div class="slider-item">
                <div class="overlay"></div>
                <div class="container">
                    <div class="row slider-text align-items-center" data-scrollax-parent="true">

                        <div class="col-md-6 col-sm-12 order-md-last ftco-animate">
                            <span class="subheading">Eai bora?</span>
                            <h1 class="mb-4">CERVEJA BECKS</h1>
                            <p class="mb-4 mb-md-5">
                                A Swift tem a legítima German Lager Puro Malte, a Becks. Uma cerveja que segue à risca a lei da pureza da cerveja alemã desde 1873. O resultado é uma cerveja de amargor intenso, sabor marcante e excepcional pureza. Ela é provocante, cheia de personalidade e com um sabor característico e único. A cerveja alemã mais vendida no mundo.
                            </p>
                            <p><a href="#" class="btn btn-primary p-3 px-xl-4 py-xl-3">Peça também</a> <a href="#"
                                                                                                          class="btn btn-white btn-outline-white p-3 px-xl-4 py-xl-3">Ver no Menu</a></p>
                        </div>
                        <div class="col-md-6 ftco-animate">
                            <img src="./_cervejaria_img/bg_2.png" class="img-fluid" alt="">
                        </div>

                    </div>
                </div>
            </div>
            <!-- FIM SLIDE 2 -->

            <!-- INICIO SLIDE 3 -->
            <div class="slider-item" style="background-image: url(./_cervejaria_img/bg_3.jpg);">
                <div class="overlay"></div>
                <div class="container">
                    <div class="row slider-text justify-content-center align-items-center" data-scrollax-parent="true">

                        <div class="col-md-7 col-sm-12 text-center ftco-animate">
                            <span class="subheading">Bem-vindos</span>
                            <h1 class="mb-4">Cervejaria</h1>
                            <p class="mb-4 mb-md-5">
                                O Brasil tem a maior biodiversidade do mundo. Então não me vem só com água, malte e lúpulo. Estamos aqui pra te provar que mel, graviola, rapadura, café e até casca de laranja dá cerveja.
                            </p>
                            <p><a href="#" class="btn btn-primary p-3 px-xl-4 py-xl-3">Comprar agora</a></p>
                        </div>

                    </div>
                </div>
            </div>
            <!-- FIM SLIDE 3 -->

        </section>
        <!-- FIM CARROSSEL CERVEJAS -->

        <section class="ftco-intro">
            <div class="container-wrap">
                <div class="wrap d-md-flex">
                    <div class="info">
                        <div class="row no-gutters">
                            <div class="col-md-4 d-flex ftco-animate">
                                <div class="icon"><span class="icon-phone"></span></div>
                                <div class="text">
                                    <h3>000 (123) 456 7890</h3>
                                    <p>Ligue para a gente!</p>
                                </div>
                            </div>
                            <div class="col-md-4 d-flex ftco-animate">
                                <div class="icon"><span class="icon-my_location"></span></div>
                                <div class="text">
                                    <h3>É só pedir que a gente entrega</h3>
                                    <p>Santa Fé, Jales, Fernandópolis e mais.</p>
                                </div>
                            </div>
                            <div class="col-md-4 d-flex ftco-animate">
                                <div class="icon"><span class="icon-clock-o"></span></div>
                                <div class="text">
                                    <h3>Aberto de segunda à sexta</h3>
                                    <p>Das 08:00 às 21:00</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="social d-md-flex pl-md-5 p-4 align-items-center">
                        <ul class="social-icon">
                            <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                            <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                            <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </section>

        <section class="ftco-about d-md-flex">
            <div class="one-half img" style="background-image: url(./_cervejaria_img/about.jpg);"></div>
            <div class="one-half ftco-animate">
                <div class="heading-section ftco-animate ">
                    <h2 class="mb-4">Bem-vindo(a) a Cervejaria Java WEB</h2>
                </div>
                <div>
                    <p>Este site foi desenvolvido utilizando o java para WEB.</p>
                </div>
            </div>
        </section>

        <section class="ftco-section ftco-services">
            <div class="overlay"></div>
            <div class="container">
                <div class="row justify-content-center mb-5 pb-3">
                    <div class="col-md-7 heading-section ftco-animate text-center">
                        <h2 class="mb-4">Nossos serviços</h2>
                        <p>Uma pequena amostra dos nossos serviços prestados.</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 ftco-animate">
                        <div class="media d-block text-center block-6 services">
                            <div class="icon d-flex justify-content-center align-items-center mb-5">
                                <span class="flaticon-diet"></span>
                            </div>
                            <div class="media-body">
                                <h3 class="heading">Comida vegana</h3>
                                <p>Se você não frequenta as cervejarias por não ter muitas opções para comer, seus problemas acabaram, aqui nós oferecemos uma grande quantidade de opções para todos os gostos.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 ftco-animate">
                        <div class="media d-block text-center block-6 services">
                            <div class="icon d-flex justify-content-center align-items-center mb-5">
                                <span class="flaticon-bicycle"></span>
                            </div>
                            <div class="media-body">
                                <h3 class="heading">Delivery rápido</h3>
                                <p>Não quer sair de casa? Peça pela internet e nós entregamos! com prazo máximo de até 30 minutos.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 ftco-animate">
                        <div class="media d-block text-center block-6 services">
                            <div class="icon d-flex justify-content-center align-items-center mb-5"><span
                                    class="flaticon-pizza-1"></span></div>
                            <div class="media-body">
                                <h3 class="heading">Petiscos à vontade</h3>
                                <p>Escolha um dos planos acima de 120 reais, e coma à vontade.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center mb-5 pb-3">
                    <div class="col-md-7 heading-section ftco-animate text-center">
                        <h2 class="mb-4">Cervejar Artesanais</h2>
                        <p>Algumas cervejas especialmentes criadas artesanalmente.</p>
                    </div>
                </div>
                <div class="row d-flex">
                    <div class="col-md-4 d-flex ftco-animate">
                        <div class="blog-entry align-self-stretch">
                            <a href="blog-single.html" class="block-20"
                               style="background-image: url('./_cervejaria_img/image_1.jpg');">
                            </a>
                            <div class="text py-4 d-block">
                                <h3 class="heading mt-2"><a href="#">Kit de Cervejas Marston's Pedigree Amber Ale - Compre 4 e Ganhe Copo Grátis</a></h3>
                                <p>A Marston’s Pedigree é uma bela Amber Ale inglesa. Ela apresenta uma coloração âmbar, aparência brilhante e média formação de espuma. No sensorial traz notas maltadas que lembram casca de pão e biscoito, além de toques frutados e condimentados, proveniente dos lúpulos ingleses. No paladar possui corpo médio e final seco.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 d-flex ftco-animate">
                        <div class="blog-entry align-self-stretch">
                            <a href="blog-single.html" class="block-20"
                               style="background-image: url('./_cervejaria_img/image_2.jpg');">
                            </a>
                            <div class="text py-4 d-block">
                                <h3 class="heading mt-2"><a href="#">Kit de Cervejas Bodebrown - Compre 4 e Ganhe Caldereta Exclusiva</a></h3>
                                <p>A cerveja Lupulol® Galaxy™ Maracujá e Manga é uma India Pale Lager da cervejaria Bodebrown, que faz um mix do conceito tropical brasileiro e dos estudos das clássicas escolas belgas, alemãs e inglesas. Com 5,5% de teor alcóolico, a Lupulol® Galaxy™ Maracujá e Manga é uma cerveja de amargor médio. No sabor, conta com notas de pães brancos, notas frutadas e leve acidez por conta do maracujá. Já o aroma é repleto de notas tropicais, com destaque para as frutas maracujá e manga. A Bodebrown foi eleita 2x a melhor cervejaria do Brasil.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 d-flex ftco-animate">
                        <div class="blog-entry align-self-stretch">
                            <a href="blog-single.html" class="block-20"
                               style="background-image: url('./_cervejaria_img/image_3.jpg');">
                            </a>
                            <div class="text py-4 d-block">
                                <h3 class="heading mt-2"><a href="#">Kit de Cervejas Duvel - Compre 4 e Ganhe Taça Exclusiva</a></h3>
                                <p>Originalmente batizada de Victory Ale, para homenagear e comemorar o fim da primeira guerra mundial, esta cerveja teve seu nome alterado, devido a sua graduação alcoólica. A Duvel é uma cerveja do estilo Belgian Strong Golden Ale, única, com alta carbonatação, ácida e com um dulçor exclusivo. Possui ainda aromas intenso de frutas cristalizadas e a sensação alcoólica desta cerveja é facilmente detectada no paladar.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="ftco-appointment">
            <div class="overlay"></div>
            <div class="container-wrap">
                <div class="row no-gutters d-md-flex align-items-center">
                    <div class="col-md-6 d-flex align-self-stretch">
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3742.5839523137356!2d-50.54389928541519!3d-20.276082454399507!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x949828ccfaa94d1d%3A0x8b69addbada7ff85!2sFaculdade%20de%20Tecnologia%20Prof.%20Jos%C3%A9%20Camargo%20-%20Fatec%20Jales!5e0!3m2!1spt-BR!2sbr!4v1637792170107!5m2!1spt-BR!2sbr" width="800" height="600" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
                    </div>
                    <div class="col-md-6 appointment ftco-animate">
                        <h3 class="mb-3">Mande uma sugestão!</h3>
                        <form action="SugestaoCTR" class="appointment-form">
                            <div class="d-md-flex">
                                <div class="form-group">
                                    <input type="text" class="form-control" name="form_sugestao_nome" id="form_sugestao_nome" placeholder="Nome" maxlength="64" required>
                                </div>
                            </div>
                            <div class="d-me-flex">
                                <div class="form-group">
                                    <input type="email" class="form-control" name="form_sugestao_email" id="form_sugestao_email" placeholder="Endereço de e-mail" maxlength="64" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <textarea name="form_sugestao_texto" id="form_sugestao_texto" cols="30" rows="3" class="form-control" placeholder="Escreva sua sugestão..." maxlength="256" required></textarea>
                            </div>
                            <% if(request.getAttribute("status") != null ) {%>
                            <div class="form-group">
                                <% if(request.getAttribute("status").equals("sucesso-sugestao")) { %>
                                <div class="alert alert-success d-flex align-items-center" role="alert">
                                    <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Success:">
                                    <use xlink:href="#check-circle-fill" /></svg>
                                    <div>${mensagem}</div>
                                </div>
                                <% } else if(request.getAttribute("status").equals("erro-sugestao")){ %>
                                <div class="alert alert-danger d-flex align-items-center" role="alert">
                                    <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:">
                                    <use xlink:href="#exclamation-triangle-fill" /></svg>
                                    <div>${mensagem}</div>
                                </div>
                                <% } %>
                            </div>
                            <% } %>
                            <div class="form-group">
                                <input type="submit" value="Enviar" class="btn btn-primary py-3 px-4">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>

        <footer class="ftco-footer ftco-section img">
            <div class="overlay"></div>
            <div class="container">
                <div class="row mb-5">
                    
                    <div class="col-lg-3 col-md-6 mb-5 mb-md-5">
                        <div class="ftco-footer-widget mb-4">
                            <h2 class="ftco-heading-2">Sobre mim</h2>
                            <p>Sou apenas uma pessoa simples que gosta de programação ;)</p>
                        </div>
                    </div>
                    
                    <div class="col-lg-3 col-md-6 mb-5 mb-md-5">
                        <div class="ftco-footer-widget mb-4">
                            <h2 class="ftco-heading-2">Tem alguma dúvida?</h2>
                            <div class="block-23 mb-3">
                                <ul>
                                    <li><span class="icon icon-map-marker"></span><span class="text">R. Vicente Leporace, 2630 - Jardim Trianon, Jales - SP</span></li>
                                    <li><a href="#"><span class="icon icon-phone"></span><span class="text">+55 (17) 3621-6911</span></a></li>
                                    <li><a href="#"><span class="icon icon-envelope"></span><span
                                                class="text"> fatecjales@fatecjales.edu.br</span></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 text-center">

                        <p>
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            Copyright &copy;
                            <script>document.write(new Date().getFullYear());</script> Feito com <i class="icon-heart" aria-hidden="true"></i> por 
                            <a href="https://github.com/onesg" target="_blank">Gabriel Possar</a>
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        </p>
                    </div>
                </div>
            </div>
        </footer>



        <!-- loader -->
        <div id="ftco-loader" class="show fullscreen">
            <svg class="circular" width="48px" height="48px">
            <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee" />
            <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" />
            </svg>
        </div>


        <script src="./_cervejaria_js/jquery.min.js"></script>
        <script src="./_cervejaria_js/jquery-migrate-3.0.1.min.js"></script>
        <script src="./_cervejaria_js/popper.min.js"></script>
        <script src="./_cervejaria_js/bootstrap.min.js"></script>
        <script src="./_cervejaria_js/jquery.easing.1.3.js"></script>
        <script src="./_cervejaria_js/jquery.waypoints.min.js"></script>
        <script src="./_cervejaria_js/jquery.stellar.min.js"></script>
        <script src="./_cervejaria_js/owl.carousel.min.js"></script>
        <script src="./_cervejaria_js/jquery.magnific-popup.min.js"></script>
        <script src="./_cervejaria_js/aos.js"></script>
        <script src="./_cervejaria_js/jquery.animateNumber.min.js"></script>
        <script src="./_cervejaria_js/bootstrap-datepicker.js"></script>
        <script src="./_cervejaria_js/jquery.timepicker.min.js"></script>
        <script src="./_cervejaria_js/scrollax.min.js"></script>
        <script
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
        <script src="./_cervejaria_js/google-map.js"></script>
        <script src="./_cervejaria_js/main.js"></script>

    </body>

</html>