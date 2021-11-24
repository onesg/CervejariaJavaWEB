<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Teste - Sugestão</title>
</head>
<body>
    <h1>Página de TESTES!</h1><hr>
    <div>
        <h2>Envie uma sugestão!</h2>
        <form action="SugestaoCTR" method="post">
            <input type="text" name="form_sugestao_nome" id="form_sugestao_nome" placeholder="Nome" required><br>
            <input type="text" name="form_sugestao_email" id="form_sugestao_email" placeholder="E-mail" required><br>
            <input type="text" name="form_sugestao_telefone" id="form_sugestao_telefone" placeholder="Telefone" required><br>
            <textarea name="form_sugestao_texto" id="form_sugestao_texto" cols="30" rows="10" placeholder="Digite sua sugestão"></textarea><br>
            <input type="reset" value="LIMPAR OS CAMPOS">
            <input type="submit" value="ENVIAR">
        </form>
    </div>
    ${status}
</body>
</html>